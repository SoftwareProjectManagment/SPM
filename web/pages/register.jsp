<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/12/26
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <s:form action="register" method="POST">
        <s:textfield label="UserName" name="userForm.username" />
        <s:password label="Password" name="userForm.password" />
        <s:submit value="confirm"/>
    </s:form>
</body>
</html>
