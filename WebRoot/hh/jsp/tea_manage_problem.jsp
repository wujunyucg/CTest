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
    
    <title>'tea_manage_problem.jsp'</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>

</script>
  </head>
  
  <body>
  	位置:<a href="hh/jsp/tea_index.jsp">教师主页</a> >> 
  		<a href="hh/jsp/tea_manage_problemstore.jsp">我的题库</a> >> 题库详情<br><hr>
  <form action="servlet/Problem_Preview_Servlet" method="post">
	<c:if test="${prolist!=null}">
		<table border="1">
			<tbody>
				<tr>
					<th>
						选择
					</th>
					<th>
						题目号
					</th>
					<th>
						题目类型
					</th>
					<th>
						内容
					</th>
					<th>
						选项A
					</th>
					<th>
						选项B
					</th>
					<th>
						选项C
					</th>
					<th>
						选项D
					</th>
					<th>
						选项E
					</th>
					<th>
						选项F
					</th>
					<th>
						正确答案
					</th>
					<th>
						题目难度
					</th>
					<th>
						选中次数
					</th>
					<th>
						正确次数
					</th>
					<th>
						正确率
					</th>
					<th>
						编辑
					</th>
					<th>
						删除
					</th>
				</tr>
					
			<c:forEach items="${prolist }" var="prolist" varStatus="status">
				<tr>
					<th>
						<input type="checkbox" name="select_problem" value="${prolist.p_id }" />
					</th>
					<th>
						${status.count }
					</th>
					<th>
						${prolist.p_type }
					</th>
					<th>
						${prolist.p_content }
					</th>
					<th>
						${prolist.a }
					</th>
					<th>
						${prolist.b }
					</th>
					<th>
						${prolist.c }
					</th>
					<th>
						${prolist.d }
					</th>
					<th>
						${prolist.e }
					</th>
					<th>
						${prolist.f }
					</th>
					<th>
						${prolist.p_key }
					</th>
					<th>
						${prolist.p_rank }
					</th>
					<th>
						${prolist.p_hitcount }
					</th>
					<th>
						${prolist.p_rightcount }
					</th>
					<th>
						${prolist.p_rightrate }
					</th>
					<th>
						<a href="#">编辑</a>
					</th>
					<th>
						<a href="">删除</a>
					</th>
				</tr>
			</c:forEach>   
		</tbody>
	</table>
	<hr>
		<input type="submit" value="预览">
</c:if>
</form>
	<c:if test="${prolist==null }">
		<h3>没有任何题目，现在添加吗？</h3>
	</c:if>
  </body>
</html>
