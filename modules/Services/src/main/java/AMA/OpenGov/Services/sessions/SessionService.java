package AMA.OpenGov.Services.sessions;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public interface SessionService {

	final String SHAREATRIBUTE = "LIFERAY_SHARED_";
	static final Log _log = LogFactoryUtil.getLog(SessionService.class);

	public <T> void setSessionAtribute(HttpSession httpSession, String key, T value);

	public <T> T getSessionAtribute(HttpSession httpSession, String key);
	
	public void removeSessionAtribute(HttpSession httpSession, String key);

	Object get(PortletRequest portletRequest, String parameterId);

	void remove(PortletRequest portletRequest, String parameterId);

	void register(PortletRequest portletRequest, String parameterId, Object value);

	void registerPortletSession(PortletRequest portletRequest, String parameterId, Object value);

	void removePortletSession(PortletRequest portletRequest, String parameterId);

	Object getPortletSession(PortletRequest portletRequest, String parameterId);
	
	Object getSession(HttpServletRequest httpServletRequest, String parameterId);
	
	void removeSession(HttpServletRequest httpServletRequest, String parameterId);
	
	void registerSession(HttpServletRequest httpServletRequest, String parameterId, Object value);
}
