package com.dean.dao;

import java.util.List;

import com.dean.bean.ProblemStore;

public interface ProblemStoreDao {

	public List<ProblemStore> FindProbleStore(String tea_number);
	
}
