$('.anchor_spot li').click(function() {
	var index = $(this).index();
	$('html, body').animate({
		scrollTop : $($(".report_anchor_spot").eq(index)).offset().top
	}, 500);
	return false;
});
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
// 异常

// var pageExce=echarts.init(document.getElementById("pageExce"));
// var optioncorpageExce = {
//		
// }
// pageExce.setOption(optioncorpageExce);

// 评价
$.ajax({
	type : "GET",
	async : true, // 同步执行
	url : path + projectName + "/rest/researchreport/getuserPC",
	dataType : "json",
	data : {
	// "startDate":startDate,
	// "endDate":endDate,
	},
	success : function(result) {
		reportVisitRate(result);
	}
});
/* 左边 */
function reportVisitRate(result) {
	// 月份
	var date = [];

	// 用户增量数据
	var userCount = [];
	var userActive = [];

	// 左边评论
	var out = [];
	var inv = [];

	// 用户留存、活跃用户留存
	var userRetain = [];
	var activeUserRetain = [];

	// 应用与页面启动、异常数T为当月、Y为上月
	var appTotal = [];
	var appExce = [];
	var pageTotal = [];
	var pageExce = [];

	// 右边评论小圆
	var rup = [];
	var rdow = [];
	// 活跃用户占比
	var actUserT = [];
	var actUserY = [];
	// 活跃用户留存占比
	var actUerT = [];
	var actUerD = [];

	for ( var re in result) {
		// 当前时间的月份
		var time = parseInt(new Date().toLocaleString().substring(5, 7));
		// 获取后台数据时间月份

		var vtime = new Date(parseInt(result[re].date)).toLocaleString()
				.substring(5, 7);

		if (vtime.indexOf("/") == 1) {
			vtime = parseInt(vtime.substring(0, 1));
		} else {
			vtime = parseInt(vtime);
		}
		if ((time - vtime) == 1) {
			// 获取月份
			date.push(vtime + "月份");
			// 获取增量数据
			var userTotalCount = {
				name : vtime + "月用户总量",
				value : result[re].userTotal
			};
			var activeUserTotal = {
				name : vtime + "月活跃用户总量",
				value : result[re].activeUserTotal
			};
			userCount.push(userTotalCount);
			userActive.push(activeUserTotal);

			// 获取留存用户、活跃用户留存
			var retainUserCount = {
				name : vtime + "月用户留存总量",
				value : result[re].userRetainedTotal
			};
			userRetain.push(retainUserCount);
			var retainActUser = {
				name : vtime + "月活跃用户留存总量",
				value : result[re].activeUserRetainedTotal
			};
			activeUserRetain.push(retainActUser);

			// 左侧当月评论数据
			var objp = {
				name : "好评总数",
				value : result[re].userPraiseTotal
			};
			var objt = {
				name : "差评总数",
				value : result[re].userCommentsTotal
						- result[re].userPraiseTotal
			};
			out.push(objp);
			out.push(objt);

			var objc = {
				name : "评论总数",
				value : result[re].userCommentsTotal
			};
			var objnc = {
				name : "未评论数",
				value : result[re].visitTotal - result[re].userCommentsTotal
			};
			inv.push(objc);
			inv.push(objnc);
			// 本月活跃用户量
			var actUserTotal = {
				name : vtime + "月活跃用户量",
				value : result[re].activeUserTotal
			};
			var userTotal = {
				name : vtime + "月非活跃用户量",
				value : result[re].userTotal - result[re].activeUserTotal
			};
			actUserT.push(actUserTotal);
			actUserT.push(userTotal);

			// 本月活跃用户留存量
			var actUerRetain = {
				name : vtime + "月活跃用户留存量",
				value : result[re].activeUserRetainedTotal
			};
			var actUerloss = {
				name : vtime + "月活跃用户流失量",
				value : result[re].activeUserTotal
						- result[re].activeUserRetainedTotal
			};
			actUerT.push(actUerRetain);
			actUerT.push(actUerloss);

			// 应用异常数
			var appStartTotal = {
				name : vtime + "月程序启动总量",
				value : result[re].applicationStartTotal
			};
			var appStartExce = {
				name : vtime + "月程序异常总量",
				value : result[re].applicationExceTotal
			};
			var pageStartTotal = {
				name : vtime + "月页面访问总量",
				value : result[re].pageVisitTotal
			};
			var pageStartExce = {
				name : vtime + "月页面异常总量",
				value : result[re].pageExceTotal
			};
			appTotal.push(appStartTotal);
			appExce.push(appStartExce);
			pageTotal.push(pageStartTotal);
			pageExce.push(pageStartExce);

			// 右侧本月评论数据
			var rupObjP = {
				name : vtime + "月好评",
				value : result[re].userPraiseTotal
			};
			var rupObjC = {
				name : vtime + "月评论",
				value : result[re].userCommentsTotal
			};
			var rupObjV = {
				name : vtime + "月访问",
				value : result[re].visitTotal
			};
			rup.push(rupObjP);
			rup.push(rupObjC);
			rup.push(rupObjV);

		} else {
			// 获取月份
			date.push(vtime + "月份");
			// 获取增量数据
			var userTotalCount = {
				name : vtime + "月用户总量",
				value : result[re].userTotal
			};
			var activeUserTotal = {
				name : vtime + "月活跃用户总量",
				value : result[re].activeUserTotal
			};
			userCount.push(userTotalCount);
			userActive.push(activeUserTotal);
			// 获取留存用户、活跃用户留存
			var retainUserCount = {
				name : vtime + "月用户留存总量",
				value : result[re].userRetainedTotal
			};
			userRetain.push(retainUserCount);
			var retainActUser = {
				name : vtime + "月活跃用户留存总量",
				value : result[re].activeUserRetainedTotal
			};
			activeUserRetain.push(retainActUser);
			// 活跃用户占比
			var actUserTotal = {
				name : vtime + "月活跃用户量",
				value : result[re].activeUserTotal
			};
			var userTotal = {
				name : vtime + "月非活跃用户量",
				value : result[re].userTotal - result[re].activeUserTotal
			};
			actUserY.push(actUserTotal);
			actUserY.push(userTotal);

			// 本月活跃用户留存量
			var actUerRetain = {
				name : vtime + "月活跃用户留存量",
				value : result[re].activeUserRetainedTotal
			};
			var actUerloss = {
				name : vtime + "月活跃用户流失量",
				value : result[re].activeUserTotal
						- result[re].activeUserRetainedTotal
			};
			actUerD.push(actUerRetain);
			actUerD.push(actUerloss);

			// 应用异常数
			var appStartTotal = {
				name : vtime + "月程序启动总量",
				value : result[re].applicationStartTotal
			};
			var appStartExce = {
				name : vtime + "月程序异常总量",
				value : result[re].applicationExceTotal
			};
			var pageStartTotal = {
				name : vtime + "月页面访问总量",
				value : result[re].pageVisitTotal
			};
			var pageStartExce = {
				name : vtime + "月页面异常总量",
				value : result[re].pageExceTotal
			};
			appTotal.push(appStartTotal);
			appExce.push(appStartExce);
			pageTotal.push(pageStartTotal);
			pageExce.push(pageStartExce);

			// 右侧上月评论数据
			var rdowObjP = {
				name : vtime + "月好评",
				value : result[re].userPraiseTotal
			};
			var rdowObjC = {
				name : vtime + "月评论",
				value : result[re].userCommentsTotal
			};
			var rdowObjV = {
				name : vtime + "月访问",
				value : result[re].visitTotal
			};
			rdow.push(rdowObjP);
			rdow.push(rdowObjC);
			rdow.push(rdowObjV);
		}

	}

	// 用户健康度 userHD
	var recoruserHD = echarts.init(document.getElementById("userHD"));
	var optionuserHD = {
		grid : {
			left : '8%',
			right : '4%',
			bottom : '5%',
			containLabel : true,
			y : 40
		},
		color : [ '#5CE3A2', '#FF8393' ],
		tooltip : {},
		xAxis : [ {
			type : 'category',
			data : date,
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			},
			axisPointer : {
				type : 'shadow'
			}
		} ],
		yAxis : [ {
			type : 'value',
			name : '用户数',
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			},
			min : 0,
		} ],
		series : [ {
			name : '活跃用户',
			type : 'bar',
			barWidth : '15%',
			data : userActive
		}, {
			name : '用户总量',
			type : 'bar',
			barWidth : '15%',
			data : userCount
		} ]
	};
	recoruserHD.setOption(optionuserHD);

	// 本月用户留存量actUserRR
	var recoractUserRR = echarts.init(document.getElementById("actUserRR"));
	var optionactUserRR = {
		grid : {
			left : '8%',
			right : '4%',
			bottom : '5%',
			containLabel : true,
			y : 40
		},
		color : [ '#5CE3A2', '#FF8393' ],
		tooltip : {},
		xAxis : [ {
			type : 'category',
			data : date,
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			},
			axisPointer : {
				type : 'shadow'
			}
		} ],
		yAxis : [ {
			type : 'value',
			name : '用户数',
			min : 0,
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa'
				}
			}
		} ],
		series : [ {
			name : '活跃用户留存',
			type : 'bar',
			barWidth : '15%',
			data : activeUserRetain
		}, {
			name : '留存用户',
			type : 'bar',
			barWidth : '15%',
			data : userRetain
		} ]
	};
	recoractUserRR.setOption(optionactUserRR);

	// 活跃用户增量（健康度） actUserNumT
	var recoractUserNumT = echarts.init(document.getElementById("actUserNumT"));
	var optionactUserNumT = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			x : 'right',
			y : 'bottom',
			textStyle : {
				color : '#fff',
			},
			data : actUserT
		},
		color : [ '#00B6CE', '#5D687C' ],
		series : [ {
			center : [ 100, 80 ],
			name : '活跃用户占比',
			type : 'pie',
			radius : [ '60%', '80%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '10',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : actUserT
		} ]
	}
	recoractUserNumT.setOption(optionactUserNumT);
	var recoractUserNumD = echarts.init(document.getElementById("actUserNumD"));
	var optionactUserNumD = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			x : 'right',
			y : 'bottom',
			textStyle : {
				color : '#fff',
			},
			data : actUserY
		},
		color : [ '#3973BD', '#5D687C' ],
		series : [ {
			center : [ 100, 80 ],
			name : '活跃用户占比',
			type : 'pie',
			radius : [ '60%', '80%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '12',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : actUserY
		} ]
	}
	recoractUserNumD.setOption(optionactUserNumD);

	// 活跃用户留存 actUserT actUserD
	var recoractUserT = echarts.init(document.getElementById("actUserT"));
	var optionactUserT = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			x : 'left',
			y : 'bottom',
			textStyle : {
				color : '#fff',
			},
			data : actUerT
		},
		color : [ '#00B7CC', '#5D687C' ],
		series : [ {
			center : [ 200, 80 ],
			name : '活跃用户留存',
			type : 'pie',
			radius : [ '60%', '80%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '10',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : actUerT
		} ]
	}
	recoractUserT.setOption(optionactUserT);
	var recoractUserD = echarts.init(document.getElementById("actUserD"));
	var optionactUserD = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			x : 'left',
			y : 'bottom',
			textStyle : {
				color : '#fff',
			},
			data : actUerD
		},
		color : [ '#3A74BE', '#5D687C' ],
		series : [ {
			center : [ 200, 80 ],
			name : '活跃用户留存',
			type : 'pie',
			radius : [ '60%', '80%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '10',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : actUerD
		} ]
	}
	recoractUserD.setOption(optionactUserD);

	// 应用健壮性 pexception
	var recorPERate = echarts.init(document.getElementById("pexception"));

	var optionPERate = {
		grid : {
			left : '3%',
			right : '4%',
			bottom : '5%',
			containLabel : true,
			y : 40
		},
		color : [ '#3B75BF', '#00B5CD', '#5BE5A0', '#FD8492' ],
		tooltip : {},
		xAxis : [ {
			type : 'category',
			data : date,
			axisPointer : {
				type : 'shadow'
			},
			axisLabel : {
				data : date,
				show : true,
				textStyle : {
					color : '#aaa'
				}
			}
		} ],
		yAxis : [ {
			type : 'value',
			min : 0,
			axisLabel : {
				data : date,
				show : true,
				textStyle : {
					color : '#aaa'
				}
			}
		} ],
		series : [ {
			name : '程序启动总量',
			type : 'bar',
			barWidth : '15%',
			data : appTotal
		}, {
			name : '程序异常总量',
			type : 'bar',
			barWidth : '15%',
			data : appExce
		}, {
			name : '页面访问总量',
			type : 'bar',
			barWidth : '15%',
			data : pageTotal
		}, {
			name : '页面异常总量',
			type : 'bar',
			barWidth : '15%',
			data : pageExce
		} ]
	};
	recorPERate.setOption(optionPERate);

	// 左侧用户好评率
	var recorVisitRate = echarts.init(document.getElementById("visitrate"));
	var optioncorVisitRate = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		color : [ '#42BC81', '#0D9EB1' ],
		series : [ {
			name : '访问来源',
			type : 'pie',
			selectedMode : 'single',
			radius : [ 0, '40%' ],

			label : {
				normal : {
					position : 'inner'
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : out
		}, {
			name : '访问来源',
			type : 'pie',
			radius : [ '60%', '85%' ],
			data : inv
		} ]
	}
	recorVisitRate.setOption(optioncorVisitRate);

	/* 右边 当月用户增长率 */
	var recorPreO = echarts.init(document.getElementById("preO"));
	var recorPreT = echarts.init(document.getElementById("preT"));
	var optioncorPreO = {
		tooltip : {
			trigger : 'item',
		},
		legend : {
			orient : 'vertical',
			x : 'right',
			y : 'bottom',
			textStyle : {
				color : '#fff',
			},
			data : rup
		},
		color : [ '#3B75BF', '#00B6CE', '#5D687C' ],
		series : [ {
			center : [ 100, 80 ],
			type : 'pie',
			radius : [ '60%', '80%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '10',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : rup
		} ]
	}
	recorPreO.setOption(optioncorPreO);
	/* 右边 上月用户增长率 */
	var optioncorPreT = {
		tooltip : {
			trigger : 'item',
		},
		legend : {
			orient : 'vertical',
			x : 'right',
			y : 'bottom',
			textStyle : {
				color : '#fff',
			},
			data : rdow
		},
		color : [ '#3B75BF', '#00B6CE', '#5D687C' ],
		series : [ {
			center : [ 100, 80 ],
			type : 'pie',
			radius : [ '60%', '80%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '10',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : rdow
		} ]
	}
	recorPreT.setOption(optioncorPreT);

}

// 事件
var recorEventL = echarts.init(document.getElementById("corEventL"));
var recorEventO = echarts.init(document.getElementById("corEventO"));
var recorEventV = echarts.init(document.getElementById("corEventV"));
var recorEventE = echarts.init(document.getElementById("corEventE"));
var recorEventT = echarts.init(document.getElementById("corEventT"));

$.ajax({
	type : "GET",
	async : true, // 同步执行
	url : path + projectName + "/rest/event/coreEvent",
	dataType : "json",
	data : {
	// "startDate":startDate,
	// "endDate":endDate,
	},
	success : function(result) {
		reportCoreEvent(result);
	}
});
function reportCoreEvent(result) {

	var fir = [];
	var sed = [];
	var thir = [];
	var fort = [];
	var fiv = [];
	var eventName = [];

	for (var i = 0; i < result.length; i++) {
		if (i == 0) {
			var obj = {
				name : result[i].eventName + "触发数",
				value : result[i].eventNumber
			};
			var obt = {
				name : result[i].eventName + "达成数",
				value : result[i].finishNumber
			};
			fir.push(obj);
			fir.push(obt);
			eventName.push(result[i].eventName);
		}
		if (i == 1) {
			var obj = {
				name : result[i].eventName + "触发数",
				value : result[i].eventNumber
			};
			var obt = {
				name : result[i].eventName + "达成数",
				value : result[i].finishNumber
			};
			sed.push(obj);
			sed.push(obt);
			eventName.push(result[i].eventName);
		}
		if (i == 2) {
			var obj = {
				name : result[i].eventName + "触发数",
				value : result[i].eventNumber
			};
			var obt = {
				name : result[i].eventName + "达成数",
				value : result[i].finishNumber
			};
			thir.push(obj);
			thir.push(obt);
			eventName.push(result[i].eventName);
		}
		if (i == 3) {
			var obj = {
				name : result[i].eventName + "触发数",
				value : result[i].eventNumber
			};
			var obt = {
				name : result[i].eventName + "达成数",
				value : result[i].finishNumber
			};
			fort.push(obj);
			fort.push(obt);
			eventName.push(result[i].eventName);
		}
		if (i == 4) {
			var obj = {
				name : result[i].eventName + "触发数",
				value : result[i].eventNumber
			};
			var obt = {
				name : result[i].eventName + "达成数",
				value : result[i].finishNumber
			};
			fiv.push(obj);
			fiv.push(obt);
			eventName.push(result[i].eventName);
		}
	}

	var optionrecorEventL = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		color : [ '#5D687B', '#5CE3A2' ],
		graphic : {
			type : 'text',
			left : '130',
			top : '280',
			scale : [ 1.4, 1.4 ],
			style : {
				text : eventName[0],
				textAlign : 'center',
				fill : 'rgba(255,255,255,1)',
				width : 50,
				height : 50,
			}
		},
		series : [ {
			center : [ 150, 160 ],
			type : 'pie',
			radius : [ '50%', '70%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '14',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : fir
		} ]

	}
	recorEventL.setOption(optionrecorEventL);
	var optionrecorEventO = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		color : [ '#5D687B', '#FF8393' ],
		graphic : {
			type : 'text',
			left : '120',
			top : '280',
			scale : [ 1.4, 1.4 ],
			style : {
				text : eventName[1],
				textAlign : 'center',
				fill : 'rgba(255,255,255,1)',
				width : 50,
				height : 50,
			}
		},
		series : [ {
			center : [ 140, 160 ],
			type : 'pie',
			radius : [ '50%', '70%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '14',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : sed
		} ]
	}
	recorEventO.setOption(optionrecorEventO);
	var optionrecorEventV = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		color : [ '#5C687B', '#36A4DC' ],
		graphic : {
			type : 'text',
			left : '110',
			top : '280',
			scale : [ 1.4, 1.4 ],
			style : {
				text : eventName[2],
				textAlign : 'center',
				fill : 'rgba(255,255,255,1)',
				width : 50,
				height : 50,
			}
		},
		series : [ {
			center : [ 130, 160 ],
			type : 'pie',
			radius : [ '50%', '70%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '14',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : thir
		} ]

	}
	recorEventV.setOption(optionrecorEventV);
	var optionrecorEventE = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		color : [ '#5D687B', '#FFAD0B' ],
		graphic : {
			type : 'text',
			left : '100',
			top : '280',
			scale : [ 1.4, 1.4 ],
			style : {
				text : eventName[3],
				textAlign : 'center',
				fill : 'rgba(255,255,255,1)',
				width : 50,
				height : 50,
			}
		},
		series : [ {
			center : [ 120, 160 ],
			type : 'pie',
			radius : [ '50%', '70%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '14',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : fort
		} ]

	}
	recorEventE.setOption(optionrecorEventE);
	var optionrecorEventT = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b}: {c} ({d}%)"
		},
		color : [ '#5D687B', '#00B6CE' ],
		graphic : {
			type : 'text',
			left : '90',
			top : '280',
			scale : [ 1.4, 1.4 ],
			style : {
				text : eventName[4],
				textAlign : 'center',
				fill : 'rgba(255,255,255,1)',
				width : 50,
				height : 50,
			}
		},
		series : [ {
			center : [ 110, 160 ],
			type : 'pie',
			radius : [ '50%', '70%' ],
			avoidLabelOverlap : false,
			label : {
				normal : {
					show : false,
					position : 'center'
				},
				emphasis : {
					show : true,
					textStyle : {
						fontSize : '14',
						fontWeight : 'bold'
					}
				}
			},
			labelLine : {
				normal : {
					show : false
				}
			},
			data : fiv
		} ]

	}
	recorEventT.setOption(optionrecorEventT);
}

