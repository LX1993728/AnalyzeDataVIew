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
<link rel="stylesheet" href="<%=basePath%>/css/index.css">
<title>移动行为分析-数据统计</title>
</head>

<body>
    <!-- 头部 -->
    <%@ include file="top.jsp"%>
    <div class="index_main">
        <%-- <%@ include file="left_menu.jsp" %> --%>
        <jsp:include page="left_menu.jsp">
	        <jsp:param name="menu" value="100"/>
	    </jsp:include>
        
        <!-- 内容 -->
        <div class="index_content">
            <!-- 第一行 -->
            <div class="index_content_top">
                <div class="index_content_top_left fl">
                    <div class="table_caption">
                        <div class="fl cp title_caption_table" id="table_caption_title">
                            <div class="fl table_title" rel="${sessionScope.appKey}" id="get_appKey">${sessionScope.appInfo }</div>
                        </div>
                        <!-- 选择平台 -->
                        <c:if test="${not empty appPlatformList && empty platFormCheck }">
	                        <div class="table_icon fl" id="table_iconX">
	                        	<c:forEach items="${appPlatformList}" var="apf" >
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
	                        	<c:forEach items="${ sessionScope.platFormCheck}" var="apf" >
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
									<li class="list-group-item group-item1 appKey" rel="${appInfo.appKey}">
									<!-- onclick='getAppPlatform(this)' -->
									<a href='javascript:void(0)' onClick="getAppKey(this)" value="${appInfo.appKey}">${appInfo.appName}</a>
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
							<button class="btn_confirm fl" id="pla_Form_bt">确定</button>
							<button class="btn_cancel fr">取消</button>
						</div>
					</div>
					
					<div class="right_data_title1 table_title_bottom fl">应用概况</div>
					<span class="fl runNum_index_title">覆盖移动终端</span>
					<div class="runNum_index">
        				<ul class="runNum" id="test"></ul>
    				</div>
    				<div class="runNum_up_test">
    					<div class="runNum_up fl">
					        <span class="runNum_upText">${generalize.sevenActive }</span>
					        <c:choose>
					      	  <c:when test="${generalize.sevenActiveFloat < 0}">
					      	  	<span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
					      	  </c:when>
					          <c:otherwise>
					          	 <span class="glyphicon glyphicon-arrow-up channelBg_up"></span>
					          </c:otherwise>
					        </c:choose>
					        <span class="runNum_upPercent">${generalize.sevenActiveFloat }%</span>
					        <p  class="runNum_upName">近七日活跃设备</p>
					    </div>
					    <div class="runNum_up fl">
					        <span class="runNum_upText">${generalize.thirtyActive }</span>
					        <c:choose>
					      	  <c:when test="${generalize.thirtyActiveFloat < 0}">
					      	  	<span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
					      	  </c:when>
					          <c:otherwise>
					          	 <span class="glyphicon glyphicon-arrow-up channelBg_up"></span>
					          </c:otherwise>
					        </c:choose>
					        <span class="runNum_upPercent">${generalize.thirtyActiveFloat }%</span>
					        <p  class="runNum_upName">近30日活跃设备</p>
					    </div>
					    <div class="runNum_up fl">
					        <span class="runNum_upText">00:04:04</span>
					        <span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
					        <span class="runNum_upPercent">-1.94%</span>
					        <p  class="runNum_upName">单设备日均使用时长</p>
					    </div>
    				</div>
<!-- 					<div class="right_data_title table_title_bottom">留存概况</div> -->
					<%-- <table class="table table_index">
						<tbody>
							<tr class="table_index_luncun">
								<td>日期</td>
								<td>用户数</td>
								<td>+1月</td>
								<td>+2月</td>
								<td>+3月</td>
							</tr>
							<c:if test="${empty retentionMonthList}">
								<tr>
									<td colspan="5">暂时没有任何数据</td>
								</tr>
							</c:if>
							<c:if test="${not empty retentionMonthList}">
								<c:forEach items="${retentionMonthList}" var="monthUser">
									<tr>
										<td>${monthUser.date}</td>
										<td>${monthUser.monthActiveUser}</td>
										<td class="bg_green1">${monthUser.oneMonth}%</td>
										<td class="bg_green2">${monthUser.twoMonth}%</td>
										<td class="bg_green3">${monthUser.threeMonth}%</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table> --%>
				</div>
				<div class="index_content_top_right fr">
					<div class="right_data_title fl">用户构成</div>
					<span class="glyphicon glyphicon-question-sign Question_markSign fr"></span>
					<div class="QuestionPopup">
						<div class="QuestionPopup_title">数据指标</div>
						<div class="QuestionPopup_content">
							<span class="QuestionPopup_content_name">新增设备：</span>
							<span>昨日两议案，重复安装的应用不会昨日两议案，重复安装的应用不会昨日两议案，重复安装的应用不会。</span>
						</div>
					</div>
					<div id="shuju" class="user_distribution">数据展现</div>					
