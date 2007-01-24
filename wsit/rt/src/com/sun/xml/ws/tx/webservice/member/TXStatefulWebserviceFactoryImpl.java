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
package com.sun.xml.ws.tx.webservice.member;

import com.sun.istack.NotNull;
import com.sun.xml.ws.api.addressing.AddressingVersion;
import com.sun.xml.ws.developer.StatefulWebServiceManager;
import com.sun.xml.ws.tx.at.ATCoordinator;
import com.sun.xml.ws.tx.at.ATParticipant;
import static com.sun.xml.ws.tx.common.Constants.UNKNOWN_ID;
import com.sun.xml.ws.tx.common.StatefulWebserviceFactory;
import com.sun.xml.ws.tx.common.TxLogger;
import com.sun.xml.ws.tx.coordinator.RegistrationManager;
import com.sun.xml.ws.tx.webservice.member.at.CoordinatorPortTypeImpl;
import com.sun.xml.ws.tx.webservice.member.at.ParticipantPortTypeImpl;
import com.sun.xml.ws.tx.webservice.member.coord.RegistrationCoordinatorPortTypeImpl;
import com.sun.xml.ws.tx.webservice.member.coord.RegistrationRequesterPortTypeImpl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.EndpointReference;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;

/**
 * This class ...
 *
 * @author Ryan.Shoemaker@Sun.COM
 * @version $Revision: 1.5 $
 * @since 1.0
 */
// suppress known deprecation warnings about using short term workaround StatefulWebService.export(Class, String webServiceEndpoint, PortType)
@SuppressWarnings("deprecation")
final public class TXStatefulWebserviceFactoryImpl implements StatefulWebserviceFactory {

    private static final TxLogger logger = TxLogger.getLogger(TXStatefulWebserviceFactoryImpl.class);

    @NotNull
    public StatefulWebServiceManager getManager(@NotNull String serviceName, @NotNull String portName) {
        if (serviceName.equals(ParticipantPortTypeImpl.serviceName)) {
            // ParticipantPortTypeImpl && CoordinatorPortTypeImpl have the same serviceName
            if (portName.equals(ParticipantPortTypeImpl.portName)) {
                return ParticipantPortTypeImpl.manager;
            } else if (portName.equals(CoordinatorPortTypeImpl.portName)) {
                return CoordinatorPortTypeImpl.manager;
            } else {
                throw new IllegalStateException("Unable to resolve port '" + portName + "' for service '" + serviceName + "'");
            }
        } else if (serviceName.equals(RegistrationRequesterPortTypeImpl.serviceName)) {
            if (portName.equals(RegistrationRequesterPortTypeImpl.portName)) {
                return RegistrationRequesterPortTypeImpl.manager;
            } else if (portName.equals(RegistrationCoordinatorPortTypeImpl.portName)) {
                return RegistrationCoordinatorPortTypeImpl.manager;
            } else {
                throw new IllegalStateException("Unable to resolve port '" + portName + "' for service '" + serviceName + "'");
            }
        } else {
            throw new IllegalStateException("Unable to resolve service '" + serviceName + "'");
        }
    }

    @NotNull
    public EndpointReference createService(@NotNull String serviceName, @NotNull String portName,
                                           @NotNull URI address, @NotNull AddressingVersion addressingVersion,
                                           @NotNull String activityId, @NotNull String registrantId) {
        registerFallback();
        if (serviceName.equals(ParticipantPortTypeImpl.serviceName)) {
            // ParticipantPortTypeImpl && CoordinatorPortTypeImpl have the same serviceName
            if (portName.equals(ParticipantPortTypeImpl.portName)) {
                ParticipantPortTypeImpl participant =
                        new ParticipantPortTypeImpl(activityId, registrantId);
                return ParticipantPortTypeImpl.manager.
                        export(addressingVersion.eprType.eprClass, address.toString(), participant);
            } else if (portName.equals(CoordinatorPortTypeImpl.portName)) {
                CoordinatorPortTypeImpl coordinator =
                        new CoordinatorPortTypeImpl(activityId, registrantId);
                return CoordinatorPortTypeImpl.manager.
                        export(addressingVersion.eprType.eprClass, address.toString(), coordinator);
            } else {
                throw new IllegalStateException("Unable to resolve port '" + portName + "' for service '" + serviceName + "'");
            }
        } else if (serviceName.equals(RegistrationRequesterPortTypeImpl.serviceName)) {
            if (portName.equals(RegistrationRequesterPortTypeImpl.portName)) {
                RegistrationRequesterPortTypeImpl registrationRequester =
                        new RegistrationRequesterPortTypeImpl(activityId, registrantId);
                return RegistrationRequesterPortTypeImpl.manager.
                        export(addressingVersion.eprType.eprClass, address.toString(), registrationRequester);
            } else if (portName.equals(RegistrationCoordinatorPortTypeImpl.portName)) {
                RegistrationCoordinatorPortTypeImpl registrationCoordinator =
                        new RegistrationCoordinatorPortTypeImpl(activityId);
                return RegistrationCoordinatorPortTypeImpl.manager.
                        export(addressingVersion.eprType.eprClass, address.toString(), registrationCoordinator);
            } else {
                throw new IllegalStateException("Unable to resolve port '" + portName + "' for service '" + serviceName + "'");
            }
        } else {
            throw new IllegalStateException("Unable to resolve service '" + serviceName + "'");
        }
    }

