<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 使用webkit内核 -->
<meta name="renderer" content="webkit">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="<%=basePath%>bootstrap/css/bootstrap.min.css">
<!-- style.css -->
<link rel="stylesheet" href="<%=basePath%>css/base.css">
<link rel="stylesheet" href="<%=basePath%>css/research_report.css">
<title>移动行为分析-研报</title>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="researcch_report_title">
		<p class="report_titleName ac">移动行为分析系统10月份研报</p>
		<div class="report_subtitle">
			<span class="report_subtitle_date fl">日期：2017-10</span> <span
				class="report_subtitle_date subtitle_type fl">类型：月报</span> <span
				class="report_subtitle_date fl">评价：</span>
			<ul class="report_subtitle_ul fl">
				<li class="report_subtitleLi report_subtitleHoverLi"></li>
				<li class="report_subtitleLi report_subtitleHoverLi"></li>
				<li class="report_subtitleLi report_subtitleHoverLi"></li>
				<li class="report_subtitleLi report_subtitleHoverLi"></li>
				<li class="report_subtitleLi"></li>
			</ul>
		</div>
	</div>
	<!-- 第一行 -->
	<div class="researcch_report_healthy report_anchor_spot">
		<div class="report_healthy_left fl">
			<div class="report_healthy_left_title fl">
				<s class="healthy_titleBorder fl"></s> <span class="fl">用户数据健康度</span>
			</div>
			<div class="report_healthy_text fl clearfix">
				<div class="healthy_text_name">用户增长率</div>
				<div class="healthy_text_name">
					<span class="fl">评价：</span>
					<ul class="report_subtitle_ul text_name_top fl">
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi"></li>
						<li class="report_subtitleLi"></li>
					</ul>
				</div>
				<div class="healthy_text_name">权重：${upw}</div>
				<div class="healthy_text_name">本月用户增量：${addUser}</div>
				<div class="healthy_text_name">用户环比增长率：${userGrowRate}</div>
				<div class="healthy_text_name">新增用户环比增长率：${newUserRate}</div>
			</div>
			<div class="report_healthy_text fl" id="userHD"></div>
		</div>
		<div class="report_healthy_left fl">
			<div class="report_healthy_left_title fl">
				<span class="fl">健康度</span>
				<ul class="report_subtitle_ul text_name_top1 fl">
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi"></li>
					<li class="report_subtitleLi"></li>
				</ul>
			</div>
			<div class="clearfix">
				<div class="report_healthy_text fl">
					<div class="healthy_text_name">活跃用户增长率</div>
					<div class="healthy_text_name">
						<span class="fl">评价：</span>
						<ul class="report_subtitle_ul text_name_top fl">
							<li class="report_subtitleLi report_subtitleHoverLi"></li>
							<li class="report_subtitleLi report_subtitleHoverLi"></li>
							<li class="report_subtitleLi report_subtitleHoverLi"></li>
							<li class="report_subtitleLi"></li>
							<li class="report_subtitleLi"></li>
						</ul>
					</div>
					<div class="healthy_text_name">权重：${auw}</div>
					<div class="healthy_text_name">活跃用户增长率：${activeUserRate}</div>
					<div class="healthy_text_name">活跃用户增量：${actvieUser}</div>
					<div class="healthy_text_name">活跃用户占比增量：${slAC}</div>
					<div class="healthy_text_name">活跃用户占比增长率：${lastACRate}</div>
				</div>
				<div class="report_healthy_text3 fl">
					<div class="report_topTable" id="actUserNumT"></div>
					<div class="report_bottomTable" id="actUserNumD"></div>
				</div>
			</div>
			<div class="report_healthy_text fl"></div>
		</div>
	</div>
	<!-- 第二行 -->
	<div class="researcch_report_subject report_anchor_spot">
		<div class="report_healthy_left subject_top fl clearfix">
			<!-- <div class="clearfix"> -->
			<div class="report_healthy_text3 fl">
				<div class="report_topTable" id="actUserT"></div>
				<div class="report_bottomTable" id="actUserD"></div>
			</div>
			<div class="report_healthy_text text_name_top fl">
				<div class="healthy_text_name">活跃用户留存率</div>
				<div class="healthy_text_name">
					<span class="fl">评价：</span>
					<ul class="report_subtitle_ul text_name_top fl">
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi"></li>
						<li class="report_subtitleLi"></li>
					</ul>
				</div>
				<div class="healthy_text_name">权重：${acturrw}</div>
				<div class="healthy_text_name">活跃用户留存率：${ActUserReRate}</div>
				<div class="healthy_text_name">活跃留存占比增量：${actUserRe}</div>
				<div class="healthy_text_name">活跃留存占比增长率：${ActUserRate}</div>
			</div>
		</div>
		<div class="report_healthy_left subject_top fl">
			<div class="report_healthy_text fl clearfix" id="actUserRR"></div>
			<div class="report_healthy_text text_name_top fl">
				<div class="healthy_text_name">用户留存率</div>
				<div class="healthy_text_name">
					<span class="fl">评价：</span>
					<ul class="report_subtitle_ul text_name_top fl">
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi"></li>
						<li class="report_subtitleLi"></li>
						<li class="report_subtitleLi"></li>
					</ul>
				</div>
				<div class="healthy_text_name">权重：${ruaddw}</div>
				<div class="healthy_text_name">本月用户留存增量：${userRetained}</div>
				<div class="healthy_text_name">用户留存率增量：${slpUserRe}</div>
			</div>
		</div>
	</div>
	<!-- 第三行 -->
	<div class="report_appHealthy report_anchor_spot">
		<div class="report_appHealthy_left fl">
			<div class="report_healthy_left_title fl">
				<s class="healthy_titleBorder fl"></s> <span class="fl">应用健壮性</span>
			</div>
			<div class="report_healthy_text1 fl clearfix">
				<div class="healthy_text_name">应用操作异常率：${startExceRate}</div>
				<div class="healthy_text_name">当月应用异常率：${applicationExceRate}</div>
				<div class="healthy_text_name">应用异常增长率：${slApplicationExceRate}</div>
				<div class="healthy_text_name">
					<span class="fl">评价：</span>
					<ul class="report_subtitle_ul text_name_top fl">
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi"></li>
					</ul>
				</div>
				<div class="healthy_text_name">权重：${appew}</div>
			</div>
		</div>
		<div class="report_appHealthy_middle fl" id="pexception"></div>
		<div class="report_appHealthy_left fr">
			<div class="report_healthy_left_title fl">
				<span class="fl">健壮性</span>
				<ul class="report_subtitle_ul text_name_top1 fl">
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi"></li>
					<li class="report_subtitleLi"></li>
					<li class="report_subtitleLi"></li>
				</ul>
			</div>
			<div class="report_healthy_text1 fl clearfix">
				<div class="healthy_text_name">页面操作异常率：${pageVisitExceRate}</div>
				<div class="healthy_text_name">当月页面异常率：${sPageExceRate}</div>
				<div class="healthy_text_name">页面异常增长率：${slPageExceRate}</div>
				<div class="healthy_text_name">
					<span class="fl">评价：</span>
					<ul class="report_subtitle_ul text_name_top fl">
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi"></li>
					</ul>
				</div>
				<div class="healthy_text_name">权重：${pagew}</div>
			</div>
		</div>
	</div>
	<!-- 第四行 -->
	<div class="researcch_report_subject report_anchor_spot">
		<div class="report_healthy_left fl">
			<div class="report_healthy_left_title fl">
				<s class="healthy_titleBorder fl"></s> <span class="fl">用户体验</span>
			</div>
			<div class="report_healthy_text2 fl clearfix">
				<div class="healthy_text_name">用户评价</div>
				<div class="healthy_text_name">
					<span class="fl">评价：</span>
					<ul class="report_subtitle_ul text_name_top fl">
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi report_subtitleHoverLi"></li>
						<li class="report_subtitleLi"></li>
						<li class="report_subtitleLi"></li>
					</ul>
				</div>
				<div class="healthy_text_name">权重：${ucrw}</div>
				<div class="healthy_text_name">用户好评率：${pc}</div>
				<div class="healthy_text_name">用户评价率：${cvRate}</div>
			</div>
			<div class="report_healthy_text2 bg_pink fl" id="visitrate"></div>
		</div>
		<div class="report_healthy_left fl">
			<div class="report_healthy_left_title fl">
				<span class="fl">体验度</span>
				<ul class="report_subtitle_ul text_name_top1 fl">
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi"></li>
					<li class="report_subtitleLi"></li>
				</ul>
			</div>
			<div class="clearfix">
				<div class="report_healthy_text2 fl">
					<div class="healthy_text_name">用户评价增长状况</div>
					<div class="healthy_text_name">
						<span class="fl">评价：</span>
						<ul class="report_subtitle_ul text_name_top fl">
							<li class="report_subtitleLi report_subtitleHoverLi"></li>
							<li class="report_subtitleLi report_subtitleHoverLi"></li>
							<li class="report_subtitleLi report_subtitleHoverLi"></li>
							<li class="report_subtitleLi"></li>
							<li class="report_subtitleLi"></li>
						</ul>
					</div>
					<div class="healthy_text_name">权重：${upprw}</div>
					<div class="healthy_text_name">用户好评增长率：${slpRate}</div>
					<div class="healthy_text_name">用户评价增长率：${slcRate}</div>
				</div>
				<div class="report_healthy_text3 fl">
					<div class="report_topTable" id="preO"></div>
					<div class="report_bottomTable" id="preT"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- 第五行 -->
	<div class="report_core report_anchor_spot">
		<div class="report_core_echart fl" id="corEventL"></div>
		<div class="report_core_echart fl" id="corEventO"></div>
		<div class="report_core_echart fl" id="corEventV"></div>
		<div class="report_core_echart fl" id="corEventE"></div>
		<div class="report_core_echart fl" id="corEventT"></div>
		<div class="report_core_title">
			<div class="report_healthy_left_title core_title_box fl">
				核心事件完成率 ${feRate}</div>
			<div class="report_healthy_left_title core_title_box fl core_title_line">
				<span class="fl">评价：</span>
				<ul class="report_subtitle_ul text_name_top1 fl">
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi"></li>
					<li class="report_subtitleLi"></li>
				</ul>
			</div>
			<div class="report_healthy_left_title core_title_box fl">权重：5</div>
		</div>
	</div>
	<!-- 第六行 -->
	<div class="report_user_experience report_anchor_spot">
		<div class="report_core_title">
			<div class="report_healthy_left_title user_experience_title fl">
				<s class="healthy_titleBorder fl"></s> <span class="fl">渠道推广</span>
			</div>
			<div class="report_healthy_left_title user_experience_title fl">
				<span class="fl">推广质量</span>
				<ul class="report_subtitle_ul text_name_top1 fl">
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi report_subtitleHoverLi"></li>
					<li class="report_subtitleLi"></li>
				</ul>
			</div>
		</div>
		<div class="user_experience_left fl">
			<div class="healthy_text_name">渠道总量：${channelNum}</div>
			<div class="healthy_text_name">用户增长最多渠道：${channelName}</div>
			<div class="healthy_text_name">留存率最高渠道：${channelH}</div>
		</div>
		<div class="user_experience_right fr" id="reportChannel"></div>
		<!-- 锚点按钮 -->
		<ul class="anchor_spot">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
		<!-- jQuery -->
		<script src="<%=basePath%>js/jQuery 1.9.1.js"></script>
		<!-- bootstrap -->
		<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
		<!-- js  -->
		<script src="<%=basePath%>/js/echarts.js"></script>
		<script src="<%=basePath%>js/research_report.js"></script>
</body>

</html>