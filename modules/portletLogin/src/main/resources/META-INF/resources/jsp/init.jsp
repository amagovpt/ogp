<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>




<!-- teste comentarios -->

<%-- <%@ page import="com.liferay.portal.comment.display.context.CommentDisplayContextProviderUtil" %><%@ --%>
<%-- page import="com.liferay.portal.comment.display.context.util.DiscussionRequestHelper" %><%@ --%>
<%-- page import="com.liferay.portal.comment.display.context.util.DiscussionTaglibHelper" %> --%>
<%@
page import="com.liferay.portal.kernel.comment.CommentConstants" %><%@
page import="com.liferay.portal.kernel.comment.CommentManagerUtil" %><%@
page import="com.liferay.portal.kernel.comment.Discussion" %><%@
page import="com.liferay.portal.kernel.comment.DiscussionComment" %><%@
page import="com.liferay.portal.kernel.comment.DiscussionCommentIterator" %><%@
page import="com.liferay.portal.kernel.comment.DiscussionPermission" %><%@
page import="com.liferay.portal.kernel.comment.WorkflowableComment" %><%@
page import="com.liferay.portal.kernel.comment.display.context.CommentSectionDisplayContext" %><%@
page import="com.liferay.portal.kernel.comment.display.context.CommentTreeDisplayContext" %><%@
page import="com.liferay.portal.kernel.service.ServiceContextFunction" %>



<%@ page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil" %><%@
page import="com.liferay.taglib.aui.AUIUtil" %><%@
page import="com.liferay.taglib.util.InlineUtil" %><%@
page import="com.liferay.taglib.util.PortalIncludeUtil" %><%@
page import="com.liferay.taglib.util.TagResourceBundleUtil" %>
<%@ page import="java.io.IOException" %>








<liferay-theme:defineObjects />
<portlet:defineObjects />






 
 

 