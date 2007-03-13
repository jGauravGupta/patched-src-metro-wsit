/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License).  You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://glassfish.dev.java.net/public/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at https://glassfish.dev.java.net/public/CDDLv1.0.html.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Copyright 2006 Sun Microsystems Inc. All Rights Reserved
 */

package com.sun.xml.ws.transport.tcp.io;

import com.sun.xml.ws.transport.tcp.pool.LifeCycle;
import com.sun.xml.ws.transport.tcp.util.ByteBufferFactory;
import com.sun.xml.ws.transport.tcp.util.FrameType;
import com.sun.xml.ws.transport.tcp.util.TCPConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey Stashok
 */
public final class FramedMessageOutputStream extends OutputStream implements LifeCycle {
    private static final int HEADER_BUFFER_SIZE = 10;
    private boolean useDirectBuffer;
    
    private ByteBuffer outputBuffer;
    
    private SocketChannel socketChannel;
    private int frameNumber;
    private int frameSize;
    private boolean isFlushLast;
    
    // Fragment header attributes
    private int channelId;
    private int messageId;
    private int contentId;
    private Map<Integer, String> contentProps = new HashMap<Integer, String>(8);
    private int payloadlengthLength;
    
    /** is message framed or direct mode is used */
    private boolean isDirectMode;
    // ByteBuffer for channel_id and message_id, which present in all messages
    private final ByteBuffer headerBuffer;
    // ByteBuffer for content_id, parameters for first frames only
    private final ByteBuffer headerParamsBuffer;
    // ByteBuffer for payload_length
    private ByteBuffer payloadLengthBuffer;
    
    private final ByteBuffer[] frameWithParams = new ByteBuffer[4];
    private final ByteBuffer[] frameWithoutParams = new ByteBuffer[3];
    
    /**
     * could be useful for debug reasons
     */
    private long sentMessageLength;
    
    public FramedMessageOutputStream() {
        this(TCPConstants.DEFAULT_FRAME_SIZE, TCPConstants.DEFAULT_USE_DIRECT_BUFFER);
    }
    
    public FramedMessageOutputStream(int frameSize) {
        this(frameSize, TCPConstants.DEFAULT_USE_DIRECT_BUFFER);
    }
    
    public FramedMessageOutputStream(int frameSize, boolean useDirectBuffer) {
        this.useDirectBuffer = useDirectBuffer;
        headerBuffer = ByteBufferFactory.allocateView(HEADER_BUFFER_SIZE, useDirectBuffer);
        headerParamsBuffer = ByteBufferFactory.allocateView(frameSize, useDirectBuffer);
        setFrameSize(frameSize);
    }
    
    public void setFrameSize(final int frameSize) {
        this.frameSize = frameSize;
        payloadlengthLength = (int) Math.ceil(Math.log(frameSize) / Math.log(2));
        payloadLengthBuffer = ByteBufferFactory.allocateView(payloadlengthLength, useDirectBuffer);
        outputBuffer = ByteBufferFactory.allocateView(frameSize, useDirectBuffer);
        formFrameBufferArrays();
    }
    
    public boolean isDirectMode() {
        return isDirectMode;
    }
    
    public void setDirectMode(final boolean isDirectMode) {
        reset();
        this.isDirectMode = isDirectMode;
    }
    
    public void setSocketChannel(final SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }
    
    public void setChannelId(final int channelId) {
        this.channelId = channelId;
    }
    
    public void setMessageId(final int messageId) {
        this.messageId = messageId;
    }
    
    public void setContentId(final int contentId) {
        this.contentId = contentId;
    }
    
    public void setContentProperty(int key, String value) {
        this.contentProps.put(key, value);
    }
    
    public void addAllContentProperties(Map<Integer, String> properties) {
        this.contentProps.putAll(properties);
    }
    
    public void write(final int data) throws IOException {
        if (!outputBuffer.hasRemaining()) {
            flushFrame();
        }
        
        outputBuffer.put((byte) data);
    }
    
    public void write(final byte[] data, int offset, int size) throws IOException {
        while(size > 0) {
            final int bytesToWrite = Math.min(size, outputBuffer.remaining());
            outputBuffer.put(data, offset, bytesToWrite);
            size -= bytesToWrite;
            offset += bytesToWrite;
            if (!outputBuffer.hasRemaining() && size > 0) {
                flushFrame();
            }
        }
    }
    
