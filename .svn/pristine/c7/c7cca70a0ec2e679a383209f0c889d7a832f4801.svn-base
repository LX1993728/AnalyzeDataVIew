var platForm;
//获取首页appKey
var appInforAppKey= $("#get_appKey").attr("rel");
//获取项目名
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
//获取当前日期
var myDate = new Date();
var nowY = myDate.getFullYear();
var nowM = myDate.getMonth()+1;
var nowD = myDate.getDate();
//今天调用值
var today = nowY+"-"+(nowM<10 ? "0" + nowM : nowM)+"-"+(nowD<10 ? "0"+ nowD : nowD);
//进入时终止日期调用值
var endDate = nowY+"-"+(nowM<10 ? "0" + nowM : nowM)+"-"+(nowD<10 ? "0"+ nowD : nowD);
//获取几天前方法   获取多少天前请直接将天数传入
function loadDate(day){
	var nowDate = new Date(myDate - 1000 * 60 * 60 * 24 * day);//最后一个数字30可改，30天的意思
	var lw = nowDate;
	var lastY = lw.getFullYear();
	var lastM = lw.getMonth()+1;
	var lastD = lw.getDate();
	var returnDate=lastY+"-"+(lastM<10 ? "0" + lastM : lastM)+"-"+(lastD<10 ? "0"+ lastD : lastD);//三十天之前日期
	return returnDate;
}
var startDate = loadDate(30);

$(".searchDate").click(function(){
	$("#btn_group_time_id").removeClass("hidden")

});
$("#timeButton-cancel").click(function(){
	$("#btn_group_time_id").addClass("hidden")
});
$("#tipData").click(function(){
	 	startDate = $("#startDate").val();
	 	endDate = $("#endDate").val();
	 	date=startDate+"~"+endDate;
		 $("#searchDate").html(date);
		 $("#btn_group_time_id").addClass("hidden");
		 loadUserData();
}) ;
$("#today").click(function(){
	startDate = today;
 	endDate =  today;
	date = today;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	 loadUserData();
});
$("#yesterday").click(function(){
	startDate = loadDate(1);
 	endDate =  startDate;
	date = startDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	 loadUserData();
});
$("#week").click(function(){
	startDate = loadDate(7);
 	endDate =  today;
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	 loadUserData();
});
$("#month").click(function(){
	startDate = loadDate(30);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	 loadUserData();
});
$("#year").click(function(){
	startDate = loadDate(365);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	 loadUserData();
});
//时间控件日期编写值
var date;

$(function(){
	loadUserData();
	date= startDate +"~"+endDate;
	$(".queryUserAnalysis").click();
	$("#searchDate").html(date);
})

function loadUserData(){
	//用户数据
	var userChart = echarts.init(document.getElementById('user'));
	//年龄分布
	var ageChart = echarts.init(document.getElementById('age'));
	//行业
	var hyCharts = echarts.init(document.getElementById('hy'));
	
	//用户分析数据查询
	$(".queryUserAnalysis").click(function(){
		var type = $(this).attr("rel");
		//用户数据
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : path + projectName + "/rest/datasanalysis/querybyparams",
			dataType : "json", 
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
				"type":type
			},
			success : function(result) {
				loadResult(result);
				loadDataoptionAge(result);
				if(result.boy!=null && result.girl!=null){
					$("#boy").html(result.boy);
					$("#girl").html(result.girl);
				}
			}
		});	
		
		
		//行业分布
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : path + projectName + "/rest/datasanalysis/queryIndusty",
			dataType : "json", 
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
				"type":type
			},
			success : function(result) {
				if(result==null){
					$("#hy").html("Sorry ！ 暂无数据！");
					addsStyle("#hy");
				}
				loadHangYeDate(result);
			}
		});	
	});
	
	function loadResult(rel){
		//用户数据
		var optionUser = {
		 tooltip : {
		        trigger: 'axis'
		    },
			grid:{
				left: '0%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true,
				y:20
			},
			color:['#5EE3A4'],
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : rel.xAxis,
					axisLabel:{
						show:true,
						textStyle:{
							color:'#aaa',
						}
					}
		        },
		    ],
		    yAxis : [
		        {
		            type : 'value',
					axisLabel:{
						show:true,
						textStyle:{
						color:'#aaa',
						}
					}
		        }
		    ],
		    series : [
		        {
		            name:'累计用户',
		            type:'line',
		            smooth:true,
		            data:rel.seriesData
		        }
		    ]
		};
		userChart.setOption(optionUser);
	}


	//年龄分布
	