    static private boolean registeredFallback = false;
    /**
     * Instances that handle request for unknown StatefulWebService instance.
     * This can happen when a request for a StatefulWebService is received after the instance has
     * timed out or was explicitly unexported.
     */
    private void registerFallback() {
        if (!registeredFallback ) {
            registeredFallback = true;

            // force the lazy deployment of our ws so we can access the stateful manager field
            pingStatefulServices();

            ParticipantPortTypeImpl participant =
                    new ParticipantPortTypeImpl(UNKNOWN_ID, UNKNOWN_ID);
            ParticipantPortTypeImpl.manager.setFallbackInstance(participant);
            
            CoordinatorPortTypeImpl coordinator =
                    new CoordinatorPortTypeImpl(UNKNOWN_ID, UNKNOWN_ID);
            CoordinatorPortTypeImpl.manager.setFallbackInstance(coordinator);
            
            RegistrationRequesterPortTypeImpl registrationRequester =
                    new RegistrationRequesterPortTypeImpl(UNKNOWN_ID, UNKNOWN_ID);
            RegistrationRequesterPortTypeImpl.manager.setFallbackInstance(registrationRequester);

            RegistrationCoordinatorPortTypeImpl registrationCoordinator =
                    new RegistrationCoordinatorPortTypeImpl(UNKNOWN_ID);
            RegistrationCoordinatorPortTypeImpl.manager.setFallbackInstance(registrationCoordinator);
        }
    }

    private boolean pingServices = true;

    /**
     * A workaround for WSIT issue 309
     * <p/>
     * The GF performance team does not want our wstx services to load during app server
     * startup, so they are marked to lazy deploy upon the first invocation.  Unfortunately
     * we need to access the stateful webservice manager field in some of these services
     * before the first invocation, so we will ping each of them to force the load to happen.
     * <p/>
     * This will only happen once and it will only happen after we are certain that an app
     * needs these services running.
     */
    private void pingStatefulServices() {
        if (pingServices) {
            pingServices = false;

            if (logger.isLogging(Level.FINEST)) {
                logger.finest("pingStatefulServices", "pinging register service...");
            }
            pingService(RegistrationManager.getLocalAsyncRegistrationURI().toString() + "?wsdl", RegistrationCoordinatorPortTypeImpl.class);
            if (logger.isLogging(Level.FINEST)) {
                logger.finest("pingStatefulServices", "pinging registerResponse service...");
            }
            pingService(RegistrationManager.getLocalRegistrationRequesterURI().toString() + "?wsdl", RegistrationRequesterPortTypeImpl.class);
            if (logger.isLogging(Level.FINEST)) {
                logger.finest("pingStatefulServices", "pinging ATCoordinator service...");
            }
            pingService(ATCoordinator.localCoordinationProtocolServiceURI.toString() + "?wsdl", CoordinatorPortTypeImpl.class);
            if (logger.isLogging(Level.FINEST)) {
                logger.finest("pingStatefulServices", "pinging ATParticipant service...");
            }
            pingService(ATParticipant.LOCAL_PPS_URI.toString() + "?wsdl", ParticipantPortTypeImpl.class);
        }
    }

    /*
     * This method accesses a url specifically to force the app server to completely
     * load our stateful webservices.  We're pinging the services by accessing their
     * wsdl files.
     */
    private void pingService(String urlAddr, Class sws) {
        HttpURLConnection conn = null;
        InputStream response = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(urlAddr);
            conn = (HttpURLConnection) url.openConnection();
            if (conn instanceof HttpsURLConnection) {
                ((HttpsURLConnection) conn).setHostnameVerifier(
                        new HostnameVerifier() {
                            public boolean verify(String string, SSLSession sSLSession) {
                                return true;
                            }
                        });
            }
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded"); // taken from wsimport
            conn.connect();
            response = conn.getInputStream();
            reader = new BufferedReader(
                    new InputStreamReader(response));
            String line = reader.readLine();
            while (line != null) {
//                    logger.finest("pingService", line);
                line = reader.readLine();
            }

            logger.finest("pingService", "RESPONSE CODE: " + conn.getResponseCode());
            if (sws.getDeclaredField("manager").equals(null)) {
                logger.severe("pingService", "Injection failed");
            } else {
                logger.finest("pingService", "Injection succeeded");
            }
        } catch (Exception e) {
            logger.severe("pingService", "Injection failed: " + e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.disconnect();
                if (reader != null) reader.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }
}
