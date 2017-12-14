<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="fix_header">
	<div class="layui-container">
		<div class="layui-row">
			<div class="layui-col-md2 nav_logo">测试知识积累</div>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item">
					<a href="javascript:;">
				          ${user.u_name==null?"未登记用户":user.u_name}
				          <!-- <span class="layui-nav-more"></span>，欢迎您！ -->
				     </a>
					<c:if test="${user.u_id != 0}">
						<dl class="layui-nav-child">
				          <dd><a href="my/all/1" target="_blank">我的文章</a></dd>
				          <c:if test="${user.role == \"1\"}">
				          		<dd><a onclick="javascript:layer.msg('功能开发中，敬请期待！');">系统管理</a></dd>
				          </c:if>
				        </dl>
					</c:if>
				</li>
			</ul>
		</div>
	</div>
</div>