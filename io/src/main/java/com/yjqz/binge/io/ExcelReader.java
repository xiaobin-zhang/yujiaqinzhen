package com.yjqz.binge.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExcelReader {
	
	/**
	 * 总行数
	 */
	private int rows;
	
	/**
	 * 总列数
	 */
	private int cells;
	
	private List<String> getExcelInfo(InputStream is,boolean isExcel2003) {
		List<String> list = null;
		Workbook wb = null;
		try {
			if (isExcel2003) {
				wb = new HSSFWorkbook(is);
			} else {
				wb = new XSSFWorkbook(is);
			}
			list = readExcelValue(wb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	private List<String> readExcelValue(Workbook wb) {
		List<String> list = new ArrayList<String>();
		Sheet sheet = wb.getSheetAt(0);
		//获取总行数
		this.rows = sheet.getPhysicalNumberOfRows();
		if (rows >0 && sheet.getRow(0) != null) {
			//获取总列数
			this.cells = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		//跳过第一行的标题，从第二行的内容开始读取
		for (int i = 1; i < this.rows; i++) {
			StringBuffer sbuff = new StringBuffer();
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			for (int j = 0; j < this.cells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellTypeEnum();
				switch (cellType) {
				case NUMERIC:
					if (j == 1) {
						double value = cell.getNumericCellValue();
						String valueStr = new DecimalFormat("########").format(value);
						sbuff.append(valueStr).append("|");
						break;
					}
					if (j == 2) {
						double value = cell.getNumericCellValue();
						String valueStr = new DecimalFormat("#").format(value);
						sbuff.append(valueStr).append("|");
						break;
					}
					if (j == 3) {
						double value = cell.getNumericCellValue();
						String valueStr = new DecimalFormat("##.##").format(value);
						sbuff.append(valueStr);
						break;
					}
					break;
				case STRING:
					sbuff.append(cell.getStringCellValue()).append("|");
					break;
				default:
					break;
				}
			}
			list.add(sbuff.toString());
		}
		return list;
	}
	
	@Test
	public void test() throws IOException {
		File file = new File("C:\\Users\\zhangxiaobin\\Desktop\\temp\\未逾期.xlsx");
		File targetFile = new File("C:\\Users\\zhangxiaobin\\Desktop\\temp\\B_CBIB_REPAY_FQL_FqlCCPay_20171031_02.txt");
		FileInputStream is = new FileInputStream(file);
		boolean isExcel2003 = false;
		List<String> excelInfo = this.getExcelInfo(is, isExcel2003);
		List<String> head = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		String headStr = sb.append("735").append("|")
							.append("504").append("|")
							.append("03002971517").append("|")
							.append("51000631748").append("|")
							.append("2017-10-31").toString();
		head.add(headStr);
		FileUtils.writeLines(targetFile, "UTF-8", head, IOUtils.LINE_SEPARATOR_UNIX, true);
		FileUtils.writeLines(targetFile, "UTF-8", excelInfo, IOUtils.LINE_SEPARATOR_UNIX, true);
	}
}
