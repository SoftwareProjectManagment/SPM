<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/12/25
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Submitted Student Information</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Score</td>
        <td>${score}</td>
    </tr>
    <tr>
        <td>Lesson</td>
        <td>${lesson}</td>
    </tr>
</table>
<form:form method="POST" action="/SpringMVC_war_exploded/">
    <input type="submit" value="Back"/>
</form:form>
</body>
</html>
