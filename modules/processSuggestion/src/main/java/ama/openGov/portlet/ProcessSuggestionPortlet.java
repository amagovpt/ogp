package ama.openGov.portlet;



import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author nbelo
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AMA-OpenGov",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProcessSuggestion",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user,guest"		
	},
	service = Portlet.class
)

public class ProcessSuggestionPortlet extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(ProcessSuggestionPortlet.class.getName());
	
	/*
	* Serve Resource
	*/
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException{
		
		log.info("Entrou!");

    	String jsonData = ParamUtil.getString(request, "data");
    	JSONObject obj =  JSONFactoryUtil.createJSONObject();
    	
    	try {
        	JSONObject jData = JSONFactoryUtil.createJSONObject(jsonData);
    		String nome = jData.getString("nome");
        	String email = jData.getString("email");
        	String mensagem = jData.getString("mensagem");
        	boolean snValida = true;
        	
        	log.info("Nome encontrado="+nome);
        	
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
        	
	    	//ContatoServices.gravaEmail(request,ContatoServices.sendEmail(request));
        	obj.put("nome", nome);
	    	obj.put("message","Mensagem enviada com sucesso, Obrigado. ");
	    	obj.put("error",false);
			
		} catch (JSONException e) {
			obj.put("message","Erro ao enviar mensagem ao servidor! - "+e.getMessage());
			obj.put("error",true);
		}
    	

    	PrintWriter out=response.getWriter();
    	out.print(obj.toString());
    }

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		log.info("Passou no do View!");
		
		super.doView(renderRequest, renderResponse);
	}
	
	/*public void addComment(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("Add Suggestion");
	}*/
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		//addComment(actionRequest, actionResponse);
		log.info("Process Action!");
		//super.processAction(actionRequest, actionResponse);
	}
	
	
	
}