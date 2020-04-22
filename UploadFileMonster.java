package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class UploadFileMonster {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.monsterindia.seeker.views");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.monsterindia.seeker.views.view.splash.SplashActivity");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Done']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Register']")).click();
		
		//SCROLL INTO VIEW
		
		
		
		verticalSwipeByPercentages(driver, 0.8, 0.2);
		Thread.sleep(2000);

		verticalSwipeByPercentages(driver, 0.8, 0.2);
		Thread.sleep(2000);
	
		/*WebElement UR=driver.findElement(By.xpath("//android.widget.TextView[@text='Upload Resume']"));
		TouchActions action = new TouchActions(driver);
		action.scroll(UR, 10, 100);
		action.perform();
*/
		
	/*	JavascriptExecutor je = (JavascriptExecutor) driver;
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='Upload Resume']"));
		
		je.executeScript("arguments[0].scrollIntoView(true);",element);
*/

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Upload Resume']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mobile']")).click();
		
		try{
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
	
		}catch(Exception e){
			
		}
		
		
	List<WebElement> fileNames=	driver.findElements(By.id("com.monsterindia.seeker.views:id/tv_file_title"));
	List<WebElement> fileNamesCB=	driver.findElements(By.id("com.monsterindia.seeker.views:id/cbx"));
		
		for(WebElement fileName: fileNames){
			System.out.println(fileName);
		}
		
		
		int fns=driver.findElements(By.id("com.monsterindia.seeker.views:id/tv_file_title")).size();
		
		
		for(int i=0;i<fns;i++){
			
			String files=fileNames.get(i).getText();
			System.out.println(files);
			
			if(files.equalsIgnoreCase("Ganesh M_Resume.docx")){
				fileNamesCB.get(i).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
				
				break;
			}
			
			}
		}
		
		
		
	
	 public static void verticalSwipeByPercentages(AppiumDriver driver,double startPercentage, double endPercentage) {
	        Dimension size = driver.manage().window().getSize();
	        int x = (int) (size.width)/2;
	        int y_startPoint = (int) (size.height * startPercentage);
	        int y_endPoint = (int) (size.height * endPercentage);
	 
	        TouchAction touchAction=new TouchAction(driver);
	                touchAction.press(PointOption.point(x, y_startPoint))
	                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                .moveTo(PointOption.point(x, y_endPoint))
	                .release().perform();
	    }

	
}
