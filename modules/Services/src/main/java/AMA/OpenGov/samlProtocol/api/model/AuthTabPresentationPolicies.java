package AMA.OpenGov.samlProtocol.api.model;

import java.util.List;

public class AuthTabPresentationPolicies {
	
	private List<String> hideAuthTab;
	private String defaultSelectedAuthTab;
	
	public List<String> getHideAuthTab() {
		return hideAuthTab;
	}
	public void setHideAuthTab(List<String> hideAuthTab) {
		this.hideAuthTab = hideAuthTab;
	}
	public String getDefaultSelectedAuthTab() {
		return defaultSelectedAuthTab;
	}
	public void setDefaultSelectedAuthTab(String defaultSelectedAuthTab) {
		this.defaultSelectedAuthTab = defaultSelectedAuthTab;
	}	
}
