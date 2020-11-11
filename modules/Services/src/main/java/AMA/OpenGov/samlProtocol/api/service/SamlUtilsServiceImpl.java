package AMA.OpenGov.samlProtocol.api.service;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.opensaml.Configuration;
import org.opensaml.DefaultBootstrap;
import org.opensaml.common.SAMLVersion;
import org.opensaml.saml2.common.Extensions;
import org.opensaml.saml2.common.impl.ExtensionsBuilder;
import org.opensaml.saml2.core.AuthnRequest;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.LogoutRequest;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.RequestAbstractType;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.StatusCode;
import org.opensaml.saml2.core.StatusMessage;
import org.opensaml.saml2.core.impl.AuthnRequestBuilder;
import org.opensaml.saml2.core.impl.IssuerBuilder;
import org.opensaml.saml2.core.impl.LogoutRequestBuilder;
import org.opensaml.saml2.core.impl.NameIDBuilder;
import org.opensaml.xml.ConfigurationException;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.Marshaller;
import org.opensaml.xml.io.Unmarshaller;
import org.opensaml.xml.io.UnmarshallerFactory;
import org.opensaml.xml.schema.XSAny;
import org.opensaml.xml.schema.impl.XSAnyBuilder;
import org.opensaml.xml.security.SecurityException;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.keyinfo.KeyInfoGenerator;
import org.opensaml.xml.security.x509.BasicX509Credential;
import org.opensaml.xml.signature.KeyInfo;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureConstants;
import org.opensaml.xml.signature.SignatureValidator;
import org.opensaml.xml.signature.Signer;
import org.opensaml.xml.signature.impl.SignatureBuilder;
import org.opensaml.xml.util.AttributeMap;
import org.opensaml.xml.validation.ValidationException;
import org.osgi.service.component.annotations.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import AMA.OpenGov.samlProtocol.api.api.SamlUtilsService;
import AMA.OpenGov.samlProtocol.api.model.RequestedAttribute;
import AMA.OpenGov.samlProtocol.api.model.Saml20Consts;

/**
 * Clazz Saml20Utils.
 * 
 * @author Gfi
 */

@Component(immediate = true, property = {}, service = SamlUtilsService.class)
public class SamlUtilsServiceImpl implements SamlUtilsService {

	private Log _log = LogFactoryUtil.getLog(SamlServiceImpl.class);
	
	private static final AuthnRequestBuilder _AuthnRequestBuilder = new AuthnRequestBuilder();
	private static final LogoutRequestBuilder _LogoutRequestBuilder = new LogoutRequestBuilder();
	private static final IssuerBuilder _IssuerBuilder = new IssuerBuilder();
	private static final ExtensionsBuilder _ExtensionsBuilder = new ExtensionsBuilder();
	private static final XSAnyBuilder _XSAnyBuilder = new XSAnyBuilder();
	private static final SignatureBuilder _SignatureBuilder = new SignatureBuilder();

	public SamlUtilsServiceImpl() {
		try {
			_log.error("Chamada a bootstrap" );
			DefaultBootstrap.bootstrap();
		} catch (ConfigurationException e) {
			e.printStackTrace();
			 _log.error("LOG ERROR:não passou" + e.getMessage());
		}
	}

