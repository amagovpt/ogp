<%@ include file="init.jsp" %>

<%@page import = "com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import="javax.portlet.PortletURL"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.io.File"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="ama.openGov.service.SearchHelper"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	ContentWebSearchContainer contentWebSearchContainer = new ContentWebSearchContainer(renderRequest, portletURL);
	WebContentDisplayTerms displayTerms = (WebContentDisplayTerms)contentWebSearchContainer.getDisplayTerms();
	Object languageID = pageContext.getRequest().getLocale();
%>
  		  
<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<div class="container-fluid main-content-page">

	<h2 class="col-sm-10 col-sm-offset-1 panel-title"><liferay-ui:message key="proposals-list-header" />
		<span class="opendate-subtitle"><liferay-ui:message key="proposals-list-header-opendate" /></span>
	</h2>
	
	<div class="col-sm-10 col-sm-offset-1"> 
		<h3 class="list-proposals-subtitle"><liferay-ui:message key="proposals-list-second-header" /></h3>
				
		<!-- Hidden for now -->
		<div class="propose-measure-btn-pos">
			<button class="suggestion btn btn-primary" id="validaLogin" >
	       		<liferay-ui:message key="propose-your-measure"/>
			</button>
			<h4><liferay-ui:message key="to-insert-contribuitions-you-need-to-authenticate-first"/></h4>
		</div>
	
		<aui:form action="<%= searchURL %>" method="post" name="fm">
		    <liferay-portlet:renderURLParams varImpl="searchURL" />
		
		    <div class="search-form" style="margin-top: 60px;">
		        <span class="aui-search-bar list-proposals-search-form">
		            
		              <aui:select inlineField="<%= true %>" name="orderBy">
		        		<aui:option label="id" value="I" />
		        		<aui:option label="title" value="T" />
<%-- 		        		<aui:option label="date" value="D" /> --%>
		    		 </aui:select>
		    		
<!-- 		    		label � feito a tradu��o  -->
<!-- 					Value � feito a compara��o no retorno das tags	    		  -->
		            <aui:select inlineField="<%= true %>" name="filter-by">
		              	<aui:option label="all-axes" value="T" />		  
		        		<aui:option label="open-data" value="dad" />
		        		<aui:option label="transparency" value="tra"/>
		        		<aui:option label="digital-inclusion" value="inc" />
		        		<aui:option label="public-participation" value="par" />
		    		 </aui:select>
		            
		            <div class="search-text-pos">
			            <aui:input inlineField="<%= true %>" 
			              		   name="keywords" 
			              		   size="30" 
			              		   title="search" 
			              		   type="text"
			            />          
			
			            <aui:button type="submit" value="Search"  />
		            </div>	            
		        </span>
		    </div>
		</aui:form>
		
		<div class="measure-table-head">
		    <span>#</span>
		    <span><liferay-ui:message key="title"/></span>
		    <span><liferay-ui:message key="axis"/></span>
		    <span><liferay-ui:message key="comment"/></span>
		</div>
		
		<aui:form action="<%= portletURLString %>" method="post" name="fm" cssClass="proposals-list-table">
		
			<liferay-ui:search-container cssClass="total-width" searchContainer="<%= contentWebSearchContainer%>" 
				total="<%= SearchHelper.getTotalJornalCount(displayTerms,contentWebSearchContainer.getStart(), contentWebSearchContainer.getEnd(),languageID) %>">
			
<%-- 			<liferay-ui:search-form page="/search.jsp" servletContext="<%= application %>" /> --%>
			
			<liferay-ui:search-container-results results="<%=SearchHelper.getJornal(displayTerms,contentWebSearchContainer.getStart(), contentWebSearchContainer.getEnd(),languageID) %>"/>
				 
				 <liferay-ui:search-container-row className="com.liferay.journal.model.JournalArticle" modelVar="aJornal" >
					
					<!--<liferay-ui:search-container-column-text name="Key" property="articleId" />-->
					
					<liferay-ui:search-container-column-text name="Key" value="<span>#${aJornal.companyId}</span>" />
		
		  			<liferay-ui:search-container-column-text name="Propose" 
		   													 value="${aJornal.title}"  
		   													 href="${aJornal.urlTitle}" 
		   													  />  
				 			
		 			<liferay-ui:search-container-column-text name="Tag" value="<span>${aJornal.treePath}</span>" />
		 			<!--  liferay-ui:search-container-column-text name="Tag" property="content" />-->		 			
		 			
		 			<liferay-ui:search-container-column-text name="comment" value=" " href="${aJornal.urlTitle}"/>
		 			
				</liferay-ui:search-container-row>
				
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</aui:form>
		
	</div>
</div>

<script type="text/javascript">
$( document ).ready(function() {
	
	$("#validaLogin").click(function() {
		if (!Liferay.ThemeDisplay.isSignedIn()) {
// 			$("#loginModal").modal("show");
			$("#callLogin").trigger('click');
		} else {
			console.log("Utilizador logado." + Liferay.ThemeDisplay.getUserName()) 	
			$('#pm-nome').val(Liferay.ThemeDisplay.getUserName());			
			$("#myModalSuggestion").modal("show");
		}
	});
		
	var getUrlParameter = function getUrlParameter(sParam) {
	    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
	        sURLVariables = sPageURL.split('&'),
	        sParameterName,
	        i;

	    for (i = 0; i < sURLVariables.length; i++) {
	        sParameterName = sURLVariables[i].split('=');

	        if (sParameterName[0] === sParam) {
	            return sParameterName[1] === undefined ? true : sParameterName[1];
	        }
	    }
	};
	
	var action = getUrlParameter("modal");
	if (action == "open") {
		$('#pm-nome').val(Liferay.ThemeDisplay.getUserName());			
		$("#myModalSuggestion").modal("show");	
	}
		
});
</script>
