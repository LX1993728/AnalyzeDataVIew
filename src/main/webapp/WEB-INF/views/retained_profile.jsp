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
<title>移动行为分析-留存概况</title>

</head>

<body>
	<!-- 头部 -->
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<%-- <%@ include file="left_menu.jsp" %> --%>
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="102" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<!-- 第一行 -->
			<%@ include file="filter.jsp"%>
			<!-- 按钮 -->
			<div class="hide">
				<input type="text" value="${startDate}" id="startTime" /> 
				<input type="text" value="${endDate}" id="endTime" />
				<input type="text" value="${eventFlag}" id="retainedFlag"/>
			</div>
			<div class="btn-group btn-retained_profile fr" role="group"
				aria-label="..." id="justified_btn">
				<button type="button" class="retained_width retained_width_right"
					onclick="getdateTerms('dayClick')">日</button>
				<button type="button" class="retained_width retained_width_right"
					onclick="getdateTerms('weekClick')">周</button>
				<button type="button" class="retained_width"
					onclick="getdateTerms('monthClick')">月</button>
				<!-- <div class="btn-group" role="group">
                        <button type="button" id="nUser" class="btn btn-default btn_radius" onclick="showEcharts('usert','pageUs')">日</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="sumUser" type="button" class="btn btn-default" onclick="showEcharts('usert','pageUs')">周</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button id="ageTime" type="button" class="btn btn-default btn_radius1" onclick="showEcharts('timet','pageAvgTime')">月</button>
                    </div> -->
			</div>
			<!-- 第二行 -->
			<div class="retauned_profile">
				<div class="right_data_title">
					<span class="cp" onclick="getClick('newUserClick')" id="retained_new_users">新增留存</span> <span
						class="right_data_title_glay cp"
						onclick="getClick('activeUserClick')"  id="retained_active_users">活跃留存</span>
				</div>
				<div id="content_fade">
					<div class="newadd_content retauned_profile_content">

						<table id="t" class="table table_index table_retauned_profile">
							<thead id="mark">
								<!-- <tr>
									<td>日期</td>
									<td>用户数</td>
								</tr> -->
							</thead>
							<tbody id="tb">
							</tbody>
						</table>
						<ul class="pagination pull-right paginationRight"
							id="pageRetained"></ul>
					</div>
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
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<script src="<%=basePath%>/js/getAppkey.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
	<script src="<%=basePath%>/js/retained_profile.js"></script>
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
		type="text/javascript"></script>
		
		
</body>
</html>