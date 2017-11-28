var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

$(function() {
	setDefaultTime();
});
// 设置默认时间为30天
function setDefaultTime() {
	$.ajax({
		type : "get",
		async : true, // 同步执行
		url : path + projectName + "/rest/commonTime/setDefaultTime",
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			/* commonMethod(result); */
			if (result.startTime == result.endTime) {
				$("#timeShow").text(result.startTime);
			} else {
				$("#timeShow").text(result.startTime + " ~ " + result.endTime);
			}
			/* $(".dropdown-menu-data").hide(); */
			$("#startTime").val(result.startTime);
			$("#endTime").val(result.endTime);
		}
	});
}

// 昨天,今天,近30天，时间段
function getEchartModelData(timeArea) {
	$(".dropdown-menu-data").hide();
	var dayCount = $(timeArea).attr("value");
	$.ajax({
		type : "get",
		async : true, // 同步执行
		url : path + projectName + "/rest/commonTime/getCommonTime",
		data : {
			"dayCount" : dayCount
		},
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			commonMethod(result);
		}
	});
}
function getEchartModelDataByCustom() {
	$(".dropdown-menu-data").hide();
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if(startTime!="" && endTime != "" ){
		$.ajax({
			type : "get",
			async : true, // 同步执行
			url : path + projectName + "/rest/commonTime/getCommonTime",
			data : {
				"startTime" : startTime,
				"endTime" : endTime,
			},
			dataType : "json", // 返回数据形式为json
			success : function(result) {
				commonMethod(result);
			}
		});
	}else{
		$("#timeShow").text($("#startTime").val() + " ~ " + $("#endTime").val());
		return false;
	}
}

// 时间段按钮赋值,设置开始时间,结束时间,隐藏时间控件,重新加载图表
function commonMethod(result) {
	if (result.startTime == result.endTime) {
		$("#timeShow").text(result.startTime);
	} else {
		$("#timeShow").text(result.startTime + " ~ " + result.endTime);
	}
	$("#startTime").val(result.startTime);
	$("#endTime").val(result.endTime);
	// 检验是否存在loadModelUseEchart方法
	if (typeof loadModelUseEchart === 'function') {
		loadModelUseEchart(result);
	}
}

// 点击的app对应的平台信息
function getAppPlatform(a) {
	$("#appIndex").text($(a).text());
	$.ajax({
			type : "GET",
			url : path + projectName + "/rest/appPlatform/getAppPlatform",
			data : {
				"appKey" : encodeURI($(a).attr("value")),
				"appName" : encodeURI($(a).text()),
			},
			dataType : "json",
			success : function(data) {
				var re = "";
				/*$.each(data.appPlatformList,function(key, val) {
						re += "<li><a href='javascript:void(0)' onclick='changeAppPlatform(this)'>"
								+ val.platform + "</a></li>";
	
					  });*/
				$("#appPlatformList").html(re);
				alert(data);
				$("#platform").text(data.appInfo);

				/*if (typeof loadModelUseEchart === 'function') {
					loadModelUseEchart();
				}*/
			}
		});

}
// 平台下拉框改变
function changeAppPlatform(a) {
	$.ajax({
		type : "GET",
		url : path + projectName + "/rest/appPlatform/saveAppPlatform",
		data : {
			"platform" : encodeURI($(a).text()),
		},
		dataType : "json",
		success : function(data) {
			$("#platform").text(data.appPlatform);
			if (typeof loadModelUseEchart === 'function') {
				loadModelUseEchart();
			}
		}
	});
}
// 版本筛选
var isClick = false;
function getAllVersion() {
	// 版本筛选框弹出
	$("#version-filterP").toggle();
	// 判断是否第一次点击
	if (!isClick) {
		$.ajax({
			type : "GET",
			url : path + projectName + "/rest/appPlatform/queryAllAppVersion",
			dataType : "json",
			success : function(data) {
				$("#allAppVersion").html("");
				var re = "";
				$.each(data.appVersionList, function(key, val) {
					re += "<li class='selectLi'  value='" + val.appVersion
							+ "' onclick='addActStyle(this)'>" + val.appVersion
							+ "</li>";

				});
				// 全部版本
				$("#allAppVersion").html(re);
				// 默认选中版本
				$('.select-version').each(function() {
					var tmp = $(this).text();
					$('.selectLi').each(function() {
						if ($(this).text() == tmp) {
							$(this).addClass("selectActive");
						}
					});
				});
			}
		});
	}
	isClick = true;
}

function addActStyle(a) {
	$(a).toggleClass("selectActive");
}
// 确定
$("#buttonBlue-confirm").click(function() {
	// 版本被选中
	if ($(".selectLi").hasClass("selectActive")) {
		$("#version-filterP").hide();
		$("#version-promptP").show();
		// 用户选中的版本
		var re = "";
		var version = "";
		$('.selectActive').each(function() {
			re += "<li class='select-version'>" + $(this).text() + "</li>";
			version = version + $(this).text() + ",";
		});
		$("#selectVersion").html(re);
		$.ajax({
			type : "GET",
			url : path + projectName + "/rest/appPlatform/saveSelectVersion",
			dataType : "json",
			data : {
				"version" : version,
			},
			success : function(data) {
				sessionFlag = data.flag;
				if (typeof loadModelUseEchart === 'function') {
					loadModelUseEchart();
				}
			}
		});
		// 版本未被选中
	} else {
		$("#version-filterP").hide();
		$("#version-promptP").hide();
		// 清空session中的version
		$.ajax({
			type : "GET",
			url : path + projectName + "/rest/appPlatform/saveSelectVersion",
			dataType : "json",
			success : function(data) {
				if (typeof loadModelUseEchart === 'function') {
					loadModelUseEchart();
				}
			}
		});
	}
});
// 取消
$("#buttonBlue-cancel").click(function() {
	$("#version-filterP").hide();
	$(".selectLi").removeClass("selectActive");
	$('.select-version').each(function() {
		var tmp = $(this).text();
		$('.selectLi').each(function() {
			if ($(this).text() == tmp) {
				$(this).addClass("selectActive");
			}
		});
	});
});
