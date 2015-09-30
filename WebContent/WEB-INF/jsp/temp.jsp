<%@ taglib prefix="c" uri="/WEB-INF/tlds/c-rt.tld" %>
<%@ page import="com.mockservice.domain.MockAppContext"%>
<% 
    MockAppContext appContext = (MockAppContext)request.getSession().getAttribute("mainObj"); 
    pageContext.setAttribute("MessageBean", appContext, PageContext.PAGE_SCOPE);
 %>

<div id="content1">
    <div id="leftPanel">
        <span >Please provide the URL of the WSDL below</span>
    </div>
  </div>    
<%-- <c:if test="${not empty MessageBean}">
${MessageBean.helloString}</c:if>
</center>--%>




