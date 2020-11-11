package pt.com.ama.portlet;

import javax.portlet.Portlet;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=AMA-OpenGov",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=ContentWebList Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

/**
 * @author raraujo
 */
@Controller(value = "ContatoController")
@RequestMapping("VIEW")
public class ContentWebListPortletViewController  {
//	extends MVCPortlet
	
	@RenderMapping
	public String renderForm(RenderResponse response, Model model) {
		model.addAttribute("view");

		return "view";
	}

}