var platForm;
//获取首页appKey
var appInforAppKey= $("#get_appKey").attr("rel");
 
//获取当前日期
var myDate = new Date();
var nowY = myDate.getFullYear();
var nowM = myDate.getMonth()+1;
var nowD = myDate.getDate();
//获取项目名
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
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
		 loadDataMoudle();
}) ;
$("#today").click(function(){
	startDate = today;
 	endDate =  today;
	date = today;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadDataMoudle();
});
$("#yesterday").click(function(){
	startDate = loadDate(1);
 	endDate =  startDate;
	date = startDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadDataMoudle();
});
$("#week").click(function(){
	startDate = loadDate(7);
 	endDate =  today;
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadDataMoudle();
});
$("#month").click(function(){
	startDate = loadDate(30);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadDataMoudle();
});
$("#year").click(function(){
	startDate = loadDate(365);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadDataMoudle();
});
//时间控件日期编写值
var date;
//点击时间ID
var eventId;

//地区分布容器
var tmoudleChart = document.getElementById('moudleCharts');

$(function() {
	date= startDate +"~"+endDate;
	$("#searchDate").html(date);
	$('#TopName').val("TOP10");
	loadDataMoudle();
});
function loadDataMoudle(){
	var moduleName =$('#TopName').val();  
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/moudle/moudleCharts",
		dataType : "json", // 返回数据形式为json
		data:{
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate":startDate,
			"endDate":endDate,
			"moduleName":moduleName,
			
		},
		success : function(result) {	
			if(result.res == undefined){
				loadChartData(result);
			}else{
				$("#moudleCharts").html(result.res);
				addsStyle("#moudleCharts");
			}
		}
	});
};

function Top10(){
	$('#TopName').val("TOP10");
	loadDataMoudle();
}
function Under10(){
	$('#TopName').val("UNDER10");
	loadDataMoudle();
}

$("#tipData").click(function(){
	 startDate = $("#startDate").val();
	 endDate = $("#endDate").val();
	 date=startDate+"~"+endDate;
	 $("#searchDate").html(date);
	 $("#btn_group_time_id").addClass("hidden");
	 $.ajax({
			type : "GET",
			async : true, // 同步执行
			url : dataUrl,
			dataType : "json", // 返回数据形式为json
			data:{
				"startDate":startDate,
				"endDate":endDate
			},
			success : function(result) {
				if(result.res == undefined){
					$("#moudleCharts").html("");
					loadChartData(result);
				}else{
					$("#moudleCharts").html(result.res);
				}
			}
		});
}) 
function addsStyle(id) {
	$(id).css({
		"font-size" : "18px",
		"line-height" : '262px',
		"text-align" : 'center',
		"font-family" : '微软雅黑',
	});
}

function loadChartData(result){
	echarts.dispose(tmoudleChart);
	var moudleChart = echarts.init(tmoudleChart);
	var optionMoudle = {
	    color: ['#5EE3A4'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '0%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true,
			y:30
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : result.xAxis,
	            axisTick: {
	                alignWithLabel: true
	            },
	            axisLabel:{
					show:true,
					textStyle:{
						color:'#aaa',
					}
				}
	        }
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
	            type:'bar',
	            barWidth: '15%',
	            data:result.seriesData,
	        }
	    ]
	};
	moudleChart.setOption(optionMoudle);
}


 function getPlatForm(){//pla_Form_bt pro_Form_bt
	platForm="";
	$("#app-form-group").addClass("hidden")
	var appInput=$("#app-form-group input");
//	console.log(appInput)
	for(var i=0;i<appInput.length;i++){
		if(appInput[i].checked && appInput[i].value!=null ){
			platForm=appInput[i].value+"+"+platForm;
		}
	};

	loadDataMoudle();
	
	$.ajax({
		type : "POST",
		async : true, // 同步执行
		url : path + projectName + "/rest/moudle/datamodule",
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

