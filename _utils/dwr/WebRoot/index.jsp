<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<!-- 此处dwr/dwrjs/engine.js和web.xml配置的/dwr/dwrjs/* 相对应 -->
<script type="text/javascript" src="dwr/dwrjs/engine.js"></script>
<script type="text/javascript" src="dwr/dwrjs/util.js"></script>
<!-- DwrResponse为类名，与dwr.xml中javascript="DwrResponse"对应 -->
<script type="text/javascript" src="dwr/dwrjs/interface/dwr_push.js"></script>

<script type="text/javascript">
$(function() {
	//这个方法用来启动该页面的ReverseAjax功能
	dwr.engine.setActiveReverseAjax(true);
	//设置在页面关闭时，通知服务端销毁会话
	dwr.engine.setNotifyServerOnPageUnload(true);
	
	$("#submit").click(function() {
		dwr_push.msg($("#text").val());
		$("#text").val("");
	});
});
	
//这个函数是提供给后台推送的时候 调用的
function sendDwrMsg(msg) {
	msg = decodeURI(msg);
	$("#content").html(function() {
		return $(this).html()+"<br />"+msg;
	});
}
</script>
</head>
<body>
	<div id="content"></div>
	<input type="text" id="text"/>
	<button id="submit">提交</button>
</body>
</html>