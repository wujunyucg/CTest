/**
* 2015-7-25  
* AnswerDao.java 
* author:JunYu Wu 
*/
package com.dean.dao;

import java.util.List;

import com.dean.bean.Answer;

/**
 * @author asus1
 *
 */
public interface AnswerDao {
	public void addAnswer(Answer answer);
	public void deleteAnswer(int ans_id);
	public void updateAnswer(int id,Answer answer);
	public List<Answer> findByStuNumAndExamId(String stuNumber,String examId);
	public List<Answer>  findByStuNumber(String stuNumber);
}
