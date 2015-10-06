<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"/>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<title>生鲜超市后台管理系统</title>
<link href="static/js/easyui/themes/metro-blue/easyui.css" rel="stylesheet" type="text/css"/>
<link href="static/js/easyui/themes/icon.css" rel="stylesheet" type="text/css"/>
<link href="static/css/common.css" rel="stylesheet" type="text/css"/>
<script src="static/js/jquery.min.js" type="text/javascript"></script>
<script src="static/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="static/js/easyui/datagrid-detailview.js" type="text/javascript"></script>
<script src="static/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script src="static/js/require.js" type="text/javascript"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:false,href:'./view/north.jsp'" style="height:50px;"></div>
	<div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
		<ul id="menu">
		<c:forEach items="${menus }" var="menu">
		<li>
			<span>${menu.name }</span>
			<c:if test="${not empty menu.children }">
			<ul>
				<c:forEach items="${menu.children }" var="child">
				<li data-options="attributes:{leaf:true,code:'${child.code }',url:'${child.url }'}"><span>${child.name }</span></li>
				</c:forEach>
			</ul>
			</c:if>
		</li>
		</c:forEach>
		</ul>
	</div>
	<div data-options="region:'center'">
		<div id="index-tab">
			<div title="首页">
				欢迎登录生鲜超市后台管理系统
			</div>
		</div>
	</div>
<script type="text/javascript" src="static/js/horse.js"></script>
<script type="text/javascript" src="static/js/horse-ui.js"></script>
<script type="text/javascript" src="static/js/index.js"></script>
<script type="text/javascript">
$(function() {
	require.config({
		baseUrl: 'static/js'
	});
	require(['index'], function(Index) {
		Index.init();
	});
});
</script>
</body>
</html>
