/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2010 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.08.13 at 02:11:31 PM IST 
//


package com.sun.xml.ws.security.trust.impl.wssx.bindings;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.sun.xml.ws.security.trust.impl.bindings.EndpointReference;
//import org.w3._2005._08.addressing.EndpointReferenceType;
//import com.sun.xml.ws.addressing.v200408.EndpointReferenceImpl;
//import com.sun.xml.ws.addressing.EndpointReferenceImpl;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sun.xml.ws.security.trust.impl.wssx.bindings package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RequestSecurityTokenResponseCollection_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestSecurityTokenResponseCollection");
    private final static QName _Lifetime_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Lifetime");
    private final static QName _KeyType_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "KeyType");
    private final static QName _DelegateTo_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "DelegateTo");
    private final static QName _ValidateTarget_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "ValidateTarget");
    private final static QName _Issuer_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Issuer");
    private final static QName _SignChallenge_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "SignChallenge");
    private final static QName _Forwardable_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Forwardable");
    private final static QName _IssuedTokens_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "IssuedTokens");
    private final static QName _RequestSecurityTokenCollection_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestSecurityTokenCollection");
    private final static QName _SignatureAlgorithm_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "SignatureAlgorithm");
    private final static QName _RequestType_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestType");
    private final static QName _RequestedProofToken_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedProofToken");
    private final static QName _KeyExchangeToken_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "KeyExchangeToken");
    private final static QName _ComputedKey_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "ComputedKey");
    private final static QName _RequestedSecurityToken_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedSecurityToken");
    private final static QName _KeySize_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "KeySize");
    private final static QName _Participants_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Participants");
    private final static QName _Claims_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Claims");
    private final static QName _CancelTarget_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "CancelTarget");
    private final static QName _EncryptionAlgorithm_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "EncryptionAlgorithm");
    private final static QName _CombinedHash_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "CombinedHash");
    private final static QName _Challenge_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Challenge");
    private final static QName _Status_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Status");
    private final static QName _CanonicalizationAlgorithm_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "CanonicalizationAlgorithm");
    private final static QName _RenewTarget_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RenewTarget");
    private final static QName _RequestSecurityToken_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestSecurityToken");
    private final static QName _SecondaryParameters_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "SecondaryParameters");
    private final static QName _KeyWrapAlgorithm_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "KeyWrapAlgorithm");
    private final static QName _ProofEncryption_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "ProofEncryption");
    private final static QName _BinaryExchange_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "BinaryExchange");
    private final static QName _Delegatable_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Delegatable");
    private final static QName _Entropy_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Entropy");
    private final static QName _RequestSecurityTokenResponse_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestSecurityTokenResponse");
    private final static QName _Authenticator_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Authenticator");
    private final static QName _RequestKET_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestKET");
    private final static QName _Renewing_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Renewing");
    private final static QName _BinarySecret_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "BinarySecret");
    private final static QName _RequestedAttachedReference_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedAttachedReference");
    private final static QName _ComputedKeyAlgorithm_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "ComputedKeyAlgorithm");
    private final static QName _SignWith_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "SignWith");
    private final static QName _AuthenticationType_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "AuthenticationType");
    private final static QName _Encryption_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Encryption");
    private final static QName _RequestedUnattachedReference_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedUnattachedReference");
    private final static QName _EncryptWith_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "EncryptWith");
    private final static QName _SignChallengeResponse_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "SignChallengeResponse");
    private final static QName _AllowPostdating_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "AllowPostdating");
    private final static QName _OnBehalfOf_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "OnBehalfOf");
    private final static QName _RequestedTokenCancelled_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedTokenCancelled");
    private final static QName _TokenType_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "TokenType");
    private final static QName _UseKey_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "UseKey");
 // private static final QName _EndpointReference_QNAME = new QName("http://schemas.xmlsoap.org/ws/2004/08/addressing", "EndpointReference");
     private static final QName _EndpointReference_QNAME = new QName("http://www.w3.org/2005/08/addressing", "EndpointReference");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sun.xml.ws.security.trust.impl.bindings
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UseKeyType }
     * 
     */
    public UseKeyType createUseKeyType() {
        return new UseKeyType();
    }

    /**
     * Create an instance of {@link RequestSecurityTokenResponseCollectionType }
     * 
     */
    public RequestSecurityTokenResponseCollectionType createRequestSecurityTokenResponseCollectionType() {
        return new RequestSecurityTokenResponseCollectionType();
    }

    /**
     * Create an instance of {@link ParticipantType }
     * 
     */
    public ParticipantType createParticipantType() {
        return new ParticipantType();
    }

    /**
     * Create an instance of {@link RequestKETType }
     * 
     */
    public RequestKETType createRequestKETType() {
        return new RequestKETType();
    }

    /**
     * Create an instance of {@link DelegateToType }
     * 
     */
    public DelegateToType createDelegateToType() {
        return new DelegateToType();
    }

    /**
     * Create an instance of {@link RequestSecurityTokenCollectionType }
     * 
     */
    public RequestSecurityTokenCollectionType createRequestSecurityTokenCollectionType() {
        return new RequestSecurityTokenCollectionType();
    }

    /**
     * Create an instance of {@link BinarySecretType }
     * 
     */
    public BinarySecretType createBinarySecretType() {
        return new BinarySecretType();
    }

    /**
     * Create an instance of {@link RenewTargetType }
     * 
     */
    public RenewTargetType createRenewTargetType() {
        return new RenewTargetType();
    }

    /**
     * Create an instance of {@link CancelTargetType }
     * 
     */
    public CancelTargetType createCancelTargetType() {
        return new CancelTargetType();
    }

    /**
     * Create an instance of {@link EncryptionType }
     * 
     */
    public EncryptionType createEncryptionType() {
        return new EncryptionType();
    }

    /**
     * Create an instance of {@link ValidateTargetType }
     * 
     */
    public ValidateTargetType createValidateTargetType() {
        return new ValidateTargetType();
    }

    /**
     * Create an instance of {@link ProofEncryptionType }
     * 
     */
    public ProofEncryptionType createProofEncryptionType() {
        return new ProofEncryptionType();
    }

    /**
     * Create an instance of {@link RequestedSecurityTokenType }
     * 
     */
    public RequestedSecurityTokenType createRequestedSecurityTokenType() {
        return new RequestedSecurityTokenType();
    }

    /**
     * Create an instance of {@link RequestedReferenceType }
     * 
     */
    public RequestedReferenceType createRequestedReferenceType() {
        return new RequestedReferenceType();
    }

    /**
     * Create an instance of {@link LifetimeType }
     * 
     */
    public LifetimeType createLifetimeType() {
        return new LifetimeType();
    }

    /**
     * Create an instance of {@link RenewingType }
     * 
     */
    public RenewingType createRenewingType() {
        return new RenewingType();
    }

    /**
     * Create an instance of {@link RequestSecurityTokenType }
     * 
     */
    public RequestSecurityTokenType createRequestSecurityTokenType() {
        return new RequestSecurityTokenType();
    }
    
    /**
     * Create an instance of {@link SecondaryParametersType }
     * 
     */
    public SecondaryParametersType createSecondaryParametersType() {
        return new SecondaryParametersType();
    }

    /**
     * Create an instance of {@link KeyExchangeTokenType }
     * 
     */
    public KeyExchangeTokenType createKeyExchangeTokenType() {
        return new KeyExchangeTokenType();
    }

    /**
     * Create an instance of {@link ParticipantsType }
     * 
     */
    public ParticipantsType createParticipantsType() {
        return new ParticipantsType();
    }

    /**
     * Create an instance of {@link AllowPostdatingType }
     * 
     */
    public AllowPostdatingType createAllowPostdatingType() {
        return new AllowPostdatingType();
    }

    /**
     * Create an instance of {@link ClaimsType }
     * 
     */
    public ClaimsType createClaimsType() {
        return new ClaimsType();
    }

    /**
     * Create an instance of {@link AuthenticatorType }
     * 
     */
    public AuthenticatorType createAuthenticatorType() {
        return new AuthenticatorType();
    }

    /**
     * Create an instance of {@link RequestedTokenCancelledType }
     * 
     */
    public RequestedTokenCancelledType createRequestedTokenCancelledType() {
        return new RequestedTokenCancelledType();
    }

    /**
     * Create an instance of {@link RequestSecurityTokenResponseType }
     * 
     */
    public RequestSecurityTokenResponseType createRequestSecurityTokenResponseType() {
        return new RequestSecurityTokenResponseType();
    }

    /**
     * Create an instance of {@link BinaryExchangeType }
     * 
     */
    public BinaryExchangeType createBinaryExchangeType() {
        return new BinaryExchangeType();
    }

    /**
     * Create an instance of {@link SignChallengeType }
     * 
     */
    public SignChallengeType createSignChallengeType() {
        return new SignChallengeType();
    }

    /**
     * Create an instance of {@link OnBehalfOfType }
     * 
     */
    public OnBehalfOfType createOnBehalfOfType() {
        return new OnBehalfOfType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link RequestedProofTokenType }
     * 
     */
    public RequestedProofTokenType createRequestedProofTokenType() {
        return new RequestedProofTokenType();
    }

    /**
     * Create an instance of {@link EntropyType }
     * 
     */
    public EntropyType createEntropyType() {
        return new EntropyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestSecurityTokenResponseCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestSecurityTokenResponseCollection")
    public JAXBElement<RequestSecurityTokenResponseCollectionType> createRequestSecurityTokenResponseCollection(RequestSecurityTokenResponseCollectionType value) {
        return new JAXBElement<RequestSecurityTokenResponseCollectionType>(_RequestSecurityTokenResponseCollection_QNAME, RequestSecurityTokenResponseCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LifetimeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Lifetime")
    public JAXBElement<LifetimeType> createLifetime(LifetimeType value) {
        return new JAXBElement<LifetimeType>(_Lifetime_QNAME, LifetimeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "KeyType")
    public JAXBElement<String> createKeyType(String value) {
        return new JAXBElement<String>(_KeyType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelegateToType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "DelegateTo")
    public JAXBElement<DelegateToType> createDelegateTo(DelegateToType value) {
        return new JAXBElement<DelegateToType>(_DelegateTo_QNAME, DelegateToType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateTargetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "ValidateTarget")
    public JAXBElement<ValidateTargetType> createValidateTarget(ValidateTargetType value) {
        return new JAXBElement<ValidateTargetType>(_ValidateTarget_QNAME, ValidateTargetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}possible object is EndpointReferenceType{@code >}}
     * 
     */
    @SuppressWarnings("unchecked")
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Issuer")
    public JAXBElement createIssuer(EndpointReference value) {
        return new JAXBElement(_Issuer_QNAME, EndpointReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignChallengeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "SignChallenge")
    public JAXBElement<SignChallengeType> createSignChallenge(SignChallengeType value) {
        return new JAXBElement<SignChallengeType>(_SignChallenge_QNAME, SignChallengeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Forwardable")
    public JAXBElement<Boolean> createForwardable(Boolean value) {
        return new JAXBElement<Boolean>(_Forwardable_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestSecurityTokenResponseCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "IssuedTokens")
    public JAXBElement<RequestSecurityTokenResponseCollectionType> createIssuedTokens(RequestSecurityTokenResponseCollectionType value) {
        return new JAXBElement<RequestSecurityTokenResponseCollectionType>(_IssuedTokens_QNAME, RequestSecurityTokenResponseCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestSecurityTokenCollectionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestSecurityTokenCollection")
    public JAXBElement<RequestSecurityTokenCollectionType> createRequestSecurityTokenCollection(RequestSecurityTokenCollectionType value) {
        return new JAXBElement<RequestSecurityTokenCollectionType>(_RequestSecurityTokenCollection_QNAME, RequestSecurityTokenCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "SignatureAlgorithm")
    public JAXBElement<String> createSignatureAlgorithm(String value) {
        return new JAXBElement<String>(_SignatureAlgorithm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestType")
    public JAXBElement<String> createRequestType(String value) {
        return new JAXBElement<String>(_RequestType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestedProofTokenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestedProofToken")
    public JAXBElement<RequestedProofTokenType> createRequestedProofToken(RequestedProofTokenType value) {
        return new JAXBElement<RequestedProofTokenType>(_RequestedProofToken_QNAME, RequestedProofTokenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyExchangeTokenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "KeyExchangeToken")
    public JAXBElement<KeyExchangeTokenType> createKeyExchangeToken(KeyExchangeTokenType value) {
        return new JAXBElement<KeyExchangeTokenType>(_KeyExchangeToken_QNAME, KeyExchangeTokenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "ComputedKey")
    public JAXBElement<String> createComputedKey(String value) {
        return new JAXBElement<String>(_ComputedKey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestedSecurityTokenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestedSecurityToken")
    public JAXBElement<RequestedSecurityTokenType> createRequestedSecurityToken(RequestedSecurityTokenType value) {
        return new JAXBElement<RequestedSecurityTokenType>(_RequestedSecurityToken_QNAME, RequestedSecurityTokenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "KeySize")
    public JAXBElement<Long> createKeySize(Long value) {
        return new JAXBElement<Long>(_KeySize_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParticipantsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Participants")
    public JAXBElement<ParticipantsType> createParticipants(ParticipantsType value) {
        return new JAXBElement<ParticipantsType>(_Participants_QNAME, ParticipantsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Claims")
    public JAXBElement<ClaimsType> createClaims(ClaimsType value) {
        return new JAXBElement<ClaimsType>(_Claims_QNAME, ClaimsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelTargetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "CancelTarget")
    public JAXBElement<CancelTargetType> createCancelTarget(CancelTargetType value) {
        return new JAXBElement<CancelTargetType>(_CancelTarget_QNAME, CancelTargetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "EncryptionAlgorithm")
    public JAXBElement<String> createEncryptionAlgorithm(String value) {
        return new JAXBElement<String>(_EncryptionAlgorithm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}possible object is byte[]{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "CombinedHash")
    public JAXBElement<byte[]> createCombinedHash(byte[] value) {
        return new JAXBElement<byte[]>(_CombinedHash_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Challenge")
    public JAXBElement<String> createChallenge(String value) {
        return new JAXBElement<String>(_Challenge_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Status")
    public JAXBElement<StatusType> createStatus(StatusType value) {
        return new JAXBElement<StatusType>(_Status_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "CanonicalizationAlgorithm")
    public JAXBElement<String> createCanonicalizationAlgorithm(String value) {
        return new JAXBElement<String>(_CanonicalizationAlgorithm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RenewTargetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RenewTarget")
    public JAXBElement<RenewTargetType> createRenewTarget(RenewTargetType value) {
        return new JAXBElement<RenewTargetType>(_RenewTarget_QNAME, RenewTargetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestSecurityTokenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestSecurityToken")
    public JAXBElement<RequestSecurityTokenType> createRequestSecurityToken(RequestSecurityTokenType value) {
        return new JAXBElement<RequestSecurityTokenType>(_RequestSecurityToken_QNAME, RequestSecurityTokenType.class, null, value);
    }
    
     /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecondaryParametersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "SecondaryParameters")
    public JAXBElement<SecondaryParametersType> createSecondaryParameters(SecondaryParametersType value) {
        return new JAXBElement<SecondaryParametersType>(_SecondaryParameters_QNAME, SecondaryParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "KeyWrapAlgorithm")
    public JAXBElement<String> createKeyWrapAlgorithm(String value) {
        return new JAXBElement<String>(_KeyWrapAlgorithm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProofEncryptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "ProofEncryption")
    public JAXBElement<ProofEncryptionType> createProofEncryption(ProofEncryptionType value) {
        return new JAXBElement<ProofEncryptionType>(_ProofEncryption_QNAME, ProofEncryptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryExchangeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "BinaryExchange")
    public JAXBElement<BinaryExchangeType> createBinaryExchange(BinaryExchangeType value) {
        return new JAXBElement<BinaryExchangeType>(_BinaryExchange_QNAME, BinaryExchangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Delegatable")
    public JAXBElement<Boolean> createDelegatable(Boolean value) {
        return new JAXBElement<Boolean>(_Delegatable_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntropyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Entropy")
    public JAXBElement<EntropyType> createEntropy(EntropyType value) {
        return new JAXBElement<EntropyType>(_Entropy_QNAME, EntropyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestSecurityTokenResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestSecurityTokenResponse")
    public JAXBElement<RequestSecurityTokenResponseType> createRequestSecurityTokenResponse(RequestSecurityTokenResponseType value) {
        return new JAXBElement<RequestSecurityTokenResponseType>(_RequestSecurityTokenResponse_QNAME, RequestSecurityTokenResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticatorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Authenticator")
    public JAXBElement<AuthenticatorType> createAuthenticator(AuthenticatorType value) {
        return new JAXBElement<AuthenticatorType>(_Authenticator_QNAME, AuthenticatorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestKETType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestKET")
    public JAXBElement<RequestKETType> createRequestKET(RequestKETType value) {
        return new JAXBElement<RequestKETType>(_RequestKET_QNAME, RequestKETType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RenewingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Renewing")
    public JAXBElement<RenewingType> createRenewing(RenewingType value) {
        return new JAXBElement<RenewingType>(_Renewing_QNAME, RenewingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinarySecretType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "BinarySecret")
    public JAXBElement<BinarySecretType> createBinarySecret(BinarySecretType value) {
        return new JAXBElement<BinarySecretType>(_BinarySecret_QNAME, BinarySecretType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestedReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestedAttachedReference")
    public JAXBElement<RequestedReferenceType> createRequestedAttachedReference(RequestedReferenceType value) {
        return new JAXBElement<RequestedReferenceType>(_RequestedAttachedReference_QNAME, RequestedReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "ComputedKeyAlgorithm")
    public JAXBElement<String> createComputedKeyAlgorithm(String value) {
        return new JAXBElement<String>(_ComputedKeyAlgorithm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "SignWith")
    public JAXBElement<String> createSignWith(String value) {
        return new JAXBElement<String>(_SignWith_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "AuthenticationType")
    public JAXBElement<String> createAuthenticationType(String value) {
        return new JAXBElement<String>(_AuthenticationType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncryptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Encryption")
    public JAXBElement<EncryptionType> createEncryption(EncryptionType value) {
        return new JAXBElement<EncryptionType>(_Encryption_QNAME, EncryptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestedReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestedUnattachedReference")
    public JAXBElement<RequestedReferenceType> createRequestedUnattachedReference(RequestedReferenceType value) {
        return new JAXBElement<RequestedReferenceType>(_RequestedUnattachedReference_QNAME, RequestedReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "EncryptWith")
    public JAXBElement<String> createEncryptWith(String value) {
        return new JAXBElement<String>(_EncryptWith_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignChallengeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "SignChallengeResponse")
    public JAXBElement<SignChallengeType> createSignChallengeResponse(SignChallengeType value) {
        return new JAXBElement<SignChallengeType>(_SignChallengeResponse_QNAME, SignChallengeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllowPostdatingType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "AllowPostdating")
    public JAXBElement<AllowPostdatingType> createAllowPostdating(AllowPostdatingType value) {
        return new JAXBElement<AllowPostdatingType>(_AllowPostdating_QNAME, AllowPostdatingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OnBehalfOfType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "OnBehalfOf")
    public JAXBElement<OnBehalfOfType> createOnBehalfOf(OnBehalfOfType value) {
        return new JAXBElement<OnBehalfOfType>(_OnBehalfOf_QNAME, OnBehalfOfType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestedTokenCancelledType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestedTokenCancelled")
    public JAXBElement<RequestedTokenCancelledType> createRequestedTokenCancelled(RequestedTokenCancelledType value) {
        return new JAXBElement<RequestedTokenCancelledType>(_RequestedTokenCancelled_QNAME, RequestedTokenCancelledType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "TokenType")
    public JAXBElement<String> createTokenType(String value) {
        return new JAXBElement<String>(_TokenType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UseKeyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "UseKey")
    public JAXBElement<UseKeyType> createUseKey(UseKeyType value) {
        return new JAXBElement<UseKeyType>(_UseKey_QNAME, UseKeyType.class, null, value);
    }

}
