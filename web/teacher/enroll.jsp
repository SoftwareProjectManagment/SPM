<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/16
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Enroll</title>
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
        <h1>欢迎来到小组信息录入界面</h1>
        <button type="button" class="btn btn-primary btn-lg" href="#">
            开始录入小组信息
        </button>
    </div>
</div>
    <hr>
<div class="container text-center">
<div class="well">
    <s:form action="enrollfinish" method="post">
        <div class="row">
            <div class="col-sm-4">

            </div>
            <div class="col-sm-2">
                <h4>小组编号</h4>
            </div>
            <div class="col-sm-2">
                <label for="team-number" class="sr-only">teamNumber</label>
                <select class="form-control" id="team-number" name="teamNumber">
                    <c:forEach var="noRegister" items="${sessionScope.noRegisterList}">
                        <option value=${noRegister}>${noRegister}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <h3>下面填写组员信息，第一个人是组长</h3>
        <div class="row">
            <div class="col-sm-5">
                </div>
            <div class="col-sm-2">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">学号</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon1" name="numberOne">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-5">
            </div>
            <div class="col-sm-2">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon3">学号</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon1" name="numberTwo">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-5">
            </div>
            <div class="col-sm-2">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon5">学号</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon1" name="numberThree">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-5">
            </div>
            <div class="col-sm-2">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon7">学号</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon1" name="numberFour">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-5">
            </div>
            <div class="col-sm-2">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon9">学号</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon1" name="numberFive">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-5">
            </div>
            <div class="col-sm-2">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon11">学号</span>
                    <input type="text" class="form-control" aria-describedby="basic-addon1" name="numberSix">
                </div>
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">保存组员信息</button>
    </s:form>
</div>
</div>
<hr>



</body>
</html>
