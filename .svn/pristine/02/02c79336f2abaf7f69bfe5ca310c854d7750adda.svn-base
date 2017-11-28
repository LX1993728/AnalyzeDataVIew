// 时间控件日期编写值
var date;
// 点击时间ID
var eventId;
var platForm;
// 获取首页appKey
var appInforAppKey = $("#get_appKey").attr("rel");
// 获取项目名
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
// 进入时终止日期调用值
var endDate = nowY + "-" + (nowM < 10 ? "0" + nowM : nowM) + "-"
		+ (nowD < 10 ? "0" + nowD : nowD);
// 获取几天前方法 获取多少天前请直接将天数传入
var today=endDate;
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

//时间帅选
$("#tipData").click(function() {
	startDate = $("#startDate").val();
	endDate = $("#endDate").val();
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#' + eventId).click();
	loadDataPro();
});
$("#today").click(function() {
	startDate = today;
	endDate = today;
	date = today;
	loadDataPro();
	initTable();
	$("#usert").bootstrapTable('refresh');
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#' + eventId).click();
});
$("#yesterday").click(function() {
	startDate = loadDate(1);
	endDate = startDate;
	date = startDate;
	initTable();
	$("#usert").bootstrapTable('refresh');
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#' + eventId).click();
	loadDataPro();
});
$("#week").click(function() {
	startDate = loadDate(7);
	endDate = today;
	initTable();
	$("#usert").bootstrapTable('refresh');
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#' + eventId).click();
	loadDataPro();
});
$("#month").click(function() {
	startDate = loadDate(30);
	endDate = today;
	initTable();
	$("#usert").bootstrapTable('refresh');
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#' + eventId).click();
	loadDataPro();
});
$("#year").click(function() {
	startDate = loadDate(365);
	endDate = today;
	initTable();
	$("#usert").bootstrapTable('refresh');
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#' + eventId).click();
	loadDataPro();
});


$(function() {
	date = startDate + "~" + endDate;
	loadDataPro();
	$("#newUser").click();
	$("#nUser").click();
	$("#searchDate").html(date);
});

function loadDataPro(){
		//趋势分析 新增用户
		$("#nUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/newUser",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		});
		
		//趋势分析 活跃用户
		$("#aUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/activeUser",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		});
		/*$("#rUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/retentionUser",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		});
		
		//
		$("#lUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/lostUser",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		});
		
		$("#bUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/backUser",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		});*/
		
		//趋势分析 启动次数
		$("#startPro").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/start",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		});
		
		// 趋势分析 累计用户
		$("#sumUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/totalUser",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		
		});
		
		//趋势分析平均使用时长
		$("#avgTime").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/avgUseTime",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadData(result);
				}
			});
		
		});
		
		
		//时段分析 新增用户
		$("#newUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/newUserTime",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
//					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadTime(result);
				}
			});
		});
		//时段分析 活跃用户
		$("#actUser").click(function() {
			eventId = $(this).attr("id");
			$.ajax({
				type : "GET",
				async : true, // 同步执行
				url : path + projectName + "/rest/profile/actUserTime",
				dataType : "json",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
//					"startDate" : startDate,
					"endDate" : endDate,
				},
				success : function(result) {
					loadTime(result);
				}
			});
		});
	}
//趋势分析Echart
function loadData(result) {
	var nuCharts = echarts.init(document.getElementById('profile'));
	var optionNu = {
		tooltip : {
			trigger : 'axis'
		},
		grid : {
			left : '0%',
			right : '4%',
			bottom : '3%',
			containLabel : true,
			y : 20,
			x : 0,
			y2 : 5,
			x2 : 5
		},
		color : [ '#5EE3A4' ],
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : result.xAxis,
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa',
				}
			}
		}, ],
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
			name : result.legend,
			type : 'line',
			smooth : true,
			data : result.seriesData,
		} ]
	};
	nuCharts.setOption(optionNu);
}

//时段分析Echart

function loadTime(result) {
	var nuCharts = echarts.init(document.getElementById('profileTime'));
	var optionNu = {
		tooltip : {
			trigger : 'axis'
		},
		grid : {
			left : '0%',
			right : '4%',
			bottom : '3%',
			containLabel : true,
			y : 20,
			x : 0,
			y2 : 5,
			x2 : 5
		},
		color : [ '#5EE3A4', '#FF0000' ],
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : result.xAxis,
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa',
				}
			}
		}, ],
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
			name : result.legend[0],
			type : 'line',
			color : [ '#5EE3A4' ],
			smooth : true,
			data : result.seriesData,
		}, {
			name : result.legend[1],
			type : 'line',
			color : [ '#e5cfd0' ],
			smooth : true,
			data : result.seriesDataYes,
		} ]
	};
	nuCharts.setOption(optionNu);
}

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

	loadDataPro();

	$.ajax({
		type : "POST",
		async : true, // 同步执行
		url : path + projectName + "/rest/profile/dataprofiling",
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

};

