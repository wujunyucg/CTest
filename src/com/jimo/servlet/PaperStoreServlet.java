package com.jimo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dean.bean.Problem;
import com.jimo.daoimpl.ProblemDaoimpl;

public class PaperStoreServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PaperStoreServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("question_type");
		String difficulty_degree = request.getParameter("difficulty_degree");
		System.out.println(type);
		System.out.println(difficulty_degree);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		ProblemDaoimpl pd = new ProblemDaoimpl();
		ArrayList<Problem> list = new ArrayList<Problem>();
		
		try {
			if((list = (ArrayList<Problem>) pd.FindByType(type,difficulty_degree))!=null ){
				System.out.println("enter if");
				System.out.println(list.get(0).getP_content());
				session.setAttribute("list", list);
				System.out.println("list passed");
			}else{
				System.out.println("SQL search error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("../jimo_jsp/paper_store.jsp");
		
		out.flush();
		out.close();
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
