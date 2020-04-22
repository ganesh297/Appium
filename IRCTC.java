package com.appium.practice.Appium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// LAUNCHING IRCTC DRIVER
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[1]/app-header/div[2]/div[2]/div[1]/a[6]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("userName"))).isDisplayed();
		
		driver.findElement(By.name("userName")).sendKeys("mganesh297");		
		driver.findElement(By.name("usrPwd")).sendKeys("Qwerty123");
		driver.findElement(By.name("cnfUsrPwd")).sendKeys("Qwerty123");
		driver.findElement(By.xpath("//label[@class='ng-tns-c13-8 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='What is your pet name?']"))).isDisplayed();
		driver.findElement(By.xpath("//span[text()='What is your pet name?']")).click();		
		driver.findElement(By.xpath("//input[@formcontrolname='secAns']")).sendKeys("Tommy");
		
		
		driver.findElement(By.xpath("//label[@class='ng-tns-c13-9 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='English']"))).isDisplayed();
		driver.findElement(By.xpath("//span[text()='English']")).click();
		
		
		driver.findElement(By.name("firstName")).sendKeys("Ganesh");
		driver.findElement(By.id("M")).click();
		
		driver.findElement(By.xpath("//input[@class='ng-tns-c14-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).sendKeys("29-07-1995");
		
		driver.findElement(By.xpath("//label[@class='ng-tns-c13-11 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PROFESSIONAL']"))).isDisplayed();
		driver.findElement(By.xpath("//span[text()='PROFESSIONAL']")).click();
		
		driver.findElement(By.name("email")).sendKeys("ganesh.kmahalingam@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("9791131137");
		
		
		Select nationality=new Select(driver.findElement(By.xpath("//select[@formcontrolname='nationality']")));
		nationality.selectByVisibleText("India");
		
		
		driver.findElement(By.xpath("//textarea[@formcontrolname='resAddress1']")).sendKeys("Chennai");		
		driver.findElement(By.xpath("//input[@formcontrolname='resPinCode']")).sendKeys("600117");		
		driver.findElement(By.xpath("//input[@formcontrolname='resState']")).sendKeys("Tamil Nadu");		
		Thread.sleep(3000);
		Select city=new Select(driver.findElement(By.xpath("//select[@formcontrolname='resCity']")));
		city.selectByVisibleText("Kanchipuram");		
		Select postOffice=new Select(driver.findElement(By.xpath("//select[@formcontrolname='resPostOff']")));
		postOffice.selectByVisibleText("Kovilambakkam B.O");		
		driver.findElement(By.xpath("//input[@formcontrolname='resPhone']")).sendKeys("8653246");
	
		driver.findElement(By.xpath("//app-user-registration/div[2]/div/div[2]/div[4]/form/div[19]/div[2]/input")).click();
	
		//driver.findElement(By.xpath("//app-user-registration/div[2]/div/div[2]/div[4]/form/div[22]/div/input")).click();
		WebElement terms=driver.findElement(By.xpath("//app-user-registration/div[2]/div/div[2]/div[4]/form/div[22]/div/input"));	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", terms);

		driver.findElement(By.xpath("//app-user-registration/div[2]/div/div[2]/div[4]/form/div[24]/div[1]/button")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p-dialog/div/div[2]/app-registration-confirmation/div/div[3]/input[1]"))).isDisplayed();
		driver.findElement(By.xpath("//p-dialog/div/div[2]/app-registration-confirmation/div/div[3]/input[1]")).click();
		
		
			
	}

}
