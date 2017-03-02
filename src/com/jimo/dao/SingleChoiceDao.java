package com.jimo.dao;

import java.util.List;

import com.dean.bean.Problem;

/**
 *ClassName:SingleChoiceDao
 * @comment:
 * @author jimo
 * @date 2015年7月26日 下午3:35:37
 */
public interface SingleChoiceDao {
	public void add(Problem singlechoice);
	public void add(List<Problem> list);
	public void delete(int SP_id);
	public void update(int SP_id,Problem singlechoice) throws Exception;
	public List<Problem> findbychapter(String SP_Chapter) throws Exception;
	public List<Problem> findbyrank(String SP_Rank) throws Exception;
}
