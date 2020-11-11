package pt.com.ama.search;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.dao.search.SearchContainer;

public class ContentWebSearchContainer extends SearchContainer<JournalArticle> {
	public static final String	EMPTY_RESULTS_MESSAGE	= "Resultado n�o encontrado";
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
