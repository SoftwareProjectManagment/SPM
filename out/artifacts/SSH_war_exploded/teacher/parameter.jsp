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
        <h1>欢迎来到参数设置界面</h1>
        <button type="button" class="btn btn-primary btn-lg" href="#">
            开始设置参数
        </button>
    </div>
</div>
<hr>
<div class="container text-center">
    <div class="well">
        <%--                   完成这里的Action                    --%>
        <form action="" method="post">
            <h3>配置部署IP地址</h3>
            <div class="row">
                <div class="col-sm-5">
                </div>
                <div class="col-sm-2">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">IP地址1</span>
                        <input type="text" class="form-control" aria-describedby="basic-addon1" name="IPOne">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-5">
                </div>
                <div class="col-sm-2">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon3">IP地址2</span>
                        <input type="text" class="form-control" aria-describedby="basic-addon1" name="IPTwo">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-5">
                </div>
                <div class="col-sm-2">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon5">IP地址3</span>
                        <input type="text" class="form-control" aria-describedby="basic-addon1" name="IPThree">
                    </div>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">提交IP地址修改</button>
        </form>
    </div>
</div>
<hr>
<div class="container text-center">
    <div class="well">
        <form action="#" method="post">
            <h3>配置部署IP地址</h3>
            <button type="submit" class="btn btn-primary">提交IP测试用例修改</button>
        </form>
    </div>
</div>
</body>
</html>
