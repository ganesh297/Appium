package com.appium.practice.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AnyReminder {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.anyreminder");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.anyreminder.ReminderListTabsActivity");

		// caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
		// "D:\\Webdrivers\\chromedriver.exe");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		// driver.toggleWifi();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("com.anyreminder:id/fab")).click();
		driver.findElement(By.id("com.anyreminder:id/txtWakeUp")).click();
		WebElement name = driver.findElement(By.id("com.anyreminder:id/edtName"));

		/*
		 * TouchActions action = new TouchActions(driver);
		 * action.longPress(name); action.release(); action.perform();
		 */

		driver.findElement(By.id("com.anyreminder:id/action_save")).click();

		//boolean nameText = driver.findElement(By.id("com.anyreminder:id/tilName")).isDisplayed();
		//System.out.println("nameText: " + nameText);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		final String toastText = "Enter Name";
		wait.until(toastMatches(toastText, false));

	//	wait.until(toastMatches("^Catch.+!", true));

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
