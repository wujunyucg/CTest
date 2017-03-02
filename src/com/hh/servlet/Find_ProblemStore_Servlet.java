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

import com.dean.bean.ProblemStore;
import com.dean.dao.ProblemStoreDao;
import com.dean.daoimpl.ProblemStoreDaoimpl;

public class Find_ProblemStore_Servlet extends HttpServlet {

	public Find_ProblemStore_Servlet() {
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
		List<ProblemStore> proslist = new ArrayList<ProblemStore>();
		try {
			
			ProblemStoreDao psdao = new ProblemStoreDaoimpl();
			proslist = psdao.FindProbleStore(tea_number);
			
			HttpSession session = request.getSession();
			session.setAttribute("proslist",proslist);
			response.sendRedirect("../hh/jsp/tea_manage_problemstore.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {

	}

}
