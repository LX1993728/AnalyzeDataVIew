var platForm = "";
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
// 获取首页appKey
var appInforAppKey = $("#get_appKey").attr("rel");
$(function() {
	reload(platForm);
})

$("#pla_Form_bt").click(function() {
	$("#app-form-group").addClass("hidden")
	var appInput = $("#app-form-group input");

	$("input[name='platform']:checkbox").each(function() {
		if ($(this).is(":checked")) {
			platForm += $(this).attr("value") + "+";
		}
	});
	if (platForm != null && platForm.length > 1) {
		platForm = platForm.substring(0, platForm.length - 1);
	}
	if (platForm == "") {
		alert("平台不能为空！");
		return;
	}
	// for(var i=0;i<appInput.length;i++){
	// if(appInput[i].checked && appInput[i].value!=null ){
	// platForm+=appInput[i].value+"+";
	// }
	// };
	reload(platForm)
	location.reload();
});

function reload(platForm) {
	/*
	 * //首页用户数据 var sjChart = echarts.init(document.getElementById('sj'));
	 * $.ajax({ type : "GET", async : true, // 同步执行 url : path+ projectName +
	 * "/rest/summaryTrendEchart/getTrendEchartsYonghu", dataType : "json",
	 * data:{ "appKey" : appInforAppKey, "platForm" : platForm, "today":endDate },
	 * success : function(result) { userData(result); } });
	 * 
	 * function userData(rst){ var optionSj = { tooltip: { trigger: 'item',
	 * formatter: "{b} <br/>{c}: {a} ({d}%)" },
	 * color:['#FF8196','#5EE3A4','#5D687B'], legend: { orient: 'horizontal', x:
	 * 'left', y: 'bottom', data:['用户总量','昨日新增用户','昨日活跃用户'], textStyle:{
	 * color:'#aaa', }, padding:[50,0,20,40], }, graphic:{ type:'text',
	 * left:'125', top:'85', scale: [1.4, 1.4], style:{
	 * text:'用户总量\n\n'+rst.totalUserSize, textAlign:'center',
	 * fill:'rgba(94,227,160,1)', width:50, height:50, } }, series: [ {
	 * center:[160,110], name:'用户数据', type:'pie', radius: ['45%', '65%'],
	 * avoidLabelOverlap: false, label: { normal: { show: false, position:
	 * 'center' }, emphasis: { show: false, textStyle: { fontSize: '20',
	 * fontWeight: 'bold', color: 'rgba(94,227,160,1)'
	 *  } } }, labelLine: { normal: { show: false } }, data:[
	 * {value:rst.actUserSize, name:'昨日活跃用户'}, {value:rst.newUserSize,
	 * name:'昨日新增用户'}, // {value:rst.totalUserSize, name:'用户总量'} ] } ] };
	 * sjChart.setOption(optionSj); };
	 */

	// 暂时要求是右上角柱状图
	var sjChart = echarts.init(document.getElementById('shuju'));
	var optionSj = {
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '0%',
			y : 30,
			containLabel : true
		},
		color : [ '#026b57', '#008d63', '#01bc77', '#6af5ad', "#c8ffe2" ],
		xAxis : [ {
			type : 'category',
			data : [ '2017-09-26', '2017-10-03', '2017-10-10', '2017-10-17',
					'2017-10-24', '2017-11-01', '2017-11-07' ],
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
		legend : {
			itemGap : 1,
			data : [ '新用户', '本周回流', '活跃2周', '活跃3周', '忠实用户' ],
			textStyle : {
				fontSize : 10,
				color : '#aaa',
			}
		},
		series : [ {
			name : '新用户',
			type : 'bar',
			stack : '总量',
			data : [ 320, 332, 301, 334, 390, 330, 320 ]
		}, {
			name : '本周回流',
			type : 'bar',
			stack : '总量',
			data : [ 120, 132, 101, 134, 90, 230, 210 ]
		}, {
			name : '活跃2周',
			type : 'bar',
			stack : '总量',
			data : [ 220, 182, 191, 234, 290, 330, 310 ]
		}, {
			name : '活跃3周',
			type : 'bar',
			stack : '总量',
			data : [ 150, 232, 201, 154, 190, 330, 410 ]
		}, {
			name : '忠实用户',
			type : 'bar',
			stack : '总量',
			data : [ 150, 232, 201, 154, 190, 330, 410 ],
			barWidth : 30
		}, ]
	};
	sjChart.setOption(optionSj);

	// 首页 活跃用户
	var legendStr = "新增用户";
	var legendSt = "活跃用户";
	// 点击活跃用户加载echars
	$("#hy").click(function() {
		var auChart = echarts.init(document.getElementById('au'));
		$(function() {
			activeEchartsData(encodeURI(legendSt));
		});
		function activeEchartsData(legendSt) {
			$.ajax({
				type : "GET",
				url : path + projectName + "/rest/profile/activeUser",
				data : {
					"appKey" : appInforAppKey,
					"platForm" : platForm,
					"startDate" : startDate,
					"endDate" : endDate,
				},
				dataType : "json",
				success : function(data) {
					activeEchart(data);

				}
			});

		}
		function activeEchart(result) {
			var optionAu = {

				tooltip : {
					trigger : 'axis',
					axisPointer : {
						label : {
							backgroundColor : '#000'
						}
					}
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true,
					y : 20
				},

				xAxis : [ {
					type : 'category',
					boundaryGap : true,
					data : result.xAxis,
					splitLine : {
						show : false
					},
					axisLabel : {
						show : true,
						textStyle : {
							color : '#aaa'
						}
					}

				} ],

				yAxis : {
					type : 'value',
					axisLabel : {
						show : true,
						textStyle : {
							color : '#aaa'
						}
					}
				},
				series : {
					name : result.legend,
					type : 'line',
					data : result.seriesData,
					itemStyle : {
						normal : {
							color : '#6699FF'
						}
					},
					smooth : true
				}
			};
			auChart.setOption(optionAu);

		}
	})

	// 首页新增用户
	var nuChart = echarts.init(document.getElementById('nu'));
	$(function() {
		getTrendEchartsData(encodeURI(legendStr));
	});
	function getTrendEchartsData(legendStr) {

		$.ajax({
			type : "GET",
			url : path + projectName + "/rest/profile/newUser",
			data : {
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate" : startDate,
				"endDate" : endDate,
			},
			dataType : "json",
			success : function(data) {
				loadTrendEchart(data);

			}
		});

	}
	function loadTrendEchart(result) {
		var option = {

			tooltip : {
				trigger : 'axis',
				axisPointer : {
					label : {
						backgroundColor : '#000'
					}
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true,
				y : 20
			},

			xAxis : [ {
				type : 'category',
				boundaryGap : true,
				data : result.xAxis,
				splitLine : {
					show : false
				},
				axisLabel : {
					show : true,
					textStyle : {
						color : '#aaa'
					}
				}

			} ],

			yAxis : {
				type : 'value',
				axisLabel : {
					show : true,
					textStyle : {
						color : '#aaa'
					}
				}
			},
			series : {
				name : result.legend,
				type : 'line',
				data : result.seriesData,
				itemStyle : {
					normal : {
						color : '#6699FF'
					}
				},
				smooth : true
			}
		};
		nuChart.setOption(option);

	}

	// 首页中国地图
	var mapChart = echarts.init(document.getElementById('map'));
	function randomValue() {
		return Math.round(Math.random() * 1000);
	}

	var datas = [];
	var name = null;
	var val = null;

	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/area/areaUserRegionChart",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
		},
		dataType : "json",
		success : function(result) {

			for ( var key in result) {
				name = key;
				val = result[key];
				var area = {
					name : name,
					value : val
				};
				if (area.name != "null" && area.val != "null") {
					datas.push(area);
				}
			}
			;
			distrArea(datas);
		}
	});

	function distrArea(result) {
		var optionMap = {
			tooltip : {},
			visualMap : {
				min : 0,
				max : 1500,
				left : 'left',
				top : 'bottom',
				text : [ '1500', '0' ],
				seriesIndex : [ 1 ],
				inRange : {
					color : [ '#e0ffff', '#006edd' ]
				},
				itemWidth : '10px',
				itemHeight : '50px',
				textStyle : {
					color : "#aaa"
				},
			},
			geo : {
				map : 'china',
				roam : false,
				itemStyle : {
					normal : {
						borderColor : 'rgba(0, 0, 0, 0.2)'
					},
					emphasis : {
						areaColor : null,
						shadowOffsetX : 0,
						shadowOffsetY : 0,
						shadowBlur : 20,
						borderWidth : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			},
			series : [ {
				type : 'scatter',
				coordinateSystem : 'geo',
				symbolSize : 20,
				symbolRotate : 35,
				label : {
					normal : {
						formatter : '{b}',
						position : 'right',
						show : false
					},
					emphasis : {
						show : true
					}
				},
				itemStyle : {
					normal : {
						color : '#F06C00'
					}
				}
			}, {
				name : '用户量',
				type : 'map',
				geoIndex : 0,
				data : result
			} ]
		};
		mapChart.setOption(optionMap);
	}
	;

	// 首页TOP模块
	var topChart = echarts.init(document.getElementById('top'));
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/moudle/getTopModelUse",
		data : {
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate" : startDate,
			"endDate" : endDate,
		},
		dataType : "json", // 返回数据形式为json
		success : function(result) {
			if (result.message == undefined) {
				loadMoudle(result);
			} else {
				$("#top").html(result.message);
			}
		}
	});
	function loadMoudle(result) {
		var optionTop = {
			color : [ '#6699fe' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '0%',
				right : '10%',
				bottom : '3%',
				containLabel : true,
				y : 30
			},
			xAxis : [ {
				type : 'value',
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
				type : 'category',
				data : result.yAxis.reverse(),
				axisLabel : {
					show : true,
					textStyle : {
						color : '#aaa',
					}
				}
			} ],
			series : [ {
				type : 'bar',
				barWidth : '50%',
				data : result.seriesData.reverse(),
			} ]
		};
		topChart.setOption(optionTop);
	}

	// 首页用户留存
	// var lcChart = echarts.init(document.getElementById('lc'));
	//		
	// $.ajax({
	// type : "GET",
	// async : true, // 同步执行
	// url : path+ projectName + "/rest/retention/retentionUser",
	// data:{
	// "appKey" : appInforAppKey,
	// "platForm" : platForm,
	// "startDate":startDate,
	// "endDate":endDate,
	// },
	// dataType : "json", // 返回数据形式为json
	// success : function(result) {
	// loadoptionLc(result);
	// }
	// });

	function loadoptionLc(result) {
		optionLc = {
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true,
				y : 20,
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
				name : '留存用户',
				type : 'bar',
				barWidth : '15%',
				data : result.seriesData,
				itemStyle : {
					normal : {
						color : '#55C076'
					}
				},
			}, {
				name : '流失用户',
				type : 'bar',
				barWidth : '15%',
				data : result.seriesDatalost,
				itemStyle : {
					normal : {
						color : '#F15755'
					}
				},
			}, {
				name : '回流用户',
				type : 'bar',
				barWidth : '15%',
				data : result.seriesDataback,
				itemStyle : {
					normal : {
						color : '#ADD497'
					}
				},
			} ]
		};

		lcChart.setOption(optionLc);
	}
	;
}
