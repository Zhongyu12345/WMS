package com.wms.commons.utils;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelToDisk<T> {
	public void Excel( Object data[], String fileName, String [] title, HttpServletResponse resp){
		try {
				OutputStream os = resp.getOutputStream();// 取得输出流
				resp.reset();// 清空输出流
				resp.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("GB2312"),"ISO8859-1"));
				resp.setContentType("application/msexcel");// 定义输出类型\
				WritableWorkbook workbook = Workbook.createWorkbook(os);
				WritableSheet sheet = workbook.createSheet("Sheet1",0);
				//设置纵横打印
				jxl.SheetSettings sheetset = sheet.getSettings();
				sheetset.setProtected(false);
				//设置单元格字体
				WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 12);
				WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 12,WritableFont.BOLD);
				// 用于标题居中
				WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
				wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
				wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
				wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
				wcf_center.setWrap(false); // 文字是否换行
				// 用于正文居左
				WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
				wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
				wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
				wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
				wcf_left.setWrap(false); // 文字是否换行

				for(int i = 0 ; i < title.length ; i++){
					sheet.addCell(new Label(i,0,title[i],wcf_center));
				}

				int i = 1;
				int j = 0;
				for(int k=0;k<title.length;k++){
					sheet.addCell(new Label(j,i,data[k].toString(),wcf_left));
					if(k == (title.length-1)){
						i=2;
						j=0;
						for(int o=title.length;o<data.length;o++){
							sheet.addCell(new Label(j,i,data[o].toString(),wcf_left));
							j++;
						}
					}
					j++;
				}
				i++;
				workbook.write();
				workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
