<%-- <%@ page import="com.liferay.portal.kernel.*"%> --%>
<%@page import = "com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import="javax.portlet.PortletURL"%>


<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
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
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%> 

 <%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%> 
 <%@page import="com.liferay.portal.kernel.util.ListUtil"%> 
 <%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%> 


<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="pt.com.ama.service.SearchHelper"%>

<%@ include file="init.jsp" %>

		<%
		PortletURL portletURL = renderResponse.createRenderURL();
		String portletURLString = portletURL.toString();
		ContentWebSearchContainer contentWebSearchContainer = new ContentWebSearchContainer(renderRequest, portletURL);
		WebContentDisplayTerms displayTerms = (WebContentDisplayTerms)contentWebSearchContainer.getDisplayTerms();
  		 %>
  		  
<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" 
    value="/WEB-INF/jsp/search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="search-form">
        <span class="aui-search-bar">
            
              <aui:select inlineField="<%= true %>" name="orderBy" >
        		<aui:option label="Date" value="D" />
        		<aui:option label="Id" value="I" />
        		<aui:option label="Title" value="T" />
    		 </aui:select>
    		 
            <aui:select inlineField="<%= true %>" name="filter" >
              	<aui:option label="all-axes" value="" />		  
        		<aui:option label="open-data" value="dados abertos" />
        		<aui:option label="transparency" value="transparência"/>
        		<aui:option label="digital-inclusion" value="inclusão digital" />
        		<aui:option label="public-participation" value="participação pública" />
    		 </aui:select>
            
            <aui:input inlineField="<%= true %>" 
              		   name="keywords" 
              		   size="30" 
              		   title="search" 
              		   type="text"
            />            

            <aui:button type="submit" value="search"  />
        </span>
    </div>
</aui:form>

<aui:form action="<%= portletURLString %>" method="post" name="fm">

	<liferay-ui:search-container  searchContainer="<%= contentWebSearchContainer %>" 
								  total="<%= SearchHelper.getTotalJornalCount(displayTerms,contentWebSearchContainer.getStart(), contentWebSearchContainer.getEnd()) %>">
	<liferay-ui:search-form page="/WEB-INF/jsp/search.jsp" 
							servletContext="<%= application %>" />
	<liferay-ui:search-container-results results="<%=SearchHelper.getJornal(displayTerms,contentWebSearchContainer.getStart(), contentWebSearchContainer.getEnd()) %>"/>
		 <liferay-ui:search-container-row className="com.liferay.journal.model.JournalArticle" 
		 								  modelVar="aJornal" >
			<liferay-ui:search-container-column-text name="Key" property="articleId" />

  			<liferay-ui:search-container-column-text  name="Propose" 
   													  value="${aJornal.title}"  
   													  href="${aJornal.urlTitle}" 
   													  />  

 			<liferay-ui:search-container-column-text name="Tag" property="content" /> 
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>


	 	

