//鼠标移动到帮助按钮上显示div移开隐藏
$("#sexHelp").mouseover(function() {
	$("#sexInstruction").removeClass("hide");
})
$("#sexHelp").mouseout(function() {
	$("#sexInstruction").addClass("hide");
})
$("#ageHelp").mouseover(function() {
	$("#ageInstruction").removeClass("hide");
})
$("#ageHelp").mouseout(function() {
	$("#ageInstruction").addClass("hide");
})
$("#areaHelp").mouseout(function() {
	$("#areaInstruction").addClass("hide");
})
$("#areaHelp").mouseover(function() {
	$("#areaInstruction").removeClass("hide");
})
$("#moblieHelp").mouseout(function() {
	$("#moblieInstruction").addClass("hide");
})
$("#moblieHelp").mouseover(function() {
	$("#moblieInstruction").removeClass("hide");
})

// 初始化echarts对应的div的ID
var groupSex = document.getElementById("userSex");
var groupAge = document.getElementById("userAge");
var groupArea = document.getElementById("userArea");
var groupTopArea = document.getElementById("userTopArea");

// 设置每个div对应的echartsId并初始化对应divId
var sexCharts = echarts.init(groupSex);
var ageCharts = echarts.init(groupAge);
var areaCharts = echarts.init(groupArea);
var topAreaCharts = echarts.init(groupTopArea);

// echarts中数据
var sex = [ {
	name : "男",
	value : 3335
}, {
	name : "女",
	value : 3335
}, {
	name : "未知",
	value : 1234
} ];
var ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
var ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
var ageX = [ 1123, 1135, 1142, 1112, 1194 ];
var topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021, 12312 ];

// 初次加载echarts
$(function() {
	loadMoblie();
	loadSex();
	loadAge();
	loadTopArea();
	loadArea();
});

// 鼠标移动时 echarts切换
areaCharts.on('mouseover',
		function(params) {
			if (params.name == "黑龙江") {
				sex = [ {
					name : "男",
					value : 1335
				}, {
					name : "女",
					value : 2335
				}, {
					name : "未知",
					value : 934
				} ];
				ageMan = [ 231, 1435, 1242, 1112, 1034 ];
				ageWomen = [ 1231, 335, 542, 1212, 934 ];
				ageX = [ 923, 935, 1022, 212, 94 ];
				topArea = [ 1011, 2346, 1121, 2345, 2231, 4572, 5432, 1120,
						4021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "辽宁") {

				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "吉林") {

			}
			if (params.name == "新疆") {

			}
			if (params.name == "内蒙古") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();

			}
			if (params.name == "西藏") {
				sex = [ {
					name : "男",
					value : 5335
				}, {
					name : "女",
					value : 7335
				}, {
					name : "未知",
					value : 34
				} ];
				ageMan = [ 3231, 4435, 6242, 812, 334 ];
				ageWomen = [ 1231, 2635, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "北京") {

			}
			if (params.name == "天津") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "河北") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "河南") {

			}
			if (params.name == "山东") {

			}
			if (params.name == "山西") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "陕西") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "甘肃") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "青海") {

			}
			if (params.name == "四川") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "重庆") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "湖北") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "湖南") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "江苏") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "浙江") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "上海") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "福建") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "广西") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "广东") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "安徽") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "云南") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "海南") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "台湾") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
			if (params.name == "江西") {
				sex = [ {
					name : "男",
					value : 2335
				}, {
					name : "女",
					value : 4335
				}, {
					name : "未知",
					value : 234
				} ];
				ageMan = [ 1231, 4435, 6242, 812, 334 ];
				ageWomen = [ 5231, 2335, 9542, 7212, 2934 ];
				ageX = [ 2923, 1935, 9022, 3212, 694 ];
				topArea = [ 7011, 5346, 3121, 6345, 12231, 6572, 8432, 2120,
						8021, 2312 ];
				loadAge();
				loadSex();
				loadTopArea();
			}
		});
