package AMA.OpenGov.samlProtocol.api.model;


public final class SamlResponseStatus {

	private String successStatusCode = "urn:oasis:names:tc:SAML:2.0:status:Success";
	private String statusCode;
	private String statusMessage;
	private String statusDetail;
	private SamlBean samlBean;
	
	public SamlResponseStatus(final String statusCode, final String statusMessage, final String statusDetail, SamlBean samlBean) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.statusDetail = statusDetail;
		this.samlBean = samlBean;
	}

	public String getStatusCode() {
		return statusCode;
	}
	
	public boolean isSuccess()
	{
		return (statusCode != null && statusCode.equals(successStatusCode));
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public String getStatusDetail() {
		return statusDetail;
	}
	
	public SamlBean getSamlBean()
	{
		return samlBean;
	}
}
