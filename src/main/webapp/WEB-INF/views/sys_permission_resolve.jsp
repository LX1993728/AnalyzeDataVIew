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
			<jsp:param name="menu" value="303" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">

			<div class="add_systemusers_form">

				<div class="add_systemusers_form_title fl" role="alert">
					<c:if test="${p.id eq null}">
					增加系统资源
					</c:if>
					<c:if test="${p.id ne null}">
					修改系统资源
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
				action="${ p.id eq null? 'addpermission':'updatepermission'}"
				method="post">
				<div class="form-group">
					<input type="hidden" name="id" value="${p.id }" /> <label
						for="name" class="col-sm-2 control-label">资源名</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="name" name="name"
							value="${p.name }" placeholder="请输入资源名">
					</div>
				</div>
				<div class="form-group">
					<label for="code" class="col-sm-2 control-label">资源编码</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="code"
							value="${p.code }" name="code" placeholder="请输入资源对应的编码">
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">资源描述</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="description"
							value="${p.description }" name="description"
							placeholder="请输入资源描述">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary fc btn_update">确定</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-warning btn_cancel"
							aria-label="Left Align"
							onclick="javascript:window.location.href='<%=basePath%>rest/syspermission/list'">
							取消</button>
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