package AMA.OpenGov.InsertContent.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import AMA.OpenGov.InsertContent.constants.*;
import AMA.OpenGov.InsertContent.service.*;

/**
 * @author raraujo
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=AMA-OpenGov",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=insertContent Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + InsertContentPortletKeys.InsertContent,
		"javax.portlet.name=AMA_OpenGov_portlet_insertContentPortlet",

		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"mvc.command.name=addComment"
	},
	service = Portlet.class
)
public class InsertContentPortlet extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(InsertContentPortlet.class.getName());
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response )throws IOException, PortletException{
			
		UploadPortletRequest uploadPortletRequest1 = PortalUtil.getUploadPortletRequest(request);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String jsonData = ParamUtil.getString(uploadPortletRequest1, "data");
		JSONObject obj =  JSONFactoryUtil.createJSONObject();
		
		try {

			JSONObject jData = JSONFactoryUtil.createJSONObject(jsonData);

			String nome = jData.getString("nome");
			String email = jData.getString("email");
			String htmlContent = "null";
			String title = jData.getString("titulo");
			String eixos = jData.getString("eixos");

			String objectivo = jData.getString("objectivo");
			String problema = jData.getString("problema");
			String solucao = jData.getString("solucao");
			String outras = jData.getString("outras");
			
			if (InsertContentService.validaCampos(nome, title) || !themeDisplay.isSignedIn()) {
				obj.put("nome", "Inválido");
				obj.put("message", "Erro ao conectar com o servidor ou utilizador não autenticado: ");
				obj.put("error", true);
				log.error("Utilizador autenticado?"+themeDisplay.isSignedIn() + ",Nome:"+nome+ " ,Titulo:"+ title );
				PrintWriter out=response.getWriter();
				out.print(obj.toString());
				return;
			}
			
			email = themeDisplay.getUser().getEmailAddress();
			
			JournalArticle newArticle;
			long groupId = themeDisplay.getLayout().getGroupId();
			
			String languageId = LanguageUtil.getLanguageId(request);
			
			//Forma encontrada para obter os valores sem precisar realizar alteração em codigo
			// Criar um Webcontent no diretório e com o nome informado na urlTitle   proposta-modelo
			List<JournalArticle> ResultJornalList = new ArrayList<JournalArticle>();
			List<JournalArticle> JornalList = Collections.EMPTY_LIST;
			
			Criterion crit;
			
			DynamicQuery dynamicQuery = JournalArticleLocalServiceUtil.dynamicQuery();
			crit = (PropertyFactoryUtil.forName("urlTitle").like("proposta-modelo"));
			dynamicQuery.addOrder(PropertyFactoryUtil.forName("createDate").desc());
			dynamicQuery.add(crit);
			JornalList =JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			long   folderId = JornalList.get(0).getFolderId() ; //Informar o diretorio que será inserido o webcontent
			String ddmStructureKey = JornalList.get(0).getDDMStructureKey(); // ddmStructureKey - Codigo da Estrutura
			String ddmTemplateKey  = JornalList.get(0).getDDMTemplateKey(); // ddmTemplateKey  - Codigo do Template
			
			 newArticle = InsertContentService.addJournalArticle(
																	 themeDisplay.getUserId(),
																	 groupId,//themeDisplay.getScopeGroupId(),
																	 title,
																	 htmlContent,
																	 eixos,
																	 email,
																	 nome,
																	 languageId,
																	 folderId,
																	 ddmStructureKey,
																	 ddmTemplateKey,
																	 objectivo ,
																	 problema,
																	 solucao,
																	 outras
						 );
			InsertContentService.updateJournalArticle(
													 themeDisplay.getUserId(),
													 groupId,//themeDisplay.getScopeGroupId(),
													 title,
													 eixos,
													 newArticle
			 );
			
			obj.put("nome", nome);
			obj.put("message", "Proposta submetida com sucesso!");
			obj.put("error", false);

		} catch (Exception e) {
			log.error("Erro server resource:" + e.getMessage());
			obj.put("nome", "");
			obj.put("message","Erro ao enviar proposta ao servidor! - "+e.getMessage());
			obj.put("error",true);
			
		}
		PrintWriter out=response.getWriter();
    	out.print(obj.toString());
	}
}