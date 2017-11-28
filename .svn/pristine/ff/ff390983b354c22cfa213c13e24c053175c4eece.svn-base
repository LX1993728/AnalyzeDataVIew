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
<title>移动行为分析-资源管理</title>

<style type="text/css">
.fc {
	color: white;
}
</style>
<script type="text/javascript">
	function deletepermission(id, name) {
		if (confirm('您确定要删除资源' + name)) {
			$.ajax({
				url : "<%=basePath%>/rest/syspermission/deletepermission?id=" + id,
				type : "get",
				success : function(data) {
					result = eval(data);
					alert(result.message);
					window.location.href = "<%=basePath%>/rest/syspermission/list";
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
			<jsp:param name="menu" value="303" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<div class="profiling_contanter_bottom1">
				<div class="right_data_title fl">系统资源表</div>
				<div class="clear"></div>
				<!-- 查询 -->
				<div class="row user_row">
					<div class="col-md-8">
						<form class="form-inline user_form"
							action="<%=basePath%>/rest/syspermission/list">
							<div class="form-group">
								<label for="name" class="fc">资源名</label> <input type="text"
									class="form-control user_select" name="name"
									placeholder="输入资源名" value="${p.name}">
							</div>
							<div class="form-group user_role">
								<label for="name" class="fc">资源编码</label> <input type="text"
									class="form-control user_select" name="code"
									placeholder="输入资源编码" value="${p.code}">
							</div>
							<button type="submit" class="btn btn-default user_search_btn"
								onclick="javascript:document.forms[0].submit()"
								aria-label="Left Align">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
							</button>
						</form>
					</div>
					<div class="col-md-3">
						<button type="button" class="btn btn-default per_add_btn"
							aria-label="Left Align"
							onclick="javascript:window.location.href='<%=basePath%>/rest/syspermission/add'">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							添加资源
						</button>
					</div>
				</div>
				<!-- 列表显示 -->
				<table class="data_table1 fl">
					<thead>
						<tr>
							<td>资源名</td>
							<td>资源编码</td>
							<td>资源描述</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty page.items}">
							<tr>
								<td colspan="4">暂时没有任何数据</td>
							</tr>
						</c:if>
						<c:forEach items="${page.items}" var="m">
							<tr>
								<td>${m.name}</td>
								<td>${m.code }</td>
								<td>${m.description }</td>
								<td>
									<button type="button" class="btn btn-info btn_update"
										onclick="javascript:window.location.href='<%=basePath%>/rest/syspermission/update?id=${m.id}'">修改</button>
									<button type="button" class="btn btn-danger btn_delete"
										onclick="deletepermission('${m.id}','${m.name }')">删除</button>
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
            href:'?p={{number}}&name=${p.name}&code=${p.code}'
        });
    });
    </script>
</body>

</html>