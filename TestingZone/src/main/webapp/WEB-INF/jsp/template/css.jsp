<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="js/layui/css/layui.css">
<style>
body {
	color: #666;
	background-color: #f5f5f5;
}
.fix_header{
	height: 60px;
	background-color: #393D49;
	color: #009688;
    border-bottom: 1px solid #404553;
    position: fixed;
    width: 100%;
    top: 0;
    z-index: 999;
} 
.nav_logo{
	text-align: center;;
	line-height: 60px;
}
.content{
	margin-top: 61px;
}
.title{
	font-size: 16px;
	margin-left: 20px;
}
.desc{
	padding: 10px;
	-webkit-line-clamp: 2;
	line-height: 25px;
	font-size: 14px;
	text-overflow: ellipsis;
	height: 70px;
	overflow: hidden;
}
.data{
	text-align: right;
	padding-right: 30px;
}
.foot{
	text-align: center;
	font-size: 14px;
	line-height: 60px;
}
.layui-body {
	left: 0;
}
.layui-layout-admin .layui-footer {
	left: 0;
	text-align: center;
}
.tot-panel {
	margin: 5px 10px;
	background-color: #fff;
}
.layui-col-md4{
	margin-top: 5px;
}
.layui-breadcrumb span {
    padding-left: 8px;
    font-family: Sim sun;
}
.tot-panel h2 {
	border-bottom: 1px dotted #E9E9E9;
	padding: 0 15px;
}

.tot-panel-main {
	padding: 10px 15px;
}
.tot-panel-main li{
	padding: 5px 20px;
	font-size: 14px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    color: #1AA195;
   /*list-style: decimal-leading-zero inside; */
}
li a{
	text-overflow: ellipsis;
}
.content-panel{
	margin:10px 0;
	padding: 10px;
	height: 123px;
	background-color: #fff;
	border-bottom: 1px solid #eee;
}
</style>