<!-- 					<div class="right_data_title">用户数据</div> -->
<!-- 					<div id="sj" class="user_distribution">数据展现</div> -->
				</div>
			</div>
			<!-- 第二行 -->
			<div class="index_content_center">
				<div class="index_content_top_left fl">
					<div class="right_data_title" id="new_users">
						<span class="cp">新增用户</span> 
						<span class="right_data_title_glay cp" id="hy">活跃用户</span>
					</div>
					<!-- echarts的头部  -->
					<div class="">
						<div class="channel_analysis_title">
		                	<span class="channel_analysis_titleColor">昨日</span>
		                	<span class="channel_analysis_titleColor1">${generalize.yesterdayNewSum }</span>
		                	<!-- <span class="glyphicon glyphicon-arrow-down channelBg_up1"></span> -->
		                	<span class="channel_analysis_titleColor">昨日此时</span>
		                	<span class="channel_analysis_titleColor1">${generalize.yesterdayMomentNewSum }</span>
		                	<span class="channel_analysis_titleColor">今日</span>
		                	<span class="channel_analysis_titleColor1">${generalize.todayNewSum }</span>
		                	<c:choose>
					      	  <c:when test="${generalize.yesterdayNewSum  > generalize.todayNewSum}">
					      	  	<span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
					      	  </c:when>
					          <c:otherwise>
					          	 <span class="glyphicon glyphicon-arrow-up channelBg_up"></span>
					          </c:otherwise>
					        </c:choose>
		                </div>
		                <div class="channel_analysis_title hide">
		                	<span class="channel_analysis_titleColor">昨日</span>
		                	<span id="activeYesterday" class="channel_analysis_titleColor1">${generalize.yesterdayActiveSum }</span>
		                	<span class="channel_analysis_titleColor">昨日此时</span>
		                	<span id="activeYesterdayMoment" class="channel_analysis_titleColor1">${generalize.yesterdayMomentActiveSum}</span>
		                	<span class="channel_analysis_titleColor">今日</span>
		                	<span id="activeToday" class="channel_analysis_titleColor1">${generalize.todayActiveSum}</span>
		                	<c:choose>
					      	  <c:when test="${generalize.yesterdayActiveSum  > generalize.todayActiveSum}">
					      	  	<span class="glyphicon glyphicon-arrow-down channelBg_up"></span>
					      	  </c:when>
					          <c:otherwise>
					          	 <span class="glyphicon glyphicon-arrow-up channelBg_up"></span>
					          </c:otherwise>
					        </c:choose>
		                </div>
					</div>
					<div id="content_fade">
						<div id="nu" class="newadd_content newadd_content1"></div>
						<div id="au" class="newadd_content newadd_content1 hide"></div>
					</div>
				</div>
				<div class="index_content_top_right fr">
					<div class="right_data_title">用户分布</div>
					<div id="map" class="user_distribution"></div>
				</div>
			</div>
			<!-- 第三行 -->
			<div class="index_content_top">
				<div class="index_content_top_left fl">
					<div class="right_data_title">用户留存</div>
					<table class="table table_index tableIndex">
						<tbody>
							<tr class="table_index_luncun">
								<td>日期</td>
								<td>用户数</td>
								<td>+1月</td>
								<td>+2月</td>
								<td>+3月</td>
							</tr>
							<c:if test="${empty retentionMonthList}">
								<tr>
									<td colspan="5">暂时没有任何数据</td>
								</tr>
							</c:if>
							<c:if test="${not empty retentionMonthList}">
								<c:forEach items="${retentionMonthList}" var="monthUser">
									<tr>
										<td>${monthUser.date}</td>
										<td>${monthUser.monthActiveUser}</td>
										<td class="bg_green1">${monthUser.oneMonth}%</td>
										<td class="bg_green2">${monthUser.twoMonth}%</td>
										<td class="bg_green3">${monthUser.threeMonth}%</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
