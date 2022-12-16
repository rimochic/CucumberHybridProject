package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlutil {
	
	public FileInputStream fi;
	public XSSFWorkbook book;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	public int getRowCount(String path, String sheetName) throws IOException {
		fi = new FileInputStream(path);
		book = new XSSFWorkbook(fi);
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		book.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String path, String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		book = new XSSFWorkbook(fi);
		sheet = book.getSheet(sheetName);
		int cellCount = sheet.getRow(rowNum).getLastCellNum();
		book.close();
		fi.close();
		return cellCount;
	}
	
	public String getData(String path, String sheetName, int rowNun, int cellNum) throws IOException {
		fi = new FileInputStream(path);
		book = new XSSFWorkbook(fi);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNun);
		cell = row.getCell(cellNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
		data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data = "";
		}
		book.close();
		fi.close();
		return data;
		
	}
	
	public List<HashMap<String, String>> getDataExcel(String path, String sheetName) throws IOException {
		List<HashMap<String, String>> mydata = new ArrayList<>();
		try {
			fi = new FileInputStream(path);
			book = new XSSFWorkbook(fi);
			sheet = book.getSheet(sheetName);
			row = sheet.getRow(0); // header row
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
				{
				XSSFRow currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) 
					{
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) 
						{
							case STRING:
							currentHash.put(row.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
							break;
						}
					}
				mydata.add(currentHash);
				}
			fi.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
}
