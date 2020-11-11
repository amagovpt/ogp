package AMA.OpenGov.Services.util;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

public interface UtilService {

	void setErrorMessage(PortletRequest request, String key);
	
	void setErrorMessages(PortletRequest request, List<String> key);
	
	void setSuccessMessage(PortletRequest request, String key);

	void hidePortlet(RenderRequest request);

	HttpServletRequest getHttpRequest(PortletRequest request);
}
