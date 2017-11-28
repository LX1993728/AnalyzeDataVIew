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

<script type="text/javascript">
	$(function() {

	});
</script>
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
			<jsp:param name="menu" value="304" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">

			<div class="add_systemusers_form">

				<div class="add_systemusers_form_title fl" role="alert">
					<c:if test="${m.id eq null}">
					增加系统菜单
					</c:if>
					<c:if test="${m.id ne null}">
					修改系统菜单
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
				action="${ m.id eq null? 'addmenu':'updatemenu'}" method="post">
				<div class="form-group">
					<input type="hidden" name="id" value="${m.id }" /> <label
						for="menuname" class="col-sm-2 control-label">菜单名</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="menuname" name="name"
							value="${m.name }" placeholder="请输入菜单名">
					</div>
				</div>
				<div class="form-group">
					<label for="url" class="col-sm-2 control-label">对应URL</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="url" value="${m.url }"
							name="url" placeholder="请输入菜单对应的URL">
					</div>
				</div>
				<div class="form-group">
					<label for="iconStyle" class="col-sm-2 control-label">图标样式</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="iconStyle"
							value="${m.iconstyle }" name="iconstyle"
							placeholder="请输入菜单对应的图标样式">
					</div>
				</div>
				<div class="form-group">
					<label for="pmenus" class="col-sm-2 control-label">所属菜单</label>
					<div id="pmenus" class="col-sm-8">
						<select class="form_right_style" name="pid" value="${m.pid }"
							${m.id ne null and m.pid eq 1?'disabled':''}>
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
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary fc btn_update">确定</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-warning btn_cancel"
							aria-label="Left Align"
							onclick="javascript:window.location.href='<%=basePath%>rest/sysmenu/list'">取消</button>

					</div>
				</div>
			</form>
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
</body>

</html>