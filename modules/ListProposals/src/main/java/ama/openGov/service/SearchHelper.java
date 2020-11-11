package ama.openGov.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.util.JournalContent;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;


import ama.openGov.search.WebContentDisplayTerms;


public class SearchHelper {
	
	
	private static Log log = LogFactoryUtil.getLog(SearchHelper.class.getName());
	
	public static List<JournalArticle>getJornal(WebContentDisplayTerms displayTerms,int start,int end,Object languageId) 
			throws SystemException{
        List<JournalArticle> jornalList = null;
		try {
			jornalList = getJornalData(displayTerms,languageId);
			jornalList = ListUtil.subList(jornalList, start , end) ; 
		} catch (PortalException e) {
			log.error("Erro na busca getJornal  --- :"+e.getMessage());
		}
        
        return jornalList;
	}
	public static int getTotalJornalCount(WebContentDisplayTerms displayTerms,int start,int end,Object languageId) 
			throws SystemException, PortalException {
        int jornalList = 0;

		try {
			jornalList=	getJornalData(displayTerms,languageId).size();
		} catch (Exception e) {
			jornalList = 0;
			log.info("Erro no metodo getTotalJornalCount: Retornando nenhum valor ");
		}
		return jornalList;
	}
	
	public static List<JournalArticle>getJornalData(WebContentDisplayTerms displayTerms,Object languageId) 
			throws SystemException, PortalException {

		
		//		List<JournalArticle> ResultJornalListDiretorio = new ArrayList<JournalArticle>();
		List<JournalArticle> JornalListDiretorio = Collections.EMPTY_LIST;
		List<JournalArticle> ResultJornalList = new ArrayList<JournalArticle>();
		Criterion critDiretorio;
			try{
			//C�digo para recuperar os WebContents, ir� recuperar o FolderID e GroupId onde estiver cadastrado 
			//o webcontent proposta-modelo
			
			DynamicQuery dynamicQuery = JournalArticleLocalServiceUtil.dynamicQuery();
			critDiretorio = (PropertyFactoryUtil.forName("urlTitle").like("proposta-modelo"));
			dynamicQuery.addOrder(PropertyFactoryUtil.forName("createDate").desc());
			dynamicQuery.add(critDiretorio);
			JornalListDiretorio =JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			long vGroupId = JornalListDiretorio.get(0).getGroupId();
			long vFolderId = JornalListDiretorio.get(0).getFolderId();
			//Fim//
	
			ResultJornalList = fFiltro(vGroupId,vFolderId, displayTerms,languageId);
		} catch (SystemException e1) {
			log.error("Erro no metodo getJornalData (Verificar diretorio se existe o webcontent proposta-modelo configurado --- :"+e1.getMessage());
		}
		return ResultJornalList;
	}
	
