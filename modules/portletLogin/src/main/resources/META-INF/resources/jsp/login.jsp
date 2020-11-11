<%@ include file="init.jsp"%>
    <%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>


        <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

            <liferay-ui:error key="userNotFound" message="Não existe utilizador no portal. Por favor efectuar o registo" />

            <!-- login redirects -->
            <portlet:actionURL name="login" var="loginByCCURL">
                <portlet:param name="authType" value="CC" />
                <portlet:param name="location" value="listproposal" />
            </portlet:actionURL>

<%--             <portlet:actionURL name="login" var="loginByUserPassURL"> --%>
<%--                 <portlet:param name="authType" value="SIMPLE" /> --%>
<%--             </portlet:actionURL> --%>

            <portlet:actionURL name="login" var="loginByCMDURL">
            </portlet:actionURL>

<%--             <portlet:actionURL name="login" var="loginByCertificatesURL"> --%>
<%--             </portlet:actionURL> --%>

            <!-- AUTENTICAÇAO ENTRAR -->
            
            
<%--             <portlet:renderURL var="registerUserURL"> --%>
<%-- 				<portlet:param name="mvcPath" value="registerUser.jsp"></portlet:param> --%>
<%-- 			</portlet:renderURL> --%>

<%-- 			<portlet:renderURL var="createUserAccountUrl"> --%>
<%-- 				<portlet:param name="mvcPath" value="createUserAccount.jsp"></portlet:param> --%>
<%-- 			</portlet:renderURL> --%>
			
			<portlet:renderURL var="createUserAccountUrl">
				<portlet:param name="mvcRenderCommandName" value="viewCreateUserAccount"></portlet:param>
			</portlet:renderURL>
			
<%-- 			<portlet:renderURL var="logoutUrl"> --%>
<%-- 				<portlet:param name="mvcPath" value="logout.jsp"></portlet:param> --%>
<%-- 			</portlet:renderURL> --%>

<%-- 	<portlet:renderURL var="logoutUrl"> --%>
<%-- 	    <portlet:param name="mvcRenderCommandName" value="viewLogout" /> --%>
<%-- 	</portlet:renderURL> --%>

<!--  				<div class="dashboard__close "> -->
<%--                     <a class="flex-between-center " <a href="${theme_display.getPortalURL()}/en/web/opengov/processLogin?p_p_id=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortletmvcRenderCommandName=viewLogin">Entrar</a> --%>
<%--                     href="${theme_display.getPortalURL()}/pt/web/opengov/entrar?p_p_id=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortletmvcRenderCommandName=viewLogout"> --%>
                        
<!--                         <span class=""> -->
<!--                         <@liferay.language key="Logout" /> -->
<!--                         </span> -->
<!--                     </a> -->
<!--                 </div> -->

<a href="${theme_display.getPortalURL()}/web/opengov/processlogin?p_p_id=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_AMA_OpenGov_PortletLogin_portlet_PortletLoginPortlet_mvcRenderCommandName=viewLogout">Logout</a>
<a href="${theme_display.getPortalURL()}/web/opengov/processLogin?p_p_id=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortletmvcRenderCommandName=viewCreateUserAccount">Register</a>
<%-- <a href="${theme_display.getPortalURL()}/web/opengov/processlogin?p_p_id=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_AMA_OpenGov_PortletLogin_portlet_PortletLoginPortlet_mvcRenderCommandName=viewCreateUserAccount">Register</a> --%>
<%-- <a href="${theme_display.getPortalURL()}/web/opengov/processLogin?p_p_id=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortletmvcRenderCommandName=viewLogout">Logout</a> --%>
<%-- <a href="${theme_display.getPortalURL()}/web/opengov/processLogin?p_p_id=AMA_OpenGov_PortletLogin_portlet_PortletLoginPortletmvcRenderCommandName=viewCreateUserAccount">Register</a> --%>
                
                
			<div class="text-right pt-3 pb-5">
				<aui:button-row>
