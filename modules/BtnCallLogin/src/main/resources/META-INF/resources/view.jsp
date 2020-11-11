<%@ include file="/init.jsp" %>
<%@page import = "com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import = "com.liferay.portal.kernel.util.WebKeys" %>

<%
	ThemeDisplay themeDisplay1 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

	System.out.println(themeDisplay1.isSignedIn());
%>
<c:set var = "field" scope = "session" value = "<%=themeDisplay1.isSignedIn()%>"/>
	<c:if test="${field eq false}">
	<div class="col-md-12">
		<h5><liferay-ui:message key="to-insert-contribuitions-you-need-to-authenticate-first"/></h5>
		<p>
			<button class="suggestion btn btn-primary" id="chamaLogin" >
		       		<liferay-ui:message key="comment"/>
			</button>
		</p>		
	</div>
</c:if>


<script type="text/javascript">
	$("#chamaLogin").click(function() {
		console.log("Chamando");
		if (!Liferay.ThemeDisplay.isSignedIn()) {
// 			$("#loginModal").modal("show");
			$("#callLogin").trigger('click');
		}
	});
</script>