package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.Problem;
import com.dean.dao.ProblemDao;
import com.dean.utils.Getconnection;

public class ProblemDaoimpl implements ProblemDao{

	Getconnection myconn = null;
	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	Statement s = null;
	List<Problem> prolist = null;
	Problem pro = null;
	String sql = null;

	public ProblemDaoimpl() throws ClassNotFoundException, SQLException
	{
		this.myconn = new Getconnection();
		this.conn = myconn.getConnection();
	}
	
	// 从ResultSet中取字段赋值到Problem中
	public Problem RStoProblem(ResultSet rs,Problem pro)
	{
		try {
			pro.setA(rs.getString("A"));
			pro.setB(rs.getString("B"));
			pro.setC(rs.getString("C"));
			pro.setD(rs.getString("D"));
			pro.setE(rs.getString("E"));
			pro.setF(rs.getString("F"));
			pro.setP_content(rs.getString("p_content"));
			pro.setP_course(rs.getString("p_course"));
			pro.setP_hitcount(rs.getString("p_hitcount"));
			pro.setP_id(Integer.valueOf(rs.getString("p_id")));
			pro.setP_key(rs.getString("p_key"));
			pro.setP_rank(rs.getString("p_rank"));
			pro.setP_rightcount(rs.getString("p_rightcount"));
			pro.setP_rightrate(rs.getString("p_rightrate"));
			pro.setP_type(rs.getString("p_type"));
			pro.setPs_name(rs.getString("ps_name"));
			pro.setPs_number(rs.getString("ps_number"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
	@Override
	public List<Problem> FindProblem(String ps_number) {

		prolist = new ArrayList<Problem>();
		sql = "select * from problem where ps_number = '" + ps_number + "';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				pro = new Problem();
				pro = RStoProblem(rs, pro);
				prolist.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prolist;
	}

	@Override
	public Problem FindProblemByP_id(String p_id) {
		sql = "select * from problem where p_id='" + p_id + "';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				pro = new Problem();
				pro = RStoProblem(rs,pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}

}
