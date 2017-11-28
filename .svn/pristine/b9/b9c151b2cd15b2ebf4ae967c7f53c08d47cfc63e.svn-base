<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="UTF-8">
        <!-- Bootstrap Core CSS -->
   		<link href="css/bootstrap.min.css" rel="stylesheet">
   		<link href="css/plugins/bootstrap-table.css" rel="stylesheet">
   		
   		 <!-- jQuery -->
	    <script src="js/jquery.js"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="js/bootstrap.min.js"></script>
	    <script src="js/plugins/bootstrap-table.js"></script>
	    <script src="js/plugins/bootstrap-table-zh-CN.min.js"></script>
	     
	    <script src="js/plugins/bootstrap-multiselect.js"></script> 
	    <link href="css/plugins/bootstrap-multiselect.css" rel="stylesheet">
        <title>移动行为分析系统</title>
        <script type="text/javascript">
		 $.ajaxSetup({async : false});
			function refulshVersion(){
			
				$.ajax({
					type : "GET",
					url : "rest/appVersion/selectAppVersion",
					async: false,
					data : {
			
						"appKey" : getAppKey()
					},
					dataType : "json",
			
					success : function(result) { 
						var re = '';
						if(result.length==0){
							re += '<option value=""></option>';
						}
						$.each(result, function() {
							re += '<option value="'+this+'">' + this + '</option>';
			
						});
						$('#version option').remove();
						$('#version').append(re);
						$('#version').multiselect('rebuild');
			
					}
				});
				
			}
 
        
        function getVersion() {
			return $("#version").val();
		}
		function getAppKey() {
			return $("#appKey").val();
		}
		function getParams(params) {
			 params.version=getVersion();
			 params.appKey=getAppKey(); 
			return params;
		}
		
		function mutiselectInit() {
			$('.multiselect').multiselect({
				
				buttonText : function(option) {
					return (option.attr('label') !== undefined) ? option
							.attr('label'): option.html();

				}
			});
		}
		$(function(){
			mutiselectInit();
			$(".multiselect#appKey").change(function(){
				refulshVersion();
			});
			$(".multiselect").change(function() {
				//下拉菜单改变 重新获取数据
				$('#queryTable').bootstrapTable('refresh'); 
	
			});
		});
		function xxFmt(value,row,index){
			return "<a href='rest/event/detail?appKey="+getAppKey()+"&event="+row.event+"'>详细</a>"
		}
        </script>
        <style type="text/css">
		.pull-right{
			margin-right:15px;
		}
		</style> 
    </head>
    <body>
    
    	<div class="row">
		<div class="col-xs-2">
			<select id="appKey" name="" class="multiselect">
				<c:forEach items="${appList }" var="app">
					<option value="${app.appKey }">${app.appName}</option>
				</c:forEach>
			</select>
		</div> 

		<div class="pull-right">
			<select class="multiselect" id="version">
				<c:forEach items="${firstAppVersion }" var="v">
					<option value="${v}">${v}</option>
				</c:forEach>
			</select>
		</div>
	</div>
    <div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">事件列表</h3>
	  </div> 
    
	<table id="queryTable"
	   data-toggle="table"
       data-url="rest/event/query"
       data-pagination="true"
       data-side-pagination="server"
       data-page-size = "30"
       data-show-refresh="true"
       data-show-toggle="true"
       data-show-columns="true"
       data-click-to-select="true"
	   data-single-select="true"
       data-query-params-type="limit"
       data-query-params="getParams">
    <thead>
    <tr>
    	<th data-field="stat" data-checkbox="true"></th>
        <th data-field="id" data-visible="false">ID</th>
        <th data-field="event">事件</th>
        <th data-field="eventName" data-visible="false">事件名称</th>
        <th data-field="startCount">昨日消息数</th>
        <th data-formatter="xxFmt">详情</th>
    </tr>
    </thead>
</table>
</div> 
    </body>
</html>