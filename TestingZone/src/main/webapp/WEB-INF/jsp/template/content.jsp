<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>

<blockquote class="layui-elem-quote"
	style="margin-top: 5px;margin-bottom: 0px;">
	<span class="layui-breadcrumb" style="visibility: visible;"> <a
		href="main/1"><cite>首页</cite></a> <span class="layui-box">&gt;</span><cite>文章列表</cite>
	</span>
</blockquote>

<ul class="layui-col-md12">

	<c:forEach items="${contentMap.aList}" var="article">
		<li class="content-panel">
			<h2 class="title">
				<a href="article/${article.a_id}" target="_blank">${article.title}</a>
			</h2>
			<h2 id="a_id" style="display: none;">${article.a_id}</h2>
			<div class="desc">${article.content}</div>
			<div class="data">
				<span><i class="layui-icon"></i> <fmt:formatDate
						value="${article.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></span> 
						<span>By</span>
						<span><i
					class="layui-icon"></i> ${article.u_name}</span>
			</div>
		</li>
	</c:forEach>
</ul>
<div id="paging"></div>