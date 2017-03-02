package com.jr.dean;

import java.util.List;

import com.dean.bean.Student;
import com.dean.bean.Teacher;

/** 
 * @author ShengRong Ji 
 * @version 创建时间：2015-7-26 下午3:25:05 
 */

public interface TeacherDao {
	public List<Class> getClass(String tea_number);	//根据教师编号从class表获取该教师的课程信息，保存在list中
	public void addClass(Teacher teacher,String course_name);	//向class表增加班级
	public void deleteClass(int cla_number);			//在class表删除班级
	public List<Student> getStudentInformation(int cla_number);	//根据班级号从student表获取学生信息,保存到list中
	public void addStudent(Student student);			//增加学生到student表中
	public void excel_addStudent(String tea_number);	//根据教师号从class表查找到相关信息后将excel内信息和查找到信息导入student表中
	public void deleteStudent(String stu_number,String tea_number);		//根据学生学号和教师编号将该学生从student表中移除，现实意义为从该教师班级中移除该学生
	public void excel_getStudentInformation(String tea_number);			//根据教师编号从student表中将学生信息导出到excel中
	
	//made by jimo
	public boolean CheckTeacherLog(String number,String psw);
}
