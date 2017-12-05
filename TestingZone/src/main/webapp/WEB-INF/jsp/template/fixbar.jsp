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
    ,layout: ['count','prev', 'page', 'next']
    ,count: ${contentMap.count} //数据总数，从服务端得到
    ,curr: ${contentMap.page}
    ,jump: function(obj, first){
    	if(!first){
    		var url =   window.location.pathname;
    		console.log(url);
    		if(url.indexOf("main")>-1){
    			window.location.href = "/TestingZone/main/" + obj.curr;
    		}else if(url.indexOf("plate")>-1){
    			var position = url.lastIndexOf("/")
    			var u = url.substring(0,position+1);
    			console.log(u);
    			window.location.href =  u + obj.curr;
    		}else{
				
    		}
    	}
    }
  });
});
</script>