<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>'tea_index.jsp'</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
 	
 			<button onclick="window.location.href='servlet/Find_ExamArrange?tea_number=${tea_number}'">我的考试</button>
 		
 			<button onclick="window.location.href='servlet/Find_ProblemStore_Servlet?tea_number=${tea_number}'">我的题库</button>
 		
 			<button onclick="window.location.href='servlet/Tea_login_Servlet?type=logout'">退出</button>
 		
 			老师工号:${tea_number }
 		
 	<hr>
 	<br>
  </body>
</html>
