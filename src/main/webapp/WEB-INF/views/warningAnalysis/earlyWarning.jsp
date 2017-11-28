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
    <!-- 分页排序 -->
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-table.css">
    <!-- base style -->
    <link rel="stylesheet" href="<%=basePath%>css/base.css">
    <link rel="stylesheet" href="<%=basePath%>css/theme.css">
    <link rel="stylesheet" href="<%=basePath%>css/index.css">
    <link rel="stylesheet" href="<%=basePath%>css/Users.css">
    <link rel="stylesheet" href="<%=basePath%>css/warning.css">
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
                <img src="<%=basePath%>imgs/logo.png" alt="">
                <img src="<%=basePath%>imgs/logo-title.png" alt="">
            </div>
        </div>
        <div class="toptitle">
            <div class="toptitle-fl fl">
                <div class="toptitle-fl-span">
                    <a href="<%=basePath%>rest/genneralSummary/indexView">产品中心<i></i></a>
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
								id="appKey" value="${appInfo.appKey}">${appInfo.appName}</a>
							</li>
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
                    <a href="<%=path%>/rest/user/logout">${username}<i class="fr"></i></a>
                </div>
                <span class="toptitle-fr-line2 fr"></span>
            </div>
        </div>
        <!-- main主体 -->
        <div class="main">
            <div class="menu fl">
                <ul class="parentWrap">
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=basePath%>imgs/little-icon/Survey_hover.png" alt=""></s>总体概况<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=basePath%>rest/genneralSummary/indexView">应用概况</a></li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=basePath%>imgs/little-icon/User.png" alt=""></s>用户与使用<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=basePath%>rest/UserAndUse/NewAndStart">新增和启动</a></li>
							<li><a href="<%=path%>/rest/UserAndUse/activeAnalysis">活跃分析</a></li>
							<li><a href="<%=path%>/rest/UserAndUse/timeAnalysis">时段分析</a></li>
							<li><a href="<%=path%>/rest/UserAndUse/areaDis">地区分析</a>
							</li>
							<li><a href="<%=basePath%>rest/versionDistribution/versionView">版本分析</a>
							</li>
							<li><a href="<%=path%>/rest/UserAndUse/equipmentModl">设备机型</a></li>
							<li><a href="<%=basePath%>rest/networkAndOper/networkAndOperView">运营商与网络</a>
							</li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=basePath%>imgs/little-icon/ParticipateIn.png" alt=""></s>参与与留存<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=basePath%>rest/retention/retentionView">用户留存</a>
							</li>
							<li><a href="<%=basePath%>rest/backLost/backLostView">流失用户</a>
							</li>
							<li><a href="<%=basePath%>rest/returnVisit/returnVisitView">用户回访</a>
							</li>
							<li><a href="<%=basePath%>rest/startDay/startDayView">日启动次数</a>
							</li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=basePath%>imgs/little-icon/Custom.png" alt=""></s>事件分析<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=basePath%>rest/event/eventView">模块分析</a>
							</li>
							<li><a href="<%=path%>/rest//EventAnalysis/ExceptionAnalysis">异常分析</a>
							</li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=basePath%>imgs/little-icon/Channel.png" alt=""></s>预警分析<i class="fr"></i></span>
                        <ul class="friends" style="display: block;">
                            <li><a href="<%=basePath%>rest/earlyWarnning/earlyWarnningView" class="friends-color">预警通知</a></li>
                            <!-- <li><a href="warningB.html">趋势汇总</a></li> -->
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=basePath%>imgs/little-icon/AnalysisTools.png" alt=""></s>业务分析<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=path%>/rest/businessAnaly/operecord">操作记录</a></li>
                            <li><a href="<%=path%>/rest/businessAnaly/exceprecord">异常记录</a></li>
                            <!-- <li><a href="Work-Jhty.html">交互体验统计</a></li> -->
                        </ul>
                    </li>
                    <%-- <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=basePath%>imgs/little-icon/SetUp.png" alt=""></s>系统管理<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="System-Yh.html">用户管理</a></li>
                            <li><a href="System-Js.html">角色管理</a></li>
                            <li><a href="System-Qx.html">权限管理</a></li>
                            <li><a href="System-Cd.html">菜单管理</a></li>
                        </ul>
                    </li> --%>
                </ul>
            </div>
            <div class="content fr">
                <!-- 日期控件 -->
                <button type="button" class="btn btn-primary btn-lg btn-ma" id="j_btnAddData" data-toggle="modal" data-target=".bs-example-modal-sm">+ 创建新预警</button>
                <!-- 第一排 -->
                <div class="panel panel-default" id="warn-new">
                    <div class="panel-heading no-collapse gk-title">
                        创建新预警
                    </div>
                    <div class="timeAnaly-w">
                        <div class="timeAnaly-btn1">
                           <span >预警名称:</span> 
                            <input type="text" placeholder="预警名称" id="warnName" onblur ="CheckName()" onfocus = "removeNameMessage()">
                            <span id="nameMessage" style="disploy:none"></span>
                        </div>
                        <div class="timeAnaly-btn2">
                            <span class="if">IF:</span>
                            <br>
                          <span class="exception" >异常数:</span> 
                            <select name="" id="ifCondition" class="timeAnaly-if3">
                                <option value="1">较上一日变化幅度</option>
