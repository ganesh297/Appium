package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeHorizonatllyDemo_SC {
	static DesiredCapabilities cap;
	
	static AppiumDriverLocalService service ;
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		serverStart();
		
		cap=new DesiredCapabilities();
		
		cap = new DesiredCapabilities();
	    cap.setCapability("noReset", "false");

	    //Build the Appium service
	   		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.dialer.DialtactsActivity");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.9, 0.1);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.9, 0.1);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.1, 0.9);
		Thread.sleep(2000);
		horizontalSwipeByPercentage(driver, 0.1, 0.9);
		
		stopServer();

	}
	
	public static void horizontalSwipeByPercentage(AppiumDriver<MobileElement> driver,double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();

        int y = (int) (size.height )/2;
        int x_startPoint = (int) (size.width * startPercentage);
        int x_endPoint = (int) (size.width * endPercentage);

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(x_startPoint, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(x_endPoint, y))
                .release().perform();
    }
	
	
	public static void serverStart(){
		 AppiumServiceBuilder builder = new AppiumServiceBuilder();
		    builder.withIPAddress("127.0.0.1");
		    builder.usingPort(4723);
		    builder.withCapabilities(cap);
		    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		    builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		     service = AppiumDriverLocalService.buildDefaultService();
		    //Start the server with the builder
		    service = AppiumDriverLocalService.buildService(builder);
		    service.start();
	}
	
	public static void stopServer() {
	    service.stop();
	}
}
