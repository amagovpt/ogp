<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.journal.service.*"%>
<%@ page import="com.liferay.journal.model.JournalArticle"%>
<%@ page import="java.util.List"%>
<%-- <%@ page import="com.liferay.portal.kernel.model.User"%> --%>
<%-- <%@ page import="com.liferay.portal.kernel.util.*"%> --%>
<%-- <%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%> --%>
<%-- <%@ page import="com.liferay.portal.kernel.util.*"%> --%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page import="com.liferay.journal.util.comparator.ArticleDisplayDateComparator"%>





<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%-- <%@page import="com.liferay.sample.service.EmployeeLocalServiceUtil"%> --%>
<%-- <%@page import="com.liferay.sample.model.Employee"%> --%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.liferay.portal.util.PortalUtil"%> --%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="pt.com.ama.search.*"%>
<%-- <%@page import="com.test.EmployeeHelper"%> --%>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />