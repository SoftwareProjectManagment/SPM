<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Deploy</title>
    <link rel="stylesheet" href="/SSH_war_exploded/bootstrap/css/bootstrap.min.css">

    <style>
        body {
            padding-top : 50px;
        }
    </style>

</head>
<body data-spy="scroll" data-target="#main-navbar">
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
                    <c:when test="${sessionScope.loginStudent == null}">
                        <p class="navbar-text">没有权限</p>
                    </c:when>
                    <c:otherwise>
                        <li><p class="navbar-text">学号：${sessionScope.loginStudent.id}</p></li>
                        <li><p class="navbar-text">姓名：${sessionScope.loginStudent.name}</p></li>
                        <li><p class="navbar-text">组号：${sessionScope.loginStudent.groupnum}</p></li>
                        <li><a href="#deploy">系统部署</a></li>
                        <li><a href="#frontpage">系统检测</a></li>
                        <li><a href="#function">功能测试</a></li>
                        <li><a href="#performance">性能测试</a></li>
                        <li><a href="#code">代码检测</a></li>
                        <li><a href="#document">文档检测</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>

            <form action="logout.action" class="nav-form navbar-right" method="post" role="button">
                <button type="submit" class="btn btn-default navbar-btn" >退出</button>
            </form>
        </div>
    </div>

</nav>

<div class="jumbotron">
    <div class="container text-center">
        <h1>欢迎来到系统部署界面</h1>
        <button type="button" class="btn btn-primary btn-lg" href="#deploy">
            开始系统部署
        </button>
    </div>
</div>

<hr>

