<%@ include file="init.jsp"%>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import = "com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@page import = "com.liferay.portal.kernel.util.WebKeys" %>

<%

	ThemeDisplay td  = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	String url = td.getURLCurrent();
%>

        <!-- autentication redirects -->
        <portlet:actionURL name="register" var="authByCCURL">
            <portlet:param name="authType" value="CC" />
            <portlet:param name="URL" value="<%=url%>" />
        </portlet:actionURL>
<%--         <portlet:actionURL name="register" var="authByUserPassURL"> --%>
<%--             <portlet:param name="authType" value="SIMPLE" /> --%>
<%--         </portlet:actionURL> --%>
        <portlet:actionURL name="register" var="urlAuthByCMDURL">
            <portlet:param name="URL" value="<%=url%>" />
        </portlet:actionURL>
<%--         <portlet:actionURL name="register" var="authByCertificadosURL"></portlet:actionURL> --%>

<!-- Modal -->
<div id="loginModal" class="modal fade" role="dialog" style="display:none;">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="main-content main-form" style="background-color: #fff;">
 	
      	<picture>
      		<source class="close-modal" media="(min-width: 580px)" srcset="/o/opengov-theme/images/close.svg" style="display: none;">
      		<img alt="Fechar modal de login"  class="close-modal" src="/o/opengov-theme/images/close-white.svg">
      	</picture>

        <div class="modal-body">
            
	        <!-- AUTENTICAÇAO NOVO REGISTO -->
	
	        <div class="row">
	        
	        	<div class=" text-white bg-color-secondary page-header__title h-100 ">
	                <h1 class="text-uppercase page-header__heading">
	                    <liferay-ui:message key="pt.ama.portlet.login.registertitle" />
	                </h1>
                </div>
	
	            <div class="col-md-12 col-sm-12 main-col__authentication">
	                <div id="createUserAccount">
	                    <div class="row">
	                        <div class="col-md-8 hidden-xs hidden-sm">
	                            <p>
	                                <liferay-ui:message key="pt.ama.portlet.login.register.description1"></liferay-ui:message>
	                            </p>
<!-- 	                            <p> -->
<%-- 	                                <liferay-ui:message key="pt.ama.portlet.login.register.description2"></liferay-ui:message> --%>
<!-- 	                            </p> -->
<!-- 	                            <p> -->
<%-- 	                                <liferay-ui:message key="pt.ama.portlet.login.register.description3"></liferay-ui:message> --%>
<!-- 	                            </p> -->
	                        </div>
	                        <div class="col-md-4 authentication__img--box">
	                            <img class="authentication__img" src="${themeDisplay.getPathThemeImages()}/linkgov.png"
	                                alt="Logotipo Autenticação.gov.pt">
	                        </div>
	                    </div>
	
	                    <h2 class="service__heading mt-5">
<%-- 	                        <liferay-ui:message key="pt.ama.portlet.login.create" /> --%>
	                
<%-- 	                         <liferay-ui:message key="pt.ama.portlet.login.newregister" /> --%>
	                        
<%-- 	                        <liferay-ui:message key="pt.ama.portlet.login.inportal" /> --%>
	                    </h2>
	                    <hr>
	
	                    <div class="row" style="margin-top: 5rem;">
	
	                       <!-- Cartão 1 -->
	                            
	                         <div class="col-md-5 col-md-offset-1 d-sm-none">
	
	                            <div class="panel">
	
	                                    <div class="panel-heading-custom">
	                                        <h3>
	                                            <liferay-ui:message key="pt.ama.portlet.login.CC"></liferay-ui:message>
	                                        </h3>
	                                    </div>
	                                
	                                   <div class="authcard">
	                                       <p>
	                                           <liferay-ui:message key="pt.ama.portlet.login.register.CC.Body"></liferay-ui:message>
	                                       </p>
	                                       <aui:form cssClass="w-100 " action="<%=authByCCURL%>" id="ccForm" name="ccForm">
	                                           <button class=" btn-block panel__button bg-color-secondary" type="submit" id="callLogin" >
	                                               <span class="btn__text-md">
	                                                   <liferay-ui:message key="pt.ama.portlet.login.authenticate"></liferay-ui:message>
	                                               </span>
	
	                                                 <svg class="panel-heading-custom__submit">
	                                                     <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" />
	                                                 </svg>
	                                                 
	                                           </button>
	                                       </aui:form>
<!-- 	                                       <noscript> -->
<!-- 												<div id="noscript-fa"> -->
<!-- 													<p></p> -->
<!-- 													<input type="submit" value="register" /> -->
<!-- 												</div> -->
<!-- 										</noscript> -->
	                                   </div>
 <script type="text/javascript">
