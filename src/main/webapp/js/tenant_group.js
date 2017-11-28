$(".tenantGroup_checkBox").click(function(){
	$(this).toggleClass("tenantGroup_checkBox_add");
})

$("#tenantStyleDown").click(function(){
	event.stopPropagation();
	$(".tenant_group_select").fadeToggle();
})
$(document).click(function(event) {
    $('.tenant_group_select').fadeOut();
});

$(".tenantData_btn").click(function(){
	$(this).css("background","#444c63");
	$(this).siblings().css("background","transparent");
})


//新建分群

$(".form_right_checkBox").click(function(){
	$(this).toggleClass("form_right_checkBox_add");
})

$("#styleDown").click(function(){
	event.stopPropagation();
	$(".systemMenu_selectTop1").fadeToggle();
	$('.systemMenu_selectTop').fadeOut();
	$('.systemMenu_selectTop2').fadeOut();
})
$(document).click(function(event) {
    $('.systemMenu_selectTop1').fadeOut();
});

$("#styleDown1").click(function(){
	event.stopPropagation();
	$(".systemMenu_selectTop").fadeToggle();
	$('.systemMenu_selectTop1').fadeOut();
	$('.systemMenu_selectTop2').fadeOut();
})
$(document).click(function(event) {
    $('.systemMenu_selectTop').fadeOut();
});

$("#styleDown2").click(function(){
	event.stopPropagation();
	$(".systemMenu_selectTop2").fadeToggle();
	$('.systemMenu_selectTop1').fadeOut();
	$('.systemMenu_selectTop').fadeOut();
})
$(document).click(function(event) {
    $('.systemMenu_selectTop2').fadeOut();
});