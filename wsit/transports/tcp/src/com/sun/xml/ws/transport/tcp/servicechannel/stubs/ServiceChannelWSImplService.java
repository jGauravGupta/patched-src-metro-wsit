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

package com.sun.xml.ws.transport.tcp.servicechannel.stubs;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.0.1-09/01/2006 06:27 PM(Oleksiy)-M1
 * Generated source version: 2.0
 *
 */
@WebServiceClient(name = "ServiceChannelWSImplService", targetNamespace = "http://servicechannel.tcp.transport.ws.xml.sun.com/", wsdlLocation = "C:\\Projects\\TCPWSTransport/etc/ServiceChannelWSImplService.wsdl")
public class ServiceChannelWSImplService
        extends Service {
    
    private final static URL SERVICECHANNELWSIMPLSERVICE_WSDL_LOCATION;
    
    static {
        SERVICECHANNELWSIMPLSERVICE_WSDL_LOCATION = com.sun.xml.ws.transport.tcp.servicechannel.ServiceChannelWSImpl.class.getResource("ServiceChannelWSImplService.wsdl");
    }
    
    public ServiceChannelWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }
    
    public ServiceChannelWSImplService() {
        super(SERVICECHANNELWSIMPLSERVICE_WSDL_LOCATION, new QName("http://servicechannel.tcp.transport.ws.xml.sun.com/", "ServiceChannelWSImplService"));
    }
    
    /**
     *
     * @return
     *     returns ServiceChannelWSImpl
     */
    @WebEndpoint(name = "ServiceChannelWSImplPort")
    public ServiceChannelWSImpl getServiceChannelWSImplPort() {
        return (ServiceChannelWSImpl)super.getPort(new QName("http://servicechannel.tcp.transport.ws.xml.sun.com/", "ServiceChannelWSImplPort"), ServiceChannelWSImpl.class);
    }
    
}
