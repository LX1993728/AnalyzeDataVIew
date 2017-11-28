var platForm;
// 获取首页appKey
var appInforAppKey = $("#get_appKey").attr("rel");
//获取项目名
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
// 获取当前日期
var myDate = new Date();
var nowY = myDate.getFullYear();
var nowM = myDate.getMonth() + 1;
var nowD = myDate.getDate();
// 今天调用值
var today = nowY + "-" + (nowM < 10 ? "0" + nowM : nowM) + "-"
		+ (nowD < 10 ? "0" + nowD : nowD);
// 进入时终止日期调用值
var endDate = nowY + "-" + (nowM < 10 ? "0" + nowM : nowM) + "-"
		+ (nowD < 10 ? "0" + nowD : nowD);
// 获取几天前方法 获取多少天前请直接将天数传入
function loadDate(day) {
	var nowDate = new Date(myDate - 1000 * 60 * 60 * 24 * day);// 最后一个数字30可改，30天的意思
	var lw = nowDate;
	var lastY = lw.getFullYear();
	var lastM = lw.getMonth() + 1;
	var lastD = lw.getDate();
	var returnDate = lastY + "-" + (lastM < 10 ? "0" + lastM : lastM) + "-"
			+ (lastD < 10 ? "0" + lastD : lastD);// 三十天之前日期
	return returnDate;
}
var startDate = loadDate(30);

$(".searchDate").click(function() {
	$("#btn_group_time_id").removeClass("hidden")

});
$("#timeButton-cancel").click(function() {
	$("#btn_group_time_id").addClass("hidden")
});
$("#tipData").click(function() {
	startDate = $("#startDate").val();
	endDate = $("#endDate").val();
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadEventCharts();
});
$("#today").click(function() {
	startDate = today;
	endDate = today;
	date = today;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadEventCharts();
});
$("#yesterday").click(function() {
	startDate = loadDate(1);
	endDate = startDate;
	date = startDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadEventCharts();
});
$("#week").click(function() {
	startDate = loadDate(7);
	endDate = today;
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadEventCharts();
});
$("#month").click(function() {
	startDate = loadDate(30);
	endDate = today;
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadEventCharts();
});
$("#year").click(function() {
	startDate = loadDate(365);
	endDate = today;
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadEventCharts();
});
// 时间控件日期编写值
var date;

var eventCharts = document.getElementById('eventCharts');
var eventDeatilCharts = document.getElementById('eventDetailCharts');
$(function() {
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#eventClicks").click();
});

var platForm;
// 获取首页appKey
var appInforAppKey = $("#get_appKey").attr("rel");
function getPlatForm() {
	platForm = "";
	$("#app-form-group").addClass("hidden")
	var appInput = $("#app-form-group input");
	for (var i = 0; i < appInput.length; i++) {
		if (appInput[i].checked && appInput[i].value != null) {
			platForm = appInput[i].value + "+" + platForm;
		}
	}
	;
	loadEvent();
};
function loadEvent() {
	$.ajax({
		type : "POST",
		async : true,
		url : path + projectName + "/rest/event/analysis",
		scriptCharset : 'utf-8',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
		},
		success : function(datas) {
			if (datas != null) {
				location.reload();
			}
		},
		error : function(datas) {
			alert(datas);
		}
	});
}
var eventSortId;
var myEventChart = document.getElementById('eventCharts');
function loadEventCharts() {
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/event/eventClickCharts",
		dataType : "json", // 返回数据形式为json
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
			"sortId" : eventSortId,
		},
		success : function(result) {
			if (result.res == undefined) {
				$("#eventChart").html("");
				loadChartEventData(result);
			} else {
				$("#eventChart").html(result.res);
			}
		}
	});
}
$("#eventClicks").click(function() {
	eventSortId = "eventClicks";
	loadEventCharts();
});
$("#eventUser").click(function() {
	eventSortId = "eventUser";
	loadEventCharts();
});
function loadChartEventData(result) {
	echarts.dispose(eventCharts);
	echarts.dispose(eventDeatilCharts);
	var eventData = echarts.init(eventCharts);
	var enentDeatilData = echarts.init(eventDeatilCharts);
	var eventDataOption = {
		color : [ '#5EE3A4', '#5555FF' ],
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		grid : {
			left : '0%',
			right : '6.5%',
			bottom : '3%',
			containLabel : true,
			y : 35
		},
		xAxis : [ {
			type : 'category',
			data : result.xAxis,
			axisTick : {
				alignWithLabel : true
			},
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa',
				}
			}
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa',
				}
			}
		} ],
		series : [ {
			name : result.trigger,
			type : 'bar',
			barWidth : '15%',
			data : result.seriesData
		}, {
			name : result.reach,
			type : 'bar',
			barWidth : '15%',
			data : result.reachData
		} ]
	};
	enentDeatilData.setOption(eventDataOption);
	var detailOption = {
		grid : {
			left : '0%',
			right : '4%',
			bottom : '0%',
			containLabel : true,
			y : 50
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c}"
		},
		color : [ '#599296', '#C2CDD3', '#D48265', '#749F83', '#91C7AE',
				'#F49631', '#FCAD9D', '#DD4040',
				'#6DBCBC',  '#ADADAD' ],
		series : [ {
			name : '触发',
			type : 'funnel',
			width : '70%',
			height : '65%',
			left : '20%',
			top : '6.5%',
			label : {
				normal : {
					position : 'left',
					formatter : '{b}'
				},
				emphasis : {
					position : 'inside',
					formatter : '{b}: {c}'
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			itemStyle : {
				normal : {
					opacity : 0.7
				}
			},
			data : result.seriesDataList
		}, {
			name : '完成',
			type : 'funnel',
			width : '70%',
			height : '65%',
			left : '20%',
			top : '6.5%',
			maxSize : '80%',
			label : {
				normal : {
					position : 'inside',
					formatter : '{c}',
					textStyle : {
						color : '#fff'
					}
				},
				emphasis : {
					position : 'inside',
					formatter : '{b}: {c}'
				}
			},
			itemStyle : {
				normal : {
					opacity : 0.5,
					borderColor : '#fff',
					borderWidth : 2
				}
			},
			data : result.reachDataList
		} ]
	};
	eventData.setOption(detailOption);
}