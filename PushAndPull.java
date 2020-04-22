package com.appium.practice.Appium;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class PushAndPull {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.lenovo.FileBrowser2");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.lenovo.FileBrowser.activities.FileBrowserMain");
	
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		//byte[] fileBase64 = driver.pullFile("/storage/emulated/0/DCIM/Camera/IMG_20200226_221514417.jpg");
        //FileUtils.writeByteArrayToFile(new File("D:\\A.jpg"), fileBase64);

		driver.pushFile("/storage/emulated/0/DCIM/Camera/butterfly.jpg", new File("D:\\butterfly.jpg"));
        
        
        
		
	}

}
