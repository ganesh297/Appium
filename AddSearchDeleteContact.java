package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AddSearchDeleteContact {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.motorola.dialer.app.ExtendedDialtactsActivity");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		

		driver.findElementByAccessibilityId("Contacts tab.").click();
		driver.findElementByAccessibilityId("Create new contact").click();
		driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys("Test First Name");
	
		driver.findElement(By.xpath("(//android.widget.EditText)[3]")).sendKeys("9876543210");
		driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
		
		//phone
		//save
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(By.xpath("(//android.widget.FrameLayout)[13]")).click();
		/*TouchActions action = new TouchActions(driver);
		action.singleTap(search);
		action.perform();
		*/
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Test First Name");
		
		
	int searchListsCount=driver.findElements(By.xpath("//android.widget.TextView")).size();
	System.out.println(searchListsCount);
	
	
	
	
	for(int i=1;i<=searchListsCount;i++ ){
		String name=driver.findElement(By.xpath("(//android.widget.TextView)["+i+"]")).getText();
		System.out.println(name);
		if(name.equalsIgnoreCase("Test First Name")){
			driver.findElement(By.xpath("(//android.widget.QuickContactBadge)["+i+"]")).click();
		break;
	}	
	}
	driver.findElementByAccessibilityId("More options").click();
	driver.findElement(By.xpath("(//android.widget.TextView)[2]")).click();
	driver.findElement(By.id("android:id/button1")).click();
	
	
	
	}

}
