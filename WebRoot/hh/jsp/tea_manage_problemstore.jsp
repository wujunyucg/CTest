<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>'tea_manage_problemstore.jsp'</title>
    
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
  位置:<a href="hh/jsp/tea_index.jsp">教师主页</a> >> 我的题库
  <br><hr>
   <c:forEach items="${proslist }" var="proslist">
   <button onclick="window.location.href='servlet/Find_Problem_Servlet?ps_number=${proslist.ps_number}'">${proslist.ps_name }</button>
  </c:forEach>
  <hr>
  <button>增加题库</button>
  </body>
</html>
