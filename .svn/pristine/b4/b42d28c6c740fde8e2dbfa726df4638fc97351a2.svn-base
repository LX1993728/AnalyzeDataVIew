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
<title>移动行为分析-用户管理</title>

<style type="text/css">
.fc {
	color: white;
}
</style>

</head>

<body>
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="301" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<div class="profiling_contanter_bottom1">
				<div class="right_data_title fl">系统用户表</div>
				<div class="clear"></div>
				<!-- 查询 -->
				<div class="row user_row">
					<div class="col-md-8">
						<form class="form-inline user_form"
							action="<%=basePath%>/rest/sysuser/list">
							<div class="form-group">
								<label for="username" class="fc">用户名</label> <input type="text"
									class="form-control user_select" id="u" name="username"
									placeholder="输入用户名" value="${u.username}">
							</div>
							<div class="form-group user_role">
								<label for="roles" class="fc">用户角色</label> <select
									class="form-control user_select" name="roleId"
									value="${u.roleId }">
									<option value="-1">---请选择角色---</option>
									<c:forEach var="role" items="${roles }">
										<c:if test="${u.roleId eq role.id}">
											<option value="${role.id }" selected>${role.name }</option>
										</c:if>
										<c:if test="${u.roleId ne role.id}">
											<option value="${role.id }">${role.name }</option>
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
						<button type="button" class="btn btn-default user_add_btn"
							aria-label="Left Align"
							onclick="javascript:window.location.href='<%=basePath%>rest/sysuser/add'">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
							添加用户
						</button>
					</div>
				</div>

				<!-- 列表显示 -->
				<table class="data_table1 fl">
					<thead>
						<tr>
							<td>用户名</td>
							<td>用户状态</td>
							<td>用户创建时间</td>
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
								<td>${m.username}</td>
								<td><c:if test="${m.state eq 1}">已激活</c:if> <c:if
										test="${m.state eq 2}">未激活</c:if></td>
								<td><fmt:formatDate value="${m.createTime}"
										pattern="yyyy/MM/dd  HH:mm:ss" /></td>
								<td>
									<button type="button" class="btn btn-info btn_update"
										onclick="javascript:window.location.href='<%=basePath%>rest/sysuser/update?id=${m.id}'">修改</button>
									<button type="button" class="btn btn-danger btn_delete"
										onclick="javascript:if(confirm('确实要删除员工${m.username}吗?'))location='deleteuser?id=${m.id }'">删除</button>
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
            href:'?p={{number}}&username=${u.username}&roleId=${u.roleId}'
        });
    });
    </script>
</body>

</html>