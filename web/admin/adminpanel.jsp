<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/4/3
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>AdminPanel</title>
    <link rel="stylesheet" href="/SSH_war_exploded/bootstrap/css/bootstrap.min.css">

    <style>
        body {
            padding-top : 50px;
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#example-nav-collapse" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">欢迎登陆</a>
            </div>

            <div class="collapse navbar-collapse" id="example-nav-collapse">
                <ul class="nav navbar-nav">
                    <c:choose>
                        <%--modify--%>
                        <c:when test="${sessionScope.loginAdmin == null}">
                            <p class="navbar-text">没有权限</p>
                        </c:when>
                        <c:otherwise>
                            <%--modify--%>
                            <li><p class="navbar-text">编号：${sessionScope.loginAdmin.id}</p></li>
                            <li><p class="navbar-text">姓名：${sessionScope.loginAdmin.name}</p></li>
                            <%--<li>
                                <form action="enroll.action"  class="nav-form" method="post">
                                    <button type="submit" class="btn btn-primary navbar-btn">录入小组</button>
                                </form>
                            </li>
                            <li>
                                <form>
                                    <a href="/SSH_war_exploded/teacher/parameter.jsp">
                                        <button type="submit" class="btn btn-primary navbar-btn">参数设置</button>
                                    </a>
                                </form>
                            </li>--%>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <form action="logout.action" class="nav-form navbar-right" method="post" role="button">
                    <button type="submit" class="btn btn-default navbar-btn" >退出</button>
                </form>
            </div>
        </div>
    </nav>
</header>

<div class="container">
    <div class="jumbotron">
        <h1>管理员控制面板</h1>
        <hr/>
        <c:choose>
            <c:when test="${sessionScope.loginAdmin == null}">
                <form action="" method="post">
                    <button type="submit" class="btn btn-primary" disabled="disabled">修改用户列表</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="userinfo.action" method="post">
                    <button type="submit" class="btn btn-primary">修改用户列表</button>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</body>
</html>
