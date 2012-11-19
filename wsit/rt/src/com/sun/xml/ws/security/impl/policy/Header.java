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


import com.sun.xml.ws.policy.AssertionSet;
import com.sun.xml.ws.policy.PolicyAssertion;
import com.sun.xml.ws.policy.PolicyException;
import com.sun.xml.ws.policy.sourcemodel.AssertionData;
import java.util.Collection;
import java.util.Map;
import javax.xml.namespace.QName;
/**
 *
 * @author K.Venugopal@sun.com
 */
public class Header extends PolicyAssertion implements com.sun.xml.ws.security.policy.Header{
    
    String name ="";
    String uri = "";
    int hashCode = 0;
    /**
     * Creates a new instance of Header
     */
    @Deprecated public Header(String localName , String uri) {
        Map<QName,String> attrs = this.getAttributes();
        attrs.put(NAME,localName);
        attrs.put(URI,uri);
    }
    
    public Header(AssertionData name,Collection<PolicyAssertion> nestedAssertions, AssertionSet nestedAlternative)  throws PolicyException {
        super(name,nestedAssertions,nestedAlternative);
        
        
        String tmp = this.getAttributeValue(NAME);
        if(tmp != null){
            this.name = tmp;
        }
        
        this.uri = this.getAttributeValue(URI);
        
        if(uri == null || uri.length() == 0){
            throw new PolicyException("Namespace attribute is required under Header element ");
        }
        
    }
    
    public boolean equals(Object object){
        if(object instanceof Header){
            Header header = (Header)object;
            if(header.getLocalName() != null && header.getLocalName().equals(getLocalName())){
                if(header.getURI().equals(getURI())){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int hashCode(){
        if(hashCode ==0){
            if(uri!=null){
                hashCode =uri.hashCode();
            }
            if(name !=null){
                hashCode =hashCode+name.hashCode();
            }
        }
        return hashCode;
    }
    
    public String getLocalName() {
        return name;
    }
    
    public String getURI() {
        return uri;
    }
}