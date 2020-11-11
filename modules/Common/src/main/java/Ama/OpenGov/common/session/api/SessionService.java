package Ama.OpenGov.common.session.api;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SessionService {

//	public <T> void setSessionAtribute(HttpSession httpSession, String key, T value);
//
//	public <T> T getSessionAtribute(HttpSession httpSession, String key);
	
//	public void removeSessionAtribute(HttpSession httpSession, String key);

//	Object get(PortletRequest portletRequest, String parameterId);
//
//	void remove(PortletRequest portletRequest, String parameterId);
//
//	void register(PortletRequest portletRequest, String parameterId, Object value);
//
//	void registerPortletSession(PortletRequest portletRequest, String parameterId, Object value);

	void removePortletSession(PortletRequest portletRequest, String parameterId);

//	Object getPortletSession(PortletRequest portletRequest, String parameterId);
	
	Object getSession(HttpServletRequest httpServletRequest, String parameterId);
	
	void removeSession(HttpServletRequest httpServletRequest, String parameterId);
	
//	void registerSession(HttpServletRequest httpServletRequest, String parameterId, Object value);
}
