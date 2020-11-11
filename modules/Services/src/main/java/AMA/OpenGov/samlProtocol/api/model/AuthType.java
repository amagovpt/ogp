package AMA.OpenGov.samlProtocol.api.model;

public enum AuthType
{
	CC,
	NOTARY,
	LAWYER,
	SOLICITATOR,
	SIMPLE,
	CMD_NIC,
	CMD_PASSPORT,
	SOCIAL_NETWORK;
	
	public static AuthType fromValue(String authType) {
		for (AuthType auth : AuthType.values()) {
			if (auth.name().equalsIgnoreCase(authType)) {
				return auth;
			}
		}
		return null;
	}
}
