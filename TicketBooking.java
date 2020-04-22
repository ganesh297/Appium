package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TicketBooking {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\Webdrivers\\chromedriver.exe");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://m.ticketnew.com");
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		System.out.println(driver.getPageSource());
		
		//driver.findElement(By.xpath("//input[@id='J_regionSearchKey']")).sendKeys("Chennai");
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		//driver.findElement(By.xpath("(//a[@data-regionname='Chennai'])[1]")).click();
		
		
		WebElement region=driver.findElement(By.xpath("(//a[@data-regionname='Chennai'])[1]"));	


		((JavascriptExecutor) driver).executeScript("arguments[0].click();", region);

		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"J_regionGroup_gps\"]/li[2]/div/a/span[4]"))).isDisplayed();		
		//driver.findElement(By.xpath("//*[@id=\"J_regionGroup_gps\"]/li[2]/div/a/span[4]")).click();
		
		
		try{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Retry']"))).isDisplayed();		
			WebElement BA=driver.findElement(By.xpath("//span[text()='Retry']"));	


			((JavascriptExecutor) driver).executeScript("arguments[0].click();", BA);


			
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	
		
		}catch(Exception e){
			System.out.println("Alert is not getting displayed");
			
		}
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Chennai"))).isDisplayed();
		
		//WebElement region=driver.findElement(By.linkText("Chennai"));	


		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", region);

		Thread.sleep(5000);
	     int count=driver.findElements(By.xpath("//div[@class='poster lazy']")).size();
	     System.out.println("Film Count: "+count);
	     
	     
	     driver.findElement(By.xpath("(//a[text()='Book'])[3]")).click();	     
	     driver.findElement(By.xpath("(//div[@class='time-day'])[2]")).click();		 
	     driver.findElement(By.xpath("(//div[text()='Padmam 4K RGB Laser Dolby Atmos'])[1]")).click();	    
	     
	     driver.findElement(By.linkText("OTP Login")).click();	     
	     driver.findElement(By.id("J_otpMobile")).sendKeys("9791131137");
	     driver.findElement(By.id("J_btnSendCode")).click();
	     
	     
		//Need to navigate to Message Box and get OTP
	     
	     
	}

}
