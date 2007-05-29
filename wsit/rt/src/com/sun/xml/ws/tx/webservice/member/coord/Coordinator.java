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

package com.sun.xml.ws.tx.webservice.member.coord;

import com.sun.xml.ws.api.addressing.WSEndpointReference;
import com.sun.xml.ws.tx.common.TxLogger;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.EndpointReference;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.1-hudson-795-EA2
 * Generated source version: 2.0
 */
@WebServiceClient(name = "Coordinator", targetNamespace = "http://schemas.xmlsoap.org/ws/2004/10/wscoor", wsdlLocation = "WEB-INF/wsdl/wscoor.wsdl")
public class Coordinator
        extends Service {

    private final static URL COORDINATOR_WSDL_LOCATION;

    static private TxLogger logger = TxLogger.getCoordLogger(Coordinator.class);

    static {
        COORDINATOR_WSDL_LOCATION = Thread.currentThread().getContextClassLoader().getResource("WEB-INF/wsdl/wscoor.wsdl");
        if (logger.isLogging(Level.FINEST)) {
            logger.finest("static initializer:", "WSDL_LOCATION = " + COORDINATOR_WSDL_LOCATION);
        }
    }

    public Coordinator(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Coordinator() {
        super(COORDINATOR_WSDL_LOCATION, new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "Coordinator"));
    }

    /**
     * @return returns ActivationCoordinatorPortType
     */
    @WebEndpoint(name = "ActivationCoordinator")
    public ActivationCoordinatorPortType getActivationCoordinator() {
        return (ActivationCoordinatorPortType) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "ActivationCoordinator"), ActivationCoordinatorPortType.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns ActivationCoordinatorPortType
     */
    @WebEndpoint(name = "ActivationCoordinator")
    public ActivationCoordinatorPortType getActivationCoordinator(WebServiceFeature... features) {
        return (ActivationCoordinatorPortType) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "ActivationCoordinator"), ActivationCoordinatorPortType.class, features);
    }

    /**
     * @return returns ActivationRequesterPortType
     */
    @WebEndpoint(name = "ActivationRequester")
    public ActivationRequesterPortType getActivationRequester() {
        return (ActivationRequesterPortType) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "ActivationRequester"), ActivationRequesterPortType.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns ActivationRequesterPortType
     */
    @WebEndpoint(name = "ActivationRequester")
    public ActivationRequesterPortType getActivationRequester(WebServiceFeature... features) {
        return (ActivationRequesterPortType) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "ActivationRequester"), ActivationRequesterPortType.class, features);
    }

    /**
     * @return returns RegistrationCoordinatorPortType
     */
    @WebEndpoint(name = "RegistrationCoordinator")
    public RegistrationCoordinatorPortType getRegistrationCoordinator() {
        return (RegistrationCoordinatorPortType) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "RegistrationCoordinator"), RegistrationCoordinatorPortType.class);
    }

    /**
     * @param epr      EndpointReference of returned proxy.
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns RegistrationCoordinatorPortType
     */
    @WebEndpoint(name = "RegistrationCoordinator")
    public RegistrationCoordinatorPortType getRegistrationCoordinator(EndpointReference epr, WebServiceFeature... features) {
        RegistrationCoordinatorPortType result =
                (RegistrationCoordinatorPortType) super.getPort(epr, RegistrationCoordinatorPortType.class, features);
        return result;
    }

    /**
     * @return returns RegistrationRequesterPortType
     */
    @WebEndpoint(name = "RegistrationRequester")
    public RegistrationRequesterPortType getRegistrationRequester() {
        return (RegistrationRequesterPortType) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "RegistrationRequester"), RegistrationRequesterPortType.class);
    }

    /**
     * @param epr      EndpointReference of returned proxy.
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns RegistrationRequesterPortType
     */
    @WebEndpoint(name = "RegistrationRequester")
    public RegistrationRequesterPortType getRegistrationRequester(EndpointReference epr, WebServiceFeature... features) {
        RegistrationRequesterPortType result =
                (RegistrationRequesterPortType) super.getPort(epr, RegistrationRequesterPortType.class, features);
        return result;
    }

    /**
     * @return returns ActivationPortTypeRPC
     */
    @WebEndpoint(name = "Activation")
    public ActivationPortTypeRPC getActivation() {
        return (ActivationPortTypeRPC) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "Activation"), ActivationPortTypeRPC.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns ActivationPortTypeRPC
     */
    @WebEndpoint(name = "Activation")
    public ActivationPortTypeRPC getActivation(WebServiceFeature... features) {
        return (ActivationPortTypeRPC) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "Activation"), ActivationPortTypeRPC.class, features);
    }

    /**
     * @return returns RegistrationPortTypeRPC
     */
    @WebEndpoint(name = "Registration")
    public RegistrationPortTypeRPC getRegistration() {
        return (RegistrationPortTypeRPC) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "Registration"), RegistrationPortTypeRPC.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns RegistrationPortTypeRPC
     */
    @WebEndpoint(name = "Registration")
    public RegistrationPortTypeRPC getRegistration(WebServiceFeature... features) {
        return (RegistrationPortTypeRPC) super.getPort(new QName("http://schemas.xmlsoap.org/ws/2004/10/wscoor", "Registration"), RegistrationPortTypeRPC.class, features);
    }

}
