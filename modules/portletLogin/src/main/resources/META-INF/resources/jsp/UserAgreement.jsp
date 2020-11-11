<%@ include file="init.jsp"%>

<%@page import="AMA.OpenGov.samlProtocol.api.model.AuthType"%>
<%@page import="com.liferay.portal.kernel.util.Tuple"%>
<%@page import="java.util.LinkedList"%>
<%@page import="AMA.OpenGov.samlProtocol.api.model.SamlBean"%>


<%
	SamlBean samlBean = (SamlBean) request.getAttribute("samlBean");
	LinkedList<Tuple> listAttr = (LinkedList<Tuple>) request.getAttribute("listAgreement");
	session.setAttribute("samlBean", samlBean);
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/jsp/login.jsp"></portlet:param>
</portlet:renderURL>
		
<portlet:actionURL name="userAgrrement" var="userAgrrementURL">
	<portlet:param name="faLevel" value="<%=samlBean.getFaaaLevel()%>" />
</portlet:actionURL>

<!-- Modal -->
<div id="agreementModal" class="modal fade" role="dialog" style="display:none;">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="main-content main-form" style="background-color: #fff;">
 	
      	<picture>
      		<source class="close-modal" media="(min-width: 580px)" srcset="/o/opengov-theme/images/close.svg" style="display: none;">
      		<img alt="Fechar modal de login"  class="close-modal" src="/o/opengov-theme/images/close-white.svg">
      	</picture>

        <div class="modal-body">

				<div class="row">
					<div class="col-sm-offset-1 col-md-11 px-0">
						<section id="section-page-header">
							<div class="row no-gutters h-100">
								<div class=" text-white bg-color-secondary page-header__title h-100 ">

								</div>
							</div>
						</section>
					</div>
				</div>
				
				<div class="row">
<!-- 					<h1 class="text-uppercase page-header__heading"> -->
<%-- 						<liferay-ui:message key="pt.ama.portlet.login.useragreement.title" /> --%>
<!-- 					</h1> -->
				
					<div class="col-md-12 col-sm-12">
						<aui:form action="<%=userAgrrementURL%>" method="post" cssClass="p-4" name="userAgreement" id="userAgreement">
							<div class="col-md-11 col-sm-11">
								<h2 class="mt-5 main-header">
									<svg class="nc-icon nc-icon-grid-24 nc-align-to-text color-primary mr-3">
										<use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-warning" />
									</svg>
									<liferay-ui:message key="pt.ama.portlet.login.useragreement.subtitle" />
								</h2>
								<p class="space-top"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Body" /></p>
								<div class="checkedlist user-list-data" role="menu">
									<div class="agreement-list">
									<%
										for (Tuple var : listAttr) {
											%>											
											<div class="panel__list"><svg class="nc-icon panel__icon color-secondary" data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 74 74"><path d="M28,58.61,2.81,33.3l2.13-2.14L28,54.32,69.11,13l2.13,2.14Z"></path></svg>
											<liferay-ui:message key="<%=var.getObject(0) != null ? var.getObject(0).toString() : ""%>"></liferay-ui:message>
											 <%=var.getObject(1) != null ? var.getObject(1).toString() : ""%></div>
												<c:if test='<%= (var.getObject(0) !=null && var.getObject(0).toString().equals("email")) %>'>
												<%--if(var.getObject(1) == null || var.getObject(1).toString().equals("")){ --%>
												<%--}--%>
												</c:if>										
											<%
										}
									%>
									</div>
									
									<aui:input disabled="false" label="Email" name="Email" id="email" placeholder="email@email.com"> 
							 			<aui:validator name="required" /> 
							 			<aui:validator name="email" /> 
							 		</aui:input>
							 		 
								</div>
								
								<p class="space-top"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Option1" /></p>
								<div class="required-radio">
									<div class="radio-liferay">
										<aui:input label="pt.ama.portlet.login.useragreement.AgreementOK" name="option1" type="radio" value="1" id="option1_OK" />                    					
									</div>	
									<div class="radio-liferay">
										<aui:input label="pt.ama.portlet.login.useragreement.AgreementKOText" name="option1" type="radio" value="2" id="option1_KO" />                       					
									</div>
									<small class="error-message"><liferay-ui:message key="pt.ama.portlet.login.option.required" /></small>
								</div>
								
								<!--  <p class="space-top"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Option2" /></p>
								<div class="required-radio">
									<div class="radio-liferay">
										<aui:input label="pt.ama.portlet.login.useragreement.AgreementOK" name="option2" type="radio" value="1" id="option2_OK" />						
									</div>
									<div class="radio-liferay">
										<aui:input label="pt.ama.portlet.login.useragreement.AgreementKO" name="option2" type="radio" value="2" id="option2_KO" />						
									</div>
									<small class="error-message"><liferay-ui:message key="pt.ama.portlet.login.option.required" /></small>
								</div>
								-->
								
								<% for (Tuple var : listAttr) { %>
									<c:set var = "field" scope = "session" value = "<%=var.getObject(0)%>"/>
									<c:if test="${field eq 'email'}">
									<p class="space-top"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Option3" /></p>
									<div class="required-radio">
										<div class="radio-liferay">
											<aui:input label="pt.ama.portlet.login.useragreement.AgreementOK" name="option3" type="radio" value="1" id="option3_OK" />					
										</div>
										<div class="radio-liferay">
											<aui:input label="pt.ama.portlet.login.useragreement.AgreementKO" name="option3" type="radio" value="2" id="option3_KO" />					
										</div>
										<small class="error-message"><liferay-ui:message key="pt.ama.portlet.login.option.required" /></small>
									</div>
									</c:if>
								<%
									}
								%>
								<p class="font-size-quinary"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Help" /> 
									<a href="https://www.ama.gov.pt/web/agencia-para-a-modernizacao-administrativa/politica-de-privacidade" target="_blank"><liferay-ui:message key="pt.ama.portlet.login.useragreement.HelpLink" /></a>.
								</p>	
							</div>
							
							<div class="text-right agreement-buttons">
								<aui:button-row>
									<aui:button type="cancel" onClick="cancel();" value="pt.ama.portlet.login.useragrement.button.cancel" cssClass="mr-4 btn-secondary"></aui:button>
									<aui:button type="submit" value="pt.ama.portlet.login.useragrement.button.confirm" id="submit" cssClass="btn-primary"></aui:button>
								</aui:button-row>
							</div>
						</aui:form>
					</div>
				</div>
				
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

$( document ).ready(function() {
	$("#agreementModal").modal("show");
});

function cancel(){
		window.location = Liferay.ThemeDisplay.getPortalURL()+"/Consulta";
}	
</script>


