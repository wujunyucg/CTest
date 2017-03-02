package com.dean.dao;

import java.util.List;

import com.dean.bean.PaperList;

public interface PaperListDao {

	public List<PaperList> FindPaperList(String examarr_id);
}