package AMA.OpenGov.samlProtocol.api.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.xml.namespace.QName;

import org.joda.time.DateTime;
import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.saml2.core.RequestAbstractType;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.schema.XSAny;
import org.opensaml.xml.schema.impl.XSAnyBuilder;
import org.opensaml.xml.security.SecurityHelper;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.util.AttributeMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import AMA.OpenGov.samlProtocol.api.api.SamlService;
import AMA.OpenGov.samlProtocol.api.api.SamlUtilsService;
import AMA.OpenGov.samlProtocol.api.model.AuthTabPresentationPolicies;
//import AMA.OpenGov.samlProtocol.api.model.AuthType;
import AMA.OpenGov.samlProtocol.api.model.Saml20Consts;
import AMA.OpenGov.samlProtocol.api.model.SamlBean;
import AMA.OpenGov.samlProtocol.api.model.SamlRequestParams;
import AMA.OpenGov.samlProtocol.api.model.SamlResponseStatus;

/**
 * Clazz SamlProtocolRequest Builds every request made to FA center.
 * 
 * @author paulolancao
 */

@Component(immediate = true, property = {}, service = SamlService.class)
public class SamlServiceImpl implements SamlService {

	private Log _log = LogFactoryUtil.getLog(SamlServiceImpl.class);
	protected final XSAnyBuilder _XSAnyBuilder = new XSAnyBuilder();

	@Reference
	SamlUtilsService saml20UtilService;

	/**
	 * Method to create integrated authenticated request for FA.
	 * 
	 * @return String
	 */
	public String createAuthenticationRequest(SamlRequestParams samlRequestParams) {

		String encodedXml = null;

		try {
			_log.info("\nStart Creating Authnrequest\n");

			_log.info("_________Solicitação dos dados verificar o que é preciso______");
			_log.info("fa.destination:"+PropsUtil.get("fa.destination"));
			_log.info("get_urlResponseDestination:"+samlRequestParams.get_urlResponseDestination());
			_log.info("fa.providerName:"+PropsUtil.get("fa.providerName"));
			_log.info("fa.issuer:"+PropsUtil.get("fa.issuer"));
			_log.info("Extesions:"+samlRequestParams.is_createExtensions());
			_log.info("_________FIM Solicitação dos dados verificar o que é preciso______");
			
			RequestAbstractType authReq = saml20UtilService.createAuthRequest("_" + UUID.randomUUID().toString(),
										new DateTime(), PropsUtil.get("fa.destination"), samlRequestParams.get_urlResponseDestination(),
										PropsUtil.get("fa.providerName"), PropsUtil.get("fa.issuer"),
										samlRequestParams.is_createExtensions());
			
			_log.info("++++++++++++++++++++++++++++++++++Ainda autenticação++++++++++++++++++++++++++++++++++");
			
			_log.info("passou attrs:: samlRequestParams.getRegisterAttributes():" + saml20UtilService.createRequestedAttributes(samlRequestParams.getRegisterAttributes()));
			XMLObject attrs = saml20UtilService.createRequestedAttributes(samlRequestParams.getRegisterAttributes());
			_log.info("passou attrs:: Valores:" + attrs);
			
			authReq.getExtensions().getUnknownXMLObjects().add(attrs);
			XMLObject faLevelObject = createFAAALevel(samlRequestParams.getFaLevel());
			_log.info("createFAAALevel(samlRequestParams.getFaLevel():" + createFAAALevel(samlRequestParams.getFaLevel()));
			authReq.getExtensions().getUnknownXMLObjects().add(faLevelObject);
			_log.info("createFAAALevel::"+ faLevelObject );
			

//			AuthTabPresentationPolicies authTabPresentationPolicies = createAuthTabPresentationPolicies(
//					samlRequestParams.getAuthType());
//			_log.info("authTabPresentationPolicies::"+authTabPresentationPolicies);

//			if (Validator.isNotNuLL(AUTHTABPRESENTATIONPOLICIES)) {
//				XMLOBJECT FAAUTHTabPresentationObject = createFAAuthTabPresentationPolicies(authTabPresentationPolicies);
//				_log.info("faAuthTabPresentationObject::"+faAuthTabPresentationObject);
//				authReq.getExtensions().getUnknownXMLObjects().add(faAuthTabPresentationObject);
//				_log.info("objetcs::"+authReq.getExtensions().getUnknownXMLObjects().add(faAuthTabPresentationObject));
//			}
			
			_log.info("Debug o getrequest: "  );
			encodedXml = getRequestAsString(authReq);
			_log.info("Debug o getrequest fim: "  );
			_log.info("encodedXml: " +encodedXml );

			_log.info("Mensagem SAML - Auth CC - msgId:" + authReq.getID() + " msg SAML: " + encodedXml);
			_log.info("++++++++++++++++++++++++++++++++++fim metodo autenticação++++++++++++++++++++++++++++++++++");

		} catch (Exception e) {
			_log.error("Exception createAuthenticationRequest"+e.getMessage());
		}

		return encodedXml;
	}

//	private AuthTabPresentationPolicies createAuthTabPresentationPolicies(AuthType authType) {
//		AuthTabPresentationPolicies authTabPresentationPolicies = new AuthTabPresentationPolicies();
//		LinkedList<String> hideAuthTab = new LinkedList<String>();
//
//		switch (authType) {
//		case CC:
//
//			hideAuthTab.add("CMD");
//			hideAuthTab.add("UPP");
//			hideAuthTab.add("RSS");
//
//			authTabPresentationPolicies.setDefaultSelectedAuthTab("CC");
//			authTabPresentationPolicies.setHideAuthTab(hideAuthTab);
//			break;
//		case CMD_NIC:
//		case CMD_PASSPORT:
//			hideAuthTab.add("CC");
//			hideAuthTab.add("UPP");
//			hideAuthTab.add("RSS");
//
//			authTabPresentationPolicies.setDefaultSelectedAuthTab("CMD");
//			authTabPresentationPolicies.setHideAuthTab(hideAuthTab);
//			break;
//		case LAWYER:
//		case NOTARY:
//		case SOLICITATOR:
//			hideAuthTab.add("CMD");
//			hideAuthTab.add("CC");
//			hideAuthTab.add("RSS");
//			authTabPresentationPolicies.setDefaultSelectedAuthTab("CC");
//			authTabPresentationPolicies.setHideAuthTab(hideAuthTab);
//			break;
//		case SIMPLE:
//			hideAuthTab.add("CMD");
//			hideAuthTab.add("CC");
//			hideAuthTab.add("RSS");
//
//			authTabPresentationPolicies.setDefaultSelectedAuthTab("UPP");
//			authTabPresentationPolicies.setHideAuthTab(hideAuthTab);
//			break;
//		case SOCIAL_NETWORK:
//			hideAuthTab.add("CMD");
//			hideAuthTab.add("UPP");
//			hideAuthTab.add("CC");
//
//			authTabPresentationPolicies.setDefaultSelectedAuthTab("RSS");
//			authTabPresentationPolicies.setHideAuthTab(hideAuthTab);
//			break;
//		}
//
//		return authTabPresentationPolicies;
//	}

