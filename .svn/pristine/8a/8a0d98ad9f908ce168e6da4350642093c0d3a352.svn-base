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
<!DOCTYPE html>
<html lang="zh-CN">

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
<link rel="stylesheet" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" href="<%=basePath%>css/base.css">
<link rel="stylesheet" href="<%=basePath%>css/research_report.css">
<link rel="stylesheet" href="<%=basePath%>/css/data_analysis.css">
<title>移动数据分析-数据分析</title>
</head>

<body>
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<!-- 侧边栏 -->
		<%--       <%@ include file="left_menu.jsp" %> --%>
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="200" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<!-- 第一行 -->
			<div class="index_content_top">
				<div class="index_content_top_left fl">
					<div class="table_caption">
						<div class="fl cp title_caption_table" id="table_caption_title">
							<div class="fl table_title" rel="${sessionScope.appKey}"
								id="get_appKey">${sessionScope.appInfo }</div>
						</div>
						<!-- 选择平台 -->
						<c:if test="${not empty appPlatformList && empty platFormCheck }">
							<div class="table_icon fl" id="table_iconX">
								<c:forEach items="${appPlatformList}" var="apf">
									<c:if test="${apf.platform eq 'android'}">
										<div class="menu_icon android fl" val="android"></div>
									</c:if>
									<c:if test="${apf.platform eq 'ios'}">
										<div class="menu_icon ios fl" val="ios"></div>
									</c:if>
									<c:if test="${apf.platform eq 'webApp'}">
										<div class="menu_icon webApp fl" val="webApp"></div>
									</c:if>
								</c:forEach>
								<div class="menu_arrow_icon fr" id="choosePlat"></div>
							</div>
						</c:if>
						<c:if test="${not empty platFormCheck }">
							<div class="table_icon fl" id="table_iconX">
								<c:forEach items="${ sessionScope.platFormCheck}" var="apf">
									<c:if test="${apf eq 'android'}">
										<div class="menu_icon android fl" val="android"></div>
									</c:if>
									<c:if test="${apf eq 'ios'}">
										<div class="menu_icon ios fl" val="ios"></div>
									</c:if>
									<c:if test="${apf eq 'webApp'}">
										<div class="menu_icon webApp fl" val="webApp"></div>
									</c:if>
								</c:forEach>
								<div class="menu_arrow_icon fr" id="choosePlat"></div>
							</div>
						</c:if>
					</div>
					<!-- 程序下拉列表 -->
					<div class="table_icon_down1 fl">
						<ul class="list-group list_group_procedure">
							<c:if test="${not empty sessionScope.appInfoList}">
								<c:forEach items="${sessionScope.appInfoList }" var="appInfo">
									<li class="list-group-item group-item1 appKey"
										rel="${appInfo.appKey}">
										<!-- onclick='getAppPlatform(this)' --> <a
										href='javascript:void(0)' onClick="getAppKey(this)"
										value="${appInfo.appKey}">${appInfo.appName}</a>
									</li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
					<!-- 版本下拉列表 -->
					<div class="table_icon_down fl" id="app-form-group">
						<c:if test="${not empty sessionScope.appPlatformList}">
							<c:forEach items="${sessionScope.appPlatformList }" var="appInfo">
								<c:if test="${appInfo.platform eq 'android'}">
									<div class="table_icon_check">
										<input type="checkbox" name="platform"
											class="table_checkbox fl check_choose" value="android" />
										<div class="menu_icon android fl"></div>
									</div>
								</c:if>
								<c:if test="${appInfo.platform eq 'ios'}">
									<div class="table_icon_check">
										<input type="checkbox" name="platform"
											class="table_checkbox fl check_choose" value="ios" />
										<div class="menu_icon ios fl"></div>
									</div>
								</c:if>
								<c:if test="${appInfo.platform eq 'webApp'}">
									<div class="table_icon_check">
										<input type="checkbox" name="platform"
											class="table_checkbox fl check_choose" value="webApp" />
										<div class="menu_icon webApp fl"></div>
									</div>
								</c:if>
							</c:forEach>
						</c:if>
						<div class="table_icon_check1">
							<button class="btn_confirm fl" onClick="getPlatForm(this)"
								id="pla_Form_bt">确定</button>
							<button class="btn_cancel fr">取消</button>
						</div>
					</div>
					<div class="right_data_title" id="new_users">
						<span class="cp" id="nut_load">人均使用时长</span> <span
							class="right_data_title_glay cp" id="ones_user">一次性用户</span>
					</div>
					<div id="content_fade">
						<div id="nut" class="newadd_content data_form"></div>
						<div id="aut" class="newadd_content data_form hide"></div>
					</div>
				</div>
				<div class="index_content_top_right fr">
					<div class="right_data_title">性别分布</div>
					<div class="user_portrait">
						<img src="<%=basePath%>/imgs/man.png" class="people" /><span
							id="boy"></span> <img src="<%=basePath%>/imgs/women.png"
							class="people" /><span id="girl"></span>
					</div>
					<div class="age_data_title">年龄分布</div>
					<div id="age" class="user_portrait"></div>
				</div>
			</div>
			<!-- 第二行 -->
			<div class="index_content_center">
				<div class="index_content_top_left fl">
					<div class="right_data_title table_title_bottom">研报</div>
					<table class="data_table">
						<tr>
							<td>指标</td>
							<td>评价</td>
							<td>权重</td>
							<td class="border_left">总评价</td>
						</tr>
						<tr>
							<td>用户数据健康度</td>
							<td><div class="healthy_text_name comment">
									<ul class="report_subtitle_ul">
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi"></li>
										<li class="report_subtitleLi"></li>
									</ul>
								</div></td>
							<td>5</td>
							<td rowspan="4" class="border_left zf"><div
									class="healthy_text_name comment">
									<ul class="report_subtitle_ul">
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi"></li>
										<li class="report_subtitleLi"></li>
									</ul>
								</div></td>
						</tr>
						<tr>
							<td>应用健壮性</td>
							<td><div class="healthy_text_name comment">
									<ul class="report_subtitle_ul">
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi"></li>
										<li class="report_subtitleLi"></li>
									</ul>
								</div></td>
							<td>4</td>
						</tr>
						<tr>
							<td>用户体验</td>
							<td><div class="healthy_text_name comment">
									<ul class="report_subtitle_ul">
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi"></li>
										<li class="report_subtitleLi"></li>
									</ul>
								</div></td>
							<td>5</td>
						</tr>
						<tr>
							<td>渠道推广</td>
							<td><div class="healthy_text_name comment">
									<ul class="report_subtitle_ul">
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi report_subtitleHoverLi"></li>
										<li class="report_subtitleLi"></li>
										<li class="report_subtitleLi"></li>
									</ul>
								</div></td>
							<td>3</td>
						</tr>
					</table>
				</div>
				<div class="index_content_top_right fr">
					<div class="right_data_title">渠道分布</div>
					<div id="mou" class="user_distribution"></div>
				</div>
			</div>
			<!-- 第三行 -->
			<div class="index_content_top">
				<div class="index_content_top_left fl">
					<div class="right_data_title">事件详情</div>
					<div style="width: 50%; height: 100%; float: left;">
						<table class="data_table1">
							<thead>
								<tr>
									<td>事件名称</td>
									<td>事件节点</td>
									<td>节点触发数</td>
									<td>节点达成数</td>
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
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="sj" style="width: 50%; height: 100%; float: left;"></div>
				</div>
				<div class="index_content_top_right fr">
					<div class="right_data_title">事件最优路径</div>
					<div class="user_distribution1">
						<table class="data_table1">
							<thead>
								<tr>
									<td>路径名称</td>
									<td>触发事件</td>
									<td>触发数</td>
									<td>完成数</td>
								</tr>
							</thead>
							<tbody>
								<c:if test="${empty bastPath}">
									<tr>
										<td colspan="5">暂时没有任何数据</td>
									</tr>
								</c:if>
								<c:forEach items="${bastPath}" var="event">
									<tr>
										<td>${event.eventPath}</td>
										<td>${event.eventName}</td>
										<td>${event.pathNum}</td>
										<td>${event.reachPathNum}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
	<script src="<%=basePath%>/js/data_analysis.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<!-- echarts -->
	<script src="<%=basePath%>/js/echarts.js"></script>
	<script src="<%=basePath%>/js/getAppkey.js"></script>
	<script src="<%=basePath%>/js/echarts.sec.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>



	<script>
		$("#choosePlat").click(function() {
			$("#app-form-group").removeClass("hidden")
		});

		$(".check_choose").click(function() {
			var fx = $(this).attr("checked");
			if (fx == undefined) {
				$(this).attr("checked", "checked");
			}
		});
	</script>

</body>

</html>