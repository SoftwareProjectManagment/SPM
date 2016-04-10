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
    <s:form action="registerForm" method="POST">
        <s:textfield label="UserName" name="username" />
        <s:password label="Password" name="password" />
        <s:select label="chooseIdentity" name="identity" list="{'teacher','student'}"  headerKey=""/>
        <s:submit value="confirm"/>
    </s:form>
</body>
</html>
