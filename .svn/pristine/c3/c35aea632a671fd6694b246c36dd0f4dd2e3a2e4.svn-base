<%@page import="com.anrong.wulan.core.util.Strings"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<%=basePath%>/scrollbar/jquery.mCustomScrollbar.css">
    <!-- style.css -->
    <link rel="stylesheet" href="<%=basePath%>/css/base.css">
    <link rel="stylesheet" href="<%=basePath%>/css/index.css">
    <link rel="stylesheet" href="<%=basePath%>/css/data_analysis.css">
    <link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
    <link rel="stylesheet" href="<%=basePath%>/css/event_analysis.css">
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	<script type="text/javascript">
    </script>
    <title>移动行为分析-渠道分析详细页面</title>
</head>

<body>
<%  
	String qdname=request.getParameter("channelName");
%> 
 <%@ include file="top.jsp" %>
    <div class="index_main">
       <jsp:include page="left_menu.jsp">
	        <jsp:param name="menu" value="107"/>
	    </jsp:include>
        <!-- 内容 -->
        <div class="index_content">
            <!-- 第一行 -->
           <%@ include file="filter.jsp" %>
            <!-- 第二行 -->
            <div class="detailed_menu">
            	<ul>
            		<li><a herf="/rest/channelStatistics/channelView" class="detailed_menu_color">渠道统计</a>></li>
            		<li><a herf="#">渠道详细</a></li>
            	</ul>
			</div>
            <div class="profiling_contanter_top">
                <!-- 按钮 -->
                <div class="btn-group btn-group-justified channel_btn fl btn-group-xbk" role="group" aria-label="..." id="justified_btn">
                    <div class="btn-group" role="group">
                        <button type="button" id="nUserDetail" class="btn btn-default btn_radius">新增用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" id="actUserDetail" class="btn btn-default">活跃用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" id="avgUserDetail" class="btn btn-default btn_radius1">人均使用时长</button>
                    </div>
                </div>
                <div style="display:none" id = "qdname"><%=qdname%></div>
                <!-- 折线图 -->
                <div id="channel_newUser" class="profiling_LineChart" ></div>
            </div>
            <!-- 第三行 -->
			<div class="profiling_contanter_bottom">
                <div class="right_data_title fl">渠道详细</div>
                <table class="data_table1 fl">
                <thead>
                    <tr>
                        <td>渠道名称</td>
                        <td>新增用户</td>
                        <td>活跃用户</td>
                        <td>人均使用时长</td>
                        <td>时间</td>
                    </tr>
                  </thead>  
                  <tbody>
                  		<c:if test="${empty channelListDetailed.items}">
                            <tr>
                                <td colspan="5">暂时没有任何数据</td>
                            </tr>
                        </c:if>
                    <c:forEach items="${channelListDetailed.items}" var="channelDetailed">
	                     <tr>
	                        <td>${channelDetailed.channelName}</td>
	                        <td>${channelDetailed.newUserDay}</td>
	                        <td>${channelDetailed.activeUserDay}</td>
	                        <td>${channelDetailed.avgUserDay}</td>
<%-- 	                        <td>${channelDetailed.statisticsDate}</td> --%>
	                        <td> <fmt:formatDate value="${channelDetailed.statisticsDate }" pattern="yyyy-MM-dd"/></td>
	                    </tr> 
                    </c:forEach>
                   </tbody>
                </table>
                <ul class="pagination pull-right paginationRight" id="pageChannel"></ul>
            </div>
        </div>
    </div>
    <!-- jQuery -->
    <script src="<%=basePath%>js/jQuery 1.9.1.js"></script>
    <!-- bootstrap -->
    <script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <!-- scrollbar -->
    <script src="<%=basePath%>scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <!-- js  -->
    <script src="<%=basePath%>js/index.js"></script>
    <script src="<%=basePath%>js/left_menu.js"></script>
    <!-- 排序 -->
	<script src="<%=basePath%>js/jquery.columns-1.0.min.js"></script>
    <!-- 初始化echarts图 -->
    <script src="<%=basePath%>js/channel_statistics_detailed.js"></script>
     <script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
    <script>
 $(function () {
    	$("#table_iconX").click(function(){
    		$("#app-form-group").removeClass("hidden")
    	})
    	$("#pageChannel").twbsPagination({
    		totalPages:${channelListDetailed.totalPages},
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