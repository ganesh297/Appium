package com.appium.practice.Appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.GsmCallActions;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class NativeApp {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator-5.5");
		//caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		//caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.dialer.DialtactsActivity");
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);result
		
		
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Contacts\"]")).click();
		
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Create new contact\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys("Ganesh");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("98653467");
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Save"))).isDisplayed();
		driver.findElementByAccessibilityId("Save").click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='DELETE']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search contacts']")).click();

		driver.findElement(By.id("com.android.dialer:id/search_view")).sendKeys("Ganesh");
		Thread.sleep(3000);
		int size=	driver.findElements(By.id("com.android.dialer:id/cliv_name_textview")).size();
		System.out.println("size:"+size);
		
		
		//driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		//Thread.sleep(3000);
		
		
		//driver.hideKeyboard();
		/*driver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		driver.findElement(By.id("com.android.calculator2:id/op_mul")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
		driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		
		String result=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		
		System.out.println("result: "+result);
		

		*/
		
		//Get orientation
		ScreenOrientation orientation = null;
		System.out.println(driver.getOrientation());
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		System.out.println(driver.getOrientation());

		driver.rotate(ScreenOrientation.PORTRAIT);
		System.out.println(driver.getOrientation());
		
		
		//driver.back();   //Doubt
		
		//Screenshot
	//	File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(file, new File("Screenshot.jpg"));
		
		
		//Session ID
		String sessionId = driver.getSessionId().toString();
		System.out.println("sessionId: "+sessionId);
		
		
		
		Map<String, Object> SD = driver.getSessionDetails();
		System.out.println(SD.entrySet());
		System.out.println(SD.values());
		
		//Page Source
		String pageSource = driver.getPageSource();
		//System.out.println("pageSource: "+pageSource);
		
		
		//Location location = driver.location(); 
		//driver.setLocation(new Location(49, 123, 10)); 
		
		
		Set<String> logTypes = driver.manage().logs().getAvailableLogTypes();
		
		Iterator it=logTypes.iterator();
		while(it.hasNext()){
			System.out.println("Log Types: "+it.next());
		}
		
		//LogEntries logEntries = driver.manage().logs().get("driver");
		
		//System.out.println("logEntries: "+logEntries);
		
		//driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, Duration.ofSeconds(5));
		
		
		//Map<String, Object> settings = driver.getSettings();
		
		//System.out.println(driver.runAppInBackground(Duration.ofSeconds(10)));
		

		//driver.shake();
		//driver.lockDevice();
		Thread.sleep(3000);
		//driver.unlockDevice();
		//boolean isLocked = driver.isDeviceLocked();
		//boolean isKeyboardShown = driver.isKeyboardShown();
		
		
		
		//Network
		/*driver.toggleAirplaneMode();
		driver.toggleData();
		driver.toggleWifi();
		driver.toggleLocationServices();
		driver.sendSMS("555-123-4567", "Hey lol");
		driver.makeGsmCall("5551234567", GsmCallActions.CALL); */
		
		//Recording
		/*driver.startRecordingScreen();
		driver.startRecordingScreen(new BaseStartScreenRecordingOptions(....));

		driver.stopRecordingScreen();
		driver.stopRecordingScreen(new BaseStopScreenRecordingOptions(....));*/

		//driver.openNotifications();
		
		//driver.closeApp();
		
				
		}
		
	}


