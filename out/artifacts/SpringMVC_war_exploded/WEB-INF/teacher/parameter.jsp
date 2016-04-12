<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/16
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Parameter</title>
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
                                <li><p class="navbar-text">编号：${result.id}</p></li>
                                <li><p class="navbar-text">姓名：${result.name}</p></li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <form action="teacherpanel.mvc" class="nav-form navbar-right" method="get" role="button">
                    <button type="submit" class="btn btn-default navbar-btn" >返回</button>
                </form>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
