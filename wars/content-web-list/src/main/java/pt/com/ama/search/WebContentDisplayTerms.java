package pt.com.ama.search;

import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class WebContentDisplayTerms extends DisplayTerms {

	private String urlTitle;
	private String orderBy;
	private String filter;
	private String tag;

	public WebContentDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		urlTitle = ParamUtil.getString(portletRequest, "urlTitle");
		orderBy  = ParamUtil.getString(portletRequest, "orderBy");
		filter  = ParamUtil.getString(portletRequest, "filter");
		tag  = ParamUtil.getString(portletRequest, "tag");
	}

	public String geturlTitle() {
		return urlTitle;
	}

	public void seturlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	public String getorderBy() {
		return orderBy;
	}

	public void setorderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public String getfilter() {
		return filter;
	}

	public void setfilter(String filter) {
		this.filter = filter;
	}
	public String gettag() {
		return tag;
	}

	public void settag(String tag) {
		this.tag = tag;
	}
}
