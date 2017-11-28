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
    <link rel="stylesheet" href="<%=basePath%>/css/event_analysis.css">
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script type="text/javascript">
	function getMoudelcName(name){
		var url = "<%=basePath%>rest/modelsanalysis/modelindex?moudleName="+encodeURI(encodeURI(name));
 		window.location.href=url;
 	}
    </script>
    <title>移动行为分析-模块分析</title>
</head>

<body>
     <%@ include file="top.jsp" %>
    <div class="index_main">
       <jsp:include page="left_menu.jsp">
	        <jsp:param name="menu" value="202"/>
	    </jsp:include>
        <!-- 内容 -->
        <div class="index_content full_bg">
            <!-- 第一行 -->
            <%@ include file="filter.jsp" %>
            <div class="event_analysis_title">
                <!-- 右侧按钮 -->
                <div class="btn-group">
                    <button type="button" class="btn btn-default btn_name_event dropdown-toggle color_white" id="model_analysisBtn">
					<div class="fl" id="moudleName">${moudleName }</div>
                   	<span class="caret fr event_caret"></span>
                    </button>
                    <div class="model_analysis_down">
                    	<ul class="list-group list_group_procedure">    
							 <c:if test="${empty modelNameList}">
                     <li class="list-group-item group-item1 appKey">暂无模块</li>
                     </c:if>
	                    <c:forEach items="${modelNameList}" var="model" >
	                   	 <li><a href="javascript:void(0)" class="list-group-item group-item1 appKey getEventId"  onclick="getMoudelcName('${model.moudleName}')" >${model.moudleName}</a></li>
	                    </c:forEach>
                        </ul>
                	</div>
                </div>
            </div>
            <!-- 第二行 -->
            <div class="profiling_contanter_top">
            <div class="data_contant fl">
                    <div class="right_data_title">性别分布</div>
					<div class="user_portrait user_sex" >
					<table id="sexss">
						<img src="<%=basePath%>/imgs/man.png" class="people"/><span id="model_boy">%</span>
						<img src="<%=basePath%>/imgs/women.png" class="people"/><span id="model_girl">%</span>
					</table>
					</div>
					<div class="right_data_title">年龄分布</div>
					<div id="model_age" class="user_portrait user_age"></div>
                </div>
                <div class="data_contant fl">
                    <div class="right_data_title fl">地区分布</div>
<!-- 					<div id="model_area" class="user_hy"></div> -->
					<div id="model_area" class="user_distribution"></div>
                </div>
            </div>
            <!-- 第三行 -->
            <div class="profiling_contanter_bottom">
                <div class="right_data_title fl">数据明细表</div>
                <table class="data_table1 fl">
				<thead>
                    <tr>
                        <td>模块名称</td>
                        <td>事件节点</td>
                        <td>节点触发数</td>
                        <td>节点达成数</td>
                    </tr>
                  </thead>  
						<tr> 
	                        <td>指标没有出来（假）</td>
	                        <td>12313</td>
	                        <td>123123</td>
	                        <td>213</td>
	                    </tr>
	                    <tr> 
	                        <td>指标没有出来（假）</td>
	                        <td>12313</td>
	                        <td>123</td>
	                        <td>123</td>
	                    </tr>
                </table>
                <ul class="pagination pull-right paginationRight" id="pageEvent"></ul>
            </div>
        </div>
    </div>
    <!-- jQuery -->
    <script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
    <!-- bootstrap -->
    <script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
    <!-- js  -->
    <script src="<%=basePath%>/js/index.js"></script>
    <script src="<%=basePath%>/js/left_menu.js"></script>
    <script src="<%=basePath%>/js/echarts.js"></script>
	<script src="<%=basePath%>/js/china.js"></script>
    <script src="<%=basePath%>/js/getAppkey.js"></script>
	<script src="<%=basePath%>/js/analysis_moudle.js"></script>
    <script>
    $('#example').popover('show');
    </script>
</body>

</html>>