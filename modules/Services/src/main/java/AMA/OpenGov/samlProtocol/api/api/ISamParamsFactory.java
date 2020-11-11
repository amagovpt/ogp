package AMA.OpenGov.samlProtocol.api.api;

//import AMA.OpenGov.samlProtocol.api.model.AuthType;
import AMA.OpenGov.samlProtocol.api.model.SamlRequestParams;

public interface ISamParamsFactory {
	public SamlRequestParams createSamlParams(String urlResponseDestination, boolean login);

}
