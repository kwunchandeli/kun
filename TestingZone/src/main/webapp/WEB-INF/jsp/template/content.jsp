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

	<!-- <li class="content-panel">
		<button class="layui-btn layui-btn-mini layui-btn-warm reprint">原创</button>
		<h2 class="title">
			<a href="article/1/1">Linux下搭建Lnmp环境--Mysql安装</a>
		</h2>

		<div class="desc">MySQL是一个关系型数据库管理系统，由瑞典MySQL AB 公司开发，目前属于
			Oracle 旗下产品。MySQL 是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL是最好的 RDBMS
			(Relational Database Management System，关系数据库管理系统) 应用软件。</div>
		<div class="data">
			<span><i class="layui-icon"></i> 10-21 18:40</span> <span><i
				class="layui-icon"></i> 管理员</span>
		</div>
	</li>
	<li class="content-panel">
		<button class="layui-btn layui-btn-mini layui-btn-warm reprint">原创</button>
		<h2 class="title">
			<a href="article/1/1">Linux搭建lnmp环境--Nginx安装</a>
		</h2>

		<div class="desc">Nginx (engine x)
			是一个高性能的HTTP和反向代理服务器，也是一个IMAP/POP3/SMTP服务器。
			下面介绍如何在Linux下安装编译Nginx服务器。并如何关联php-fpm支持php。</div>
		<div class="data">
			<span><i class="layui-icon"></i> 10-19 18:37</span> <span><i
				class="layui-icon"></i> 管理员</span>
		</div>
	</li>
	<li class="content-panel">
		<button class="layui-btn layui-btn-mini layui-btn-warm reprint">原创</button>
		<h2 class="title">
			<a href="article/1/1">Linux下搭建LNMP---PHP安装</a>
		</h2>

		<div class="desc">
			虽然网上有很多lnmp/lamp一键安装包。但是作为一名php开发者，最好还是能够搭建自己的lnmp环境。
			本篇文章主要记录编译安装php过程中遇到的问题。</div>
		<div class="data">
			<span><i class="layui-icon"></i> 10-19 14:59</span> <span><i
				class="layui-icon"></i> 管理员</span>
		</div>
	</li>
	<li class="content-panel">
		<button class="layui-btn layui-btn-mini layui-btn-warm reprint">原创</button>
		<h2 class="title">
			<a href="article/1/1">Linux搭建svn服务器</a>
		</h2>

		<div class="desc">
			您可以把SVN当成您的备份服务器，更好的是，他可以帮您记住每次上传到这个服务器的档案内容。并且自动的赋予每次的变更一个版本。
			本篇文章就是以 linux centos为例讲解Linux下搭建svn服务器</div>
		<div class="data">
			<span><i class="layui-icon"></i> 16-12-11 01:02</span> <span><i
				class="layui-icon"></i>管理员</span>
		</div>
	</li> -->
</ul>
<div id="paging"></div>