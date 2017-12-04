<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>${article_name}-TestingZone</title>
<%@ include file="template/css.jsp"%>
</head>

<body>
	<div class="fix_header">
		<div class="layui-container">
			<div class="layui-row">
				<div class="layui-col-md2 nav_logo">测试知识积累</div>
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">${username}，欢迎您！</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="layui-container content">
		<div class="layui-row">
			<div class="layui-col-md12">
				<%@ include file="template/content.jsp"%>
			</div>
		</div>
		<div class="layui-row">
			<%@ include file="template/foot.jsp"%>
		</div>
	</div>
	<%@ include file="template/fixbar.jsp"%>
</body>
</html>
