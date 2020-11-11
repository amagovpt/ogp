package AMA.OpenGov.samlProtocol.api.api;

import org.apache.xml.security.exceptions.Base64DecodingException;
import org.joda.time.DateTime;
import org.opensaml.saml2.common.Extensions;
import org.opensaml.saml2.core.AuthnRequest;

import AMA.OpenGov.samlProtocol.api.model.RequestedAttribute;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.LogoutRequest;
import org.opensaml.saml2.core.RequestAbstractType;
import org.opensaml.saml2.core.Response;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.validation.ValidationException;

import AMA.OpenGov.samlProtocol.api.model.RequestedAttribute;

public interface SamlUtilsService {
	
	public AuthnRequest createAuthRequest(String id,
			DateTime requestInstant, String urlLoginDestination,
			String urlResponseDestination, String providerName, String issuer,
			boolean createExtensions);
	
	public LogoutRequest createLogoutRequest(String id,
			DateTime requestInstant, String urlLogoutDestination,
			String urlResponseDestination, String providerName, String issuer);
	
	public Extensions createExtensions();
	
	public XMLObject createRequestedAttributes(RequestedAttribute... attributes);
	
	public XMLObject createRequestedAttribute(RequestedAttribute attribute);
	
	public Issuer createIssuer(String value);
	
	public Signature createSignature(Credential credential);
	
	public String signRequestAndConvertToBase64String(RequestAbstractType request);
	
	public Response convertBase64StringToSAML20Response(String responseBase64);
	
	public void ValidateSAML20Response(Response response,
			Credential cred, int expirationMinutes) throws ValidationException;
	
	public Credential getCredential();
	
	public String base64Encode(String str);
	
	public String base64Decode(String str) throws Base64DecodingException;
}
