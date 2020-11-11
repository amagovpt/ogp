<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="init.jsp" %>


<%

	Object SAMLRequestBase64Obj = request.getAttribute("SAMLRequestBase64");
	String SAMLRequestBase64 = SAMLRequestBase64Obj == null
			? StringPool.BLANK : SAMLRequestBase64Obj.toString();

	Object SAMLRelayStateObj = request.getAttribute("SAMLRelayState");
	String SAMLRelayState = SAMLRelayStateObj == null
			? StringPool.BLANK : SAMLRelayStateObj.toString();
	
	Object urlFAObject = request.getAttribute("urlFA");
	System.out.println("urlFAObject:"+urlFAObject);
	String urlFA = urlFAObject == null
			? "http://localhost:8080/pt/web/opengov"	
			: urlFAObject.toString();
%>   

<div class="logoutFA">
	<form id="faForm" name="faForm" action="<%= urlFA%>" method="post">
		<liferay-ui:success key="login.message.fa.redirect" message="login.message.fa.redirect" />		
		<div class="hideItem">
			<div class="hideItem">
				<label for="SAMLRequest" class="hideText">Request Data</label> 
				<input type="hidden" name="SAMLRequest" value="<%= SAMLRequestBase64 %>" />
			</div>
			<div>
				<label for="RelayState"  class="hideText" >Relay State</label> 
				<input type="hidden" name="RelayState" value="<%= SAMLRelayState %>" />
			</div>
		</div>
		<noscript>
			<div id="noscript-fa">
				<p></p>
				<input type="submit" value="LogOut" />
			</div>
		</noscript>
	</form> 
</div>

<script type="text/javascript">
	$(document).ready(function() {
		document.faForm.submit();
	});
</script>