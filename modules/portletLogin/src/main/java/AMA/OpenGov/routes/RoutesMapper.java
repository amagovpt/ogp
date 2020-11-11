package AMA.OpenGov.routes;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
				"com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
				"javax.portlet.name=AmaLogin"
		},
		service = FriendlyURLMapper.class
 )

public class RoutesMapper extends DefaultFriendlyURLMapper {
	
	  private static Log log = LogFactoryUtil.getLog(RoutesMapper.class.getName());
 
	 @Override
	 public String getMapping() {
		 return _MAPPING;
	 }
	 
	public void consulta(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		 log.info("consulta routesmapper");
	}
	 
	 private static final String _MAPPING = "consulta";

}
