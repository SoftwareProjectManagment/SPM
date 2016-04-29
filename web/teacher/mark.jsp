<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/4/3
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Mark</title>
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
                        <c:when test="${sessionScope.loginTeacher == null}">
                            <p class="navbar-text">没有权限</p>
                        </c:when>
                        <c:otherwise>

                            <li><p class="navbar-text">编号：${sessionScope.loginTeacher.id}</p></li>
                            <li><p class="navbar-text">姓名：${sessionScope.loginTeacher.name}</p></li>

                            <%--<li>
                                <form action="enroll.mvc"  class="nav-form" method="post">
                                    <button type="submit" class="btn btn-primary navbar-btn">录入小组</button>
                                </form>
                            </li>
                            <li>
                                <form action="parameter.mvc"  class="nav-form" method="post">
                                    <button type="submit" class="btn btn-primary navbar-btn">参数设置</button>
                                </form>
                            </li>--%>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <a href="/SSH_war_exploded/teacher/teacherpanel.jsp">
                    <button type="submit" class="btn btn-default navbar-btn" >返回</button>
                </a>
            </div>
        </div>
    </nav>
</header>
<div class="jumbotron">
    <div class="container text-center">
        <h1>欢迎来到小组打分界面</h1>
        <button type="button" class="btn btn-primary btn-lg" href="#deploy">
            开始打分
        </button>
    </div>
</div>

<hr>
<div class="container text-center">
    <%--DEPLOY--%>
    <section>
        <div class="well" id="deploy">
            <div class="container text-center">
                <h2>部署打分</h2>
            </div>
            <div class="container text-center">
                <form action="submit.action" class="form-inline" role="form" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <c:choose>
                                <c:when test="${team.deploytest<0}">
                                    <span class="input-group-addon">部署得分</span>
                                    <input class="form-control" name="deploypoint" type="text" placeholder="得分"/>
                                </c:when>
                                <c:otherwise>
                                    <span class="input-group-addon">部署得分</span>
                                    <input class="form-control" name="deploypoint" type="text" placeholder="得分" value="${team.deploytest}"/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">提交分数</button>
                </form>
            </div>
        </div>
    </section>
</div>

<hr>
</body>
</html>
