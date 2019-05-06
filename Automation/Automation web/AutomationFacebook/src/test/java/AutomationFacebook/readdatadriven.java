package AutomationFacebook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class readdatadriven {
	
		WebDriver driver;
	    XSSFWorkbook workbook;
	    XSSFSheet sheet;
	    XSSFCell cell;
	    By Pass_path=By.xpath("//*[@id=\"pass\"]");
		By Emil_path=By.xpath("//*[@id=\"email\"]");
		By Button_path=By.xpath("//*[@id=\"loginbutton\"]");
	    @BeforeTest
		public void initialization(){
		    // To set the path of the Chrome driver.
			 System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			 driver = new ChromeDriver();
		     
		    // To launch facebook
		    driver.get("http://www.facebook.com/");
		    // To maximize the browser
		    driver.manage().window().maximize();
		    // implicit wait
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
			  
		@Test
		public void fbLoginLogout() throws IOException{
			// Import excel sheet.
			File src=new File("C:/Users/Farah/Desktop/automation.xlsx");		  
			// Load the file.
			FileInputStream fis = new FileInputStream(src);
			// Load he workbook.
			workbook = new XSSFWorkbook(fis);
			// Load the sheet in which data is stored.
			sheet= workbook.getSheetAt(0);
			 int RowNum=sheet.getLastRowNum();
			 System.out.println("row number ="+ RowNum);
			 for(int i=1;i<=RowNum;i++)
			 {
				String email=sheet.getRow(i).getCell(0).getStringCellValue();
				System.out.println("data from execl ="+ email);
				driver.findElement(Emil_path).sendKeys(email);
				
				String pass=sheet.getRow(i).getCell(1).getStringCellValue();
				System.out.println("data from execl ="+ pass);
				driver.findElement(Pass_path).sendKeys(pass);
				
				
				if((email=="farahalaamahmed@yahoo.com")&&(pass=="Doaaafia3")) {
					driver.findElement(Button_path).sendKeys(Keys.ENTER);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
				else {
					
					driver.findElement(Button_path).sendKeys(Keys.ENTER);
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    }
			
			 }
			 
				
		}
	
		 
	
}
