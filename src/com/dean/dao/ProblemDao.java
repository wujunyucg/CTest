package com.dean.dao;

import java.util.List;

import com.dean.bean.Problem;

public interface ProblemDao {

	public List<Problem> FindProblem(String ps_number);
	
	public Problem FindProblemByP_id(String p_id);
}