<!--                                 <option value="2">数据量</option> -->
                            </select>
                            <select name="" id="compare" class="timeAnaly-if4">
                                <option value="1">高于</option>
                                <option value="2">低于</option>
                            </select>
                            <select name="" id="percent" class="timeAnaly-if5">
                                <option value="1">30</option>
                                <option value="2">40</option>
                            </select>
                            %
                        </div>
                        <div class="timeAnaly-btn3">
                            <span class="then">THEN:</span>  
                            <br>
                            <span>发邮件至：</span>
                            <input type="text" placeholder="请填写一个邮箱地址" id="mail" onblur = "CheckMail()" onfocus="removeMessage()" >
                            <span id="message" style="disploy:none"></span>
                        </div>
                        <div class="timeAnaly-btn4">
                            <button type="button" class="timeAnaly-btn4-save" id="warnSave">保存</button>
                            <button type="button" class="timeAnaly-btn4-cancel" id="warn-btnC">取消</button>
                        </div>
                    </div>
                </div>
                <!-- 第二排 -->
                <div class="panel panel-default">
                    <div class="panel-heading no-collapse gk-title">已建立预警项</div>
                   <!--  <div id="example-wA">
                    </div> -->
                    <table id="queryWarnningNormalTable" class="table-font table table-striped">
					</table>
                </div>
                <!-- 第三排 -->
                <div class="panel panel-default">
                    <div class="panel-heading no-collapse gk-title">通知</div>
                    <!-- <div id="example-wB">
                    </div> -->
                     <table id="queryWarnningTable" class="table-font table table-striped">
					</table>
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
    <!-- bootstrap -->
    <script src="<%=basePath%>bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/index.js"></script>
    <!--预警 -->
    <script src="<%=basePath%>js/head.js"></script>
    <script src="<%=basePath%>js/earlyWarnning.js"></script>
    <script src="<%=basePath%>js/bootstrap-table.js"></script>
	<script src="<%=basePath%>js/bootstrap-table-zh-CN.min.js"></script>
    <!-- 排序 -->
    <script src="<%=basePath%>js/jquery.columns-1.0.min.js"></script>
    <!-- 默认 -->
    <script>
    // $(".groupTitle").eq(4).next("ul").css("display", "block");
    </script>
    <script>
    //example 1 
    $('#example-wA').columns({
        data: [{
            'Emp. Number': 00001,
            'First Name': 'John',
            'Last Name': 'Smith',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00002,
            'First Name': 'Jane',
            'Last Name': 'Doe',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00003,
            'First Name': 'Ted',
            'Last Name': 'Johnson',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00004,
            'First Name': 'Betty',
            'Last Name': 'Smith',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00005,
            'First Name': 'Susan',
            'Last Name': 'Wilson',
            'aaaaaaaaa': '1990-02-23'
        }, {
            'Emp. Number': 00006,
            'First Name': 'John',
            'Last Name': 'Doe',
            'aaaaaaaaa': '1990-02-12'
        }, {
            'Emp. Number': 00007,
            'First Name': 'Bill',
            'Last Name': 'Watson',
            'aaaaaaaaa': '1800-01-03'
        }, {
            'Emp. Number': 00008,
            'First Name': 'Walter',
            'Last Name': 'Wright',
            'aaaaaaaaa': '26'
        }, {
            'Emp. Number': 00003,
            'First Name': 'Ted',
            'Last Name': 'Johnson',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00004,
            'First Name': 'Betty',
            'Last Name': 'Smith',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00005,
            'First Name': 'Susan',
            'Last Name': 'Wilson',
            'aaaaaaaaa': '1990-02-23'
        }, {
            'Emp. Number': 00006,
            'First Name': 'John',
            'Last Name': 'Doe',
            'aaaaaaaaa': '1990-02-12'
        }, {
            'Emp. Number': 00007,
            'First Name': 'Bill',
            'Last Name': 'Watson',
            'aaaaaaaaa': '1800-01-03'
        }, {
            'Emp. Number': 00008,
            'First Name': 'Walter',
            'Last Name': 'Wright',
            'aaaaaaaaa': '26'
        }]
    });
    </script>
    <script>
    //example 1 
    $('#example-wB').columns({
        data: [{
            'Emp. Number': 00001,
            'First Name': 'John',
            'Last Name': 'Smith',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00002,
            'First Name': 'Jane',
            'Last Name': 'Doe',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00003,
            'First Name': 'Ted',
            'Last Name': 'Johnson',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00004,
            'First Name': 'Betty',
            'Last Name': 'Smith',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00005,
            'First Name': 'Susan',
            'Last Name': 'Wilson',
            'aaaaaaaaa': '1990-02-23'
        }, {
            'Emp. Number': 00006,
            'First Name': 'John',
            'Last Name': 'Doe',
            'aaaaaaaaa': '1990-02-12'
        }, {
            'Emp. Number': 00007,
            'First Name': 'Bill',
            'Last Name': 'Watson',
            'aaaaaaaaa': '1800-01-03'
        }, {
            'Emp. Number': 00008,
            'First Name': 'Walter',
            'Last Name': 'Wright',
            'aaaaaaaaa': '26'
        }, {
            'Emp. Number': 00003,
            'First Name': 'Ted',
            'Last Name': 'Johnson',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00004,
            'First Name': 'Betty',
            'Last Name': 'Smith',
            'aaaaaaaaa': '24'
        }, {
            'Emp. Number': 00005,
            'First Name': 'Susan',
            'Last Name': 'Wilson',
            'aaaaaaaaa': '1990-02-23'
        }, {
            'Emp. Number': 00006,
            'First Name': 'John',
            'Last Name': 'Doe',
            'aaaaaaaaa': '1990-02-12'
        }, {
            'Emp. Number': 00007,
            'First Name': 'Bill',
            'Last Name': 'Watson',
            'aaaaaaaaa': '1800-01-03'
        }, {
            'Emp. Number': 00008,
            'First Name': 'Walter',
            'Last Name': 'Wright',
            'aaaaaaaaa': '26'
        }]
    });
    </script>
</body>

</html>
