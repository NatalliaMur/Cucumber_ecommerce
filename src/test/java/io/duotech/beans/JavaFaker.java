package io.duotech.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javafaker.Faker;

public class JavaFaker {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidFormatException {
		Faker f = new Faker();
		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(f.internet().emailAddress());
//		}
		
//		for (int i = 0; i < 15; i++) {
//			System.out.println(f.phoneNumber().cellPhone());
//		}
		
		/*
		 * XSSFWorkbook, XSSFSheet. XSSFRow, XSSFCell --> Classes used for format xlsx (Excel 2007+)
		 * HSSFWorkbook, HSSFSheet. HSSFRow, HSSFCell --> Classes used for format xls (Excel prior to 2007)
		 */
		
	//	FileInputStream obtains input bytesfrom a file in a file system, it is gonna read file as bytes
		
		FileInputStream file = new FileInputStream("file.xlsx");
		
		XSSFWorkbook wbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		
		XSSFRow headerRow = sheet.getRow(0);
		
		XSSFCell cell = headerRow.getCell(3);
		
		System.out.println(cell);
		
		int noOfColumns = headerRow.getLastCellNum(); // How many columns it means how many filled cells I have in one row
		System.out.println(noOfColumns);
		
//		int noOfRows = sheet.getLastRowNum();
		
		int noOfRows = sheet.getPhysicalNumberOfRows(); // How many real numbers of rows is filled
		System.out.println(noOfRows);
		
		for (int i = 0; i < noOfRows; i++) {
			
			for (int j = 0; j < noOfColumns; j++) {
				Cell eachCell = sheet.getRow(i).getCell(j);
				System.out.print(eachCell +"  \t    ");
			}
			System.out.println();
		}
		
	//	FileOutputStream class is used to write to a file as a bytes
		
		sheet.getRow(2).getCell(1).setCellValue("Nata"); //To set ane value to the xlsx file I need use
														// FileOutputStream, write mwthod, close fos, close workbook	
		
		FileOutputStream fos = new FileOutputStream("file.xlsx");
		
		wbook.write(fos); //This statement will write to my file
		fos.close();
		wbook.close();
		
		

	}

}
