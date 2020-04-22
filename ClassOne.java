package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClassOne {

	@Parameters({"udid","systemPort"})
	@Test
	public void a(String udid, String sysPort) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("avd","Pixel_XL_API_29");
		caps.setCapability("deviceName", "Pixel XL API 29");
		caps.setCapability(MobileCapabilityType.UDID, udid);
		caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, sysPort);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Sri\\workspace\\Appium\\Application.apk");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
