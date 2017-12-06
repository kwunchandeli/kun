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
				<blockquote class="layui-elem-quote"
					style="margin-top: 5px;margin-bottom: 0px;">
					<span class="layui-breadcrumb" style="visibility: visible;">
						<a href="main/1"><cite>首页</cite></a> <span class="layui-box">&gt;</span><cite>文章详情</cite>
					</span>
				</blockquote>
				<div class="light">
					<!-- 加载文章内容 -->
					<h1 class="center_text">${article.title}</h1>
					<div class="center_text tag">
						<span>时间 : ${article.create_time}</span> <span>分类 :
							${article.p_name}</span> <span>作者 : ${article.u_name}</span> <span>阅读
							: ${article.pv}</span>
					</div>
					${article.content}
				</div>
			</div>
		</div>
		<div class="layui-row">
			<%@ include file="template/foot.jsp"%>
		</div>
	</div>
	<%@ include file="template/fixbar.jsp"%>
</body>
</html>
