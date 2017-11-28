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
<link rel="stylesheet"
	href="<%=basePath%>/bootstrap/css/bootstrap.min.css">
<!-- style.css -->
<link rel="stylesheet" href="<%=basePath%>/css/base.css">
<link rel="stylesheet" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" href="<%=basePath%>/css/data_analysis.css">
<link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
<title>移动行为分析-模块统计</title>
</head>

<body>
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<%--         <%@ include file="left_menu.jsp" %> --%>

		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="104" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<!-- 第一行 -->
			<%@ include file="filter.jsp"%>
			<!-- 第二行 -->
			<div class="profiling_contanter_top">
				<!-- <select name="moduleName" class="btn btn-default btn_name_event1 dropdown-toggle color_white fr" id="moduleName">  
							<option  value="TOP10"  >TOP10模块</option>  
 							<option  value="UNDER10" >UNDER10模块</option>  
            	</select>  -->
				<button type="button"
					class="btn btn-default btn_name_event1 dropdown-toggle color_white fr"
					id="moduleName">
					<div class="fl" id="TopName">TOP10模块</div>
					<span class="caret event_caret fr"></span>
				</button>
				<div class="mCustomScrollbar channel_menu">
					<ul>
						<li><a href="javascript:Top10();">TOP10模块</a></li>
						<li><a href="javascript:Under10();">UNDER10模块</a></li>
					</ul>
				</div>
				<div class="right_data_title" id="new_users">
					<span class="cp" id="moudle">TOP模块</span>
				</div>
				<!-- 折线图 -->
				<div class="profiling_LineChart" id="moudleCharts"></div>
			</div>
			<!-- 第三行 -->
			<div class="profiling_contanter_bottom1">
				<div class="right_data_title fl">数据明细表</div>
				<table class="data_table1 fl">
					<thead>
						<tr>
							<td>模块名</td>
							<td>点击量</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty moudleList.items}">
							<tr>
								<td colspan="5">暂时没有任何数据</td>
							</tr>
						</c:if>
						<c:forEach items="${moudleList.items}" var="m">
							<tr>
								<td>${m.modelName}</td>
								<td>${m.statisticsInvokeNum}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination pull-right paginationRight" id="moudlePage"></ul>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
	<!-- bootstrap -->
	<script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
	<!-- js  -->
	<script src="<%=basePath%>/js/index.js"></script>
	<!-- echart  -->
	<script src="<%=basePath%>/js/echarts.js"></script>
	<script src="<%=basePath%>/js/data_module.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>

	<script>
    $(function () {
    	
    	$("#table_iconX").click(function(){
    		$("#app-form-group").removeClass("hidden")
    	}) 
    	
    	$("#moudlePage").twbsPagination({
    		totalPages:${moudleList.totalPages},
            visiblePages:10,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?p={{number}}'
        });
    });
    
    	
    
    </script>
</body>

</html>