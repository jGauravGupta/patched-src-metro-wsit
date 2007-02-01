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

package com.sun.xml.ws.policy.jaxws;

import com.sun.xml.ws.api.model.wsdl.WSDLModel;
import com.sun.xml.ws.api.server.Container;
import com.sun.xml.ws.policy.Policy;
import com.sun.xml.ws.policy.PolicyConstants;
import com.sun.xml.ws.policy.PolicyException;
import com.sun.xml.ws.policy.PolicyMap;
import com.sun.xml.ws.policy.PolicyMapKey;
import com.sun.xml.ws.policy.privateutil.PolicyUtils;
import com.sun.xml.ws.policy.testutils.PolicyResourceLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;
import junit.framework.TestCase;

/**
 *
 */
public class PolicyConfigParserTest extends TestCase {
    private static final String TEST_FILE_PATH = "test/unit/data/policy/config/wsit.xml";
    private static final String CONFIG_FILE_PATH = "test/unit/data/META-INF";
    private static final String CLASSPATH_CONFIG_FILE_PATH = "test/unit/data";
    private static final String CONFIG_FILE_NAME = "wsit-test.xml";
    private static final String CLIENT_CONFIG_FILE_NAME = "wsit-client.xml";
    
    public PolicyConfigParserTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
    }
    
    protected void tearDown() throws Exception {
    }
    
    public void testParseContainerNullWithoutConfig() throws Exception {
        PolicyMap result = PolicyConfigParser.parse((String) null, null);
        assertNull(result);
    }
    
    public void testParseContainerWithoutContextWithoutConfig() throws Exception {
        Container container = new MockContainer(null);        
        PolicyMap result = PolicyConfigParser.parse((String) null, container);
        assertNull(result);
    }
    
    public void testParseContainerNullWithConfig() throws Exception {        
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CONFIG_FILE_PATH, CONFIG_FILE_NAME, "test", null);
        testLoadedMap(map);
    }

    public void testParseContainerWithoutContext() throws Exception {
        Container container = new MockContainer(null);
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CONFIG_FILE_PATH, CONFIG_FILE_NAME, "test", container);
        testLoadedMap(map);
    }
    
    public void testParseContainerWithContext() throws Exception {
        // TODO Need MockServletContext
    }
    
    public void testWsitXmlNotLoadedContainerNullWithConfig() throws Exception {        
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CONFIG_FILE_PATH, "wsit.xml", "test", null);
        assertNull(map);
    }

    public void testWsitXmlNotLoadedContainerWithoutContext() throws Exception {
        Container container = new MockContainer(null);
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CONFIG_FILE_PATH, "wsit.xml", "test", container);
        assertNull(map);
    }
    
    public void testWsitXmlNotLoadedContainerWithContext() throws Exception {
        // TODO Need MockServletContext
    }
    
    public void testParseClientWithoutContextWithoutConfig() throws Exception {
        PolicyMap result = PolicyConfigParser.parse(PolicyConstants.CLIENT_CONFIGURATION_IDENTIFIER, null);
        assertNull(result);
    }
    
    public void testParseClientMetainfContainerNullWithConfig() throws Exception {        
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CONFIG_FILE_PATH, CLIENT_CONFIG_FILE_NAME, PolicyConstants.CLIENT_CONFIGURATION_IDENTIFIER, null);
        testLoadedMap(map);
    }
    
    public void testParseClientMetainfWithoutContext() throws Exception {
        Container container = new MockContainer(null);
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CONFIG_FILE_PATH, CLIENT_CONFIG_FILE_NAME, PolicyConstants.CLIENT_CONFIGURATION_IDENTIFIER, container);
        testLoadedMap(map);
    }
    
    public void testParseClientClasspathContainerNullWithConfig() throws Exception {        
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CLASSPATH_CONFIG_FILE_PATH, CLIENT_CONFIG_FILE_NAME, PolicyConstants.CLIENT_CONFIGURATION_IDENTIFIER, null);
        testLoadedMap(map);
    }
    
    public void testParseClientClasspathWithoutContext() throws Exception {
        Container container = new MockContainer(null);
        PolicyMap map = prepareTestFileAndLoadPolicyMap(TEST_FILE_PATH, CLASSPATH_CONFIG_FILE_PATH, CLIENT_CONFIG_FILE_NAME, PolicyConstants.CLIENT_CONFIGURATION_IDENTIFIER, container);
        testLoadedMap(map);
    }
    
    /**
     * Test of parse method, of class com.sun.xml.ws.policy.jaxws.PolicyConfigParser.
     */
    public void testParseURLNull() throws Exception {
        PolicyMap result = null;
        
        try {
            result = PolicyConfigParser.parse((URL) null, false);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
        }
        assertNull(result);
    }
    
    public void testParseBufferMex() throws Exception {
        PolicyMap map = parseConfigFile("mex/mex.xml");
        PolicyMapKey key = map.createWsdlEndpointScopeKey(new QName("http://schemas.xmlsoap.org/ws/2004/09/mex", "MetadataExchangeService"), new QName("http://schemas.xmlsoap.org/ws/2004/09/mex", "MetadataExchangePort"));
        Policy policy = map.getEndpointEffectivePolicy(key);
        assertNotNull(policy);
        assertEquals("MEXPolicy", policy.getId());
    }

    
    public void testParseBufferSimple() throws Exception {
        PolicyMap map = parseConfigFile("config/simple.wsdl");
        PolicyMapKey key = map.createWsdlEndpointScopeKey(new QName("http://example.org/", "AddNumbersService"), new QName("http://example.org/", "AddNumbersPort"));
        Policy policy = map.getEndpointEffectivePolicy(key);
        assertNotNull(policy);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy.getId());
    }
    
    public void testParseBufferSingleImport() throws Exception {
        WSDLModel result = null;
        
        PolicyMap map = parseConfigFile("config/single-import.wsdl");
        assertNotNull(map);
        
        PolicyMapKey key1 = map.createWsdlEndpointScopeKey(new QName("http://example.org/", "AddNumbersService"),
                new QName("http://example.org/", "AddNumbersPort"));
        Policy policy1 = map.getEndpointEffectivePolicy(key1);
        assertNotNull(policy1);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy1.getId());
        
        PolicyMapKey key2 = map.createWsdlEndpointScopeKey(new QName("http://example.net/", "AddNumbersService"),
                new QName("http://example.net/", "AddNumbersPort"));
        Policy policy2 = map.getEndpointEffectivePolicy(key2);
        assertNotNull(policy2);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy2.getId());
    }
    
    public void testParseBufferMultiImport() throws Exception {
        PolicyMap map = parseConfigFile("config/import.wsdl");
        
        assertNotNull(map);
        
        PolicyMapKey key1 = map.createWsdlEndpointScopeKey(new QName("http://example.org/", "AddNumbersService"),
                new QName("http://example.org/", "AddNumbersPort"));
        Policy policy1 = map.getEndpointEffectivePolicy(key1);
        assertNotNull(policy1);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy1.getId());
        
        PolicyMapKey key2 = map.createWsdlEndpointScopeKey(new QName("http://example.net/", "AddNumbersService"),
                new QName("http://example.net/", "AddNumbersPort"));
        Policy policy2 = map.getEndpointEffectivePolicy(key2);
        assertNotNull(policy2);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy2.getId());
        
        PolicyMapKey key3 = map.createWsdlEndpointScopeKey(new QName("http://example.com/", "AddNumbersService"),
                new QName("http://example.com/", "AddNumbersPort"));
        Policy policy3 = map.getEndpointEffectivePolicy(key3);
        assertNotNull(policy3);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy3.getId());
        
        PolicyMapKey key4 = map.createWsdlEndpointScopeKey(new QName("http://example.com/import3/", "AddNumbersService"),
                new QName("http://example.com/import3/", "AddNumbersPort"));
        Policy policy4 = map.getEndpointEffectivePolicy(key4);
        assertNotNull(policy4);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy4.getId());
    }
    
    public void testParseBufferCyclicImport() throws Exception {
        PolicyMap map = parseConfigFile("config/cyclic.wsdl");
        PolicyMapKey key = map.createWsdlEndpointScopeKey(new QName("http://example.org/", "AddNumbersService"), new QName("http://example.org/", "AddNumbersPort"));
        Policy policy = map.getEndpointEffectivePolicy(key);
        assertNotNull(policy);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy.getId());
    }
    
    public void testParseBufferExternalReference() throws Exception {
        PolicyMap map = null;
        try {
            map = parseConfigFile("config/service.wsdl");
            assert false; // should throw "failed to find policy" exception
        } catch (WebServiceException wse) {
        }
    }
    
    public void testParseBufferExternalReferenceName() throws Exception {
        PolicyMap map = parseConfigFile("config/service-name.wsdl");
        PolicyMapKey key = map.createWsdlEndpointScopeKey(new QName("http://example.org/AddNumbers/service", "AddNumbersService"), new QName("http://example.org/AddNumbers/service", "AddNumbersPort"));
        Policy policy = map.getEndpointEffectivePolicy(key);
        assertNotNull(policy);
        assertEquals("http://example.org/AddNumbers/porttype#AddNumbersServicePolicy", policy.getName());
    }
        
    private PolicyMap parseConfigFile(String configFile) throws Exception {
        URL url = PolicyUtils.ConfigFile.loadFromClasspath(PolicyResourceLoader.POLICY_UNIT_TEST_RESOURCE_ROOT + configFile);
        return PolicyConfigParser.parse(url, false);
    }

    /**
     * Copy a file
     */
    private static final void copyFile(String sourceName, String destPath, String destName) throws IOException {
        FileChannel source = null;
        FileChannel dest = null;
        try {
            File destDir = new File(destPath);
            destDir.mkdir();
            
            // Create channel on the source
            source = new FileInputStream(sourceName).getChannel();
            
            // Create channel on the destination
            dest = new FileOutputStream(destPath + File.separatorChar + destName).getChannel();
            
            // Copy file contents from source to destination
            dest.transferFrom(source, 0, source.size());
            
        } finally {
            // Close the channels
            if (source != null) {
                try {
                    source.close();
                } catch (IOException e) {
                }
            }
            if (dest != null) {
                dest.close();
            }
        }
    }

    private PolicyMap prepareTestFileAndLoadPolicyMap(String sourceName, String destPath, String destName, String cfgFileId, Container container) throws PolicyException, IOException {
        PolicyMap result;
        try {
            copyFile(sourceName, destPath, destName);
            result = PolicyConfigParser.parse(cfgFileId, container);
            return result;
        } finally {
            File wsitxml = new File(destPath + File.separatorChar + destName);
            wsitxml.delete();
        }
    }
    
    private void testLoadedMap(PolicyMap map) throws PolicyException {
        PolicyMapKey key = PolicyMap.createWsdlEndpointScopeKey(new QName("http://example.org/", "AddNumbersService"), new QName("http://example.org/", "AddNumbersPort"));
        Policy policy = map.getEndpointEffectivePolicy(key);
        assertNotNull(policy);
        assertEquals("MutualCertificate10Sign_IPingService_policy", policy.getId());        
    }
    
    class MockContainer extends Container {
        private final Object spi;
        
        public <T> MockContainer(T spi) {
            this.spi = spi;
        }
        
        public <T> T getSPI(Class<T> spiType) {
            if (spiType.isInstance(this.spi)) {
                return (T) this.spi;
            } else {
                return null;
            }
        }
        
    }
}
