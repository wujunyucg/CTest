/**
* 2015-7-25  
* AnswerDaoimpl.java 
* author:JunYu Wu 
*/
package com.dean.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.Answer;
import com.dean.bean.Notice;
import com.dean.dao.AnswerDao;
import com.dean.utils.Getconnection;

/**
 * @author asus1
 *
 */
public class AnswerDaoimpl implements AnswerDao {

	Connection conn = null;
	String sql = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public AnswerDaoimpl(){
		conn = Getconnection.getConnection();
	}
	
	public PreparedStatement getps(Answer ans,PreparedStatement ps){
		try {
			ps.setString(1,ans.getStu_Ans());
			ps.setString(2, ans.getStu_Number());
			ps.setInt(3, ans.getAns_Score());
			ps.setInt(4, ans.getP_Id());
			ps.setString(5, ans.getExamarr_Id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}
	public Answer getAnswer(ResultSet rs,Answer ans)  {
		try {
			ans.setStu_Ans(rs.getString("stu_ans"));
			ans.setStu_Number(rs.getString("stu_number"));
			ans.setAns_Score(rs.getInt("ans_score"));
			ans.setP_Id(rs.getInt("p_id"));
			ans.setExamarr_Id(rs.getString("examarr_id"));
			ans.setAns_Id(rs.getInt("ans_id"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}
	
	/* (non-Javadoc)
	 *添加答案
	 */
	@Override
	public void addAnswer(Answer answer) {
		try {
			sql="insert into  answer (stu_ans, stu_number, ans_score, p_id, examarr_id)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps=getps(answer, ps);
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
	 * 删除答案
	 */
	@Override
	public void deleteAnswer(int ans_id) {
		sql="delete from answer where ans_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ans_id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseAll.close2(conn, ps);
		}


	}

	/* (non-Javadoc)
	 * 更新答案
	 */
	@Override
	public void updateAnswer(int id, Answer answer) {
		try {
			sql = "update answer set stu_ans=?, stu_number=?, ans_score=?, p_id=?, examarr_id=? where ans_id = ?";
			ps = conn.prepareStatement(sql);
			ps = getps(answer, ps);
			ps.setInt(6, id);
			ps.execute();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * 通过学生编号和考试安排号进行查询
	 */
	@Override
	public List<Answer> findByStuNumAndExamId(String stuNumber, String examId) {
		sql = "select*from answer where stu_number = ? and examarr_id=?";
		List<Answer> list = new ArrayList<Answer>();
		Answer answer = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, stuNumber);
			ps.setString(2, examId);
			rs = ps.executeQuery();
			while(rs.next()){
				answer = new Answer();
				answer = getAnswer(rs, answer);
				list.add(answer);
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
	 * 通过学生学号进行查询
	 */
	@Override
	public List<Answer> findByStuNumber(String stuNumber) {
		sql = "select*from answer where stu_number = ?";
		List<Answer> list = new ArrayList<Answer>();
		Answer answer = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, stuNumber);
			rs = ps.executeQuery();
			while(rs.next()){
				answer = new Answer();
				answer = getAnswer(rs, answer);
				list.add(answer);
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
