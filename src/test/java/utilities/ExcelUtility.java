package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	
	public static  FileInputStream fi;
	public static  FileOutputStream fo;
	public static  XSSFWorkbook workbook;
	public static  XSSFSheet sheet;
	public static  XSSFRow row;
	public static  XSSFCell cell;
	String path;
	
	
	// here i removed only static method
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowcount(String sheetname) throws IOException {
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
	    fi.close();
		return rowcount;
		
	}
	
	public  int getCellcount(String sheetname,int rownum) throws IOException {
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
	    fi.close();
		return cellcount;
	}

	public String getCellData(String sheetname,int rownum,int colnum) throws IOException {
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		String data;
		try {
			data=cell.toString();
		}
		catch(Exception e)
		{
            data=" ";
		}
		workbook.close();
	    fi.close();
	    return data;
		
	}
	
	public  void SetCelldata(String sheetname,int rownum,int cellnum,String data) throws IOException {
		
		// this method has been updated 
		
		File xlfile=new File(path);
		if(!xlfile.exists()) {   // if file not exists than create a new file
		
			workbook=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}
		
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetname)==-1)// if sheet no exist than creat a new sheet
		   workbook.createSheet(sheetname);
		 sheet=workbook.getSheet(sheetname);
		 
		 
		 if(sheet.getRow(rownum)==null)   //  if row no exist than creat a new row
		      sheet.createRow(rownum);
		 row=sheet.getRow(rownum);

	    cell=row.createCell(cellnum);
	    cell.setCellValue(data);
	    fo=new FileOutputStream(path);
	    workbook.write(fo);
		workbook.close();
	    fi.close();
	    fo.close();
		
	}
	
	

}