// 	$(document).ready(function() {
// 		document.ccForm.submit();
// 	});
</script> 
	                            </div>
	                        </div>
	
	                        <!-- FIM Cartão 1 -->
	
	                        <!-- Cartão 2 -->
	
	                        <div class="col-md-5 col-md-offset-1">
	                            <div class="panel">
	                
	                                <div class="panel-heading-custom">
	                                      <svg class="mr-4">
	                                         <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-key" />
	                                     </svg>
	                                    <h3>
	                                        <liferay-ui:message key="pt.ama.portlet.login.CMD"></liferay-ui:message>
	                                    </h3>
	
	                                </div>
	
	                                <div id="filterPanel6" class="panel-collapse in collapse">
	                                    <div class="authcard">
	                                        <p>
	                                            <liferay-ui:message key="pt.ama.portlet.login.register.CMD.Body"></liferay-ui:message>
	                                        </p>
	                                        <aui:form cssClass="w-100 " name="chaveMovelForm" action="<%=urlAuthByCMDURL%>" id="chaveMovelForm">
	                                        	<div class="select-arrow">
		                                            <aui:select cssClass="authcard__form" name="authType" label="<span class='hide-accessible'>Seleccione uma opção</span>">
		                                                <aui:option value="CMD_NIC">
		                                                    <liferay-ui:message key="pt.ama.portlet.login.nic"></liferay-ui:message>
		                                                </aui:option>
		                                                <aui:option value="CMD_PASSPORT">
		                                                    <liferay-ui:message key="pt.ama.portlet.login.passport"></liferay-ui:message>
		                                                </aui:option>
		                                            </aui:select>
												</div>
	                                            <button class=" btn-block panel__button bg-color-secondary" type="submit">
	                                                <span class="btn__text-md">
	                                                    <liferay-ui:message key="pt.ama.portlet.login.authenticate"></liferay-ui:message>
	                                                </span>
	
	                                                 <svg class="panel-heading-custom__submit">
	                                                     <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" />
	                                                 </svg>
	                                            </button>
	                                             
	                                        </aui:form>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	
	                        <!-- FIM Cartão 2 -->
	
	
	<!--                         Cartão 3 -->
	
	<!--                         <div class="col-md-3"> -->
	<!--                             <div class="panel"> -->
	
	<!--                                 <a class="panel-trigger" data-toggle="collapse" data-parent="#accordion" href="#filterPanel7"> -->
	<!--                                     <div class="panel-heading-custom"> -->
	<!--                                         <svg class="mr-4"> -->
	<%--                                             <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-profile" /> --%>
	<!--                                         </svg> -->
	<!--                                         <h3> -->
	<%--                                             <liferay-ui:message key="pt.ama.portlet.login.Simples"></liferay-ui:message> --%>
	<!--                                         </h3> -->
	
	<!--                                         <svg  class="panel-heading__arrow"> -->
	<%--                                                 <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow-down" /> --%>
	<!--                                         </svg> -->
	<!--                                     </div> -->
	<!--                                 </a> -->
	
	
	<!--                                 <div id="filterPanel7" class="panel-collapse in collapse"> -->
	<!--                                     <div class="authcard"> -->
	<!--                                         <p> -->
	<%--                                             <liferay-ui:message key="pt.ama.portlet.login.register.Simples.Body"></liferay-ui:message> --%>
	<!--                                         </p> -->
	<%--                                         <aui:form cssClass="w-100" action="<%=authByUserPassURL%>" id="userForm" name="userForm" label="<span class='hide-accessible'>Seleccione uma opção</span>"> --%>
	<!--                                               <button class=" btn-block panel__button bg-color-secondary" type="submit"> -->
	<!--                                                 <span class="btn__text-md"> -->
	<%--                                                     <liferay-ui:message key="pt.ama.portlet.login.registerButton"></liferay-ui:message> --%>
	<!--                                                 </span> -->
	
	<!--                                                <svg class=" panel-heading-custom__submit"> -->
	<%--                                                     <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" /> --%>
	<!--                                                 </svg> -->
	<!--                                             </button> -->
	<%--                                         </aui:form> --%>
	<!--                                     </div> -->
	<!--                                 </div> -->
	<!--                             </div> -->
	<!--                         </div> -->
	
	<!--                         FIM Cartão 3 -->
	
	<!--                         Cartão 4 -->
	
	<!--                         <div class="col-md-3"> -->
	<!--                             <div class="panel"> -->
	
	<!--                                 <a class="panel-trigger" data-toggle="collapse" data-parent="#accordion" href="#filterPanel8"> -->
	<!--                                     <div class="panel-heading-custom"> -->
	<!--                                          <svg class="mr-4"> -->
	<%--                                             <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-medal" /> --%>
	<!--                                         </svg> -->
	<!--                                         <h3> -->
	<%--                                             <liferay-ui:message key="pt.ama.portlet.login.Certificate"></liferay-ui:message> --%>
	<!--                                         </h3> -->
	
	<!--                                         <svg  class="panel-heading__arrow"> -->
	<%--                                                 <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow-down" /> --%>
	<!--                                         </svg> -->
	<!--                                     </div> -->
	<!--                                 </a> -->
	
	
	<!--                                 <div id="filterPanel8" class="panel-collapse in collapse"> -->
	<!--                                     <div class="authcard"> -->
	<!--                                         <p> -->
	<%--                                             <liferay-ui:message key="pt.ama.portlet.login.register.Certificate.Body"></liferay-ui:message> --%>
	<!--                                         </p> -->
	<%--                                         <aui:form cssClass="w-100 " name="certificadoForm" action="<%= authByCertificadosURL %>" id="certificadoForm"> --%>
	<!-- 											<div class="select-arrow">	 -->
	<%--                                             <aui:select class="authcard__form" cssClass="authcard__form" name="authType" label="<span class='hide-accessible'>Seleccione uma opção</span>"> --%>
	<%--                                                 <aui:option value="NOTARY"> --%>
	<%--                                                     <liferay-ui:message key="pt.ama.portlet.login.Notary"></liferay-ui:message> --%>
	<%--                                                 </aui:option> --%>
	<%--                                                 <aui:option value="LAWYER"> --%>
	<%--                                                     <liferay-ui:message key="pt.ama.portlet.login.Lawer"></liferay-ui:message> --%>
	<%--                                                 </aui:option> --%>
	<%--                                                 <aui:option value="SOLICITATOR"> --%>
	<%--                                                     <liferay-ui:message key="pt.ama.portlet.login.Solicitor"></liferay-ui:message> --%>
	<%--                                                 </aui:option> --%>
	<%--                                             </aui:select> --%>
	<!--                                             </div> -->
	
	
	<!--                                             <button class="btn-block panel__button bg-color-secondary" type="submit"> -->
	<!--                                                 <span class="btn__text-md"> -->
	<%--                                                     <liferay-ui:message key="pt.ama.portlet.login.registerButton"></liferay-ui:message> --%>
	<!--                                                 </span> -->
	
	<!--                                                 <svg class=" panel-heading-custom__submit"> -->
	<%--                                                     <use href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-arrow_right" /> --%>
	<!--                                                 </svg> -->
	<!--                                             </button> -->
	<%--                                         </aui:form> --%>
	<!--                                     </div> -->
	<!--                                 </div> -->
	<!--                             </div> -->
	<!--                         </div> -->
	                        <!-- FIM Cartão 4 -->
	
	
	                    </div>
	                </div>
	
	                <!-- 
	                <div class="serviceboxed">
	
	                    <div class="serviceboxed__info">
	
	                        <h4 class="serviceboxed__heading">
	                            <liferay-ui:message key="pt.ama.portlet.login.questionsblock.title" />
	                        </h4>
	
	                        <p class="mb-3 mt-3">
	                            <liferay-ui:message key="pt.ama.portlet.login.questionsblock" />
	                        </p>
	                    </div>
	
	
	                    <div class="serviceboxed__buttons">
	
	                        <a onclick="controlFloatWindow($(this))" class="button button--secondary mr-3" data-rel="chatBot" data-action="to_open">
	                            <svg class="nc-icon nc-icon-grid-24 nc-align-to-text color-secondary">
	                                <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-chat" />
	                            </svg>
	                            <span class="pl-3">
	                                <liferay-ui:message key="pt.ama.portlet.login.chat" />
	                            </span>
	                        </a>
	
	                        <a onclick="controlFloatWindow($(this))" class="button button--secondary ml-3" data-rel="click2call" data-action="to_open">
	                            <svg class="nc-icon nc-icon-grid-24 nc-align-to-text color-secondary">
	                                <use xlink:href="${themeDisplay.getPathThemeImages()}/icons/sprite.svg#icon-phone" />
	                            </svg>
	                            <span class="pl-3">
	                                <liferay-ui:message key="pt.ama.portlet.login.call" />
	                            </span>
	                        </a>
	                    </div>
	
	                </div>-->
	
	            </div>
	
	            <div class="d-sm-none col-md-1">
	                &nbsp
	            </div>
	        </div>
	        
            </div>
            </div>
		</div>
	</div>
</div>