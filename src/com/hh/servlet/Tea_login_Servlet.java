package com.hh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Tea_login_Servlet extends HttpServlet {

	public Tea_login_Servlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		String tea_number = request.getParameter("tea_number");
		if(type.equals("login"))
		{
			if(tea_number.equals("2001"))
			{
				session.setAttribute("tea_number", tea_number);
				response.sendRedirect("../hh/jsp/tea_index.jsp");
				session.removeAttribute("loginerror");
			}
			
			else
			{
				session.setAttribute("loginerror", "´íÎóµÄµÇÂ¼ºÅ»òÕßÃÜÂë");
				response.sendRedirect("../hh/jsp/tea_login.jsp");
			}
		}
		else
		{
			session.removeAttribute("tea_number");
			response.sendRedirect("../hh/jsp/tea_login.jsp");
		}
	}

	public void init() throws ServletException {

	}

}
