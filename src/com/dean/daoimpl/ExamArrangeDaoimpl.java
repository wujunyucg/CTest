package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.ExamArrange;
import com.dean.dao.ExamArrangeDao;
import com.dean.utils.Getconnection;

public class ExamArrangeDaoimpl implements ExamArrangeDao{

	Getconnection myconn = null;
	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	Statement s = null;
	List<ExamArrange> examarr = null;
	String sql = null;
	
	public ExamArrangeDaoimpl() throws ClassNotFoundException, SQLException
	{
		this.myconn = new Getconnection();
		this.conn = myconn.getConnection();
	}
	public int string2int(String a)
	{
		// 如果是空的，直接返回0就行了。
		if(a==null)
		{
			return 0;
		}
		return Integer.valueOf(a).intValue();
	}
	public ExamArrange RStoExamArrange(ResultSet rs,ExamArrange ea)
	{
		
		try {
			
			/* 以下是从结果ResultSet中取出字段赋值给ExamArrange对象的过程
			 * 
			 * 在赋值的时候还要判断是否为空，是空的再进行数据类型的转换就会报错
			 */
			ea.setCla_number(string2int(rs.getString("cla_number")));
//			ea.setEnd_time(rs.getString("end_time"));
			ea.setEnd_time(rs.getTimestamp("end_time"));
			ea.setExamarr_descrip(rs.getString("examarr_descrip"));
			ea.setExamarr_id(string2int(rs.getString("examarr_id")));
			ea.setExamarr_name(rs.getString("examarr_name"));
			ea.setExamarr_total_score(string2int(rs.getString("examarr_total_score")));
			ea.setExamarr_type(rs.getString("examarr_type"));
			ea.setJ_number(string2int(rs.getString("j_number")));
			ea.setJ_sin_score(string2int(rs.getString("j_sin_score")));
			ea.setM_number(string2int(rs.getString("m_number")));
			ea.setM_sin_score(string2int(rs.getString("m_sin_score")));
			ea.setP_number(string2int(rs.getString("p_number")));
			ea.setP_sin_score(string2int(rs.getString("p_sin_score")));
			ea.setS_number(string2int(rs.getString("s_number")));
			ea.setS_sin_score(string2int(rs.getString("s_sin_score")));
//			ea.setStart_time(rs.getString("start_time"));
			ea.setStart_time(rs.getTimestamp("start_time"));
		
			ea.setTea_number(rs.getString("tea_number"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ea;
	}
	@Override
	public List<ExamArrange> FindExamArrange(String tea_number) {
		ExamArrange ea = null;
		List<ExamArrange> ealist = new ArrayList<ExamArrange>();
		sql = "select * from examarrange where tea_number = '" + tea_number 
				+ "';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				ea = new ExamArrange();
				ea = RStoExamArrange(rs, ea);
				ealist.add(ea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ealist;
	}
	
	public String sql(ExamArrange ea)
	{
		String sql = "insert into examarrange(examarr_name,examarr_descrip,"
				+ "tea_number,examarr_type,cla_number,start_time,end_time,"
				+ "s_number,s_sin_score,m_number,m_sin_score,j_number,"
				+ "j_sin_score,p_number,p_sin_score,examarr_total_score) values('"
				+ ea.getExamarr_name() +"','" + ea.getExamarr_descrip() + "','" 
				+ ea.getTea_number() + "','" + ea.getExamarr_type() + "','"
				+ ea.getCla_number() + "','" + ea.getStart_time() + "','"
				+ ea.getEnd_time() + "','" + ea.getS_number() + "','"
				+ ea.getS_sin_score() + "','" + ea.getM_number() + "','"
				+ ea.getM_sin_score() + "','" + ea.getJ_number() + "','"
				+ ea.getJ_sin_score() + "','" + ea.getP_number() + "','"
				+ ea.getP_sin_score() + "','" + ea.getExamarr_total_score() + "');";
		return sql;
	}
	@Override
	public void AddExamArrange(ExamArrange ea) {
//		sql = sql(ea);
		sql = "insert into examarrange(examarr_name,examarr_descrip,tea_number,cla_number,examarr_type)"
				+ " values('" + ea.getExamarr_name() + "','"+ea.getExamarr_descrip() + "','"
				+ ea.getTea_number() + "','" + ea.getCla_number() + "','" + ea.getExamarr_type() + "');";
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void DelExamArrange(int examarr_id) {
		
	}

}
