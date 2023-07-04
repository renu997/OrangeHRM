package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.io.File;

public class ExcelUtility {
 public FileInputStream fi;
 public FileOutputStream fo;
 public XSSFWorkbook workbook;
 public XSSFSheet sheet;
 public XSSFRow row;
 public XSSFCell cell;
 
 String path;
 
 public ExcelUtility(String path)//get path itself
 {
	 this.path=path;//declare path so need to declare path every time in every method
 }
 public int getRowCount(String sheetName) throws IOException
 {
	 fi=new FileInputStream(path);
	 workbook=new XSSFWorkbook(fi);
	 sheet=workbook.getSheet(sheetName);
	 
	 int rowCount=sheet.getLastRowNum();
	 
	 workbook.close();
	 fi.close();
	 
	return rowCount; 
 }
 public int getCellCount(String sheetName,int rownum) throws IOException
 {
	 fi=new FileInputStream(path);
	 workbook=new XSSFWorkbook(fi);
	 sheet=workbook.getSheet(sheetName);
	 row=sheet.getRow(rownum);
	 
	 int cellCount=row.getLastCellNum();
	 
	 workbook.close();
	 fi.close();
	 
	return cellCount;
 }
  public String getCellData(String sheetName,int rownum,int colnum) throws IOException
  {
	  fi=new FileInputStream(path);
	  workbook=new XSSFWorkbook(fi);
	  sheet=workbook.getSheet(sheetName);
	  row=sheet.getRow(rownum);
	  cell=row.getCell(colnum);
	  
	  DataFormatter formatter=new DataFormatter();
	  String data;
	  try
	  {
		  data=formatter.formatCellValue(cell);//return formatted value of cell
	  }
	  catch(Exception e)
	  {
		 data=""; 
	  }
	  workbook.close();
	  fi.close();
	  
	  return data;
  }
  public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
  {
	File xlfile=new File(path);
	if(!xlfile.exists());//if file not exists then create new file
	{
		workbook=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		workbook.write(fo);
	}
	
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	
	//sheet no index start from 0 (like- sheet 1 then index=0)
	//sheet==-1 means there is not any sheet present(sheet<0)
	if(workbook.getSheetIndex(sheetName)==-1)//if sheet not exists then create new sheet
	workbook.createSheet(sheetName);//create sheet
	sheet=workbook.getSheet(sheetName);//get sheet from workbook
				
	if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
	sheet.createRow(rownum);
	row=sheet.getRow(rownum);
	
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	
	fo=new FileOutputStream(path);
	workbook.write(fo);		
	workbook.close();
	fi.close();
	fo.close();	
	
  }
  
}
