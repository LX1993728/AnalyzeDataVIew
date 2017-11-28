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
   		<link href="css/plugins/bootstrap-table.css" rel="stylesheet">
   		
   		 <!-- jQuery -->
	    <script src="js/jquery.js"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="js/bootstrap.min.js"></script>
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
  			$('#roleIds').multiselect('rebuild');
  			$('#editForm').bootstrapValidator('resetForm', true);
        }
		$(document).ready(function() {
			
			//复选框
			$('#roleIds').multiselect();
			//异步获取全部可供选择的权限
        	$.get('./rest/user/queryAllRole',{},function(data){        		
        		var sedata =new Array(); 
        		$.each(data,function(key,value){
        			var op = {};
        			op.value = value.id;
        			op.label = value.roleName;
        			sedata.push(op);        		 
        		});
        		$('#roleIds').multiselect('dataprovider', sedata);
        	}); 
        	
        	//新增数据
        	$('#btnAdd').click(function(){
        		$('#editForm').data('bootstrapValidator') .enableFieldValidators('password',true);
        		$('#passwordDiv').show();
        		$('#myModalLabel').html("新增角色");
        		$('#editForm').attr('action','./rest/user/create');
        		$('#addUserModal').modal('show');
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
        			    	$.get('./rest/user/delete?id='+selectData[0].id,function(result){
                  				 
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
        			$('#passwordDiv').hide();
        			$('#editForm').data('bootstrapValidator') .enableFieldValidators('password',false);
        			$('#myModalLabel').html("编辑用户");
        			$('#id').val(selectData[0].id);
        			$('#username').val(selectData[0].username);
        			$('#password').val("");
        			$('#state').val(selectData[0].state);
        			//选中关联权限
        			$.get('./rest/user/queryUserRole',{userId:selectData[0].id},function(data){
        				$.each(data,function(key,value){
        					$('#roleIds').multiselect('select',value.id);       		 
                		});
                		
        			});        			
        			$('#editForm').attr('action','./rest/user/update');
        			$('#addUserModal').modal('show');
        			
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
                       username: {
                           validators: {
                               notEmpty: {
                                   message: '用户名不能为空'
                               },
                               stringLength: {
                                   min: 2,
                                   max: 20,
                                   message: '字符长度必须在2到20之间'
                               }
                           }
                       },
                       password: {
                           validators: {
                               notEmpty: {
                                   message: '密码不能为空'
                               },
                               regexp: {
                                   regexp: /^[a-zA-Z0-9]+$/,
                                   message: '密码只能是字母或数字'
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
                      			$('#addUserModal').modal('hide'); 
                      			resetForm();
                      		}
                   		}, 'json');
               }); 
        	});
		
		
		function stateShow(value){
			if(value==1){
				return '正常';
			}else if(value==0){
				return '停用';
			}else{
				return value;
			}
		}
        </script>
    </head>
    <body>
    <div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">用户管理</h3>
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
       data-url="rest/user/query"
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
    	<th data-field="stat" data-checkbox="true"></th>
        <th data-field="id" data-visible="false">ID</th>
        <th data-field="username">用户名</th>
        <th data-field="state" data-formatter="stateShow">状态</th>
        <th data-field="createTime">创建时间</th>
    </tr>
    </thead>
</table>
</div> 



<!-- 用户编辑 -->
	<div class="modal " id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增用户</h4>
	      </div>
	      <div class="modal-body">
	       		<form id="editForm"  method="post" action="./rest/role/create">
	       		<input type="hidden" id="id" name="id">
			  <div class="form-group">
			    <label for="username">用户名</label>
			    <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
			  </div>
			  <div class="form-group" id = "passwordDiv">
			    <label for="password">密码</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
			  <div class="form-group">
			    <label for="roleIds">角色</label>
			  </div>
			  <div class="form-group">
			     <select id="roleIds" name="roleIds" class="form-control multiselect" multiple="multiple" >
				</select>
			  </div>
			  
			  
			  <div class="form-group">
			    <label for="state">状态</label>    
			    <select id="state" name="state" class="form-control" >
			    	<option value="1">正常</option>
			    	<option value="0">停用</option>
			    </select>
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