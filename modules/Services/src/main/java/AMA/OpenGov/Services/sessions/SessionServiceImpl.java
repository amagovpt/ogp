package AMA.OpenGov.Services.sessions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {}, service = SessionService.class)
public class SessionServiceImpl implements SessionService {
	
	private Log _log = LogFactoryUtil.getLog(SessionServiceImpl.class);
	
	private final String SHAREATRIBUTE = "LIFERAY_SHARED_";

	@Override
	public <T> void setSessionAtribute(HttpSession httpSession, String key, T value) {
		httpSession.setAttribute(key, value);
	}

	@Override
	public <T> T getSessionAtribute(HttpSession httpSession, String key) {
		return (T) httpSession.getAttribute(key);
	}

	@Override
	public void removeSessionAtribute(HttpSession httpSession, String key) {
		
		httpSession.removeAttribute(key);
	}

	
	@Override
	public Object get(PortletRequest portletRequest, String parameterId) {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);
		if (parameterId != null && !parameterId.equals(StringPool.BLANK)) {
			
			HttpSession session = request.getSession();
			return session.getAttribute(parameterId);
			
		} else {
			_log.error("Missing required parameter [parameterId]");
		}
		return  null;
		
	}
	
	@Override
	public void remove(PortletRequest portletRequest, String parameterId) {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);
		if (parameterId != null && !parameterId.equals(StringPool.BLANK)) {
			
			HttpSession session = request.getSession();
			session.removeAttribute(parameterId);
			
		} else {
			_log.error("Missing required parameter [parameterId]");
		}
		
	}
	
	@Override
	public void register(PortletRequest portletRequest, String parameterId, Object value) {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);

		if (parameterId != null && !parameterId.equals(StringPool.BLANK)) {

			HttpSession session = request.getSession();

			if (value != null ) {
				session.setAttribute(parameterId, value);
			}

		} else {
			_log.error("Missing required parameter [parameterId]");
		}

	}
	
	@Override
	public Object getPortletSession(PortletRequest portletRequest, String parameterId) {
		PortletSession portletSession = portletRequest.getPortletSession();
		return portletSession.getAttribute(SHAREATRIBUTE+parameterId, PortletSession.APPLICATION_SCOPE);
	}
	
	@Override
	public void removePortletSession(PortletRequest portletRequest, String parameterId) {

		_log.info("portletRequest.getPortletSession():" +portletRequest.getPortletSession());
		_log.info("parameterId:" +parameterId);
		_log.info("PortletSession.APPLICATION_SCOPE:" +PortletSession.APPLICATION_SCOPE);

		
		PortletSession portletSession = portletRequest.getPortletSession();
		portletSession.removeAttribute(SHAREATRIBUTE+ parameterId, PortletSession.APPLICATION_SCOPE);	
	}
	
	@Override
	public void registerPortletSession(PortletRequest portletRequest, String parameterId, Object value) {
		
		_log.info("0000000000000000000000000000inicio da função registerPortletSession0000000000000000000000000000" );
		PortletSession portletSession = portletRequest.getPortletSession();
		_log.info("portletSession:" +portletSession.getId());
		_log.info("portletSession:" +portletSession.getAttributeNames());
		_log.info("portletSession:" +portletSession.getPortletContext());
		_log.info("SHAREATRIBUTE::" +SHAREATRIBUTE);
		_log.info("parameterId::" +parameterId);
		_log.info("PortletSession.APPLICATION_SCOPE::" +PortletSession.APPLICATION_SCOPE);
		portletSession.setAttribute(SHAREATRIBUTE+ parameterId, value, PortletSession.APPLICATION_SCOPE);
		_log.info("0000000000000000000000000000fim da função registerPortletSession0000000000000000000000000000" );
	}
	
	
	@Override
	public Object getSession(HttpServletRequest httpServletRequest, String parameterId) {
		HttpSession httpSession = httpServletRequest.getSession(false);
		
		Object obj = null;
		if (httpSession != null)
		{
			obj = httpSession.getAttribute(SHAREATRIBUTE+parameterId);
		}
		return obj;
	}
	
	@Override
	public void removeSession(HttpServletRequest httpServletRequest, String parameterId) {
		HttpSession portletSession = httpServletRequest.getSession();
		portletSession.removeAttribute(SHAREATRIBUTE+ parameterId);
	}
	
	@Override
	public void registerSession(HttpServletRequest httpServletRequest, String parameterId, Object value) {
		HttpSession httpSession = httpServletRequest.getSession(false);
		
		_log.info("==========================inicio da registerSession==========================");
		_log.info("httpSession:"+httpSession);
		if (httpSession == null)
		{
			httpSession = httpServletRequest.getSession(true);
			_log.info("dentro do if httpSession:"+httpSession);
		}
		httpSession.setAttribute(SHAREATRIBUTE+ parameterId, value);
		_log.info("==========================fim da registerSession==========================");
	}

}
