package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class login {
	//variable
	WebDriver browserObject;
	
	
	//locator
	By Pass_path=By.xpath("//*[@id=\"pass\"]");
	By Emil_path=By.xpath("//*[@id=\"email\"]");
	By Button_path=By.xpath("//*[@id=\"loginbutton\"]");
	
	//keywoard
	public login(WebDriver browserObject) {
		this.browserObject=browserObject;
	}
	
	
	
	public void loginButon(String password_login , String Email_login)
	{
		 browserObject.findElement(Pass_path).sendKeys(password_login);
		 browserObject.findElement(Emil_path).sendKeys(Email_login);;
		 browserObject.findElement(Button_path).sendKeys(Keys.ENTER);
		  
	}
	
}