<!-- 					<div id="lc" class="newadd_content"></div> -->
				</div>
				<div class="index_content_top_right fr">
					<div class="right_data_title">TOP模块</div>
					<div id="top" class="user_distribution"></div>
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
	<!-- echarts -->
	<script src="<%=basePath%>/js/echarts.js"></script>
	<script src="<%=basePath%>/js/china.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/echarts.min.js"></script>

	<script>
		/* function getAppKey(a) {
			$
					.ajax({
						type : "POST",
						async : true, // 同步执行
						url : "/rest/datas/index",
						scriptCharset : 'utf-8',
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						data : {
							"appKey" : $(a).attr("value"),
							"appName" : $(a).text(),
						},
						success : function(datas) {
							if (datas != null) {
								location.reload();
							}
						}
					});
		} */
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
	<script type="text/javascript">
    (function($) {
        /*jQuery对象添加  runNum  方法*/
        $.fn.extend({
            /*
             *  滚动数字
             *  @ val 值，    params 参数对象
             *  params{addMin(随机最小值),addMax(随机最大值),interval(动画间隔),speed(动画滚动速度),width(列宽),height(行高)}
             */
            runNum: function(val, params) {
                /*初始化动画参数*/
                var valString = val || '70225800'
                var par = params || {};
                var runNumJson = {
                    el: $(this),
                    value: valString,
                    valueStr: valString.toString(10),
                    width: par.width || 52,
                    height: par.height || 60,
                    addMin: par.addMin || 20,
                    addMax: par.addMax || 100,
                    interval: par.interval || 3000,
                    speed: par.speed || 1000,
                    
                    length: valString.toString(10).length
                };
                $._runNum._list(runNumJson.el, runNumJson);
                $._runNum._interval(runNumJson.el.children("li"), runNumJson);
            }
        });
        /*jQuery对象添加  _runNum  属性*/
        $._runNum = {
            /*初始化数字列表*/
            _list: function(el, json) {
                var str = '';
                for (var i = 0; i < json.length; i++) {
                    var w = json.width * i;
                    var t = json.height * parseInt(json.valueStr[i]);
                    var h = json.height * 10;
                    str += '<li style="width:' + json.width + 'px;left:' + w + 'px;top: ' + -t + 'px;height:' + h + 'px;">';
                    for (var j = 0; j < 10; j++) {
                    	str += '<div style="height:' + json.height + 'px;line-height:' + json.height + 'px;">' + j ;
                        if(i!=json.length){
	                    	if((i%3)!=0 || i==(json.length-1)){
	                       		str += '</div>' ;
	                        }else{
	                        	str += ',</div>' ;
	                        }
                        }else{
                        	str += '</div>' ;
                        }
                    }
                    str += '</li>';
                }
                el.html(str);
            },
            /*生成随即数*/
            _random: function(json) {
                var Range = json.addMax - json.addMin;
                var Rand = Math.random();
                var num = json.addMin + Math.round(Rand * Range);
                return num;
            },
            /*执行动画效果*/
            _animate: function(el, value, json) {
                for (var x = 0; x < json.length; x++) {
                    var topPx = value[x] * json.height;
                    el.eq(x).animate({ top: -topPx + 'px' }, json.speed);
                }
            },
            /*定期刷新动画列表*/
            _interval: function(el, json) {
                var val = json.value;
                setInterval(function() {
                    val += $._runNum._random(json);
                    $._runNum._animate(el, val.toString(10), json);
                }, json.interval);
            }
        }
    })(jQuery);
    </script>
    <script type="text/javascript">
    	$("#test").runNum(8188972);
    	$('#example').popover(options)
    </script>
    
	<script src="<%=basePath%>/js/getAppkey.js"></script>
</body>
</html>