package settings_mobile;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NewTest_setting_mobile {
	
	MobileDriver Driver ;
		// DesiredCapabilities capbilities;
	@BeforeClass
	  public void setUp() throws MalformedURLException {
		
		DesiredCapabilities capbilities = new DesiredCapabilities();
		capbilities.setCapability("platformName", "Android");
		capbilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		capbilities.setCapability("deviceName","02602107A8001790");
		capbilities.setCapability("appPackage","com.android.settings");
		capbilities.setCapability("appActivity","com.android.settings.Settings");
		// el far2 baen command w command gay ba3do ba7to 3shan el session mato23sh
		//capbilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);
		Driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"),capbilities);
		// 
		  
		//Driver = new AndroidDriver<MobileElement>(("http://127.0.0.1:4723/wd/hub")); 
	  }
  @Test
  public void f() {
	  MobileElement search=(MobileElement) Driver.findElement(By.id(elements_Setting.Sreach_Bar));
	if (search.isDisplayed())
	{
		System.out.println("da5allllllllllll");
	}
	 search.click();
	
	 MobileElement searchText=(MobileElement) Driver.findElement(By.id(elements_Setting.Sreach_Text));
	// searchText.sendKeys(Keys.ENTER);
	 if (searchText.isDisplayed())
		{
			System.out.println("da5allllllllllll3");
		}
	 searchText.sendKeys("Android Version");
	
	 Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  MobileElement Android_versions=(MobileElement) Driver.findElement(By.id(elements_Setting.Android_version));
	  Android_versions.click();
	 
	  Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  Assert.assertEquals("Android version", Driver.findElement(By.xpath( elements_Setting.Android_version3)).getText());
	 
	  try {
		scrollDown();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
 
 public void scroll(int startx, int starty, int endx, int endy) {

	    TouchAction touchAction = new TouchAction(Driver);

	    touchAction.longPress(PointOption.point(startx, starty))
	               .moveTo(PointOption.point(endx, endy))
	               .release()
	               .perform();

	}
 public void scrollDown() throws Exception {

	    //The viewing size of the device
	    Dimension size = Driver.manage().window().getSize();

	    //Starting y location set to 80% of the height (near bottom)
	    int starty = (int) (size.height * 0.80);
	    //Ending y location set to 20% of the height (near top)
	    int endy = (int) (size.height * 0.20);
	    //x position set to mid-screen horizontally
	    int startx = (int) size.width / 2;

	    scroll(startx, starty, startx, endy);

	}
	  
}
