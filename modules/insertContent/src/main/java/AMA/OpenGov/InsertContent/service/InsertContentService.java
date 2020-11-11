package AMA.OpenGov.InsertContent.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleConstants;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.intraband.SystemDataType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import AMA.OpenGov.InsertContent.portlet.*;

public class InsertContentService {

	private static Log log = LogFactoryUtil.getLog(InsertContentPortlet.class.getName());
	
	public static JournalArticle addJournalArticle(
		    long userId, long groupId, String title, String content,String eixos,String email
		    		,String nome,String languageId,long folderId,String ddmStructureKey,String ddmTemplateKey, String objectivo, String problema, String solucao, String outras) throws Exception {
		
		ServiceContext serviceContext = new ServiceContext();
		Calendar cal = Calendar.getInstance();
		String xmlContent = null;
		int dia = cal.get(Calendar.DATE);
		int mes = cal.get(Calendar.MONTH);
		int ano = cal.get(Calendar.YEAR);
		int hora = cal.get(Calendar.HOUR);
		int minuto = cal.get(Calendar.MINUTE);

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		try {
				
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
	
			if(languageId.equals("pt_PT")){
				Locale locale = new Locale("pt", "PT");
				titleMap.put(locale, title);
				descriptionMap.put(locale, title);

				xmlContent =
	//					"<?xml version=\"1.0\"?>" +
	//							"<root available-locales=\"pt_PT\" default-locale=\"pt_PT\">" +
	//							"<dynamic-element name=\"Nome\" type=\"text\" index-type=\"keyword\" instance-id=\"wsjq\">" +
	//								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + nome + "]]></dynamic-content>" +
	//							"</dynamic-element>" +
	//							"<dynamic-element name=\"Email\" type=\"text\" index-type=\"keyword\" instance-id=\"rcnb\">" +
	//								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + email + "]]></dynamic-content>" +
	//							"</dynamic-element>" +
	//							
	//							"<dynamic-element name=\"Titulo\" type=\"text\" index-type=\"keyword\" instance-id=\"gjgg\">" +
	//								"<dynamic-element name=\"TextArea\" instance-id=\"kooe\" type=\"text_box\" index-type=\"text\">" +
	//									"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + content + "]]></dynamic-content>" +
	//								"</dynamic-element>" +
	//								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + title + "]]></dynamic-content>" +
	//							"</dynamic-element>" +
	//							"<dynamic-element name=\"Select\" type=\"list\" index-type=\"keyword\" instance-id=\"mqpg\">"+
	//								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + eixos + "]]></dynamic-content>"+
	//							"</dynamic-element>"+
	//							"</root>" ;
						"<?xml version=\"1.0\"?>" +
						"<root available-locales=\"pt_PT\" default-locale=\"pt_PT\">" +
							"<dynamic-element name=\"numero\" type=\"ddm-integer\" index-type=\"keyword\" instance-id=\"zlks\">" +
								"<dynamic-element name=\"Titulo\" instance-id=\"becw\" type=\"text\" index-type=\"keyword\">" +
									"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + title + "]]></dynamic-content>" +
								"</dynamic-element>" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[000]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"textoObjectivo\" type=\"text_box\" index-type=\"text\" instance-id=\"ylmg\">" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + objectivo + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"textoProblema\" type=\"text_box\" index-type=\"text\" instance-id=\"zuuo\">" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + problema + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"resolverTexto\" type=\"text_box\" index-type=\"text\" instance-id=\"kgpq\">" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + solucao + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"Select\" type=\"list\" index-type=\"keyword\" instance-id=\"kkxk\">" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + eixos + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"entidade\" type=\"text_box\" index-type=\"text\" instance-id=\"rxhc\">" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[ENTIDADE PADRAO]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"outras\" type=\"text\" index-type=\"keyword\" instance-id=\"hkrv\">" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + outras + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"data\" type=\"text\" index-type=\"keyword\" instance-id=\"zzbn\">" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[VALORES PADRÃO PORTAL OPENGOV]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"Nome\" type=\"text\" index-type=\"keyword\" instance-id=\"sjep\">" +
								"<dynamic-element name=\"Email\" instance-id=\"cjyi\" type=\"text\" index-type=\"keyword\">" +
									"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + email + "]]></dynamic-content>" +
								"</dynamic-element>" +
								"<dynamic-content language-id=\"pt_PT\"><![CDATA[" + nome + "]]></dynamic-content>" +
							"</dynamic-element>" +
						"</root>" ;
				
				
			}else{
			    titleMap.put(Locale.US, title);
			    descriptionMap.put(Locale.US, title);

				xmlContent =
	//					"<?xml version=\"1.0\"?>" +
	//							"<root available-locales=\"en_US\" default-locale=\"en_US\">" +
	//							"<dynamic-element name=\"Nome\" type=\"text\" index-type=\"keyword\" instance-id=\"wsjq\">" +
	//								"<dynamic-content language-id=\"en_US\"><![CDATA[" + nome + "]]></dynamic-content>" +
	//							"</dynamic-element>" +
	//							"<dynamic-element name=\"Email\" type=\"text\" index-type=\"keyword\" instance-id=\"rcnb\">" +
	//								"<dynamic-content language-id=\"en_US\"><![CDATA[" + email + "]]></dynamic-content>" +
	//							"</dynamic-element>" +
	//							"<dynamic-element name=\"Titulo\" type=\"text\" index-type=\"keyword\" instance-id=\"gjgg\">" +
	//								"<dynamic-element name=\"TextArea\" instance-id=\"kooe\" type=\"text_box\" index-type=\"text\">" +
	//									"<dynamic-content language-id=\"en_US\"><![CDATA[" + content + "]]></dynamic-content>" +
	//								"</dynamic-element>" +
	//								"<dynamic-content language-id=\"en_US\"><![CDATA[" + title + "]]></dynamic-content>" +
	//							"</dynamic-element>" +
	//							"<dynamic-element name=\"Select\" type=\"list\" index-type=\"keyword\" instance-id=\"mqpg\">"+
	//								"<dynamic-content language-id=\"en_US\"><![CDATA[" + eixos + "]]></dynamic-content>"+
	//							"</dynamic-element>"+
	//							"</root>" ;
						
//						"<?xml version=\"1.0\"?>" +
						"<root available-locales=\"en_US\" default-locale=\"en_US\">" +
							"<dynamic-element name=\"numero\" type=\"ddm-integer\" index-type=\"keyword\" instance-id=\"tqfq\">" +
								"<dynamic-element name=\"Titulo\" instance-id=\"awzk\" type=\"text\" index-type=\"keyword\">" +
									"<dynamic-content language-id=\"en_US\"><![CDATA[" + title + "]]></dynamic-content>" +
								"</dynamic-element>" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[000]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"textoObjectivo\" type=\"text_box\" index-type=\"text\" instance-id=\"cksh\">" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[" + objectivo + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"textoProblema\" type=\"text_box\" index-type=\"text\" instance-id=\"weiv\">" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[" + problema + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"resolverTexto\" type=\"text_box\" index-type=\"text\" instance-id=\"oszh\">" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[" + solucao + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"Select\" type=\"list\" index-type=\"keyword\" instance-id=\"cugk\">" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[" + eixos + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"entidade\" type=\"text_box\" index-type=\"text\" instance-id=\"atwn\">" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[VALORES PADRÃO PORTAL OPENGOV]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"outras\" type=\"text\" index-type=\"keyword\" instance-id=\"vobr\">" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[" + outras + "]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"data\" type=\"text\" index-type=\"keyword\" instance-id=\"ryux\">" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[VALORES PADRÃO PORTAL OPENGOV]]></dynamic-content>" +
							"</dynamic-element>" +
							"<dynamic-element name=\"Nome\" type=\"text\" index-type=\"keyword\" instance-id=\"wtbl\">" +
								"<dynamic-element name=\"Email\" instance-id=\"bdhg\" type=\"text\" index-type=\"keyword\">" +
									"<dynamic-content language-id=\"en_US\"><![CDATA[" + email + "]]></dynamic-content>" +
								"</dynamic-element>" +
								"<dynamic-content language-id=\"en_US\"><![CDATA[" + nome + "]]></dynamic-content>" +
							"</dynamic-element>" +
						"</root>" ;
						
			}
			
				    
		}catch (Exception e) {
			log.error("Erro ao submeter artigo:" + e.getMessage() );
		}
		JournalArticle article = null;
		try {
						article = 
			    			JournalArticleLocalServiceUtil.addArticle(
															    		userId, //long userId
															    		groupId, //groupId, //long groupId
															    		folderId, //0, // long folderId
															    		0, //long classNameId
															    		0,//long classPK
															    		title, //java.lang.String articleId
															    		true, //boolean autoArticleId
															    		JournalArticleConstants.VERSION_DEFAULT, //double version
															    		titleMap, //java.util.Map<java.util.Locale, java.lang.String> titleMap
															    		descriptionMap, //java.util.Map<java.util.Locale, java.lang.String> descriptionMap
															    		xmlContent, //java.lang.String content
															    		ddmStructureKey, //java.lang.String ddmStructureKey
															    		ddmTemplateKey, //java.lang.String ddmTemplateKey
															    		null, //java.lang.String layoutUuid
															    		//null, 
															    		mes, //int displayDateMonth
															    		dia, //int displayDateDay
															    		ano, //int displayDateYear
															    		hora, //int displayDateHour
															    		minuto, //int displayDateMinute
															    		0, //int expirationDateMonth
															    		0, //int expirationDateDay
															    		0, //int expirationDateYear
															    		0, //int expirationDateHour
															    		0, //int expirationDateMinute
															    		true, //boolean neverExpire
															    	    0, //int reviewDateMonth
															    	    0, //int reviewDateDay
															    	    0, //int reviewDateYear
															    	    0, //int reviewDateHour
															    	    0, //int reviewDateMinute
															    	    true, //boolean neverReview
															    	    true, //boolean indexable
															    	    false, //boolean smallImage 
															    	    null,  //java.lang.String smallImageURL
															    	    null, //java.io.File smallImageFile
															    		null, //java.util.Map<java.lang.String, byte[]> images
															    		null, //java.lang.String articleURL
															    		serviceContext //com.liferay.portal.kernel.service.ServiceContext serviceContext
									    						);
		} catch (Exception e) {
			
			 log.info("Erro ao adicionar artigo:Mensagem:"+e.getMessage());
			 log.info("Erro ao adicionar artigo:Causa:"+e.getCause());
			 e.printStackTrace();
		}
	    
		return article;
		
	}

	public static void updateJournalArticle(
		    long userId, long groupId, String title,String eixos, JournalArticle journalArticle )
		    throws Exception {
		try {
			
			log.info(" updateJournalArticle:");	
			List<AssetTag> tags = AssetTagLocalServiceUtil.getTags();
			for (AssetTag assetTag : tags) {
				if(assetTag.getName().equals(eixos)){
					final long[] tagId = {assetTag.getTagId()};
					final String[] tagNames = {assetTag.getName()};
					
						AssetEntryLocalServiceUtil.updateEntry(userId, 
																groupId,
																JournalArticle.class.getName(), 
																journalArticle.getResourcePrimKey(),//73968,//UpdateArticle.getResourcePrimKey(),
																null, 
																tagNames
																);
						break;
				}
			}
		} catch (Exception e) {
			log.error("Erro no update dos webcontent" + e.getMessage());
		}
	}
	
public static boolean validaCampos(String name,String titulo){
		
		boolean snValida = false;
		
		if(name.length() == 0  || titulo.length() == 0){
    		if(name.length() == 0){
    			snValida = true;
    			log.error("Nome está nulo");
    		}
			if(titulo.length() == 0){
				snValida = true;
				log.error("Titulo está vazio");
			}
    	}
		return snValida;
	}
}
