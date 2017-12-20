<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<link rel="shortcut icon" href="images/TestingZone-2.gif" type="image/x-icon" />
<link rel="stylesheet" href="js/layui/css/layui.css">
<style>
*{
	box-sizing: border-box;
}
body {
	color: #666;
	background-color: #f5f5f5;
}
.icon {
   width: 1em; height: 1em;
   vertical-align: -0.15em;
   fill: currentColor;
   overflow: hidden;
}
.fix_header {
	height: 60px;
	background-color: #393D49;
	color: #009688;
	border-bottom: 1px solid #404553;
	position: fixed;
	width: 100%;
	top: 0;
	z-index: 999;
}

.nav_logo {
	text-align: center;
	line-height: 60px;
	padding-top: 4px;
}

.content {
	margin-top: 61px;
}

.title {
	font-size: 16px;
	margin-left: 20px;
}

.desc {
	padding: 10px;
	-webkit-line-clamp: 2;
	line-height: 18px;
	font-size: 14px;
	text-overflow: ellipsis;
	height: 82px;
	overflow: hidden;
}
.desc *{
	font-size: 12px;
	line-height: 18px;
	padding: 0;
	margin:0;
}
.data {
	text-align: right;
	padding-right: 30px;
	margin-top:5px;
}

.foot {
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

.layui-col-md4 {
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

.tot-panel-main li {
	padding: 5px 20px;
	font-size: 14px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	color: #1AA195;
	/*list-style: decimal-leading-zero inside; */
}

li a {
	text-overflow: ellipsis;
}

.content-panel {
	margin: 10px 0;
	padding: 10px;
	background-color: #fff;
	border-bottom: 1px solid #eee;
}

.center_text {
	text-align: center;
}

.tag {
	padding: 20px;
}

h1 {
	padding: 10px;
	margin-bottom: 10px;
}

p {
	margin: 12px;
	font-size: 15px;
	line-height: 25px;
}

.light {
	background-color: #fff;
	padding: 0 15px 20px 15px;
}
.edit_title{
	display: inline-block;
	width: 100%;
	font-size: 18px;
	line-height: 27px;
	padding: 2px 10px;
	border: none;
	margin-top: 10px;
	margin-bottom: 10px;
}
.edit-panel{
	padding: 10px 20px;
}
.edit-row{
	font-size: 14px;
	height: 35px;
	line-height: 35px;
	text-align: left;
	position: relative;
}
.font-red{
	position: absolute;
	line-height: 35px;
	left: -10px;
	color: #e35b5a;
}
.edit-row .row-left{
	display: inline-block;
}
.row-left{
	min-width: 130px;
	vertical-align: middle;
}
.edit-row .row-right{
	display: inline-block;
	height: 35px;
	line-height: 35px;
	vertical-align: middle;
}
.layui-form-switch{
	box-sizing: content-box;
	margin: auto;
}
</style>