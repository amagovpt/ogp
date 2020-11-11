<#--
This file allows you to override and define new FreeMarker variables.
-->

<#assign footer1 = getterUtil.getBoolean(theme_settings["footer1"])>
<#assign footer2 = getterUtil.getBoolean(theme_settings["footer2"])>
<#assign captcha = getterUtil.getString(theme_settings["captcha"])>

<#assign correctUrl = themeDisplay.getURLCurrent()?keep_after_last("/en/") />

<#if (correctUrl?is_string && correctUrl == "")>
	<#assign correctUrl = themeDisplay.getURLCurrent()?keep_after_last("/pt/") />
</#if>

<#assign permission_checker = themeDisplay.getPermissionChecker() />
<#assign is_omniadmin = permission_checker.isOmniadmin() />


<#assign isAdmin = false>
<#assign isContentReviewer = false>
<#assign showMenu = false>

<#if is_signed_in>
	<#assign usrRoles = user.getRoles()>
	<#list usrRoles as usrRole>
	   	<#if usrRole.getName() == "Administrator">
	   		<#assign isAdmin = true>
	   	<#elseif usrRole.getName() == "Portal Content Reviewer">	   		
	   		<#assign isContentReviewer = true>
		</#if>
	</#list>
</#if>

<#if isAdmin || isContentReviewer>
	<#assign showMenu = true>
</#if>