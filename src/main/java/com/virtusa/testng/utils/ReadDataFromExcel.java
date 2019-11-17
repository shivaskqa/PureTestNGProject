package com.virtusa.testng.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream fis;
	String data[][];
	
	public String[][] dataFromExcel(String path,String sheetname)throws FileNotFoundException,IOException
	{
		
		fis=new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(0);
		
		int lastRow=sheet.getLastRowNum();
		int lastCol=row.getLastCellNum();
		
		data=new String[lastRow][lastCol];
		
		for(int i=1;i<=lastRow;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<lastCol;j++)
			{
				
				cell=row.getCell(j);
				
				if(cell.getCellTypeEnum()==CellType.STRING)
			     { data[i-1][j]=cell.getStringCellValue(); }
			     else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			     { data[i-1][j]=String.valueOf(cell.getNumericCellValue());}
			    System.out.println(data[i-1][j]); 
			}
		}
		
		return data;
	}
	
}
