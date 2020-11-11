package pt.com.ama.controller;

import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;


/**
 * @author raraujo
 */

@Component(
		immediate = true,
		property = { "com.liferay.portlet.display-category=Contactos",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Contato",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,power-user,user" }, service = Portlet.class)


public class ContactUsController{

/*	@RenderMapping
	public String renderForm(RenderResponse response, Model model) {
		model.addAttribute("view");
		return "view";
	}
	
	@ResourceMapping(value="saveData")
    public void saveData(ResourceRequest request,ResourceResponse response,Model model)throws IOException, PortletException{

		String nome = request.getParameter("nome");
    	String email = request.getParameter("email");
    	String mensagem = request.getParameter("mensagem");
    	boolean snValida = true;
    	
    	JSONObject obj =  JSONFactoryUtil.createJSONObject();
    	
    	if(nome.equals(null) || email.equals(null) | mensagem.equals(null)){
    		if(nome.equals(null)){
    			snValida = false;
    		}
			if(email.equals(null)){
				snValida = false;			
			}
			if(mensagem.equals(null)){
				snValida = false;
			}
    	}
    	if(!snValida){
    		obj.put("nome", "Inválido");
    		obj.put("message","Erro ao conectar com o servidor: ");
    		return;
    	}
    	try{
	    	ContatoServices.gravaEmail(request,ContatoServices.sendEmail(request));
	    	obj.put("message","Mensagem enviada com sucesso, Obrigado. ");
	    	obj.put("error",false);
    	}catch (Exception e) {
    		
	    	obj.put("message","Erro ao enviar mensagem ao servidor! - "+e.getMessage());
	    	obj.put("error",true);
		}
    	obj.put("nome", nome);
    	PrintWriter out=response.getWriter();
    	out.print(obj.toString());
    }
  */  
}
