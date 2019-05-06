package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenGroupPage {
	 WebDriver browserObject;
	// By sreachpath =By.xpath("(//div[@class='_6v_0']//a)[1]");
	// By id =By.id("mall_post_328981934637601:6:0");
	 By shareB=By.xpath("//button[@data-testid =\"react-composer-post-button\"]");
	 
	 public OpenGroupPage( WebDriver browserObject)
	 {
		 this.browserObject=browserObject;
	 }

	/* public void opengroup()
	  {  
	  	
	  	 browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 
	  	 browserObject.findElement(id).isSelected();
	  
	  }*/
	  public void downloadfill(int index)
	  {  
	  	 browserObject.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 
	  	browserObject.findElement(By.xpath("(//div[@id=\"mall_post_328981934637601:6:0\"]//a)[" + index + "]")).click();
	  }
	
}
