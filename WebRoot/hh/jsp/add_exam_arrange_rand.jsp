<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <base href="<%=basePath%>">
    
    <title>'add_exam_arrange.jsp'</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		span{
			color:red;
		}
	</style>
  </head>
  
  <body>
  位置:<a href="hh/jsp/tea_manage_examarrange.jsp">我的考试</a>>>随机出卷子&nbsp;&nbsp;
   		<button onclick="window.location.href='hh/jsp/add_exam_arrange_guding.jsp'">改成固定出卷子</button>
   <br><hr>
   <fieldset>
   <form action="servlet/Add_ExamArrangeServlet" method="post">
   <input type="hidden" name="examarr_type" value="rand">
   <input type="hidden" name="tea_number" value="${tea_number }">
	<input type="text" name="examarr_name" placeholder="考试名称" autofocus="autofocus" required="required"><span> *</span><br><hr>
	<input type="text" name="examarr_descrip" placeholder="考试描述" required="required"><span> *</span><br><hr>
	<input type="datetime-local" name="start_time" placeholder="开始时间" required="required"><span> *</span><br><hr>
	<input type="datetime-local" name="end_time" placeholder="结束时间" required="required"><span> *</span><br><hr>
 	<select required="required" name="cla_number">
 		<option value="1">
 			选择班级
 		</option>
 		<option value="1">
 			班级1
 		</option>
 	</select><span> *</span>
 	<br><hr>
 	<input type="number" name="" placeholder="单选多少道" min="0">
	<input type="number" name="" placeholder="每道题多少分" min="0"><br><hr>
	<input type="number" name="" placeholder="多选多少道" min="0">
	<input type="number" name="" placeholder="每道题多少分" min="0"><br><hr>
	<input type="number" name="" placeholder="判断多少道" min="0">
	<input type="number" name="" placeholder="每道题多少分" min="0"><br><hr>
	<input type="number" name="" placeholder="程序设计多少道" min="0">
	<input type="number" name="" placeholder="每道题多少分" min="0"><br><hr>
	<input type="number" name="examarr_total_score" placeholder="总分" disabled="disabled"><br><hr>
   	<input type="submit" value="提交">
 	
   </form>
  </fieldset>
  </body>
</html>
