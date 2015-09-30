<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=UTF-8"%>
<%@page
    import="java.util.Map,
    com.mockservice.domain.ServiceFactory,
    com.mockservice.domain.Service,
    java.net.URL"%>

<%@ taglib prefix="c" uri="/WEB-INF/tlds/c-rt.tld"%>

<%
ServiceFactory serviceFactory = ServiceFactory.getInstance();
Map serviceMap =  serviceFactory.getServiceMap();
String selectedService = (String)request.getAttribute("selectedService");
String domain = new URL(request.getRequestURL().toString()).getHost();
String serviceEndpoint = "http://"+domain+":"+request.getLocalPort()+request.getContextPath()+"/serviceName/"+selectedService;
System.out.println("##### The domain is# "+domain);
pageContext.setAttribute("servicesMap", serviceMap, PageContext.PAGE_SCOPE);
pageContext.setAttribute("endpointURL",serviceEndpoint,PageContext.PAGE_SCOPE);
%>

<c:if test="${not empty selectedOperation}">
<div id="displayBox1">
    <span class="t1">Service Name:</span>
    <span class="spacepad20"/>
    <span class="serviceFont"><c:out value="${selectedService}"/></span>
</div>
<div id="displayBox2">
    <span class="t1">Operation</span>
    <span class="spacepad20"/>
    <span class="spacepad20"/>
    <span class="spacepad20"/>
    <span class="OperationFont"><c:out value="${selectedOperation}"/></span>
</div>
<c:forEach items="${servicesMap}" var="svcMap">
    <c:forEach items="${svcMap.value.operationList}" var="oprList">
        <c:if test="${oprList.name == selectedOperation}">
            <div id="displayBox3">
                <span class="t1">Service URL:</span>
                <span class="OperationFont"><c:out value="${endpointURL}"/></span>
            </div>
            <div id="displayBox4" class="topPad">
                <span class="t2"><a id="ctag" href="#">Click here to customize the response based on a key element</a></span>
            </div>
            
            <div id="displayBox4">
                <span class="t1">Default Response:</span>
            </div>
            <div id="displayBox4">
                <textarea id="defaultResponse" rows="18" cols="72"><c:out value="${oprList.defaultGenResponse}"/></textarea>
            </div>
            <div class="topPad">
                <a href="#"><input type="submit" class="saveResp" value="Save Default Response"/></a>
                <span id="ajaxLoad"></span>
            </div>
         </c:if>
     </c:forEach> 
</c:forEach>
</c:if>