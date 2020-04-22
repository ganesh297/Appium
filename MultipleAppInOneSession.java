package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MultipleAppInOneSession {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.deskclock");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.deskclock.DeskClock");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.deskclock:id/fab"))).isDisplayed();
		driver.findElement(By.id("com.google.android.deskclock:id/fab")).click();
		
		driver.findElementByAccessibilityId("6").click();
		
		driver.findElementByAccessibilityId("45").click();
				
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		
		String vibrate=driver.findElement(By.id("com.google.android.deskclock:id/vibrate_onoff")).getAttribute("checked");
		System.out.println("Vibrate: "+vibrate);

		
		driver.findElement(By.id("com.google.android.deskclock:id/delete")).click();
		
		
		
		String clockActivity=driver.currentActivity();
		String clockPackage=driver.getCurrentPackage();
		System.out.println("clockActivity: "+clockActivity);
		driver.startActivity(new Activity("com.google.android.apps.messaging", "com.google.android.apps.messaging.home.HomeActivity"));
		driver.findElement(By.id("com.google.android.apps.messaging:id/start_new_conversation_button")).click();
		driver.findElement(By.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("Balaji");
		
		/*System.out.println(driver.getKeyboard());
		System.out.println(driver.isKeyboardShown());
		driver.hideKeyboard();
		System.out.println(driver.isKeyboardShown());
		System.out.println(driver.getDeviceTime());
		*/driver.activateApp(clockPackage);

	}

}
