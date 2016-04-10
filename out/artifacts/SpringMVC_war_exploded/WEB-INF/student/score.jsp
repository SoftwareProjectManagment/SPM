<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/8
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Score</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

    <style>
        body {
            padding-top : 50px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" id="main-navbar" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">欢迎登陆</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <c:choose>
                    <c:when test="${empty resultList}">
                        <p class="navbar-text">没有权限</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="result" items="${resultList}">
                            <li><p class="navbar-text">学号：${result.id}</p></li>
                            <li><p class="navbar-text">姓名：${result.name}</p></li>
                            <li><p class="navbar-text">组号：${result.groupnum}</p></li>
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
<div class="jumbotron">
    <div class="container text-center">
        <h1>欢迎来到成绩界面</h1>
    </div>
</div>

<hr>

<div class="container text-center">
    <%--SCORE--%>
    <c:choose>
        <c:when test="${empty resultList || resultList.get(0).score == -1}">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">成绩列表</div>
                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>检测项目</th>
                        <th>得分</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">系统部署</th>
                        <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">首页&链接检测</th>
                        <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">功能检测</th>
                        <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">性能检测</th>
                        <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">代码检测</th>
                        <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">文档形式检测</th>
                        <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">总分</th>
                        <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <c:forEach var="result" items="${resultList}">
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">成绩列表</div>
                    <!-- Table -->
                    <table class="table">
                        <thead>
                        <tr>
                            <th>检测项目</th>
                            <th>得分</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">系统部署</th>
                            <td>${result.deployscore}</td>
                        </tr>
                        <tr>
                            <th scope="row">首页&链接检测</th>
                            <td>${result.frontpagescore}</td>
                        </tr>
                        <tr>
                            <th scope="row">功能检测</th>
                            <td>${result.functionscore}</td>
                        </tr>
                        <tr>
                            <th scope="row">性能检测</th>
                            <td>${result.performancescore}</td>
                        </tr>
                        <tr>
                            <th scope="row">代码检测</th>
                            <td>${result.codescore}</td>
                        </tr>
                        <tr>
                            <th scope="row">文档形式检测</th>
                            <td>${result.documentscore}</td>
                        </tr>
                        <tr>
                            <th scope="row">总分</th>
                            <td>${result.score}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
<hr>
<div class="container text-center">
    <div class="well">
        <form action="studentpanel.mvc"  method="get">
            <button type="submit" class="btn btn-primary">返回学生面板</button>
        </form>
    </div>
</div>

</body>
</html>
