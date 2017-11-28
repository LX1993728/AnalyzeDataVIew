<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String pathT = request.getContextPath();
	String topPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathT + "/";
%>
<html lang="zh-CN">
<body>
    <!-- 头部 -->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand navbar_logo text-center" href="<%=topPath%>rest/datas/index">移动行为分析</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${username} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        
                            <li><a href="<%=topPath%>rest/user/logout">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>

</html>