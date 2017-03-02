package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.ProblemStore;
import com.dean.dao.ProblemStoreDao;
import com.dean.utils.Getconnection;

public class ProblemStoreDaoimpl implements ProblemStoreDao{
	Getconnection myconn = null;
	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	Statement s = null;
	List<ProblemStore> proslist = null;
	ProblemStore prosto = null;
	String sql = null;
	
	public ProblemStoreDaoimpl() throws ClassNotFoundException, SQLException
	{
		this.myconn = new Getconnection();
		this.conn = myconn.getConnection();
	}
	@Override
	public List<ProblemStore> FindProbleStore(String tea_number) {
		proslist = new ArrayList<ProblemStore>();
		sql = "select * from problemstore where tea_number='" + tea_number + "';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				prosto = new ProblemStore();
				prosto.setPs_name(rs.getString("ps_name"));
				prosto.setPs_number(rs.getString("ps_number"));
				prosto.setTea_name(rs.getString("tea_number"));
				prosto.setTea_number(tea_number);
				proslist.add(prosto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proslist;
	}

	
}
