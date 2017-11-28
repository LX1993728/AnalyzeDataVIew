<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">

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
<link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
<link rel="stylesheet" href="<%=basePath%>/css/tenant_group.css">
<link rel="stylesheet" href="<%=basePath%>/css/flow_analysis.css">


<title>移动行为分析-用户分群</title>

</head>

<body>
	<!-- 头部 -->
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<%-- <%@ include file="left_menu.jsp" %> --%>
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="311" />
		</jsp:include>
		<!-- 内容 -->
        <div class="flow_analysis_content fl">
        
            <div class="flow_analysis_up fl">
                <%@ include file="filter.jsp" %>
                <div class="flow_analysis_title">流量路径图</div>
                <div class="flow_analysis_page">
                    <div class="flow_analysis_pageLeft fl">
                        <c:forEach items="${inVos}" var="in">
                        <div class="flow_analysis_pageBlock pageBlock1 ac">
                            ${in.targetName} <br><fmt:formatNumber value="${in.timesPercent } " type="number" pattern="0.00%" />
                        </div>
                        </c:forEach>
                    </div>
                    <div class="flow_page_arrow fl">
                        <div class="flowPage_arrow ac">流入</div>
                    </div>
                    <div class="flow_analysis_pageMiddle fl">${pageName} </div>
                    <div class="flow_page_arrow fl">
                        <div class="flowPage_arrow ac">流出</div>
                    </div>
                    <div class="flow_analysis_pageLeft fl">
                        <c:forEach items="${outVos}" var="out">
                        <div class="flow_analysis_pageBlock pageBlock5 ac">
                            ${out.targetName} <br><fmt:formatNumber value="${out.timesPercent} " type="number" pattern="0.00%" />
                        </div>
                        </c:forEach>
                        <%--<div class="flow_analysis_pageBlock pageBlock6 ac">--%>
                            <%--page2<br>40%--%>
                        <%--</div>--%>
                        <%--<div class="flow_analysis_pageBlock pageBlock7 ac">--%>
                            <%--page2<br>40%--%>
                        <%--</div>--%>
                        <%--<div class="flow_analysis_pageBlock pageBlock8 ac">--%>
                            <%--page2<br>40%--%>
                        <%--</div>--%>
                    </div>

                </div>
            </div>
            <!-- 页面分析 -->
            <div class="flow_analysis_down">
                <div class="flow_analysis_title1">页面分析</div>
                <table class="flowAnalysis_Table">
                    <thead>
                        <tr>
                            <th>当前页面</th>
                            <th>类型(流入/流出)</th>
                            <th>目标页面</th>
                            <th>流入/出 方式</th>
                            <th>总流量</th>
                            <th>平均停留时长</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty page.items}">
                        <tr>
                            <td colspan="6">暂时没有任何数据</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${page.items}" var="m">
                        <tr>
                            <td>${m.name}</td>
                            <td>${m.type ==0?'流入':'流出'}</td>
                            <td>${m.targetname}</td>
                            <td>${m.mode}</td>
                            <td>${m.times}</td>
                            <td>${m.stayaverage}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
			
		<ul class="pagination pull-right paginationRight" id="page"></ul>
	</div>
	<!-- jQuery -->
	<script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
	<!-- bootstrap -->
	<script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
	<!-- js  -->
	<script src="<%=basePath%>/js/index.js"></script>
	<%--<script src="<%=basePath%>/js/tenant_group.js"></script>--%>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<script src="<%=basePath%>/js/getAppkey.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
	<%--<script src="<%=basePath%>/js/retained_profile.js"></script>--%>
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {

			$("#table_iconX").click(function() {
				$("#app-form-group").removeClass("hidden")
			});


            $("#page").twbsPagination({
                totalPages : '${page.totalPages}',
                visiblePages : 10,
                first : '首页',
                prev : '上一页',
                next : '下一页',
                last : '末页',
                href : '?p={{number}}&name=${apd.name}&beginDate=<fmt:formatDate value="${apd.beginDate}" pattern="yyyy-MM-dd" /> &endDate=<fmt:formatDate value="${apd.endDate}" pattern="yyyy-MM-dd" />'
            });

            $("#appkey").remove();
            $(".searchDate").click(function() {
                $("#btn_group_time_id").removeClass("hidden")
            });
            $("#timeButton-cancel").click(function() {
                $("#btn_group_time_id").addClass("hidden")
            });
            $("#searchDate").html('<fmt:formatDate value="${apd.beginDate}" pattern="yyyy-MM-dd" /> ~ <fmt:formatDate value="${apd.endDate}" pattern="yyyy-MM-dd" />');
            $("#tipData").click(function() {
                startDate = $("#startDate").val();
                endDate = $("#endDate").val();
                date = startDate + "~" + endDate;
                $("#searchDate").html(date);
                location.href = '?name=${apd.name}&beginDate='+startDate+'&endDate='+endDate;
            });
        });
    </script>
		

</body>
</html>