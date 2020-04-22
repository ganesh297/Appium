package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BKHybrid {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub


		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.cloudgrey.the_app");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\Webdrivers\\chromedriver.exe");
		
		
		//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.dialer.DialtactsActivity");
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		//driver.toggleWifi();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Webview Demo']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"urlInput\"]")).sendKeys("https://appiumpro.com");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Go']")).click();
		System.out.println(driver.getContextHandles());
		driver.context("WEBVIEW_io.cloudgrey.the_app");
		
		//System.out.println(driver.getPageSource());
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[text()='menu']/.."))).isDisplayed();
		driver.findElement(By.xpath("//i[text()='menu']/..")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("All Editions"))).isDisplayed();
		driver.findElement(By.linkText("All Editions")).click();
		driver.findElement(By.linkText("Paid Tools And Services For Mobile App Performance Testing")).click();
		
		driver.context("NATIVE_APP");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Clear']")).click();
		
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Dual Webview Demo']"))).isDisplayed();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Dual Webview Demo']")).click();
		
		
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName:contextNames){
			
			System.out.println("The context name is"+contextName);
			driver.context(contextName);
			if(!contextName.equalsIgnoreCase("NATIVE_APP")){
				wait.until(ExpectedConditions.elementToBeClickable(By.tagName("body"))).isDisplayed();	
			String textPresentIs=driver.findElement(By.tagName("body")).getText();
			System.out.println("The text is: "+textPresentIs );
			}
			
		}
		
		driver.context("NATIVE_APP");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='List Demo']"))).isDisplayed();
		driver.findElement(By.xpath("//android.widget.TextView[@text='List Demo']")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Altocumulus']"))).isDisplayed();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Altocumulus']")).click();
		
		
		wait.until(ExpectedConditions.alertIsPresent());
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println("The alert message is:"+alertMessage);
		
		driver.switchTo().alert().accept();
		
		driver.context("NATIVE_APP");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Picker Demo']"))).isDisplayed();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Picker Demo']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Spinner[@content-desc='monthPicker']"))).isDisplayed();
		driver.findElement(By.xpath("//android.widget.Spinner[@content-desc='monthPicker']")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='July']"))).isDisplayed();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='July']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Learn More']"))).isDisplayed();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Learn More']")).click();
		
		
		wait.until(ExpectedConditions.alertIsPresent());
		String dateMessage=driver.switchTo().alert().getText();
		System.out.println("The alert message is:"+dateMessage);
		
		driver.switchTo().alert().accept();
		
	}

}
