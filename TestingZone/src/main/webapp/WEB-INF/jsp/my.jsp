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

<title>我的文章-TestingZone</title>
<%@ include file="template/css.jsp"%>
</head>

<body>
<%-- 	<div class="fix_header">
		<div class="layui-container">
			<div class="layui-row">
				<div class="layui-col-md2 nav_logo">测试知识积累</div>
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">${username}，欢迎您！</li>
				</ul>
			</div>
		</div>
	</div> --%>
	<%@ include file="template/head.jsp"%>
	
	<div class="layui-container content">
		<div class="layui-row">
			<div class="layui-col-md12">
				<%@ include file="template/overview.jsp"%>
			</div>
<%-- 			<div class="layui-col-md4">
				<%@ include file="template/right.jsp"%>
			</div> --%>
		</div>
		<div class="layui-row">
			<%@ include file="template/foot.jsp"%>
		</div>
	</div>
	<%@ include file="template/fixbar.jsp"%>
	<script type="text/javascript">
			layui.use(['laypage','element'], function() {
			var laypage = layui.laypage;
			var element = layui.element;
			//执行一个laypage实例
			laypage.render({
				elem : 'paging' ,
				layout : [ 'count', 'prev', 'page', 'next' ],
				count : ${myArticleMap.count} ,
				curr : ${myArticleMap.page},
				jump : function(obj, first) {
					if (!first) {
						var url = window.location.pathname;
						console.log(url);
						var position = url.lastIndexOf("/")
						var u = url.substring(0, position + 1);
						console.log(u);
						window.location.href = u + obj.curr;
					}
				}
			});
		});
	</script>
</body>
</html>
