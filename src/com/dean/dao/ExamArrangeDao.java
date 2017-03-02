package com.dean.dao;

import java.util.List;

import com.dean.bean.ExamArrange;

public interface ExamArrangeDao {

	public List<ExamArrange> FindExamArrange(String tea_number);
	
	public void AddExamArrange(ExamArrange ea);
	
	public void DelExamArrange(int examarr_id);
}
