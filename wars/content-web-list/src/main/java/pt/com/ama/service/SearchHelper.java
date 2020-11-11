package pt.com.ama.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleResource;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;


import pt.com.ama.search.WebContentDisplayTerms;


public class SearchHelper {
	
	
	private static Log log = LogFactoryUtil.getLog(SearchHelper.class.getName());
	
	public static List<JournalArticle>getJornal(WebContentDisplayTerms displayTerms,int start,int end) 
			throws SystemException{
		
        List<JournalArticle> jornalList = null;
		try {
			jornalList = getJornalData(displayTerms);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			log.error("Erro na busca getJornal  --- :"+e.getMessage());
		}
        
        return ListUtil.subList(jornalList, start , end) ;
	}
	public static int getTotalJornalCount(WebContentDisplayTerms displayTerms,int start,int end) 
			throws SystemException, PortalException {

		return getJornalData(displayTerms).size();
	}
	
	public static List<JournalArticle>getJornalData(WebContentDisplayTerms displayTerms ) 
			throws SystemException, PortalException {
		
		List<JournalArticle> ResultJornalListDiretorio = new ArrayList<JournalArticle>();
		List<JournalArticle> JornalListDiretorio = Collections.EMPTY_LIST;
		List<JournalArticle> ResultJornalList = new ArrayList<JournalArticle>();
		Criterion critDiretorio;
			try{
			//Código para recuperar os WebContents, irá recuperar o FolderID e GroupId onde estiver cadastrado 
			//o webcontent proposta-modelo
			
			
			DynamicQuery dynamicQuery = JournalArticleLocalServiceUtil.dynamicQuery();
			critDiretorio = (PropertyFactoryUtil.forName("urlTitle").like("proposta-modelo"));
			dynamicQuery.addOrder(PropertyFactoryUtil.forName("createDate").desc());
			dynamicQuery.add(critDiretorio);
			JornalListDiretorio =JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			long vGroupId = JornalListDiretorio.get(0).getGroupId();
			long vFolderId = JornalListDiretorio.get(0).getFolderId();
			//Fim//
	
			
			ResultJornalList = fFiltro(vGroupId,vFolderId, displayTerms);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			log.error("Erro no metodo getJornalData (Verificar diretorio se existe o webcontent proposta-modelo configurado --- :"+e1.getMessage());
		}
		return ResultJornalList;
	}
	
	private static List<JournalArticle>fFiltro(long vGroupId,long vFolderId, WebContentDisplayTerms displayTerms) throws PortalException{
		
		List<JournalArticle> JornalList = Collections.EMPTY_LIST;
		List<JournalArticle> ResultJornalList = new ArrayList<JournalArticle>();
		DynamicQuery dynamicQuery = JournalArticleLocalServiceUtil.dynamicQuery();
		Criterion crit = null;
		
//		List journalArticleList = new ArrayList();
		List<JournalArticle> journalArticleList = new ArrayList<JournalArticle>();
		
		List<AssetTag> tags = AssetTagLocalServiceUtil.getTags();
		
		int i = 0;
		
		try{
			crit = PropertyFactoryUtil.forName("groupId").eq(vGroupId);
			crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("folderId", vFolderId));
			
			if(!Validator.isBlank(displayTerms.getKeywords())){
				crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.like("title", "%"+displayTerms.getKeywords()+"%"));
			}
			
			if (!Validator.isBlank(displayTerms.getfilter())) {
				
				for (AssetTag assetTag : tags) {
					if (assetTag.getName().equals(displayTerms.getfilter())) {
						List<JournalArticle> journalArticleTag = new ArrayList<JournalArticle>();
						try {
							journalArticleTag = findArticleByTag(assetTag.getGroupId(),vGroupId, displayTerms.getfilter());
						} catch (SystemException e1) {
							log.error("Busca Tags SystemException --- :"+e1.getMessage());
						} catch (PortalException e1) {
							log.error("Busca Tags PortalException --- :"+e1.getMessage());
						}
						crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.in("articleId", journalArticleTag));
						break;
					
					}
				}
			}
			
			if(displayTerms.getorderBy().equals("D") || Validator.isBlank(displayTerms.getorderBy())){
				dynamicQuery.addOrder(PropertyFactoryUtil.forName("createDate").desc());
			}else if(displayTerms.getorderBy().equals("I")){
				dynamicQuery.addOrder(PropertyFactoryUtil.forName("articleId").desc());
			}else if(displayTerms.getorderBy().equals("T")){
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
				
				if (LayoutUuidarticless != ("")  && article.isApproved()) {
					
					
					article.setUrlTitle("/-/"+article.getUrlTitle());
			       
					try {
						String tag = xmlTag(article.getContent());
						String titulo = xmlTitle(article.getContent());
						
						article.setContent(tag);
						article.setTitle(titulo);
					} catch (DocumentException | IOException e) {
						// TODO Auto-generated catch block
						log.error("Obter o xml"+e.getMessage());
					}
			       
					journalArticleList.add(article);
					i++;
				}
			} catch (SystemException e) {
				log.error("For dos filtros searchContainer"+e.getMessage());
			}
		}
		return journalArticleList;
	}
	
	public static List<JournalArticle> findArticleByTag(long vTagId,long vGroupId, String tagName) throws PortalException, SystemException {
		AssetTag assetTagObj = AssetTagLocalServiceUtil.getTag(vTagId, tagName);
		long tagid = assetTagObj.getTagId();
		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
		long[] anyTagIds = { tagid };
		assetEntryQuery.setAnyTagIds(anyTagIds);
		List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
		
		List journalArticleList = new ArrayList<String>();
		
		for (AssetEntry ae : assetEntryList) {
			JournalArticleResource journalArticleResourceObj = JournalArticleResourceLocalServiceUtil.getJournalArticleResource(ae.getClassPK());
			JournalArticle journalArticleObj = JournalArticleLocalServiceUtil.getArticle(vGroupId,journalArticleResourceObj.getArticleId());
			journalArticleList.add(journalArticleObj.getArticleId());
		}
		return journalArticleList;
	}
	
	public static String xmlTag(String myContent) throws DocumentException, IOException {
		String tag = null;
		Document document = null;
		try {
			document = SAXReaderUtil.read(new StringReader(myContent));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='Select']/dynamic-content");
			if (node.getText().length() > 0) {
				tag = node.getText();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return tag;
	}

	public static String xmlTitle(String myContent) throws DocumentException, IOException {
		String titulo = null;
		Document document = null;
		try {
			document = SAXReaderUtil.read(new StringReader(myContent));

			Node node = document.selectSingleNode("/root/dynamic-element[@name='Titulo']/dynamic-content");
			if (node.getText().length() > 0) {
				titulo = node.getText();
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return titulo;
	}
}

