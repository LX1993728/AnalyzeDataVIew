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
<!-- style.css -->
<link rel="stylesheet" href="<%=basePath%>/css/base.css">
<link rel="stylesheet" href="<%=basePath%>/css/index.css">
<link rel="stylesheet" href="<%=basePath%>/css/data_profiling.css">
<link rel="stylesheet" href="<%=basePath%>/css/tenant_group.css">

<script type="text/javascript">
	function deleteGroup(id, name) {
		if (confirm('您确定要删除群组' + name)) {
			$.ajax({
				url : "deletegroup?id=" + id,
				type : "get",
				success : function(data) {
					result = eval(data);
					alert(result.message);
					console.log(result.message);
					window.location.href = "list";
				}
			});
		}
	}
</script>

<title>移动行为分析-用户分群</title>

</head>

<body>
	<!-- 头部 -->
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="310" />
		</jsp:include>
		<!-- 内容 -->
		<div class="tenant_group_content1">
			<div class="tenant_group_title fl">
				<div class="table_caption">
					<div class="fl cp title_caption_table" id="table_caption_title">
						<div class="fl table_title" rel="${sessionScope.appKey}"
							id="get_appKey">${sessionScope.appInfo }</div>
					</div>
				</div>
			</div>
			<div class="tenant_group_table">
				<div class="tenantGroup_titleName">
					<div class="tenantData_title fl">用户分群</div>
					<div class="tenantData_titleBtn fr">
						<button class="tenantData_btn tenantData btnMagin"
							onclick="javascript:window.location.href='<%=basePath%>/rest/staticgroup/add'">新建分群</button>
						<button class="tenantData_btn tenantData1 btnMagin">查看</button>
						<button class="tenantData_btn tenantData1 btnMagin">删除</button>
						<button class="tenantData_btn tenantData">
							<span class="glyphicon glyphicon-search"></span>搜索
						</button>
					</div>
				</div>
				<table class="tenantGroup_table">
					<thead>
						<tr>
							<td class="tenantGroup_td1">
								<div class="tenantGroup_checkBox"></div>
							</td>
							<td>用户群名称</td>
							<td>筛选条件</td>
							<td>用户量</td>
							<td>状态</td>
							<td class="ac">更新时间</td>
							<td class="ac">操作</td>
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
								<td>
									<div class="tenantGroup_checkBox"></div>
								</td>
								<td>${m.name}</td>
								<td>
									<p>
										用户范围：${m.userType==0?'新增':'活跃' }
										<fmt:formatDate value="${m.startTime}" pattern="yyyy-MM-dd" />
										至
										<fmt:formatDate value="${m.endTime}" pattern="yyyy-MM-dd" />
									</p>
									<p>
										用户属性：
										<c:choose>
											<c:when test="${m.userProvince ne null }">
									  	地区 ${m.userProvince}
									  	</c:when>
											<c:when test="${m.userSex ne null }">
									  	性别 ${m.userSex == 0?'男':'女' }
									  	</c:when>
											<c:when
												test="${(m.userMinAge ne null) and (m.userMaxAge ne null) }">
									  	年龄 ${m.userMinAge} ~ ${m.userMaxAge }
									  	</c:when>
											<c:when test="${m.userChannel ne null }">
									  	渠道 ${m.userChannel }
									  	</c:when>
											<c:when test="${m.userDevice ne null }">
									  	设备 ${m.userDevice }
									  	</c:when>
										</c:choose>
									</p>
								</td>
								<td>${m.total}</td>
								<td>${m.status == 1?'已完成':'处理中'}</td>
								<td class="ac"><fmt:formatDate value="${m.updatetime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="ac"><a href="#" class="checkBtn">查看</a>
									<button class="reviseBtn"
										onclick="javascript:window.location.href='<%=basePath%>/rest/staticgroup/update/'+ ${m.id}">修改</button>
									<button class="deleteBtn"
										onclick="deleteGroup('${m.id}','${m.name }')">删除</button></td>
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
	<script src="<%=basePath%>/js/tenant_group.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<script src="<%=basePath%>/js/getAppkey.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
	<script src="<%=basePath%>/js/retained_profile.js"></script>
	<script src="<%=basePath%>/My97DatePicker/WdatePicker.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {

			$("#table_iconX").click(function() {
				$("#app-form-group").removeClass("hidden")
			});

			$("#page").twbsPagination({
				totalPages : '${page.totalPages}',
				visiblePages : 10,
				first : '首页',
				prev : '上一页',
				next : '下一页',
				last : '末页',
				href : '?p={{number}}&name=${r.name}'
			});
		});
	</script>


</body>
</html>