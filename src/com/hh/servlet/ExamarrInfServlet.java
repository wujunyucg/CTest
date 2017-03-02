package com.hh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dean.bean.ExamArrange;

public class ExamarrInfServlet extends HttpServlet {

	public ExamarrInfServlet() {
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
		List<ExamArrange> ealist = (List<ExamArrange>) session.getAttribute("ExamArrange");
		String position = request.getParameter("position");
//		System.out.println(ealist.get(Integer.valueOf(position).intValue()-1).getExamarr_name());
		session.setAttribute("EA", ealist.get(Integer.valueOf(position).intValue()-1));
		response.sendRedirect("../hh/jsp/ExamArrInf.jsp");
	}

	public void init() throws ServletException {

	}

}
