<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>
	<meta charset="UTF-8">
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	
	<meta property="og:title" content="OpenGov" />
	<meta property="og:type" content="website" />
	<meta property="og:url" content="http://opengov.gov.pt/" />
	<meta property="og:image" content="/o/opengov-theme/images/snippet.jpg" />
	<meta property="og:description" content="Com o objetivo de implementar a participação nacional na OGP, a Agência para a Modernização Administrativa promoveu, em Maio de 2018, a criação da Rede Nacional de Administração Aberta, para desenvolver, coordenar, executar e supervisionar o Plano de Acção Nacional de Administração Aberta.">		
	
	<@liferay_util["include"] page=top_head_include />
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	
	<link rel="shortcut icon" type="image/x-icon" href="/o/opengov-theme/images/favicon.ico">
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Muli:300,400,600,700,800,900" rel="stylesheet">
</head>

<body class="${css_class} home">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<#if showMenu>
	<@liferay.control_menu />
<#elseif is_signed_in>
	<div id="no-menu">	
		<button class="dropbtn" ><span class="glyphicon glyphicon-user"></span> ${user.fullName}</button>
		<div class="dropdown-content">
	    	<#--<a id="logout-link" href="#">Logout</a>	 -->
 		<a href="${theme_display.getPortalURL()}/consulta?p_p_id=AmaLogin&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_AmaLogin_mvcRenderCommandName=viewLogout"> Logout</a>
	    
	  	</div>
	</div>
</#if>

<div id="wrapper">

	<header class="container-fluid-1280" id="banner" role="banner">
		<div class="row">			
			
			<div id="heading"> <#-- class="navbar-header" -->
			
				<div class="flex-div">
						
					<div class="col-md-1 col-sm-1 col-xs-4 logo" style="padding: 0;">
											
						<#--  <@liferay.language_format arguments="${site_name}" key="go-to-homepage" /> -->
						
						<a class="${logo_css_class}" href="${site_default_url}" title='<@liferay.language key="go-to-homepage" />'>
							<img alt="Logo OpenGov" src="/o/opengov-theme/images/logo-open-gov.svg">
						</a>						
					</div>
				
					<div class="col-sm-11 col-xs-8" style="padding: 0;">
						<div class="col-md-10 col-sm-10 col-xs-2 hamb-menu" style="padding: 0;">
							<#if is_setup_complete>
								<button aria-controls="navigation" aria-expanded="false" class="collapsed navbar-toggle" data-target="#navigationCollapse" data-toggle="collapse" type="button">
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
			
								<#--  div class="pull-right user-personal-bar">
									<@liferay.user_personal_bar />
								</div-->
								
							</#if>
							
							<div class="menu-wrapper" id="menu-wrapper">
								<div class="close visible-xs">X</div>
								<#include "${full_templates_path}/navigation.ftl" />
							</div>
						</div>	
					
						<div class="col-md-2 col-sm-2 col-xs-10" id="search-language">
										
							<div class="navbar-form" role="search">										
																			
								<div id="lang-div">
									<#-- <img alt="<@liferay.language key="change-language" />" src="/o/opengov-theme/images/switch.svg" style="width: 13px;margin-right: 2px;margin-top: -1px;"> -->
									<#assign langId = themeDisplay.getLanguageId() /> 
									<#if langId == "pt_PT">													
										<a href="/en/${correctUrl}" title="English">English Version</a>			
									<#else>										
										<a href="/pt/${correctUrl}" title="Português">Versão Portuguesa</a>
									</#if>
								</div>
								
								<div class="search-wrapper">
								    <img alt="Icon pesquisa" class="search-icon" src="/o/opengov-theme/images/search-icon.svg">
								    <img alt="Icon fecha pesquisa" class="close-search" src="/o/opengov-theme/images/close-search.svg">
								</div>
								
							</div>
							
						</div> <#-- Termina Search Language -->
					
					</div>
				</div>
				
				<div class="search-navbar col-xs-12">
					<label for="_com_liferay_portal_search_web_portlet_SearchPortlet_keywords" style="display:none;"></label>
					<#--  --if preferences??>		
						<@liferay.search default_preferences="${preferences}" />
					</#if> -->
					<#include "${full_templates_path}/search.ftl" />
										
					<button class="btn btn-search-go" id="search-btn"><@liferay.language key="go" /></button>
					
					<#--if !has_navigation || is_omniadmin> 
						
					</#if-->
					
				</div>
				
			</div>	<#--  Termina Heading -->
						
		</div> <#--  Termina a row -->
	</header>

	<#include "${full_templates_path}/content.ftl" />
	
</div>

<footer class="container-fluid" id="footer" role="contentinfo">
	<div class="container-fluid-1280">	

		<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "barebone")>
		<#if footer1>
			<@liferay_portlet["runtime"] defaultPreferences="${freeMarkerPortletPreferences}"
			portletProviderAction=portletProviderAction.VIEW
			instanceId="footer1"
			portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
			${freeMarkerPortletPreferences.reset()}
		</#if>
		
		<#if footer2>			
			<@liferay_portlet["runtime"] defaultPreferences="${freeMarkerPortletPreferences}"
			portletProviderAction=portletProviderAction.VIEW
			instanceId="footer2"
			portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
			${freeMarkerPortletPreferences.reset()}
		</#if>
	</div>
	
</footer>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<script type="text/javascript" src="${javascript_folder}/jquery.isonscreen.min.js"></script>
<script type="text/javascript" defer src="${javascript_folder}/validator.min.js"></script>

</body>

</html>