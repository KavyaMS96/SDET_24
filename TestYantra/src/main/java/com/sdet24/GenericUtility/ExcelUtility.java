package com.sdet24.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





/**
 * 
 * @author Kavya
 *
 */
public class ExcelUtility {
	
	/**
	 * 
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return data
	 * @throws Throwable
	 */
	
	public String getExcelData(String sheetname, int row, int cell) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/vtigertestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;

		
	}
	
	public void writeExcelData (String sheetName, int rownum, int column, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/vtigertestdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rownum).getCell(column).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./data/vtigertestdata.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	
	

}
