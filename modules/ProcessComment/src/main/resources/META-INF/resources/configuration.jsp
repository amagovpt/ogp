<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.stream.Collectors"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.List" %>

<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%
String chosed = (String) request.getAttribute("email");

%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%=true%>" var="configurationRenderURL" />

<aui:form action="<%=configurationActionURL%>" method="post" name="fm" >
        
	<aui:fieldset-group markupView="lexicon">
        <aui:fieldset>
        <aui:input disabled="false" label="Email a Receber" name="email" id="email" value="<%=chosed%>">

		</aui:input>
        </aui:fieldset>
    </aui:fieldset-group>           
    
     <aui:button-row cssClass="text-left">           
        <aui:button type="submit" cssClass="btn-lg"></aui:button>          
     </aui:button-row>
        
</aui:form>