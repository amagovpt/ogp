package AMA.OpenGov.samlProtocol.api.model;

import AMA.OpenGov.samlProtocol.api.model.RequestedAttribute;

/**
 * Wrapper Clazz SamlRequestParams.
 * @author paulolancao
 */
public abstract class SamlRequestParams {
	
	private final String _urlResponseDestination;
	private final boolean _createExtensions;
//	private final AuthType _authType;
	private final String _faLevel;
	protected RequestedAttribute[] requestAttr = null;
	
	
	
	public SamlRequestParams(String urlResponseDestination, boolean createExtensions, String faLevel) {
		this._urlResponseDestination = urlResponseDestination;
		this._createExtensions = createExtensions;
//		this._authType = authType;
		this._faLevel = faLevel;
	}

	public String get_urlResponseDestination() {
		return _urlResponseDestination;
	}

	public boolean is_createExtensions() {
		return _createExtensions;
	}

	public RequestedAttribute[] getRegisterAttributes() {
		return requestAttr;
	}
	
//	public AuthType getAuthType()
//	{
//		return this._authType;
//	}
	
	public String getFaLevel()
	{
		return this._faLevel;
	}
}
