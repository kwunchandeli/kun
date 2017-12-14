<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	.layui-container {
		width: 750px;
	}
}
</style>
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
				<!-- <blockquote class="layui-elem-quote"
					style="margin-top: 5px;margin-bottom: 0px;">
					<span class="layui-breadcrumb" style="visibility: visible;">
						<a href="main/1"><cite>首页</cite></a> <span class="layui-box">&gt;</span><cite>文章详情</cite>
					</span>
				</blockquote> -->
				<form class="layui-form" action="" method="post">
					<input type="hidden" id="a_id" name="a_id" value="${article.a_id}">
					<div style="width: 100%;">
						<!-- <input type="text" id="title" name="title" class="edit_title"
							placeholder="请输入标题"> -->
						<input type="text" name="title" required lay-verify="required"
							placeholder="请输入标题" autocomplete="off"
							class="layui-input edit_title" value="${article.title}">
					</div>
					<div style="padding-bottom:10px;">
						<button lay-submit lay-filter="go" class="layui-btn">提交</button>
					</div>
					<textarea id="editor_id" name="content"
						style="width:100%;height:800px;">${article.content}</textarea>
					<div class="edit-panel">
						<ul>
							<li class="edit-row"><span class="font-red">*</span>
								<div class="row-left">所属版块：</div>
								<div class="row-right">
									<select name="p_id" lay-verify="required">
										<option value="">请选择一个版块</option>
										<c:forEach items="${pList}" var="plate">
											<%-- <option value="${plate.p_id}">${plate.p_name}</option> --%>
											<c:choose>
												<c:when test="${article.p_id == plate.p_id}">
													<option value="${plate.p_id}" selected>${plate.p_name}</option>
												</c:when>
												<c:otherwise>
													<option value="${plate.p_id}">${plate.p_name}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div></li>
							<li class="edit-row">
								<div class="row-left">是否对所有人可见：</div>
								<div class="row-right">
									<c:choose>
										<c:when test="${article.status == 1}">
											<input type="checkbox" name="status" lay-skin="switch"
												value="1" checked>
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="status" lay-skin="switch"
												value="1">
										</c:otherwise>
									</c:choose>
								</div>
							</li>
						</ul>
					</div>
				</form>
			</div>
		</div>
		<div class="layui-row">
			<%@ include file="template/foot.jsp"%>
		</div>
	</div>
	<%@ include file="template/fixbar.jsp"%>
	<script charset="utf-8" src="js/kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="js/kindeditor/lang/zh-CN.js"></script>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var options = {
				height : '600px',
				filterMode : true
			};
			window.editor = K.create('#editor_id', options);
		});

		layui.use(['form','element'], function() {
			var form = layui.form;
			var element = layui.element;
			form.on('submit(go)', function(data) {
				editor.sync();
				data.field.content =$("#editor_id").val();
				console.log(data.field); //当前容器的全部表单字段，名值对形式：{name: value}
				layer.confirm('确认保存?', {
					icon : 3,
					title : '提示'
				}, function(index) {
					//do something
					$.ajax({
						type : "POST",
						url : "save/article",
						dataType : "json",
						contentType: "application/json",
						//data: data.field,
						data : JSON.stringify(data.field),
						success : function(result) {
							console.log(result);
							if (result.status == "0") {
								$("#a_id").val(result.id);
								layer.msg('保存成功！', {icon: 1});
							}
						}
					});
					layer.close(index);
				});

				return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
		});
	</script>
</body>
</html>
