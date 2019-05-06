package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Messanger {
		//varaiables
		 WebDriver browserObject;
		
		 
		 // locator
		 By path =By.xpath("//*[text()=\"Messenger\"]");
		 By homepath =By.xpath("//a[@class=\"_2s25\"]");
		 By messagepath =By.xpath("//label/input");
		
		 
		 //variable
		 public Messanger(WebDriver browserObject)
		 {
			 this.browserObject=browserObject;
		 }
		 public void home() {
			 browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 
			 browserObject.findElement(homepath).click();
				
			}
		 public void messagerr() {
			 browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 
			 browserObject.findElement(path).click();	
			}
		
		/*public void messagesreachBYname(String sreachname) {
			WebDriverWait wait=new WebDriverWait(browserObject, 20);
			 browserObject.findElement(messagepath).sendKeys(sreachname,(Keys.ENTER));
			 Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(messagepath)).getText(),sreachname);
			  
			
		}*/
	
}
