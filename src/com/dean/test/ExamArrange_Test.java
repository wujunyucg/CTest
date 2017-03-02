package com.dean.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dean.bean.ExamArrange;
import com.dean.dao.ExamArrangeDao;
import com.dean.daoimpl.ExamArrangeDaoimpl;

public class ExamArrange_Test {

	@Test
	public void testFindExamArrange() throws ClassNotFoundException, SQLException
	{
		List<ExamArrange> ealist = new ArrayList<ExamArrange>();
		ExamArrangeDao eadao = new ExamArrangeDaoimpl();
		ealist = eadao.FindExamArrange("2011");
		System.out.println(ealist.get(0).getEnd_time());
	}
	
	@Test
	public void testAddExamArrange() throws ClassNotFoundException, SQLException
	{
		ExamArrange exam = new ExamArrange();
		ExamArrangeDao eadao = new ExamArrangeDaoimpl();
		exam.setExamarr_name("sssss");
		exam.setExamarr_descrip("s");
		exam.setStart_time(new Timestamp(System.currentTimeMillis()));
		exam.setEnd_time(new Timestamp(System.currentTimeMillis()));
		exam.setTea_number("2011111");
		exam.setCla_number(2222);
		exam.setExamarr_total_score(122);
		eadao.AddExamArrange(exam);
		System.out.println("---------->³É¹¦Ìí¼Ó");
	}
}
