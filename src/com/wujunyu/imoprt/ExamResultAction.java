/**
* 2015-7-27  
* ExamResultAction.java 
* author:JunYu Wu 
*/
package com.wujunyu.imoprt;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wujunyu.util.ExportUtils;

/**
 * @author asus1
 *
 */
public class ExamResultAction extends ActionSupport {
	private String className;
	private String methodName;
	private String fields;
	
	public void export(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=export.xls");
		//创建Excel
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet0");
		try {
			//获取类
			Class clazz = Class.forName(className);
			Object o = clazz.newInstance();
			Method m = clazz.getDeclaredMethod(methodName);
			List list = (List)m.invoke(o);
			String titles = new String("学号,单选,多选,判断,编程,总分");
			ExportUtils.outputHeaders(titles.split(","), sheet);
			ExportUtils.outputColumns(fields.split(","), list, sheet, 1);
			//获取输出流，写入excel 并关闭
			ServletOutputStream out = response.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
