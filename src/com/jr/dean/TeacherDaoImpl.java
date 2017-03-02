package com.jr.dean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dean.bean.Class;
import com.dean.bean.Student;
import com.dean.bean.Teacher;
import com.dean.utils.Getconnection;

/** 
 * @author ShengRong Ji 
 * @version 创建时间：2015-7-26 下午3:53:36 
 */

public class TeacherDaoImpl implements TeacherDao{
	Connection conn=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public TeacherDaoImpl(){
		conn=Getconnection.getConnection();
	}
	public PreparedStatement getps(Student student,PreparedStatement ps) throws SQLException{
		ps.setString(1, student.getStu_name());
		ps.setString(2, student.getStu_number());
		ps.setString(3, student.getStu_pwd());
		ps.setString(4, student.getStu_class());
		ps.setString(5, student.getStu_pro());
		ps.setString(6, student.getStu_sex());
		ps.setString(7, student.getStu_email());
		ps.setString(8, student.getStu_xueyuan());
		ps.setString(9, student.getCla_number());
		ps.setString(10, student.getTea_number());
		ps.setString(11, student.getTea_name());
		return ps;
	}
	public Student  useResultset(ResultSet rs,Student student) throws Exception{
		student=new Student();
		student.setStu_name(rs.getString("stu_name"));
		student.setStu_number(rs.getString("stu_number"));
		student.setStu_pwd(rs.getString("stu_pwd"));
		student.setStu_class(rs.getString("stu_class"));
		student.setStu_pro(rs.getString("stu_pro"));
		student.setStu_sex(rs.getString("stu_sex"));
		student.setStu_email(rs.getString("stu_email"));
		student.setStu_xueyuan(rs.getString("stu_xueyuan"));
		student.setCla_number(rs.getString("cla_number"));
		student.setTea_number(rs.getString("tea_number"));
		student.setTea_name(rs.getString("tea_name"));
		return student;
	}
	/* (non-Javadoc)
	 * 根据教师编号从class表获取该教师的课程信息,保存在list中
	 */
	public List<Class> getClass(String tea_number){
		List<Class> list = new ArrayList<Class>(); 
		Class cla = null;
		try {
			sql="select * from class where tea_number=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, tea_number);
			rs = ps.executeQuery();
			while (rs.next()){
				cla = new Class();
				cla.setCla_number(rs.getInt("cla_number"));
				cla.setTea_name(rs.getString("tea_name"));
				cla.setTea_number(rs.getString("tea_number"));
				cla.setCourse_name(rs.getString("course_name"));
				list.add(cla);
			}
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("查看有些值是否为空!");
			e.printStackTrace();
		}
		return list;
		
	}
	/* (non-Javadoc)
	 * 向class表增加班级
	 */
	public void addClass(Teacher teacher,String course_name){
		try {
			sql="insert into class(tea_number,tea_name,course_name)values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, teacher.getTea_number());
			ps.setString(2, teacher.getTea_name());
			ps.setString(3, course_name);
			ps.execute();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查看有些值是否为空!");
			e.printStackTrace();
		}
}
	/*
	 * 在class表删除班级
	 */
	public void deleteClass(int cla_number) throws SQLException{
		sql = "delete from class where cla_number=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, cla_number);
		ps.execute();
		ps.close();
		conn.close();
	}
	/*
	 * 根据班级号从student表获取学生信息,保存到list中
	 */
	public List<Student> getStudentInformation(String cla_number) throws Exception {
		// TODO Auto-generated method stub
		sql="select*from student where cla_number=?";
		List<Student> list=new ArrayList<Student>();
		Student student=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, cla_number);
			rs=ps.executeQuery();
			while(rs.next()){
				student=new Student();
				student=useResultset(rs, student);
				list.add(student);
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
	/*
	 * 增加学生到student表中,初始密码为学生学号，密码以后学生可自行修改
	 */
	public void addStudent(Student student){
		try {
			student.setStu_pwd(student.getStu_number());
			sql="insert into student(stu_name,stu_number,stu_pwd,stu_class,stu_pro,stu_sex,stu_email,stu_xueyuan,cla_number,tea_number,tea_name)values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps=getps(student, ps);	
			ps.execute();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查看有些值是否为空!");
			e.printStackTrace();
		}
	}
	/*
	 * 根据教师号从class表查找到相关信息后将excel内信息和查找到信息导入student表中
	 */
	public void deleteStudent(String stu_number,String tea_number) throws SQLException{
		sql = "delete from student where stu_number=? and tea_number=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, stu_number);
		ps.setString(2, tea_number);
		ps.execute();
		ps.close();
		conn.close();
	}
	/*
	 * 根据教师编号从student表中将学生信息导出到excel中
	 */
	public void excel_getStudentInformation(String tea_number){
		
	}
	@Override
	public void getStudentInformation(int cla_number) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void excel_addStudent(String tea_number) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean CheckTeacherLog(String number, String psw) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}