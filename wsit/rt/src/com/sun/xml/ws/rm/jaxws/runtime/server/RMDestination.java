/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

/*
 * RMDestination.java
 *
 * @author Mike Grogan
 * Created on October 15, 2005, 6:24 PM
 */

package com.sun.xml.ws.rm.jaxws.runtime.server;
import com.sun.xml.ws.rm.InvalidSequenceException;
import com.sun.xml.ws.rm.RMException;
import com.sun.xml.ws.rm.Constants;
import com.sun.xml.ws.rm.jaxws.runtime.RMProvider;
import com.sun.xml.ws.rm.jaxws.runtime.SequenceConfig;
import java.net.URI;
import java.util.*;

/**
 * An RMDestination represents a Collection of Inbound RMSequences.
 */
public class RMDestination extends RMProvider<ServerInboundSequence,
                                              ServerOutboundSequence>{
   
    private static RMDestination rmDestination = new RMDestination();
  
    
    public static RMDestination getRMDestination() {
        return rmDestination;
    }
    
    //TODO - make an intelligent choice for  wake-up interval.
    private SequenceReaper reaper = new SequenceReaper(5000, inboundMap);
    
    private RMDestination() {   
    }
    
   
    public void terminateSequence(String id) 
                throws InvalidSequenceException {
        ServerInboundSequence seq = getInboundSequence(id);
        
        if (seq == null) {
            throw new InvalidSequenceException(String.format(Constants.UNKNOWN_SEQUENCE_TEXT,id),id);
        }
        
        ServerOutboundSequence out = 
                (ServerOutboundSequence)seq.getOutboundSequence();
        
        synchronized(this) {
            if (seq != null) {
                inboundMap.remove(id);
            }

            if (inboundMap.isEmpty()) {
                reaper.stop();
            }
        }
        
        if (out != null) {
            String outid = out.getId();
            if (outid != null) {
                outboundMap.remove(outid);
            }
        }
    }
    
    //TODO add endpoint address argument to this method and corresponding
    //member in ServerInboundSequence
    public ServerInboundSequence createSequence(URI acksTo, 
                                          String inboundId,
                                          String outboundId,
                                          SequenceConfig config) throws RMException {
        
        ServerInboundSequence seq = new ServerInboundSequence(acksTo, inboundId, outboundId, config);
        
        synchronized (this) {
            inboundMap.put(seq.getId(), seq);

            if (inboundMap.size() == 1) {
                reaper.start();
            }
        }
        
        ServerOutboundSequence outbound = 
                (ServerOutboundSequence)seq.getOutboundSequence();
        String id = outbound.getId();
        
        if (id != null) {
            outboundMap.put(id ,  outbound);
        }
        
        
        
        return seq;
    }
    
    /**
     * SequenceReaper is a timer with a single task that periodically checks the map
     * of active ServerInboundSequences for expired ones an peremptorily terminates them.
     */
    private class SequenceReaper extends Timer {
        
        private long frequency;
        private Map<String, 
                ServerInboundSequence> map;
        
        private TimerTask timerTask;
        
        public void start() {
            timerTask = new TimerTask() {
                public void run() {
                //go though all the sequences and shut down any that
                //are expired.
                HashSet<String> keysToRemove = new HashSet<String>();
                for (String key : map.keySet()) {
                    
                    ServerInboundSequence sis= map.get(key);
                    synchronized (sis) {
                        if (sis.isExpired()) {
                            System.out.println("Terminating expired sequence " +
                                    sis.getId());
                                    keysToRemove.add(key);
                        }
                   }
                }
                
                for (String str : keysToRemove) {                           
                    try {
                        terminateSequence(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                 }
                   
                }
            };
        
            schedule(timerTask, 
                     new Date(System.currentTimeMillis() + frequency),
                     frequency);
        }
        
        public void stop() {
            timerTask.cancel();
        }
        
        public SequenceReaper(long frequency, Map<String, 
                ServerInboundSequence> map) {
            //make the Timer Thread a daemon.
            super(true);
            this.map = map;
            this.frequency = frequency;
            
        }
    }
}
