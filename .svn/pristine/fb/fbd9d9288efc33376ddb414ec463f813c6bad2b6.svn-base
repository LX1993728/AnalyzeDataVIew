<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
   		
   		 <!-- jQuery -->
	    <script src="js/jquery.js"></script>
	
	     <!-- Bootstrap Core JavaScript -->
	    <script src="js/bootstrap.min.js"></script>
	    
   		<link href="css/plugins/bootstrap-table.css" rel="stylesheet">
	    <script src="js/plugins/bootstrap-table.js"></script>
	    <script src="js/plugins/bootstrap-table-zh-CN.min.js"></script>
	    
   		<link href="css/plugins/bootstrapValidator.css" rel="stylesheet"> 
	    <script src="js/plugins/bootstrapValidator.js"></script> 
	     
	     <link href="css/plugins/jquery-confirm.min.css" rel="stylesheet"> 
	    <script src="js/plugins/jquery-confirm.min.js"></script> 
	    
	    
	     <link href="css/plugins/bootstrap-multiselect.css" rel="stylesheet"> 
	    <script src="js/plugins/bootstrap-multiselect.js"></script> 
        <title>移动行为分析系统</title>
        
        <script type="text/javascript">

        //重置form
        function resetForm(){
        	var editForm = document.getElementById('editForm');
    		editForm.reset();
  			$('#id').val('');
  			$('#editForm').bootstrapValidator('resetForm', true);
  			$('#permissionIds').multiselect('rebuild');
        }
		$(document).ready(function() {
			
			//权限复选框
			$('#permissionIds').multiselect();
			//异步获取全部可供选择的权限
        	$.get('./rest/role/queryAllPermission',{},function(data){        		
        		var sedata =new Array(); 
        		$.each(data,function(key,value){
        			var op = {};
        			op.value = value.id;
        			op.label = value.permissionName;
        			sedata.push(op);        		 
        		});
        		$('#permissionIds').multiselect('dataprovider', sedata);
        	}); 
        	
        	//新增数据
        	$('#btnAdd').click(function(){
        		
        		$('#myModalLabel').html("新增角色");
        		$('#editForm').attr('action','./rest/role/create');
        		$('#addRoleModal').modal('show');
        		resetForm();
        	});
        	
        	
        	//删除数据
        	$('#btnDelete').click(function(){
        		var selectData = $('#queryTable').bootstrapTable('getSelections');
        		if(selectData!=null && selectData.length==0){    
        			$.alert({
                	    title: 'Alert!',
                	    content: '请选择操作行',
                	    confirmButton:'确定'
                	}); 
        		}else{
        			$.confirm({
        			    title: '确认删除!',
        			    content: '确定要删除记录吗？',
        			    confirm: function(){
        			    	$.get('./rest/role/delete?id='+selectData[0].id,function(result){
                  				 
                   				$.alert({
                            	    title: 'Alert!',
                            	    content: result.message 
                            	}); 
                   				if(result.success){
                   				 $('#queryTable').bootstrapTable('refresh');
                   				}
                   			 });
        			    },
        			    cancel: function(){
        			        return;
        			    }
        			});  	
        		}
        	});
        	
        	 
        	
        	
        	//编辑数据
        	$('#btnEdit').click(function(){
        		var selectData = $('#queryTable').bootstrapTable('getSelections');
        		if(selectData!=null && selectData.length==0){        			 
        		 
        			$.alert({
                	    title: 'Alert!',
                	    content:"请选择操作行"
                	});
        		}else{
        			resetForm();
        			$('#myModalLabel').html("编辑角色");
        			$('#id').val(selectData[0].id);
        			$('#roleName').val(selectData[0].roleName);
        			$('#roleSign').val(selectData[0].roleSign);
        			$('#description').val(selectData[0].description);
        			//选中关联权限
        			$.get('./rest/role/queryRolePermission',{roleId:selectData[0].id},function(data){
        				$.each(data,function(key,value){
        					$('#permissionIds').multiselect('select',value.id);       		 
                		});
                		
        			});        			
        			$('#editForm').attr('action','./rest/role/update');
        			$('#addRoleModal').modal('show');
        		} 
        		
        	});
        
        	//form检验
       		$('#editForm').bootstrapValidator({
                   message: 'This value is not valid',
                   feedbackIcons: {
                       valid: 'glyphicon glyphicon-ok',
                       invalid: 'glyphicon glyphicon-remove',
                       validating: 'glyphicon glyphicon-refresh'
                   },
                   fields: {
                       roleName: {
                           validators: {
                               notEmpty: {
                                   message: '角色名称不能为空'
                               },
                               stringLength: {
                                   min: 2,
                                   max: 20,
                                   message: '字符长度必须在4到20之间'
                               }
                           }
                       },
                       roleSign: {
                           validators: {
                               notEmpty: {
                                   message: '角色标识不能为空'
                               },
                               regexp: {
                                   regexp: /^[a-zA-Z]+$/,
                                   message: '角色标识格式例如：create'
                               }
                           }
                       }
                   }
               }).on('success.form.bv', function(e) {
                   // Prevent form submission
                   e.preventDefault();

                   // Get the form instance
                   var $form = $(e.target);
                   

                   // Get the BootstrapValidator instance
                   var bv = $form.data('bootstrapValidator');

                   // 表单提交
                   $.post($form.attr('action'), 
                   		$form.serialize(), 
                   		function(result) {  
                	   $.alert({
                   	    title: 'Alert!',
                   	    content: result.message 
                   		}); 
                      		if(result.success){                        			 
                      			$('#queryTable').bootstrapTable('refresh');
                      			$('#addRoleModal').modal('hide'); 
                      			resetForm();
                      		}
                   		}, 'json');
               }); 
        	});
        </script>
    </head>
    <body>
     <div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">角色管理</h3>
	  </div>
    
   <div id="toolbar" class="btn-group">
	    <button type="button" class="btn btn-default" data-toggle="modal" id="btnAdd">
	        <i class="glyphicon glyphicon-plus"></i>
	    </button>
	    <button type="button" class="btn btn-default" id="btnEdit">
	        <i class="glyphicon glyphicon-pencil"></i>
	    </button>
	    <button type="button" class="btn btn-default" id="btnDelete">
	        <i class="glyphicon glyphicon-trash"></i>
	    </button>
	</div>
    
	<table id="queryTable"
	   data-toggle="table"	   
       data-url="rest/role/query"
       data-pagination="true"
       data-side-pagination="server"
       data-page-size = "5"
       data-show-refresh="true"
       data-show-toggle="true"
       data-show-columns="true"
       data-click-to-select="true"
	   data-single-select="true"
       data-toolbar="#toolbar">
    <thead>
    <tr>
    	<th data-field="state" data-checkbox="true"></th>
        <th data-field="id" data-visible="false">ID</th>
        <th data-field="roleName">角色名称</th>
        <th data-field="roleSign">角色标识</th>
        <th data-field="description">描述</th>
    </tr>
    </thead>
</table>
</div>


<!-- 新增角色 -->
	<div class="modal " id="addRoleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增角色</h4>
	      </div>
	      <div class="modal-body">
	       		<form id="editForm"  method="post" action="./rest/role/create">
	       		<input type="hidden" id="id" name="id">
			  <div class="form-group">
			    <label for="roleName">角色名称</label>
			    <input type="text" class="form-control" id="roleName" name="roleName" placeholder="角色名称">
			  </div>
			  <div class="form-group">
			    <label for="roleSign">角色标识</label>
			    <input type="text" class="form-control" id="roleSign" name="roleSign" placeholder="例如：admin">
			  </div>
			  <div class="form-group">
			    <label for="permissionIds">权限</label>
			  </div>
			  <div class="form-group">
			     <select id="permissionIds" name="permissionIds" class="form-control multiselect" multiple="multiple" >
				</select>
			  </div>
			  
			  
			  <div class="form-group">
			    <label for="description">描述</label>			    
			    <input type="text" class="form-control" id="description" name="description">
			  </div> 
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal" id="clsModalBtn">关闭</button>
	        <button type="submit" class="btn btn-primary" form="editForm">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	 
    </body>
</html>