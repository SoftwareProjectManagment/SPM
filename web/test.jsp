<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/4/18
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
123!
<s:iterator value="#session.resultList" var="teacher">
    <p>${teacher.id}</p>
    <p>${teacher.name}</p>
</s:iterator>
</body>
</html>
