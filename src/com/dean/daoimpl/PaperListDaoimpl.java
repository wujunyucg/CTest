package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.ExamArrange;
import com.dean.bean.PaperList;
import com.dean.dao.PaperListDao;
import com.dean.utils.Getconnection;

public class PaperListDaoimpl implements PaperListDao{

	Getconnection myconn = null;
	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	Statement s = null;
	List<ExamArrange> examarr = null;
	String sql = null;

	public PaperListDaoimpl() throws ClassNotFoundException, SQLException
	{
		this.myconn = new Getconnection();
		this.conn = myconn.getConnection();
	}
	public int str2int(String str)
	{
		if(str==null) 
			return 0;
		else
			return Integer.valueOf(str).intValue();
	}
	@Override
	public List<PaperList> FindPaperList(String examarr_id) {

		List<PaperList> paperlist = new ArrayList<PaperList>();
		PaperList paper = null;
		sql = "select * from paperlist where examarr_id = '" + examarr_id + "';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				paper = new PaperList();
//				paper.setExamarr_id(Integer.valueOf(rs.getString("examarr_id")).intValue());
//				paper.setPap_list_id(Integer.valueOf(rs.getString("pap_list_id")).intValue());
				paper.setExamarr_id(str2int(rs.getString("examarr_id")));
				paper.setPap_list_id(str2int(rs.getString("pap_list_id")));
				paper.setStu_number(rs.getString("stu_number"));
				paperlist.add(paper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return paperlist;
	}

}
