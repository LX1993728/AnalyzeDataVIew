<%@page import="com.anrong.wulan.admin.po.SYSMenu"%>
<%@page import="com.anrong.wulan.admin.vo.SYSMenuVO"%>
<%@page import="java.util.List"%>
<%@page import="com.anrong.wulan.admin.vo.ActiveUserVO"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String pathM = request.getContextPath();
	String menuPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathM + "/";
	//主体  
    Subject subject = SecurityUtils.getSubject();  
    //身份  
    ActiveUserVO userInfo = (ActiveUserVO) subject.getPrincipal(); 
    List<SYSMenuVO> oneMenus =  userInfo.getMenus();
    pageContext.setAttribute("oneMenus",oneMenus);
%>

<!DOCTYPE html>
<html lang="en">
<body>


        <!-- 侧边栏 -->
       <div class="index_menu">
            <ul class="list-group" id="list_group">
		  	<c:forEach var="oneMenu" items="${oneMenus }">
                <li class="list-group-item ${param.menu == oneMenu.id ? 'list_group_bg':''}">
                <!-- nav_icon nav_icon1 fl -->
                		<c:if test="${oneMenu.url.length() > 1 }">
                     <s class="${oneMenu.iconstyle }"></s><a href="<%=menuPath%>${oneMenu.url}">${oneMenu.name}</a>
                		</c:if>
                		<c:if test="${oneMenu.url eq '-' }">
                     <s class="${oneMenu.iconstyle }"></s><a href="javascript:void(0)">${oneMenu.name}</a>
                		</c:if>
                    <s class="menu_arrow_icon icon_top fr"></s>
                </li>
                <ul class="list-group list_group_bottom">
                <c:forEach var="twoMenu" items="${oneMenu.childMenus}">
                <!-- list_item list_item_color  -->
                    <!--list_item  -->
                    <c:if test="${twoMenu.url.length() > 1 }">
                    	<li class="list_item ${param.menu == twoMenu.id+'' ? 'active list_group_bg':''}"><a href="<%=menuPath%>${twoMenu.url}"  target="${'研报' == twoMenu.name ? '_blank':''}" onClick="getMenuName(this)">${twoMenu.name}</a>
                    </c:if>
                    
                    <c:if test="${twoMenu.url eq '-' }">
                    <li class="list_item ${param.menu == twoMenu.id+'' ? 'active list_group_bg':''}"><a href="javascript:void(0)">${twoMenu.name}</a>
                    </c:if>
                    
                </c:forEach>
                </ul>
		  	</c:forEach>
            </ul>
        </div> 
        
        <!-- 侧边栏 -->
        <%-- <div class="index_menu">
            <ul class="list-group" id="list_group">
                <li class="list-group-item ${param.menu == 'index' ? 'list_group_bg':''}">
                <!-- nav_icon nav_icon1 fl -->
                    <s class="nav_icon nav_icon1 fl "></s><a href="<%=menuPath%>rest/datas/index">数据统计</a>
                    <s class="menu_arrow_icon icon_top fr"></s>
                </li>
                <!-- list_item list_item_color  -->
                <ul class="list-group list_group_bottom">
                    <!--list_item  -->
                    <li class="list_item ${param.menu == 'dataPro' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/profile/dataprofiling">用户概况</a></li>
                <li class="list_item ${param.menu == 'user_analysis' ? 'active list_group_bg':''}" ><a href="<%=menuPath%>rest/datasanalysis/useranalysis">用户统计</a></li>  
                  <li class="list_item ${param.menu == 'retained_profile' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/retained/profile">留存概况</a></li>
                    <li class="list_item ${param.menu == 'dataVersion' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/version/dataversion">机型版本</a></li>
                    <li class="list_item ${param.menu == 'dataModel' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/moudle/datamodule">模块统计</a></li>
                    <li class="list_item ${param.menu == 'dataArea' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/area/datarea">地区统计</a></li>
                    <li class="list_item ${param.menu == 'dataNet' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/network/datanetwork">联网方式</a></li>
              		  <li class="list_item ${param.menu == 'channel_analysis' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/channelStatistics/channelView">渠道统计</a></li>
                </ul>
               <li class="list-group-item ${param.menu == 'datanalysis' ? 'list_group_bg':''}">
                	<!-- nav_icon nav_icon2 fl -->
                    <s class="nav_icon nav_icon2 fl"></s><a href="<%=menuPath%>rest/DataAnalysis/datanalysis">数据分析</a>
                    <s class="menu_arrow_icon icon_top fr"></s>
                </li>
                <ul class="list-group list_group_bottom">
                    <li class="list_item ${param.menu == 'model_analysis' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/modelsanalysis/modelindex">模块分析</a></li>
                    <li class="list_item ${param.menu == 'event_analysis' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/event/analysis">事件分析</a></li>
					<li class="list_item"><a href="<%=menuPath%>rest/researchreport/researchreportindex" target="_blank">研报</a></li>
                </ul>
                <li class="list-group-item">
                    <s class="nav_icon nav_icon3 fl"></s>配置管理
                    <s class="menu_arrow_icon icon_top fr"></s>
                </li>
                <ul class="list-group list_group_bottom">
                    <li class="list_item"><a href="#">用户角色管理</a></li>
                    <li class="list_item"><a href="#">预警管理</a></li>
                    <li class="list_item ${param.menu == 'event_manager' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/manager/event">事件管理</a></a></li>
                    <li class="list_item"><a href="#">菜单管理</a></li>
                    <li class="list_item ${param.menu == 'report_manager' ? 'active list_group_bg':''}"><a href="<%=menuPath%>rest/report/manager">研报管理</a></li>
					<li class="list_item"><a href="#">接入管理</a></li>
					<li class="list_item"><a href="#">业务操作记录</a></li>
                </ul>
            </ul>
        </div>  --%>
        
        
        
        <script>
   		
        </script>
</body>
</html>
