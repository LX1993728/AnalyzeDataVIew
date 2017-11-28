//模块统计，下拉框
$("#moduleName").click(function(e){
	e.stopPropagation();	
	$(".channel_menu").fadeIn();
	$(".model_analysis_down").fadeOut();
    $("#btn_group_time_id").fadeOut();
    $(".table_icon_down1").fadeOut();
    $(".table_icon_down").fadeOut();
    $("#dropdown_menu").fadeOut();
    $(".event_analysis_down").fadeOut();
})
$(document).click(function() {
    $('.channel_menu').fadeOut();
});

//渠道分析，下拉框
$("#channel_downMenu").click(function(e){
	e.stopPropagation();	
	$(".channel_menu").fadeIn();
	$(".model_analysis_down").fadeOut();
    $("#btn_group_time_id").fadeOut();
    $(".table_icon_down1").fadeOut();
    $(".table_icon_down").fadeOut();
    $("#dropdown_menu").fadeOut();
    $(".event_analysis_down").fadeOut();
})
$(document).click(function() {
    $('.channel_menu').fadeOut();
});

//模块分析，事件分析下拉框
$("#model_analysisBtn").click(function(e){
	e.stopPropagation();
	$(".model_analysis_down").fadeIn();
    $("#btn_group_time_id").fadeOut();
    $(".table_icon_down1").fadeOut();
    $(".table_icon_down").fadeOut();
    $("#dropdown_menu").fadeOut();
    $(".event_analysis_down").fadeOut();
    $(".channel_menu").fadeOut();
})
$(document).click(function() {
    $('.model_analysis_down').fadeOut();
});
//事件分析，注册下拉框
$("#eventSelect").click(function(e){
	e.stopPropagation();
	$(".event_analysis_down").fadeIn();
	$(".model_analysis_down").fadeOut();
    $("#btn_group_time_id").fadeOut();
    $(".table_icon_down1").fadeOut();
    $(".table_icon_down").fadeOut();
    $("#dropdown_menu").fadeOut();
    $(".channel_menu").fadeOut();
})
$(document).click(function() {
    $('.event_analysis_down').fadeOut();
});

//版本点击空白处或者自身隐藏弹出层  
$("#table_iconX").click(function(e) {
    e.stopPropagation();
    $(".table_icon_down").fadeIn();
    $("#btn_group_time_id").fadeOut();
    $('.btn_right_menu').fadeOut();
    $(".table_icon_down1").fadeOut();
    $("#dropdown_menu").fadeOut();
    $(".model_analysis_down").fadeOut();
    $(".event_analysis_down").fadeOut();
    $(".channel_menu").fadeOut();
})
$(document).click(function() {
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
    $(".model_analysis_down").fadeOut();
    $(".event_analysis_down").fadeOut();
    $(".channel_menu").fadeOut();
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
    $(".model_analysis_down").fadeOut();
    $(".event_analysis_down").fadeOut();
    $(".channel_menu").fadeOut();
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
    $(".channel_menu").fadeOut();
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
    $(".model_analysis_down").fadeOut();
    $(".event_analysis_down").fadeOut();
    $(".channel_menu").fadeOut();
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


$("#list_group>ul>li").click(function() {
    $(this).addClass("list_group_bg");
    $(this).siblings().removeClass("list_group_bg");
})

$("#new_users span").click(function() {
    $(this).removeClass("right_data_title_glay");
    $(this).siblings().addClass("right_data_title_glay");
    var index = $(this).index();
    $("#content_fade .newadd_content").eq(index).fadeIn();
    $("#content_fade .newadd_content").eq(index).removeClass("hide");
    $("#content_fade .newadd_content").eq(index).siblings().addClass("hide");
    $(".channel_analysis_title").eq(index).fadeIn();
    $(".channel_analysis_title").eq(index).removeClass("hide");
    $(".channel_analysis_title").eq(index).siblings().addClass("hide");
})

$("#channel_users span").click(function() {
    $(this).removeClass("right_data_title_glay");
    $(this).siblings().addClass("right_data_title_glay");
    var index = $(this).index();
    $("#channel_users_table .data_table1").eq(index).fadeIn();
    $("#channel_users_table .data_table1").eq(index).removeClass("hide");
    $("#channel_users_table .data_table1").eq(index).siblings().addClass("hide");
})

$(".list_item").click(function() {
    $(this).css("color", "#fff");
    $(this).siblings().css("color", "#b1b8c7");
})

$("#list_group .list-group-item").click(function() {
    $(this).next().slideToggle();
})

/*事件分析*/
$(".user_event").click(function(){
    $(this).children().addClass("color_white");
    $(this).siblings().children().removeClass("color_white");

})

//添加选中效果
$(".btn-default").click(function(){
	$(this).addClass("index_btnChecked");
	$(this).parent().siblings().children().removeClass("index_btnChecked");
})

$("#nUser").click(function(){
	$(".channelAnalysis_title .channel_analysis_title").eq(0).fadeIn();
    $(".channelAnalysis_title .channel_analysis_title").eq(0).removeClass("hide");
    $(".channelAnalysis_title .channel_analysis_title").eq(0).siblings().addClass("hide");
})

$("#actUser").click(function(){
	$(".channelAnalysis_title .channel_analysis_title").eq(1).fadeIn();
    $(".channelAnalysis_title .channel_analysis_title").eq(1).removeClass("hide");
    $(".channelAnalysis_title .channel_analysis_title").eq(1).siblings().addClass("hide");
})

$("#avgUser").click(function(){
	$(".channelAnalysis_title .channel_analysis_title").eq(2).fadeIn();
    $(".channelAnalysis_title .channel_analysis_title").eq(2).removeClass("hide");
    $(".channelAnalysis_title .channel_analysis_title").eq(2).siblings().addClass("hide");
})

$(".Question_markSign").mouseenter(function(){
	$(".QuestionPopup").fadeIn();
})

$(".Question_markSign").mouseleave(function(){
	$(".QuestionPopup").fadeOut();
})
