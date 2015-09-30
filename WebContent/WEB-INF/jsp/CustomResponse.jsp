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

<c:forEach items="${servicesMap}" var="svcMap">
    <c:forEach items="${svcMap.value.operationList}" var="oprList">
        <c:if test="${oprList.name == selectedOperation}">
        
        <div class="container1 clearfix">
            <div id="leftSection">
                <div class="t1">Select the Key Element</div>
                <br />
                <div class="fltLeft clearfix">
                    &nbsp;&nbsp;                    
                    <select id="keyElementVal">
                    <c:forEach items="${oprList.keyElements}" var="keyElements">
                        <option value="${keyElements}">${keyElements}</option>
                     </c:forEach>
                     </select>       
                </div>
            </div>
        <div id="middleSection1">
            <img src="images/try4.JPG"></img>
        </div>
        <div id="rightSection1">
        
            <div class="t1">Enter the value</div>
            <br />
            <div class="fltLeft">
                <input id="customVal" type="text" value""></input>
            </div>
        </div>
        <div id="middleSection2">
            <img src="images/try4.JPG"></img>
        </div>
        <div id="rightSection2">
            <div class="t1">Response:</div>
            <br />
            <div class="fltLeft">
                <textarea id="customResponse" rows="25" cols="69" value="${oprList.defaultGenResponse}" ></textarea>
            </div>
        </div>    
    </div>
     <div class="container2">
         <span id="subsection1">
            <a href="#" id="mainMenu"><input type="submit" value="<< Back to Main Menu"/></a>
        </span>
        <span>
            <a href="#" id="showSavedHistory"><input type="submit" value="<< ShowStoredResponse"/></a>
        </span>
        <span id="subsection2">
            <a href="#"><input id="saveCustomResp" type="submit" value="Save It !!"/></a>
            <span id="ajaxLoadCustomResp"></span>            
        </span>  
     </div>
     
      </c:if>
    </c:forEach>
</c:forEach>  