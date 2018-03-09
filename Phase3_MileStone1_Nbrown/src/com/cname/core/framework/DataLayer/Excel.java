package com.cname.core.framework.DataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cname.core.framework.utils.Global;

public class Excel 
{
	public static String readData(String sheetName, int rowNum, int cellNum)
	{
		String data = null;
		try
		{
			FileInputStream fis = new FileInputStream(Global.testDataPath);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rowNum);
			
			XSSFCell cell = row.getCell(cellNum);
			
			data =cell.getStringCellValue();
		
		}
		catch(Exception e)
		{
			new Exception("File not found in given : "+Global.testDataPath);
		}
		
		return data;
	}
	
	public static void setData(String sheetName, int rowNum, int colNum, String value)
	{
		try
		{
			FileInputStream fis = new FileInputStream(Global.testDataPath);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rowNum);
			
			XSSFCell cel = row.createCell(colNum);
			
			cel.setCellType(CellType.STRING);
			cel.setCellValue(value);
			
			FileOutputStream fos = new FileOutputStream(Global.testDataPath);
			workbook.write(fos);
			
			fos.close();
			
		}
		catch(Exception e)
		{
			new Exception("File not found in given : "+Global.testDataPath);
		}
	}
	
	public static ArrayList<String> getAllRowData(String sheetName, int rowNum)
	{
		ArrayList<String> lst = new ArrayList<String>();
		try
		{
			FileInputStream fis = new FileInputStream(Global.testDataPath);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(rowNum);
			
			int colNum = row.getLastCellNum();
			
			for(int i=0; i<=colNum; i++)
			{
				String val = row.getCell(i).getStringCellValue();
				
				if(!(val.isEmpty()))
				{
					lst.add(val);
				}
			}	
		}
		catch(Exception e)
		{
			new Exception("File not found in given : "+Global.testDataPath);
		}
		return lst;
	}
	
	public static ArrayList<String> getAllColData(String sheetName, int colNum)
	{
		ArrayList<String> lst = new ArrayList<String>();
		try
		{
			FileInputStream fis = new FileInputStream(Global.testDataPath);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			
			int rowNum = sheet.getLastRowNum();	
			
			for(int i=0; i<=rowNum; i++)
			{
				String val = sheet.getRow(i).getCell(colNum).getStringCellValue();
				if(!(val.isEmpty()))
				{
					lst.add(val);
				}
			}
		}
		catch(Exception e)
		{
			new Exception("File not found in given : "+Global.testDataPath);
		}
		return lst;
	}
	
}