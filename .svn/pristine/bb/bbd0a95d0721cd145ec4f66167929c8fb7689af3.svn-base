<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<title>移动行为分析系统</title>
<link rel="stylesheet" href="<%=basePath%>bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/base.css">
<link rel="stylesheet" href="<%=basePath%>css/login.css">	
</head>

<body>
	<!-- Top content -->
	<div class="login_bg">
        <div class="login_logo fl"></div>
        <div class="login_accountNum"> 
			<form role="form" action="<%=basePath%>rest/user/login" method="post"  class="login_accountNum_main">
				<div class="login_accountNum_top tc">
	               	 登录平台账号
	            </div>
	            <div class="login_accountNum_middle">
	                <input type="text" name="username" class="accountNum_text" id="username" onblur="getFocus(this.id);" placeholder="请输入登录账号">
	                <input type="password" name="password" class="accountNum_text1" id="password" onblur="getFocus(this.id);" placeholder="输入您的密码">
	                <span class="glyphicon glyphicon-user text_icon1"></span>
	                <span class="glyphicon glyphicon-lock text_icon2"></span>
	            </div>
	            <div class="login_accountNum_password hide">
	                <input type="checkbox" class="password_box fl">
	                <span class="fl">下次自动登录</span>
	                <span class="fr">忘记密码</span>
	            </div>
	            <div class="login-error">
					<c:choose>
						<c:when test="${error!=null}">
							<span style="color:red">${error }</span>
						</c:when>
					</c:choose>
				</div>
	            <button class="login_accountNum_btn tc" onclick="login();">
	               	登录
               	</button>
            </form>
        </div>
      	<div class="Copy-right">Copyright © 2005-2015 ANRONG Technologies Co., Ltd.All rights reserved.</div>
    </div>
	<!-- Javascript -->
	
	<script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
	<!-- bootstrap -->
	<script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
	
	<[if lt IE 10]>
            <script src="<%=basePath%>/js/placeholder.js"></script>
        <![endif]>
	<script>
		$(function() {
			$("#username").focus();
		});

		function login() {
			//清空错误信息
			$(".login-error").empty();
			var username = $("#username");
			var password = $("#password");
			if (username.val() == "") {
				username.next().css("color", "red").text("用户名不能为空");
				username.focus();
				return;
			}
			if (password.val() == "") {
				password.next().css("color", "red").text("密码不能为空");
				password.focus();
				return;
			}
			$("#form").submit();
		}

		function getFocus(id) {
			$("#" + id).next().text("");
		}

		$(window).keydown(function(ev) {
			var oEvent = ev || event;
			if (oEvent.keyCode == 9) {
			    console.log(oEvent.keyCode);
				/*关键部分 开始(重要! 去掉浏览器的默认事件 不然会按tab之后光标会跳去其他的地方,用户优化不好)*/
				if (oEvent.preventDefault) {
					oEvent.preventDefault();
				} else {
					window.event.returnValue = false;
				}
				var isUsernameFocus = $("#username").is(":focus");
				var isPasswordFocus = $("#password").is(":focus");
				if(!isUsernameFocus){
				   	$("#username").focus();
				}else if(!isPasswordFocus){
					$("#password").focus();
				}
			}
		});
	</script>
</body>

</html>
