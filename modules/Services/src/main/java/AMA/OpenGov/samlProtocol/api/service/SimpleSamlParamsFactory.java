package AMA.OpenGov.samlProtocol.api.service;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import AMA.OpenGov.samlProtocol.api.api.ISamParamsFactory;
//import AMA.OpenGov.samlProtocol.api.model.AuthType;
import AMA.OpenGov.samlProtocol.api.model.CCSamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.CMDNicSamlRequestParams;
import AMA.OpenGov.samlProtocol.api.model.RequestedAttribute;
//import AMA.OpenGov.samlProtocol.api.model.CCSamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.CMDNicSamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.CMDPassportSamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.LawerSamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.NotarySamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.RequestedAttribute;
import AMA.OpenGov.samlProtocol.api.model.Saml20Consts;
//import AMA.OpenGov.samlProtocol.api.model.SamlRequest;
import AMA.OpenGov.samlProtocol.api.model.SamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.SimpletSamlRequestParams;
//import AMA.OpenGov.samlProtocol.api.model.SolocitorSamlRequestParams;

@Component(immediate = true, property = {}, service = ISamParamsFactory.class)
public class SimpleSamlParamsFactory implements ISamParamsFactory {

	private static final Log _log = LogFactoryUtil.getLog(SimpleSamlParamsFactory.class);
	
	public SamlRequestParams createSamlParams(String urlResponseDestination, boolean login) {

		_log.info("Inicio classe SimpleSamlParamsFactory");
		
//		_log.info("SimpleSamlParamsFactory TIPO:::" + authType);
		SamlRequestParams samlRequestParams = null;
//		switch (authType) {
//		case CC:
			samlRequestParams = new CCSamlRequestParams(urlResponseDestination, true, 
					Saml20Consts.SAML_20_FA_LEVEL_2, login);
//			break;
//		case LAWYER:
//			samlRequestParams = new LawerSamlRequestParams(urlResponseDestination, true, authType,
//					Saml20Consts.SAML_20_FA_LEVEL_4, login);
//			break;
//		case NOTARY:
//			samlRequestParams = new NotarySamlRequestParams(urlResponseDestination, true, authType,
//					Saml20Consts.SAML_20_FA_LEVEL_4, login);
//			break;
//		case SOLICITATOR:
//			samlRequestParams = new SolocitorSamlRequestParams(urlResponseDestination, true, authType,
//					Saml20Consts.SAML_20_FA_LEVEL_4, login);
//			break;
//		case CMD_PASSPORT:
//			samlRequestParams = new CMDPassportSamlRequestParams(urlResponseDestination, true, authType,
//					Saml20Consts.SAML_20_FA_LEVEL_2, login);
//			break;
//		case CMD_NIC:
//			samlRequestParams = new CMDNicSamlRequestParams(urlResponseDestination, true, authType,
//					Saml20Consts.SAML_20_FA_LEVEL_2, login);
//			break;
//		case SIMPLE:
//			samlRequestParams = new SimpletSamlRequestParams(urlResponseDestination, true, authType,
//					Saml20Consts.SAML_20_FA_LEVEL_1);
//		default:
//			break;
//		}

		_log.info("samlRequestParams parameter: " + samlRequestParams);
		_log.info("samlRequestParams 1: " + samlRequestParams.get_urlResponseDestination());
		_log.info("samlRequestParams 2: " + samlRequestParams.getFaLevel());
		return samlRequestParams;
	}

}
