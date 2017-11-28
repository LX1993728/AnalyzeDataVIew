//隐藏确定取消 按钮
         $(function() {
         	$("#dropdown-menu-data-bottom").hide();
         })

         $(function() {
         	//开始时间改变
         	$('#startDate').bind('input propertychange', function() {
         		var startDate = $("#startDate").val();
         		//为""时隐藏
         		if(startDate == "" || startDate == null){
         			$("#dropdown-menu-data-bottom").fadeOut();
         			$('#btn_group_time_id').height(100)
         		}
         	});
         	//结束时间改变
         	$('#endDate').bind('input propertychange', function() {
         		var endDate = $("#endDate").val();
         		//$("#btn_group_time_id").height(200);
         		//为""时隐藏
         		if(endDate == "" || endDate == null){
         			$("#dropdown-menu-data-bottom").fadeOut();
         			$('#btn_group_time_id').height(100)
         		}
         	});
         })

         //执行完时间插件后执行此方法
         function show(){
         	var startDate = $("#startDate").val();
         	var endDate = $("#endDate").val();
         	if(startDate != "" && endDate != ""){
         		$('#btn_group_time_id').height(150);
         		$("#dropdown-menu-data-bottom").fadeIn();
         	}else {
         		$('#btn_group_time_id').height(100);
         		$("#dropdown-menu-data-bottom").fadeOut();
         	}
         }
