package AMA.OpenGov.configuration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;


@Component(
    configurationPid = "AMA.OpenGov.configuration.ProcessCommentConfigurationAction",
    configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
   property = {
       "javax.portlet.name=AMA_OpenGov_portlet_ProcessCommentPortlet"
   },
   service = ConfigurationAction.class
)

public class ProcessCommentConfigurationAction extends DefaultConfigurationAction {
    
    @Override
   public String getJspPath(HttpServletRequest renderRequest) {

       PortletRequest pr=(PortletRequest) renderRequest.getAttribute("javax.portlet.request");
       PortletPreferences prefs=pr.getPreferences();
       renderRequest.setAttribute("email", prefs.getValue("email", ""));

        return "/configuration.jsp";
    }
        
    @Override
   public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
           
       String email = ParamUtil.getString(actionRequest, "email", "");
       PortletPreferences prefs = actionRequest.getPreferences();
       _log.info("Prefs value set to = " + email);
       prefs.setValue("email", email);
       prefs.store();

    }

   private static final Log _log = LogFactoryUtil.getLog(ProcessCommentConfigurationAction.class);
    
}
