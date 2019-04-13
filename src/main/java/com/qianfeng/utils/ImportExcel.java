package com.qianfeng.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExcel {
	
	public static boolean isXls(String fileName){
		// (?i)忽略大小写
		if(fileName.matches("^.+\\.(?i)(xls)$")){
			return true;
		}else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
			return false;
		}else{
			throw new RuntimeException("格式不对");
		}
	}
	
	public static List<Map<String, Object>> readExcel(String fileName,InputStream inputStream) throws IOException {
		boolean ret = isXls(fileName);
		
		Workbook workbook = null;
		
		if(ret) {
			//xls
			workbook = new HSSFWorkbook(inputStream);	
		}else {
			//xlsx
			workbook = new XSSFWorkbook(inputStream);	
		}
		
		Sheet sheet = workbook.getSheetAt(0);
		
		Row titlerow = sheet.getRow(0);
		short lastCellNum = titlerow.getLastCellNum();
		int lastRowNum = sheet.getLastRowNum();
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 1; i <= lastRowNum; i++) {
			Map<String, Object> map =  new HashMap<>();
			Row row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				String key = titlerow.getCell(j).getStringCellValue();
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				map.put(key, cell.getStringCellValue());
			}
			list.add(map);
		}
	
		workbook.close();
		
		return list;
	}
}
