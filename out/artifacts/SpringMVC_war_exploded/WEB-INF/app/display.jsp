<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/12/26
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<c:choose>
    <c:when test="${empty resultList}">
        <p>No Record</p>
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>ID</th><th>Name</th><th>Score</th><th>Lesson</th>
            </tr>
            <c:forEach var="result" items="${resultList}">
                <tr>
                    <td>${result.id}</td>
                    <td>${result.name}</td>
                    <td>${result.score}</td>
                    <td>${result.lesson}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<form:form method="POST" action="/SpringMVC_war_exploded/">
    <input type="submit" value="Back"/>
</form:form>
</body>
</html>
