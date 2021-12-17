package com.qmetry.qaf.example.random;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({util.Listener.class})
//class TestTest4 {
//  public String username = "YOUR USERNAME";
//  public String accesskey = "YOUR ACCESSKEY";
//  public static RemoteWebDriver driver = null;
//  public String gridURL = "@hub.lambdatest.com/wd/hub";
// 
//  @BeforeTest
//  public void setUp() throws Exception {
//      DesiredCapabilities capabilities = new DesiredCapabilities();
//      capabilities.setCapability("browserName", "chrome");
//      capabilities.setCapability("version", "94.0");
//      capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
//      capabilities.setCapability("build", "FirstTestScript");
//      capabilities.setCapability("name", "FirstTestScriptSample");
//      try {
//          driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
//      } catch (MalformedURLException e) {
//          System.out.println("Invalid grid URL");
//      } catch (Exception e) {
//          System.out.println(e.getMessage());
//      }
//  }
// 
//  @Test
//  public void firstTestCase() {
//      try {
//          System.out.println("Logging into Lambda Test Sign Up Page");
//          driver.get("https://accounts.lambdatest.com/register");
//          WebElement pageHeader= driver.findElement(By.xpath("//a[text()='Sign In']"));
//          pageHeader.click();
//          System.out.println("Clicked on the Sign In Button.");
//      } catch (Exception e) {
// 
//      }
//   }
// 
//  @AfterTest
//  public void closeBrowser() {
//      driver.close();
//      System.out.println("The driver has been closed.");
//  }
//}