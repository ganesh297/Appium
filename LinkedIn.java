package com.appium.practice.Appium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		// LAUNCHING
		driver.get("https://www.linkedin.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("session_key")).sendKeys("ganesh.kmahalingam@gmail.com");
		driver.findElement(By.name("session_password")).sendKeys("ultimate123@");
		driver.findElement(By.xpath("//button[@class='sign-in-form__submit-btn']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='search-global-typeahead__input always-show-placeholder']"))).isDisplayed();
		driver.findElement(By.xpath("//input[@class='search-global-typeahead__input always-show-placeholder']")).sendKeys("Selenium");

	}

}
