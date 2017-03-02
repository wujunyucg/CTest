/**
 * 
 */
package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *ClassName:CloseAll
 * @comment:
 * @author Zhixin Zhang
 * @date 2015年7月22日 下午3:10:49
 */
public class CloseAll {
	public static void close2(Connection conn,PreparedStatement ps){
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void close3(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			rs.close();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
