<%@ include file="init.jsp"%>
<%@ page import="AMA.OpenGov.samlProtocol.api.model.SamlBean" %>

<%-- <%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%> --%>

<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> --%>

<%
System.out.println("Chamada registerUser.jsp");
	SamlBean samlBean = (SamlBean) request.getAttribute("samlBean");
System.out.println(" registerUser samlBean"+samlBean);
	session.setAttribute("samlBean", samlBean);
System.out.println("Fim registerUser.jsp");
	
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/jsp/login.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="registerUser" var="registerUserURL"></portlet:actionURL>


<div class="row">
	<div class="col-sm-offset-1 col-md-11 px-0">
		<section id="section-page-header">
			<div class="row no-gutters h-100">
				<div
					class=" text-white bg-color-secondary page-header__title h-100 ">
					<h1 class="text-uppercase page-header__heading">
						<liferay-ui:message key="pt.ama.portlet.login.registeruser.title" />
					</h1>
				</div>
			</div>
		</section>
	</div>
</div>

<div class="row">
	<div class="col-md-1 col-sm-1 bg-color-grey-light-1 col__block hidden-xs">&nbsp</div>

	<div class="col-md-10 col-sm-11">
		<aui:form action="<%=registerUserURL%>" cssClass="p-4" name="userAgreement" id="userAgreement">
			<div class="col-md-8 col-sm-11">
				<h2 class="mt-5 main-header">
					<svg class="nc-icon nc-icon-grid-24 nc-align-to-text color-primary mr-3">
						<use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-warning" />
					</svg>
					<liferay-ui:message key="pt.ama.portlet.login.useragreement.subtitle" />
				</h2>
				<p class="py-5"><liferay-ui:message key="pt.ama.portlet.login.useragreement.infoText" /></p>
				<p class="pb-4"><liferay-ui:message key="pt.ama.portlet.login.registUser.servicesTitle" /></p>
				<div class="checkedlist user-list-data pb-5">
					<ul class="list_user_service">						
						<li class="panel__list">
							<svg class="nc-icon panel__icon color-secondary" id="icon1" data-name="icon1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 74 74"><path d="M28,58.61,2.81,33.3l2.13-2.14L28,54.32,69.11,13l2.13,2.14Z"></path></svg>
							<liferay-ui:message key="pt.ama.portlet.login.registUser.services1" />
						</li>
						<li class="panel__list"> 
							<svg class="nc-icon panel__icon color-secondary" id="icon2" data-name="icon2" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 74 74"><path d="M28,58.61,2.81,33.3l2.13-2.14L28,54.32,69.11,13l2.13,2.14Z"></path></svg>
							<liferay-ui:message key="pt.ama.portlet.login.registUser.services2" />
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-5 col-sm-11 pb-5">
				<fieldset>
					<legend class="hide-accessible"><liferay-ui:message key="pt.ama.portlet.reserverArea.firstName"/> / <liferay-ui:message key="pt.ama.portlet.reserverArea.lastName"/></legend>
					<aui:input name="firstName" type="text" value='<%=samlBean.getFirstName()%>' />
					<aui:input name="lastName" type="text" 	value='<%=samlBean.getLastName()%>' />
					<div class="pt-4 pb-4"><liferay-ui:message key="pt.ama.portlet.login.registUser.labelEmail" /></div>
					<div><%=samlBean.getEmailAddress()%></div>
				</fieldset>
			</div>
			<div class="col-md-8 col-sm-11">

				<p class="py-5"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Option1" /></p>
				<div class="required-radio">
					<div class="radio-liferay">
						<aui:input label="pt.ama.portlet.login.useragreement.AgreementOK" name="option1" type="radio" value="1" id="option1_OK" />                    					
					</div>	
					<div class="radio-liferay">
						<aui:input label="pt.ama.portlet.login.useragreement.AgreementKOText" name="option1" type="radio" value="2" id="option1_KO" />                       					
					</div>
					<span class="error-message"><liferay-ui:message key="pt.ama.portlet.login.option.required" /></span>
				</div>
				<p class="py-5"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Option2" /></p>
				<div class="required-radio">
					<div class="radio-liferay">
						<aui:input label="pt.ama.portlet.login.useragreement.AgreementOK" name="option2" type="radio" value="1" id="option2_OK" />						
					</div>
					<div class="radio-liferay">
						<aui:input label="pt.ama.portlet.login.useragreement.AgreementKO" name="option2" type="radio" value="2" id="option2_KO" />						
					</div>
					<span class="error-message"><liferay-ui:message key="pt.ama.portlet.login.option.required" /></span>
				</div>
				<p class="py-5"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Option3" /></p>
				<div class="required-radio">
					<div class="radio-liferay">
						<aui:input label="pt.ama.portlet.login.useragreement.AgreementOK" name="option3" type="radio" value="1" id="option3_OK" />					
					</div>
					<div class="radio-liferay">
						<aui:input label="pt.ama.portlet.login.useragreement.AgreementKO" name="option3" type="radio" value="2" id="option3_KO" />					
					</div>
					<span class="error-message"><liferay-ui:message key="pt.ama.portlet.login.option.required" /></span>
				</div>
				<p class="p-5 ml-3 font-size-quinary"><liferay-ui:message key="pt.ama.portlet.login.useragreement.Help" /> <a href="/" target:"_blank"><liferay-ui:message key="pt.ama.portlet.login.useragreement.HelpLink" /></a>.</p>	
			</div>
			<div class="text-right pt-3 pb-5">
				<aui:button-row>
					<aui:button type="cancel" onClick="<%= viewURL.toString() %>" value="pt.ama.portlet.login.useragrement.button.cancel" cssClass="mr-4 btn-secondary"></aui:button>
					<aui:button type="submit" value="pt.ama.portlet.login.useragrement.button.confirm" id="submit" cssClass="btn-primary"></aui:button>
				</aui:button-row>
			</div>
		</aui:form>
	</div>
	<div class="col-md-1">&nbsp</div>
</div>
