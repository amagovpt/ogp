package AMA.OpenGov.PortletLogin.portlet;
import java.io.IOException;
import java.util.LinkedList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.util.WebKeys;

import AMA.OpenGov.Services.keys.SessionsKeys;
import AMA.OpenGov.Services.sessions.SessionService;
import AMA.OpenGov.Services.util.UtilService;
import AMA.OpenGov.samlProtocol.api.api.ISamParamsFactory;
import AMA.OpenGov.samlProtocol.api.api.SamlService;
import AMA.OpenGov.samlProtocol.api.api.SamlUtilsService;
//import AMA.OpenGov.samlProtocol.api.model.AuthType;
import AMA.OpenGov.samlProtocol.api.model.SamlBean;
import AMA.OpenGov.samlProtocol.api.model.SamlRequestParams;
import AMA.OpenGov.samlProtocol.api.model.SamlResponseStatus;
import pt.ama.services.customuser.api.CustomUserService;


/**
 * @author raraujo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AMA-OpenGov",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=portletAMALogin",
		"javax.portlet.name=AmaLogin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/createUserAccount.jsp",
//		"javax.portlet.init-param.view-template=/jsp/btnLogin.jsp",
		"javax.portlet.init-param.loginFA=/jsp/loginFA.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.add-process-action-success-action=false" 
	},
	service = Portlet.class
)
public class PortletLoginPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(PortletLoginPortlet.class);
	private String URL = null;
	
	@Reference
	SessionService sessionService;
	
	@Reference
	UtilService utilsService;
	
	@Reference
	ISamParamsFactory samlFactory;

	@Reference
	SamlService samlService;
	
	@Reference
	SamlUtilsService samlUtilsService;
	
	@Reference
	CustomUserService authenticationService;
	
	public void login(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		URL = ParamUtil.getString(actionRequest, "URL");
		_log.info("URL:" +URL);
				
		_log.info("Action Login");
//		AuthType authType = AuthType.valueOf(ParamUtil.getString(actionRequest, "authType"));
		createSamlRequest(actionRequest, actionResponse,  true);
	}
	
	
	private void createSamlRequest(ActionRequest actionRequest, ActionResponse actionResponse, boolean login) {
		
//		PortletConfig portletConfig =  (PortletConfig) actionRequest.getAttribute (JavaConstants.JAVAX_PORTLET_CONFIG);
//
//		SessionMessages.add(actionRequest, ((LiferayPortletConfig)portletConfig).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
//		SessionMessages.add (actionRequest, PortalUtil.getPortletId (actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		try {
			sessionService.registerPortletSession(actionRequest, SessionsKeys.Authentication, null);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			// User can be already logged in
			if (!themeDisplay.isSignedIn()) {
				_log.info("Usuario não logado");
				String idService = ParamUtil.getString(actionRequest, "idServico");

				// Create Action URL to Registration portlet, should be the callback response from FA.
				String actionRegistrationPortlet = "";
				_log.info("Processo de Login ->"+login);
				if (login) {
					_log.info("Processo de Login");
					actionRegistrationPortlet = createActionUrlToRegistrationPortlet(actionRequest,
							"processLoginRequest", idService);
				} else {
					_log.info("Processo de autenticação");
					actionRegistrationPortlet = createActionUrlToRegistrationPortlet(actionRequest,
							"processAuthRequest", idService);
				}
				_log.info("actionRegistrationPortlet:"+actionRegistrationPortlet);	
				
				_log.info("SAML");	
				SamlRequestParams params = samlFactory.createSamlParams( actionRegistrationPortlet, login);
				_log.info("params:"+params);
				
				String encodedXML = samlService.createAuthenticationRequest(params);
				
				_log.info("params:"+ params.get_urlResponseDestination());
				_log.info("params:"+ params.getFaLevel());
				_log.info("params:"+ params.getRegisterAttributes());
				_log.info("Saindo do service, criado a autenticação etapa if abaixo:");
				
				if (encodedXML == null) {
					_log.info("encode xml null errro na autenticação");
					utilsService.setErrorMessage(actionRequest, "auth-cc-error-key");
				} else {
					_log.info("else encode xml");
					_log.info("Set renderparametes ");
//					_log.info("Set base64 encode: " + samlUtilsService.base64Encode(authType.toString()));
					actionResponse.setRenderParameter("SAMLRequestBase64", encodedXML);
//					actionResponse.setRenderParameter("SAMLRelayState",
//							samlUtilsService.base64Encode(authType.toString()));
					actionResponse.setRenderParameter("urlFA", PropsUtil.get("fa.url"));
					actionResponse.setRenderParameter("mvcPath", "/jsp/loginFA.jsp");
					_log.info("Fim else createSamlRequest" );
				}
				
				
			}else{
				_log.info("Usuario Logado ");	
				utilsService.setErrorMessage(actionRequest, "Already Loged In");
//				utilsService.setSuccessMessage(actionRequest, "Você já encontrasse logado com o utilizador:"+login);
			}

		} catch (Exception ex) {
			_log.error("Exception: "+ ex);
			sessionService.removePortletSession(actionRequest, SessionsKeys.Authentication);
			ex.printStackTrace();
		}
		
	}
		
	
	private String createActionUrlToRegistrationPortlet(PortletRequest portletRequest, String actionResponse,
			String serviceId) {

		String actionUrl = null;
		_log.info("createActionUrlToRegistrationPortlet passando ");
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

			LiferayPortletURL registrationActionUrl = PortletURLFactoryUtil.create(portletRequest,
					PortalUtil.getPortletId(portletRequest), themeDisplay.getLayout().getPlid(),
					PortletRequest.ACTION_PHASE);

			_log.info("portletRequest: "+portletRequest);
			_log.info("PortalUtil.getPortletId(portletRequest):" + PortalUtil.getPortletId(portletRequest));
			_log.info("themeDisplay.getLayout().getPlid():" + themeDisplay.getLayout().getPlid());
			_log.info("PortletRequest.ACTION_PHASE:" + PortletRequest.ACTION_PHASE);
			_log.info("createActionUrlToRegistrationPortlet passando ");

			
			
			registrationActionUrl.setWindowState(LiferayWindowState.NORMAL);
			registrationActionUrl.setPortletMode(PortletMode.VIEW);
			registrationActionUrl.setParameter(ActionRequest.ACTION_NAME, actionResponse);

			actionUrl = registrationActionUrl.toString();
			_log.info("actionUrl: "+ actionUrl);
		} catch (Exception ex) {
			_log.error("createActionUrlToRegistrationPortlet Exception" + ex);
		}

		return actionUrl;
	}


	public void processLoginRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
	
		_log.info("Apos chamar a tela de login colocar user e senha ele vem para cá");
		
//		AuthType authType = getAuthType(actionRequest);
//		_log.info("authType:" + authType);

		SamlBean samlBean = getSamlBean(actionRequest);
		_log.info("samlBean:" + samlBean);
		
		_log.info("MEU USUARIO " + getSamlBean(actionRequest).getEmailAddress());
			
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		_log.info("authType para registro do user " + authType);
		User user = getUser(samlBean, themeDisplay.getCompanyId());
		_log.info("Passou get user ");
		_log.info("user:: "+user);
		_log.info(user != null);
		if (user != null) {
			_log.info("IF get user ");
	        String[] credentials = new String[] { String.valueOf(user.getUserId()), user.getPassword(),
	                String.valueOf(user.isPasswordEncrypted()) };
	        
	        for (int i = 0; i < credentials.length; i++) {
				String string = credentials[i];
				
				 _log.info("for::: "+ string);
			}
	        _log.info("Credenciais::: "+ credentials);
	        
	        _log.info("Processo de registerportlet::: ");
	        sessionService.registerPortletSession(actionRequest, "userCredentials", credentials);
	        _log.info("Fim de registerportlet::: ");
	        _log.info("Inicio de registerSession::: ");
	        sessionService.registerSession(PortalUtil.getHttpServletRequest(actionRequest), "userCredentials",
	                credentials);
	        _log.info("fim de registerSession::: ");
	
	        _log.info("inicio de sendRedirect::: ");
	       
	        _log.info("Url:"+URL.contains("/web/guest/suggestions"));
			if(URL.contains("/suggestions") || URL.contains("/consulta" )){
				if(URL.contains("/suggestions")){
					_log.info("if"+themeDisplay.getPortalURL()+"/en/suggestions?modal=open");
					actionResponse.sendRedirect(themeDisplay.getPortalURL()+"/en/suggestions?modal=open");
				}else{
					actionResponse.sendRedirect(themeDisplay.getPortalURL()+"/consulta?modal=open");
				}
			}else{
				 _log.info("Else:"+themeDisplay.getPortalURL()+URL);
				actionResponse.sendRedirect(themeDisplay.getPortalURL()+URL);
				
			}
		_log.info("fim");
	        _log.info(themeDisplay.getPortalURL());
	        _log.info("fim de sendRedirect::: ");
	        _log.info("credenciais::: "+credentials.toString());
	    } else {
	    	
	    	register(actionRequest, actionResponse);
//	    	_log.info("Else get user ");
//	        utilsService.setErrorMessage(actionRequest, "userNotFound");
	    }
	}
	

	private String getAuthType(ActionRequest actionRequest) {
		try {
			_log.info("getAuthType função");
			String relayState = PortalUtil.getUploadPortletRequest(actionRequest).getParameter("RelayState");
			_log.info("relayState: "+relayState);
			return (samlUtilsService.base64Decode(relayState));
		} catch (Exception e) {
			_log.error(e);
			return null;
		}
	}
	
	private SamlBean getSamlBean(ActionRequest actionRequest) {
		
		try {
			_log.info("getSamlBean");
			String samlResponse = PortalUtil.getUploadPortletRequest(actionRequest).getParameter("SAMLResponse");
			_log.info("samlResponse:: "+samlResponse);
			SamlResponseStatus samlResponseStatus = this.samlService.processSamlResponse(samlResponse);
			_log.info("samlResponseStatus.getSamlBean():: "+samlResponseStatus.getSamlBean());
			
			_log.info("Resposta para o bean:: ");
			_log.info("Email:: "+samlResponseStatus.getSamlBean().getEmailAddress());
			_log.info("PrimeiroNome:: "+samlResponseStatus.getSamlBean().getFirstName());
			_log.info("Nome Completo:: "+samlResponseStatus.getSamlBean().getFullName());
			_log.info("FaaLv:: "+samlResponseStatus.getSamlBean().getFaaaLevel());
			_log.info("nacionalidade:: "+samlResponseStatus.getSamlBean().getNationality());
			_log.info("Niff:: "+samlResponseStatus.getSamlBean().getNif());
			return samlResponseStatus.getSamlBean();
		} catch (Exception e) {
			_log.error("Erro ao obter os dados:"+e.getMessage());
			return null;
		}
	}
	
	private LinkedList<Tuple> createAttributeConsentList(SamlBean samlBean) {

		LinkedList<Tuple> list = new LinkedList<Tuple>();

//		switch (authType) {
//		case CC:
			list.add(new Tuple("firstName", samlBean.getFirstName()));
			list.add(new Tuple("lastName", samlBean.getLastName()));
			list.add(new Tuple("nic", samlBean.getNic()));
			list.add(new Tuple("email", samlBean.getEmailAddress()));
////			break;
//		case CMD_NIC:
//			list.add(new Tuple("firstName", samlBean.getFirstName()));
//			list.add(new Tuple("lastName", samlBean.getLastName()));
//			list.add(new Tuple("citizenship", samlBean.getNationality()));
//			list.add(new Tuple("nic", samlBean.getNic()));
//			list.add(new Tuple("email", samlBean.getEmailAddress()));
//			break;
//		default:
//			break;
//		}

		return list;
	}
	
	private User getUser(SamlBean samlBean, long companyId) {

		return authenticationService.getUser(samlBean, companyId);
	}
	
	public void register(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		_log.info("register inicio");
		try {
			URL = ParamUtil.getString(actionRequest, "URL");
			_log.info("URL:" +URL);
//			AuthType authType = AuthType.valueOf(ParamUtil.getString(actionRequest, "authType"));
			_log.info("register inicio");
			createSamlRequest(actionRequest, actionResponse, false);
		} catch (Exception e) {
			_log.error(e.getMessage(),e);
		}
		_log.info("register fim");
	}
	
	public void processAuthRequest(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		_log.info("processAuthRequest inicio");
//		AuthType authType = getAuthType(actionRequest);
		SamlBean samlBean = getSamlBean(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		_log.info("if::");
		
		User user = getUser(samlBean, themeDisplay.getCompanyId());

		_log.info("Utilizador::" + user);
		if (user != null) {
			_log.info("if::");
			
			login(user, actionRequest, actionResponse, samlBean.getFaaaLevel());
		} else {
			_log.info("else::");

			actionRequest.setAttribute("samlBean", samlBean);

//			if (authType.equals(AuthType.SIMPLE) || authType.equals(AuthType.SOCIAL_NETWORK)) {
//				HttpServletRequest request1 = PortalUtil.getHttpServletRequest(actionRequest);
//				request1.getSession().setAttribute("emailAddr", samlBean.getEmailAddress());
//				actionResponse.setRenderParameter("mvcPath", "/jsp/registerUser.jsp");
//			} else {

				LinkedList<Tuple> attrAgreement = createAttributeConsentList(samlBean);

				actionRequest.setAttribute("listAgreement", attrAgreement);

				actionResponse.setRenderParameter("mvcPath", "/jsp/UserAgreement.jsp");
//			}
		}
		_log.info("processAuthRequest fim");
	}
	
	
	public void userAgrrement(ActionRequest actionRequest, ActionResponse actionResponse) {

		_log.info("userAgrrement inicio processo");
		String agreeFullName = actionRequest.getParameter("option1");
		String agreePortalUseData = actionRequest.getParameter("option2");
		String agreeEmail = actionRequest.getParameter("option3");
		String Email = actionRequest.getParameter("Email");
		Boolean snEmailValida = true;
		try {
			HttpServletRequest request1 = PortalUtil.getHttpServletRequest(actionRequest);
			SamlBean samlBean = (SamlBean) request1.getSession().getAttribute("samlBean");
			request1.getSession().removeAttribute("samlBean");

			_log.info("email process: "+ Email);
			_log.info("email process: "+ samlBean.getEmailAddress());
			if(Email != null || samlBean.getEmailAddress().isEmpty()){
				samlBean.setEmailAddress(Email);
				snEmailValida = false;
			}
			_log.info("snEmailValida: "+ snEmailValida);
			if(!snEmailValida){
				if (samlBean != null) {
					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
					User user = authenticationService.createUser(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId(), samlBean.getScreenName(), samlBean, agreeFullName,
							agreePortalUseData, agreeEmail);
					login(user, actionRequest, actionResponse, samlBean.getFaaaLevel());
				}
			}else{
		        utilsService.setErrorMessage(actionRequest, "Email não cadastrado");
	
			}
		} catch (Exception ex) {
			_log.error(ex);
		}
		_log.info("userAgrrement fim do processo");
	}
	
	
	private void login(User user, ActionRequest actionRequest, ActionResponse actionResponse, String faLoginLevel) {

		_log.info("**********************************************Inicio da fun��o login **********************************************");
		_log.info(actionRequest.getPortletSession().getId());

		try {
			String authType = (String) sessionService.getPortletSession(actionRequest, SessionsKeys.Authentication);
			_log.info(authType);

			_log.info("inicio da chamada authenticationService.updateUserAuthType");
			authenticationService.updateUserAuthType(user.getUserId(), authType);
			_log.info("fim da chamada authenticationService.updateUserAuthType");
			
			String[] credentials = new String[] { String.valueOf(user.getUserId()), user.getPassword(),
					String.valueOf(user.isPasswordEncrypted()) };
			_log.info("credentials"+credentials);
			
			_log.info("inicio da chamada sessionService.registerPortletSession");
            sessionService.registerPortletSession(actionRequest, "userCredentials", credentials);
            _log.info("fim da chamada sessionService.registerPortletSession");
            _log.info("inicio da chamada sessionService.registerSession");
            sessionService.registerSession(PortalUtil.getHttpServletRequest(actionRequest), "userCredentials",
                    credentials);
            _log.info("fim da chamada sessionService.registerSession");
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			
			 _log.info("Url:"+URL);
		        _log.info("Url:"+URL.contains("/web/guest/suggestions"));
				if(URL.contains("/suggestions") || URL.contains("/consulta" )){
					if(URL.contains("/suggestions")){
						_log.info("if"+themeDisplay.getPortalURL()+"/en/suggestions?modal=open");
						actionResponse.sendRedirect(themeDisplay.getPortalURL()+"/en/suggestions?modal=open");
					}else{
						actionResponse.sendRedirect(themeDisplay.getPortalURL()+"/consulta?modal=open");
					}
				}else{
					 _log.info("Else:"+themeDisplay.getPortalURL()+URL);
					actionResponse.sendRedirect(themeDisplay.getPortalURL()+URL);
					
				}
			_log.info("fim");
			
			
		} catch (Exception e) {
			sessionService.removePortletSession(actionRequest, SessionsKeys.Authentication);
			e.printStackTrace();
			_log.error(e);
		}
	}
	
}