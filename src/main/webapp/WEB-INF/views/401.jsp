<%@ page language="java" pageEncoding="utf-8" session="false"%>
<%@include file="head.jsp" %>
<body class="error">
    <div class="container">
      <div class="col-lg-8 col-lg-offset-2 text-center">
        <div class="logo">
          <h1>401</h1>
        </div>
        <p class="lead text-muted">未授权</p>
        <div class="clearfix"></div>
         
        <div class="clearfix"></div>
        <br>
        <div class="col-lg-6 col-lg-offset-3">
          <div class="btn-group btn-group-justified">
            <a href="javascript:history.back(-1);" class="btn btn-info">返回上一页面</a>
            <a href="javascript:parent.location.href='<%=basePath %>';" class="btn btn-warning">返回主页</a>
          </div>
        </div>
      </div><!-- /.col-lg-8 col-offset-2 -->
    </div>
  </body>
<!-- END BODY -->
</html>