	/**
	 * Cria um AuthRequest que será utilizado para invocar o FA
	 * 
	 * @param id
	 *            o identificador do pedido
	 * @param requestInstant
	 *            a data associada a este pedido
	 * @param urlLoginDestination
	 *            o URL para onde será enviado o pedido
	 * @param urlResponseDestination
	 *            o URL para onde será enviada a resposta
	 * @param providerName
	 *            o nome de quem fornece o serviço
	 * @param issuer
	 *            o nome de quem invoca o serviço
	 * @param createExtensions
	 *            indica se este pedido terá extensões, sendo criado o no XML
	 * @return
	 */
	@Override
	public AuthnRequest createAuthRequest(String id, DateTime requestInstant, String urlLoginDestination,
			String urlResponseDestination, String providerName, String issuer, boolean createExtensions) {

		AuthnRequest authReq = _AuthnRequestBuilder.buildObject(Saml20Consts.SAML_20_PROTOCOL_NAMESPACE, "AuthnRequest",
				Saml20Consts.SAML_20_PROTOCOL_PREFIX);

		_log.info("==================Set dos campos de autenticação::=======================");
		_log.info("Version::"+SAMLVersion.VERSION_20);
		_log.info("setIssueInstant:"+requestInstant);
		_log.info("urlLoginDestination:"+urlLoginDestination);
		_log.info("setConsent:"+Saml20Consts.SAML_20_CONSENT);
		_log.info("setProtocolBinding:"+Saml20Consts.SAML_20_BINDINGS);
		_log.info("setAssertionConsumerServiceURL:"+urlResponseDestination);
		_log.info("providerName:"+providerName);
		_log.info("issuer:"+issuer);
		_log.info("===================FIM Set dos campos de autenticação::================");
		authReq.setID(id);
		authReq.setVersion(SAMLVersion.VERSION_20);
		authReq.setIssueInstant(requestInstant);
		authReq.setDestination(urlLoginDestination);
		authReq.setConsent(Saml20Consts.SAML_20_CONSENT);
		authReq.setProtocolBinding(Saml20Consts.SAML_20_BINDINGS);
		authReq.setAssertionConsumerServiceURL(urlResponseDestination);
		authReq.setProviderName(providerName);

		authReq.setIssuer(createIssuer(issuer));

		if (createExtensions)
			authReq.setExtensions(createExtensions());

		return authReq;
	}

	/**
	 * Cria um LogoutRequest que será utilizado para invocar o FA
	 * 
	 * @param id
	 *            o identificador do pedido
	 * @param requestInstant
	 *            a data associada a este pedido
	 * @param urlLogoutDestination
	 *            o URL para onde será enviado o pedido
	 * @param urlResponseDestination
	 *            o URL para onde será enviada a resposta
	 * @param providerName
	 *            o nome de quem fornece o serviço
	 * @param issuer
	 *            o nome de quem invoca o serviço
	 * @param createExtensions
	 *            indica se este pedido terá extensões, sendo criado o no XML
	 * @return
	 */
	@Override
	public LogoutRequest createLogoutRequest(String id, DateTime requestInstant, String urlLogoutDestination,
			String urlResponseDestination, String providerName, String issuer) {

		_log.info("createLogoutRequest util service imp");
		LogoutRequest logoutReq = _LogoutRequestBuilder.buildObject(Saml20Consts.SAML_20_PROTOCOL_NAMESPACE,
				"LogoutRequest", Saml20Consts.SAML_20_PROTOCOL_PREFIX);
		_log.info("logoutReq" + logoutReq);

		NameID nameID = new NameIDBuilder().buildObject();
		_log.info("nameID" + nameID);
		logoutReq.setNameID(nameID);

		logoutReq.setID(id);
		logoutReq.setVersion(SAMLVersion.VERSION_20);
		logoutReq.setIssueInstant(requestInstant);
		logoutReq.setDestination(urlLogoutDestination);
		_log.info("urlLogoutDestination" + urlLogoutDestination);

		logoutReq.setConsent(Saml20Consts.SAML_20_LOGOUT_CONSENT);
		logoutReq.setIssuer(createIssuer(issuer));
		_log.info("issuer" + issuer);

		if (Validator.isNotNull(urlResponseDestination)) {
			_log.info("if urlResponseDestination" );

			logoutReq.setExtensions(createExtensions());
			XMLObject logoutUrlObject = createLogoutUrl(urlResponseDestination);
			logoutReq.getExtensions().getUnknownXMLObjects().add(logoutUrlObject);
		}
		_log.info("logoutReq" );

		return logoutReq;
	}