<%-- 					<aui:button type="cancel" onClick="<%= registerUserURL.toString() %>" value="registerUserURL" cssClass="mr-4 btn-secondary"></aui:button> --%>
					<aui:button type="cancel" onClick="<%= createUserAccountUrl.toString() %>" value="createUserAccountUrl" cssClass="mr-4 btn-secondary"></aui:button>
<%-- 					<aui:button type="cancel" onClick="<%= logoutUrl.toString() %>" value="logoutUrl" cssClass="mr-4 btn-secondary"></aui:button> --%>
				</aui:button-row>
			</div>

            <!-- PAGE HEADER START -->
            
            <div class="row">
                <div class="col-sm-offset-1 col-md-11 px-0">
                    <section id="section-page-header">
                        <div class="row no-gutters h-100">
                            <div class=" text-white bg-color-secondary page-header__title h-100 ">
                                <h1 class="text-uppercase page-header__heading">
                                    <liferay-ui:message key="Autentica��o | Entrar" />
                                </h1>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <!-- PAGE HEADER END -->

            <div class="row">

                <div class="col-md-1 col-sm-1 col__block ">
                    &nbsp
                </div>

                <div class="col-md-10 col-sm-11 main-col__authentication">
                    <div id="authentication">
                        <div class="row mb-5">
                            <div class="col-md-8 hidden-xs hidden-sm">
                                <p>
                                    <liferay-ui:message key="O processo de autentica��o ao um servi�o que lhe permite o acesso online a v�rios servi�oos p�blicos."></liferay-ui:message>
                                </p>
                                <p>
                                    <liferay-ui:message key="Seleccione a op��o de autentica��o que pretende."></liferay-ui:message>
                                </p>
                            </div>
<!--                             <div class="col-md-4 authentication__img--box"> -->
<%--                                 <img class="authentication__img" src="${themeDisplay.getPathThemeImages()}/portlets/auth/linkgov.png" --%>
<!--                                     alt="Logotipo Autentica��o.gov.pt"> -->
<!--                             </div> -->
                        </div>

                        <div class="mt-5 hidden-xs hidden-sm">
                            <h2 class="service__heading mt-5">
                                <liferay-ui:message key="Criar" />
                                
                                 <liferay-ui:message key="Autentica��o | Entrar" />
                                
                                <liferay-ui:message key="no portal" />
                            </h2>
                            <hr>
                        </div>

                        <div class="row" style="margin-top: 5rem;">


							 <!-- Cartão 1 -->
                            <div class="col-md-3 d-sm-none">


                                <div class="panel ">

                                    <a class="panel-trigger" data-toggle="collapse" data-parent="#accordion" href="#filterPanel">
                                        <div class="panel-heading-custom">
<!--                                             <svg class="mr-4"> -->
<%--                                                 <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-id" /> --%>
                                            </svg>
                                            <h3>
                                                <liferay-ui:message key="Cart�o Cidad�o"></liferay-ui:message>
                                            </h3>

                                            <svg class="panel-heading__arrow">
                                                <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow-down" />
                                            </svg>
                                        </div>
                                    </a>


                                    <div id="filterPanel" class="panel-collapse in collapse">
                                        <div class="authcard">
                                            <p>
                                                <liferay-ui:message key="Cart�o Cidad�o"></liferay-ui:message>
                                            </p>
                                            <aui:form cssClass="w-100" action="<%=loginByCCURL%>" name="login">
                                                <button class="btn-block panel__button bg-color-secondary" type="submit">
                                                    <span class="btn__text-md">
                                                        <liferay-ui:message key="Entrar no Portal"></liferay-ui:message>
                                                    </span>

<!--                                                     <svg class=" panel-heading-custom__submit "> -->
<%--                                                         <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" /> --%>
<!--                                                     </svg> -->
                                                </button>
                                                <noscript>
											<div id="noscript-fa">
												<p></p>
												<input type="submit"  />
											</div>
										</noscript>
                                            </aui:form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- FIM Cartão 1 -->

                            <div class="col-md-3">

                                <!-- Cartão 2 -->

                                <div class="panel">

                                    <a class="panel-trigger" data-toggle="collapse" data-parent="#accordion" href="#filterPanel2">
                                        <div class="panel-heading-custom">
