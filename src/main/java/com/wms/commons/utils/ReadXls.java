package com.wms.commons.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 读取excel表格
 */
public class ReadXls {
	@SuppressWarnings("resource")
	public static List<List<String>> readxls(String path) throws Exception{
		InputStream is = new FileInputStream(path);

		String name = path.substring(path.lastIndexOf(".")+1);
		if(name.equals("xls")){
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);//HSSFWorkbook表示整个excel
			List<List<String>> list = new ArrayList<List<String>>();
			for(int i=0;i<hssfWorkbook.getNumberOfSheets();i++){
				HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
				if(sheet == null){
					continue;
				}
				for(int rownum = 1;rownum <= sheet.getLastRowNum();rownum++){
					HSSFRow hssfRow = sheet.getRow(rownum);//HSSFRow表示行
					int minColIx = hssfRow.getFirstCellNum();
					int maxColIx = hssfRow.getLastCellNum();

					List<String> rowlist = new ArrayList<String>();
					for(int ColIx = minColIx; ColIx < maxColIx ;ColIx++){
						HSSFCell hssfCell = hssfRow.getCell(ColIx);
						if(hssfCell == null){
							continue;
						}
						rowlist.add(hssfCell+"");
					}
					list.add(rowlist);
				}
			}
			return list;
		}else if(name.equals("xlsx")){
			XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);//HSSFWorkbook表示整个excel
			List<List<String>> list = new ArrayList<List<String>>();
			for(XSSFSheet xssfSheet :hssfWorkbook){
				if(xssfSheet == null){
					continue;
				}
				for(int rownum = 1;rownum <= xssfSheet.getLastRowNum();rownum++){
					XSSFRow hssfRow = xssfSheet.getRow(rownum);//HSSFRow表示行
					int minColIx = hssfRow.getFirstCellNum();
					int maxColIx = hssfRow.getLastCellNum();

					List<String> rowlist = new ArrayList<String>();
					for(int ColIx = minColIx; ColIx < maxColIx ;ColIx++){
						XSSFCell hssfCell = hssfRow.getCell(ColIx);
						if(hssfCell == null){
							continue;
						}
						rowlist.add(hssfCell+"");
					}
					list.add(rowlist);
				}
			}
			return list;
		}
		return null;
	}
}
