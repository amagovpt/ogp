<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="init.jsp" %>

<%
	System.out.println("Abrir Login FA no JSP FA");
	Object SAMLRequestBase64Obj = ParamUtil.getString(request, "SAMLRequestBase64");
	String SAMLRequestBase64 = SAMLRequestBase64Obj == null
			? StringPool.BLANK : SAMLRequestBase64Obj.toString();
	System.out.println("SAMLRequestBase64Obj:"+SAMLRequestBase64Obj);
	Object SAMLRelayStateObj = ParamUtil.getString(request, "SAMLRelayState");
	String SAMLRelayState = SAMLRelayStateObj == null
			? StringPool.BLANK : SAMLRelayStateObj.toString();
	System.out.println("SAMLRelayState:"+SAMLRelayState);
	
	Object urlFAObject = ParamUtil.getString(request, "urlFA");
	System.out.println("urlFAObject:"+urlFAObject);
	String urlFA = urlFAObject == null
			? "https://preprod.portaldocidadao.gov.pt/FA"	
			: urlFAObject.toString();
	System.out.println("urlFA:"+urlFA);
	System.out.println("FIM DO FA JSP:");

%>   

<div style="display: none;">
	<form name="faForm" action="<%= urlFA %>" method="post">
		
		<liferay-ui:success key="login.message.fa.redirect" message="login.message.fa.redirect" />
		
		<div style="display: none;">
			<div>
				<label for="SAMLRequest">Request Data</label> 
				<input type="text" name="SAMLRequest" value="<%= SAMLRequestBase64 %>" />
			</div>
			<div>
				<label for="RelayState">Relay State</label> 
				<input type="text" name="RelayState" value="<%= SAMLRelayState %>" />
			</div>
		</div>
		<noscript>
			<div id="noscript-fa">
				<p><%= LanguageUtil.get(request, "login.fa.message") %></p>
				<input type="submit" value="Autenticar" />
			</div>
		</noscript>
	</form> 
</div>

<script type="text/javascript">
	$(document).ready(function() {
		document.faForm.submit();
	});
</script>