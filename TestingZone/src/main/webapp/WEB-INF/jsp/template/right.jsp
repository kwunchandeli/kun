<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="layui-col-md12 tot-panel">
	<h2>所有版块</h2>
	<ul class="tot-panel-main">
		<!-- <li><a href="plate/performance" target="_self">性能测试</a></li>
		<li><a href="plate/auto" target="_self">自动化测试</a></li>
		<li><a href="plate/deploy" target="_self">自动化部署</a></li> -->
		<c:forEach items="${pList}" var="plate">
			<li>
				<a href="plate/${plate.p_id}/1">${plate.p_name}</a>
			</li>
		</c:forEach>
	</ul>

</div>

<div class="layui-col-md12 tot-panel">
	<h2>热门文章</h2>
	<ol class="tot-panel-main">
		<c:forEach items="${hotArticleList}" var="article">
			<li><a href="article/${article.a_id}" target="_blank">${article.title}</a></li>
		</c:forEach>
	</ol>
</div>

<div class="layui-col-md12 tot-panel">
	<h2>网站统计</h2>
	<ul class="tot-panel-main">
		<li>建站日期 : 2017-09-28</li>
		<li>文章总数 : 10 条</li>
		<li>运行天数 : 64 天</li>
		<li>标签总数 : 9 个</li>
		<li>最后更新 : 2017-10-22</li>
		<li></li>
	</ul>
</div>

<div class="layui-col-md12 tot-panel">
	<h2>友情链接</h2>
	<ul class="tot-panel-main">
		<li><a href="http://www.layui.com" target="_blank">Layui</a></li>
		<li><a href="http://www.thinkphp.cn" target="_blank">Thinkphp</a></li>
	</ul>
</div>