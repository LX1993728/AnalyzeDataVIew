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
	     
	    
   		<link href="css/plugins/bootstrapValidator.css" rel="stylesheet"> 
	    <script src="js/plugins/bootstrapValidator.js"></script> 
	     
	     <link href="css/plugins/jquery-confirm.min.css" rel="stylesheet"> 
	    <script src="js/plugins/jquery-confirm.min.js"></script> 
	    
	    <link href="css/plugins/bootstrap-treeview.css" rel="stylesheet"> 
	    <script src="js/plugins/bootstrap-treeview.js"></script>
        <title>移动行为分析系统</title>        
        
        <script type="text/javascript">
        
         
        function getTree(){
        	var boot = new Array();
        	boot.push({text:'菜单',id:0,level:0});
        	var treeData = new Array();
        	  
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
        			//二级菜单
        			node.nodes = new Array();
        			var children = data[n].children;
					for(var c in children){
						var cld = {};
						cld.text = children[c].name; 
						cld.id = children[c].id;
						cld.level = children[c].level;
						cld.pid = children[c].pid;
						cld.cls = children[c].cls;
						node.nodes.push(cld);
        			}
					treeData.push(node);
        		} 
        		
        		 
        		boot[0].nodes=treeData;
        		var $checkableTree = $('#tree').treeview({
        			data: boot,
        			levels: 4,
        			onNodeSelected: function(event, node) { 
        				
       	            },
       	            onNodeUnselected: function (event, node) {
       	              
       	            }
        		}); 
        	    
        	}); 
        }
        
        
        $(document).ready(function() {
        	getTree();
        	
        	 
  	    
  	    $('#btnAdd').click(function(){
  	    	var selected = $('#tree').treeview('getSelected');
  	    	if(selected.length == 1){
  	    		if(selected[0].level==2){
  	    			$.alert({
  	            	    title: 'Alert!',
  	            	    content:"最多只能添加两级菜单"
  	            	});
  	    			return;
  	    		}
  	    		$(':input','#editForm')  
  	    		 .not(':button, :submit, :reset, :hidden')  
  	    		 .val('')  
  	    		 .removeAttr('checked')  
  	    		 .removeAttr('selected'); 
  	    		$('#pid').val(selected[0].id);
  	    		$('#pname').val(selected[0].text);
      			$('#myModalLabel').html("新增菜单");
      			$('#editForm').attr('action','./rest/menu/create');
  	    		$('#addModal').modal('show');
  	    		$('#editForm').data('bootstrapValidator').resetForm();
  	    	}else{
  	    		$.alert({
            	    title: 'Alert!',
            	    content:"请选择父菜单"
            	});
  	    	}
  	    	 
  	    });
        	
    
        			
        	
        	//删除数据
        	$('#btnDelete').click(function(){
        		var selected = $('#tree').treeview('getSelected');
      	    	if(selected.length != 1){
        			$.alert({
                	    title: 'Alert!',
                	    content: '请选择要删除的菜单',
                	    confirmButton:'确定'
                	}); 
        			return;
        		}else{
        			$.confirm({
        			    title: '确认删除!',
        			    content: '确定要删除记录吗？',
        			    confirm: function(){
        			    	$.get('./rest/menu/delete?id='+selected[0].id,function(result){
                  				 
                   				$.alert({
                            	    title: 'Alert!',
                            	    content: result.message 
                            	}); 
                   				if(result.success){
                   					getTree();
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
        		var selected = $('#tree').treeview('getSelected');
      	    	if(selected.length != 1 || selected[0].level==0){     			 
        		 
        			$.alert({
                	    title: 'Alert!',
                	    content:"请选择操作的菜单"
                	});
        		}else{
        			var parent = $('#tree').treeview('getParent',selected[0]);
        			 
        			$.get('./rest/menu/select?id='+selected[0].id,function(data){
        				$(':input','#editForm')  
         	    		 .not(':button, :submit, :reset, :hidden')  
         	    		 .val('')  
         	    		 .removeAttr('checked')  
         	    		 .removeAttr('selected');
              			$('#myModalLabel').html("编辑菜单");
            			$('#id').val(selected[0].id);
            			$('#pid').val(data.pid);
            			$('#pname').val(parent.text);
            			$('#name').val(data.name);
            			$('#url').val(data.url);
            			$('#cls').val(data.cls);
            			$('#sort').val(data.sort);
            			$('#status').val(data.status);
            			$('#editForm').attr('action','./rest/menu/update');
            			$('#addModal').modal('show');
              			$('#editForm').data('bootstrapValidator').resetForm();
        			}); 
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
                       name: {
                           validators: {
                               notEmpty: {
                                   message: '菜单名称不能为空'
                               } 
                           }
                       },
                       url: {
                           validators: {
                               notEmpty: {
                                   message: '链接地址不能为空，如果是父节点请填#'
                               }
                           }
                       },
                       sort: {
                           validators: {
                               notEmpty: {
                                   message: '排序值不能为空'
                               },
                               integer: {
                                   message: '请填入数字'
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
                      			document.getElementById('editForm').reset();
                      			$('#id').val('');
                      			$('#pid').val('');
                      			getTree();
                      			$('#addModal').modal('hide');
                      			$form.data('bootstrapValidator').resetForm();
                      		}
                   		}, 'json');
               });  
        	});
        </script>
         
    </head>
    <body>
  <div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">菜单管理</h3>
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
    
 <div id="tree"></div>
</div>
	
	
	<!-- 新增权限 -->
	<div class="modal " id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增菜单</h4>
	      </div>
	      <div class="modal-body">
	       		<form id="editForm"  method="post" action="./rest/menu/create">
	       		<input type="hidden" id="id" name="id">
	       	  <div class="form-group">
			    <label for="pname">父节点名称</label>
	       		<input type="hidden" id="pid" name="pid">
			    <input type="text" class="form-control" id="pname" name="pname" readonly="readonly" >
			  </div>
			  <div class="form-group">
			    <label for="name">菜单名称</label>
			    <input type="text" class="form-control" id="name" name="name" placeholder="菜单名称">
			  </div>
			  <div class="form-group">
			    <label for="url">链接地址</label>
			    <input type="text" class="form-control" id="url" name="url" placeholder="例如：./rest/user/query">
			  </div>
			  <div class="form-group">
			    <label for="sort">排序</label>			    
			    <input type="number" class="form-control" id="sort" name="sort">
			  </div> 
			  <div class="form-group">
			    <label for="cls">图标类</label>			    
			    <input type="text" class="form-control" id="cls" name="cls" placeholder="例如：fa fa-fw fa-bar-chart-o">
			  </div>
			  <div class="form-group">
			    <label for="status">状态</label>			    
			    <select id="status" name="status" class="form-control">
			    	<option value="1">启用</option>
			    	<option value="0">关闭</option>
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