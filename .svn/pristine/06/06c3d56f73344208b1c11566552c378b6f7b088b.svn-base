<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	function getDataBycName(name){
		var url = "<%=basePath%>rest/channelStatistics/channelView?channelName="+encodeURI(encodeURI(name));
 		window.location.href=url;
 	}
    </script>
    <title>移动行为分析-渠道分析</title>
</head>

<body>
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
            <div class="profiling_contanter_top">
                <!-- 按钮 -->
                <div class="btn-group btn-group-justified channel_btn fl btn-group-xbk" role="group" aria-label="..." id="justified_btn">
                    <div class="btn-group" role="group">
                        <button type="button" id="nUser" class="btn btn-default btn_radius">新增用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" id="actUser" class="btn btn-default">活跃用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" id="avgUser" class="btn btn-default btn_radius1">人均使用时长</button>
                    </div>
                </div>
                <!-- echarts的头部  -->
                <div class="channelAnalysis_title">
                	<div class="channel_analysis_title">
	                	<span class="channel_analysis_titleColor">昨日</span>
	                	<span class="channel_analysis_titleColor1">38,651</span>
	                	<span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
	                	<span class="channel_analysis_titleColor">昨日此时</span>
	                	<span class="channel_analysis_titleColor1">8,689</span>
	                	<span class="glyphicon glyphicon-arrow-up channelBg_up"></span>
	                </div>
	                <div class="channel_analysis_title hide">
	                	<span class="channel_analysis_titleColor">昨日1</span>
	                	<span class="channel_analysis_titleColor1">38,651</span>
	                	<span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
	                	<span class="channel_analysis_titleColor">昨日此时</span>
	                	<span class="channel_analysis_titleColor1">8,689</span>
	                	<span class="glyphicon glyphicon-arrow-up channelBg_up"></span>
	                </div>
	                <div class="channel_analysis_title hide">
	                	<span class="channel_analysis_titleColor">昨日2</span>
	                	<span class="channel_analysis_titleColor1">38,651</span>
	                	<span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
	                	<span class="channel_analysis_titleColor">昨日此时</span>
	                	<span class="channel_analysis_titleColor1">8,689</span>
	                	<span class="glyphicon glyphicon-arrow-up channelBg_up"></span>
	                </div>
                </div>
                
                <!-- 折线图 -->
                <div id="channel_newUser" class="profiling_LineChart" ></div>
            </div>
            <!-- 第三行 -->
			<div class="profiling_contanter_bottom">
                <div class="right_data_title fl" id="channel_users">
                	<span class="cp">渠道总览</span>
                    <span class="right_data_title_glay cp">运是营商</span>
                </div>
                <div id="channel_users_table">
                <table class="data_table1 fl">
                <thead>
                    <tr>
                        <td>渠道名称</td>
                        <td>用户总量</td>
                        <td>新增用户</td>
                        <td>活跃用户</td>
                        <td>人均使用时长</td>
                    </tr>
                  </thead>  
                  <tbody>
                  		<c:if test="${empty channelList.items}">
                            <tr>
                                <td colspan="5">暂时没有任何数据</td>
                            </tr>
                        </c:if>
                    <c:forEach items="${channelList.items}" var="channel">
	                    <tr>
	                        <td onclick="channelDetil(this);" class ="channelName" >${channel.channelName}</td>
	                        <td>${channel.userCount}</td>
	                        <td>${channel.newUserDay}</td>
	                        <td>${channel.activeUserDay}</td>
	                        <td>${channel.avgUserDay}</td>
	                    </tr>
                    </c:forEach>
                   </tbody>
                </table>
                 <table class="data_table1 fl hide">
                <thead>
                    <tr>
                    	<td>渠道名称</td>
                        <td>今日启动</td>
                        <td>今日活跃</td>
                        <td>昨日活跃</td>
                        <td>启动次数</td>
                        <td>人均启动次数</td>
                        <td>一次性用户占比</td>
                        <td>单次使用时长</td>
                    </tr>
                  </thead>  
                  <tbody>
	                    <tr>
	                    	<td>小米商城</td>
	                        <td>94,073</td>
	                        <td>20,763</td>
	                        <td>36,035</td>
	                        <td>2,875,671</td>
	                        <td>6.11</td>
	                        <td>42.47%</td>
	                        <td>00:01:24</td>
	                    </tr>
	                    <tr>
	                    	<td>应用宝</td>
	                        <td>88,194</td>
	                        <td>15,226</td>
	                        <td>28,828</td>
	                        <td>2,231,409</td>
	                        <td>6.20</td>
	                        <td>44.03%</td>
	                        <td>00:01:21</td>
	                    </tr>
	                    <tr>
	                    	<td>小米商城</td>
	                        <td>94,073</td>
	                        <td>20,763</td>
	                        <td>36,035</td>
	                        <td>2,875,671</td>
	                        <td>6.11</td>
	                        <td>42.47%</td>
	                        <td>00:01:24</td>
	                    </tr>
	                    <tr>
	                    	<td>机锋市场</td>
	                        <td>58,796</td>
	                        <td>20,763</td>
	                        <td>36,035</td>
	                        <td>1,776,066</td>
	                        <td>6.11</td>
	                        <td>42.47%</td>
	                        <td>00:01:24</td>
	                    </tr>
                   </tbody>
                </table>
                </div>
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
    <script src="<%=basePath%>js/channel_statistics.js"></script>
     <script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
    <script>
 $(function () {
    	$("#table_iconX").click(function(){
    		$("#app-form-group").removeClass("hidden")
    	})
    	$("#pageChannel").twbsPagination({
    		totalPages:${channelList.totalPages},
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