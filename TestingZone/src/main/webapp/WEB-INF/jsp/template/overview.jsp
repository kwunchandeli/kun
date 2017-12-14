<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>

<blockquote class="layui-elem-quote"
	style="margin-top: 5px;margin-bottom: 0px;">
	<span class="layui-breadcrumb" style="visibility: visible;"> <a
		href="main/1"><cite>首页</cite></a> <span class="layui-box">&gt;</span>
		<c:choose>
			<c:when test="${type == \"2\"}">
				<cite>我的文章</cite>
			</c:when>
			<c:when test="${type == \"1\"}">
				<cite>公开文章</cite>
			</c:when>
			<c:when test="${type == \"0\"}">
				<cite>非公开文章</cite>
			</c:when>
		</c:choose>
		
	</span>
</blockquote>

<ul class="layui-col-md12">

	<c:forEach items="${myArticleMap.aList}" var="article">
		<li class="content-panel" >
			<h2 class="title">
				<a href="article/${article.a_id}" target="_blank">${article.title}</a>
			</h2>
			<h2 id="a_id" style="display: none;">${article.a_id}</h2>
			<div style="padding:4px 20px;font-size:12px;position: relative;">
				<span>发表于
				<fmt:formatDate value="${article.create_time}"
						pattern="yyyy-MM-dd HH:mm:ss" /></span>
				<span>阅读：${article.pv}</span>
				
				<div class="layui-btn-group" style="position: absolute;right: 5px;bottom: 5px">
				
					<c:if test="${article.status != \"1\"}">
						<button class="layui-btn layui-btn-primary layui-btn-sm" onclick="javascript:layer.msg('功能开发中，敬请期待！');" title="设置为所有人可见">
					    	<i class="layui-icon">&#xe641;</i>
					    </button>
					</c:if>
				  
				  <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="javascript:window.open('article/edit/${article.a_id}');" title="编辑">
				    <i class="layui-icon">&#xe642;</i>
				  </button>
				  <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="javascript:layer.msg('功能开发中，敬请期待！');" title="删除">
				    <i class="layui-icon">&#xe640;</i>
				  </button>
				</div>
			</div>
			
		</li>
	</c:forEach>
</ul>
<div id="paging"></div>