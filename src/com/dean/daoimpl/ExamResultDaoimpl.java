/**
* 2015-7-27  
* ExamResultDaoimpl.java 
* author:JunYu Wu 
*/
package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;

import com.dean.bean.ExamArrange;
import com.dean.bean.ExamResult;
import com.dean.bean.Notice;
import com.dean.dao.ExamResultDao;
import com.dean.utils.Getconnection;

/**
 * @author asus1
 *
 */
public class ExamResultDaoimpl implements ExamResultDao {

	Getconnection myconn = null;
	Connection conn = null;
	PreparedStatement ps=null;
	ResultSet rs = null;
	Statement s = null;
	String sql = null;
	
	public ExamResultDaoimpl() throws ClassNotFoundException, SQLException
	{
		this.myconn = new Getconnection();
		this.conn = myconn.getConnection();
	}
	
	public ExamResult RStoExamResult(ResultSet rs,ExamResult er)
	{
		
		try {
			
			/* 以下是从结果ResultSet中取出字段赋值给ExamResult对象的过程
			 * 
			 * 在赋值的时候还要判断是否为空，是空的再进行数据类型的转换就会报错
			 */
			er.setExamarr_id(rs.getInt("examarr_id"));
			er.setExamres_id(rs.getInt("examres_id"));
			er.setJ_score(rs.getInt("j_score"));
			er.setM_score(rs.getInt("m_score"));
			er.setP_score(rs.getInt("p_score"));
			er.setS_score(rs.getInt("s_score"));
			er.setStu_number(rs.getString("stu_number"));
			er.setTotal_score(rs.getInt("total_score"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return er;
	}
	
	public PreparedStatement getps(PreparedStatement ps,ExamResult er)
	{
		
		try {
			ps.setInt(1,er.getExamarr_id() );
			ps.setInt(2,er.getS_score() );
			ps.setInt(3,er.getM_score() );
			ps.setInt(4,er.getP_score() );
			ps.setInt(5,er.getJ_score() );
			ps.setInt(6,er.getTotal_score() );
			ps.setString(7,er.getStu_number() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}
	
	/* (non-Javadoc)
	 * 根据考试安排号查找学生考试成绩
	 */
	@SuppressWarnings("null")
	public List<ExamResult> findByExamArr(int examArr_Id,boolean stu,boolean up,boolean down) {
		sql="select * from examresult where examarr_id = ?";
		if(stu==true){
			sql+=" order by stu_number asc";
		}
		else if(up==true){
			sql+=" order by  total_score asc";
		}
		else if(down==true){
			sql+=" order by  total_score desc";
		}
		ExamResult examResult =null;
		List<ExamResult> list = new ArrayList<ExamResult>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,examArr_Id );
			rs = ps.executeQuery();
			while(rs.next()){
				 examResult = new ExamResult();
				examResult = RStoExamResult(rs, examResult);		
				list.add(examResult);
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

	/* (non-Javadoc)
	 * 修改学生考试成绩
	 */
	@Override
	public void updateExamResult(ExamResult examResult) {
		try {
			sql = "update examresult set examarr_id=?,s_score=?,m_score=?,p_score=?,j_score=?,total_score=?  stu_number=?where examres_id = ?";
			ps = conn.prepareStatement(sql);
			ps = getps(ps, examResult);
			ps.setInt(8, examResult.getExamres_id());
			ps.execute();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * 删除学生考试成绩
	 */
	@Override
	public void deleteExamResule(int examres_id) {
		sql="delete from examresult where examres_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, examres_id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseAll.close2(conn, ps);
		}

	}

	/* (non-Javadoc)
	 * 添加学生考试成绩
	 */
	@Override
	public void addExamResult(ExamResult examResult) {
		try {
			sql="insert into  examresult (examarr_id,s_score,m_score,p_score,j_score,total_score,stu_number)values(?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps=getps(ps, examResult);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseAll.close2(conn, ps);
			System.out.println("finally");
		}

	}
	

}
