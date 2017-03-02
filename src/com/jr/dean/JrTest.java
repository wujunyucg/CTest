package com.jr.dean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dean.bean.Class;
import com.dean.bean.Student;
import com.dean.bean.Teacher;
import com.jr.dean.TeacherDaoImpl;

/** 
 * @author ShengRong Ji 
 * @version 创建时间：2015-7-27 上午9:41:23 
 */

public class JrTest {
	@Test
	public void test() throws Exception{
		Teacher teacher = new Teacher();
		teacher.setTea_name("陈陈");
		teacher.setTea_number("201411");
		
		Student student = new Student();
		student.setStu_name("纪圣荣");
		student.setStu_number("2014112109");
		student.setStu_pwd("blacksky");
		student.setStu_class("软件一班");
		student.setStu_pro("软件");
		student.setStu_sex("男");
		student.setStu_xueyuan("信息科学与技术学院");
		student.setCla_number("45");
		student.setTea_name("陈陈");
		student.setTea_number("201411");
		
		List<Class> list1 = new ArrayList<Class>();
		list1 = new TeacherDaoImpl().getClass("201411");	//根据教师编号从class表获取班级，保存在list中
		for(Class class1: list1){
			System.out.println(class1.getCla_number());
		}
//	1	new TeacherDaoImpl().addClass(teacher,"通信工程");	//向class表增加班级
//	1	new TeacherDaoImpl().deleteClass(47);
		
		//根据班级号从student表获取学生信息,保存到list中
/*	1	List<Student> list = new ArrayList<Student>();
		list = new TeacherDaoImpl().getStudentInformation("45");
		for (Student student1:list){
			System.out.println(student1.getStu_number());
		}
*/	
		
//	1	new TeacherDaoImpl().addStudent(student);			//增加学生到student表中
//	0	new TeacherDaoImpl().excel_addStudent(teacher.getTea_name());	//根据教师号从class表查找到相关信息后将excel内信息和查找到信息导入student表中
//		new TeacherDaoImpl().deleteStudent("2014112122","201411");		//根据学生学号和教师编号将该学生从student表中移除，现实意义为从该教师班级中移除该学生
//	0	new TeacherDaoImpl().excel_getStudentInformation(tea_number);			//根据教师编号从student表中将学生信息导出到excel中
	}
}
