<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>移动行为分析-事件管理</title>
</head>

<body>
	<%@ include file="top.jsp"%>
	<div class="index_main">
		<jsp:include page="left_menu.jsp">
			<jsp:param name="menu" value="305" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<div class="profiling_contanter_top">
				<div class="right_data_title" id="new_users">
					<span class="cp">事件管理</span>
				</div>
				<table class="data_table1 fl" id="tableCarrier">
					<thead>
						<tr>
							<td>事件名称</td>
							<td>录入时间</td>
							<td>是否核心</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty coreEventList.items}">
							<tr>
								<td colspan="5">暂时没有任何数据</td>
							</tr>
						</c:if>
						<c:forEach items="${coreEventList.items}" var="event"
							varStatus="eventStatus">
							<tr>
								<td class="hide">${event.eventId}</td>
								<td>${event.eventName}</td>
								<td>${event.date}</td>
								<td><c:if test="${empty event.type}">
										否
									</c:if> <c:if test="${not empty event.type}">
										是
									</c:if></td>
								<td>
								<button class="btn btn-info btn_update" rev="${event.type}" rel="${event.eventId}" onClick = "updateE(this)">修改</button>
									&nbsp;&nbsp;
								<buton class="btn btn-danger btn_delete" rel="${event.eventId}" onClick = "deleteE(this)">删除</button>

									<%-- <div class="modal fade event_manager_content"
										id="${event.eventId}" tabindex="-1" role="dialog"
										aria-labelledby="myModalLabel">
										<div class="modal-dialog" role="document">
											<div class="modal-content content_dialog">
												<div class="modal-header event_manager_td_div">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true" class="btn_close">&times;</span>
													</button>
													<h4 class="modal-title event_manager_td_title"
														id="myModalLabel">${event.eventName}</h4>
												</div>
												<div class="modal-body event_manager_td_content">
													<div class="select_content_div">
														事件名称：<input class="content_div_input" type="text"
															value="${event.eventName}" />
													</div>
													<div class="select_content_div" >
														<span class="fl">是否为核心事件：</span>
														<select class="form-control col-xs-4" id="coreE"><!-- form-control  -->
															<option value="core">fdg</option>
															<option value=null>fd</option>
														</select>
														<div class="dropdown fl">
															<button class="btn_dropdown" id="dLabel" type="button"
																data-toggle="dropdown" aria-haspopup="true"
																aria-expanded="false">
																<c:if test="${empty event.type}">
										否
									</c:if>
																<c:if test="${not empty event.type}">
										是
									</c:if>
															</button>
															<ul class="dropdown-menu btn_dropdown" aria-labelledby="dLabel">
																<li>是</li>
																<li>否</li>
															</ul>
														</div>
													</div>
													<div class="select_content_div">事件节点：</div>

												</div>
												<div class="modal-footer event_manager_td_divTop btn_footer">
													<button type="button" class="btn btn-primary btn_hover" rel="${event.eventId}" onClick="updateE(this)">保存</button>
													<button type="button" class="btn btn-primary btn_hover"
														data-dismiss="modal">关闭</button>
												</div>
											</div>
										</div>
									</div> --%></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination pull-right paginationRight" id="eventCount"></ul>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="<%=basePath%>/js/jQuery 1.9.1.js"></script>
	<!-- bootstrap -->
	<script src="<%=basePath%>/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>/js/left_menu.js"></script>
	<!-- js  -->
	<script src="<%=basePath%>/js/index.js"></script>
	<script src="<%=basePath%>/js/jquery.twbsPagination.min.js"></script>
	<script type="text/javascript">
	
	
	
		//删除事件
		function deleteE(a){
			var eventId =$(a).attr("rel");
			if(confirm("确定删除事件么？")){
				window.location.href = "deleteEvent?id="+eventId;
			}
			
		}
	
		//修改事件类型
		function updateE(a){
			var eventId =$(a).attr("rel");
			var type = $(a).attr("rev");
			var msg;
	        if (type == "core") {
	            msg = "确定设为普通事件么？";
	        } else {
	            msg = "确定要设为核心事件么？";
	        }
	        if (confirm(msg)) {
	            window.location.href = "updateEvent?id="+eventId;
	        }
		}
	
 		$(function () {
    		$("#eventCount").twbsPagination({
	    		totalPages:${coreEventList.totalPages},
	            visiblePages:10,
	            first:'首页',
	            prev:'上一页',
	            next:'下一页',
	            last:'末页',
	            href:'?p={{number}}'
       	 });
    });
    </script>
</body>
</html>