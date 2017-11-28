<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 使用webkit内核 -->
    <meta name="renderer" content="webkit">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<%=basePath%>/bootstrap/css/bootstrap.min.css">
    <!-- style.css -->
    <link rel="stylesheet" href="<%=basePath%>/css/base.css">
    <link rel="stylesheet" href="<%=basePath%>/css/index.css">
    <link rel="stylesheet" href="<%=basePath%>/css/data_analysis.css">
    <link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
    <link rel="stylesheet" href="<%=basePath%>/css/user_analysis.css">
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <title>移动行为分析-用户分析</title>
</head>

<body>
     <%@ include file="top.jsp" %>
    <div class="index_main">
        <jsp:include page="left_menu.jsp">
	        <jsp:param name="menu" value="201"/>
	    </jsp:include>
        <!-- 内容 -->
        <div class="index_content">
               <!-- 第一行 -->
            <%@ include file="filter.jsp" %>
            <!-- 第二行 -->
            <div class="profiling_contanter_top">
                <!-- 按钮 -->
                <div class="btn-group btn-group-justified fl" role="group" aria-label="..." id="justified_btn">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default btn_radius queryUserAnalysis" rel="totaluser">总用户</button>
                    </div>
					<div class="btn-group" role="group">
                        <button type="button" class="btn btn-default queryUserAnalysis " rel="newadd">新增分析</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default queryUserAnalysis" rel="activeanalysis">活跃分析</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default queryUserAnalysis" rel="quitanalysis">静默分析</button>
                    </div>
<!--                     <div class="btn-group" role="group"> -->
<!--                         <button type="button" class="btn btn-default btn_radius1">用户分群</button> -->
<!--                     </div> -->
                </div>
                <!-- 折线图 -->
               <div id="user" class="profiling_LineChart"></div>
            </div>
            <!-- 第三行 -->
            <div class="profiling_contanter_bottom">
                <div class="user_analysis fl">
                    <div class="right_data_title">性别分布</div>
					<div class="user_portrait user_sex" >
					<table id="sexss">
						<img src="<%=basePath%>/imgs/man.png" class="people"/><span id="boy">%</span>
						<img src="<%=basePath%>/imgs/women.png" class="people"/><span id="girl">%</span>
					</table>
					</div>
					<div class="right_data_title">年龄分布</div>
					<div id="age" class="user_portrait user_age"></div>
					<div></div>
                </div>
                <div class="user_analysis fr">
                    <div class="right_data_title fl">行业分布</div>
					<div id="hy" class="user_hy"></div>
                </div>
                
            </div>
        </div>
    </div>
    <!-- jQuery -->
    <script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
    <!-- bootstrap -->
    <script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
    <!-- js  -->
    <script src="<%=basePath%>/js/index.js"></script>
    
    <!-- echarts -->
    <script src="<%=basePath%>/js/echarts.js"></script>
	<script src="<%=basePath%>/js/user_analysis.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
    <script>
    $('#example').popover('show');
    </script>
</body>
</html>