package com.qmetry.qaf.example.random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestTest3 {

  @Test
  public void testTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
  	
      String baseUrl = "http://demo.guru99.com/test/newtours/";
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = "";

      // launch Fire fox and direct it to the Base URL
      driver.get(baseUrl);

      // get the actual value of the title
      actualTitle = driver.getTitle();
      
      /*
       * compare the actual title of the page with the expected one and print
       * the result as "Passed" or "Failed"
       */
      if (actualTitle.contentEquals(expectedTitle)){
          System.out.println("Test Passed!");
      } else {
          System.out.println("Test Failed");
      }
     
      Thread.sleep(5000);
      //close 
      driver.close();
  }
}
