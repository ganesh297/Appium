package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RedBus {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.redbus.android");
		//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "in.smsoft.lib.lock.LockActivity");
		
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\Webdrivers\\chromedriver.exe");
		caps.setCapability("autoGrantPermissions", true);
		//caps.setCapability(“autoGrantPermissions”, true);
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
		driver.get("http://redbus.in");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String con=driver.getContext();
		System.out.println(con);
		
		
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.pressKey(new KeyEvent(AndroidKey.CAMERA));
		/*driver.context("NATIVE_APP");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.context(con);
		System.out.println(con);
		try{
			
			driver.context("NATIVE_APP");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(5000);
			driver.context(con);
			System.out.println(con);
			
		}catch(Exception e){
			
			
		}
	   
	*/
		driver.findElement(By.xpath("//android.widget.Button[@text='Allow']")).click();
		Thread.sleep(5000);
	driver.findElement(By.xpath("//textarea[@name='fromIp']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='suggestInput']")).sendKeys("Chennai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"suggestedCities\"]/li[1]")).click();
		Thread.sleep(3000);
		
		
		
		
		driver.findElement(By.xpath("//textarea[@name='toIp']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='suggestInput']")).sendKeys("Bangalore");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"suggestedCities\"]/li[1]")).click();
		
		Thread.sleep(5000);
		
		
		
		
		driver.findElement(By.xpath("//*[@id=\"search_button\"]")).click();
		
		//int count=driver.findElements(By.xpath("//div[@data-autoid='tvl-name']")).size();
		//System.out.println("count: "+count);
		int count;
		int totalsize;	
		while(true){
			count=driver.findElements(By.xpath("//div[@data-autoid='tvl-name']")).size();
			System.out.println("count: "+count);
		WebElement element = driver.findElement(By.xpath("(//div[@data-autoid='tvl-name'])["+count+"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(5000);
		
		
	 totalsize=driver.findElements(By.xpath("//div[@data-autoid='tvl-name']")).size();
		System.out.println("totalsize: "+totalsize);
		
		if(count==totalsize){
			break;
		}
		else{
			count=totalsize;
		}
				}
		
		System.out.println("Total Count is: "+totalsize);
		

	}

}
