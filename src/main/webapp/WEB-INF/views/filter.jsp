
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String pathF = request.getContextPath();
	String filterPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathF + "/";
%>
<html lang="zh-CN">
<head>
<%--  <link rel="stylesheet" href="<%=filterPath%>/css/filter.css"> --%>
</head>
<body>
	<!-- 第一行 -->
	<div class="profiling_header">
		<div id="appkey">
		<div class="table_caption fl">
			<div class="fl cp title_caption_table" id="table_caption_title">
				<div class="fl table_title" rel="${sessionScope.appKey}"
					id="get_appKey">${sessionScope.appInfo }</div>
			</div>
			<!-- 选择平台 -->
			<c:if
				test="${not empty sessionScope.appPlatformList && empty sessionScope.platFormCheck }">
				<div class="table_icon fl" id="table_iconX">
					<c:forEach items="${sessionScope.appPlatformList}" var="apf">
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
			<c:if test="${not empty sessionScope.platFormCheck }">
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
		<!-- 右侧按钮 -->
		<!-- <div class="btn-group fr">
                    <button type="button" class="btn btn-default btn_name dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        筛选 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu btn_right_menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </div> -->
		<!-- 右侧按钮 -->
		</div>
		<div class="btn-group fr">
			<button type="button"
				class="btn btn-default btn_time btn_group_id searchDate"
				id="searchDate">2017-7-10～2017-8-20</button>
			<button type="button"
				class="btn btn-default btn_time1 btn_group_id dropdown-toggle searchDate"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span class="caret"></span> <span class="sr-only">Toggle
					Dropdown</span>
			</button>
		</div>
		<div class="btn_group_time" id="btn_group_time_id"
			style="width: 392px; height: 102px">
			<!-- <div class="" id="btn_group_time_id"> -->
			<div class="dropdown-menu-data-top">
				<a id="today">今日</a>| <a id="yesterday">昨日</a>| <a id="week">近7天</a>|
				<a id="month">近30日</a>|
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
                            </select>| -->
				<a id="year">近一年</a>
			</div>
			<div class="dropdown-menu-data-middle">
				自 <input id="startDate" type="text" class="dropdown_time"
					onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}',onpicked:function() {javascript:show();}})" />
				到 <input id="endDate" class="dropdown_time" type="text"
					onclick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-%d',onpicked:function() {javascript:show();}})"
					onblur="show()" />
			</div>

			<div class="dropdown-menu-data-bottom" id="dropdown-menu-data-bottom">
				<button type="button" class="btnOff fr" id="timeButton-cancel">取消</button>
				<button type="button" class="btnSuccess fr" id="tipData">确定</button>
			</div>
		</div>

	</div>
	<script src="<%=filterPath%>/js/getAppkey.js"></script>
	<!-- jQuery -->
	<script src="<%=filterPath%>/js/jQuery 1.9.1.js"></script>
	<script type="text/javascript" src="<%=filterPath%>/js/filter.js"></script>
</body>
</html>