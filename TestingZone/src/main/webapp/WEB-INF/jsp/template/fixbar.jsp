<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<ul class="layui-fixbar">
	<li class="layui-icon" lay-type="bar1"></li>
	<li class="layui-icon layui-fixbar-top" lay-type="top"
		style="display: none;"></li>
</ul>
<!-- <script src="js/jquery-3.2.1.min.js"></script> -->
<script src="js/layui/layui.js"></script>

<script type="text/javascript">
layui.use('laypage', function(){
  var laypage = layui.laypage;
  
  //执行一个laypage实例
  laypage.render({
    elem: 'paging' //注意，这里的 test1 是 ID，不用加 # 号
    ,count: 13 //数据总数，从服务端得到
    ,curr: 1
    ,jump: function(obj, first){
    	
    }
  });
});
</script>