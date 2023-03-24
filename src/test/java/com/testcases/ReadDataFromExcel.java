package com.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path + "\\excelFiles\\testdata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Create Bill Account");
		
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		
		System.out.println("ROws : "+noOfRows);
		System.out.println("Column : "+noOfColumns);
		//String [][] data = new String[noOfRows-1][noOfColumns];
		
		for (int i = 1; i < noOfRows; i++) {
			for (int j = 0; i < noOfColumns ; j++) {
				DataFormatter df = new DataFormatter();
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
				
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	}
}

