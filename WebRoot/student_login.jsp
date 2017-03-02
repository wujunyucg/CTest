<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>西南交大-在线自主学习考试系统</title>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<!--Google Fonts-->
<script type="text/javascript">
	
	function reloadCode(){
			var time = new Date().getTime();
			document.getElementById("imagecode").src="kaptcha?d="+time;
		}  
</script>
</head>
<% String  student = "stu"; %>
<body>
<!--header start here-->
	<div class="login">
		 <div class="login-main">
		 		<div class="login-top">
		 			<h1>在线考试学习系统</h1>
		 			<span>
		 			<a href="teacher_login.jsp" style=" font-size:20px;" />教师</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    				<span  style=" font-size:30px;">学生</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    				<a href="admin_login.jsp" style=" font-size:20px;">管理员</a>
    				<form action="servlet/DealLoginServlet?identity=<%=student%>" method="post">
		 			<input type="text" name="number" placeholder="学号" required="">
		 			<input type="password" name="password" placeholder="密码" required="">
		 			<input id="node" type="text" name="node" value="" placeholder="验证码" required=""/>
		 			<img id="imagecode" src="kaptcha" width=160px/>
		 			<a href="javascript: reloadCode();">看不清楚</a><br><br>
		 			<input type="submit" value="登录" />
		 			</form></span>
		 		</div>
		 	</div>
  </div>
</body>
</html>