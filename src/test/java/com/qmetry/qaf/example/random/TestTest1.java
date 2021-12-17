package com.qmetry.qaf.example.random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestTest1 {

  @Test
  public void testTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");	
		//Initiating your chromedriver
		WebDriver driver=new ChromeDriver();
		 
		//maximize window
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/documentation/webdriver/locating_elements/");
		
//		((JavascriptExecutor) driver).executeScript("window.open()");
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
		
		//class name	Locates elements whose class name contains the search value (compound class names are not permitted)
		System.out.println(driver.findElement(By.className("nav-link active tab-Java")).getText());
		
		//css selector	Locates elements matching a CSS selector
		System.out.println(driver.findElement(By.cssSelector("#element-selection-strategies")).getText());
		
		//id	Locates elements whose ID attribute matches the search value
		System.out.println(driver.findElement(By.id("element-selection-strategies")).getText());
		
		//name	Locates elements whose NAME attribute matches the search value
		System.out.println(driver.findElement(By.id("element-selection-strategies")).getText());
		
		//link text	Locates anchor elements whose visible text matches the search value
		driver.findElement(By.linkText("SearchContext")).click();
		
		//partial link text	Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected.
		driver.findElement(By.partialLinkText("Context")).click();
		
		//tag name	Locates elements whose tag name matches the search value
		driver.findElement(By.tagName("nav"));
		
		//xpath	Locates elements matching an XPath expression
		System.out.println(driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/table/thead/tr/th[1]")).getText());
  }
}
