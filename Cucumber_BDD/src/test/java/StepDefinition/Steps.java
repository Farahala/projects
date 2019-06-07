package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;	
	 @Given("^Open the Firefox and launch the application$")				
	    public void open_the_Chrome_and_launch_the_application() throws Throwable							
	    {		
	    // System.out.println("This Step open the Chrome and launch the application.");					
		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize(); 
		 driver.get("http://demo.guru99.com/v4");
	 }
	    			
	  //@When("^Enter the Username and Password$")
	 @When("^Enter the Username \"(.*)\" and Password \"(.*)\"$")
	  public void enter_the_Username_and_Password(String username,String password) throws Throwable 							
	    {	
		 //System.out.println("This step enter the Username and Password on the login page.");	
	       driver.findElement(By.name("uid")).sendKeys(username);							
	       driver.findElement(By.name("password")).sendKeys(password);
	    }		

	    @Then("^Reset the credential$")					
	    public void Reset_the_credential() throws Throwable 							
	    {    		
	        //System.out.println("This step click on the Reset button.");					
	    	 driver.findElement(By.name("btnReset")).click();	
	    }		

	

}
