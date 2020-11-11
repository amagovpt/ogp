package AMA.OpenGov.PortletLogin.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import AMA.OpenGov.PortletLogin.portlet.PortletLoginPortlet;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;


@Component(
	immediate = true,
	property = {
		//"javax.portlet.name=" + ProcessCommentPortletKeys.ProcessComment,
//		"javax.portlet.name=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortlet",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"mvc.command.name=processLogin"
	},
	service = MVCResourceCommand.class
)
public class ProcessLoginResource implements MVCResourceCommand {
	
	private static Log log = LogFactoryUtil.getLog(ProcessLoginResource.class.getName());

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException {
				
//		nao precisa
		
		
		return false;
		
	}
		
    	

}
