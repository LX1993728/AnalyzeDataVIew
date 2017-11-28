<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ taglib prefix="format" uri="http://www.anrong.cn/format" %>
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

    <title>移动行为分析-用户分析</title>

</head>

<body>
<!-- 头部 -->
<%@ include file="top.jsp" %>
<div class="index_main">
    <%-- <%@ include file="left_menu.jsp" %> --%>
    <jsp:include page="left_menu.jsp">
        <jsp:param name="menu" value="311"/>
    </jsp:include>
    <!-- 内容 -->
    <div class="page_analysis_content">
        <jsp:include page="filter.jsp"/>
        <!-- 页面分析 -->
        <div class="flow_analysis_down1">
            <div class="flow_analysis_title1 fl">页面分析</div>
            <!-- <div class="flow_analysis_titleBtn fr">
                <input type="text" class="flowAnalysis_input" placeholder="搜索">
                <span class="glyphicon glyphicon-search flowAnalysis_inputSearch"></span>
                <div class="altDownload">
                    <span
                        class="glyphicon glyphicon-download-alt flowAnalysis_altDownload"></span>
                </div>

            </div> -->
            <table class="flowAnalysis_Table">
                <thead>
                <tr>
                    <th>页面<s class="flowAnalysis_TableArrow fr"></s></th>
                    <th>页面名<s class="flowAnalysis_TableArrow fr"></th>
                    <th>访问人数/占比<s class="flowAnalysis_TableArrow fr"></th>
                    <th>访问次数/占比<s class="flowAnalysis_TableArrow fr"></th>
                    <th>平均停留时长<s class="flowAnalysis_TableArrow fr"></th>
                    <th>离开率<s class="flowAnalysis_TableArrow fr"></th>
                    <th>走向<s class="flowAnalysis_TableArrow fr"></th>
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
                        <td>${m.pagecode}</td>
                        <td>${m.name }</td>
                        <td>${m.totalnumber }/<fmt:formatNumber value="${m.totalnumberproportion }" type="number"
                                                                pattern="0.00%"/></td>
                        <td>${m.totaltimes }/<fmt:formatNumber value="${m.totaltimesproportion }" type="number"
                                                               pattern="0.00%"/></td>
                        <td>
                                ${format:timeDiff(m.stayaverage) }
                        </td>
                        <td><fmt:formatNumber value="${m.departurerate }" type="number" pattern="0.00%"/></td>
                        <td>
                            <a href="pdetail?name=${m.pagecode}&beginDate=<fmt:formatDate value="${ap.beginDate}" pattern="yyyy-MM-dd" /> &endDate=<fmt:formatDate value="${ap.endDate}" pattern="yyyy-MM-dd" />"
                               class="altDownload_color">查看</a>
                        </td>
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
    $(function () {

        $("#table_iconX").click(function () {
            $("#app-form-group").removeClass("hidden")
        });

        $("#page").twbsPagination({
            totalPages: '${page.totalPages}',
            visiblePages: 10,
            first: '首页',
            prev: '上一页',
            next: '下一页',
            last: '末页',
            href: '?p={{number}}&beginDate=<fmt:formatDate value="${ap.beginDate}" pattern="yyyy-MM-dd" /> &endDate=<fmt:formatDate value="${ap.endDate}" pattern="yyyy-MM-dd" />'
        });

        $("#appkey").remove();
        $(".searchDate").click(function() {
            $("#btn_group_time_id").removeClass("hidden")
        });
        $("#timeButton-cancel").click(function() {
            $("#btn_group_time_id").addClass("hidden")
        });
        $("#searchDate").html('<fmt:formatDate value="${ap.beginDate}" pattern="yyyy-MM-dd" /> ~ <fmt:formatDate value="${ap.endDate}" pattern="yyyy-MM-dd" />');
        $("#tipData").click(function() {
            startDate = $("#startDate").val();
            endDate = $("#endDate").val();
            date = startDate + "~" + endDate;
            $("#searchDate").html(date);
            location.href = '?beginDate='+startDate+'&endDate='+endDate;
        });
    });

</script>


</body>
</html>