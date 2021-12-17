package com.qmetry.qaf.example.random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestTest {

  @Test
  public void testTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");	
		//Initiating your chromedriver
		WebDriver driver=new ChromeDriver();
			
		//maximize window
		driver.manage().window().maximize();
		
		//open browser with desried URL
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("cat" + Keys.ENTER);
		
		//Applied wait time
		Thread.sleep(5000);
		//closing the browser
		driver.close();
  }
}
