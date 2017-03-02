package com.dean.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.dean.bean.Problem;
import com.dean.dao.ProblemDao;
import com.dean.daoimpl.ProblemDaoimpl;

public class ProblemTest {

	@Test
	public void testFindProblem()
	{
		List<Problem> prolist = new ArrayList<Problem>();
		try {
			ProblemDao prodao = new ProblemDaoimpl();
			prolist = prodao.FindProblem("1");
			Iterator<Problem> ite = prolist.iterator();
			while(ite.hasNext())
			{
				Problem p = ite.next();
				System.out.println(p.getA());
				System.out.println(p.getB());
				System.out.println(p.getC());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
