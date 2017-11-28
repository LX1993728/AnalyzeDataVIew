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
			<jsp:param name="menu" value="307" />
		</jsp:include>
		<!-- 内容 -->
		<div class="index_content">
			<div class="profiling_contanter_top">
				<div class="right_data_title" id="new_users">
					<span class="cp">研报管理</span>
					<table class="data_table1 fl" id="tbStu">
						<thead>
		                    <tr>
		                        <td>指标名称</td>
		                        <td>权重</td>
		                        <td>指标范围(第一阶段)</td>
		                        <td>指标范围(第二阶段)</td>
		                        <td>指标范围(第三阶段)</td>
		                        <td>指标范围(第四阶段)</td>
		                        <td>操作</td>
		                    </tr>
		                  </thead> 
		                  <tbody>
								<c:if test="${empty reportDate.items}">
									<tr><td colspan="7">暂时没有任何数据</td></tr>
								</c:if>
								
								<c:forEach items="${reportDate.items}" var="rd">
									<tr>
										<td>${rd.name}</td>
										<td>${rd.weight}</td>
										<td>${rd.firdata}</td>
										<td>${rd.sdata}</td>
										<td>${rd.thirdata}</td>
										<td>${rd.fordata}</td>
										<td>
											<button class="btn btn-info btn_update" 
											
											firdata="${rd.firdata}" sdata="${rd.sdata}" 
											thirdata="${rd.thirdata}" fordata="${rd.fordata}" 
											weight="${rd.weight}"  name="${rd.name}"
											rel="${rd.id}"
											 
											onClick = "updateR(this)">修改</button>
												
										
										</td>
									</tr>
								</c:forEach>
						</tbody> 
		             </table>
		             <ul class="pagination pull-right paginationRight" id="pageVer"></ul>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="newUserModal">
		<div class="modal_dialog_width" role="document">
			<div class="modal-content update_data_dialog">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改数据</h4>
				</div>
				<div class="modal-body">
					<form id="newForm">
						<input type="hidden" name="id" id="rid">
						<div class="form-group">
							<label>指标名称</label> <input type="text" id="name" name="name"
								class="form_right_style" disabled="disabled">
						</div>
						<div class="form-group">
							<label>权　　重</label> <input type="text" placeholder="请输入权重"
								id="weight" onblur="getWeightData(this)" name="weight"
								class="form_right_style">
						</div>
						<div class="form-group">
							<label>指标范围(第一阶段)</label> <input type="text" placeholder="请输入密码"
								id="firdata" onblur="getFirData(this)" name="firdata"
								class="form_right_style">
						</div>
						<div class="form-group">
							<label>指标范围(第二阶段)</label> <input type="text" placeholder="请输入密码"
								id="sdata" onblur="getSData(this)" name="sdata"
								class="form_right_style">
						</div>
						<div class="form-group">
							<label>指标范围(第三阶段)</label> <input type="text" placeholder="请输入密码"
								id="thirdata" onblur="getThirData(this)" name="thirdata"
								class="form_right_style">
						</div>
						<div class="form-group">
							<label>指标范围(第四阶段)</label> <input type="text" placeholder="请输入密码"
								id="fordata" onblur="getForData(this)" name="fordata"
								class="form_right_style">
						</div>
					</form>
				</div>
				<div class="modal-footer modal_footer_center">
					<button type="button" class="btn btn-primary btn_update" id="saveBtn">保存</button>
					<button type="button" class="btn btn-default btn_cancel" data-dismiss="modal">取消</button>
				</div>
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
	<script src="<%=basePath%>/validate/jquery.validate.min.js"></script>
	<script>
	
	   $("#newForm").validate({
	        errorClass: "text-danger",
	        errorElement: "span",
	        rules: {
	            username: {
	                required: true,
	            },
	            weight: {
	                required: true,
	                range: [1, 5],

	            },
	            usertype: {
	                required: true,
	                maxlength:2
	            },
	            state:{
	                required:true,
	            }
	        },
	        messages: {
	            username: {
	                required: "请输入客户名",
	            },
	            weight: {
	                required: "请输入权重值",
	                range: "输入值必须介于 5 和 10 之间"
	            },
	            usertype: {
	                required: "请输入用户类型",
	                maxlength: "只能输入两个汉字"
	            },
	            state: {
	                required: "请选择用户状态",
	            }
	        },
	        submitHandler: function (form) {
	            $.post("update", $(form).serialize())
	                    .done(function (data) {
	                        if (data == "success") {
	                            $("#newUserModal").modal("hide");
	                            location.reload();
	                        }
	                    })
	                    .fail(function () {
	                        alert("客户保存失败");
	                    });
	        }
	    });
	    $("#saveBtn").click(function () {
	        $("#newForm").submit();
	    });
	
	   
	function updateR(a){
		 $("#newUserModal").modal({
	                    show: true,
	                    backdrop: 'static',
	                    keyboard: false
	                });
		 $("#rid").val($(a).attr("rel"));
		 $("#name").val($(a).attr("name"));
		 $("#weight").val($(a).attr("weight"));
		 $("#firdata").val($(a).attr("firdata"));
		 $("#sdata").val($(a).attr("sdata"));
		 $("#thirdata").val($(a).attr("thirdata"));
		 $("#fordata").val($(a).attr("fordata"));
	}
	
// 	function getFirData(a){
// 		alert($(a).val());
// 	}
	var firdata;
	var sdata;
	var thdata;
	var fordata;
	//第一个
	function getFirData(a){
		firdata = $(a).val();
		if(firdata<=0 || firdata >=100){
			confirm("请输入大于：0  并且小于 100 的数")
		}
	}
	
	/* function getWeightData(a){
		var w = $(a).val();
		if(w<1 || w >5){
			confirm("权重范围[1~5]")
		}
	} */
	
	//第二个
	function getSData(a){
		
		firdata = $("#firdata").val();
		sdata = $(a).val();
		thdata = $("#thirdata").val();
		if(sdata<= firdata || sdata>thdata ){
			confirm("请输入大于："+firdata+"并且小于 "+thdata+"的数")
		}
		
	}
	
	function getThirData(a){
		
		sdata = $("#sdata").val();
		thdata = $(a).val();
		fordata = $("#fordata").val();
		 if(thdata<= sdata || thdata>fordata ){
			 confirm("请输入大于："+sdata+"并且小于 "+fordata+"的数")
		 }
	}
	
	function getForData(a){
		thdata = $("#thirdata").val();
		fordata = $(a).val();
		if(fordata<= thdata || fordata>100 ){
			 confirm("请输入大于："+sdata+"并且小于 "+"100 的数")
		 }
	}
	
	$(function () {
		
			$("#pageVer").twbsPagination({
				totalPages:${reportDate.totalPages}, 
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