// 渠道

$.ajax({
	type : "GET",
	async : true, // 同步执行
	url : path + projectName + "/rest/DataAnalysis/reportChannel",
	dataType : "json",
	data : {
	// "startDate":startDate,
	// "endDate":endDate,
	},
	success : function(result) {
		reportChannel(result);
	}
});

function reportChannel(result) {
	var datas = [];
	var name = []
	for (var i = 0; i < result.length; i++) {
		var obj = {
			name : result[i].name,
			value : result[i].value
		};
		datas.push(obj);
		name.push(result[i].name);
	}
	var reportChannel = echarts.init(document.getElementById("reportChannel"));
	var optionReChannel = {

		tooltip : {
			trigger : 'item',
		},
		legend : {
			orient : 'vertical',
			x : 'left',
			data : name,
			textStyle : {
				color : '#fff'
			}
		},
		color : [ '#FCAD9D', '#DD4040', '#6DBCBC', '#D48265', '#ADADAD',
				'#599296', '#C2CDD3', '#749F83', '#91C7AE', '#F49631' ],
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : [ '40%', '55%' ],
			label : {
				normal : {
					backgroundColor : '#eee',
					borderColor : '#aaa',
					borderWidth : 1,
					borderRadius : 4,
					rich : {
						a : {
							color : '#999',
							lineHeight : 22,
							align : 'center'
						},
						hr : {
							borderColor : '#aaa',
							width : '100%',
							borderWidth : 0.5,
							height : 0
						},
						b : {
							fontSize : 16,
							lineHeight : 33
						},
						per : {
							color : '#eee',
							backgroundColor : '#334455',
							padding : [ 2, 4 ],
							borderRadius : 2
						}
					}
				}
			},
			data : datas
		} ]

	};
	reportChannel.setOption(optionReChannel);
}
