package practiceTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class WriteInCell {
	
	    private static XSSFWorkbook workbook;
	    static int Rownum=1;
	    static WebDriver driver;
	  //  @Description("Test Description: Login test with wrong username and wrong password.")
		public static void WriteToExel(String sUserName, String sPassword , String Name) throws IOException 
	    {
	    	
	    	File src=new File("C:/Users/Farah/Desktop/automation1.xlsx");
		   
	    	FileInputStream fis = new FileInputStream(src);
	    	 workbook = new XSSFWorkbook(fis);
	    	 XSSFSheet sheet = workbook.getSheetAt(0) ;
	    	 By logname=By.xpath("//a/span/span[contains(text(),\"Farah\")]");
	    	
	    		// if((sUserName.contentEquals("farahalaamahmed@yahoo.com"))&&(sPassword.contentEquals("Doaaafia3"))) 
	    	//{
	    			if( Name=="Farah")
	    			{
	    			 sheet.getRow(Rownum).createCell(2).setCellValue("Passed");
	    			 System.out.println("passsssssssssssss");
	    		}
	    		else {
	    			 
	    			sheet.getRow(Rownum).createCell(2).setCellValue("Failed");
	    			 System.out.println("failllllllllllll");
	    			
	    	    }
	    		 Rownum++;
	    	FileOutputStream fout=new FileOutputStream(src);
			workbook.write(fout);
	    }

}
