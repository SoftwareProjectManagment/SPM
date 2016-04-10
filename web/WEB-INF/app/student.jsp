
<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/12/20
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Student</title>
</head>
<body>
<h2>Student Information</h2>
<form:form method="POST" action="/SpringMVC_war_exploded/addStudent.mvc">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="score">Score</form:label></td>
            <td><form:input path="score" /></td>
        </tr>
        <tr>
            <td><form:label path="lesson">Lesson</form:label></td>
            <td>
                <form:select path="lesson">
                    <form:option value="Chinese">Chinese</form:option>
                    <form:option value="Math">Math</form:option>
                    <form:option value="English">English</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
