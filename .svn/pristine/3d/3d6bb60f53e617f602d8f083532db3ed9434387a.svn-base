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

//获取首页appKey
var appInforAppKey= $("#get_appKey").attr("rel");
var platForm= null;

$("#list_group>li").click(function(){
	$(this).addClass("list_group_bg");
	$(this).siblings().removeClass("list_group_bg");
})

 $(function(){
	nutloadData();   //加载人均使用时长
	channelloadData(); //加载渠道分布
	ageloadData();	 //加载年龄分布性别比例
	sjloadData();	 //加载漏斗图
});

//点击人均使用时长Id刷新echars
$("#nut_load").click(function(){
	$(this).removeClass("right_data_title_glay");
	$(this).siblings().addClass("right_data_title_glay");
	var index = $(this).index();
	$("#content_fade .newadd_content").eq(index).fadeIn();
	$("#content_fade .newadd_content").eq(index).removeClass("hide");
	$("#content_fade .newadd_content").eq(index).siblings().addClass("hide");
	nutloadData();
});

//一次性用户，年龄分布，性别echars  
$("#ones_user").click(function(){
	$(this).removeClass("right_data_title_glay");
	$(this).siblings().addClass("right_data_title_glay");
	var index = $(this).index();
	$("#content_fade .newadd_content").eq(index).fadeIn();
	$("#content_fade .newadd_content").eq(index).removeClass("hide");
	$("#content_fade .newadd_content").eq(index).siblings().addClass("hide");
	
	$.ajax({
		type : "GET",
		async : true, // 同步执行
		url : path + projectName + "/rest/DataAnalysis/onesUser",
		dataType : "json", 
		data:{
			"appKey" : appInforAppKey,
			"platForm" : platForm,
			"startDate":startDate,
			"endDate":endDate,
		},
		success : function(result){
			if(result.message!=null){
				alert("暂时没有数据");
			}else{
				loadDataPro(result);
			}
		}
	});	
})
 

$(".list_item").click(function(){
	$(this).css("color","#fff");
	$(this).siblings().css("color","#b1b8c7");
})

$("#list_group .list-group-item").click(function(){
	$(this).next().slideToggle();
})

//版本点击空白处或者自身隐藏弹出层  
$("#table_iconX").click(function(e) {
    e.stopPropagation();
    $(".table_icon_down").fadeIn();
    $("#btn_group_time_id").fadeOut();
    $('.btn_right_menu').fadeOut();
    $(".table_icon_down1").fadeOut();
    $("#dropdown_menu").fadeOut();
})
$(document).click(function(event) {
    $('.table_icon_down').fadeOut();

});
$('.table_icon_down').click(function(e) {
    e.stopPropagation();
});
// 版本取消按钮
$(".btn_cancel").click(function() {
    $(".table_icon_down").fadeOut();
})

//程序点击空白处或者自身隐藏弹出层  
$("#table_caption_title").click(function(e) {
    e.stopPropagation();
    $(".table_icon_down1").fadeIn();
    $(".table_icon_down").fadeOut();
    $("#btn_group_time_id").fadeOut();
    $('.btn_right_menu').fadeOut();
    $("#dropdown_menu").fadeOut();
})
$(document).click(function(event) {
    $('.table_icon_down1').fadeOut();

});
$('.table_icon_down1').click(function(e) {
    e.stopPropagation();
});
// 程序取消按钮
$(".btn_cancel1").click(function() {
    $(".table_icon_down").fadeOut();
})

//时间控件点击空白处或者自身隐藏弹出层  
$(".btn_group_id").click(function(e) {
    e.stopPropagation();
    $("#btn_group_time_id").fadeIn();
    $('.btn_right_menu').fadeOut();
    $(".table_icon_down").fadeOut();
    $(".table_icon_down1").fadeOut();
    $("#dropdown_menu").fadeOut();
})
$(document).click(function(event) {
    $('#btn_group_time_id').fadeOut();

});
$('#btn_group_time_id').click(function(e) {
    e.stopPropagation();
});

//筛选点击空白处或者自身隐藏弹出层 
$(".btn_name").click(function(e) {
    e.stopPropagation();
    $(".btn_right_menu").fadeIn();
    $('#btn_group_time_id').fadeOut();
    $(".table_icon_down").fadeOut();
    $(".table_icon_down1").fadeOut();
    $("#dropdown_menu").fadeOut();
})
$(document).click(function(event) {
    $('.btn_right_menu').fadeOut();

});
$('.btn_right_menu').click(function(e) {
    e.stopPropagation();
});

//筛选点击空白处或者自身隐藏弹出层 
$("#dropdown_toggle").click(function(e) {
    e.stopPropagation();
    $("#dropdown_menu").fadeIn();
    $(".btn_right_menu").fadeOut();
    $('#btn_group_time_id').fadeOut();
    $(".table_icon_down").fadeOut();
    $(".table_icon_down1").fadeOut();
})
$(document).click(function(event) {
    $('#dropdown_menu').fadeOut();

});
$('#dropdown_menu').click(function(e) {
    e.stopPropagation();
});

// 程序取消按钮
$("#btn_cancel1").click(function() {
    $("#btn_group_time_id").fadeOut();
})