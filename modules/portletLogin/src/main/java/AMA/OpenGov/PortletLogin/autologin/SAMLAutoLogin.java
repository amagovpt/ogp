package AMA.OpenGov.PortletLogin.autologin;
	
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
	
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import AMA.OpenGov.Services.sessions.SessionService;
	
	@Component(immediate = true)
	public class SAMLAutoLogin implements AutoLogin {
	
		private Log _log = LogFactoryUtil.getLog(SAMLAutoLogin.class);

		@Reference
		SessionService sessionService;
	
		@Override
		public String[] handleException(HttpServletRequest request, HttpServletResponse response, Exception e)
				throws AutoLoginException {
			// TODO Auto-generated method stub
			return null;
		}
	
		@Override
		public String[] login(HttpServletRequest request, HttpServletResponse response) throws AutoLoginException {
			
			String [] credentials =  (String[]) sessionService.getSession(request, "userCredentials");

			if (credentials != null){
				sessionService.removeSession(request, "userCredentials");
			}
			return credentials;
		}
	
	
		
	
	}
