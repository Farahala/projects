package AutomationFacebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class NewTest {

  WebDriver browserObject;
 
	 @BeforeClass
	// @BeforeMethod
	 
	  public void beforeMethod() {

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		  browserObject = new ChromeDriver(options);
		  browserObject.navigate().to("https://www.facebook.com");
		  browserObject.manage().window().maximize(); 
	 }

	/*@BeforeClass
	  public void login() {
		 
		   WebElement password= browserObject.findElement(By.xpath("//*[@id=\"pass\"]"));
		   password.sendKeys("Doaaafia3");
		   
		   WebElement Email = browserObject.findElement(By.xpath("//*[@id=\"email\"]"));
		  Email.sendKeys("farahalaamahmed@yahoo.com");
		  
		  WebElement B_login = browserObject.findElement(By.xpath("//*[@id=\"loginbutton\"]"));
		  B_login.sendKeys(Keys.ENTER);
		 
		 
	  }
	 @Test
	 public void addpost() {
		 //boolean postt;
		
		  WebElement addPost = browserObject.findElement(By.xpath("//div[@id=\"pagelet_composer\"]//textarea[contains(@title,\"What's on your mind\")]"));
		  //postt=  addPost.isDisplayed();
		  addPost.sendKeys("ITI");
		  addPost.sendKeys(Keys.ENTER);
		  //Assert.assertTrue(postt);
		 
	  }
	 
	@Test
	  public void search() { 
		WebDriverWait wait=new WebDriverWait(browserObject, 20);
		   WebElement sreach = browserObject.findElement(By.name("q"));
		   sreach.sendKeys("ITI Testing Intake39");
		   sreach.sendKeys(Keys.ENTER);
		   //wait
		  // browserObject.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
		  
		   WebElement firstresult  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_6v_0']//a)[1]")));
		  // sreach.click();
		 String ouputsreach  ;
		  //Assert.assertTrue(browserObject.findElement(By")).isDisplayed());
		 
		//   WebElement firstresult = browserObject.findElement(By.xpath("(//div[@class='_6v_0']//a)[1]"));
		   //ouputsreach =firstresult.isDisplayed();
		  ouputsreach =firstresult.getText();
		   Assert.assertEquals(ouputsreach,"ITI Testing Intake39");
		  
	  }
	/*@AfterMethod
	public void message() {
		WebElement messanger = browserObject.findElement(By.xpath("//*[text()=\"Messenger\"]"));
		messanger.click();
	}*/
/*	@AfterClass
	  public void AfterMethod_close() { 
		   // close the browser at end
		   browserObject.quit();
	  }*/
	 
	 
	 
}
