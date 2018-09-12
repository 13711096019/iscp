package com.cn.unit.excel;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cn.common._Tool;

/**
 * 导入EXCEL文档
 * @author adonis_1111@163.com
 * 2015-02-06
 */
public class ExcelCreate {

	/**
	 * 导入EXCEL文档
	 * @param execelFile 文件路径
	 * @return 数据集合
	 */
	public static List<String[]> impExcel(String execelFile) throws Exception{
		// 构造 Workbook 对象
		Workbook book = null;
		try {
			// Excel 2007获取方法
			book = new XSSFWorkbook(new FileInputStream(execelFile));
		} catch (Exception ex) {
			// Excel 2003获取方法
			book = new HSSFWorkbook(new FileInputStream(execelFile));
		}
		
		// 读取表格的第一个sheet页
		Sheet sheet = book.getSheetAt(0);
		// 定义 row
		Row row;
		// 总共有多少行,从0开始
		int totalRows = sheet.getLastRowNum();
		List<String[]> list = new ArrayList<String[]>();
		try {
			// 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
			for (int i = 1; i <= totalRows; i++) {
				row = sheet.getRow(i);
				// 处理空行
				if (row == null) {
					continue;
				}
				// 总共有多少列,从0开始
				int totalCells = row.getLastCellNum();
				String[] str = new String[totalCells];
				
	
				String rowStr = "";
				for (int j = row.getFirstCellNum(); j < totalCells; j++) {
					Cell cell = row.getCell(j);
					// 处理空列
					if (cell == null) {
						continue;
					}
					
					switch (row.getCell(j).getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
							rowStr = sdf.format(cell.getDateCellValue());
						} else {
							rowStr = "" + new BigDecimal(cell.getNumericCellValue()); 
							//rowStr = "" + (int)row.getCell(j).getNumericCellValue();
						}
						break;
					default:
						rowStr = cell.getStringCellValue();
						break;
					}
					str[j] = rowStr;
				}
				System.out.println(_Tool.toJson(str));
				list.add(str);
			}
		}catch (Exception ex) {
			System.out.println(ex);
		}
		return list;
	}
	
}
