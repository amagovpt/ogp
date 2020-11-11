package AMA.OpenGov.samlProtocol.api.api;

import AMA.OpenGov.samlProtocol.api.model.SamlRequestParams;
import AMA.OpenGov.samlProtocol.api.model.SamlResponseStatus;

/**
 * Clazz RequestedAttribute.
 * 
 * @author Gfi
 */
public interface SamlService {
	
	String createAuthenticationRequest(SamlRequestParams samlRequestParams);

	String createLogoutRequest(String urlResponseDestination);
	
	SamlResponseStatus processSamlResponse(String samlResponseStr) throws Exception;
}
