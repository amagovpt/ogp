package AMA.OpenGov.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import AMA.OpenGov.LocalDataSaveEmail.model.*;
import AMA.OpenGov.LocalDataSaveEmail.service.*;
import pt.com.ama.services.CommentServices;

@Component(
	immediate = true,
	property = {
		//"javax.portlet.name=" + ProcessCommentPortletKeys.ProcessComment,
		"javax.portlet.name=AMA_OpenGov_portlet_ProcessCommentPortlet",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"mvc.command.name=addComment"
	},
	service = MVCResourceCommand.class
)
public class ProcessCommentResource implements MVCResourceCommand {
	
	private static Log log = LogFactoryUtil.getLog(ProcessCommentResource.class.getName());

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException {
		
    	String jsonData = ParamUtil.getString(request, "data");
    	JSONObject obj =  JSONFactoryUtil.createJSONObject();
    	
    	try {
        	JSONObject jData = JSONFactoryUtil.createJSONObject(jsonData);
    		String nome = jData.getString("nome");
        	String email = jData.getString("email");
        	String mensagem = jData.getString("msg");
        	ogp_comments contact = ogp_commentsLocalServiceUtil.createogp_comments(0);
        	contact.setNome(nome);
        	contact.setEmail(email);
        	contact.setMensagem(mensagem);
        	boolean snValida = true;
        	
        	log.info("Nome encontrado --->"+nome);
        	
        	/*if(nome.equals(null) || email.equals(null) | mensagem.equals(null)){
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
        		log.error("Erro ao conectar com o servidor");
        		obj.put("nome", "Inv�lido");
        		obj.put("message","Erro ao conectar com o servidor: ");
        		return false;
        	}*/
        	
        	log.info("A enviar mail...");
        	 
        	PortletPreferences prefs = request.getPreferences();
		    String receiver = (prefs.getValue("email", email));
		    prefs.store();
		    log.info(receiver);
		    
	    	CommentServices.gravaEmail(contact, CommentServices.sendSuggestion(contact, receiver));
        	obj.put("nome", nome);
	    	obj.put("message","Mensagem enviada com sucesso, Obrigado. ");
	    	obj.put("error",false);
			
		} catch (Exception e) {
			obj.put("message","Erro ao enviar mensagem ao servidor! - "+e.getMessage());
			obj.put("error",true);
		}
    	

    	PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			log.error("Erro="+e.getMessage());
			e.printStackTrace();
		}
    	out.print(obj.toString());
    	return true;
	}

}
