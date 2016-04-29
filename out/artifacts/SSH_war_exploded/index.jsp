<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 2015/12/25
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="/SSH_war_exploded/bootstrap/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>请登录</h1>
        <div class="input-group">
            <s:form name="loginFrom" method="POST" action="login">
                <s:textfield name="userForm.username" placeholder="用户名" class="form-control" />
                <s:password name="userForm.password" placeholder="密码" class="form-control"/>
                <s:submit value="登录" align="left" class="btn btn-primary"/>
            </s:form>
            <%--<s:form name="registerForm" method="POST" action="register">
                <s:submit value="注册" class="btn btn-primary"/>
            </s:form>--%>
        </div>
    </div>
    <%--<s:if test='message == "登陆失败"'>
        <script  type="text/javascript">
            var msg = "${message}";
            alert(msg);
        </script>
    </s:if>--%>
</div>
</body>
</html>
