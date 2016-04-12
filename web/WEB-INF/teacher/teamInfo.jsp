<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/17
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>teamInfo</title>
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

<div class="jumbotron">
    <div class="container text-center">
        <h1>欢迎来到小组信息界面</h1>
        <button type="button" class="btn btn-primary btn-lg" href="#">
            开始查看或修改小组信息
        </button>
    </div>
</div>
<hr>

<Script Language="JavaScript">
    function modify()
    {
        document.form1.action="modifyStudentInfo.mvc";
        document.form1.submit();
    }

    function delet()
    {
        document.form1.action="deleteStudentInfo.mvc";
        document.form1.submit();
    }
</Script>

<div class="container">
    <div class="jumbotron">
        <h1>小组信息面板</h1>
        <hr/>
        <c:choose>
            <c:when test="${empty resultList}">
                <form name="form1" action="" method="post">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">组员信息</div>
                        <!-- Table -->
                        <table class="table">
                            <thead>
                            <tr><th>学号</th><th>姓名</th><th>系统部署</th><th>首页&链接</th><th>功能测试</th><th>性能测试</th><th>代码检测1</th><th>代码检测2</th><th>文档检测</th></tr>
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
                <form name="form1" action="" method="post">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">小组概要</div>
                        <!-- Table -->
                        <table class="table">
                            <thead>
                            <tr><th>学号</th><th>姓名</th><th>系统部署</th><th>首页&链接</th><th>功能测试</th><th>性能测试</th><th>代码检测</th><th>文档检测</th><th>选择删除</th></tr>
                            </thead>
                            <tbody>
                            <c:set var="ordinal" value="1"/>
                            <c:forEach var="student" items="${studentList}">
                                <tr>
                                    <th scope="row">
                                        <input class="form-control" name="StudentNumber${ordinal}" type="text" value="${student.id}" style="width:120px;"/>
                                    </th>
                                    <td>
                                        <input class="form-control" name="StudentName${ordinal}" type="text" value="${student.name}" readonly="readonly" style="width:70px;"/>
                                    </td>
                                    <c:choose>
                                        <c:when test="${student.deployscore < 0}">
                                            <td>
                                                <input class="form-control" name="deployscore${ordinal}" type="text" placeholder="未打分" style="width:80px;"/>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                <input class="form-control" name="deployscore${ordinal}" type="text" value="${student.deployscore}" style="width:80px;"/>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${student.frontpagescore < 0}">
                                            <td>
                                                <input class="form-control" name="frontpagescore${ordinal}" type="text" placeholder="未打分" style="width:80px;"/>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                <input class="form-control" name="frontpagescore${ordinal}" type="text" value="${student.frontpagescore}" style="width:80px;"/>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${student.functionscore < 0}">
                                            <td>
                                                <input class="form-control" name="functionscore${ordinal}" type="text" placeholder="未打分" style="width:80px;"/>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                <input class="form-control" name="functionscore${ordinal}" type="text" value="${student.functionscore}" style="width:80px;"/>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${student.performancescore < 0}">
                                            <td>
                                                <input class="form-control" name="performancescore${ordinal}" type="text" placeholder="未打分" style="width:80px;"/>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                <input class="form-control" name="performancescore${ordinal}" type="text" value="${student.performancescore}" style="width:80px;"/>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${student.codescore < 0}">
                                            <td>
                                                <input class="form-control" name="codescore${ordinal}" type="text" placeholder="未打分" style="width:80px;"/>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                <input class="form-control" name="codescore${ordinal}" type="text" value="${student.codescore}" style="width:80px;"/>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${student.documentscore < 0}">
                                            <td>
                                                <input class="form-control" name="documentscore${ordinal}" type="text" placeholder="未打分" style="width:80px;"/>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>
                                                <input class="form-control" name="documentscore${ordinal}" type="text" value="${student.documentscore}" style="width:80px;"/>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td><input name="chooseStudent${ordinal}" type="radio" value="${ordinal}"/></td>
                                </tr>
                                <c:set var="ordinal" value="${ordinal+1}"/>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="modify()">修改学生成绩</button>
                    <button type="button" class="btn btn-primary" onclick="delet()">删除学生</button>
                </form>
            </c:otherwise>
        </c:choose>
        <hr/>
        <form action="addStudentInfo.mvc" class="form-inline" role="form" method="post">
            <div class="form-group">
                <h2>添加组员信息</h2>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon0">组号</span>
                    <input class="form-control" name="selectTeam" type="text" value="${teamSelected}" readonly="readonly"/>
                </div>

                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">学号</span>
                    <input class="form-control" name="addStudentNumber" type="text" placeholder="Number" describedby="basic-addon1" value="20000"/>
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2">姓名</span>
                    <input class="form-control" name="addStudentName" type="text" placeholder="Name" describedby="basic-addon1" value="ac"/>
                </div>
                <button type="submit" class="btn btn-primary">确认添加</button>
            </div>
        </form>
    </div>
</div>



</body>
</html>
