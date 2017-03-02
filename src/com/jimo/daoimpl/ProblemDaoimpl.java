package com.jimo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.Problem;
import com.dean.daoimpl.CloseAll;
import com.dean.utils.Getconnection;
import com.jimo.dao.ProblemDao;

public class ProblemDaoimpl implements ProblemDao{
	Connection conn=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public ProblemDaoimpl(){
		conn=Getconnection.getConnection();
	}
	public PreparedStatement getps(Problem pb){
		try {
			ps.setString(1,pb.getP_content() );
			ps.setString(2,pb.getPs_number());
			ps.setString(3, pb.getPs_name());
			ps.setString(4, pb.getP_type());
			ps.setString(5, pb.getP_course());
			ps.setString(6, pb.getP_rank());
			ps.setString(7, pb.getA());
			ps.setString(8, pb.getB());
			ps.setString(9, pb.getC());
			ps.setString(10, pb.getD());
			ps.setString(11, pb.getE());
			ps.setString(12, pb.getF());
			ps.setString(13, pb.getP_key());
			ps.setString(14, pb.getP_hitcount());
			ps.setString(15, pb.getP_rightcount());
			ps.setString(16, pb.getP_rightrate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	public Problem getpb(ResultSet rs,Problem pb) throws Exception{
		pb.setP_content(rs.getString("p_content"));
		pb.setPs_number(rs.getString("ps_number"));
		pb.setPs_name(rs.getString("ps_name"));
		pb.setP_type(rs.getString("p_type"));
		pb.setP_course(rs.getString("p_course"));
		pb.setP_rank(rs.getString("p_rank"));
		pb.setA(rs.getString("A"));
		pb.setB(rs.getString("B"));
		pb.setC(rs.getString("C"));
		pb.setD(rs.getString("D"));
		pb.setE(rs.getString("E"));
		pb.setF(rs.getString("F"));
		pb.setP_key(rs.getString("p_key"));
		pb.setP_hitcount(rs.getString("p_hitcount"));
		pb.setP_rightcount(rs.getString("p_rightcount"));
		pb.setP_rightrate(rs.getString("p_rightrate"));
		return pb;
	}
	@Override
	public void add(Problem problem) {
		
	}
	@Override
	public void add(List<Problem> list) {
		
	}
	@Override
	public void delete(int SP_id) {
		
	}
	@Override
	public void update(int SP_id, Problem problem) throws Exception {
		
	}
	@Override
	public List<Problem> FindByType(String p_type,String d_degree) throws Exception {
		List<Problem> list = null;
		Problem pb = null;
		try{
			sql = "select * from problem where p_type=? and p_rank=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, p_type);
			ps.setString(2, d_degree);
			rs = ps.executeQuery();
			list = new ArrayList<Problem>();
			while(rs.next()){
				pb = new Problem();
				pb = getpb(rs, pb);
				list.add(pb);
			}
		}finally{
			System.out.println("finally excute");
			CloseAll.close3(conn, ps, rs);
		}
		return list;
	}
	
	public static void main(String []args){
		
		ProblemDaoimpl pd = new ProblemDaoimpl();
		ArrayList<Problem> list = new ArrayList<Problem>();
		try {
			list = (ArrayList<Problem>) pd.FindByType("µ¥Ñ¡","¼òµ¥");
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
