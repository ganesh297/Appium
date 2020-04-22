package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Dimension {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.the511plus.MultiTouchTester");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MultiTouchTester");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		verticalSwipeByPercentages(driver, 0.8, 0.2);
		Thread.sleep(2000);

		verticalSwipeByPercentages(driver, 0.2, 0.8);
		Thread.sleep(2000);
		
		horizontalSwipeByPercentage(driver, 0.1, 0.9);
		Thread.sleep(2000);
		
		
		horizontalSwipeByPercentage(driver, 0.9, 0.1);
		Thread.sleep(2000);
		

	}
	
	public static void verticalSwipeByPercentages(AppiumDriver driver,double startPercentage, double endPercentage){
		
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		
		System.out.println(size);
		
		 int x = (int) (size.width)/2;
		 System.out.println("x value is: "+x);
		 
		 
		 int y_height = (int) (size.height);
		 System.out.println("y_height: "+y_height);
	      int y_startPoint = (int) (size.height * startPercentage);
	      System.out.println("y_startPoint: "+y_startPoint);
	      int y_endPoint = (int) (size.height * endPercentage);
	      System.out.println("y_endPoint: "+y_endPoint);
	      
	      TouchAction touchAction=new TouchAction(driver);
          touchAction.press(PointOption.point(x, y_startPoint))
          .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
          .moveTo(PointOption.point(x, y_endPoint))
          .release().perform();
	 	 
		
		
	}
	
	public static void horizontalSwipeByPercentage(AppiumDriver<MobileElement> driver,double startPercentage, double endPercentage) {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();

        int y = (int) (size.height )/2;
        int x_startPoint = (int) (size.width * startPercentage);
        int x_endPoint = (int) (size.width * endPercentage);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(x_startPoint, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(x_endPoint, y))
                .release().perform();
    }
	


}
