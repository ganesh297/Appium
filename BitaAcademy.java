package com.appium.practice.Appium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BitaAcademy {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//System property
				System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				// LAUNCHING
				driver.get("https://bitaacademy.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//img[@itemprop='logo']")).isDisplayed();
				
				//boolean aboutUS=driver.findElement(By.linkText("About Us")).isDisplayed();
				//System.out.println("aboutUS: "+aboutUS);
				
				boolean aboutUS=driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]")).isDisplayed();
				System.out.println("aboutUS: "+aboutUS);
			
				
				driver.findElement(By.name("search")).sendKeys("Selenium");
				Thread.sleep(3000);
				
				WebDriverWait wait=new WebDriverWait(driver,10);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='js-fieldIcon fieldIcon fa fa-search']"))).isDisplayed();

				
			List<WebElement> searchLists=driver.findElements(By.xpath("//*[@id='searchField']/ul/li"));
				
			for(WebElement searchList:searchLists){
				String names=searchList.getText();
				System.out.println("Course Names: "+names);
				if(names.equalsIgnoreCase("selenium")){
					System.out.println("Search text is found: "+names);
					break;
				}
				
			}
				
				for(int i=1;i<=searchLists.size();i++){				
					driver.findElement(By.xpath("//*[@id='searchField']/ul/li["+i+"]/a")).click();				
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div/div[1]/ol/li[3]"))).isDisplayed();
					
					String courseName=driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div/div[2]/div/div/div[1]/ol/li[3]")).getText();
					System.out.println("courseName: "+courseName);
					//Get the Course Name
					if(i!=searchLists.size()){
					driver.findElement(By.name("search")).sendKeys("Selenium");
					Thread.sleep(3000);
					}
				
				}
					
				
				
				
			
			
	}

}
