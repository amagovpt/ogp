//package AMA.OpenGov.PortletLogin.commands;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.Layout;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.WebKeys;
//
//import AMA.OpenGov.PortletLogin.constants.PortletLoginPortletKeys;
//
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//import Ama.OpenGov.common.model.*;
//
//@Component(
//		immediate = true,
//		property = {
//				"javax.portlet.name= AmaLogin",
//				"mvc.command.name=/"
//		},
//		service = MVCRenderCommand.class
//	)
//public class RenderCommand implements MVCRenderCommand {
//	
//	private static Log _log = LogFactoryUtil.getLog(RenderCommand.class);
//
//	@Override
//	public String render(RenderRequest renderRequest, RenderResponse renderResponse)throws PortletException {
//		
//		_log.info("Passando no RenderCommand sem nome");
//
//		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		Layout layout = themeDisplay.getLayout();
//		
//		if(layout.getFriendlyURL().equalsIgnoreCase(NavigationURL.ENTRAR.getUrl())){
//			return "/jsp/login.jsp";
//		}else{
//			return "/jsp/createUserAccount.jsp";
//			
//		}
//		
//	}
//	
//}