<!--                                             <svg class="mr-4"> -->
<%--                                                 <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-key" /> --%>
<!--                                             </svg> -->
											<h3>
                                            	<liferay-ui:message key="Chave M�vel Digital"></liferay-ui:message>
											</h3>

<!--                                             <svg class="panel-heading__arrow"> -->
<%--                                                 <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow-down" /> --%>
<!--                                             </svg> -->

                                        </div>
                                    </a>


                                    <div id="filterPanel2" class="panel-collapse in collapse">
                                        <div class="authcard">
                                            <p>
                                                <liferay-ui:message key="Seleccione a nacionalidade para avan�ar."></liferay-ui:message>
                                            </p>
                                            <aui:form cssClass="w-100" name="cmd" action="<%=loginByCMDURL%>">
                                            <div class="select-arrow">
                                                <aui:select class="authcard__form form-control" cssClass="authcard__form form-control" name="authType" label="">
                                                    <aui:option value="CMD_NIC">
                                                        <liferay-ui:message key="N� de CC/BI"></liferay-ui:message>
                                                    </aui:option>
                                                    <aui:option value="CMD_PASSPORT">
                                                         <liferay-ui:message key="Passaporte"></liferay-ui:message>
                                                    </aui:option>
                                                </aui:select>
											</div>
                                                <button class=" btn-block panel__button bg-color-secondary" type="submit" onclick="<%=loginByCMDURL%>">
                                                    <span class="btn__text-md">
                                                        <liferay-ui:message key="Entrar no Portal"></liferay-ui:message>
                                                    </span>

<!--                                                     <svg class="panel-heading-custom__submit "> -->
<%--                                                         <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" /> --%>
<!--                                                     </svg> -->
                                                </button>
                                            </aui:form>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <!-- FIM Cartão 2 -->

                            <div class="col-md-3">

                                <!-- Cartão 3 -->

<!--                                 <div class="panel "> -->


<!--                                     <a class="panel-trigger" data-toggle="collapse" data-parent="#accordion" href="#filterPanel3"> -->
<!--                                         <div class="panel-heading-custom"> -->
<!--                                              <svg class="mr-4"> -->
<%--                                                 <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-profile" /> --%>
<!--                                             </svg> -->
<!-- 											<h3> -->
<%--                                             	<liferay-ui:message key="Utilizador e Senha"></liferay-ui:message> --%>
<!-- 											</h3> -->
<!--                                             <svg class="panel-heading__arrow"> -->
<%--                                                 <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow-down" /> --%>
<!--                                             </svg> -->
<!--                                         </div> -->
<!--                                     </a> -->
<!--                                     <div id="filterPanel3" class="panel-collapse in collapse"> -->
<!--                                         <div class="authcard"> -->

<!--                                             <p> -->
<%--                                                 <liferay-ui:message key="Preencha o nome de utilizador e senha para aceder � sua �rea reservada. N�o permite realizar servi�os online."></liferay-ui:message> --%>
<!--                                             </p> -->

<%--                                             <aui:form cssClass=" w-100" name="userpass" action="<%=loginByUserPassURL%>"> --%>
<%--                                                 <button onclick="<%=loginByUserPassURL%>" class="btn-block panel__button bg-color-secondary" type="submit"> --%>
<!--                                                     <span class="btn__text-md"> -->
<%--                                                         <liferay-ui:message key="Entrar no Portal"></liferay-ui:message> --%>
<!--                                                     </span> -->

<!--                                                     <svg class="panel-heading-custom__submit"> -->
<%--                                                         <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" /> --%>
<!--                                                     </svg> -->
<!--                                                 </button> -->
<%--                                             </aui:form> --%>
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->

<!--                             </div> -->

                            <!-- FIM Cartão 3 -->

                            <div class="col-md-3">

                                <!-- Cartão 4 -->