areaCharts.on('mouseout', function(params) {
	if (params.name == "黑龙江") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "辽宁") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "吉林") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "新疆") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "内蒙古") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "西藏") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "北京") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "天津") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "河北") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "河南") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "山东") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "山西") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "陕西") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "甘肃") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "青海") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "四川") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "重庆") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "湖北") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "湖南") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "江苏") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "浙江") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "上海") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "福建") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "广西") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "广东") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "安徽") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "云南") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "海南") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "台湾") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
	if (params.name == "江西") {
		sex = [ {
			name : "男",
			value : 3335
		}, {
			name : "女",
			value : 3335
		}, {
			name : "未知",
			value : 1234
		} ];
		ageMan = [ 2131, 2735, 2542, 2312, 2134 ];
		ageWomen = [ 2231, 2135, 2542, 2212, 2234 ];
		ageX = [ 1123, 1135, 1142, 1112, 1194 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadSex();
		loadTopArea();
	}
});
sexCharts.on('mouseover',
		function(params) {
			loadArea();
			// 控制台打印数据的名称
			// alert(params.name);
			if (params.name == "男") {
				ageMan = [ 131, 735, 542, 312, 134 ];
				ageWomen = [];
				ageX = [];
				topArea = [ 1311, 2346, 3121, 4345, 5231, 6572, 7432, 8120,
						9021, 10312 ];
				loadAge();
				loadTopArea();
			}
			if (params.name == "女") {
				ageMan = [];
				ageWomen = [ 231, 135, 542, 212, 234 ];
				ageX = [];
				topArea = [ 311, 1346, 2121, 3345, 4231, 5572, 6432, 7120,
						8021, 9312 ];
				loadAge();
				loadTopArea();
			}
			if (params.name == "未知") {
				ageMan = [];
				ageWomen = [];
				ageX = [ 123, 135, 142, 112, 94 ];
				topArea = [ 31, 346, 1121, 2345, 3231, 4572, 5432, 6120, 7021,
						8312 ];
				loadAge();
				loadTopArea();
			}
		});
ageCharts.on('mouseover',
		function(params) {
			loadArea();
			if (params.name == "<20") {
				topArea = [ 1311, 2346, 3121, 4345, 5231, 6572, 7432, 8120,
						9021, 10312 ];
				sex = [ {
					name : "男",
					value : 1335
				}, {
					name : "女",
					value : 835
				}, {
					name : "未知",
					value : 134
				} ];
				loadSex();
				loadTopArea();
			}
			if (params.name == "20-35") {
				topArea = [ 311, 1346, 2121, 3345, 4231, 5572, 6432, 7120,
						8021, 9312 ];
				sex = [ {
					name : "男",
					value : 1835
				}, {
					name : "女",
					value : 935
				}, {
					name : "未知",
					value : 94
				} ];
				loadSex();
				loadTopArea();
			}
			if (params.name == "35-45") {
				topArea = [ 31, 346, 1121, 2345, 3231, 4572, 5432, 6120, 7021,
						8312 ];
				sex = [ {
					name : "男",
					value : 1835
				}, {
					name : "女",
					value : 1235
				}, {
					name : "未知",
					value : 74
				} ];
				loadSex();
				loadTopArea();
			}
			if (params.name == "45-60") {
				topArea = [ 31, 346, 1121, 2345, 3231, 4572, 5432, 6120, 7021,
						8312 ];
				sex = [ {
					name : "男",
					value : 935
				}, {
					name : "女",
					value : 635
				}, {
					name : "未知",
					value : 54
				} ];
				loadSex();
				loadTopArea();
			}
			if (params.name == "60<") {
				topArea = [ 31, 346, 1121, 2345, 3231, 4572, 5432, 6120, 7021,
						8312 ];
				sex = [ {
					name : "男",
					value : 635
				}, {
					name : "女",
					value : 295
				}, {
					name : "未知",
					value : 34
				} ];
				loadSex();
				loadTopArea();
			}
		});

ageCharts.on('mouseout', function(params) {
	loadArea();
	if (params.name == "<20" || params.name == "20-35"
			|| params.name == "35-45" || params.name == "45-60"
			|| params.name == "60<") {
		// echarts.dispose(sexCharts);
		// sexCharts = echarts.init(groupSex);
		// echarts.dispose(topAreaCharts);
		// topAreaCharts = echarts.init(groupTopArea);
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 2335
		}, {
			name : "未知",
			value : 234
		} ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadSex();
		loadTopArea();
	}
});

sexCharts.on('mouseout', function(params) {
	loadArea();
	if (params.name == "男" || params.name == "女" || params.name == "未知") {
		// echarts.dispose(ageCharts);
		// ageCharts = echarts.init(groupAge);
		// echarts.dispose(topAreaCharts);
		// topAreaCharts = echarts.init(groupTopArea);
		// 控制台打印数据的名称
		ageMan = [ 131, 735, 542, 312, 134 ];
		ageWomen = [ 231, 135, 542, 212, 234 ];
		ageX = [ 123, 135, 142, 112, 94 ];
		topArea = [ 2311, 3346, 4121, 5345, 6231, 7572, 8432, 9120, 10021,
				12312 ];
		loadAge();
		loadTopArea();
	}
});