	private static List<JournalArticle>fFiltro(long vGroupId,long vFolderId, WebContentDisplayTerms displayTerms, Object languageId) throws PortalException{
		
		List<JournalArticle> JornalList = Collections.EMPTY_LIST;
		DynamicQuery dynamicQuery = JournalArticleLocalServiceUtil.dynamicQuery();
		Criterion crit = null;
		
		List<JournalArticle> journalArticleList = new ArrayList<JournalArticle>();

		try{
			crit = PropertyFactoryUtil.forName("groupId").eq(vGroupId);
			crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("folderId", vFolderId));
			
			if(!Validator.isBlank(displayTerms.getKeywords())){
				crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.like("title", "%"+displayTerms.getKeywords()+"%"));
			}
//			if (!Validator.isBlank(displayTerms.getfilter())) {
//				for (AssetTag assetTag : tags) {					
//					if (assetTag.getName().equals(displayTerms.getfilter())) {
//						List<JournalArticle> journalArticleTag = new ArrayList<JournalArticle>();
//						try {
//							log.info("+++++++++++++antes de chamar a func+++++++++++++" );
//							journalArticleTag = findArticleByTag(assetTag.getGroupId(),vGroupId, displayTerms.getfilter());
//						} catch (SystemException e1) {
//							log.error("Busca Tags SystemException --- :"+e1.getMessage());
//						} catch (PortalException e1) {
//							log.error("Busca Tags PortalException --- :"+e1.getMessage());
//						}
//						log.info("TAG:" + displayTerms.getfilter());
//						log.info("journalArticleTag:" +journalArticleTag);
//						if(!journalArticleTag.isEmpty()){
//							crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.in("articleId", journalArticleTag));
//						}else{
//							//adicionado para nao retornar valores caso nao tenha tag cadastrada. (Não existe folder 0 )
//							crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("folderId", 0l));
//							log.info("Ainda não existe tag cadastrada para:" + displayTerms.getfilter());
//						}
//						break;
//					}
//				}
//			}
			
//			if(displayTerms.getorderBy().equals("D") || Validator.isBlank(displayTerms.getorderBy())){
//				dynamicQuery.addOrder(PropertyFactoryUtil.forName("createDate").desc());
//			}else if(displayTerms.getorderBy().equals("I")){
//				dynamicQuery.addOrder(PropertyFactoryUtil.forName("articleId").asc());
//			}else 
				if(displayTerms.getorderBy().equals("T")){
				dynamicQuery.addOrder(PropertyFactoryUtil.forName("urlTitle").asc());
				}
			dynamicQuery.add(crit);
			JornalList =JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery);

		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			log.error("Erro ao pesquisar:"+e1.getMessage());
		}
		
		for (JournalArticle article : JornalList) {
			try {
				String LayoutUuidarticless = article.getLayoutUuid(); 
				try {
					
					if (LayoutUuidarticless != ("")  && article.isApproved() && JournalArticleLocalServiceUtil.isLatestVersion(vGroupId, article.getArticleId(), article.getVersion())) {
						
						String titulo = xmlTitle(article.getContent(),article.getUrlTitle(),article.getArticleId());
						String tag = xmlTag(article.getContent(),titulo);
						//Campos Atribuições
						if (!Validator.isBlank(displayTerms.getfilter()) && !displayTerms.getfilter().equals("T")) {
							if (tag.substring(0,2).equals(displayTerms.getfilter().substring(0,2))) {
								if(languageId.toString().equals("pt_PT")){
									article.setTreePath(tag);
								}else{
									article.setTreePath(traducao(tag));
								}
								article.setCompanyId(buscaIdProposta(article.getContent(),titulo));
								article.setTitle(article.getTitle((Locale) languageId));
								article.setUrlTitle("/-/"+article.getUrlTitle());
								journalArticleList.add(article);
//								Collections.sort(journalArticleList);
								ordenaListId(journalArticleList,displayTerms.getorderBy());
							}
						}else{
							if(languageId.toString().equals("pt_PT")){
								article.setTreePath(tag);
							}else{
								article.setTreePath(traducao(tag));
							}
							article.setCompanyId(buscaIdProposta(article.getContent(),titulo));
							article.setTitle(article.getTitle((Locale) languageId));
							article.setUrlTitle("/-/"+article.getUrlTitle());
							journalArticleList.add(article);
							ordenaListId(journalArticleList,displayTerms.getorderBy());
							//Campos Atribuições Fim
						}
					}
				} catch (DocumentException | IOException e) {
					log.error("Obter o xml"+e.getMessage());
				}
			} catch (SystemException e) {
				log.error("For dos filtros searchContainer"+e.getMessage());
			}
			//journalArticleList.stream().filter(j -> j.getArticleId() == article.getArticleId()).
		}
		return journalArticleList;
	}
	
