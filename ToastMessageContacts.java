package com.appium.practice.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


import org.bytedeco.javacpp.*;
import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;


public class ToastMessageContacts {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AppiumDriver driver;
				DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		//caps.setCapability("automationName", "Espresso");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.motorola.dialer.app.ExtendedDialtactsActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByAccessibilityId("Contacts tab.").click();
		driver.findElementByAccessibilityId("Create new contact").click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Fr");
		driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		//final String toastText = "Fr saved";
		//wait.until(toastMatches(toastText, false));
		
		
		BytePointer outText;
        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(null, "eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }
        // Open input image with leptonica library
        PIX image = pixRead(args.length > 0 ? args[0] : "D:\\ToastMessages\\phototest.tif");
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        System.out.println("OCR output:\n" + outText.getString());
        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);

				

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ExpectedCondition<Boolean> toastMatches(String matchText, Boolean isRegexp) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				ImmutableMap<String, Object> args = ImmutableMap.of("text", matchText, "isRegexp", isRegexp);
				return (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: isToastVisible", args);
			}

		};

	}

}
