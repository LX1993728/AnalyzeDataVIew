<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 使用webkit内核 -->
<meta name="renderer" content="webkit">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="<%=basePath%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=basePath%>/scrollbar/jquery.mCustomScrollbar.css">
<!-- style.css -->
<link rel="stylesheet" href="<%=basePath%>/css/base.css">
<link rel="stylesheet" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
<link rel="stylesheet" href="<%=basePath%>/css/tenant_group.css">
<title>移动行为分析-新建用户分群</title>

</head>

<body>
	<!-- 头部 -->
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<%-- <%@ include file="left_menu.jsp" %> --%>
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="310" />
		</jsp:include>
		<!-- 内容 -->
		<div class="tenant_group_content1">
			<div class="tenant_groupNew_content">
				<div class="tenant_group_title">
					<button class="tenant_group_style" id="tenantStyleDown">
						<!-- <span class="fl">移动警务</span> <span class="caret caret1"></span> -->
					</button>
					<div
						class="tenant_group_select tenantGroup_selectTop1 mCustomScrollbar">
						<ul>
							<li><a href="#">移动行为分析</a></li>
							<li><a href="#">数据统计</a></li>
							<li><a href="#">数据分析</a></li>
							<li><a href="#">配置管理</a></li>
							<li><a href="#">配置管理</a></li>
						</ul>
					</div>
				</div>
				<div class="tenant_group_table_top">
					<div class="tenantGroup_titleName">
						<div class="tenantData_title fl">新建分群</div>
					</div>
					<div class="tenantGroup_titleName_frame">
						<div class="systemusers_form_left fl">
							<ul>
								<li>用户群名称</li>
								<li>用户范围</li>
								<li>用户属性</li>
							</ul>
						</div>
						<div class="systemusers_form_right fl">
							<input type="text" id="groupName" class="form_right_style"
								placeholder="请输入用户群名称（20个字符内）"> <br> <select
								class="form_right_style" id="scope">
								<option value="-1">选择用户范围</option>
								<option value="0">新增用户</option>
								<option value="1">活跃用户</option>
							</select> <br> <select class="form_right_style" id="property">
								<option value="">选择用户属性</option>
								<option value="地区">地区</option>
								<option value="性别">性别</option>
					            <option value="年龄">年龄</option>
					            <option value="渠道">渠道</option>
					            <option value="设备">设备</option>
							</select>
							<div class="form_right_btn">
								<button class="btn_conserve" id="add" onclick="add()">保存</button>
								<button class="btn_cancel">取消</button>
							</div>
						</div>
						<div class="systemusers_form_left fl">
							<ul>
								<li>日期</li>
								<li>选择详情</li>
							</ul>
						</div>
						<div class="systemusers_form_right fl" >
							 <div>
								<input class="form_right_style_time" id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}'})"/>
								<span style="color: white;">到</span>
								<input class="form_right_style_time" id="endDate" onclick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-%d'})"/>
							</div> 
							<br>
							 <select class="form_right_style" id="details">
								<option value="">请选择详情</option>
							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
	<!-- bootstrap -->
	<script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
	<!-- scrollbar -->
	<script
		src="<%=basePath%>scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- js  -->
	<script src="<%=basePath%>/js/index.js"></script>
	<script src="<%=basePath%>/js/tenant_group.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<script src="<%=basePath%>/js/getAppkey.js"></script>
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		//属性改变详情改变
		$("#property").change(function(){
			var property = $("#property").val();
			$.ajax({
				url : path + projectName + "/rest/staticgroup/property",
				dataType : "json",
				type : "post",
				data : {
					property : $("#property").val(),
				},
				success : function(data) {
					$("#details").html("")
					$("#details").append("<option value=''>请选择详情</option>");
					var str = data.s
					if (data != null) {
						for(var s in str){
							$("#details").append("<option value='"+str[s]+"'>"+str[s]+"</option>");
						}
					} 
				}
			})
		})	
		
	function add() {
			var groupName = $("#groupName").val();
			var scope = $("#scope").val();
			var details = $("#details").val();
			var property = $("#property").val();
			var startDate = $("#startDate").val();
			var endDate = $("#endDate").val();
			if (groupName == "") {
				alert("请填写群名称!")
			}else if (scope == "-1") {
				alert("请选择用户范围!")
			}else if (property == "") {
				alert("请选择属性!")
			}else if(startDate == "" || endDate == ""){
				alert("请填写完整日期!")
			}else if (details == "") {
				alert("请选择详情!")
			}else {
				$.ajax({
					url : path + projectName + "/rest/staticgroup/add",
					dataType : "json",
					type : "post",
					data : {
						name : groupName,
						userType : scope,
						details : details,
						property : property,
						startDate:startDate,
						endDate:endDate,
					},
					success : function(result) {
						if(result.message != null){
							alert(result.message)
						}
						if (result.b == true) {
							alert("新建成功!")
							location.href = path + projectName + "/rest/staticgroup/list";
						} else{
							alert("新建失败!")
						}
					}
				})
			}

		}
		$("#details").click(function(){
			if($("#property").val() == ""){
				alert("请先选择用户属性!")
			}
		})
	</script>

</body>
</html>