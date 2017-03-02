package com.jimo.dao;

import java.util.List;

import com.dean.bean.Problem;

/**
 *ClassName:ProblemDao
 * @comment:
 * @author jimo
 * @date 2015年7月26日 下午3:35:37
 */
public interface ProblemDao {
	public void add(Problem problem);
	public void add(List<Problem> list);
	public void delete(int SP_id);
	public void update(int SP_id,Problem problem) throws Exception;
	public List<Problem> FindByType(String p_type,String difficulty_degree) throws Exception;
}
