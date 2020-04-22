package com.appium.practice.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ContactsList {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZF6223D8QM");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.motorola.dialer.app.ExtendedDialtactsActivity");
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		int count;
		int totalsize;

		driver.findElementByAccessibilityId("Contacts tab.").click();
		
		int totalContacts=0;
		while(true){



			count=	driver.findElements(By.id("com.android.dialer:id/cliv_name_textview")).size();
			System.out.println(count);

			List<MobileElement> list1 = driver.findElements(By.id("com.android.dialer:id/cliv_name_textview"));
			
			List<String> list2=new ArrayList<String>();
			for(MobileElement CL1:list1){
			String conName1=CL1.getText();
			list2.add(conName1);
			
			//System.out.println(conName1);
			}
			totalContacts=totalContacts+list2.size();
			System.out.println(list2);
			verticalSwipeByPercentages(driver, 0.8, 0.2);
			Thread.sleep(2000);
			
			
			
			List<MobileElement> list3 = driver.findElements(By.id("com.android.dialer:id/cliv_name_textview"));
			
			List<String> list4=new ArrayList<String>();
			for(MobileElement CL2:list3){
			String conName2=CL2.getText();
			list4.add(conName2);
			//System.out.println(conName2);
			}
			totalContacts=totalContacts+list4.size();
			
			System.out.println(list4);
			
			
			if (list2.equals(list4)){ 
	            System.out.println("Equal");
	            break;
			}
	        else{
	            System.out.println("Not equal");
	            verticalSwipeByPercentages(driver, 0.8, 0.2);
				Thread.sleep(2000);
				
	        }
	   
			
			/*totalsize=driver.findElements(By.id("com.android.dialer:id/cliv_name_textview")).size();

			totalsize=totalsize+count;
			System.out.println("totalsize: "+totalsize);
			if(count==totalsize){
				break;
			}
			else{
				count=totalsize;
			}
*/		}

		System.out.println("Total Contact Count: "+totalContacts);


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
