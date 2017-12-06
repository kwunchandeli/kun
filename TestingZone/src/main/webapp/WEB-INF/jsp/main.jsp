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

<title>TestingZone</title>
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
			<div class="layui-col-md8">
				<%@ include file="template/content.jsp"%>
			</div>
			<div class="layui-col-md4">
				<%@ include file="template/right.jsp"%>
			</div>
		</div>
		<div class="layui-row">
			<%@ include file="template/foot.jsp"%>
		</div>
	</div>
	<%@ include file="template/fixbar.jsp"%>
	<script type="text/javascript">
			layui.use('laypage', function() {
		var laypage = layui.laypage;

		//执行一个laypage实例
		laypage.render({
			elem : 'paging' //注意，这里的 test1 是 ID，不用加 # 号
			,
			layout : [ 'count', 'prev', 'page', 'next' ],
			count : ${contentMap.count} //数据总数，从服务端得到
			,
			curr : ${contentMap.page},
			jump : function(obj, first) {
				if (!first) {
					var url = window.location.pathname;
					console.log(url);
					if (url.indexOf("main") > -1) {
						window.location.href = "/TestingZone/main/" + obj.curr;
					} else if (url.indexOf("plate") > -1) {
						var position = url.lastIndexOf("/")
						var u = url.substring(0, position + 1);
						console.log(u);
						window.location.href = u + obj.curr;
					} else {

					}
				}
			}
		});
	});
	</script>
</body>
</html>
