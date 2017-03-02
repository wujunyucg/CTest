/**
* 2015-7-27  
* ExamResultServlet.java 
* author:JunYu Wu 
*/
package com.wujunyu.imoprt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dean.bean.ExamResult;
import com.dean.daoimpl.ExamResultDaoimpl;
/**
 * @author asus1
 *
 */
public class ExamResultServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ExamResultServlet() {
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

		doPost(request, response);
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

		response.setContentType("text/html,charset=utf-8");
		String select=request.getParameter("select");
		System.out.println(select);
		List<ExamResult> list=new ArrayList<ExamResult>();
		try {
			ExamResultDaoimpl result= new ExamResultDaoimpl();
			
			if(select.equals("S_Number")){
				list=result.findByExamArr(2,true,false,false);
			}
			else if(select.equals("S_up")){
				list=result.findByExamArr(2,false,true,false);
			}else if(select.equals("S_down")){
				list=result.findByExamArr(2,false,false,true);
			}
			
			request.getSession().setAttribute("examresult", list);
			response.sendRedirect("../wujunyu/view.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
