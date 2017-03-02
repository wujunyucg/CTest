<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>'UpdateExamArr.jsp'</title>
    
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
    位置:<a href="hh/jsp/tea_index.jsp">教师主页</a> >> <a href="hh/jsp/tea_manage_examarrange.jsp">我的考试</a> >> 修改考试信息
     <form>
     <fieldset>
     	考试名称:<input type="text" value="${EA.examarr_name }">
     	<hr>
     	教师工号:<input type="text" value="${EA.tea_number }" disabled="disabled">
     	<hr>
     	考试描述:<input type="text" value=" ${EA.examarr_descrip }">
     	<hr>
     	面向班级:<input type="text" value=" ${EA.cla_number }">
     	<hr>
     	开始时间:<input type="text" value="${EA.start_time }">
     	<hr>
     	结束时间:<input type="text" value="${EA.end_time }">
     	<hr>
     	 <input type="submit" value="确定">
     </fieldset>
    
     </form>
  </body>
</html>
