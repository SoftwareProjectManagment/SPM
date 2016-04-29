<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/8
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>StudentPanel</title>
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
                        <c:when test="${sessionScope.loginStudent == null}">
                            <p class="navbar-text">没有权限</p>
                        </c:when>
                        <c:otherwise>
                            <p class="navbar-text">学号：${sessionScope.loginStudent.id}</p>
                            <p class="navbar-text">姓名：${sessionScope.loginStudent.name}</p>
                            <p class="navbar-text">组号：${sessionScope.loginStudent.groupnum}</p>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <s:form action="logout" class="nav-form navbar-right" method="post" role="button">
                    <button type="submit" class="btn btn-default navbar-btn" >退出</button>
                </s:form>

            </div>

        </div>
    </nav>

</header>

<div class="container">
    <div class="jumbotron">
        <h1>学生控制面板</h1>
        <hr/>
        <c:choose>
            <c:when test="${sessionScope.loginStudent == null}">
                <s:form action="checkdeploy" method="post">
                    <button type="submit" class="btn btn-primary" disabled="disabled">开始安装部署系统</button>
                </s:form>
                <a href="student/score.jsp">
                    <button  class="btn btn-primary" disabled="disabled">查看成绩</button>
                </a>
            </c:when>
            <c:otherwise>
                <s:form action="checkdeploy" method="post">
                    <button type="submit" class="btn btn-primary">开始安装部署系统</button>
                </s:form>
                <a href="student/score.jsp">
                    <button  class="btn btn-primary">查看成绩</button>
                </a>
            </c:otherwise>
        </c:choose>
        </div>
</div>
</body>
</html>
