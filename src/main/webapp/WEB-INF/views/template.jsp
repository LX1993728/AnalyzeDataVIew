<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>移动行为分析系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath %>font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

 	<!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=basePath %>js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
    
    <!-- echarts -->
    <script src="<%=basePath %>js/plugins/echarts.min.js"></script>
    </head>
    <body>

    </body>
</html>