<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 使用webkit内核 -->
<meta name="renderer" content="webkit">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="<%=basePath%>/bootstrap/css/bootstrap.min.css">
<!-- style.css -->
<link rel="stylesheet" href="<%=basePath%>/css/base.css">
<link rel="stylesheet" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" href="<%=basePath%>/css/data_analysis.css">
<link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
<link rel="stylesheet" href="<%=basePath%>/css/add_systemusers.css">

<!-- jQuery -->
<script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>

<!-- Ztree -->
<script type="text/javascript"
	src="<%=basePath%>/js/jquery.ztree.all-3.5.js"></script>
<link rel="stylesheet" href="<%=basePath%>/css/zTreeStyle.css"
	type="text/css">
<title>移动行为分析-模块统计</title>

<style type="text/css">
.fc {
	color: white;
}
</style>
<script type="text/javascript">
	function zTreeOnCheck(event, treeId, treeNode) {
		if (treeNode.isParent) {
			if (treeNode.checked) {
				appendHidden(treeNode.id);
			} else {
				removeHidden(treeNode.id);
			}
			 $.each(treeNode.children, function(index, value) {
				/* if (treeNode.checked) {
					appendHidden(value.id);
				} else {
					removeHidden(value.id);
				} */
				if (!treeNode.checked) {
					removeHidden(value.id);
				}
			}); 
		} else {
			if (treeNode.checked) {
				appendHidden(treeNode.id);
				appendHidden(treeNode.getParentNode().id);
			} else {
				removeHidden(treeNode.id);
			}
		}
	};
	function appendHidden(id) {
		var hiddenString = '<input type="hidden" name="menuIds" id="'+id+'" value="'+id+'">';
		if ($("#" + id).length <= 0) {
			$("#hiddenBox").append(hiddenString);
		}
	}
	function removeHidden(id) {
		$("#hiddenBox>input").each(function(index, element) {
			if ($(this).val() == id) {
				$(this).remove();
			}
		});
	}
	var setting = {
		check : {
			enable : true,
			chkboxType : { /* 勾选父不级联子 取消父级联子。 勾选子级联父，取消子不级联父 */
				"Y" : "p",
				"N" : "s"
			}
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		view : {
			fontCss : {
				'color' : 'white'
			},
			nameIsHTML : true
		},
		callback : {
			onCheck : zTreeOnCheck
		}
	};

	$(document).ready(function() {
		var tree;
		$.ajax({
			type : "GET",
			async : true,
			url : "<%=basePath%>/rest/sysrole/menus",
			success : function(data) {
				tree = eval(data);
				// 默认展开第一个一级菜单
				if (tree.length > 0) {
					tree[0].open=true;
				}
				/* 初始化树 */
				$.fn.zTree.init($("#menuTree"), setting, tree);
				//获取ztree对象（系统菜单树）
				var treeObj = $.fn.zTree.getZTreeObj("menuTree");
				/* 判断：如果是修改则需要获取 该角色原先绑定的所有菜单 为系统菜单进行选中*/
				/* alert("=======${perms[0].name}===="+'${r.id}'.length); */
				/* alert(eval("${r.menuIds}").length); */
				if ('${r.id}'.length > 0 && eval("${r.menuIds}").length == 0) { /*进入的是修改页面*/
					/*说明不是修改失败后的返回 即初次进入修改页面 需要加载该角色原先已绑定的菜单*/
			        $.ajax({  
			            url:"<%=basePath%>/rest/sysrole/menusOfRole?id=${r.id}",  
			            type:"get", 
			            async:false,  /* 此处必须是同步执行，否则会先执行插入隐藏字段 导致表单数据错误											 */
			            contentType:"application/json;charset=utf-8",  
			            success:function(data){  
			                var treeNode = eval(data);
			                for (var i = 0; i < treeNode.length; i++) {
                                var nodes = treeObj.getNodesByParam("id", treeNode[i].id, null);
                                //勾选当前选中的节点
                                treeObj.checkNode(nodes[0],true,true);
                            };
			            },
			            error : function(msg) {
							alert('获取角色原先绑定的菜单异常!');
						}
			        });  
				}
				/* 其它情况 无论是修改失败回到本页面还是增加失败回到该页面 都回显上次编辑的数据 */
				if (eval("${r.menuIds}").length > 0) {
					var mennuIds = eval("${r.menuIds}");
					for (var i = 0; i < mennuIds.length; i++) {
						var nodes = treeObj.getNodesByParam("id", mennuIds[i], null);
						treeObj.checkNode(nodes[0],true,true);
					}
				}
				
				/* 根据当前树所有节点的选中状态 初始化新增隐藏字段 */
				var node = treeObj.getNodes();
				var nodes = treeObj.transformToArray(node);
				$.each(nodes, function(index, value) {
					if (value.checked) {
						appendHidden(value.id);
					} else {
						removeHidden(value.id);
					}
				});
			},
			error : function(msg) {
				alert('树加载异常!');
			}
		});
	});
</script>
</head>

<body>
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="302" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">

			<div class="add_systemusers_form">

				<div class="add_systemusers_form_title fl" role="alert">
					<c:if test="${r.id eq null}">
					增加系统角色
					</c:if>
					<c:if test="${r.id ne null}">
					修改系统角色
					</c:if>
					<c:if test="${message ne null }">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span>
						<span class="sr-only">Error:</span>
						${message }
					</c:if>
				</div>
				<div class="clear"></div>
			</div>
			<form class="form-horizontal fc"
				action="${ r.id eq null? 'addrole':'updaterole'}" method="post">
				<div class="form-group">
					<input type="hidden" name="id" value="${r.id }" /> <label
						for="name" class="col-sm-2 control-label">角色名</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="name" name="name"
							value="${r.name }" placeholder="请输入新的角色名">
					</div>
				</div>
				<div class="form-group">
					<label for="code" class="col-sm-2 control-label">角色编码</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="code" value="${r.code }"
							name="code" placeholder="请输入新的角色编码">
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">角色描述</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="description" value="${r.description }"
							name="description" placeholder="请输入新的角色描述">
					</div>
				</div>
				<div class="form-group">
					<label for="roles" class="col-sm-2 control-label">分配资源</label>
					<div class="col-sm-8">
						<c:forEach var="perm" items="${perms }">
							<c:set var="flag" value="false" />
							<c:forEach items="${r.permIds}" var="permId">
								<c:if test="${perm.id  eq permId}">
									<c:set var="flag" value="true" />
								</c:if>
							</c:forEach>
							<label class="checkbox-inline"> <input type="checkbox"
								name="permIds" value="${perm.id }"
								${ flag?'checked="checked"':'' }> ${perm.name }
							</label>
						</c:forEach>
					</div>
				</div>
				<div class="form-group">
					<label for="menus" class="col-sm-2 control-label">绑定菜单</label>
					<div class="col-sm-8">
						<div>
							<ul id="menuTree" class="ztree"></ul>
						</div>
						<div id="hiddenBox" style="width: 0px; height: 0px"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary fc btn_update">确定</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-warning btn_cancel"
							aria-label="Left Align"
							onclick="javascript:window.location.href='<%=basePath%>rest/sysrole/list'">
							取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
<!-- bootstrap -->
<script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
<!-- js  -->
<script src="<%=basePath%>/js/index.js"></script>
<script src="<%=basePath%>/js/left_menu.js"></script>
<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>	 
</body>

</html>