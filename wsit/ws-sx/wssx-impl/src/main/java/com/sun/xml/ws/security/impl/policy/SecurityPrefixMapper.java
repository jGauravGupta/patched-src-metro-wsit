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
package com.sun.xml.ws.security.impl.policy;

import com.sun.xml.ws.policy.PolicyConstants;
import com.sun.xml.ws.policy.spi.PrefixMapper;
import com.sun.xml.ws.security.policy.SecurityPolicyVersion;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabian Ritzmann
 */
public class SecurityPrefixMapper implements PrefixMapper {

    private static final Map<String, String> prefixMap = new HashMap<String, String>();

    static {
        prefixMap.put(SecurityPolicyVersion.SECURITYPOLICY200507.namespaceUri, "sp");
        prefixMap.put(SecurityPolicyVersion.SECURITYPOLICY12NS.namespaceUri, "sp");
        prefixMap.put(Constants.TRUST_NS, "wst");
        prefixMap.put(Constants.UTILITY_NS, PolicyConstants.WSU_NAMESPACE_PREFIX);
        prefixMap.put(Constants.SUN_WSS_SECURITY_CLIENT_POLICY_NS, "csp");
        prefixMap.put(Constants.SUN_WSS_SECURITY_SERVER_POLICY_NS, "ssp");
        prefixMap.put(Constants.SUN_TRUST_CLIENT_SECURITY_POLICY_NS, "ctp");
        prefixMap.put(Constants.SUN_TRUST_SERVER_SECURITY_POLICY_NS, "stp");
        prefixMap.put(Constants.SUN_SECURE_CLIENT_CONVERSATION_POLICY_NS, "cscp");
        prefixMap.put(Constants.SUN_SECURE_SERVER_CONVERSATION_POLICY_NS, "sscp");
    }
        
    public Map<String, String> getPrefixMap() {
        return prefixMap;
    }
    
}