package AMA.OpenGov.samlProtocol.api.model;

public class CCSamlRequestParams extends SamlRequestParams {

	public CCSamlRequestParams(String urlResponseDestination, boolean createExtensions, 
			String faLevel, boolean login) {
		super(urlResponseDestination, createExtensions,  faLevel);

		if (login) {
			this.requestAttr = new RequestedAttribute[] {
					new RequestedAttribute("http://interop.gov.pt/MDC/Cidadao/NIC", true) };
		} else {
			this.requestAttr = new RequestedAttribute[] {
					new RequestedAttribute("http://interop.gov.pt/MDC/Cidadao/NIC", true),
					new RequestedAttribute("http://interop.gov.pt/MDC/Cidadao/NomeApelido", true),
					new RequestedAttribute("http://interop.gov.pt/MDC/Cidadao/NomeProprio", true),
//					new RequestedAttribute("http://interop.gov.pt/MDC/Cidadao/CorreioElectronico", true)
			};
		}
	}

}
