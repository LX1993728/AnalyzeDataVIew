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
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 使用webkit内核 -->
<meta name="renderer" content="webkit">
<!-- bootstrap -->
<link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
<!-- base style -->
<link rel="stylesheet" href="<%=basePath%>css/base.css">
<link rel="stylesheet" href="<%=basePath%>css/theme.css">
<link rel="stylesheet" href="<%=basePath%>css/index.css">
<link rel="stylesheet" href="<%=basePath%>css/Users.css">
<link rel="stylesheet" href="<%=basePath%>css/indexFunction.css">
<!-- 分页排序 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-table.css">
<!-- 分页排序 -->
<link rel="stylesheet" href="<%=basePath%>css/classic.css">
<!-- ico -->
<link rel="shortcut icon" href="<%=basePath%>imgs/favicon 1.ico" type="image/x-icon" />
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询 S-->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>移动行为分析系统</title>
</head>

<body>
	<div class="container-fluid">
		<div class="header">
			<div class="logo">
				<img src="<%=basePath%>imgs/logo.png" alt=""> <img
					src="<%=basePath%>imgs/logo-title.png" alt="">
			</div>
		</div>
		<div class="toptitle">
			<div class="toptitle-fl fl">
				<div class="toptitle-fl-span">
					<a href="<%=basePath%>rest/genneralSummary/indexView">产品中心<i></i> </a>
				</div>
				<!-- 下拉菜单按钮 -->
				<div class="btn-group perBtn">
					<button type="button" class="btn btn-default1 dropdown-toggle"
						data-toggle="dropdown">
						<span id="appIndex">${appInfo }</span><span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" id="appList">
						<c:forEach items="${appInfoList }" var="appInfo">
							<li><a href='javascript:void(0)' onclick='getAppPlatform(this)'
								id="appKey" value="${appInfo.appKey}">${appInfo.appName}</a></li>
						</c:forEach>
					</ul>
				</div>
				<!-- 下拉菜单按钮 -->
				<!-- 下拉菜单按钮 -->
				<div class="btn-group perBtn">
					<button type="button" class="btn btn-default1 dropdown-toggle"
						data-toggle="dropdown">
						<span id="platform">${appPlatform }</span> <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" id="appPlatformList">
						<c:forEach items="${appPlatformList }" var="appPlatform">
							<li><a href='javascript:void(0)' onclick='changeAppPlatform(this)'>${appPlatform.platform}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- 下拉菜单按钮 -->
			</div>
			<div class="toptitle-fr fr">
				<span class="toptitle-fr-line1 fl"></span>
				<div class="main_menu fl">
					<a href="<%=basePath%>rest/user/logout">${username}<i class="fr"></i> </a>
				</div>
				<span class="toptitle-fr-line2 fr"></span>
			</div>
		</div>
		<!-- main主体 -->
		<div class="main">
			<div class="menu fl">
				<ul class="parentWrap">
					<li><span class="groupTitle"><s class="idx"><img
								src="<%=basePath%>imgs/little-icon/Survey_hover.png" alt=""> </s>总体概况<i
							class="fr"></i> </span>
						<ul class="friends">
							<li><a href="<%=basePath%>rest/genneralSummary/indexView">应用概况</a>
							</li>
						</ul></li>
					<li><span class="groupTitle"><s class="idx"><img
								src="<%=basePath%>imgs/little-icon/User.png" alt=""> </s>用户与使用<i
							class="fr"></i> </span>
						<ul class="friends">
							<li><a href="<%=basePath%>rest/UserAndUse/NewAndStart">新增和启动</a>
							</li>
							<li><a href="<%=path%>/rest/UserAndUse/activeAnalysis">活跃分析</a>
							</li>
							<li><a href="<%=path%>/rest/UserAndUse/timeAnalysis">时段分析</a>
							</li>
							<li><a href="<%=path%>/rest/UserAndUse/areaDis">地区分析</a>
							<li><a href="<%=basePath%>rest/versionDistribution/versionView"
								class="friends-color">版本分析</a>
							</li>
							<li><a href="<%=path%>/rest/UserAndUse/equipmentModl">设备机型</a>
							</li>
							<li><a href="<%=basePath%>rest/networkAndOper/networkAndOperView">运营商与网络</a>
							</li>
						</ul></li>
					<li><span class="groupTitle"><s class="idx"><img
								src="<%=basePath%>imgs/little-icon/ParticipateIn.png" alt=""> </s>参与与留存<i
							class="fr"></i> </span>
						<ul class="friends">
							<li><a href="<%=basePath%>rest/retention/retentionView">用户留存</a></li>
							<li><a href="<%=basePath%>rest/backLost/backLostView">流失用户</a>
							</li>
							<li><a href="<%=basePath%>rest/returnVisit/returnVisitView">用户回访</a>
							</li>
							<li><a href="<%=basePath%>rest/startDay/startDayView">日启动次数</a></li>
						</ul></li>
					<li><span class="groupTitle"><s class="idx"><img
								src="<%=basePath%>imgs/little-icon/Custom.png" alt=""> </s>事件分析<i
							class="fr"></i> </span>
						<ul class="friends">
							<li><a href="<%=path%>/rest/event/eventView">模块分析</a></li>
							<li><a href="<%=path%>/rest//EventAnalysis/ExceptionAnalysis">异常分析</a>
							</li>
						</ul></li>
					<li><span class="groupTitle"><s class="idx"><img
								src="<%=basePath%>imgs/little-icon/Channel.png" alt=""> </s>事件通知<i
							class="fr"></i> </span>
						<ul class="friends">
							<li><a href="<%=basePath%>rest/earlyWarnning/earlyWarnningView">预警通知</a>
							</li>
							<!-- <li><a href="#">趋势汇总</a>
							</li> -->
						</ul></li>
					<li><span class="groupTitle"><s class="idx"><img
								src="<%=basePath%>imgs/little-icon/AnalysisTools.png" alt=""> </s>业务分析<i
							class="fr"></i> </span>
						<ul class="friends">
						<li><a href="<%=path%>/rest/businessAnaly/operecord">操作记录</a></li>
						<li><a href="<%=path%>/rest/businessAnaly/exceprecord">异常记录</a></li>
							<!-- <li><a href="#">统计汇总</a>
							</li> -->
						</ul></li>
					<%-- <li><span class="groupTitle"><s class="idx"><img
								src="<%=basePath%>imgs/little-icon/SetUp.png" alt=""> </s>系统管理<i
							class="fr"></i> </span>
						<ul class="friends">
							<li><a href="System-Yh.html">用户管理</a>
							</li>
							<li><a href="System-Js.html">角色管理</a>
							</li>
							<li><a href="System-Qx.html">权限管理</a>
							</li>
							<li><a href="System-Cd.html">菜单管理</a>
							</li>
						</ul></li> --%>
				</ul>
			</div>
			<div class="content fr">
				<!-- 日期控件 -->
				<div class="users-dataTime">
					<!-- Split button -->
					<div class="btn-group">
						<button type="button" class="btn-timeData fl btnShow" id="timeShow">${startTime
							} ~ ${endTime }</button>
						<button type="button" class="dropdown-timeData fl btnShow"></button>
						<div class="dropdown-menu-data fl">
							<div class="dropdown-menu-data-top">
								<a href='javascript:void(0)' onclick='getEchartModelData(this)'
									value="0">今日</a>| <a href='javascript:void(0)'
									onclick='getEchartModelData(this)' value="1">昨日</a>| <a
									href="javascript:void(0)" onclick='getEchartModelData(this)' value="7">近7天</a>|
								<a href='javascript:void(0)' onclick='getEchartModelData(this)'
									value="30">近30日</a>|<!--  <select name="" id="">
									<option value="">一月</option>
									<option value="">二月</option>
									<option value="">三月</option>
									<option value="">四月</option>
									<option value="">五月</option>
									<option value="">六月</option>
									<option value="">七月</option>
									<option value="">八月</option>
									<option value="">九月</option>
									<option value="">十月</option>
									<option value="">十一月</option>
									<option value="">十二月</option>
								</select>| --> <a href='javascript:void(0)' onclick='getEchartModelData(this)'
									value="365">近一年</a>
							</div>
							<div class="dropdown-menu-data-middle">
								自定&nbsp <input type="text" id="startTime" class="Wdate"
									onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}',dateFmt:'yyyy-MM-dd'})"
									readonly /> &nbsp到&nbsp <input type="text" id="endTime" class="Wdate"
									onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',dateFmt:'yyyy-MM-dd'})"
									readonly />
							</div>
							<div class="dropdown-menu-data-bottom">
								<button type="button" class="btnOff fr">取消</button>
								<button type="button" class="btnSuccess fr"
									onclick='getEchartModelDataByCustom()'>确定</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 第二排 -->
				<div class="panel panel-default">
					<div class="panel-heading no-collapse gk-title">版本分布</div>
					<table id="queryVersionTable" class="table-font table table-striped">
					</table>
				</div>
				<!-- 第四排 -->
				<div class="panel panel-default">
					<div class="panel-heading no-collapse gk-title" style="position: relative;">
						<div class="gk-title-bbqs fl">版本趋势</div>
						<div class="gk-titles fl">
							<select class="gk-title-select-long" id="allVersion">
							</select>
						</div>
						<div class="fr">
							<div class="fl selectlble">版本对比:</div>
							<div class="selectlble-relative fl"
								style=" z-index:99; margin-right:5px;" id="selectlbleRelative"
								onclick='getContrastVersion()'>
								<a class="selectlble-relative-time" href="javascript:void(0);"></a> <span
									class="selectlble-relative-time-span"> <font
									style="margin:0 5px; font-size:12px">选择对比版本</font> </span>
							</div>
						</div>
						<div class="contrastVersions fr">
							<div class="filter_left_channelCompare">
								<div class="timetxt_content_channelCompare">
									<div class="brdediv">
										<span class="fl" style="font-size: 12px">版本：</span> <span
											class="brdedivcompare fr" id="brdedivCompare">不对比</span>
									</div>
									<div class="brdedivbottom">
										<ul id="versionContrast">
										</ul>
									</div>
									<div style="line-height:20px;color:red;padding-bottom:3px;" id="prompt"></div>
								</div>
								<div class="filter_bottom">
									<div class="menu-filter_bottom">
										<button type="button" class="filter-btnOff fr" id="filterBtnOff">取消</button>
										<button type="button" class="filter-btnSuccess fr"
											id="filterBtnSuccess">确定</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="timeAnaly">
						<div class="timeAnaly-btn">
							<div class="btn-group1 fl z" role="group">
								<button id="verAddUser" type="button" class="btn-left fl">新增用户</button>
								<div class="line fl"></div>
								<button id="verActUser" type="button" class="btn-center fl">活跃用户</button>
								<div class="line fl"></div>
								<!--  <button id="verUpUser" type="button" class="btn-center fl">升级用户</button>-->
								<div class="line fl"></div>
								<button id="verStartCount" type="button" class="btn-right fl">启动次数</button>
							</div>
						</div>
						<div class="timeChart1" id="versionDisEchart"></div>
					</div>
				</div>
				<!-- 第二排 -->
				<div class="panel panel-default">
					<div class="panel-heading no-collapse gk-title">
						<span>版本明细</span> <span class="title-disable osVersion">1.2</span>
					</div>
					<table id="queryTable" class="table-font table table-striped">
					</table>
				</div>
				<!-- 第二排 -->
				<div class="row">
					<div class="col-sm-12 col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading no-collapse gk-title">
								<span>版本摘要</span> <span class="title-disable osVersion">1.2</span>
							</div>
							<table class="table table-striped">
								<thead>
									<tr>
										<td>新增用户比例</td>
										<td class="br" id="newUserRate"></td>
										<td>活跃用户比例</td>
										<td id="actUserRate"></td>
									</tr>
									<tr>
										<td>日人均启动次数</td>
										<td class="br" id="perStart"></td>
										<td>平均每天使用时长</td>
										<td id="perUse"></td>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
				<!-- 第二排 -->
			</div>
		</div>
		<div class="footer col-sm-12 col-md-12">
			<span class="footer-line"></span>
			<p>Copyright©2005-2016.CN All Rights Reserved</p>
			<p>北京安荣科技有限公司 版权所有</p>
			<p>京公网安备 111000002000008号</p>
		</div>
	</div>
	<!-- jQuery -->
	<script src="<%=basePath%>js/jquery-1.12.2.min.js"></script>
	<!-- ECharts -->
	<script src="<%=basePath%>js/echarts.js"></script>
	<!-- bootstrap -->
	<script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/index.js"></script>
	<!-- 用户与使用 -->
	<script src="<%=basePath%>js/addAndStart.js"></script>
	<!-- 日期控件 -->
	<script src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<!-- 版本分布图表 -->
	<script src="<%=basePath%>js/util.js"></script>
	<script src="<%=basePath%>js/head.js"></script>
	<script src="<%=basePath%>js/versionDistribution.js"></script>
	<!-- 排序 -->
	<script src="<%=basePath%>js/jquery.columns-1.0.min.js"></script>
	<script src="<%=basePath%>js/bootstrap-table.js"></script>
	<script src="<%=basePath%>js/bootstrap-table-zh-CN.min.js"></script>
	<!-- 默认 -->
	<script type="text/javascript">
		$(".groupTitle").eq(1).next("ul").css("display", "block");
		$("#verAddUser").addClass('btn-left1');
	</script>

</body>

</html>
