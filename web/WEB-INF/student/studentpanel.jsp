<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/8
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>StudentPanel</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

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
                        <c:when test="${empty resultList}">
                            <p class="navbar-text">没有权限</p>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="result" items="${resultList}">
                                <p class="navbar-text">学号：${result.id}</p>
                                <p class="navbar-text">姓名：${result.name}</p>
                                <p class="navbar-text">组号：${result.group}</p>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <form action="/SpringMVC_war_exploded/" class="nav-form navbar-right" method="post" role="button">
                    <button type="submit" class="btn btn-default navbar-btn" >退出</button>
                </form>

            </div>

        </div>
    </nav>

</header>

<div class="container">
    <div class="jumbotron">
        <h1>学生控制面板</h1>
        <hr/>
        <c:choose>
            <c:when test="${empty resultList}">
                <form action="deploy.mvc" method="post">
                    <button type="submit" class="btn btn-primary" disabled="disabled">开始安装部署系统</button>
                </form>
                <form action="score.mvc" method="post">
                    <button type="submit" class="btn btn-primary" disabled="disabled">查看成绩</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="deploy.mvc" method="post">
                    <button type="submit" class="btn btn-primary">开始安装部署系统</button>
                </form>
                <form action="score.mvc" method="post">
                    <button type="submit" class="btn btn-primary">查看成绩</button>
                </form>
            </c:otherwise>
        </c:choose>
        </div>
</div>
</body>
</html>
