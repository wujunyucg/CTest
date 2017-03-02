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
    
    <title>'ExamArrInf.jsp'</title>
    
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
  位置:<a href="hh/jsp/tea_index.jsp">教师主页</a> >> <a href="hh/jsp/tea_manage_examarrange.jsp">我的考试</a> >> 考试信息
  <br><hr>
  <fieldset> ${EA.examarr_name}
  <hr>
  ${EA.tea_number }
  <hr>
  ${EA.examarr_descrip }
  <hr>
  ${EA.cla_number }
  <hr>
  ${EA.start_time }
  <hr>
  ${EA.end_time }
  <hr>
  
  <button onclick="window.location.href='hh/jsp/UpdateExamArr.jsp'">修改</button>
  
  <button onclick="window.location.href='servlet/Del_ExamarrServlet'">删除</button>
  
  </fieldset>
  
  </body>
</html>
