package AMA.OpenGov.PortletLogin.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import AMA.OpenGov.PortletLogin.autologin.SAMLAutoLogin;
import AMA.OpenGov.PortletLogin.constants.PortletLoginPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {
				"javax.portlet.name=AmaLogin",
//				"javax.portlet.display-name=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortlet",
//				"javax.portlet.name=" + PortletLoginPortletKeys.portletAMALogin,
				"mvc.command.name=viewLogin"
		},
		service = MVCRenderCommand.class
	)
public class LoginRenderCommand implements MVCRenderCommand {
	
	private Log _log = LogFactoryUtil.getLog(LoginRenderCommand.class);
	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {
		
		_log.info("Passando no LoginRenderCommand ");
		
		return "/jsp/login.jsp";
	}
	
	
	
}
