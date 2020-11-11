package AMA.OpenGov.samlProtocol.api.model;

/**
 * Clazz RequestedAttribute.
 * @author paulolancao
 */
public class RequestedAttribute {

	private static final String NameFormat = "urn:oasis:names:tc:SAML:2.0:attrname-format:uri";

	private String name;

	public String getName() {
		return this.name;
	}

	private String nameFormat;

	public String getNameFormat() {
		return this.nameFormat;
	}

	private boolean isRequired;

	public boolean isRequired() {
		return this.isRequired;
	}

	public RequestedAttribute(String name,
			boolean isRequired) {
		this.name = name;
		this.nameFormat = NameFormat;
		this.isRequired = isRequired;
	}
}
