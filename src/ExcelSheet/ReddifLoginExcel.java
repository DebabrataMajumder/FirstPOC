package ExcelSheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReddifLoginExcel 
{


	//To Get the data from the excel sheet 
	public String getExcelData(String sheetname,int rownum,int cellnum) throws InvalidFormatException
	{
		String retval=null;
		try
		{
			FileInputStream fis = new FileInputStream("./TestData/reddifLogin.xlsx"); //give the path of excel sheet from where the data to be fetched
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s= wb.getSheet(sheetname);
			Row r=s.getRow(rownum);
			Cell c = r.getCell(cellnum);
			
			retval = ((org.apache.poi.ss.usermodel.Cell) c).getStringCellValue();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return retval;
	}
	
	
	//The method returns a zero based integer of the last row in the sheet  <which contains last data in that sheet>
	public int getRowCount(String sheetname) throws InvalidFormatException
	{
		
		int rowcount=0;
		try
		{
			FileInputStream fis= new FileInputStream("./TestData/reddifLogin.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s= wb.getSheet(sheetname);
			rowcount = s.getLastRowNum();
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return rowcount;
	}
	
	//This method returns the data into the excel sheet
	public void setExcelData(String sheetname,int rownum,int cellnum,String data) throws InvalidFormatException
	{
		try
		{
			FileInputStream fis = new FileInputStream("./TestData/reddifLogin.xlsx"); //give the path of excel sheet from where the data to be fetched
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s= wb.getSheet(sheetname);
			Row r=s.getRow(rownum);
			Cell c = r.getCell(cellnum);
			((org.apache.poi.ss.usermodel.Cell) c).setCellValue(data);
			FileOutputStream fos=new FileOutputStream("./TestData/reddifLogin.xlsx");
			wb.write(fos);
		}
		
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(EncryptedDocumentException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
}


}







