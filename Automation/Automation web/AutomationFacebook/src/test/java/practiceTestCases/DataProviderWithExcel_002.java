package practiceTestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.qameta.allure.Step;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


public class DataProviderWithExcel_002 {


	WebDriver driver;
	XSSFWorkbook workbook ;
	 XSSFSheet sheet ;
	 XSSFRow row;
	 WriteInCell writeToFile;
   
	 By Pass_path=By.xpath("//*[@id=\"pass\"]");
		By Emil_path=By.xpath("//*[@id=\"email\"]");
		By Button_path=By.xpath("//*[@id=\"loginbutton\"]");
		By logname=By.xpath("//a/span/span[contains(text(),\"Farah\")]");
	   
		
  @BeforeClass

  public void beforeMethod() throws Exception {
	  ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		
	  System.setProperty("webdriver.chrome.driver","F:\\esclipe\\AutomationFacebook\\src\\test\\resources\\chromedriver.exe");
	  driver =new ChromeDriver(options);
		 
	     
  }	
  @Step("login step with username{0}, password{1}")
  @Test(dataProvider = "Authentication")
  public void f(String sUserName, String sPassword) throws IOException {
	  System.out.println("DataProvider");
	  // To launch facebook
	    driver.get("http://www.facebook.com/");
	    // To maximize the browser
	    driver.manage().window().maximize();
	    // implicit wait
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
			  
		// Load the file.
	    
	  driver.findElement(Emil_path).sendKeys(sUserName);
	  
		System.out.println(sUserName);

		driver.findElement(Pass_path).sendKeys(sPassword);

		System.out.println(sPassword);
		
		driver.findElement(Button_path).click();
		/*if((sUserName=="farahalaamahmed@yahoo.com")&&(sPassword=="Doaaafia3")) {
			 driver.findElement(Button_path).click();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		else {
			driver.findElement(Button_path).click();
			driver.navigate().back();
	   }*/
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String name_profile=driver.findElement(logname).getText();
		
		// Assert.assertEquals("Farah", driver.findElement(logname).getText());
			 
		WriteInCell.WriteToExel(sUserName,sPassword ,name_profile);
		
	    System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
  }

  @AfterMethod

 /* public void afterMethod() {

	   driver.close();

  }*/

  @DataProvider

  public Object[][] Authentication() throws Exception{
	  System.out.println("Authentication");
	//Rows - Number of times your test has to be repeated.
		//Columns - Number of parameters in test data.
		Object[][] data= GetCell.getcellfromexcel();
		
	   	return (data);

		}

}