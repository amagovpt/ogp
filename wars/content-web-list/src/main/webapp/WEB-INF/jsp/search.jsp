<%@include file="init.jsp" %>
	
	<%
	ContentWebSearchContainer searchContainer = (ContentWebSearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
	WebContentDisplayTerms displayTerms = (WebContentDisplayTerms)searchContainer.getDisplayTerms();

// 	 String keywords = ParamUtil.getString(request, "keywords");
//   	long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");
	%>

<!-- Ordenar por: Data, ID, Titulo -->
<!-- Filtro por: Dados Abertos, Transparência,Inclusão digital, Participação publica -->

	
<%-- <liferay-ui:search-toggle buttonLabel="Web Content Search" displayTerms="<%= displayTerms %>" id="toggle_id_employee_search"> --%>
<%-- 	<aui:input label="urlTitle" name="urlTitle Content Search" value="<%=displayTerms.geturlTitle() %>"/> --%>
<%-- 	<aui:input label="xxx" name="OrderBy Content Search" value="<%=displayTerms.getorderBy() %>"/> --%>
<%-- </liferay-ui:search-toggle> --%>


<%-- <portlet:renderURL var="viewURL"> --%>
<%--     <portlet:param  --%>
<%--          name="mvcPath"   --%>
<%--          value="/view.jsp"   --%>
<%--      />  --%>
<%--  </portlet:renderURL>  --%>