<div class="container text-center">
    <%--DEPLOY--%>
    <section>
        <div class="well" id="deploy">
            <div class="container text-center">
                <h2>上传系统文件&选择部署IP</h2>
            </div>
            <div class="container text-center">
                <s:form action="uploadfile" class="form-inline" role="form" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="choose-file" class="sr-only">file</label>
                        <input type="file" title="选择上传文件" id="choose-file" name="file">
                        <!--input type="text" class="form-control" id="subscribe-name" placeholder="Name"-->
                    </div>
                    <div class="form-group">
                        <label for="IP-address" class="sr-only">IP</label>
                        <select class="form-control" id="IP-address" name="IPaddress">
                            <option value="10.1.1.1">10.1.1.1</option>
                            <option value="10.1.1.2">10.1.1.2</option>
                            <option value="10.1.1.3">10.1.1.3</option>
                            <option value="10.1.1.4">10.1.1.4</option>
                            <option value="10.1.1.5">10.1.1.5</option>
                        </select>
                        <!--input type="text" class="form-control" id="subscribe-email" placeholder="Email address"-->
                    </div>
                    <c:choose>
                        <c:when test="${sessionScope.deployedFile != 'in:valid'}">
                            <button type="submit" class="btn btn-primary" disabled="disabled">开始上传</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary">开始上传</button>
                        </c:otherwise>
                    </c:choose>

                </s:form>
            </div>
            <br>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.deployedFile != 'in:valid' && sessionScope.checkFrontPage == -1}">
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" >
                                    <div class="progress-bar" role="progressbar" style="width: 0%;" data-percentage="100">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-primary" href="#frontpage">下一步</button>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" ></div>
                            </div>
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-primary" disabled="disabled" href="#frontpage">下一步</button>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>

    <hr>
    <%--FRONTPAGE--%>

    <section>
        <div class="well" id="frontpage">
            <div class="container text-center">
                <h2>系统检测&首页检测</h2>
            </div>
            <div class="container text-center">
                <s:form action="checkfrontpage" class="form-inline" role="form" method="checkFrontPage">
                    <c:choose>
                        <c:when test="${sessionScope.checkFrontPage == -1 && sessionScope.deployedFile != 'in:valid' && sessionScope.deployedIP != 'in:valid'}">
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary">开始检测首页</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary" disabled="disabled">开始检测首页</button>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </s:form>
            </div>
            <br>
            <div>
                <c:choose>
                    <c:when test="${ sessionScope.checkFrontPage != -1 && sessionScope.checkFunction == -1 && sessionScope.checkCodeOne == -1 && sessionScope.checkCodeTwo == -1 }">
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" >
                                    <div class="progress-bar" role="progressbar" style="width: 0%;" data-percentage="100">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-1">
                                <button type="button" class="btn btn-primary" href="#">打开首页</button>
                            </div>
                            <div class="col-lg-1">
                                <button type="button" class="btn btn-primary" href="#frontpage">下一步</button>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" ></div>
                            </div>
                            <div class="col-lg-1">
                                <button type="button" class="btn btn-primary" disabled="disabled" href="#">打开首页</button>
                            </div>
                            <div class="col-lg-1">
                                <button type="button" class="btn btn-primary" disabled="disabled" href="#function">下一步</button>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>

    <hr>
    <%--FUNCTION--%>
    <section>
        <div class="well" id="function">
            <div class="container text-center">
                <h2>功能测试</h2>
            </div>
            <div class="container text-center">
                <s:form action="checkfunction" class="form-inline" role="form" method="checkFunction">
                    <c:choose>
                        <c:when test="${ sessionScope.checkFrontPage != -1 && sessionScope.checkFunction == -1 && sessionScope.checkPerformance == -1}">
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary">开始功能测试</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary" disabled="disabled">开始功能测试</button>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </s:form>
            </div>
            <br>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.checkFunction != -1 }">
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="panel panel-default">
                                    <!-- Default panel contents -->
                                    <div class="panel-heading">功能测试</div>
                                    <!-- Table -->
                                    <table class="table">
                                        <tbody>
                                        <tr>
                                            <th scope="row">测试用例1</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例2</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例3</th>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例4</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例5</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <button type="button" class="btn btn-primary" href="#performance">下一步</button>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="panel panel-default">
                                    <!-- Default panel contents -->
                                    <div class="panel-heading">功能测试</div>
                                    <!-- Table -->
                                    <table class="table">
                                        <tbody>
                                        <tr>
                                            <th scope="row">测试用例1</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例2</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例3</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例4</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例5</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <button type="button" class="btn btn-primary" disabled="disabled" href="#performance">下一步</button>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>

    <hr>
    <%--PERFORMACE--%>
    <section>
        <div class="well" id="performance">
            <div class="container text-center">
                <h2>性能测试</h2>
            </div>
            <div class="container text-center">
                <s:form action="checkperformance" class="form-inline" role="form" method="checkPerformance">
                    <c:choose>
                        <c:when test="${sessionScope.checkFunction != -1 && sessionScope.checkPerformance == -1 && sessionScope.checkCodeOne == -1 && sessionScope.checkCodeTwo == -1}">
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary">开始性能测试</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary" disabled="disabled">开始性能测试</button>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </s:form>
            </div>
            <br>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.checkPerformance != -1 }">
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="panel panel-default">
                                    <!-- Default panel contents -->
                                    <div class="panel-heading">性能测试</div>
                                    <!-- Table -->
                                    <table class="table">
                                        <tbody>
                                        <tr>
                                            <th scope="row">测试用例1</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例2</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例3</th>
                                            <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例4</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例5</th>
                                            <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <button type="button" class="btn btn-primary" href="#performance">下一步</button>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="col-sm-8">
                                <div class="panel panel-default">
                                    <!-- Default panel contents -->
                                    <div class="panel-heading">性能测试</div>
                                    <!-- Table -->
                                    <table class="table">
                                        <tbody>
                                        <tr>
                                            <th scope="row">测试用例1</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例2</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例3</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例4</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">测试用例5</th>
                                            <td><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <button type="button" class="btn btn-primary" disabled="disabled" href="#performance">下一步</button>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>

    <hr>
    <%--CODE--%>
    <section>
        <div class="well" id="code">
            <div class="container text-center">
                <h2>代码检测</h2>
            </div>
            <div class="container text-center">
                <s:form action="checkcode" class="form-inline" role="form" method="checkCode">
                    <c:choose>
                        <c:when test="${sessionScope.checkPerformance != -1 && sessionScope.checkCodeOne == -1 && sessionScope.checkCodeTwo == -1  && sessionScope.checkDocument == -1}">
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary">开始检测代码</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary" disabled="disabled">开始检测代码</button>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </s:form>
            </div>
            <br>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.deployedFile != 'in:valid' && sessionScope.deployedIP != 'in:valid' && sessionScope.checkFrontPage != -1 && sessionScope.checkFunction != -1 && sessionScope.checkPerformance != -1 && sessionScope.checkCodeOne != -1 && sessionScope.checkCodeTwo != -1 && sessionScope.checkDocument == -1}">
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" >
                                    <div class="progress-bar" role="progressbar" style="width: 0%;" data-percentage="100">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-primary" href="#frontpage">下一步</button>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" ></div>
                            </div>
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-primary" disabled="disabled" href="#function">下一步</button>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>

    <hr>
    <%--DOCUMENT--%>
    <section>
        <div class="well" id="document">
            <div class="container text-center">
                <h2>文档形式检测</h2>
            </div>
            <div class="container text-center">
                <s:form action="checkdocument" class="form-inline" role="form" method="checkDocument">
                    <c:choose>
                        <c:when test="${sessionScope.checkCodeOne != -1 && sessionScope.checkCodeTwo != -1  && sessionScope.checkPerformance != -1}">
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary">开始检测文档</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="container text-center">
                                <button type="submit" class="btn btn-primary" disabled="disabled">开始检测文档</button>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </s:form>
            </div>
            <br>
            <div>
                <c:choose>
                    <c:when test="${sessionScope.deployedFile != 'in:valid' && sessionScope.deployedIP != 'in:valid' && sessionScope.checkFrontPage != -1 && sessionScope.checkFunction != -1 && sessionScope.checkCodeOne != -1 && sessionScope.checkCodeTwo != -1 && sessionScope.checkDocument != -1}">
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" >
                                    <div class="progress-bar" role="progressbar" style="width: 0%;" data-percentage="100">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="col-lg-10">
                                <div class="progress" ></div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>

    <%--GO BACK--%>

    <section>
        <div class="well">
            <a href="/SSH_war_exploded/student/studentpanel.jsp" class="btn btn-primary">返回学生面板</a>
        </div>
    </section>

</div>

<script src="bootstrap/jquery-2.2.1.min.js"></script>
<script src="bootstrap/bootstrap.file-input.js"></script>

<script>
    $(document).ready(function(){
        $('input[type=file]').bootstrapFileInput();
    });
</script>

<script>
    setTimeout(function(){
        $('.progress .progress-bar').each(function() {
            var me = $(this);
            var perc = me.attr("data-percentage");
            var current_perc = 0;
            var progress = setInterval(function() {
                if (current_perc>=perc) {
                    clearInterval(progress);
                } else {
                    current_perc +=1;
                    me.css('width', (current_perc)+'%');
                }
                me.text((current_perc)+'%');
            }, 50);
        });
    },300);
</script>


</body>
</html>
