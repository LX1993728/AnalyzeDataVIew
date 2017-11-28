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
	loadRetained();
});
$("#today").click(function() {
	startDate = today;
	endDate = today;
	loadRetained();
});
$("#yesterday").click(function() {
	startDate = loadDate(1);
	endDate = startDate;
	loadRetained();
});
$("#week").click(function() {
	startDate = loadDate(7);
	endDate = today;
	loadRetained();
});
$("#month").click(function() {
	startDate = loadDate(30);
	endDate = today;
	loadRetained();
});
$("#year").click(function() {
	startDate = loadDate(365);
	endDate = today;
	loadRetained();
});
// 时间控件日期编写值
var date;
$(function() {
	$("#searchDate").html(date);
	if ($("#retainedFlag").val() == 'newUserClick') {
		$("#retained_new_users").removeClass("right_data_title_glay");
		$("#retained_active_users").addClass("right_data_title_glay");
	} else if ($("#retainedFlag").val() == 'activeUserClick') {
		$("#retained_active_users").removeClass("right_data_title_glay");
		$("#retained_new_users").addClass("right_data_title_glay");
	}
});

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
	loadRetained();
};

function loadRetained() {

	$.ajax({
		type : "POST",
		dataType : "JSON",
		async : true,
		url : path + projectName + "/rest/retained/profile",
		scriptCharset : 'utf-8',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
		},
		success : function(datas) {
			$("#btn_group_time_id").hide();
			if (datas != null) {
				common(datas);
			}
		},
		error : function(datas) {
			alert(datas);
		}
	});
}
function common(datas) {
	$("#t thead").html("")
	$("#t tbody").html("")
	$("#startTime").val(datas.startDate)
	$("#endTime").val(datas.endDate)
	$("#retainedFlag").val(datas.eventFlag)
	$("#searchDate").html($("#startTime").val() + "~" + $("#endTime").val());
	if (datas.flag == "0" || datas.flag == "1") {
		var html = "<tr class='table_index_luncun'><td>日期</td><td>用户数</td>"
				+ "<td>+1日</td>" + "<td>+2日</td>" + "<td>+3日</td>"
				+ "<td>+4日</td>" + "<td>+5日</td>" + "<td>+6日</td>"
				+ "<td>+7日</td>" + "<td>+14日</td>" + "<td>+30日</td>" + "</tr>"
		$("#mark").append(html)
	}
	if (datas.flag == "2" || datas.flag == "3") {
		var html = "<tr class='table_index_luncun'><td>日期</td><td>用户数</td>"
				+ "<td>+1周</td>" + "<td>+2周</td>" + "<td>+3周</td>"
				+ "<td>+4周</td>" + "<td>+5周</td>" + "<td>+6周</td>"
				+ "<td>+7周</td>" + "<td>+8周</td>" + "</tr>"
		$("#mark").append(html)

	}
	if (datas.flag == "4" || datas.flag == "5") {
		var html = "<tr class='table_index_luncun'><td>日期</td><td>用户数</td>"
				+ "<td>+1月</td>" + "<td>+2月</td>" + "<td>+3月</td>"
				+ "<td>+4月</td>" + "<td>+5月</td>" + "<td>+6月</td>" + "</tr>"
		$("#mark").append(html)
	}
	// 数据为空时
	if (datas.retentionList.items == null || datas.retentionList.items == "") {
		var html = "<tr><td colspan='11'>暂时没有任何数据</td></tr>";
		$("#tb").append(html)
	}
	if (datas.retentionList.items != null && datas.retentionList.items != "") {
		var result = datas.retentionList.items;
		// 判断是新增还是活跃
		if (datas.eventFlag == "newUserClick") {
			if (datas.flag == "0") {
				for (var i = 0; i < result.length; i++) {
					var html = "<tr>" + "<td>" + result[i].date + "</td>"
							+ "<td>" + result[i].newUserDay + "</td>"
							+ "<td class='bg_green1'>" + result[i].oneDay
							+ "%</td>" + "<td class='bg_green1'>"
							+ result[i].twoDay + "%</td>"
							+ "<td class='bg_green1'>" + result[i].threeDay
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].fourDay + "%</td>"
							+ "<td class='bg_green2'>" + result[i].fiveDay
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].sixDay + "%</td>"
							+ "<td class='bg_green3'>" + result[i].sevenDay
							+ "%</td>" + "<td class='bg_green3'>"
							+ result[i].fourteenDay + "%</td>"
							+ "<td class='bg_green3'>" + result[i].thirtyDay
							+ "%</td>" + "</tr>";
					$("#tb").append(html)
				}
			}

			if (datas.flag == "2") {
				for (var i = 0; i < result.length; i++) {
					var html = "<tr>" + "<td>" + result[i].date + "</td>"
							+ "<td>" + result[i].newUserWeek + "</td>"
							+ "<td class='bg_green1'>" + result[i].oneWeek
							+ "%</td>" + "<td class='bg_green1'>"
							+ result[i].twoWeek + "%</td>"
							+ "<td class='bg_green1'>" + result[i].threeWeek
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].fourWeek + "%</td>"
							+ "<td class='bg_green2'>" + result[i].fiveWeek
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].sixWeek + "%</td>"
							+ "<td class='bg_green3'>" + result[i].sevenWeek
							+ "%</td>" + "<td class='bg_green3'>"
							+ result[i].eightWeek + "%</td>" + "</tr>";
					$("#tb").append(html)
				}
			}

			if (datas.flag == "4") {
				for (var i = 0; i < result.length; i++) {
					var html = "<tr>" + "<td>" + result[i].date + "</td>"
							+ "<td>" + result[i].monthNewUser + "</td>"
							+ "<td class='bg_green1'>" + result[i].oneMonth
							+ "%</td>" + "<td class='bg_green1'>"
							+ result[i].twoMonth + "%</td>"
							+ "<td class='bg_green1'>" + result[i].threeMonth
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].fourMonth + "%</td>"
							+ "<td class='bg_green2'>" + result[i].fiveMonth
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].sixMonth + "%</td>" + "</tr>";
					$("#tb").append(html)
				}
			}
		} else {
			if (datas.flag == "1") {
				for (var i = 0; i < result.length; i++) {
					var html = "<tr>" + "<td>" + result[i].date + "</td>"
							+ "<td>" + result[i].activeUserDay + "</td>"
							+ "<td class='bg_green1'>" + result[i].oneDay
							+ "%</td>" + "<td class='bg_green1'>"
							+ result[i].twoDay + "%</td>"
							+ "<td class='bg_green1'>" + result[i].threeDay
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].fourDay + "%</td>"
							+ "<td class='bg_green2'>" + result[i].fiveDay
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].sixDay + "%</td>"
							+ "<td class='bg_green3'>" + result[i].sevenDay
							+ "%</td>" + "<td class='bg_green3'>"
							+ result[i].fourteenDay + "%</td>"
							+ "<td class='bg_green3'>" + result[i].thirtyDay
							+ "%</td>" + "</tr>";
					$("#tb").append(html)
				}
			}

			if (datas.flag == "3") {
				for (var i = 0; i < result.length; i++) {
					var html = "<tr>" + "<td>" + result[i].date + "</td>"
							+ "<td>" + result[i].activeUserWeek + "</td>"
							+ "<td class='bg_green1'>" + result[i].oneWeek
							+ "%</td>" + "<td class='bg_green1'>"
							+ result[i].twoWeek + "%</td>"
							+ "<td class='bg_green1'>" + result[i].threeWeek
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].fourWeek + "%</td>"
							+ "<td class='bg_green2'>" + result[i].fiveWeek
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].sixWeek + "%</td>"
							+ "<td class='bg_green3'>" + result[i].sevenWeek
							+ "%</td>" + "<td class='bg_green3'>"
							+ result[i].eightWeek + "%</td>" + "</tr>";
					$("#tb").append(html)
				}
			}

			if (datas.flag == "5") {
				for (var i = 0; i < result.length; i++) {
					var html = "<tr>" + "<td>" + result[i].date + "</td>"
							+ "<td>" + result[i].monthActiveUser + "</td>"
							+ "<td class='bg_green1'>" + result[i].oneMonth
							+ "%</td>" + "<td class='bg_green1'>"
							+ result[i].twoMonth + "%</td>"
							+ "<td class='bg_green1'>" + result[i].threeMonth
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].fourMonth + "%</td>"
							+ "<td class='bg_green2'>" + result[i].fiveMonth
							+ "%</td>" + "<td class='bg_green2'>"
							+ result[i].sixMonth + "%</td>" + "</tr>";
					$("#tb").append(html)
				}
			}
			
		}
		$("#pageRetained").twbsPagination({
			totalPages : datas.retentionList.totalPages,
			visiblePages : 10,
			first : '首页',
			prev : '上一页',
			next : '下一页',
			last : '末页',
			startPage: 1, 
			//href : '?p={{number}}'
			 onPageClick : function(event, page) {  
				 $.ajax({
						type : "POST",
						dataType : "JSON",
						async : true,
						url : path + projectName + "/rest/retained/profile",
						scriptCharset : 'utf-8',
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						data : {
							"appKey" : appInforAppKey,
							"platForm" : platForm,
							"startDate" : startDate,
							"endDate" : endDate,
							"dateTerms" : dateTerms,
							'p':page
						},
						success : function(datas) {
							if (datas != null) {
								common(datas);
							}
						},
						error : function(datas) {
							alert(datas);
						}
					});
	         }  
		});
	}
}
var dateTerms;
$(function() {
	$.ajax({
		type : "POST",
		dataType : "JSON",
		async : true,
		url : path + projectName + "/rest/retained/profile",
		scriptCharset : 'utf-8',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
			"click" : "newUserClick"
		},
		success : function(datas) {
			if (datas != null) {
				common(datas);
			}

		},
		error : function(datas) {
			alert(datas);
		}
	});
	
})
function getClick(clickId) {
	 
	if (clickId == "activeUserClick") {
		$("#retained_active_users").removeClass("right_data_title_glay cp");
		$("#retained_active_users").addClass("cp");
		$("#retained_new_users").removeClass("cp");
		$("#retained_new_users").addClass("right_data_title_glay cp");
	}
	if (clickId == "newUserClick") {
		$("#retained_new_users").removeClass("right_data_title_glay cp");
		$("#retained_new_users").addClass("cp");
		$("#retained_active_users").removeClass("cp");
		$("#retained_active_users").addClass("right_data_title_glay cp");
	}
	$.ajax({
		type : "POST",
		dataType : "JSON",
		async : true,
		url : path + projectName + "/rest/retained/profile",
		scriptCharset : 'utf-8',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
			"dateTerms" : dateTerms,
			"click" : clickId
		},
		success : function(datas) {
			if (datas != null) {
				$('#pageRetained').empty();  
				$('#pageRetained').removeData("twbs-pagination");  
				$('#pageRetained').unbind("page");  
				common(datas)
			}

		},
		error : function(datas) {
			alert(datas);
		}
	});
}
function getdateTerms(dateId) {
 
	dateTerms = dateId;
	$.ajax({
		type : "POST",
		dataType : "JSON",
		async : true,
		url : path + projectName + "/rest/retained/profile",
		scriptCharset : 'utf-8',
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
			"dateTerms" : dateTerms
		},
		success : function(datas) {
			if (datas != null) {
				$('#pageRetained').empty();  
				$('#pageRetained').removeData("twbs-pagination");  
				$('#pageRetained').unbind("page"); 
				common(datas)
			}

		},
		error : function(datas) {
			alert(datas);
		}
	});
	
}
