<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=UTF-8"%>
<%@page
    import="java.util.Map,
    com.mockservice.domain.ServiceFactory,
    com.mockservice.domain.Service"%>

<%@ taglib prefix="c" uri="/WEB-INF/tlds/c-rt.tld"%>

<%
ServiceFactory serviceFactory = ServiceFactory.getInstance();
Map serviceMap =  serviceFactory.getServiceMap();
pageContext.setAttribute("servicesMap", serviceMap, PageContext.PAGE_SCOPE);
%>
<div id="loading">
  <img id="loading-image" src="images/loading1.gif" alt="Loading..." />
</div>
<div id="content1">
    <div id="leftPanel">
    <form id="import" action="import.htm" method="post">
        <div id="inputBox1" class="t1">
            <span>Wsdl Url</span>
            <span class="spacepad" />
            <input type="text" name="serviceurl" placeholder="wsdl url" size="60"/>
        </div>
        <div id="inputBox2" class="t1">
            <span>Service Name</span>
            <input type="text" name="servicename" placeholder="Service Name" size="30"/>
        </div>
        </br>
        <div class="alignCenter">
            <input type="submit" value="Import"/>
        </div>
    </form>
    <form id="operation" action="operation.htm" method="post">
    <input type="hidden" id="svcNM" name="servicename">
    <input type="hidden" id="oprNM" name="operationname">
    </form>
        <div id="leftLowerContent">
            <c:if test="${not empty servicesMap}">
            <div id="textLowerContext">
                <span class="t1 underline">
                Services Already Loaded [Expand to view operations]
                </span>
            </div>
            </c:if>
            <div class="overflowSection">
            <c:forEach items="${servicesMap}" var="svcMap">
            <div id="${svcMap.key}">
                <a href="#" class="atag"><img src="images/plus1.png" /></a>
                <span class="serviceFont"><c:out value="${svcMap.key}"/></span>
                <c:forEach items="${svcMap.value.operationList}" var="oprList">
                <div class="collapse">
                    <span class="spacepad"/>
                    <span class="operationFont"><a href="#" class="btag" data1="${svcMap.key}" data2="${oprList.name}"><c:out value="${oprList.name}"/></a></span>
                </div>
                </c:forEach> 
                </div>
                </c:forEach>
            </div>
            
        </div>
    </div>
    <div id="middlePanel">
    </div>
  
    <div id="rightPanel">
    </div>
  
  </div> 
<div id="content2" class="collapse">
</div>
<div id="content3" class="collapse showHistory">
</div>
  