	/**
	 * Create LogoutUrl of document.
	 * 
	 * @param logoutUrlValue
	 * @return
	 */
	private XMLObject createLogoutUrl(String logoutUrlValue) {

		XSAny fAAALevel = _XSAnyBuilder.buildObject("http://autenticacao.cartaodecidadao.pt/logout", "LogoutUrl", "fa");

		fAAALevel.setTextContent(logoutUrlValue);

		return fAAALevel;
	}
	@Override
	public Extensions createExtensions() {

		Extensions extensions = _ExtensionsBuilder.buildObject(Saml20Consts.SAML_20_PROTOCOL_NAMESPACE, "Extensions",
				Saml20Consts.SAML_20_PROTOCOL_PREFIX);

		return extensions;
	}
	@Override
	public XMLObject createRequestedAttributes(RequestedAttribute... requestedAttribute) {

		_log.info("##################################INICIO DEBUG ##########################");
		_log.info("Parametros Passado::"+requestedAttribute);

		
		_log.info("Começa o metodo de csanybuilder");
		XSAny requestedAttributes = _XSAnyBuilder.buildObject(Saml20Consts.SAML_20_REQUESTED_ATTRIBUTES_NAMESPACE,
				"RequestedAttributes", Saml20Consts.SAML_20_REQUESTED_ATTRIBUTES_PREFIX);
		_log.info("depois que faz o joga para o XSANY valor:::"+requestedAttributes);
		
		_log.info("«List«");
		List<XMLObject> requestedAttributesList = requestedAttributes.getUnknownXMLObjects();
		_log.info("requestedAttributesList:::"+requestedAttributesList);
		_log.info("requestedAttributesList:::"+requestedAttributesList.size());
		for (int i = 0; i < requestedAttribute.length; i++) {
			requestedAttributesList.add(createRequestedAttribute(requestedAttribute[i]));
		}
		_log.info("requestedAttributesList"+requestedAttributesList);
		_log.info("requestedAttributes"+requestedAttributes);
		_log.info("##################################FIM DEBUG ##########################");
		return requestedAttributes;
	}
	@Override
	public XMLObject createRequestedAttribute(RequestedAttribute attribute) {

		XSAny requestedAttribute = _XSAnyBuilder.buildObject("http://autenticacao.cartaodecidadao.pt/atributos",
				"RequestedAttribute", "fa");
		
		AttributeMap attributes = requestedAttribute.getUnknownAttributes();
		
		attributes.put(new QName("Name"), attribute.getName());
		attributes.put(new QName("NameFormat"), attribute.getNameFormat());
		attributes.put(new QName("isRequired"), Boolean.toString(attribute.isRequired()));
		_log.info("createRequestedAttributes"+attributes);
		return requestedAttribute;
	}

	@Override
	public Issuer createIssuer(String value) {
		Issuer issuer = _IssuerBuilder.buildObject(Saml20Consts.SAML_20_ASSERTION_NAMESPACE, "Issuer",
				Saml20Consts.SAML_20_ASSERTION_PREFIX);

		issuer.setValue(value);

		return issuer;
	}

	@Override
	public Signature createSignature(Credential credential) {

		_log.info("createSignature, Ini");
		Signature signature = _SignatureBuilder.buildObject();
		signature.setSigningCredential(credential);
		signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA1);
		signature.setCanonicalizationAlgorithm(SignatureConstants.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
		signature.setKeyInfo(createKeyInfo(credential));
		_log.info("createSignature, fim");

		return signature;
	}

	private KeyInfo createKeyInfo(Credential credential) {

		_log.info("createKeyInfo, Ini");
		KeyInfoGenerator kfg = Configuration.getGlobalSecurityConfiguration().getKeyInfoGeneratorManager()
				.getDefaultManager().getFactory(credential).newInstance();
		
		try {
			_log.info("return fim createKeyInfo :"+ kfg.generate(credential));
			return kfg.generate(credential);
		} catch (SecurityException e) {
			throw new RuntimeException("Exception when creating the KeyInfo", e);
		}
		
	}

	@Override
	public String signRequestAndConvertToBase64String(RequestAbstractType request) {

		try {

			_log.info("signRequestAndConvertToBase64String Ini :");
			Marshaller marshaller = Configuration.getMarshallerFactory().getMarshaller(request);
			Element elem = marshaller.marshall(request);

			Document document = elem.getOwnerDocument();
			DOMImplementationLS domImplLS = (DOMImplementationLS) document.getImplementation();
			LSSerializer serializer = domImplLS.createLSSerializer();
			String str = serializer.writeToString(elem);

			Signer.signObject(request.getSignature());

			elem = marshaller.marshall(request);

			document = elem.getOwnerDocument();
			domImplLS = (DOMImplementationLS) document.getImplementation();
			serializer = domImplLS.createLSSerializer();

			str = serializer.writeToString(elem);
			_log.info("Fim signRequestAndConvertToBase64String return :" + base64Encode(str));
			return base64Encode(str);

		} catch (Exception e) {
			throw new RuntimeException("Exception when converting the AuthnRequest to base64 String", e);
		}
	}

