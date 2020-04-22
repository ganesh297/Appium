package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Fynd {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps= new DesiredCapabilities();		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "co.go.fynd");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "co.go.fynd.activity.AppHomeActivity");
		
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		System.out.println(driver.isAppInstalled("co.go.fynd"));

		//driver.installApp("");
		
		//driver.toggleWifi();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='LOGIN']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Continue with Mobile']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='097911 31137']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Use SMS']")).click();
		Thread.sleep(3000);
		
		int count=driver.findElements(By.xpath("//android.widget.EditText")).size();
		System.out.println("count: "+count);
		
		
		String fyndActivity=driver.currentActivity();
		String fyndPackage=driver.getCurrentPackage();
		System.out.println("fyndActivity: "+fyndPackage);
		driver.startActivity(new Activity("com.google.android.apps.messaging", "com.google.android.apps.messaging.home.HomeActivity"));
		
		//READING FROM MESSAGES
		
		Thread.sleep(3000);
		System.out.println(driver.findElements(By.xpath("//android.widget.TextView")).size());
		List<WebElement> mess=driver.findElements(By.xpath("//android.widget.TextView"));
		mess.get(0).click();
		System.out.println(driver.findElements(By.xpath("//android.widget.FrameLayout")).size());
		
		int i = driver.findElements(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']")).size();
		System.out.println(driver.findElement(By.xpath("//android.widget.FrameLayout["+i+"]//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']")).getText());

		
		System.out.println(driver.findElement(By.xpath("//android.widget.FrameLayout["+i+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']")).getText());
		String OTPM=driver.findElement(By.xpath("//android.widget.FrameLayout["+i+"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']")).getText();
		OTPM = OTPM.replaceAll("[^0-9]", "");
		System.out.println("OTP is "+OTPM);
		
		//System.out.println(driver.findElement(By.xpath("//*[contains(text(),'as your login code']")).getText());
				//System.out.println(driver.getPageSource());
		
		
		//BACK TO FYND APP	
		
		driver.activateApp(fyndPackage);
		System.out.println("fyndPackage: "+fyndPackage);
		
		/*driver.startActivity(new Activity(fyndPackage,fyndActivity));
		System.out.println(driver.currentActivity());
		System.out.println(driver.getCurrentPackage());
		System.out.println("fyndActivity: "+fyndPackage);
		*/
		Thread.sleep(2000);
		
		//driver.navigate().back();
		
		List<WebElement> OPTTexts=driver.findElements(By.xpath("//android.widget.EditText"));
		int j=0;
		char[] OTPMSplit=OTPM.toCharArray();
		for(char c:OTPMSplit){
		
			String OTPmyStr = Character. toString(c);
			System.out.println("OTPmyStr-Single"+OTPmyStr);
			for(;j<OPTTexts.size();j++){
			
				OPTTexts.get(j).sendKeys(OTPmyStr);
				break;
			}
		}
			
		
	}

}
