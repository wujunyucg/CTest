/**
* 2015-7-27  
* ExamResultDao.java 
* author:JunYu Wu 
*/
package com.dean.dao;

import java.util.List;

import com.dean.bean.ExamResult;

/**
 * @author asus1
 *
 */
public interface ExamResultDao {
	public List<ExamResult> findByExamArr(int examArr_Id,boolean stu,boolean up,boolean down);
	public void updateExamResult(ExamResult examResult);
	public void deleteExamResule(int examres_id);
	public void addExamResult(ExamResult examResult);
	/**
	 * @param examResult
	 */
}
