package com.qmetry.qaf.example.random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTest2 {

  @Test
  public void testTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qmetry.github.io/qaf/playground/useraccount-form.html");
		WebElement firstname=driver.findElement(By.id("firstname"));
		WebElement middlename=driver.findElement(By.id("middlename"));
		WebElement lastname=driver.findElement(By.id("lastname"));
		WebElement username=driver.findElement(By.id("username"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement confirm_password=driver.findElement(By.id("confirm_password"));
		WebElement email=driver.findElement(By.id("email"));
		
		//handle date
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement birthdate = driver.findElement(By.id("birthdate"));
	    //js.executeScript("document.getElementByID('birthdate').setAttribute('readonly', false)");
	    //js.executeScript("arguments[0].setAttribute('readonly', false)",birthdate);
	    js.executeScript("$(birthdate).prop('readonly', false)");
		WebElement checkbox=driver.findElement(By.name("agree"));
		WebElement submit=driver.findElement(By.className("submit"));
			    
		firstname.sendKeys("Toan");
		middlename.sendKeys("Song");
		lastname.sendKeys("Tran");
		username.sendKeys("abc");
		password.sendKeys("your_password");
		confirm_password.sendKeys("your_password");
		email.sendKeys("abc@gmail.com");
		birthdate.sendKeys("01/01/2010" + Keys.ENTER);
		checkbox.click();
		submit.click();
		
		String actualTitle="User Details";
		String expectedTitle= driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle);
		Thread.sleep(5000);
		driver.close();
  }
}
