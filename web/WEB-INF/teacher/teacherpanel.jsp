<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/14
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>TeacherPanel</title>
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
                            <li>
                                <form action="enroll.mvc"  class="nav-form" method="post">
                                    <button type="submit" class="btn btn-primary navbar-btn">录入小组</button>
                                </form>
                            </li>
                            <li>
                                <form action="parameter.mvc"  class="nav-form" method="post">
                                    <button type="submit" class="btn btn-primary navbar-btn">参数设置</button>
                                </form>
                            </li>
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
        <h1>教师控制面板</h1>
        <hr/>
        <c:choose>
            <c:when test="${empty resultList}">
                <form action="" method="post">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">小组概要</div>
                        <!-- Table -->
                        <table class="table">
                            <thead>
                            <tr><th>组号</th><th>系统部署</th><th>首页&链接</th><th>功能测试</th><th>性能测试</th><th>代码检测1</th><th>代码检测2</th><th>文档检测</th></tr>
                            </thead>
                            <tbody>
                            <c:forEach var="team" items="${teamList}">
                            <tr>
                                <th scope="row">${team.id}</th>
                                <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <button type="submit" class="btn btn-primary" disabled="disabled">查看成绩</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="" method="post">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">小组概要</div>
                        <!-- Table -->
                        <table class="table">
                            <thead>
                            <tr><th>组号</th><th>系统部署</th><th>首页&链接</th><th>功能测试</th><th>性能测试</th><th>代码检测1</th><th>代码检测2</th><th>文档检测</th><th>选择</th></tr>
                            </thead>
                            <tbody>
                            <c:forEach var="team" items="${teamList}">
                                <tr>
                                    <th scope="row">${team.id}</th>
                                    <c:choose>
                                        <c:when test="${team.deploytest < 0}">
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${team.deploytest}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${team.frontpagetest < 0}">
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${team.frontpagetest}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${team.functiontest < 0}">
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${team.functiontest}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${team.performancetest < 0}">
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${team.performancetest}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${team.codetestone < 0}">
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${team.codetestone}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${team.codetestwo < 0}">
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${team.codetestwo}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${team.documentest < 0}">
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${team.documentest}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td><input name="chooseTeam" type="radio"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <button type="submit" class="btn btn-primary">进入小组打分页面</button>
                </form>
            </c:otherwise>
        </c:choose>
        <hr/>
        <form action="" class="form-inline" role="form" method="post">
        <div class="form-group">
            <h2>选择要查看信息的小组</h2>
            <label for="choose-team" class="sr-only">选择要查看信息的小组</label>
            <select class="form-control" id="choose-team" name="scoreForTeam">
                <c:forEach var="team" items="${teamList}">
                    <option value=${team.id}>${team.id}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary">进入小组信息界面</button>
        </div>
        </form>
    </div>
</div>



<%--<script src="bootstrap/jquery-2.2.1.min.js"></script>
<script src="bootstrap/bootstrap.file-input.js"></script>--%>

</body>
</html>
