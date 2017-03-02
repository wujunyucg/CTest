<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tea_main_face.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="jimo_css/tea_main_face.css">

  </head>
  
  <body>
<h1 align="center">Welcome Teacher</h1>
<hr>
<div>
		<div id="left">
			<h3>我的题库</h3>
			<a href="jimo_jsp/paper_store.jsp">题库名称</a><br/><br/>
			<a href="">新增题库</a>
		</div>
		<div id="right">
			<div id="right_up">
				Right_Up
			</div>
			<div id="right_down">
				Right_Down
			</div>
		</div>
</div>
  </body>
</html>
