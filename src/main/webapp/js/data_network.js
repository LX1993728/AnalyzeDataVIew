var platForm;
//获取首页appKey
//获取项目名
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var appInforAppKey= $("#get_appKey").attr("rel");
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
		 $('#'+eventId).click();
}) ;
$("#today").click(function(){
	startDate = today;
 	endDate =  today;
	date = today;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#'+eventId).click();
});
$("#yesterday").click(function(){
	startDate = loadDate(1);
 	endDate =  startDate;
	date = startDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#'+eventId).click();
});
$("#week").click(function(){
	startDate = loadDate(7);
 	endDate =  today;
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#'+eventId).click();
});
$("#month").click(function(){
	startDate = loadDate(30);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#'+eventId).click();
});
$("#year").click(function(){
	startDate = loadDate(365);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	$('#'+eventId).click();
});
//时间控件日期编写值
var date;
//点击时间ID
var eventId;
var nuNetUrl;
var auNetUrl;
var startNetUrl;
var dateNetUrl;
$(function(){
	loadDataNet();
	date= startDate +"~"+endDate;
	$("#net").click();
	$("#searchDate").html(date);
});

function loadDataNet(){
$("#net").click(function(){
	nuNetUrl = path + projectName + "/rest/network/netNewUser";
	auNetUrl = path + projectName + "/rest/network/netActiveUser";
	startNetUrl = path + projectName + "/rest/network/netStart";
	$("#nuNet").click();
	$("#tableNet").show();
	$("#pageNet").show();
	$("#pageCarrier").hide();
	$("#tableCarrier").hide();
});
$("#ope").click(function(){
	nuNetUrl = path + projectName + "/rest/network/operatorsNewUser";
	auNetUrl = path + projectName + "/rest/network/operatorsActiveUser";
	startNetUrl = path + projectName + "/rest/network/operatorsStart";
	$("#nuNet").click();
	$("#tableCarrier").show();
	$("#tableNet").hide();
	$("#pageNet").hide();
	$("#pageCarrier").show();
});


	$("#nuNet").click(function(){
		eventId = $(this).attr("id");
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : nuNetUrl,
			dataType : "json", // 返回数据形式为json
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
			},
			success : function(result) {			
				if(result.message == undefined){
					loadNetData(result);
				}else{
					$("#netWrok").html(result.message);
					addStyle("#netWrok");
				}
			}
		});
	});
	$("#auNet").click(function(){
		eventId = $(this).attr("id");
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : auNetUrl,
			dataType : "json", // 返回数据形式为json
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
			},
			success : function(result) {			
				if(result.message == undefined){
					loadNetData(result);
				}else{
					$("#netWrok").html(result.message);
					addStyle("#netWrok");
				}
			}
		});
	});
	$("#startNet").click(function(){
		eventId = $(this).attr("id");
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : startNetUrl,
			dataType : "json", // 返回数据形式为json
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
			},
			success : function(result) {			
				if(result.message == undefined){
					loadNetData(result);
				}else{
					$("#netWrok").html(result.message);
					addStyle("#netWrok");
				}
			}
		});
	});
	
	function loadNetData(result){
	echarts.dispose(document.getElementById("netWrok"));
	var netCharts = echarts.init(document.getElementById("netWrok"));
	 optionNet = {
	    tooltip : {
	       
	    },
			grid: {
	        left: '1%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true,
			y:20
	    },
		color:['#5EE3A4'],
	    calculable : true,
	    xAxis : [
	        {
	            type : 'value',
	            boundaryGap : [0, 0.01],
				axisLabel: {
	                            show: true,
	                            textStyle: {
	                                color: '#aaa'
	                            }
	                        }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'category',
	            data : result.yAxis,
				axisLabel: {
	                            show: true,
	                            textStyle: {
	                                color: '#aaa'
	                            }
	                        }
	        }
	    ],
	    series : [
	        {
	            name:result.legend,
	            type:'bar',
				barWidth:"30%",
	            data:result.seriesData,
	        },]
	}
	netCharts.setOption(optionNet);
	};
	
}
function addStyle(id) {
	$(id).css({
		"font-size" : "18px",
		"line-height" : '262px',
		"text-align" : 'center',
		"font-family" : '微软雅黑',
	});
}

function getPlatForm(){
	
	platForm="";
	$("#app-form-group").addClass("hidden")
	var appInput=$("#app-form-group input");
	for(var i=0;i<appInput.length;i++){
		if(appInput[i].checked && appInput[i].value!=null ){
			platForm=appInput[i].value+"+"+platForm;
		}
	};

	loadDataNet();
	
	$.ajax({
		type : "POST",
		async : true, 
		url : path + projectName + "/rest/network/datanetwork",
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


