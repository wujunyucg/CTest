/**
 * 
 */
package com.lilinhan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.dean.bean.Notice;

/**
 *ClassName:NoticeDao
 * @comment:
 * @author Linhan Li
 * @date 2015Äê7ÔÂ27ÈÕ
 */
public interface NoticeDao {

		public PreparedStatement PSset(PreparedStatement ps,Notice not);
		public Notice RSGet(ResultSet rs,Notice not);
		public void AddNotice(Notice not);
		public void UpdateNoticeById(int id);
		public void UpdateNotice(Notice not);
		public List<Notice> FindNoticeByProperty(String property, String value);
		public Notice FindNoticeById(int id);
		public List<Notice> FindNoticeByClass(String clazz);
		public List<Notice> FindNoticeByteaNumber(String number);
		public List<Notice> FindNoticeByTitle(String title);
		public List<Notice> FindAllNotice();
		public void DeleteNoticeById(int id);
		public void DeleteNotice(Notice not);
		
}
