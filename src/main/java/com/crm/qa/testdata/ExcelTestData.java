package com.crm.qa.testdata;

import java.io.File;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTestData {


	public static Object[][] getExcelData()

	{		
		Object data [] []=null;
		try {
			File fs = new File("./Excel/testData.xlsx");
			FileInputStream ff = new FileInputStream(fs);
			XSSFWorkbook wb = new XSSFWorkbook(ff);
			XSSFSheet sheet = wb.getSheetAt(0);

			int rowcount = sheet.getPhysicalNumberOfRows();
			int colcount = sheet.getRow(0).getPhysicalNumberOfCells();

			data = new Object[rowcount-1][colcount];

			for(int i=1;i<rowcount;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					String celldata=sheet.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j] = celldata;
					System.out.println(data[i-1][j]);

				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	} 

//	public static void main (String args [] )
//	{
//		ExcelTestData ob = new ExcelTestData();
//		ob.getExcelData();
//		
//	}

}