function loadDataoptionAge(rel){
	var optionAge = {
			grid: {
				left: '6%',
				right: '10%',
				bottom: '5%',
				containLabel: true,
				y:20
			},
			tooltip:{},
			xAxis: {
	        data:['<20','20-35','35-45','45-60','<60'],
	        axisLabel: {
	            inside: true,
	            textStyle: {
	                color: '#fff'
	            }
	        },
	        axisTick: {
	            show: false
	        },
	        axisLine: {
	            show: false
	        },
	        z: 10
	    },
	    yAxis: {
	        axisLine: {
	            show: false
	        },
	        axisTick: {
	            show: false
	        },
	        axisLabel: {
	            textStyle: {
	                color: '#999'
	            }
	        }
	    },
	    dataZoom: [
	        {
	            type: 'inside'
	        }
	    ],
	    series: [
	        {
	            type: 'bar',
	            itemStyle: {
	                normal: {color: 'rgba(0,0,0,0.05)'}
	            },
	            barGap:'-100%',
	            barCategoryGap:'60%',
	            animation: false
	        },
	        {
	            name:'男士',
	            type:'bar',
	            stack: '广告',
	            data: rel.mr,
	            itemStyle: {
	                normal: {
	                    color: new echarts.graphic.LinearGradient(
	                        0, 0, 0, 1,
	                        [
	                            {offset: 0, color: '#83bff6'},
	                            {offset: 0.5, color: '#188df0'},
	                            {offset: 1, color: '#188df0'}
	                        ]
	                    )
	                },
	            },
	        },
	        {
	            name:'女士',
	            type:'bar',
	            stack: '广告',
	            data:rel.ms,/*['514','1929','990','138','102'],*/
	            itemStyle: {
	                normal: {
	                    color: new echarts.graphic.LinearGradient(
	                        0, 0, 0, 1,
	                        [
	                            {offset: 0, color: '#FF44AA'},
	                            {offset: 0.5, color: '#FF8888'},
	                            {offset: 1, color: '#F15F74'}
	                        ]
	                    )
	                },
	      
	            },
	        }
	    ]
	};
	ageChart.setOption(optionAge);

}	
	
	
	//行业分析
	function loadHangYeDate(rel){
		
		optionHy = {
			    tooltip : {  
			    },
			grid: {
			        left: '1%',
			        right: '5%',
			        bottom: '3%',
			        containLabel: true,
					y:20,
			    },
				color:['#5F677D'],
			    xAxis : [
			        {
			            type : 'value',
			          show:false,
			            boundaryGap : [0, 0.01]
			        }
			    ],
			    yAxis : [
			        {
			            type : 'category',
			          axisLine: {
			            show: false
			        },axisTick: {
			            show: false
			        },
			            data :rel.xAxis,
						 axisLabel:{
							show:true,
							textStyle:{
								color:'#aaa',
							}
						}
			        }
			    ],
			    series : [
			        {
			            name:'行业分布',
			            type:'bar',
						barWidth:'30%',
			            data:rel.seriesData,
						itemStyle : { normal: {label : {show: true, position: 'right'}}},
			        }
			    ]
			};
			hyCharts.setOption(optionHy);
	}	
	
}

//平台筛选
function getPlatForm(){
	platForm="";
	$("#app-form-group").addClass("hidden")
	var appInput=$("#app-form-group input");
	for(var i=0;i<appInput.length;i++){
		if(appInput[i].checked && appInput[i].value!=null ){
			platForm=appInput[i].value+"+"+platForm;
		}
	};

	loadUserData();
	
	$.ajax({
		type : "POST",
		async : true,
		url : path + projectName + "/rest/datasanalysis/querybyparams",
		scriptCharset: 'utf-8' ,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",   
		data:{
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate":startDate,
			"endDate":endDate,
		},
		success:function(datas){
			if(datas!=null){
				location.reload();
			}
		},
		error:function(datas){
			alert(datas);
		}
	});

	
};

function addsStyle(id) {
	$(id).css({
		"font-size" : "18px",
		"line-height" : '262px',
		"text-align" : 'center',
		"font-family" : '微软雅黑',
		"color" : 'red',
	});
}
