package com.jr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dean.bean.Class;
import com.jr.dean.TeacherDaoImpl;

/** 
 * @author ShengRong Ji 
 * @version 创建时间：2015-7-27 下午5:14:11 
 */

public class ShowTeacherClass extends HttpServlet {

	public ShowTeacherClass() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tea_number = request.getParameter("tea_number");
		List<Class> cla = new ArrayList<Class>();
		cla = new TeacherDaoImpl().getClass(tea_number);
		HttpSession session = request.getSession();
		session.setAttribute("cla", cla);
		response.sendRedirect("../jishengrongJsp/teacherClass.jsp");
	}

	public void init() throws ServletException {
	}

}
