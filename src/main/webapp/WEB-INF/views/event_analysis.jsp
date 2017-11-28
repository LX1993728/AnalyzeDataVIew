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
    <title>移动行为分析-事件分析</title>
    <script type="text/javascript">
    function getDataBycName(name){
		var url = "<%=basePath%>rest/event/analysis?eventId="+encodeURI(encodeURI(name));
 		window.location.href=url;
 	}
    </script>
</head>

<body>
     <%@ include file="top.jsp" %>
    <div class="index_main">
        <jsp:include page="left_menu.jsp">
	        <jsp:param name="menu" value="203"/>
	    </jsp:include>
        <!-- 内容 -->
        <div class="index_content">
            <!-- 第一行 -->
             <%@ include file="filter.jsp" %>
            <!-- 第二行 -->
             <div class="profiling_contanter_top event_title_top">
                    <!-- 右侧按钮 -->
                <div class="btn-group event_button">
                    <button id="eventSelect" type="button" class="btn btn-default btn_name_event dropdown-toggle color_white">
                    <c:if test="${not empty eventName}">
                        	${eventName}
                    </c:if>
                    <c:if test="${empty eventName}">
                    <c:if test="${empty eventIdList[0].eventName}">事件概览</c:if>
                        	<c:if test="${not empty eventIdList[0].eventName}">
                        	${eventIdList[0].eventName}
                        	</c:if>
                    </c:if>
                        	<span class="caret fr event_caret"></span>
                    </button>
                    <div class="event_analysis_down">
                     <ul class="list-group list_group_procedure" id="eventId">
                     <c:if test="${empty eventIdList}">
                     <li class="list-group-item group-item1 appKey">暂无事件</li>
                     </c:if>
	                    <c:forEach items="${eventIdList}" var="event" >
		                     <li class="list-group-item group-item1 appKey" onclick="getDataBycName(${event.eventId})">${event.eventName}</li>
	                    </c:forEach>
                    </ul>
                	</div>
                </div>
            </div>
            <div class="profiling_contanter_top">
			<!-- 按钮 -->
                <div class="btn-group btn-group-justified btn-group-event fl" role="group" aria-label="..." id="justified_btn">
                    <div class="btn-group" role="group">
                        <button id="eventClicks" type="button" class="btn btn-default btn_radius">次数</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="eventUser" type="button" class="btn btn-default">人数</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default btn_radius1">更多指标
                        <span class="caret"></span>
                        </button>
                    </div>
                </div>
                <!-- 折线图 -->
                <div class="event_Line_Chart fl" id="eventCharts"></div>
                <div class="event_Line_Chart1 fl" id="eventDetailCharts"></div>
            </div>
            <!-- 第三行 -->
            <div class="profiling_contanter_bottom">
                <div class="right_data_title fl">数据明细表</div>
                <table class="data_table1 fl">
				<thead>
                    <tr>
                        <td>事件名称</td>
                        <td>事件节点</td>
                        <td>节点触发数</td>
                        <td>节点达成数</td>
                        <td>触发用户数</td>
                        <td>达成用户数</td>
                    </tr>
                  </thead>  
                  <tbody>
                  		<c:if test="${empty eventModel.items}">
                            <tr>
                                <td colspan="5">暂时没有任何数据</td>
                            </tr>
                        </c:if>
                    <c:forEach items="${eventModel.items}" var="event">
	                    <tr>
	                        <td>${event.eventName}</td>
	                        <td>${event.eventNode}</td>
	                        <td>${event.eventTrigger}</td>
	                        <td>${event.reach}</td>
	                        <td>${event.countUser}</td>
	                        <td>${event.reachUser}</td>
	                    </tr>
                    </c:forEach>
                   </tbody>
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
    <script src="<%=basePath%>/js/getAppkey.js"></script>
    <script src="<%=basePath%>/js/echarts.js"></script>
    <script src="<%=basePath%>/js/analysis_event.js"></script>
    <script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
    <script>
 $(function () {
    	$("#table_iconX").click(function(){
    		$("#app-form-group").removeClass("hidden")
    	})
    	$("#pageEvent").twbsPagination({
    		totalPages:${eventModel.totalPages},
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