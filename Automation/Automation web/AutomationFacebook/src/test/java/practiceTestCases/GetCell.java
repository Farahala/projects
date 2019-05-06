package practiceTestCases;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class GetCell {
	
	 static XSSFWorkbook workbook;
	    static XSSFSheet sheet;
	    XSSFCell cell;
	    static WebDriver driver;
	    static File src=new File("C:/Users/Farah/Desktop/automation1.xlsx");
	    
public static Object[][] getcellfromexcel()throws Exception
{
	  System.out.println("GetCelllllllllllllllllll");
	Object[][] data= new Object[2][2];
	
	FileInputStream fis = new FileInputStream(src);
	// Load he workbook.
	workbook = new XSSFWorkbook(fis);
	// Load the sheet in which data is stored.
	sheet= workbook.getSheetAt(0);
	
	
	
	int j = 1; // counter for sheet rows
	
	 for(int i=0;i<data.length;i++) // i: counter for data array
	 {// email
	data[i][0]=sheet.getRow(j).getCell(0).getStringCellValue();
	//password
	data[i][1]=sheet.getRow(j).getCell(1).getStringCellValue();
	 j++;
	 }
	 return (data);

}
	  

}
