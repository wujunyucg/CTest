/**
 * 
 */
package com.dean.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dean.bean.Answer;
import com.dean.bean.ExamResult;
import com.dean.bean.Notice;
import com.dean.daoimpl.AnswerDaoimpl;
import com.dean.daoimpl.ExamResultDaoimpl;
import com.dean.daoimpl.NoticeDaoimpl;

/**
 *ClassName:Tetszzx
 * @comment:
 * @author Zhixin Zhang
 * @date 2015年7月22日 上午11:06:06
 */
public class Tetszzx {
	@Test
	public void testJudge() throws Exception{
		//Notice notice=new Notice("123125",1,"无拘ssa","软件2014-2","后天考试","考试",new Timestamp(System.currentTimeMillis()));
		//new NoticeDaoimpl().addNotice(notice);
		//new NoticeDaoimpl().deleteNotice(1);
		//List<Notice> list=new NoticeDaoimpl().findNoticeByTeacherNumber("123125");
		//System.out.println(list.get(0).getNotice_Time());
		//Answer answer=new Answer("B","2014112155",5,778,"20150708",2);
		//new AnswerDaoimpl().addAnswer(answer);
		//new AnswerDaoimpl().deleteAnswer(1);
		//new AnswerDaoimpl().updateAnswer(2, answer);
		//List<Answer> list=new AnswerDaoimpl().findByStuNumber("2014112155");
		//System.out.println(list.get(0).getAns_Score());
		List<ExamResult> list=new ExamResultDaoimpl().findByExamArr(2);
		System.out.println(list.get(0).getExamarr_id());
	}
	//@Test
	/*public void testSingleChoice() throws Exception{
		SingleChoiceDaoimpl scdl=new SingleChoiceDaoimpl();
		SingleChoice sc1=new SingleChoice("sjjjjy","srre","1");
		SingleChoice sc2=new SingleChoice("zshds","988as","5");
		SingleChoice sc3=new SingleChoice("zshds","988as","5");
		List<SingleChoice> list=new ArrayList<SingleChoice>();
		list.add(sc1);
		list.add(sc2);
		sc3.setsP_Chapter("1");
//		new SingleChoiceDaoimpl().add(sc);
//		scdl.add(sc3);
//		System.out.println(scdl.findbychapter("1").get(0).getsP_id());
//		System.out.println(scdl.)
//		scdl.delete(1);
	}*/
}