<!--                                 <div class="panel "> -->
<!--                                     <a class="panel-trigger" data-toggle="collapse" data-parent="#accordion" href="#filterPanel4"> -->
<!--                                         <div class="panel-heading-custom"> -->
<!--                                              <svg class="mr-4"> -->
<%--                                                 <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-medal" /> --%>
<!--                                             </svg> -->
<!-- 											<h3> -->
<%--                                             	<liferay-ui:message key="Certificado Digital"></liferay-ui:message> --%>
<!-- 											</h3> -->
<!--                                             <svg class="panel-heading__arrow"> -->
<%--                                                 <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow-down" /> --%>
<!--                                             </svg> -->
<!--                                         </div> -->
<!--                                     </a> -->


<!--                                     <div id="filterPanel4" class="panel-collapse in collapse"> -->
<!--                                         <div class="authcard"> -->

<!--                                             <p> -->
<%--                                                 <liferay-ui:message key="Selecione o seu perfil para aceder com o certificado."></liferay-ui:message> --%>
<!--                                             </p> -->
<%--                                             <aui:form cssClass="w-100" name="certificates" action="<%=loginByCertificatesURL.toString()%>"> --%>
<!-- 												<div class="select-arrow"> -->
<%-- 	                                                <aui:select class="authcard__form" cssClass="authcard__form" name="authType" label=""> --%>
<%-- 	                                                    <aui:option value="NOTARY"> --%>
<%-- 	                                                        <liferay-ui:message key="Not�rio"></liferay-ui:message> --%>
<%-- 	                                                    </aui:option> --%>
<%-- 	                                                    <aui:option value="LAWYER"> --%>
<%-- 	                                                        <liferay-ui:message key="Advogado"></liferay-ui:message> --%>
<%-- 	                                                    </aui:option> --%>
<%-- 	                                                    <aui:option value="SOLICITATOR"> --%>
<%-- 	                                                        <liferay-ui:message key="Solicitor"></liferay-ui:message> --%>
<%-- 	                                                    </aui:option> --%>
<%-- 	                                                </aui:select> --%>
<!-- 												 </div> -->

<!--                                                 <button class="btn-block panel__button bg-color-secondary" type="submit"> -->


<!--                                                     <span class="btn__text-md"> -->
<%--                                                         <liferay-ui:message key="Entrar no Portal"></liferay-ui:message> --%>
<!--                                                     </span> -->

<!--                                                     <svg class=" panel-heading-custom__submit"> -->
<%--                                                         <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" /> --%>
<!--                                                     </svg> -->

<!--                                                 </button> -->
<%--                                             </aui:form> --%>
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->

                                <!-- FIM Cartão 4 -->

                            </div>


                        </div>
                    </div>

                    <div class="serviceboxed">

                        <div class="serviceboxed__info">

                            <h4 class="serviceboxed__heading">
                                <liferay-ui:message key="Tem Dúvidas?" />
                            </h4>

                            <p class="mb-3 mt-3">
                                <liferay-ui:message key="Necessita de esclarecimnentos adicionais sobre este servi�o? Entre em contacto connosco:" />
                            </p>
                        </div>


                        <div class="serviceboxed__buttons">

                            <a onclick="controlFloatWindow($(this))" class="button button--secondary mr-3" data-rel="chatBot" data-action="to_open">
<!--                                 <svg class="nc-icon nc-icon-grid-24 nc-align-to-text color-secondary"> -->
<%--                                     <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-chat" /> --%>
<!--                                 </svg> -->
                                <span class="pl-3">
                                    <liferay-ui:message key="CHAT" />
                                </span>
                            </a>

                            <a onclick="controlFloatWindow($(this))" class="button button--secondary ml-3" data-rel="click2call" data-action="to_open">
<!--                                 <svg class="nc-icon nc-icon-grid-24 nc-align-to-text color-secondary"> -->
<%--                                     <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-phone" /> --%>
<!--                                 </svg> -->
                                <span class="pl-3">
                                    <liferay-ui:message key="LIGAR" />
                                </span>
                            </a>
                        </div>

                    </div>

                </div>

                <div class=" d-sm-none col-md-1">&nbsp</div>
                
            </div>
 <script type="text/javascript">
		console.log("js");
	$(document).ready(function() {
		console.log("Passa func");
		document.login.submit();
	});
</script>           