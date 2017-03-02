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

import com.dean.bean.ExamArrange;
import com.dean.dao.ExamArrangeDao;
import com.dean.daoimpl.ExamArrangeDaoimpl;

public class Find_ExamArrange extends HttpServlet {

	public Find_ExamArrange() {
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
		String tea_number = request.getParameter("tea_number");
		List<ExamArrange> list = new ArrayList<ExamArrange>();
		try {
			ExamArrangeDao examdao = new ExamArrangeDaoimpl();
			list = examdao.FindExamArrange(tea_number);
			HttpSession session = request.getSession();
			session.setAttribute("ExamArrange",list);
			response.sendRedirect("../hh/jsp/tea_manage_examarrange.jsp");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void init() throws ServletException {

	}

}
