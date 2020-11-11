package AMA.OpenGov.Services.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {}, service = UtilService.class)
public class UtilsServiceImpl implements UtilService{

	private static final Log _log = LogFactoryUtil.getLog(UtilsServiceImpl.class);
	
	@Override
	public void setErrorMessage(PortletRequest request, String key) {
		
		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		SessionErrors.add(request, key);
	}
	
	@Override
	public void setErrorMessages(PortletRequest request, List<String> keys) {

		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		for(String key : keys)
		{
			SessionErrors.add(request, key);
		}
	}

	@Override
	public void setSuccessMessage(PortletRequest request, String key) {

		_log.info("Passando pela mensagem:" +request + "--"+key );
		SessionMessages.add(request, key);
//		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
//		SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		_log.info("Passando pela mensagem:" +request + "--"+key );
	}
	
	@Override
	public HttpServletRequest getHttpRequest(PortletRequest request) {
		HttpServletRequest hsrequest = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(hsrequest);
		return httpReq;
	}
	
	@Override
	public void hidePortlet(RenderRequest request) {
		request.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
	}

}
