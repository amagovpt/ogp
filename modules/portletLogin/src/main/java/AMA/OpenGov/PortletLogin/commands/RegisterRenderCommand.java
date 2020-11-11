package AMA.OpenGov.PortletLogin.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import AMA.OpenGov.PortletLogin.constants.PortletLoginPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {
				"javax.portlet.name=AmaLogin",
				"mvc.command.name=viewCreateUserAccount"
		},
		service = MVCRenderCommand.class
	)
public class RegisterRenderCommand implements MVCRenderCommand {
	
	private static Log _log = LogFactoryUtil.getLog(RegisterRenderCommand.class);

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {
		_log.info("Passando no render viewCreateUserAccount command");

		return "/jsp/createUserAccount.jsp";
	}
	
}
