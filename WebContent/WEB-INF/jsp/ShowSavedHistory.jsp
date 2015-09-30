<%@ page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=UTF-8"%>
<%@page
    import="java.util.Map,
    com.mockservice.domain.ServiceFactory,
    com.mockservice.domain.Service"%>

<%@ taglib prefix="c" uri="/WEB-INF/tlds/c-rt.tld"%>
<div id="savedOprSection">
    <ul>
<c:forEach items="${savedResponseHistory}" var="respHistory">
        <li>${respHistory}</li>
</c:forEach>
    </ul>
    <a href="#" id="closeList"><input type="submit" value="<< Close"/></a>
    <br/> <br/>
</div>
