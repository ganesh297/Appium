package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


import org.bytedeco.javacpp.*;
import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;


public class JustReminder {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		 DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability("automationName", "Espresso");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.smsoft.justremind");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "in.smsoft.lib.lock.LockActivity");
	
		
		
		//caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\Webdrivers\\chromedriver.exe");
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		//driver.toggleWifi();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().alert().accept();
		driver.findElement(By.id("in.smsoft.justremind:id/fav_add_rmd")).click();
		//driver.findElement(By.id("in.smsoft.justremind:id/et_add_title")).sendKeys("Alarm");
		
		driver.getClipboard(ClipboardContentType.PLAINTEXT); // get plaintext
		String text=driver.getClipboardText();
		System.out.println(text);
		driver.findElement(By.id("in.smsoft.justremind:id/et_add_title")).sendKeys(text);
		
		driver.findElement(By.id("in.smsoft.justremind:id/tv_ab_act_item")).click();
		
		//System.out.println(driver.getPageSource());
		
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[@text='Please set reminder for upcoming time']"))).isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		final String toastText = "Please set reminder for upcoming time";
		wait.until(toastMatches(toastText, false));

		    		

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
