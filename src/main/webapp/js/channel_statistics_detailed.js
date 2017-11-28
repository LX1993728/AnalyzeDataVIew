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

var series=[];
//var channelName= $.trim($("#channelName").html()); //子页面用到
$(function(){
	loadDataPro();
//	getChannelData();
	date= startDate +"~"+endDate;
	$("#nUserDetail").click();
	$("#searchDate").html(date);
});


function showEcharts(tableId,pageId){
		$("#usert").addClass("hide")
		$("#lct").addClass("hide")
		$("#"+tableId).removeClass("hide")
		$("#"+pageId).removeClass("hide")
	}
function loadDataPro(){
	$("#nUserDetail").click(function(){
		eventId = $(this).attr("id");
		var channelname = $("#qdname").html();
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : path + projectName + "/rest/channelStatistics/getChannelNewUser",
			dataType : "json", 
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
				"channelName":channelname,
			},
			success : function(result) {
				loadData(result);
			}
		});	
	});
	function loadData(result){
		echarts.dispose(document.getElementById('channel_newUser'));
		var nuCharts = echarts.init(document.getElementById('channel_newUser'));
		var optionNu = {
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
		            data : result.xAxis,
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
				            name:result.legend,
				            type:'line',
				            smooth:true,
				            data:result.seriesData,
				        }
				    ],
		};
		nuCharts.setOption(optionNu);
	}
	
	$("#actUserDetail").click(function(){
		eventId = $(this).attr("id");
		var channelname = $("#qdname").html();
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : path + projectName + "/rest/channelStatistics/getActiveUserByChanel",
			dataType : "json", 
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
				"channelName":channelname,
			},
			success : function(result) {
				loadData(result);
			},error : function(result){
				alert(result);
			}
		});		
	});
//点击人均使用时长加载eachrs
	$("#avgUserDetail").click(function(){
		eventId = $(this).attr("id");
		var channelname = $("#qdname").html();
		$.ajax({
			type : "GET",
			async : true, // 同步执行
			url : path + projectName + "/rest/channelStatistics/getAvgUserByChanel",
			dataType : "json", 
			data:{
				"appKey" : appInforAppKey,
				"platForm" : platForm,
				"startDate":startDate,
				"endDate":endDate,
				"channelName":channelname,
			},
			success : function(result) {
				loadData(result);
			},error : function(result){
				alert(result);
			}
		});	
	});
};
function getPlatForm(){
	platForm="";
	$("#app-form-group").addClass("hidden")
	var appInput=$("#app-form-group input");
	for(var i=0;i<appInput.length;i++){
		if(appInput[i].checked && appInput[i].value!=null ){
			platForm=appInput[i].value+"+"+platForm;
		}
	};
	loadDataPro();
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/channelStatistics/changePlatForm",
		scriptCharset: 'utf-8' ,
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
}


function getChannelData() { // 第三排的数据
	$('#channelData').bootstrapTable('refresh');
	$('#channelData').bootstrapTable({
		url : 'getChannelData',
		pagination : true,
		sidePagination : 'server',
		pageNumber : 1,
		pageSize : 5,
		pageList : [ 5, 10, 20 ],
		sortable : true,
		// queryParamsType : 'limit',
		dataType: "json",
		sortName : 'activeUserDay',
		sortOrder : 'desc',
		queryParams : function(params) {
			return {
//				 传给服务端的参数为：limit, offset
				limit : params.limit,
				offset : params.offset,
				sort : params.sort,
				order : params.order,
				per_page : 100,
				page : 1,
				"startDate":startDate,
				"endDate":endDate,
			}
		},
		columns : [  {
			field : 'channelName',
			title : '渠道名称',
			sortable : true
		}, {
			field : 'activeUserDay',
			title : '活跃用户',
			sortable : true
		}, {
			field : 'newUserDay',
			title : '新增用户',
			sortable : true
		}, {
			field : 'avgUserDay',
			title : '人均使用',
			sortable : true
		} ],
	});
}
