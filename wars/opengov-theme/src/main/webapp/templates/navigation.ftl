<div aria-expanded="false" class="collapse navbar-collapse" id="navigationCollapse">
	<#if has_navigation && is_setup_complete>
		<nav class="${nav_css_class} site-navigation" id="navigation" role="navigation">
			<#assign preferences = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />

			<div class="navbar-center">
				<@liferay.navigation_menu default_preferences="${preferences}" />
			</div>			

		</nav>
	</#if>
</div>