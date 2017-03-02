/**
* 2015-7-25  
* NoticeDao.java 
* author:JunYu Wu 
*/
package com.dean.dao;

import java.util.List;

import com.dean.bean.Notice;

/**
 * @author asus1
 *
 */
public interface NoticeDao {
	public void addNotice(Notice notice);
	public void deleteNotice(int notice_Id);
	public void updateNotice(int id,Notice notice);
	public List<Notice> findNoticeByTeacherNumber(String number);
}