    public void flushLast() throws IOException {
        if (!isFlushLast) {
            outputBuffer.flip();
            isFlushLast = true;
            
            do {
                flushBuffer();
            } while(outputBuffer.hasRemaining());
            outputBuffer.clear();
        }
    }
    
    private void flushBuffer() throws IOException {
        ByteBuffer[] frameBuffersArray = frameWithoutParams;
        
        final int payloadLength = outputBuffer.remaining();
        if (!isDirectMode) {
            int readyBytesToSend = 1 + payloadlengthLength + payloadLength;
            if (FrameType.isFrameContainsParams(messageId) && frameNumber == 0) {
                prepareHeaderParams();
                readyBytesToSend += headerParamsBuffer.remaining();
                frameBuffersArray = frameWithParams;
            }
            
            prepareHeader(isFlushLast && readyBytesToSend <= frameSize);
            
            final int sendingPayloadLength = preparePayloadHeader(readyBytesToSend);
            final int payloadLimit = outputBuffer.limit();
            if (sendingPayloadLength < payloadLength) {
                // check to change for outputBuffer.limit(sendingPayloadLength);
                outputBuffer.limit(outputBuffer.limit() - (payloadLength - sendingPayloadLength));
            }
            
            OutputWriter.flushChannel(socketChannel, frameBuffersArray);
            outputBuffer.limit(payloadLimit);
            sentMessageLength += sendingPayloadLength;
            frameNumber++;
        } else {
            OutputWriter.flushChannel(socketChannel, outputBuffer);
        }
    }
    
    private int preparePayloadHeader(final int readyBytesToSend) throws IOException {
        int payloadLength = outputBuffer.remaining();
        if (readyBytesToSend > frameSize) {
            payloadLength -= (readyBytesToSend - frameSize);
        }
        
        payloadLengthBuffer.clear();
        DataInOutUtils.writeInt8(payloadLengthBuffer, payloadLength);
        payloadLengthBuffer.flip();
        return payloadLength;
    }
    
    private void prepareHeader(final boolean isLastFrame) throws IOException {
        headerBuffer.clear();
        int frameMessageId = messageId;
        if (messageId == FrameType.MESSAGE) {
            frameMessageId = FrameType.MESSAGE;
            if (isLastFrame) {
                if (frameNumber != 0) {
                    frameMessageId = FrameType.MESSAGE_END_CHUNK;
                }
            } else if (frameNumber == 0) {
                frameMessageId = FrameType.MESSAGE_START_CHUNK;
            } else {
                frameMessageId = FrameType.MESSAGE_CHUNK;
            }
        }
        
        DataInOutUtils.writeInts4(headerBuffer, channelId, frameMessageId);
        headerBuffer.flip();
    }
    
    private void prepareHeaderParams() throws IOException {
        headerParamsBuffer.clear();
        final int propsCount = contentProps.size();
        
        DataInOutUtils.writeInts4(headerParamsBuffer, contentId, propsCount);
        //@TODO improve string serialization
        for(Map.Entry<Integer, String> entry : contentProps.entrySet()) {
            final String value = entry.getValue();
            byte[] valueBytes = value.getBytes(TCPConstants.UTF8);
            DataInOutUtils.writeInts4(headerParamsBuffer, entry.getKey(), valueBytes.length);
            headerParamsBuffer.put(valueBytes);
        }
        
        headerParamsBuffer.flip();
    }
    
    private void formFrameBufferArrays() {
        frameWithParams[0] = frameWithoutParams[0] = headerBuffer;
        frameWithParams[1] = headerParamsBuffer;
        frameWithParams[2] = frameWithoutParams[1] = payloadLengthBuffer;
        frameWithParams[3] = frameWithoutParams[2] = outputBuffer;
    }
    
    
    public void reset() {
        outputBuffer.clear();
        headerBuffer.clear();
        headerParamsBuffer.clear();
        messageId = -1;
        contentId = -1;
        contentProps.clear();
        frameNumber = 0;
        isFlushLast = false;
        sentMessageLength = 0;
    }
    
    public void activate() {
    }
    
    public void passivate() {
        reset();
        socketChannel = null;
    }
    
    public void close() {
    }
    
    private void flushFrame() throws IOException {
        outputBuffer.flip();
        flushBuffer();
        outputBuffer.compact();
    }
}
