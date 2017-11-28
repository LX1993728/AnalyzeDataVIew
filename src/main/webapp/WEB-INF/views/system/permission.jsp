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
	    
	    <link href="css/plugins/bootstrap-treeview.css" rel="stylesheet"> 
	    <script src="js/plugins/bootstrap-treeview.js"></script>
        <title>移动行为分析系统</title>        
        
        <script type="text/javascript">
       /*  $.ajaxSetup({
        	  async: false
        	  }); */
        function getTree(){ 
        	 var treeData = new Array();
        	 
        	 var level2Data = new Array();
        	$.get('./rest/menu/query',function(data){    
        	
        		for(var n in data){
        			var node = {};
        			node.text = data[n].name; 
        			node.id = data[n].id;
        			node.level = data[n].level;
        			node.pid = data[n].pid;
        			node.cls = data[n].cls;
        			//node.href=data[n].url;
        			//node.parentId = data[n].pid;
        			//node.nodeId = data[n].id;
        			
        			node.nodes = new Array();
        			
        				
        			var children = data[n].children; 
					for(var c in children){
						var cld = {};
						cld.text = children[c].name; 
						cld.id = children[c].id;
						cld.level = children[c].level;
						cld.pid = children[c].pid;
						cld.cls = children[c].cls
						node.nodes.push(cld);
						
        			}
					treeData.push(node);
        		} 
        		
        		 
        		var $checkableTree = $('#menuTree').treeview({
        			data: treeData,
        			showCheckbox: true,
        			levels: 2,
        			onNodeChecked: function(event, node) { 
        				if(node.level!=1){
        					var parent = $('#menuTree').treeview('getParent',node);        				
        					$('#menuTree').treeview('checkNode', [ parent, { silent: true } ]);
        				}
        				if(node.nodes === undefined ){
	       	        		return;
	       	        	}else if(node.nodes.length>0){
	       	        		for(var n in node.nodes){ 
	       	        			$('#menuTree').treeview('checkNode', [ node.nodes[n].nodeId, { silent: true } ]);
	       	        		}
	       	        	} 
        	        },
	       	        onNodeUnchecked: function (event, node) {
	       	        	if(node.nodes === undefined ){
	       	        		return;
	       	        	}else if(node.nodes.length>0){
	       	        		for(var n in node.nodes){
	       	        			if(node.nodes[n].state.checked){
	       	        				$('#menuTree').treeview('uncheckNode', [ node.nodes[n].nodeId, { silent: true } ]);
	       	        			}
	       	        		}
	       	        	} 
	       	        }
        		}); 
        	    
        	}); 
        }
        
        
      function getCheckedTree(permisisonId){ 
    	  var checkedMenu = '';
    	  //获得关联菜单
	   	  $.get('./rest/permission/selectPermissionMenu?permissionId='+permisisonId,function(data){   
	   		checkedMenu = data;	   		
		});
    	  
    	  var treeData = new Array();       	 
       	 var level2Data = new Array();
       	 //获得菜单树
       	$.get('./rest/menu/query',function(data){    
       		
       		
       		for(var n in data){
    			var node = {};
    			node.text = data[n].name; 
    			node.id = data[n].id;
    			node.level = data[n].level;
    			node.pid = data[n].pid;
    			node.cls = data[n].cls
    			//node.href=data[n].url;
    			//node.parentId = data[n].pid;
    			//node.nodeId = data[n].id;
    			//选中 
   				for(var c in checkedMenu){      				
       				if((data[n].id == checkedMenu[c].id)){  
       					var state = {};
       					state.checked = true; 
       					node.state = state;
       					break;
       				}       				
       			} 
    			node.nodes = new Array();
    			
    				
    			var children = data[n].children; 
				for(var cr in children){
					var cld = {};
					cld.text = children[cr].name; 
					cld.id = children[cr].id;
					cld.level = children[cr].level;
					cld.pid = children[cr].pid;
					cld.cls = children[cr].cls;
					
					//选中 
	   				for(var cm in checkedMenu){      				
	       				if((cld.id == checkedMenu[cm].id)){  
	       					var state = {};
	       					state.checked = true; 
	       					cld.state = state;
	       					break;
	       				}       				
	       			} 
					node.nodes.push(cld);
    			}
				treeData.push(node);
    		} 
         
	   	      	    		
       	
       		
       	
       		
       		var $checkableTree = $('#menuTree').treeview({
       			data: treeData,
       			showCheckbox: true,
       			levels: 2,
       			onNodeChecked: function(event, node) { 
       				if(node.level!=1){
       					var parent = $('#menuTree').treeview('getParent',node);        				
       					$('#menuTree').treeview('checkNode', [ parent, { silent: true } ]);
       				}
       				if(node.nodes === undefined ){
	       	        		return;
       	        	}else if(node.nodes.length>0){
       	        		for(var n in node.nodes){ 
       	        			$('#menuTree').treeview('checkNode', [ node.nodes[n].nodeId, { silent: true } ]);
       	        		}
       	        	} 
       	        },
	       	        onNodeUnchecked: function (event, node) {
	       	        	if(node.nodes === undefined ){
	       	        		return;
	       	        	}else if(node.nodes.length>0){
	       	        		for(var n in node.nodes){
	       	        			if(node.nodes[n].state.checked){
	       	        				$('#menuTree').treeview('uncheckNode', [ node.nodes[n].nodeId, { silent: true } ]);
	       	        			}
	       	        		}
	       	        	} 
	       	        }
       		});  
       	    
       	}); 
       }
        
        $(document).ready(function() {
        	
        	
        	
        	//新增数据
        	$('#btnAdd').click(function(){
        		$(':input','#editForm')  
	    		 .not(':button, :submit, :reset')  
	    		 .val('')  
	    		 .removeAttr('checked')  
	    		 .removeAttr('selected');
        		getTree();
      			$('#myModalLabel').html("新增权限");
        		$('#editForm').attr('action','./rest/permission/create');
        		$('#addPermissionModal').modal('show');
      			$('#editForm').data('bootstrapValidator').resetForm();
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
        			    	$.get('./rest/permission/delete?id='+selectData[0].id,function(result){
                  				 
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
        			$(':input','#editForm')  
	   	    		 .not(':button, :submit, :reset')  
	   	    		 .val('')  
	   	    		 .removeAttr('checked')  
	   	    		 .removeAttr('selected')
          			$('#myModalLabel').html("编辑权限");
        			$('#id').val(selectData[0].id);
        			$('#permissionName').val(selectData[0].permissionName);
        			$('#permissionSign').val(selectData[0].permissionSign);
        			$('#description').val(selectData[0].description);
        			$('#editForm').attr('action','./rest/permission/update');
        			getCheckedTree(selectData[0].id);
        			        			
        			
        			$('#addPermissionModal').modal('show');
          			$('#editForm').data('bootstrapValidator').resetForm();
        			 
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
                       permissionName: {
                           validators: {
                               notEmpty: {
                                   message: '权限名称不能为空'
                               },
                               stringLength: {
                                   min: 4,
                                   max: 20,
                                   message: '字符长度必须在4到20之间'
                               }
                           }
                       },
                       permissionSign: {
                           validators: {
                               notEmpty: {
                                   message: '权限标识不能为空'
                               },
                               regexp: {
                                   regexp: /^[a-zA-Z]+\:[a-zA-Z]+$/,
                                   message: '权限标识格式例如：user:create'
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
                   var checkedMenus = $('#menuTree').treeview('getChecked');
                   if(checkedMenus === null || checkedMenus== ''){                	   
                	   
                   }else{
                	   var menuIds = new Array();
                	   
                	   
                	   for(var n in checkedMenus){
                		   menuIds.push(checkedMenus[n].id);
                	   }
                	   
                	   $('#menuIds').val(menuIds.join(','));
                   }
                   
                   
                   // 表单提交
                 $.post($form.attr('action'), 
                   		$form.serialize(), 
                   		function(result) {  
	                	   $.alert({
	                   	    title: 'Alert!',
	                   	    content: result.message 
	                   		}); 
                      		if(result.success){  
                      			document.getElementById('editForm').reset();
                      			$('#id').val('');
                      			$('#queryTable').bootstrapTable('refresh');
                      			$('#addPermissionModal').modal('hide');
                      			$form .data('bootstrapValidator').resetForm();
                      		}
                   		}, 'json');
               }); 
        	});
        </script>
         
    </head>
    <body>
  <div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">权限管理</h3>
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
       data-url="rest/permission/query"
       data-pagination="true"
       data-side-pagination="server"
       data-page-size = "10"
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
        <th data-field="permissionName">权限名称</th>
        <th data-field="permissionSign">标识</th>
        <th data-field="description">描述</th>
    </tr>
    </thead>
	</table>
	
	</div>
	
	<!-- 新增权限 -->
	<div class="modal " id="addPermissionModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增权限</h4>
	      </div>
	      <div class="modal-body">
	       		<form id="editForm"  method="post" action="./rest/permission/create">
	       		<input type="hidden" id="id" name="id">
	       		 <input type="hidden" id="menuIds" name="menuIds" value="">
			  <div class="form-group">
			    <label for="permissionName">权限名称</label>
			    <input type="text" class="form-control" id="permissionName" name="permissionName" placeholder="权限名称">
			  </div>
			  <div class="form-group">
			    <label for="permissionSign">权限标识</label>
			    <input type="text" class="form-control" id="permissionSign" name="permissionSign" placeholder="例如：user:create">
			  </div>
			  <div class="form-group">
			    <label for="description">描述</label>			    
			    <input type="text" class="form-control" id="description" name="description">
			  </div> 
			  <div class="form-group">
			  	<label>菜单分配</label>
			  	<div id="menuTree"></div>
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