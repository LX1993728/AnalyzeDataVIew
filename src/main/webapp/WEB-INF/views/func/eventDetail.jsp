<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="../head.jsp" %>
<link href="<%=basePath%>css/plugins/bootstrap-multiselect.css" rel="stylesheet">
<script src="<%=basePath%>js/plugins/bootstrap-multiselect.js"></script>

<link href="<%=basePath%>css/plugins/bootstrap-table.css" rel="stylesheet">
<script src="<%=basePath%>js/plugins/bootstrap-table.js"></script>
<script src="<%=basePath%>js/plugins/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript">
 $.ajaxSetup({async : false});
 
 $(function(){
 	 mutiselectInit();
	 loadData();
	 $(".multiselect").change(function(){
		 loadData();
	 });
 });
 
function mutiselectInit() {
	$('.multiselect').multiselect({		
		buttonText : function(option) {

			return (option.attr('label') !== undefined) ? option.attr('label'): option.html();

		}
	});
}
		
function getVersion() {
	return $("#version").val();
}
function getTimeArea() {
	return $("#timeArea").val();

}
function getAppKey() {
	return $("#appKey").val();
}

function getEvent(){
	return $("#event").val();
}
 
 function loadData() {
		$.ajax({
			type : "GET",
			url : "selectEchartDataByCondtion",
			data : {
				"event" : getEvent(),
				"timeArea" : getTimeArea(),
				"version" : getVersion(),
				"appKey" : getAppKey()
			},
			dataType : "json",
			success : function(result) {
				loadTable(result);
				loadEchart(result);
			}
		});
	}
 
	//加载table数据
	function loadTable(result){
		$('#showTable').bootstrapTable('load', result.records);
	}
	//加载图表
	function loadEchart(result) {		

		var myChart = echarts.init(document.getElementById('main'));
		
		var option = {
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : result.legend,
			},
			xAxis : [ {
				type : 'category',
				boundaryGap : true,
				data : result.xAxis,
				splitLine : {
					show : false
				}
			} ],
			yAxis : {
				type : 'value',

				axisLine : {
					show : false
				},
				axisTick : {
					show : false
				}
			},
			series : [ {
				name : result.legend[0],
				type : 'line',
				data : result.seriesData,
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					} ]
				},

			} ]
		};
		myChart.setOption(option);
		window.onresize = myChart.resize;
	}
 

 </script>
 <style type="text/css">
.pull-right{
	margin-right:15px;
}
</style>
<body>
	<div class="row">
		<input type="hidden" id="appKey" name="appKey" value="${appKey }"/>
		<div class="col-xs-2">
			<select id="event" name="" class="multiselect">
				<c:forEach items="${appEventList }" var="appEvent">
					<option value="${appEvent.event }" <c:if test="${appEvent.event eq event }">selected</c:if>>${appEvent.event}</option>
				</c:forEach>
			</select>
		</div>
	 
		<div class="pull-right">
			<select class="multiselect" id="timeArea">
				<option value="60">过去60天</option>
				<option value="30">过去30天</option>
				<option selected="selected" value="7">过去7天</option>
				<option value="1">今日</option>
			</select>
		</div>
		
		<div class="pull-right">
			<select class="multiselect" id="version">
				<c:forEach items="${appVersions }" var="v">
					<option value="${v}">${v}</option>
				</c:forEach>
			</select>
		</div>

	 
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">事件统计
			</h3>
		</div>
		<div class="panel-body">
			<div class="btn-group" role="group" id="btn-group">
				<button type="button" class="btn btn-default btn-type" id="count">消息数量</button>
			</div> 
			<div id="main" style="width: 100%; height: 400px;"></div>
		</div>
	</div>

	<div class="panel panel-default" style="width: 100%;">
		<div class="panel-heading">
			<h3 class="panel-title">事件统计明细
			</h3>
		</div>
		<div class="panel-body">
			<table  id="showTable"
			data-toggle="table"
			data-show-toggle="true"
			data-show-columns="true">
				<thead>
					<tr>
						<th data-field="event">事件</th>
						<th data-field="statisticDate">日期</th>
						<th data-field="startCount">消息数量</th> 
					</tr>
				</thead>
			</table>
		</div>
	</div>

</body>
</html>