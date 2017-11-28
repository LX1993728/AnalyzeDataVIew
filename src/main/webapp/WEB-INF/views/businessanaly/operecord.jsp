<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <link rel="stylesheet" href="<%=path%>/bootstrap/css/bootstrap.min.css">
    <!-- base style -->
    <link rel="stylesheet" href="<%=path%>/css/base.css">
    <link rel="stylesheet" href="<%=path%>/css/theme.css">
    <link rel="stylesheet" href="<%=path%>/css/index.css">
    <link rel="stylesheet" href="<%=path%>/css/Users.css">
    <link rel="stylesheet" href="<%=path%>/css/indexFunction.css">
    <!-- 日期控件 -->
    <!-- <link rel="stylesheet" href="<%=path%>/dataTime/css/daterangepicker-bs3.css"> -->
    <!-- 分页排序 -->
    <link rel="stylesheet" href="<%=path%>/css/classic.css">
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
                <img src="<%=path%>/imgs/logo.png" alt="">
                <img src="<%=path%>/imgs/logo-title.png" alt="">
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
                    <a href="<%=path%>/rest/user/logout">${username}<i class="fr"></i> </a>
                </div>
                <span class="toptitle-fr-line2 fr"></span>
            </div>
        </div>
        <!-- main主体 -->
        <div class="main">
            <div class="menu fl">
                <ul class="parentWrap">
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=path%>/imgs/little-icon/Survey_hover.png" alt=""></s>总体概况<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=path%>/rest/genneralSummary/indexView">应用概况</a></li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=path%>/imgs/little-icon/User.png" alt=""></s>用户与使用<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=path%>/rest/UserAndUse/NewAndStart">新增和启动</a></li>
                            <li><a href="<%=path%>/rest/UserAndUse/activeAnalysis">活跃分析</a></li>
                            <li><a href="<%=path%>/rest/UserAndUse/timeAnalysis">时段分析</a></li>
                            <li><a href="<%=path%>/rest/UserAndUse/areaDis">地区分析</a></li>
                            <li><a href="<%=path%>/rest/versionDistribution/versionView">版本分析</a></li>
                            <li><a href="<%=path%>/rest/UserAndUse/equipmentModl">设备机型</a></li>
                            <li><a href="<%=path%>/rest/networkAndOper/networkAndOperView">运营商与网络</a></li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=path%>/imgs/little-icon/ParticipateIn.png" alt=""></s>参与与留存<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=basePath%>rest/retention/retentionView" >用户留存</a></li>
                            <li><a href="<%=basePath%>rest/backLost/startDayView" >流失用户</a></li>
                            <li><a href="<%=basePath%>rest/returnVisit/returnVisitView" >用户回访</a></li>
                            <li><a href="<%=basePath%>rest/startDay/startDayView" >日启动次数</a></li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=path%>/imgs/little-icon/Custom.png" alt=""></s>事件分析<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=path%>/rest/event/eventView">模块分析</a>
                            <li><a href="<%=path%>/rest//EventAnalysis/ExceptionAnalysis">异常分析</a></li>
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=path%>/imgs/little-icon/Channel.png" alt=""></s>预警分析<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="<%=basePath%>rest/earlyWarnning/earlyWarnningView">预警通知</a></li>
                            <!-- <li><a href="#">趋势汇总</a></li> -->
                        </ul>
                    </li>
                    <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=path%>/imgs/little-icon/AnalysisTools.png" alt=""></s>业务分析<i class="fr"></i></span>
                        <ul class="friends" style="display: block;">
                            <li><a href="<%=path%>/rest/businessAnaly/operecord"  class="friends-color">操作记录</a></li>
                            <li><a href="<%=path%>/rest/businessAnaly/exceprecord">异常记录</a></li>
                            <!-- <li><a href="#">交互体验统计</a></li> -->
                        </ul>
                    </li>
                    <%-- <li>
                        <span class="groupTitle"><s class="idx"><img src="<%=path%>/imgs/little-icon/SetUp.png" alt=""></s>系统管理<i class="fr"></i></span>
                        <ul class="friends">
                            <li><a href="#">用户管理</a></li>
                            <li><a href="#">角色管理</a></li>
                            <li><a href="#">权限管理</a></li>
                            <li><a href="#">菜单管理</a></li>
                        </ul>
                    </li> --%>
                </ul>
            </div>
            <div class="content fr">
                <!-- 日期控件 -->
                <div class="users-dataTime">
                    <!-- Split button -->
                    <div class="btn-group">
                        <button type="button" class="btn-timeData fl btnShow" id="timeShow"></button>
                        <button type="button" class="dropdown-timeData fl btnShow"></button>
                        <div class="dropdown-menu-data fl">
                            <div class="dropdown-menu-data-top">
                                <a href='javascript:void(0)' onclick='getEchartModelData(this)' value="0">今日</a>| <a href="#"
                                    onclick='getEchartModelData(this)' value="1">昨日</a>| <a href="#" onclick='getEchartModelData(this)' value="7">近7天</a>| <a
                                    href='#' onclick='getEchartModelData(this)' value="30">近30日</a>| 
                                    <!-- <select name="" id="">
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
                                    </select>|  -->
                                <a href="#" onclick='getEchartModelData(this)' value="365">近一年</a>
                            </div>
                            <div class="dropdown-menu-data-middle">
                                        自定&nbsp <input type="text" id="startTime" readonly class="Wdate"
                                            onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endTime\')}',dateFmt:'yyyy-MM-dd'})" /> &nbsp到&nbsp <input type="text" id="endTime"
                                            readonly class="Wdate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startTime\')}',dateFmt:'yyyy-MM-dd'})" />
                            </div>
                            <div class="dropdown-menu-data-bottom">
                                <button type="button" class="btnOff fr">取消</button>
                                <button type="button" class="btnSuccess fr" onclick='getEchartModelDataByCustom()'>确定</button>
                            </div>
                        </div>
                    </div>
					设备标识：<input type="text" style="width: 214px;height: 36px;border-radius: 8px;" id="deviceId" onkeyup="getOperatorRecordDetail()"/>
                    <div class="btn-filter fr" onclick='getAllVersion()'>筛选</div>   
                </div>
                                                <!-- 提示 -->
                <div id="version-promptP"
                    <c:if test="${versions==null}">
                <c:out value="style=display:none;" />
                </c:if>>
                    <div class="triangle fr"></div>
                    <div class="version-prompt">
                        <span>版本:</span>
                        <ul id="selectVersion">
                            <c:forEach items="${versions }" var="version">
                                <li class='select-version'>${version}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <!-- 版本选择 -->
                <div class="panel panel-default" id="version-filterP" style="display: none;">
                    <div class="version-filter">
                        <div class="version-number">
                            <div class="version-number-search fl">
                                <div class="btn-group-index fr" role="group">
                                   <!--  <span style="font-size: 14px; line-height: 28px;">版本</span> <input
                                        type="text" class="abnormal-eve">
                                    <div class="glyphicon glyphicon-search gly-search"></div> -->
                                </div>
                            </div>
                            <div class="version-number-checked fr">
                                <s class="version-number-checked-t fl">全选</s> <s
                                    class="version-number-checked-f fr">取消选择</s>
                            </div>
                            <div class="numberLine"></div>
                            <div class="version-number-select">
                                <ul id="allAppVersion">
                                </ul>
                                <!-- <span class="fr" style="cursor: pointer;">更多>></span> -->
                            </div>
                        </div>
                        <div class="version-number-btn fr">
                            <div class="buttonBlue fl" id="buttonBlue-confirm">确定</div>
                            <div class="buttonBlue fr" id="buttonBlue-cancel">取消</div>
                        </div>
                    </div>
                </div>
                <!-- 第二排 -->
                <div class="panel panel-default">
                    <div class="panel-heading no-collapse gk-title">操作记录</div>
                        <table id="example-Czjl" class="table-font table table-striped">
                        </table>
<!--                     <div id="example-Czjl">
                    </div> -->
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
    <script src="<%=path%>/js/jquery-1.12.2.min.js"></script>
    <!-- bootstrap -->
    <script src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/index.js"></script>
    <!-- 日期控件 -->
    <script src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <script src="<%=path%>/js/head.js"></script>
    <!-- 排序 -->
    <script src="<%=path%>/js/jquery.columns-1.0.min.js"></script>
    <script src="<%=path%>/js/bootstrap-table.js"></script>
    <script src="<%=path%>/js/bootstrap-table-zh-CN.min.js"></script>
    <script src="<%=path%>/js/operecord.js"></script>
    <script type="text/javascript">
    // $(".groupTitle").eq(5).next("ul").css("display", "block");
    </script>
</body>

</html>
