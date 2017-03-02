package com.hh.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dean.bean.Problem;
import com.dean.dao.ProblemDao;
import com.dean.daoimpl.ProblemDaoimpl;

public class Find_Problem_Servlet extends HttpServlet {

	public Find_Problem_Servlet() {
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
		List<Problem> prolist = new ArrayList<Problem>();
		try {
			ProblemDao prodao = new ProblemDaoimpl();
			String ps_number = request.getParameter("ps_number");
			prolist = prodao.FindProblem(ps_number);
			
			HttpSession session = request.getSession();
			session.setAttribute("prolist",prolist);
			response.sendRedirect("../hh/jsp/tea_manage_problem.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {

	}

}
