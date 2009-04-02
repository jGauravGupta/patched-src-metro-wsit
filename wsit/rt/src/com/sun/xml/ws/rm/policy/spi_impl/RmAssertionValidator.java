/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2008 Sun Microsystems, Inc. All rights reserved.
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
package com.sun.xml.ws.rm.policy.spi_impl;

import com.sun.xml.ws.rm.policy.assertion.Rm10Assertion;
import com.sun.xml.ws.rm.policy.assertion.Rm11Assertion;
import com.sun.xml.ws.policy.PolicyAssertion;
import com.sun.xml.ws.policy.spi.PolicyAssertionValidator;
import com.sun.xml.ws.policy.spi.PolicyAssertionValidator.Fitness;
import com.sun.xml.ws.rm.RmVersion;

import com.sun.xml.ws.rm.policy.assertion.RmFlowControlAssertion;
import com.sun.xml.ws.rm.policy.assertion.AckRequestIntervalClientAssertion;
import com.sun.xml.ws.rm.policy.assertion.AllowDuplicatesAssertion;
import com.sun.xml.ws.rm.policy.assertion.CloseTimeoutClientAssertion;
import com.sun.xml.ws.rm.policy.assertion.OrderedDeliveryAssertion;
import com.sun.xml.ws.rm.policy.assertion.ResendIntervalClientAssertion;
import com.sun.xml.ws.rm.policy.assertion.InactivityTimeoutAssertion;
import static com.sun.xml.ws.rm.Constants.microsoftVersion;
import static com.sun.xml.ws.rm.Constants.sunVersion;
import static com.sun.xml.ws.rm.Constants.sunClientVersion;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class RmAssertionValidator implements PolicyAssertionValidator {

    private static final ArrayList<QName> serverSideSupportedAssertions = new ArrayList<QName>(5);
    private static final ArrayList<QName> clientSideSupportedAssertions = new ArrayList<QName>(8);

    static {
        serverSideSupportedAssertions.add(Rm10Assertion.NAME);
        serverSideSupportedAssertions.add(Rm11Assertion.NAME);
//        serverSideSupportedAssertions.add(new QName(RMVersion.WSRM11.policyNamespaceUri, "SequenceSTR"));
//        serverSideSupportedAssertions.add(new QName(RMVersion.WSRM11.policyNamespaceUri, "SequenceTransportSecurity"));
        serverSideSupportedAssertions.add(OrderedDeliveryAssertion.NAME);
        serverSideSupportedAssertions.add(AllowDuplicatesAssertion.NAME);
        serverSideSupportedAssertions.add(RmFlowControlAssertion.NAME);
        serverSideSupportedAssertions.add(InactivityTimeoutAssertion.NAME);        

        clientSideSupportedAssertions.add(AckRequestIntervalClientAssertion.NAME);
        clientSideSupportedAssertions.add(ResendIntervalClientAssertion.NAME);
        clientSideSupportedAssertions.add(CloseTimeoutClientAssertion.NAME);
        clientSideSupportedAssertions.addAll(serverSideSupportedAssertions);
    }

    public RmAssertionValidator() {
    }

    public Fitness validateClientSide(PolicyAssertion assertion) {
        return clientSideSupportedAssertions.contains(assertion.getName()) ? Fitness.SUPPORTED : Fitness.UNKNOWN;
    }

    public Fitness validateServerSide(PolicyAssertion assertion) {
        QName assertionName = assertion.getName();
        if (serverSideSupportedAssertions.contains(assertionName)) {
            return Fitness.SUPPORTED;
        } else if (clientSideSupportedAssertions.contains(assertionName)) {
            return Fitness.UNSUPPORTED;
        } else {
            return Fitness.UNKNOWN;
        }
    }

    public String[] declareSupportedDomains() {
        return new String[]{RmVersion.WSRM10.policyNamespaceUri, RmVersion.WSRM11.policyNamespaceUri, microsoftVersion, sunVersion, sunClientVersion};
    }
}