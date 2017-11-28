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
<link rel="stylesheet" href="<%=basePath%>/css/add_systemusers.css">
<link rel="stylesheet" href="<%=basePath%>/css/user_analysis.css">
<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
<title>移动行为分析-用户画像</title>
</head>

<body>
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="309" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<!-- 第一行 -->
			<div class=user_group_content>
				<div class="user_group_sex fl">
					<div class="table_caption">
						<div class="fl cp title_caption_table" id="table_caption_title">
							<div class="fl table_title" rel="${sessionScope.appKey}"
								id="get_appKey">${sessionScope.appInfo }</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="cut_title">用户画像</div>
				<div class="clear"></div>
				<div class="user_group_cut fl">
					<div class="right_data_title fl">
						性别分布<img class="help_imgs" id="sexHelp"
							src="<%=basePath%>imgs/help.png" />
					</div>
					<!-- 起泡  -->
					<div id="sexInstruction" class="instruction_dialog fl hide">性别分布:
						依据用户对应用的使用情况预测用户的性别，这个性别是指用户的行为特征性别，与用户身份证记录的性别有一定差异。</div>
					<div class="user_group_charts" id="userSex"></div>
				</div>
				<div class="cut_right"></div>
				<div class="user_group_cut fl">
					<div class="right_data_title fl">
						年龄分布 <img class="help_imgs" id="ageHelp"
							src="<%=basePath%>imgs/help.png" />
					</div>
					<div id="ageInstruction" class="instruction_dialog fl hide">年龄分布：依据对用户使用应用的行为的研究预测用户的年龄分布。</div>
					<div class="user_group_charts" id="userAge"></div>
				</div>
				<div class="clear"></div>
				<div class="user_analysis fl">
					<div class="right_data_title fl">
						地区分布<img class="help_imgs" id="areaHelp"
							src="<%=basePath%>imgs/help.png" />
					</div>
					<div id="areaInstruction" class="instruction_dialog fl hide">地区分布:
						依据用户对应用的使用情况预测用户的地区，与用户身份记录的地区可能会有一定差异。</div>
					<div class="user_group_charts" id="userArea"></div>
				</div>
				<div class="user_analysis fl">
					<div class="right_data_title fl">TOP10省份</div>
					<div class="user_group_charts" id="userTopArea"></div>
				</div>
				<div class="user_group fl">
					<div class="right_data_title fl">
						移动设备偏好<img class="help_imgs" id="moblieHelp" src="<%=basePath%>imgs/help.png" />
					</div>
					<div id="moblieInstruction" class="instruction_dialog fl hide">移动设备偏好:
						根据各大主要移动设备卖场公布的设备特征对设备进行分类并统计样本中各类设备的占比。</div>
					<canvas id="aa" width="1100" height="300"></canvas>
					<script src="<%=basePath%>/js/d3.min.js"></script>
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
	<script src="<%=basePath%>/js/echarts.js"></script>
	<script src="<%=basePath%>/js/china.js"></script>
	<script src="<%=basePath%>/js/user_portrait.js"></script>
</body>
</html>