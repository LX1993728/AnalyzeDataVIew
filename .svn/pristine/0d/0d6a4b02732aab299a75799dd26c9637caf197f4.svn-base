<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

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
    <link rel="stylesheet" href="<%=basePath%>/bootstrap/css/bootstrap-table.css">
    <!-- style.css -->
    <link rel="stylesheet" href="<%=basePath%>/css/base.css">
    <link rel="stylesheet" href="<%=basePath%>/css/index.css">
    <link rel="stylesheet" href="<%=basePath%>/css/data_analysis.css">
    <link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <title>移动行为分析-数据概况</title>
</head>

<body>
    <%@ include file="top.jsp" %>
    <div class="index_main">
	 	<jsp:include page="left_menu.jsp">
	        <jsp:param name="menu" value="101"/>
	    </jsp:include>
        <!-- 内容 -->
        <div class="index_content">
            <!-- 第一行 -->
			<%@ include file="filter.jsp" %>
			<!-- 第二行 -->
            <div class="profiling_contanter_top">
            	<div class="right_data_title">时段分析</div>
                <!-- 按钮 -->
                <div class="btn-group btn-group-justified btn-group-sx1" role="group" aria-label="..." id="justified_btn">
                    <div class="btn-group" role="group">
                        <button id="newUser"   type="button"  class="btn btn-default btn_radius">新增用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="actUser" type="button" class="btn btn-default btn_radius1">活跃用户</button>
                    </div>
                </div>
                <!-- 折线图 -->
                <div class="profiling_LineChart" id="profileTime"></div>
            </div>
            <!-- 第三行 -->
            
            <div class="profiling_contanter_bottom profiling_paddingTop">
            	<div class="right_data_title">趋势分析</div>
                <!-- 按钮 -->
                <div class="btn-group btn-group-justified fl btn-group-sx" role="group" aria-label="..." id="justified_btn">
                    <div class="btn-group" role="group">
                        <button type="button" id="nUser" class="btn btn-default btn_radius">新增用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="aUser" type="button" class="btn btn-default">活跃用户</button>
                    </div>
                    <div class="btn-group hide" role="group">
                        <button id="rUser" type="button" class="btn btn-default">留存用户</button>
                    </div>
                    <div class="btn-group hide" role="group">
                        <button id="lUser" type="button" class="btn btn-default">流失用户</button>
                    </div>
                    <div class="btn-group hide" role="group">
                        <button id="bUser" type="button" class="btn btn-default">回流用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="startPro" type="button" class="btn btn-default">启动次数</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="sumUser" type="button" class="btn btn-default">累计用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="avgTime" type="button" class="btn btn-default btn_radius1">人均使用时长</button>
                    </div>
                </div>
                <!-- 折线图 -->
                <div class="profiling_LineChart" id="profile"></div>
            </div>
            <!-- 第四行 -->
            <div class="profiling_contanter_top1">
                <div class="right_data_title fl">数据明细表</div>
               <!-- <table id="usert"> -->
               	<table class="data_table1 fl" style=" width: 97%" id="usert"></table>
                 <%-- <thead>
                    <tr>
                        <td>日期</td>
                        <td>新增用户</td>
                        <td>活跃用户</td>
                        <td>启动次数</td>
                        <td>人均使用时长</td>
                        <td>累计用户总量</td>
                    </tr>
                  </thead>  
                  <tbody>
                  		 <c:if test="${empty pageUser.items}">
                            <tr>
                                <td colspan="5">暂时没有任何数据</td>
                            </tr>
                        </c:if>
                    <c:forEach items="${pageUser.items}" var="pro">
	                    <tr>
	                        <td>${pro.date}</td>
	                        <td>${pro.newUserCount}</td>
	                        <td>${pro.activeUser}</td>
	                        <td>${pro.startCount}</td>
	                        <td>${pro.avgUserTime}s</td>
	                        <td>${pro.totalUserCount}</td>
	                    </tr>
                    </c:forEach>
                   </tbody> --%>
                
                <!-- <ul class="pagination pull-right paginationRight" id="pageUs"></ul> -->
            </div>
        </div>
    </div>
    <!-- jQuery -->
    <script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
    <!-- bootstrap -->
    <script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
    <!-- bootstrap-table -->
    <script src="<%=basePath%>/bootstrap/js/bootstrap-table.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap-table-zh-CN.js"></script>
    <!-- js  -->
    <script src="<%=basePath%>/js/index.js"></script>
	<!-- echarts -->
	<script src="<%=basePath%>/js/echarts.js"></script>
	<script src="<%=basePath%>/js/data_profile.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
	<script type="text/javascript">

	$(document).ready(function() {
		initTable();
	})
	//按时间搜索数据明细表
	$("#tipData").click(function(){
		//销毁原来数据重新加载
		 $("#usert").bootstrapTable('destroy'); 
		 initTable();
	}) ; 
	 
	function initTable() {
		$("#usert").bootstrapTable({
			url : path + projectName + "/rest/profile/dataprofiling",
			dataType : "json",
			method : 'post',
			contentType : "application/x-www-form-urlencoded",
			pagination : true, //分页
			classes : 'table-no-bordered',
			locale : 'zh-CN',//中文支持
			height : 450,
			pageNumber : 1,//初始化加载第一页，默认第一页
			pageSize : 6,//每页的记录行数（*）
			pageList : [ 6 ],
			queryParamsType : '',
			queryParams: function(params) {  
	             var param = {  
	            	pageNumber: params.pageNumber,    
	                pageSize: params.pageSize,
	            	//startDate:startDate,
	            	//endDate:endDate,
            		startDate:$("#startDate").val(),
         		 	endDate:$("#endDate").val(),
	             }; 
	            
	             return param;                   
	         }, 
			sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
			columns : [ {
				title : '日期',
				field : 'date',
				align : 'center',
				//width:'16.6%'
			}, {
				title : '新增用户',
				field : 'newUserCount',
				align : 'center',
				//width:'16.6%'
			}, {
				title : '活跃用户',
				field : 'activeUser',
				align : 'center',
				//width:'16.6%'
			}, {
				title : '启动次数',
				field : 'startCount',
				align : 'center',
				//width:'16.6%'
			}, {
				title : '人均使用时长',
				field : 'avgUserTime',
				align : 'center',
				//width:'16.6%'
			}, {
				title : '累计用户总量',
				field : 'totalUserCount',
				align : 'center',
				//width:'16.6%'
			} ],
			
		});
	}

	</script>
</body>

</html>