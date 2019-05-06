package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookActions {
//varaiables
	 WebDriver browserObject;
	 WebDriverWait wait;
	//locators 
	 By path =By.xpath("//div[@id=\"pagelet_composer\"]//textarea[contains(@title,\"What's on your mind\")]");
	 By name=By.name("q");
	 By sreachpath =By.xpath("//div[@class=\"_77we\"]//div/a[contains(text(),\"ITI Testing Intake39\")]");
	 By shareB=By.xpath("//button[@data-testid=\"react-composer-post-button\"]");
	
			 
	
	//keywoards
	 public FacebookActions( WebDriver browserObject)
	 {
		 this.browserObject=browserObject;
	 }
	
	 public void addpost(String word) {
	
		 wait=new WebDriverWait(browserObject, 20);
		  browserObject.findElement(path).sendKeys(word,(Keys.ENTER));
		 browserObject.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ; 
		  
		/* if(browserObject.findElement(shareB).isDisplayed())
		  {
			 System.out.print("successssssssssss");
			 browserObject.findElement(shareB).sendKeys((Keys.ENTER));;
		  }
		  else
		  {
			  System.out.print("faillllllll"); 
		  }*/
	
		// browserObject.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ; 
		// Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(shareB)).click(),true);
		
	  }
	 
	 
	  public void search(String Sreach) { 
		 
		wait=new WebDriverWait(browserObject, 20);
		browserObject.findElement(name).sendKeys(Sreach,(Keys.ENTER));
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(sreachpath)).getText(),Sreach);
		  browserObject.findElement(sreachpath).click();
		  
	  }
	 
}