	@Override
	public Response convertBase64StringToSAML20Response(String responseBase64) {

		try {

			_log.info("Ini convertBase64StringToSAML20Response :" );
			String responseStr = base64Decode(responseBase64);
			ByteArrayInputStream is = new ByteArrayInputStream(responseStr.getBytes());
			Response response = null;

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setNamespaceAware(true);

			Element element = documentBuilderFactory.newDocumentBuilder().parse(is).getDocumentElement();

			if (Validator.isNotNull(element)) {
				UnmarshallerFactory unmarshallerFactory = Configuration.getUnmarshallerFactory();
				Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(element);
				response = (Response) unmarshaller.unmarshall(element);
			}
			_log.info("Fim convertBase64StringToSAML20Response :" + response );
			return response;

		} catch (Exception e) {
			throw new RuntimeException("Exception when converting the base64 String to a standard SAML 2.0 Response",
					e);
		}
	}

	@Override
	public void ValidateSAML20Response(Response response, Credential cred, int expirationMinutes)
			throws ValidationException {

		final DateTime now = new DateTime();
		final DateTime responseTimeStamp = response.getIssueInstant();

		final int difMinutes = Minutes.minutesBetween(now, responseTimeStamp).getMinutes();

		_log.info("Ini ValidateSAML20Response :" );
		if (expirationMinutes < 0)
			expirationMinutes *= -1;

		if (difMinutes > expirationMinutes || difMinutes < (-1 * expirationMinutes)) {
			throw new ValidationException(
					"The response timestamp is not valid, please syncronize both servers clocks: { ID="
							+ response.getID() + ", InResponseTo=" + response.getInResponseTo() + ", IssueInstant="
							+ response.getIssueInstant() + ", ServerInstant=" + now + ", DifMinutes=" + difMinutes
							+ " }");
		}

		StatusCode statusCode = response.getStatus().getStatusCode();
		StatusMessage statusMessage = response.getStatus().getStatusMessage();
		if (statusCode == null || !StatusCode.SUCCESS_URI.endsWith(statusCode.getValue())) {

			throw new RuntimeException(
					"A resposta SAML indica falha de autenticação: " + "{ StatusCode = " + statusCode != null
							? statusCode.getValue()
							: "N/A" + ", StatusMessage" + statusMessage != null ? statusMessage.getMessage()
									: "N/A" + " }");
		}

		final SignatureValidator validator = new SignatureValidator(cred);

		validator.validate(response.getSignature());
		_log.info("fim ValidateSAML20Response :"+response );
	}

	public String base64Encode(String str) {
		if (str == null)
			return null;

		return Base64.encode(str.getBytes());
	}

	public String base64Decode(String str) throws Base64DecodingException {
		if (str == null)
			return null;

		return new String(Base64.decode(str));
	}

	@Override
	public Credential getCredential() {
		String certPath = PropsUtil.get(Saml20Consts.FACertificatePathAlias);
		if (certPath == null) {
			throw new RuntimeException(
					"Não foi possivel encontrar a configuração com o caminho para o certificado com a chave pública do Fornecedor de Autenticação");
		}

		return createCredential(certPath);
	}

	private Credential createCredential(String certPath) {

		InputStream fileStream = null;
		try {

			_log.info("createCredential" );
			fileStream = new FileInputStream(certPath);

			BasicX509Credential publicCredential = new BasicX509Credential();

			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(fileStream);
			fileStream.close();

			X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(certificate.getPublicKey().getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey key = keyFactory.generatePublic(publicKeySpec);

			if (key == null) {
				throw new RuntimeException("Not possible to export the public key from the given certificate");
			}

			publicCredential.setPublicKey(key);
			_log.info("FIM createCredential::" + publicCredential );
			return publicCredential;

		} catch (FileNotFoundException e) {

			throw new RuntimeException(
					"Não foi possivel encontrar o certificado com a chave pública do Fornecedor de Autenticação ("
							+ certPath == null ? "" : certPath + ")",
					e);

		} catch (Exception e) {
			throw new RuntimeException(
					"Não foi possivel carregar o certificado com a chave pública do Fornecedor de Autenticação", e);
		} finally {
			if (fileStream != null) {
				try {
					fileStream.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