	private String getRequestAsString(RequestAbstractType request) throws FileNotFoundException {
		
		
		String pfxName = PropsUtil.get("pfx.name");
		String pfxPwd = PropsUtil.get("pfx.pass");
		_log.info( "+++++++++++++++getRequestAsString+++++++++++++++++");
		_log.info( pfxName);
		_log.info( pfxPwd);
		_log.info("ravel debug");
		
		_log.info("Create Signature Inicio");
		request.setSignature(saml20UtilService.createSignature(createRequestCredential(new FileInputStream(pfxName), pfxPwd)));
		_log.info("Create Signature Fim");

		_log.info( "+++++++++++++++fim getRequestAsString+++++++++++++++++");
		return saml20UtilService.signRequestAndConvertToBase64String(request);
	}

	/**
	 * Method to create integrated logout request for FA.
	 * 
	 * @return String
	 */
	public String createLogoutRequest(String urlResponseDestination) {
		String encodedXml = null;

		try {
			_log.info("\nStart Creating Logoutrequest\n");

			RequestAbstractType logoutReq = saml20UtilService.createLogoutRequest("_" + UUID.randomUUID().toString(),
					new DateTime(), PropsUtil.get("fa.destination"), urlResponseDestination,
					PropsUtil.get("fa.providerName"), PropsUtil.get("fa.issuer"));
			
			encodedXml = getRequestAsString(logoutReq);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return encodedXml;
	}

	/**
	 * Create FAAALevel of document.
	 * 
	 * @param fAAALevelValue
	 * @return
	 */
	private XMLObject createFAAALevel(String fAAALevelValue) {

		XSAny fAAALevel = _XSAnyBuilder.buildObject("http://autenticacao.cartaodecidadao.pt/atributos", "FAAALevel",
				"fa");

		fAAALevel.setTextContent(fAAALevelValue);

		return fAAALevel;
	}

	/**
	 * Create FAAuthTabPresentationPolicies.
	 * 
	 * @param authTabPresentationPolicies
	 * @return
	 */
	private XMLObject createFAAuthTabPresentationPolicies(AuthTabPresentationPolicies authTabPresentationPolicies) {

		_log.info("createFAAuthTabPresentationPolicies");
		XSAny fAAuthTabPresentationPolicies = _XSAnyBuilder.buildObject(
				"http://autenticacao.cartaodecidadao.pt/presentationpolicy", "AuthTabPresentationPolicies ", "fa");

		List<XMLObject> unknownXMLObjectsList = fAAuthTabPresentationPolicies.getUnknownXMLObjects();
		List<String> hideAuths = authTabPresentationPolicies.getHideAuthTab();
		for (String hideAuthTab : hideAuths) {
			if (hideAuthTab != null) {
				unknownXMLObjectsList.add(createPresentationAttribute("hideAuthTab", hideAuthTab));
			}
		}
		String defaultSelectedAuthTab = authTabPresentationPolicies.getDefaultSelectedAuthTab();
		if (defaultSelectedAuthTab != null) {
			unknownXMLObjectsList.add(createPresentationAttribute("defaultSelectedAuthTab", defaultSelectedAuthTab));
		}

		_log.info("Return  fAAuthTabPresentationPolicies:::"+fAAuthTabPresentationPolicies);
		return fAAuthTabPresentationPolicies;
	}

	/**
	 * Create RequestedAttributes of document.
	 * 
	 * @param attributes
	 * @return
	 */
	private XMLObject createPresentationAttribute(String attribute, String value) {

		QName qName = new QName("http://autenticacao.cartaodecidadao.pt/presentationpolicy", attribute, "fa");
		XSAny presentationAttribute = _XSAnyBuilder.buildObject(qName);

		AttributeMap attributes = presentationAttribute.getUnknownAttributes();
		attributes.put(new QName("TabId"), value);

		return presentationAttribute;
	}

	/**
	 * Create request Credentials.
	 * 
	 * @param fileStream
	 * @param password
	 * @return
	 */
	private Credential createRequestCredential(InputStream fileStream, String password) {

		_log.info("createRequestCredential");
		try {
			
			KeyStore ks = KeyStore.getInstance("PKCS12");
			ks.load(fileStream, password.toCharArray());

			Enumeration<String> e = ks.aliases();
			while (e.hasMoreElements()) {
				String s = e.nextElement();
				X509Certificate cert = (X509Certificate) ks.getCertificate(s);
				PrivateKey pk = (PrivateKey) ks.getKey(s, password.toCharArray());
				_log.info("createRequestCredential while return::"+SecurityHelper.getSimpleCredential(cert, pk));
				return SecurityHelper.getSimpleCredential(cert, pk);
			}

			throw new RuntimeException("Certificate not found!");

		} catch (Exception e) {
			throw new RuntimeException("Exception when creating the Credendial for the given Certificate", e);
		}
	}

	private final String SAMLRESPONSE_STATUSCODE_VALUE = "success";
	private final String SAMLRESPONSE_FAAAVALUE = "FAAALevel";

	public SamlResponseStatus processSamlResponse(String samlResponseStr) throws Exception {

		SamlResponseStatus samlResponseStatus = null;

		_log.info("processSamlResponse INI::");
		
		Response samlResponse = saml20UtilService.convertBase64StringToSAML20Response(samlResponseStr);
		Credential cred = saml20UtilService.getCredential();

		Integer expirationMinutes = Integer.valueOf(PropsUtil.get(Saml20Consts.ResponseExpirationMinutesAlias));
		if (cred == null)
			throw new Exception(
					"Não foi possivel obter o objeto Credential utilizado para validar a autenticidade da mensagem SAML recebida.");
		if (expirationMinutes == null)
			throw new Exception("Não foi possivel obter o valor do ResponseExpirationMinutes");

		saml20UtilService.ValidateSAML20Response(samlResponse, cred, expirationMinutes);

		if (Validator.isNotNull(samlResponse) && Validator.isNotNull(samlResponse.getStatus())) {
			String statusCode = StringPool.BLANK;
			String statusMessage = StringPool.BLANK;
			String statusDetail = StringPool.BLANK;
			SamlBean samlBean = null;

			if (Validator.isNotNull(samlResponse.getStatus().getStatusCode())) {
				statusCode = samlResponse.getStatus().getStatusCode().getValue();
			}

			if (Validator.isNotNull(samlResponse.getStatus().getStatusMessage())) {
				statusMessage = samlResponse.getStatus().getStatusMessage().getMessage();
			}

			if (Validator.isNotNull(samlResponse.getStatus().getStatusDetail())) {
				statusDetail = samlResponse.getStatus().getStatusDetail().toString();
			}

			if (isSuccess(samlResponse)) {

				String faaaLevel = StringPool.BLANK;
				for (XMLObject object : samlResponse.getExtensions().getUnknownXMLObjects()) {
					if (SAMLRESPONSE_FAAAVALUE.equals(object.getElementQName().getLocalPart())) {
						faaaLevel = object.getDOM().getTextContent().replaceAll("\\s", StringPool.BLANK);
					}
				}

				samlBean = processSamlResponse(samlResponse, faaaLevel);
			}
			_log.info("processSamlResponse create responde::++statuscode" + statusCode + "statusMessage"+statusMessage+
					"statusDetail"+statusDetail+"samlBean"+samlBean);
			samlResponseStatus = new SamlResponseStatus(statusCode, statusMessage, statusDetail, samlBean);
		}
		_log.info("processSamlResponse FIM:: samlResponseStatus" + samlResponseStatus);
		return samlResponseStatus;
	}
	

	private boolean isSuccess(Response samlResponse) {
		return Validator.isNotNull(samlResponse.getStatus().getStatusCode()) && samlResponse.getStatus().getStatusCode()
				.getValue().toLowerCase().contains(SAMLRESPONSE_STATUSCODE_VALUE.toLowerCase());
	}

	private SamlBean processSamlResponse(Response samlResponse, String faaaLevel) {
		SamlBean samlBean = new SamlBean();
		_log.info("##############################processSamlResponse Ini::###########################" );
		_log.info("Parameters>>samlResponse::" + samlResponse);
		_log.info(">faaaLevel::" + faaaLevel);
		for (Assertion assertion : samlResponse.getAssertions()) {
			List<AttributeStatement> attState = assertion.getAttributeStatements();
			for (AttributeStatement attributeStatement : attState) {
				List<Attribute> attrList = attributeStatement.getAttributes();
				processBean(attrList, faaaLevel, samlBean);
			}
		}
		_log.info(">samlBean::" + samlBean.getNic());
		_log.info(">samlBean::" + samlBean.getEmailAddress());
		_log.info("##############################processSamlResponse return FIM::###########################" );
		return samlBean;
	}

	private void processBean(List<Attribute> attrList, String faaaLevel, SamlBean samlBean) {

		_log.info(">processBean INICIO::" );
		if (Validator.isNull(samlBean)) {
			samlBean = new SamlBean();
		}

		String value = null;
		samlBean.setFaaaLevel(faaaLevel);
		for (Attribute attribute : attrList) {
			String attName = attribute.getName();

			switch (attName) {
			case Saml20Consts.SAML_20_FULLNAME_RESPONSE:
			case Saml20Consts.SAML_20_CERT_SOL_FULLNAME_RESPONSE:
			case Saml20Consts.SAML_20_CERT_NOT_FULLNAME_RESPONSE:
			case Saml20Consts.SAML_20_CERT_ADV_FULLNAME_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setFullName(value);
				break;
			case Saml20Consts.SAML_20_NIC_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setNic(value);
				break;
			case Saml20Consts.SAML_20_NIF_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setNif(value);
				break;
			case Saml20Consts.SAML_20_NISS_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setNiss(value);
				break;
			case Saml20Consts.SAML_20_SERIALNUMBER_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setSerialNumber(value);
				break;
			case Saml20Consts.SAML_20_FIRSTNAME_RESPONSE:
			case Saml20Consts.SAML_20_CERT_NOT_FIRSTNAME_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setFirstName(value);
				break;
			case Saml20Consts.SAML_20_LASTNAME_RESPONSE:
			case Saml20Consts.SAML_20_CERT_NOT_LASTNAME_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setLastName(value);
				break;
			case Saml20Consts.SAML_20_BIRTHDAY_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setBirthday(value);
				break;
			case Saml20Consts.SAML_20_CERT_ADV_EMAIL:
			case Saml20Consts.SAML_20_CERT_NOT_EMAIL:
			case Saml20Consts.SAML_20_CERT_SOL_EMAIL:
			case Saml20Consts.SAML_20_EMAIL_ADDRESS_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				if (Validator.isNotNull(value)) {
					value = value.trim();
				}
				samlBean.setEmailAddress(value);
				break;
			case Saml20Consts.SAML_20_CERT_SOL_NCS_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setNcs(value);
				break;
			case Saml20Consts.SAML_20_CERT_NOT_MNON_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setNon(value);
				break;
			case Saml20Consts.SAML_20_CERT_ADV_NOA_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setNoa(value);
				break;
			case Saml20Consts.SAML_20_PASSPORTID_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setPassport(value);
				break;
			case Saml20Consts.SAML_20_NATIONALITY_RESPONSE:
				value = attribute.getDOM().getTextContent().trim();
				samlBean.setNationality(value);
				break;
			}
		}
		_log.info(">processBean FIM::" );

	}

}
