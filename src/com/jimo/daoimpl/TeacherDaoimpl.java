package com.jimo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dean.daoimpl.CloseAll;
import com.dean.utils.Getconnection;
import com.jimo.dao.TeacherDao;

public class TeacherDaoimpl implements TeacherDao{

	Connection conn=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//constructor
	public TeacherDaoimpl() {
		conn = Getconnection.getConnection();
}
	@Override
	public boolean CheckTeacherLog(String tea_number, String tea_pwd) {
			
		sql = "select *from teacher where tea_number = ? and tea_pwd = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, tea_number);
			ps.setString(2, tea_pwd);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			CloseAll.close3(conn, ps, rs);
		}
	}

}
