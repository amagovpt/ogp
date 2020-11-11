package ama.openGov.search;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ama.openGov.service.SearchHelper;

public class ContentWebSearchContainer extends SearchContainer<JournalArticle> {
	
	private static Log log = LogFactoryUtil.getLog(ContentWebSearchContainer.class.getName());
	
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "result";
	public static final int DEFAULT_DELTA = 5;
	static List<String>	headerNames	= new ArrayList<String>();
	static {
		headerNames.add("urlTitle");
		headerNames.add("orderBy");
	}
	public ContentWebSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new WebContentDisplayTerms(portletRequest), new WebContentDisplayTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL,
				headerNames, EMPTY_RESULTS_MESSAGE);
		
		WebContentDisplayTerms displayTerms = (WebContentDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("urlTitle", displayTerms.geturlTitle());
		iteratorURL.setParameter("orderBy", displayTerms.getorderBy());
	}
}
