package com.dean.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dean.bean.PaperList;
import com.dean.dao.PaperListDao;
import com.dean.daoimpl.PaperListDaoimpl;

public class PaperListTest {

	@Test
	public void testFindPaperList() throws ClassNotFoundException, SQLException
	{
		List<PaperList> ealist = new ArrayList<PaperList>();
		PaperListDao eadao = new PaperListDaoimpl();
		ealist = eadao.FindPaperList("2");
		System.out.println(ealist.get(1).getStu_number());
		
	}
}
