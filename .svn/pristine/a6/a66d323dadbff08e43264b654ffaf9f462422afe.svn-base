<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
    <script src="<%=basePath%>/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <title>移动行为分析-联网方式</title>
</head>

<body>
    <%@ include file="top.jsp" %>
    <div class="index_main">
<%--         <%@ include file="left_menu.jsp" %> --%>
		<jsp:include page="left_menu.jsp">
	        <jsp:param name="menu" value="106"/>
	    </jsp:include>
        <!-- 内容 -->
        <div class="index_content">
 			<!-- 第一行 -->
            <%@ include file="filter.jsp" %>
            <!-- 第二行 -->
            <div class="profiling_contanter_top">
			    <div class="right_data_title" id="new_users">
                    <span class="cp" id="net">联网方式</span>
                    <span class="right_data_title_glay cp" id="ope">运营商</span>
                </div>
                <!-- 按钮 -->
                <div class="btn-group btn-group-justified fl btn-group-xbk" role="group" aria-label="..." id="justified_btn">
                    <div class="btn-group" role="group">
                        <button id="nuNet" type="button" class="btn btn-default btn_radius">新增用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="auNet" type="button" class="btn btn-default">活跃用户</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="startNet" type="button" class="btn btn-default btn_radius1">启动次数</button>
                    </div>
                </div>
                <!-- 折线图 -->
                <div class="profiling_LineChart" id="netWrok"></div>
            </div>
            <!-- 第三行 -->
            <div class="profiling_contanter_bottom">
                <div class="right_data_title fl">数据明细表</div>
                <table class="data_table1 fl" id="tableNet">
                    <thead>
                    <tr>
                        <td>联网方式</td>
                        <td>新增用户</td>
                        <td>活跃用户</td>
                        <td>启动次数</td>
                        <td>累积用户</td>
                    </tr>
                    </thead>
					<tbody>
						<c:if test="${empty pageNet.items}">
							<tr>
								<td colspan="5">暂时没有任何数据</td>
							</tr>
						</c:if>
						<c:forEach items="${pageNet.items}" var="m">
							<tr>
								<td>${m.network}</td>
								<td>${m.newUser}</td>
								<td>${m.activeUser}</td> 
								<td>${m.start}</td>
								<td>${m.userCount}</td> 
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<table class="data_table1 fl" id="tableCarrier" >
                    <thead>
                    <tr>
                        <td>运营商</td>
                        <td>新增用户</td>
                        <td>活跃用户</td>
                        <td>启动次数</td>
                        <td>累积用户</td>
                    </tr>
                    </thead>
					<tbody>
						<c:if test="${empty pageCarrier.items}">
							<tr>
								<td colspan="5">暂时没</td>
							</tr>
						</c:if>
						<c:forEach items="${pageCarrier.items}" var="c">
							<tr>
								<td>${c.carrier}</td>
								<td>${c.newUser}</td>
								<td>${c.activeUser}</td>
								<td>${c.start}</td>
								<td>${c.newUserCount}</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<ul class="pagination pull-right paginationRight" id="pageNet"></ul>
				<ul class="pagination pull-right paginationRight" id="pageCarrier"></ul>
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
    <script src="<%=basePath%>/js/data_network.js"></script>
    <script src="<%=basePath%>/js/left_menu.js"></script>
    <script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>

    
   <script>
    $(function () {
    	$("#table_iconX").click(function(){
    		$("#app-form-group").removeClass("hidden")
    	})
    	
    	$("#pageNet").twbsPagination({
    		totalPages:${pageNet.totalPages},
            visiblePages:10,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?p={{number}}'
        });
    	$("#pageCarrier").twbsPagination({
    		totalPages:${pageCarrier.totalPages},
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