<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'view.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	/*function export(){
									//获取后台传递参数 className  methodName
									var className = $('#examresult').datagrid('getData').className;
									var methodName = $('#examresult').datagrid('getData').methodName;
									
									//获取表头信息
									var header = $('#t_student').datagrid('options').columns[0];
									var fields = "";
									var titles = "";
									for(var i = 0;i<header.length;i++){
										var field = header[i].field;
										var title = header[i].title;
										var hiddenFlag = header[i].hidden;
										if(!hiddenFlag){
											var dh = i == (header.length -1) ? "" :",";
											fields = fields + field + dh;
											titles = titles + title + dh;
										}
									}
									//向后台发送请求  
									var form = $("<form>");//定义一个form表单
									form.attr('style','display:none');
									form.attr('target','');
									form.attr('method','post');
									form.attr('action','student-export');
									//添加input
									var input1 = $("<input>");
									input1.attr('type','hidden');
									input1.attr('name','fields');
									input1.attr('value',fields);
									
									var input2 = $("<input>");
									input2.attr('type','hidden');
									input2.attr('name','titles');
									input2.attr('value',titles);
									
									var input3 = $("<input>");
									input3.attr('type','hidden');
									input3.attr('name','className');
									input3.attr('value',className);
									
									var input4 = $("<input>");
									input4.attr('type','hidden');
									input4.attr('name','methodName');
									input4.attr('value',methodName);
									
									//将表单放到body中
									$('body').append(form);
									form.append(input1);
									form.append(input2);
									form.append(input3);
									form.append(input4);
									form.submit();//提交表单
									
								}*/
	</script>
  </head>
  
  <body>
   
     <form id="score" action="servlet/ExamResultServlet" method="post" accept-charset="utf-8">
	按关键词排序:
	<select name="select" name="select" >
		<option value="S_Number" selected="selected">
			学号
		</option>			
		<option value="S_up">
			成绩升序
		</option>	
		<option  value="S_down">
			成绩降序
		</option>
	</select>
	<input type="submit" value="提交">
	</form>

    <table  border="1" id="examresult">
    	<tr>
    		<td>学号</td>
    		<td>单选</td>
    		<td>多选</td>
    		<td>判断</td>
    		<td>编程</td>
    		<td>总分</td>
    	</tr>
    	<c:if test="${examresult != null }">
    	<c:forEach items="${examresult}" var="result">
    	<tr>
    		<td>${result.getStu_number() }</td>
    		<td>${result.getS_score() }</td>
    		<td>${result.getM_score() }</td>
    		<td>${result.getJ_score() }</td>
    		<td>${result.getP_score() }</td>
    		<td>${result.getTotal_score() }</td>
    	</tr>
    </c:forEach>
    </c:if>
    </table>

<c:if test="examresult==null">dfds</c:if>
  </body>
</html>
