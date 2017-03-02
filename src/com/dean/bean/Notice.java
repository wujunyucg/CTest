
package com.dean.bean;

import java.sql.Timestamp;

/**
 * @author asus1
 *
 */
/**
* 2015-7-25  
* Notice.java 
* author:JunYu Wu 
*/
public class Notice {
<<<<<<< .mine
	private String tea_Number;
	private int notice_Id;
	private String tea_Name;
	private String cla_Number;
	private String notice_Content;
	private String notice_Title;
	private Timestamp notice_Time;
	public Notice() {
=======
 
	private int notice_id;
	private String tea_number;
	private String tea_name;
	private String cla_number;
	private String notice_content;
	private String notice_title;
	private String notice_time;
	
	public int getNotice_id() {
		return notice_id;
>>>>>>> .r135
	}
	public Notice(String tea_Number,int notice_Id,String tea_Name,String cla_Number,String notice_Content,String notice_Title,
			Timestamp notice_Time){
		this.tea_Number = tea_Number;
		this.notice_Id = notice_Id;
		this.tea_Name = tea_Name;
		this.cla_Number = cla_Number;
		this.notice_Content = notice_Content;
		this.notice_Title = notice_Title;
		this.notice_Time = notice_Time;
	}
	public String getTea_Number() {
		return tea_Number;
	}
	public void setTea_Number(String tea_Number) {
		this.tea_Number = tea_Number;
	}
	public int getNotice_Id() {
		return notice_Id;
	}
	public void setNotice_Id(int notice_Id) {
		this.notice_Id = notice_Id;
	}
<<<<<<< .mine
	public String getTea_Name() {
		return tea_Name;
=======
	
	public String getCla_number() {
		return cla_number;
>>>>>>> .r135
	}
<<<<<<< .mine
	public void setTea_Name(String tea_Name) {
		this.tea_Name = tea_Name;
=======
	public void setCla_number(String cla_number) {
		this.cla_number = cla_number;
>>>>>>> .r135
	}
	public String getCla_Number() {
		return cla_Number;
	}
	public void setCla_Number(String cla_Number) {
		this.cla_Number = cla_Number;
	}
	public String getNotice_Content() {
		return notice_Content;
	}
	public void setNotice_Content(String notice_Content) {
		this.notice_Content = notice_Content;
	}
	public String getNotice_Title() {
		return notice_Title;
	}
	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}
<<<<<<< .mine
	public Timestamp getNotice_Time() {
		return notice_Time;
	}
	public void setNotice_Time(Timestamp notice_Time) {
		this.notice_Time = notice_Time;
	}
	
}	
=======
}
>>>>>>> .r135
