package AutomationFacebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.FacebookActions;
import Pages.Messanger;
import Pages.OpenGroupPage;
import Pages.login;

public class ObjectModel {
	 WebDriver browserObject;
	 String url="https://www.facebook.com";
	 login log ;
	 FacebookActions actions;
	 Messanger messager;
	 OpenGroupPage GroupITI;
	 @BeforeClass
		  public void beforeMethod() {

			 ChromeOptions options = new ChromeOptions();
			  options.addArguments("--disable-notifications");
			 System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			  browserObject = new ChromeDriver(options);
			  browserObject.navigate().to(url);
			  browserObject.manage().window().maximize();
			 
		 }
	 @BeforeMethod
	 public void navagitlogin() {
		 log= new login(browserObject);
		
	 }
	 @Test
	 public void login_account()
	 { log= new login(browserObject);
		 log.loginButon("Doaaafia3", "farahalaamahmed@yahoo.com");
	 }
	@Test
	 public void writePost()
	 {
		 actions =new FacebookActions(browserObject);
		 actions.addpost("ITI Yarab");
	 }
	@Test(dependsOnMethods = { "writePost" }, alwaysRun = true)
	 public void sreachfor()
	 { 
		 actions =new FacebookActions(browserObject);
		 actions.search("ITI Testing Intake39");
	 }
	/*@Test(dependsOnMethods = { "sreachfor" }, alwaysRun = true)
	 public void grouppage()
	 {  GroupITI =new OpenGroupPage(browserObject);
	 GroupITI.opengroup();
	 }*/
	@Test(dependsOnMethods = { "sreachfor" }, alwaysRun = true)
	public void download()
	{
		GroupITI =new OpenGroupPage(browserObject);
		GroupITI.downloadfill(7);
		
	}
	@Test(dependsOnMethods = { "download" }, alwaysRun = true)
	public void retuenHome()
	 {
		messager =new Messanger(browserObject);
		messager.home();
	 }
	
	 @Test(dependsOnMethods= {"retuenHome"}, alwaysRun = true)
	 public void message()
	 { 
		 messager =new Messanger(browserObject);
		 messager.messagerr();
	 }
	 
	/* @Test(dependsOnMethods= {"message"}, alwaysRun = true)
	 public void messagerrsreach()
	 { 
		 messager =new Messanger(browserObject);
		 messager.messagesreachBYname("Farah");
		
	 }*/
	/* @Test(dependsOnMethods= {"messagesreach"}, alwaysRun = true)
	 public void writemessager()
	 { 
		 messager =new Messanger(browserObject);
		 messager.writemessage("yarab");
		// Assert.assert
	 }*/
	 
	 
/*	@AfterClass
		public void afterClass() {
		 browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 
		 
			browserObject.close();
		}*/
		 	
}
