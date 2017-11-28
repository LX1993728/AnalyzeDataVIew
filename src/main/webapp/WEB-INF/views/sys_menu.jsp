<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
<title>移动行为分析-菜单管理</title>

<style type="text/css">
.fc {
	color: white;
}
</style>
<script type="text/javascript">
	function deleteMenu(id, name) {
		if (confirm('您确定要删除菜单' + name)) {
			$.ajax({
				url : "<%=basePath%>/rest/sysmenu/deletemenu?id=" + id,
				type : "get",
				success : function(data) {
					result = eval(data);
					alert(result.message);
					window.location.href = "<%=basePath%>/rest/sysmenu/list";
				}
			});
		}
	}
</script>
</head>

<body>
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="304" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<div class="profiling_contanter_bottom1">
				<div class="right_data_title fl">系统菜单表</div>
				<div class="clear"></div>
				<!-- 查询 -->
				<div class="row user_row">
					<div class="col-md-8">
						<form class="form-inline user_form" action="<%=basePath%>/rest/sysmenu/list">
							<div class="form-group">
								<label for="name" class="fc">菜单名</label> <input type="text"
									class="form-control user_select" name="name" placeholder="输入菜单名"
									value="${m.name}">
							</div>
							<div class="form-group user_role">
								<label for="pmenus" class="fc">所属菜单</label> <select
									class="form-control user_select" id="pmenus" name="pid" value="${m.pid }">
									<option value="-1">---请选择所属菜单---</option>
									<c:forEach var="pmenu" items="${pmenus }">
										<c:if test="${m.pid eq pmenu.id}">
											<option value="${pmenu.id }" selected>${pmenu.name }</option>
										</c:if>
										<c:if test="${m.pid ne pmenu.id}">
											<option value="${pmenu.id }">${pmenu.name }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<button type="submit" class="btn btn-default user_search_btn"
								onclick="javascript:document.forms[0].submit()"
								aria-label="Left Align">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
							</button>
						</form>
					</div>
					<div class="col-md-3">
						<button type="button" class="btn btn-default menu_add_btn"
							aria-label="Left Align"
							onclick="javascript:window.location.href='<%=basePath%>/rest/sysmenu/add'">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							添加菜单
						</button>
					</div>
				</div>
				<!-- 列表显示 -->
				<table class="data_table1 fl">
					<thead>
						<tr>
							<td>菜单名</td>
							<td>菜单级别</td>
							<td>所属菜单</td>
							<td>URL</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty page.items}">
							<tr>
								<td colspan="5">暂时没有任何数据</td>
							</tr>
						</c:if>
						<c:forEach items="${page.items}" var="m">
							<tr>
								<td>${m.name}</td>
								<td>${m.level }</td>
								<td>${m.pname }</td>
								<td>${m.url }</td>
								<td>
									<button type="button" class="btn btn-info btn_update"
										onclick="javascript:window.location.href='<%=basePath%>/rest/sysmenu/update?id=${m.id}'">修改</button>
									<button type="button" class="btn btn-danger btn_delete"
										onclick="deleteMenu('${m.id}','${m.name }')">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination pull-right paginationRight" id="page"></ul>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
	<!-- bootstrap -->
	<script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
	<!-- js  -->
	<script src="<%=basePath%>/js/index.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
		type="text/javascript"></script>
	<script>
    $(function () {
    	$("#table_iconX").click(function(){
    		$("#app-form-group").removeClass("hidden")
    	});
    	
    	$("#page").twbsPagination({
    		totalPages:${page.totalPages},
            visiblePages:10,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?p={{number}}&name=${m.name}&pid=${m.pid}'
        });
    });
    </script>
</body>

</html>