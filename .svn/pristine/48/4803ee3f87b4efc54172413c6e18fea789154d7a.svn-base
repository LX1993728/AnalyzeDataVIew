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

<script type="text/javascript">
	$(function() {

		$("#username").on("blur", function() {
			var username = $("#username").val();
			$.ajax({
				type : "POST",
				url : "<%=basePath%>
	/rest/sysuser/checkname",
				data : 'username=' + username,
				async : true,
				success : function(messageObj) {
					//显示Ajax返回结果
					var m = eval(messageObj);
					$("#usernameMess").text(m.message);
				}
			});

		});

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
			<jsp:param name="menu" value="301" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">

			<div class="add_systemusers_form">

				<div class="add_systemusers_form_title fl" role="alert">
					<c:if test="${u.id eq null}">
					增加系统用户
					</c:if>
					<c:if test="${u.id ne null}">
					修改系统用户
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
				action="${ u.id eq null? 'adduser':'updateuser'}">
				<div class="form-group">
					<input type="hidden" name="id" value="${u.id }" /> <label
						for="username" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="username"
							name="username" value="${u.username }" placeholder="请输入用户名">
						<div class="form_right_small">
							<span class="form_right_red fl">*</span> <span
								class="form_right_font fl">用户名不能为空或者空格</span>
						</div>
					</div>

					<span class="col-sm-2" id="usernameMess" style="color: red"></span>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
					<div class="col-sm-8">
						<input type="text" class="form_right_style" id="password" value=""
							name="password" placeholder="请输入新的密码">
					</div>
				</div>
				<div class="form-group">
					<label for="roles" class="col-sm-2 control-label">分配角色</label>
					<div class="col-sm-8">
						<c:forEach var="role" items="${roles }">
							<c:set var="flag" value="false" />
							<c:forEach items="${u.roleIds}" var="roleid">
								<c:if test="${role.id  eq roleid}">
									<c:set var="flag" value="true" />
								</c:if>
							</c:forEach>
							<label class="checkbox-inline"> <input type="checkbox"
								name="roleIds" value="${role.id }"
								${ flag?'checked="checked"':'' }> ${role.name }
							</label>
						</c:forEach>
					</div>
				</div>
				<div class="form-group">
					<label for="roles" class="col-sm-2 control-label">选择平台</label>
					<div class="col-sm-8">
						<c:forEach var="app" items="${apps }">
							<c:set var="flag2" value="false" />
							<c:forEach items="${u.appIds}" var="appid">
								<c:if test="${app.id  eq appid}">
									<c:set var="flag2" value="true" />
								</c:if>
							</c:forEach>
							<label class="checkbox-inline"> <input type="checkbox"
								name="appIds" value="${app.id }"
								${ flag2 ?'checked="checked"':'' }> ${app.appName }
							</label>
						</c:forEach>
					</div>
				</div>
				<div class="form-group">
					<label for="roles" class="col-sm-2 control-label">用户状态</label>
					<div class="col-sm-8">
						<select class="form_right_style" name="state" value="${u.state }">
							<option value="-1">---请选择用户状态---</option>
							<option value="1" ${u.state ne 0?'selected':''}>激活状态</option>
							<option value="0" ${u.state eq 0?'selected':''}>禁用状态</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary fc btn_update">确定</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-warning btn_cancel"
							aria-label="Left Align"
							onclick="javascript:window.location.href='<%=basePath%>/rest/sysuser/list'">
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