//	public static List<JournalArticle> findArticleByTag(long vTagId,long vGroupId, String tagName) throws PortalException, SystemException {
//		log.info("Inicio::");
//		AssetTag assetTagObj = AssetTagLocalServiceUtil.getTag(vTagId, tagName);
//		log.info("findArticleByTag::");
//		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
//		long[] anyTagIds = { assetTagObj.getTagId() };
//		assetEntryQuery.setAnyTagIds(anyTagIds);
//		log.info("getentries::"+assetEntryQuery);
//		List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
//		
//		List journalArticleList = new ArrayList<String>();
//		log.info("for::"+assetEntryList);
//		for (AssetEntry ae : assetEntryList) {
//			log.info("Pegando a url do que foi recuperado do entries:::"+ae.getUrl());
//			JournalArticleResource journalArticleResourceObj = JournalArticleResourceLocalServiceUtil.getJournalArticleResource(ae.getClassPK());
//			log.info("Chamando o getjournalarticleresource::"+journalArticleResourceObj);
//					
//			JournalArticle journalArticleObj = JournalArticleLocalServiceUtil.getArticle(vGroupId,journalArticleResourceObj.getArticleId());
//			log.info("Chamando o getJournal"+journalArticleObj);
//			journalArticleList.add(journalArticleObj.getArticleId());
//			
//		}
//		return journalArticleList;
//	}
	
	public static String xmlTag(String myContent, String titulo) throws DocumentException, IOException {
		String tag = null;
		Document document = null;
		try {
			
			if(!myContent.isEmpty()){
				document = SAXReaderUtil.read(new StringReader(myContent));
				
				Node node = document.selectSingleNode("/root/dynamic-element[@name='Select']/dynamic-content"); 
				if(Validator.isNotNull(node)){
					if(node.getText().length() > 0) {
						tag = node.getText();
					}
				}else{
					log.error("Tag de Proposta Vazia, Proposta: "+titulo);
				}
			}
		} catch (DocumentException e) {
			log.error("Erro no xmlTag:::"+e.getMessage());
		}
		return tag;
	}

	public static String xmlTitle(String myContent, String urlTitle, String idArticle) throws DocumentException, IOException {
		String titulo = null;
		Document document = null;
		try {
			document = SAXReaderUtil.read(new StringReader(myContent));
			Node node = document.selectSingleNode("/root/dynamic-element/dynamic-element[@name='Titulo']/dynamic-content");
			
			if(Validator.isNotNull(node)){
				if(node.getText().length() > 0) {
					titulo = node.getText();
				}
			}else{
				log.error("Titulo de Proposta Vazia, Proposta: "+urlTitle + " ID_:"+idArticle);
			}
		} catch (DocumentException e) {
			log.error("Erro no xmlTitle:::"+e.getMessage());
		}
		return titulo;
	}
	
	public static String traducao(String texto) {
		String traducao = null;
		
		try {
			if(texto.equals("dados abertos")){
				traducao = "Open Data";
			}else if(texto.length() ==  13){
				traducao = "Transparency";
			}else if(texto.length() ==  16){
				traducao = "Digital Inclusion";
			}else if(texto.length() ==  20){
				traducao = "Public Participation";
			}
		} catch (Exception e) {
			log.error("Erro na tradução da tag:::"+e.getMessage());
		}
		return traducao;
	}
	
	public static int buscaIdProposta(String myContent, String title) throws DocumentException, IOException {
		int buscaIdProposta = 0;
		Document document = null;
		try {
			document = SAXReaderUtil.read(new StringReader(myContent));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='numero']/dynamic-content");
			if(Validator.isNotNull(node)){
				if(node.getText().length() > 0) {
					buscaIdProposta = Integer.parseInt(node.getText());
				}
			}else{
				log.error("Numero de Proposta Vazia, Proposta: "+title);
			}
		} catch (DocumentException e) {
			log.error("Erro no buscaIdProposta:::"+e.getMessage());
		}
		return buscaIdProposta;
	}
	
	public static void ordenaListId(List<JournalArticle> journalArticleList, String orderBy){
		if(orderBy.equals("I")||Validator.isBlank(orderBy)){
			Collections.sort(journalArticleList, new Comparator<JournalArticle>() {
	
				@Override
				public int compare(JournalArticle o1, JournalArticle o2) {
					
					return o1.getCompanyId() > o2.getCompanyId() ? 1 : (o1.getCompanyId() < o2.getCompanyId()) ? -1 : 0;
				}
			});
		}
		
	}
}

