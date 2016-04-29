<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/4/3
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>\
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>ModifyUser</title>
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
                <s:form action="logout" class="nav-form navbar-right" method="post" role="button">
                    <button type="submit" class="btn btn-default navbar-btn" >退出</button>
                </s:form>
            </div>
        </div>
    </nav>
</header>

<Script Language="JavaScript">
    function modify()
    {
        //action to modify
        document.form1.action="modifyuser.action";
        document.form1.submit();
    }

    function delet()
    {
        //action to modify
        document.form1.action="deleteuser.action";
        document.form1.submit();
    }
</Script>

<div class="container">
    <div class="jumbotron">
        <h1>用户信息面板</h1>
        <hr/>
        <c:choose>
            <c:when test="${sessionScope.loginAdmin == null}">
                <form name="form1" action="" method="post">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">用户信息</div>
                        <!-- Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th>学/工号</th><th>姓名</th><th>密码</th><th>身份</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--action传入userList--%>
                            <c:forEach var="team" items="${sessionScope.userList}">
                                <tr>
                                    <th scope="row">${team.id}</th>
                                    <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                    <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                    <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                    <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="modify()" disabled="disabled">修改用户信息</button>
                    <button type="button" class="btn btn-primary" onclick="delet()"  disabled="disabled">删除用户</button>
                </form>
            </c:when>
            <c:otherwise>
                <form name="form1" action="" method="post">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">用户概要</div>
                        <!-- Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th>学/工号</th><th>姓名</th><th>密码</th><th>身份</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="ordinal" value="1"/>
                            <c:forEach var="user" items="${sessionScope.userList}">
                                <tr>
                                    <th scope="row">
                                        <input class="form-control" name="number${ordinal}" type="text" value="${user.id}" style="width:120px;"/>
                                    </th>
                                    <td>
                                        <input class="form-control" name="name${ordinal}" type="text" value="${user.username}" style="width:70px;"/>
                                    </td>
                                    <td>
                                        <input class="form-control" name="password${ordinal}" type="text" value="${user.password}" style="width:70px;"/>
                                    </td>
                                    <td>
                                        <input class="form-control" name="identity${ordinal}" type="text" value="${user.identity}" style="width:70px;"/>
                                    </td>
                                    <td><input name="chooseUser" type="radio" value="${user.id}"/></td>
                                </tr>
                                <c:set var="ordinal" value="${ordinal+1}"/>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="modify()">修改用户信息</button>
                    <button type="button" class="btn btn-primary" onclick="delet()">删除用户</button>
                </form>
            </c:otherwise>
        </c:choose>
        <hr/>
        <%--action to modify--%>
        <form action="adduser.action" class="form-inline" role="form" method="post">
            <div class="form-group">
                <h2>添加用户信息</h2>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon0">工/学号</span>
                    <input class="form-control" name="newNumber" type="text" placeholder="number"/>
                </div>

                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">姓名</span>
                    <input class="form-control" name="newName" type="text" placeholder="name"/>
                </div>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2">密码</span>
                    <input class="form-control" name="newPassword" type="text" placeholder="password"/>
                </div>
                <div class="form-group">
                    <label for="user-identity" class="sr-only">身份</label>
                    <select class="form-control" id="user-identity" name="newIdentity">
                        <option value="student">student</option>
                        <option value="teacher">teacher</option>
                        <option value="admin">admin</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">确认添加</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
