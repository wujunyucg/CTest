/**
* 2015-7-25  
* NoticeDaoimpl.java 
* author:JunYu Wu 
*/
package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.Notice;
import com.dean.dao.NoticeDao;
import com.dean.utils.Getconnection;

/**
 * @author asus1
 *
 */
public class NoticeDaoimpl implements NoticeDao {

	Connection conn = null;
	String sql = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public NoticeDaoimpl(){
		conn = Getconnection.getConnection();
	}
	
	public PreparedStatement getps(Notice not,PreparedStatement ps){
		try {
			ps.setString(1,not.getTea_Number() );
			ps.setString(2, not.getTea_Name());
			ps.setString(3, not.getCla_Number());
			ps.setString(4, not.getNotice_Content());
			ps.setString(5, not.getNotice_Title());
			ps.setTimestamp(6, not.getNotice_Time());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}
	public Notice getNotice(ResultSet rs,Notice not)  {
		try {
			not.setTea_Number(rs.getString("tea_number"));
			not.setCla_Number(rs.getString("cla_number"));
			not.setNotice_Content(rs.getString("notice_content"));
			not.setNotice_Id(rs.getInt("notice_id"));
			not.setNotice_Time(rs.getTimestamp("notice_time"));
			not.setNotice_Title(rs.getString("notice_title"));
			not.setTea_Name(rs.getString("tea_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return not;
	}
	
	/* (non-Javadoc)
	 * 增加通知
	 */
	@Override
	public void addNotice(Notice notice) {
		try {
			sql="insert into  notice (tea_number,tea_name,cla_number,notice_content,notice_title,notice_time)values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps=getps(notice, ps);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseAll.close2(conn, ps);
			System.out.println("finally");
		}
		

	}

	/* (non-Javadoc)
	 * 通过id删除通知
	 */
	@Override
	public void deleteNotice(int notice_Id) {
		sql="delete from notice where notice_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, notice_Id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseAll.close2(conn, ps);
		}

	}

	/* (non-Javadoc)
	 * 更新通知
	 */
	@Override
	public void updateNotice(int id,Notice notice) {
		try {
			sql = "update notice set tea_number=?,tea_name=?,cla_number=?,notice_content=?,notice_title=?,notice_time=?  where notice_id = ?";
			ps = conn.prepareStatement(sql);
			ps = getps(notice, ps);
			ps.setInt(7, id);
			ps.execute();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * 通过教师编号查询通知
	 */
	@Override
	public List<Notice> findNoticeByTeacherNumber(String number) {
		sql = "select*from notice where tea_number = ?";
		List<Notice> list = new ArrayList<Notice>();
		Notice notice = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, number);
			rs = ps.executeQuery();
			while(rs.next()){
				notice = new Notice();
				notice = getNotice(rs, notice);
				list.add(notice);
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
