package AMA.OpenGov.PortletLogin.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import AMA.OpenGov.samlProtocol.api.api.SamlService;
import AMA.OpenGov.Services.keys.SessionsKeys;
import AMA.OpenGov.Services.sessions.SessionService;

@Component(
		immediate = true, 
		property = { 
				"javax.portlet.name=AmaLogin",
//				"javax.portlet.name=" + PortletLoginPortletKeys.portletAMALogin,
				"mvc.command.name=viewLogout"  }, 
		service = MVCRenderCommand.class)
public class LogoutRenderCommand implements MVCRenderCommand {
	
	private static Log _log = LogFactoryUtil.getLog(LogoutRenderCommand.class);

	@Reference
	private SamlService samlProtocolRequest;

	@Reference
	private SessionService sessionService;

	@Reference
	UserLocalService userLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		_log.info("Passando no render logout command render login");
		try {
			User user = PortalUtil.getUser(renderRequest);
			_log.info("Passou no user:" + user.getFirstName());
			if (user != null) {
				_log.info("if logout request");
				_log.info(SessionsKeys.Authentication);

					sessionService.removePortletSession(renderRequest, SessionsKeys.Authentication);
					_log.info("remove portlet session");
					ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

					boolean isHttps = Boolean.parseBoolean(PropsUtil.get("pt.ama.portal.https"));
					_log.info("e http:" + isHttps);
					String portalURL = PortalUtil.getPortalURL(themeDisplay.getCompany().getVirtualHostname(),
							PortalUtil.getPortalServerPort(isHttps), isHttps);
					_log.info(" portalURL:" + portalURL);

					String encodedXML = samlProtocolRequest.createLogoutRequest(portalURL + "/c/portal/logout");
					_log.info("enconde xml");

					if (encodedXML != null) {
						_log.info("if enconde xml" + encodedXML);
						renderRequest.setAttribute("SAMLRequestBase64", encodedXML);
						renderRequest.setAttribute("SAMLRelayState", "");
						renderRequest.setAttribute("urlFA", PropsUtil.get("fa.url"));
					}
			}
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return "/jsp/logoutFA.jsp";
	}

}
