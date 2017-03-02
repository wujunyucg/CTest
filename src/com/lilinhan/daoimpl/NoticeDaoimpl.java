/**
 * 
 */
package com.lilinhan.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.Notice;
import com.dean.utils.Getconnection;
import com.lilinhan.dao.NoticeDao;

/**
 *ClassName:NoticeDaoimpl
 * @comment:通知数据库操作
 * @author Linhan Li
 * @date 2015年7月26日
 */
public class NoticeDaoimpl implements NoticeDao{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement s = null;
	Notice not = null;
	List<Notice> list = null;
	String sql = null;
	
	public NoticeDaoimpl()
	{
		this.conn = Getconnection.getConnection();
	}

	public PreparedStatement PSset(PreparedStatement ps,Notice not)
	{
			try {
				ps.setString(1, not.getTea_number());
				ps.setString(2, not.getTea_name());
				ps.setString(3, not.getCla_number());
				ps.setString(4, not.getNotice_content());
				ps.setString(5, not.getNotice_title());
				ps.setString(6, not.getNotice_time());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ps;
	}
	
	// 从resultset中给student赋值，返回student
	public Notice RSGet(ResultSet rs,Notice not)
	{
			try {
				not.setTea_number(rs.getString(1));
				not.setNotice_id(rs.getInt(2));
				not.setTea_name(rs.getString(3));
				not.setCla_number(rs.getString(4));
				not.setNotice_content(rs.getString(5));
				not.setNotice_title(rs.getString(6));
				not.setNotice_time(rs.getString(7));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return not;
	}
	
	@Override
	public void AddNotice(Notice not) {
		sql = "insert into notice(tea_number,tea_name,cla_number,notice_content,"
				+ "notice_title,notice_time) values(?,?,?,?,?,?);";
			try {
				ps = conn.prepareStatement(sql);
				PSset(ps,not);
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	@Override
	public void UpdateNoticeById(int id) {
	//		  update Notice
		sql = "update notice set cla_number=?,notice_content=?,notice_title=?,"
				+ "notice_time=? Where notice_id='" + id + "';";
		try {
			ps = conn.prepareStatement(sql);
			PSset(ps, not);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void UpdateNotice(Notice not) {
	//		  update Notice
		sql = "update notice set cla_number=?,notice_content=?,notice_title=?,"
				+ "notice_time=? Where notice_id='" + not.getNotice_id() + "';";
		try {
			ps = conn.prepareStatement(sql);
			PSset(ps, not);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Notice> FindNoticeByProperty(String property, String value) {
		list = new ArrayList<Notice>();
		sql = "select * from notice where " + property +"='"+value+"';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				not = new Notice();
				list.add(RSGet(rs, not));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Notice FindNoticeById(int id){
		sql = "select * from notice where notice_id='" + id + "';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				not = new Notice();
				not = RSGet(rs,not);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return not;
	}
	
	@Override
	public List<Notice> FindNoticeByClass(String clazz) {
		return FindNoticeByProperty("cla_number", clazz);
	}
	
	@Override
	public List<Notice> FindNoticeByteaNumber(String number) {
		return FindNoticeByProperty("tea_number", number);
	}
	
	@Override
	public List<Notice> FindNoticeByTitle(String title) {
		return FindNoticeByProperty("notice_title", title);
	}
	
	@Override
	public List<Notice> FindAllNotice() {
		list = new ArrayList<Notice>();
		sql = "select * from notice;";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				not = new Notice();
				list.add(RSGet(rs, not));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void DeleteNoticeById(int id) {
		sql = "delete from notice where notice_id=" + id + ";";
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void DeleteNotice(Notice not) {
		sql = "delete from notice where notice_id=" + not.getNotice_id() + ";";
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
