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

<title>编辑文章-TestingZone</title>
<%@ include file="template/css.jsp"%>
<style>
@media screen and (min-width: 800px) {
	.layui-container{
		width: 750px;
	}
}
</style>
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
				<textarea id="editor_id" name="content"
					style="width:100%;height:800px;">
					&lt;strong&gt;HTML内容&lt;/strong&gt;
				</textarea>
			</div>
		</div>
		<div class="layui-row">
			<%@ include file="template/foot.jsp"%>
		</div>
	</div>
	<%@ include file="template/fixbar.jsp"%>
	<script charset="utf-8" src="js/kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="js/kindeditor/lang/zh-CN.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var options = {
				height : '600px',
				filterMode : true
			};
			window.editor = K.create('#editor_id', options);
		});
	</script>
</body>
</html>
