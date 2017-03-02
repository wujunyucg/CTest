package com.jimo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dean.bean.Problem;
import com.dean.utils.Getconnection;
import com.jimo.dao.SingleChoiceDao;

public class SingleChoiceDaoimpl implements SingleChoiceDao{

	Connection conn=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public SingleChoiceDaoimpl(){
		conn=Getconnection.getConnection();
	}
	public PreparedStatement getps(Problem sc){
		try {
			ps.setString(1,sc.getP_content() );
			ps.setString(2,sc.getPs_number());
			ps.setString(3, sc.getPs_name());
			ps.setString(4, sc.getP_type());
			ps.setString(5, sc.getP_course());
			ps.setString(6, sc.getP_rank());
			ps.setString(7, sc.getA());
			ps.setString(8, sc.getB());
			ps.setString(9, sc.getC());
			ps.setString(10, sc.getD());
			ps.setString(11, sc.getE());
			ps.setString(12, sc.getF());
			ps.setString(13, sc.getP_key());
			ps.setString(14, sc.getP_hitcount());
			ps.setString(15, sc.getP_rightcount());
			ps.setString(16, sc.getP_rightrate());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}
	public Problem getsc(ResultSet rs,Problem sc) throws Exception{
		sc.setP_content(rs.getString("p_content"));
		sc.setPs_number(rs.getString("ps_number"));
		sc.setPs_name(rs.getString("ps_name"));
		sc.setP_type(rs.getString("p_type"));
		sc.setP_course(rs.getString("p_course"));
		sc.setP_rank(rs.getString("p_rank"));
		sc.setA(rs.getString("A"));
		sc.setB(rs.getString("B"));
		sc.setC(rs.getString("C"));
		sc.setD(rs.getString("D"));
		sc.setE(rs.getString("E"));
		sc.setF(rs.getString("F"));
		sc.setP_key(rs.getString("p_key"));
		sc.setP_hitcount(rs.getString("p_hitcount"));
		sc.setP_rightcount(rs.getString("p_rightcount"));
		sc.setP_rightrate(rs.getString("p_rightrate"));
		return sc;
	}
	@Override
	public void add(Problem singlechoice) {
			
	}

	@Override
	public void add(List<Problem> list) {
		
	}

	@Override
	public void delete(int SP_id) {
		
	}

	@Override
	public void update(int SP_id, Problem singlechoice) throws Exception {
		
	}

	@Override
	public List<Problem> findbychapter(String SP_Chapter) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Problem> findbyrank(String SP_Rank) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
