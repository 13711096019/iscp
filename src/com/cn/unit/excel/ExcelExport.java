package com.cn.unit.excel;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 导出Execl文档
 * @author caitou_1111@163.com
 * 2016-04-07
 */
public class ExcelExport {
	
	/**
	 * 模板写出Execl文档
	 * @param list 集合
	 * @param title 标题
	 * @param mould 模板名称
	 * @return
	 */
	public static HSSFWorkbook ExcelUtil(List<?> list, String title, String filePath){
		// 得到原始模板路径
		// String templateFilePath = Const.PROJECT_NAME + Const.FILE_TEMPLATE_PATH + mould;
		
		//将导出excel的数据和导出excel的标题放到集合中
		Map<String, Object> datamap = new HashMap<String, Object>();
		
		// 导出excel的数据
		datamap.put("list", list);
		// 导出excel的标题
		datamap.put("title", title);
		
		InputStream in = null;
		try {
			// 将模板文件转换为文件流
			in = new FileInputStream(filePath);
			// jxls生成excel
			XLSTransformer transformer = new XLSTransformer();
			// 将excel流转换为Workbook
			HSSFWorkbook wb = (HSSFWorkbook) transformer.transformXLS(in, datamap);
			// 取第一个Sheet
			Sheet sheet = wb.getSheetAt(0);
			// 四个参数分别是：起始行，结束行，起始列，结束列
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 0));
			return wb;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParsePropertyException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} finally{
			try {
				if(in != null) in.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
	
	/**
	 * 输出文件流
	 * @param filename
	 * @param wb
	 * @param response
	 */
	public static void writeStream(String filename, Workbook wb, HttpServletResponse response) {
		try {
			filename += ".xls";

			filename.replaceAll("/", "-");
			filename = URLEncoder.encode(filename, "UTF-8");
			
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + filename);
			response.setContentType("application/octet-stream;charset=UTF-8");
			
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());

			wb.write(outputStream);
			
			outputStream.flush();
			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 控制器调用
	 public void readInsLog(){
    	List<Record> list = null;
		String title = "log_"+System.currentTimeMillis();
		HSSFWorkbook wb = ExcelExportUtil.ExcelUtil(list, title, "inslog_export_template.xls");
		ExcelExportUtil.writeStream(title, wb, getResponse());
		renderNull();
    }*/
	
	
}
