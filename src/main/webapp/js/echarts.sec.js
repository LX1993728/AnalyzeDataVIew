//获取项目名
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
//加载年龄分布图
function ageloadData() {
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/DataAnalysis/ageEchart",
		dataType : "json",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
		},
		success : function(result) {
			if (result.message != null) {
				alert("暂时没有数据");
			} else {
				if (result.boy != null && result.girl != null) {
					$("#boy").html(result.boy);
					$("#girl").html(result.girl);
				}
				ageEcharts(result);
			}

		}
	});
}

// 加载漏斗图
function sjloadData() {
	eventSortId = "eventUser";
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
			"eventId" : 1,
			"sortId" : 'eventClicks',
		},
		success : function(result) {
			if (result.res == undefined) {
				$("#eventChart").html("");
				sjEcharts(result);
			} else {
				$("#eventChart").html(result.res);
			}
		}
	});
}

// 加载人均使用时长
function nutloadData() {
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
			if (result.message != null) {
				alert("暂时没有数据");
			} else {
				nutEcharts(result);
			}
		}
	});
}
// 加载渠道分布
function channelloadData() {
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/DataAnalysis/channelLoad",
		dataType : "json",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
		},
		success : function(result) {
			if (result.message != null) {
				alert("暂时没有数据");
			} else {
				channelEchars(result);
			}
		}
	});
}

// 点击确定选择版本
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

	nutloadData(); // 加载人均使用时长
	channelloadData(); // 加载 渠道分布
	ageloadData(); // 加载年龄分布
	sjloadData(); // 加载漏斗图

	$.ajax({
		type : "POST",
		async : true, // 同步执行
		url : path + projectName + "/rest/DataAnalysis/datanalysis",
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

// 人均使用时长echarts
function nutEcharts(result) {
	var nutChart = echarts.init(document.getElementById('nut'));
	var optionNut = {
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true,
			y : 20
		},
		tooltip : {
			trigger : 'axis'
		},
		toolbox : {
			show : true,
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : result.xAxis,

			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			}
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			}
		} ],
		series : [ {
			name : '人均使用时长',
			type : 'line',
			smooth : true,
			itemStyle : {
				normal : {
					color : '#3A74BE',
					areaStyle : {
						type : 'default'
					}
				}
			},
			data : result.seriesData
		} ]
	};
	nutChart.setOption(optionNut);

}

// 刷新一次性用户的echars
function loadDataPro(result) {
	var autChart = echarts.init(document.getElementById('aut'));
	var optionAut = {
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true,
			y : 20
		},
		tooltip : {
			trigger : 'axis'
		},
		toolbox : {
			show : true,
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : result.xAxis,
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			}
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			}
		} ],
		series : [ {
			name : '一次性用户',
			type : 'line',
			smooth : true,
			itemStyle : {
				normal : {
					color : '#3A74BE',
					areaStyle : {
						type : 'default'
					}
				}
			},
			data : result.seriesData
		}, ]
	};
	autChart.setOption(optionAut);
}
// 加载年龄分布
function ageEcharts(result) {
	var ageChart = echarts.init(document.getElementById('age'));
	var optionAge = {
		grid : {
			left : '3%',
			right : '10%',
			bottom : '5%',
			containLabel : true,
			y : 20
		},
		tooltip : {},
		xAxis : {
			data : [ '<20', '20-35', '35-45', '45-60', '<60' ],
			axisLabel : {
				inside : true,
				textStyle : {
					color : '#fff'
				}
			},
			axisTick : {
				show : false
			},
			axisLine : {
				show : false
			},
			z : 10
		},
		yAxis : {
			axisLine : {
				show : false
			},
			axisTick : {
				show : false
			},
			axisLabel : {
				textStyle : {
					color : '#999'
				}
			}
		},
		dataZoom : [ {
			type : 'inside'
		} ],
		series : [ {
			type : 'bar',
			itemStyle : {
				normal : {
					color : 'rgba(0,0,0,0.05)'
				}
			},
			barGap : '-100%',
			barCategoryGap : '60%',
			animation : false
		}, {
			name : "男士",
			type : 'bar',
			stack : '广告',
			data : result.boyAge,
			itemStyle : {
				normal : {
					color : new echarts.graphic.LinearGradient(0, 0, 0, 1, [ {
						offset : 0,
						color : '#83bff6'
					}, {
						offset : 0.5,
						color : '#188df0'
					}, {
						offset : 1,
						color : '#188df0'
					} ])
				},
			},
		}, {
			name : "女士",
			type : 'bar',
			stack : '广告',
			data : result.girlAge,
			itemStyle : {
				normal : {
					color : new echarts.graphic.LinearGradient(0, 0, 0, 1, [ {
						offset : 0,
						color : '#FF44AA'
					}, {
						offset : 0.5,
						color : '#FF8888'
					}, {
						offset : 1,
						color : '#F15F74'
					} ])
				},

			},
		}, ]
	};
	ageChart.setOption(optionAge);
}
// 加载漏斗图
function sjEcharts(result) {
	var sjChart = echarts.init(document.getElementById('sj'));
	var optionSj = {
		grid : {
			left : '0%',
			right : '4%',
			bottom : '0%',
			containLabel : true,
			y : 50
		},
		color : [ '#599296', '#C2CDD3', '#D48265', '#749F83', '#91C7AE',
				'#F49631', '#FCAD9D', '#DD4040', '#6DBCBC', '#ADADAD' ],
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c}"
		},
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
	sjChart.setOption(optionSj);
}
// 模块分布echarts
function channelEchars(result) {
	var mouChart = echarts.init(document.getElementById("mou"));
	var optionMou = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			x : 'left',
		},
		color : [ '#FCAD9D', '#DD4040', '#6DBCBC', '#D48265', '#ADADAD',
				'#599296', '#C2CDD3', '#749F83', '#91C7AE', '#F49631' ],
		toolbox : {
			show : true,
		},
		calculable : false,
		series : [ {
			name : '用户数',
			type : 'pie',
			radius : '65%',
			center : [ '50%', '50%' ],
			data : result,
		} ]
	};
	mouChart.setOption(optionMou);
}