<%--
  Created by IntelliJ IDEA.
  User: Java
  Date: 2016/3/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Deploy</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

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
                    <c:when test="${empty resultList}">
                        <p class="navbar-text">没有权限</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="result" items="${resultList}">
                            <li><p class="navbar-text">学号：${result.id}</p></li>
                            <li><p class="navbar-text">姓名：${result.name}</p></li>
                            <li><p class="navbar-text">组号：${result.group}</p></li>
                            <li><a href="#deploy">系统部署</a></li>
                            <li><a href="#frontpage">系统检测</a></li>
                            <li><a href="#function">功能测试</a></li>
                            <li><a href="#performance">性能测试</a></li>
                            <li><a href="#code">代码检测</a></li>
                            <li><a href="#document">文档检测</a></li>
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
        <h1>欢迎来到系统部署界面</h1>
        <button type="button" class="btn btn-primary btn-lg" href="#deploy">
            开始系统部署
        </button>
    </div>
</div>



<div class="container text-center">
    <%--DEPLOY--%>
    <section>
        <div class="well" id="deploy">
            <div class="container text-center">
                <h2>上传系统文件&选择部署IP</h2>
            </div>
            <div class="container text-center">
                <form action="upload.mvc" class="form-inline" role="form" method="post">
                    <div class="form-group">
                        <label for="choose-file" class="sr-only">file</label>
                        <input type="file" title="选择上传文件" id="choose-file" name="filename">
                        <!--input type="text" class="form-control" id="subscribe-name" placeholder="Name"-->
                    </div>
                    <div class="form-group">
                        <label for="IP-address" class="sr-only">IP</label>
                        <select class="form-control" id="IP-address" name="IPaddress">
<<<<<<< HEAD
                            <option value="10.1.1.1">10.1.1.1</option>
                            <option value="10.1.1.2">10.1.1.2</option>
                            <option value="10.1.1.3">10.1.1.3</option>
                            <option value="10.1.1.4">10.1.1.4</option>
                            <option value="10.1.1.5">10.1.1.5</option>
=======
                            <option value="one">10.1.1.1</option>
                            <option value="two">10.1.1.2</option>
                            <option value="three">10.1.1.3</option>
                            <option value="four">10.1.1.4</option>
                            <option value="five">10.1.1.5</option>
>>>>>>> bfadc73d6e1bf849daec0c8753286f896fe147b8
                        </select>
                        <!--input type="text" class="form-control" id="subscribe-email" placeholder="Email address"-->
                    </div>
                    <c:choose>
                        <c:when test="${isDeployed == 'success'}">
                            <button type="submit" class="btn btn-primary" disabled="disabled">开始上传</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary">开始上传</button>
                        </c:otherwise>
                    </c:choose>

                </form>
            </div>
            <c:choose>
                <c:when test="${isDeployed == 'success'}">
                    <div class="row">
<<<<<<< HEAD
                        <div class="col-lg-10">
=======
                        <div class="col-lg-11">
>>>>>>> bfadc73d6e1bf849daec0c8753286f896fe147b8
                            <div class="progress" >
                                <div class="progress-bar" role="progressbar" style="width: 0%;" data-percentage="100">
                                </div>
                            </div>
                        </div>
<<<<<<< HEAD
                        <div class="col-lg-2">
=======
                        <div class="col-lg-1">
>>>>>>> bfadc73d6e1bf849daec0c8753286f896fe147b8
                            <button type="button" class="btn btn-primary" href="#frontpage">下一步</button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
<<<<<<< HEAD
                    <div class="row">
                    <div class="col-lg-10">
                        <div class="progress" ></div>
                    </div>
                    <div class="col-lg-2">
                        <button type="button" class="btn btn-primary" disabled="disabled">下一步</button>
                    </div>
=======
                    <div class="col-lg-11">
                        <div class="progress">
                            <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="min-width: 2em;">
                                0%
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-1">
                    <button type="submit" class="btn btn-primary" disabled="disabled">下一步</button>
>>>>>>> bfadc73d6e1bf849daec0c8753286f896fe147b8
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </section>

    <%--FRONTPAGE--%>

    <section>
        <div class="container text-center" id="frontpage">
            <c:choose>
                <c:when test="${isDeployed == 'success'}">
                    <button type="submit" class="btn btn-primary">开始检测首页</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" class="btn btn-primary" disabled="disabled">开始检测首页</button>
                </c:otherwise>
            </c:choose>
        </div>
    </section>
    <!--div class="progress progress-success">
        <div class="bar" style="float: left; width: 0%; ></div>
    </div-->


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
