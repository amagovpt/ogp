package AMA.OpenGov.btncallLogin.portlet;

import AMA.OpenGov.btncallLogin.constants.BtnCallLoginPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author raraujo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AMA-OpenGov",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BtnCallLogin Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BtnCallLoginPortletKeys.BtnCallLogin,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BtnCallLoginPortlet extends MVCPortlet {
}