topAreaCharts.on('mouseover', function(params) {
	loadArea();
	if (params.name == "吉林") {
		ageMan = [ 1131, 735, 1542, 1312, 134 ];
		ageWomen = [ 1231, 1135, 542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "黑龙江") {
		ageMan = [ 2131, 735, 1542, 1312, 134 ];
		ageWomen = [ 2231, 1135, 542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "四川") {
		ageMan = [ 1131, 1735, 1542, 1312, 134 ];
		ageWomen = [ 1231, 2135, 542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "北京") {
		ageMan = [ 1131, 2735, 1542, 1312, 134 ];
		ageWomen = [ 1231, 3135, 542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "上海") {
		ageMan = [ 1131, 2735, 1542, 1312, 134 ];
		ageWomen = [ 1231, 1135, 1542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "天津") {
		ageMan = [ 1131, 1735, 1542, 1312, 134 ];
		ageWomen = [ 1231, 1135, 1542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "广州") {
		ageMan = [ 1131, 735, 1542, 1312, 1134 ];
		ageWomen = [ 1231, 1135, 1542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 1234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "深圳") {
		ageMan = [ 1131, 1735, 1542, 1312, 1134 ];
		ageWomen = [ 1231, 1135, 1542, 1212, 1234 ];
		ageX = [ 1123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2335
		}, {
			name : "女",
			value : 1035
		}, {
			name : "未知",
			value : 234
		} ];
		loadAge();
		loadSex();
	}
	if (params.name == "河北") {
		ageMan = [ 1131, 735, 1542, 1312, 1134 ];
		ageWomen = [ 1231, 1135, 1542, 212, 1234 ];
		ageX = [ 123, 1135, 1142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2035
		}, {
			name : "女",
			value : 1235
		}, {
			name : "未知",
			value : 1234
		} ];
		loadAge();
		loadSex();
	}
});

topAreaCharts.on('mouseout', function(params) {
	loadArea();
	if (params.name == "吉林" || params.name == "黑龙江" || params.name == "四川"
			|| params.name == "北京" || params.name == "上海"
			|| params.name == "天津" || params.name == "广州"
			|| params.name == "深圳" || params.name == "河北") {
		// 控制台打印数据的名称
		ageMan = [ 1131, 735, 542, 312, 134 ];
		ageWomen = [ 231, 2135, 542, 212, 234 ];
		ageX = [ 123, 135, 3142, 112, 94 ];
		sex = [ {
			name : "男",
			value : 2135
		}, {
			name : "女",
			value : 2035
		}, {
			name : "未知",
			value : 1234
		} ];
		loadAge();
		loadSex();
	}

});

// 加载性别分布echarts
function loadSex() {
	var optionSex = {
		color : [ '#5CADE5', '#FF8393', '#B1B8C8' ],
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [ {
			name : '性别分布',
			type : 'pie',
			radius : '70%',
			center : [ '50%', '60%' ],
			data : sex,
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]

	};
	sexCharts.setOption(optionSex);
}

// 加载年龄分布echarts
function loadAge() {
	var optionAge = {
		toolbox : {
			feature : {
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
			}
		},
		grid : {
			left : '3%',
			right : '10%',
			bottom : '5%',
			containLabel : true,
			y : 20
		},
		tooltip : {},
		xAxis : {
			type : 'category',
			data : [ '<20', '20-35', '35-45', '45-60', '60<' ],
			axisLabel : {
				textStyle : {
					color : '#999'
				}
			}
		},
		yAxis : {
			type : 'value',
			axisLabel : {
				textStyle : {
					color : '#999'
				}
			}

		},
		color : [ '#5CADE5', '#FF8393', '#B1B8C8' ],
		series : [ {
			name : '男性',
			type : 'bar',
			barWidth : '30%',
			stack : '总量',
			data : ageMan
		}, {
			name : '女性',
			type : 'bar',
			barWidth : '30%',
			stack : '总量',
			data : ageWomen
		}, {
			name : '未知X',
			barWidth : '30%',
			type : 'bar',
			stack : '总量',
			data : ageX
		} ]
	};
	ageCharts.setOption(optionAge);
}

// 加载地区echarts
function loadArea() {
	// 基于准备好的dom，初始化echarts实例
	function randomValue() {
		return Math.round(Math.random() * 1000);
	}
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
			data : [ {
				name : '北京',
				value : randomValue()
			}, {
				name : '天津',
				value : randomValue()
			}, {
				name : '上海',
				value : randomValue()
			}, {
				name : '重庆',
				value : randomValue()
			}, {
				name : '河北',
				value : randomValue()
			}, {
				name : '河南',
				value : randomValue()
			}, {
				name : '云南',
				value : randomValue()
			}, {
				name : '辽宁',
				value : randomValue()
			}, {
				name : '黑龙江',
				value : randomValue()
			}, {
				name : '湖南',
				value : randomValue()
			}, {
				name : '安徽',
				value : randomValue()
			}, {
				name : '山东',
				value : randomValue()
			}, {
				name : '新疆',
				value : randomValue()
			}, {
				name : '江苏',
				value : randomValue()
			}, {
				name : '浙江',
				value : randomValue()
			}, {
				name : '江西',
				value : randomValue()
			}, {
				name : '湖北',
				value : randomValue()
			}, {
				name : '广西',
				value : randomValue()
			}, {
				name : '甘肃',
				value : randomValue()
			}, {
				name : '山西',
				value : randomValue()
			}, {
				name : '内蒙古',
				value : randomValue()
			}, {
				name : '陕西',
				value : randomValue()
			}, {
				name : '吉林',
				value : randomValue()
			}, {
				name : '福建',
				value : randomValue()
			}, {
				name : '贵州',
				value : randomValue()
			}, {
				name : '广东',
				value : randomValue()
			}, {
				name : '青海',
				value : randomValue()
			}, {
				name : '西藏',
				value : randomValue()
			}, {
				name : '四川',
				value : randomValue()
			}, {
				name : '宁夏',
				value : randomValue()
			}, {
				name : '海南',
				value : randomValue()
			}, {
				name : '台湾',
				value : randomValue()
			}, {
				name : '香港',
				value : randomValue()
			}, {
				name : '澳门',
				value : randomValue()
			} ]
		} ]
	};
	areaCharts.setOption(optionMap);
}

// 加载top地区echarts
function loadTopArea() {
	var optionTopArea = {
		tooltip : {},
		grid : {
			left : '1%',
			right : '5%',
			bottom : '3%',
			containLabel : true,
			y : 20,
		},
		color : [ '#529A84' ],
		xAxis : [ {
			type : 'value',
			show : false,
			boundaryGap : [ 0, 0.01 ]
		} ],
		yAxis : [ {
			type : 'category',
			axisLine : {
				show : false
			},
			axisTick : {
				show : false
			},
			data : [ '吉林', '黑龙江', '广西', '四川', '北京', '上海', '天津', '广州', '深圳',
					'河北' ],
			axisLabel : {
				show : true,
				textStyle : {
					color : '#aaa',
				}
			}
		} ],
		series : [ {
			name : '人数',
			type : 'bar',
			barWidth : '30%',
			data : topArea,
			itemStyle : {
				normal : {
					label : {
						show : true,
						position : 'right'
					}
				}
			},
		} ]
	};
	topAreaCharts.setOption(optionTopArea);
}
// 移动行为偏好
function loadMoblie() {
	var test = [ "科技手机20%", '老人机20%', '商务手机20%', '平板电脑20%', '快充手机20%' ];
	var canvas = d3.select("canvas"), context = canvas.node().getContext("2d"), width = canvas
			.property("width"), height = canvas.property("height"), radius = 32;
	var xz = [];
	var yz = [];
	// 画圆
	var circles = d3.range(test.length).map(function(i) {
		xz.push(Math.round(Math.random() * (width - radius * 2) + radius));
		yz.push(Math.round(Math.random() * (height - radius * 2) + radius));
		return {
			index : i,
			x : xz[i],
			y : yz[i],
		};
	});

	var color = d3.scaleOrdinal().range(d3.schemeCategory20);

	render();

	canvas.call(d3.drag().subject(dragsubject).on("start", dragstarted).on(
			"drag", dragged).on("end", dragended).on(
			"start.render drag.render end.render", render));
	// 将每个圆中填入颜色和内容
	function render() {
		context.clearRect(0, 0, width, height);
		for (var i = 0, n = circles.length, circle; i < n; ++i) {
			circle = circles[i];
			context.beginPath();
			context.moveTo(circle.x + radius, circle.y);
			context.arc(circle.x, circle.y, radius, 0, 2 * Math.PI);
			// 设置文字大小
			context.font = '16px Adobe Ming Std';
			// 设置文字对其方式
			context.textAlign = 'center';
			context.fillStyle = color(circle.index);
			// 圆上显示数据
			context.fillText(test[i], xz[i], yz[i]);
			// 重叠部分透明
			context.globalCompositeOperation = "xor";
			context.fill();
			if (circle.active) {
				context.lineWidth = 2;
				context.stroke();
			}
		}
	}

	function dragsubject() {
		for (var i = circles.length - 1, circle, x, y; i >= 0; --i) {
			circle = circles[i];
			x = circle.x - d3.event.x;
			y = circle.y - d3.event.y;
			if (x * x + y * y < radius * radius)
				return circle;
		}
	}

	function dragstarted() {
		circles.splice(circles.indexOf(d3.event.subject), 1);
		circles.push(d3.event.subject);
		d3.event.subject.active = true;
	}

	function dragged() {
		d3.event.subject.x = d3.event.x;
		d3.event.subject.y = d3.event.y;
	}

	function dragended() {
		d3.event.subject.active = false;
	}
}