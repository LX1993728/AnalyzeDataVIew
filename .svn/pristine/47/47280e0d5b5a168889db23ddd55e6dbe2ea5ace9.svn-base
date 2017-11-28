/*左侧菜单栏*/
$(document).ready(function(){ 
	if($(".list-group-item").hasClass("list_group_bg")){
		$(".list_group_bg").next().css("display","block");
	}	
})

$(document).ready(function(){ 
	if($(".list_item").hasClass("list_group_bg")){
		$(".list_group_bg").parents().css("display","block");
	}	
})

/*版本下拉选中*/
$(document).ready(function(){ 
	$.each($(".table_icon_check"),function(i,item){
		var menuIcons = $(item).find("input").val();
//		console.log(menuIcons);
		$.each($("#table_iconX .menu_icon"),function(j,item2){
			var iconIds = $(item2).attr("val");
//			console.log(iconIds);
			if(menuIcons == iconIds){
				$(item).find("input").prop("checked","checked")
			}	
		})	
	})
})


