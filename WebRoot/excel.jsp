<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>'excel.jsp'</title>
    
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
  <form action="servlet/FindByPropertyServlet" method="post" accept-charset="utf-8">
	按关键词查找:
	<select name="select">
		<option value="S_Name">
			姓名
		</option>	
		<option value="S_Number">
			学号
		</option>		
		<option value="S_Class">
			班级
		</option>	
		<option value="S_Pro">
			专业
		</option>	
		<option value="S_XueYuan">
			学院
		</option>	
		<option selected="selected" value="all">
			全部
		</option>
	</select>
	<input type="text" name="value" id="value">
   	<input type="submit" value="提交">
   </form>
  <c:if test="${list != null }">
   <table border="1">
  		<tr>
  			<td>
  				姓名
  			</td>
  			<td>
  				学号
  			</td>
  			<td>
  				密码
  			</td>
  			<td>
  				班级
  			</td>
  			<td>
  				专业
  			</td>
  			<td>
  				学院
  			</td>
  			<td>
  				性别
  			</td>
  			<td>
  				手机号
  			</td>
  			<td>
  				Email
  			</td>
  			<td>
  				QQ
  			</td>
  			<td>
  				编辑
  			</td>
  			<td>
  				删除
  			</td>
  		</tr>
  	
  	<c:forEach items="${list}" var="student">
			<tr>
				<td>
					${student.s_Name} 
				</td>
				<td>
					${student.s_Number} 
				</td>
				<td>
					${student.s_Pwd} 
				</td>	
				<td>
					${student.s_Class} 
				</td>	
				<td>
					${student.s_Pro} 
				</td>	
				<td>
					${student.s_XueYuan} 
				</td>	
				<td>
					${student.s_Sex} 
				</td>	
				<td>
					${student.s_Phone} 
				</td>	
				<td>
					${student.s_Email} 
				</td>	
				<td>
					${student.s_QQ} 
				</td>
				<td>
					<a href="servlet/">编辑</a>
				</td>	
				<td>
					<a href="servlet/DelStudentServlet?s_id=${student.s_id }">删除</a>
				</td>
			</tr>
	</c:forEach>
</table>
</c:if>
<c:if test="${list == null }">
	没货
</c:if>		
  </body>
</html>
