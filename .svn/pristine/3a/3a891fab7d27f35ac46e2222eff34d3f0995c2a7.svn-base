//获取项目名
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var path = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
function getAppKey(a){
			$.ajax({
				type : "POST",
				async : true, // 同步执行
				url : path + projectName + "/rest/datas/index",
				scriptCharset: 'utf-8' ,
				contentType: "application/x-www-form-urlencoded; charset=utf-8",   
				data:{
					"appKey" : $(a).attr("value"),
					"appName" : $(a).text(),
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
		
	