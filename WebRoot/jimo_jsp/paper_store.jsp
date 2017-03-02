<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.jimo.daoimpl.ProblemDaoimpl"%>
<%@ page  import="com.jimo.dao.ProblemDao"%>
<%@ page import="com.dean.bean.Problem" %>
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
	<script type="text/javascript" src="jimo_js/paper_store.js"></script>
	<script type="text/javascript" src="jimo_js/edit.js"></script>
  </head>
  <% request.setCharacterEncoding("utf-8"); %>
  <body>
<h1 align="center">Welcome Teacher</h1>
<hr>
<div>
		<div id="left">
			<a href="jimo_jsp/tea_main_face.jsp">返回主页>>题库页面</a><br/><br/>
			<h3>题库名称</h3>
		</div>
		<div id="right">
			<div id="right_up">
				<br/><br/>
				<form action="servlet/PaperStoreServlet" method="post">
					<strong>题目类型:</strong>
					<select name="question_type">
						<option value="单选">单选题</option>
						<option value="多选">多选题</option>
						<option value="判断">判断题</option>
						<option value="程序设计">程序设计题</option>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<strong>题目难度：</strong>
					<select name="difficulty_degree">
						<option value="2">简单</option>
						<option value="5">容易</option>
						<option value="10">难</option>
					</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="执行查询"/>
				</form>
			</div>
			<div id="right_down">
				Right_Down
			 <c:if test="${ list != null}">
					yes
			<table>
				<tr>
					<th>内容</th><th>编号</th><th>名称</th><th>类型</th><th>课程
						</th><th>难度</th><th>A</th><th>B</th><th>C</th><th>D</th><th>编辑</th><th>删除</th>
				</tr>
					<c:forEach items="${ list }" var="problem">
						<tr>
							<td>${problem.getP_content() }</td><td>${problem.getPs_number() }</td><td>${problem.getPs_name() }</td><td>${problem.getP_type() }</td>
							<td>${ problem.getP_course()}</td><td>${ problem.getP_rank() }</td><td>${problem.getA() }</td><td>${problem.getB() }</td>
							<td>${problem.getC() }</td><td>${problem.getD() }</td><td><button onclick="edit_child()">编辑</button></td><td>删除</td>
						</tr>
					</c:forEach>
			</table>
				</c:if>
				<c:if test="${  list == null  }">
					<h1>No acess</h1>
				</c:if> 
				<h1 id="h1"></h1>
			</div>
		</div>
</div>
  </body>
</html>
