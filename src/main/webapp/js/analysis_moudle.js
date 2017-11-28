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
	loadModelData();
}) ;
$("#today").click(function(){
	startDate = today;
 	endDate =  today;
	date = today;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadModelData();
});
$("#yesterday").click(function(){
	startDate = loadDate(1);
 	endDate =  startDate;
	date = startDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadModelData();
});
$("#week").click(function(){
	startDate = loadDate(7);
 	endDate =  today;
	date = startDate + "~" + endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadModelData();
});
$("#month").click(function(){
	startDate = loadDate(30);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadModelData();
});
$("#year").click(function(){
	startDate = loadDate(365);
 	endDate =  today;
	date = startDate + "~" +endDate;
	$("#searchDate").html(date);
	$("#btn_group_time_id").addClass("hidden");
	loadModelData();
});
//时间控件日期编写值
var date;

$(function(){
	date= startDate +"~"+endDate;
	$("#searchDate").html(date);
	loadModelData();
})
var modelType;
function loadModel(id){
	modelType = $(this).attr("rel")
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
	loadModelData();
	$.ajax({
		type : "POST",
		async : true, // 同步执行
		url : path + projectName + "/rest/modelsanalysis/modelindex",
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
//加载地图年龄分布
var datas=[];
var name=null;
var val=null;
function loadModelData(){
	var moudleName = $("#moudleName").html();
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/modelsanalysis/querybyparams",
		dataType : "json", 
		data:{
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate":startDate,
			"endDate":endDate,
			"type":modelType,
			"moudleName":moudleName
		},
		success : function(result) {
			if(result.boy!=null && result.girl!=null){
				$("#model_boy").html(result.boy);
				$("#model_girl").html(result.girl);
			}
			loadModelDataAge(result);//年龄分布加载
			for(var key in result){
				name=key;
				val=result[key];
				var area={name:name,value:val};
				if(area.name!="null" && area.val!="null"){
					datas.push(area);
				}
			};
			loadModelArea(datas);//地图加载
		}
	})
}
var modelAge = document.getElementById("model_age");
var modelArea = document.getElementById("model_area");
function loadModelDataAge(result){
	echarts.dispose(modelAge);
	var modelAgeCharts = echarts.init(modelAge);
	var modelAgeOption = {

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
//	            name:result.xAxis[0],
	            name:"男士",
	            type:'bar',
	            stack: '广告',
	            data: result.boyAge,
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
//	            name:rel.xAxis[1],
	        	name:"女士",
	            type:'bar',
	            stack: '广告',
	            data:result.girlAge,
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
	}
	modelAgeCharts.setOption(modelAgeOption);
	
}
function loadModelArea(result){
	echarts.dispose(modelArea);
	var modelAreaCharts = echarts.init(modelArea);
	var modelAreaOption = {
		    tooltip: {},
		    visualMap: {
		        min: 0,
		        max: 1500,
		        left: 'left',
		        top: 'bottom',
		        text: ['1500','0'],
		        seriesIndex: [1],
		        inRange: {
		            color: ['#e0ffff', '#006edd']
		        },
				itemWidth:'10px',
		        itemHeight:'50px',
				textStyle:{color:"#aaa"},
		    },
		    geo: {
		        map: 'china',
		        roam: false,
		        itemStyle: {
		            normal:{
		                borderColor: 'rgba(0, 0, 0, 0.2)'
		            },
		            emphasis:{
		                areaColor: null,
		                shadowOffsetX: 0,
		                shadowOffsetY: 0,
		                shadowBlur: 20,
		                borderWidth: 0,
		                shadowColor: 'rgba(0, 0, 0, 0.5)'
		            }
		        }
		    },
		    series : [
		       {
		           type: 'scatter',
		           coordinateSystem: 'geo',
		           symbolSize: 20,
		           symbolRotate: 35,
		           label: {
		               normal: {
		                   formatter: '{b}',
		                   position: 'right',
		                   show: false
		               },
		               emphasis: {
		                   show: true
		               }
		           },
		           itemStyle: {
		               normal: {
		                    color: '#F06C00'
		               }
		           }
		        },
		        {
		            name: '用户量',
		            type: 'map',
		            geoIndex: 0,
		            data:result
		        }
		    ]
	}
	modelAreaCharts.setOption(modelAreaOption);
}