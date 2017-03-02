package com.jimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dean.bean.Student;
import com.jimo.daoimpl.TeacherDaoimpl;

public class DealLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DealLoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		/*获取验证码信息*/
		String kaptchaExpected = (String)request.getSession() .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		String kaptchaReceived = request.getParameter("node"); 
	    
	    //获取学号，密码
	    String number = request.getParameter("number");
	    String password = request.getParameter("password");
	    Student stu = new Student();
	    stu.setStu_number(number);
	    stu.setStu_pwd(password);
	//    StudentDaoimpl stuDao = new StudentDaoimpl();
	    
	    /*获取身份*/
	    String identity = request.getParameter("identity");
	    System.out.println(identity);
	    if (kaptchaReceived == null || kaptchaReceived.equalsIgnoreCase(kaptchaExpected)){
		      System.out.println("pic_code passed");
		      
		      //学生
		      //if(identity!=null&&identity.equals(""))
		      if(identity.equals("stu")){
		    	  System.out.println("Students OK");
		    	  System.out.println(stu.getStu_number() + stu.getStu_pwd());
		    	  
		    	  
		    	  //首先判断学生是否存在
		    	/*  if(stuDao.CheckIfStudentExist(stu)){
		    		  System.out.println("Stu Exist");

		    		  //然后看密码是否正确
		    		  if(stuDao.CheckIfStudentLogPassed(stu)){
		    			  System.out.println("Stu passed");
		    			  
		    		  }else{
		    			  response.setContentType("text/html; charset=UTF-8");
		    				PrintWriter out = response.getWriter();
		    				out.flush();
		    				out.println("<script>");
		    				out.println("alert('账户或密码错误');");
		    				out.println("history.back();");
		    				out.println("</script>");		
		    			  System.out.println("stu not passed");
		    		  }
		    	  }else{
		    		  System.out.println("Stu Not Exist");
		    	  }*/
		      }
		      
		      //老师
		      if(identity.equals("teacher")){
		    	  System.out.println("teacher OK");
		    	  TeacherDaoimpl teaDaoI = new TeacherDaoimpl();
		    	  
		    	  if(teaDaoI.CheckTeacherLog(number, password)){
		    		  	response.sendRedirect("../jimo_jsp/tea_main_face.jsp");
		    	  }else{
		    		  System.out.println(" tea not passed");
		    		  response.sendRedirect("../teacher_login.jsp");
		    	  }
		      }
		      
		      //管理员
		      if(identity.equals("admin")){
		    	  System.out.println("Admin");
		      }
	    }
	    else {
	      System.out.println("验证码错误");
	    }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
