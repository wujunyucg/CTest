package com.hh.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dean.bean.ExamArrange;
import com.dean.dao.ExamArrangeDao;
import com.dean.daoimpl.ExamArrangeDaoimpl;

public class Add_ExamArrangeServlet extends HttpServlet {

	public Add_ExamArrangeServlet() {
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
		ExamArrange ea = new ExamArrange();
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Content-Type", "text/html; charset=UTF-8");

		String tea_number = request.getParameter("tea_number");
		String cla_number = request.getParameter("cla_number");
		String examarr_type = request.getParameter("examarr_type");
		String examarr_name = request.getParameter("examarr_name");
		String examarr_descrip = request.getParameter("examarr_descrip");
		
//		String examarr_total_score = request.getParameter("examarr_total_score");
//		String start_time = request.getParameter("start_time");
//		String end_time = request.getParameter("end_time");
		
		try {
			ExamArrangeDao eadao = new ExamArrangeDaoimpl();
			ea.setCla_number(Integer.valueOf(cla_number).intValue());
//			ea.setEnd_time(Timestamp.valueOf(end_time));
//			ea.setStart_time(Timestamp.valueOf(start_time));
			ea.setExamarr_descrip(examarr_descrip);
			ea.setExamarr_name(examarr_name);
//			ea.setExamarr_total_score(Integer.valueOf( examarr_total_score).intValue());
			ea.setExamarr_type(examarr_type);
			ea.setTea_number(tea_number);
			
			eadao.AddExamArrange(ea);
			System.out.println("--------->≤Â»ÎExamArrange≥…π¶");
			
			response.sendRedirect("../");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {

	}

}
