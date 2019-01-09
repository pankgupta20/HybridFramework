package com.HybridFramework.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HybridFramework.testbase.TestBase;

public class Excel_Reader extends TestBase {

	public String[][] getExcelData(String excelLocation, String Sheetname) throws IOException{
	try{	
		String dataSets[][] = null;
		FileInputStream file = new FileInputStream(new File(excelLocation));
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(Sheetname);
		int Rcount = sh.getLastRowNum()+1;
		int Ccount = sh.getRow(0).getLastCellNum();
		
		logger.info("Row count is: " + Rcount);
		logger.info("Column count is: " +Ccount);
		
		dataSets = new String[Rcount-1][Ccount];
		Iterator<Row> rowIterator = sh.iterator();
		
		int i=0;
		int t=0;
		while(rowIterator.hasNext()){
			Row row = rowIterator.next();
				if(i++ !=0){
					int k=t;
					t++;
					Iterator<Cell> cellIterator = row.cellIterator();
					int j=0;
					
					while(cellIterator.hasNext()){
						Cell cell = cellIterator.next();
						
						dataSets[k][j++] = cell.getStringCellValue();
						//dataSets[i][j++] = cell.getStringCellValue();
						//System.out.print(cell.getStringCellValue()+",");
						}
					//System.out.println("");
					}
				}
			file.close();
			return dataSets;
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;		
			
		}
		
		
/*	public static void main(String[] args) throws IOException{
		Excel_Reader ex = new Excel_Reader();
		ex.getExcelData("C:\\Selenium\\TestData.xlsx", "Sheet1");
	}*/
	
	@DataProvider(name="testdataprovider")
	public Object[][] dataSource() throws IOException{
		return getExcelData("C:\\Selenium\\TestData.xlsx", "Sheet1");
	}
	
	@Test(dataProvider="testdataprovider")
	public void testlogin(String name, String password, String value){
		logger.info(name+",");
		logger.info(password+",");
		logger.info(value);
		logger.info("");
	}
	
		
	}
	