<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- <script src="js/jquery-3.2.1.min.js"></script> -->
<script src="js/layui/layui.js"></script>

<script type="text/javascript">

	layui.use('util', function() {
		var util = layui.util;

		//执行
		util.fixbar({
			bar1 : '&#xe621',
			click : function(type) {
				console.log(type);
				if (type === 'bar1') {
					alert('点击了bar1')
				}
			}
		});
	});
</script>