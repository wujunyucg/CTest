
package com.dean.bean;
/**
* 2015-7-25  
* Answer.java 
* author:JunYu Wu 
*/
/**
 * @author asus1
 *
 */
public class Answer {
	private String stu_Ans;
	private String stu_Number;
	private int ans_Score;
	private int p_Id;
	private String examarr_Id;
	private int ans_Id;
	
	public Answer(){}
	public Answer(String stu_Ans, String stu_Number, int ans_Score, int p_Id, String examarr_Id, int ans_Id){
		this.stu_Ans = stu_Ans;
		this.stu_Number =stu_Number;
		this.ans_Score = ans_Score;
		this.p_Id = p_Id;
		this.examarr_Id = examarr_Id;
		this.ans_Id = ans_Id;
	}
	public String getStu_Ans() {
		return stu_Ans;
	}
	public void setStu_Ans(String stu_Ans) {
		this.stu_Ans = stu_Ans;
	}
	public String getStu_Number() {
		return stu_Number;
	}
	public void setStu_Number(String stu_Number) {
		this.stu_Number = stu_Number;
	}
	public int getAns_Score() {
		return ans_Score;
	}
	public void setAns_Score(int ans_Score) {
		this.ans_Score = ans_Score;
	}
	public int getP_Id() {
		return p_Id;
	}
	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}
	public String getExamarr_Id() {
		return examarr_Id;
	}
	public void setExamarr_Id(String examarr_Id) {
		this.examarr_Id = examarr_Id;
	}
	public int getAns_Id() {
		return ans_Id;
	}
	public void setAns_Id(int ans_Id) {
		this.ans_Id = ans_Id;
	}
}
