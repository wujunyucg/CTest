package com.dean.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Getconnection {
	/*private static String url=null;
	private static String username=null;
	private static String password=null;
	private static String driver=null;*/
	private static ComboPooledDataSource ds=null;
	static{
	
		try{
			/*url="jdbc:sqlserver://192.168.31.210:1433;databaseName=first";;
			username="sa";
			password="dean6405";
			driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driver);*/
			ds=new ComboPooledDataSource("Exam");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static  Connection getConnection() {
		
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("获取不到连接");
		}
		return null;
		
	}
}
