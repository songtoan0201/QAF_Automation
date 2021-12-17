package com.qmetry.qaf.example.test;

import org.testng.annotations.Test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class AppiumSetUpTestSuit{
	
    @Test
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AppiumDriver driver = new AppiumDriver(url, capabilities);
        
        driver.get("http://saucelabs.com/test/guinea-pig");
        WebElement div = driver.findElement(By.id("i_am_an_id"));
        Assert.assertEquals("I am a div", div.getText()); //check the text retrieved matches expected value
        driver.findElement(By.id("comments")).sendKeys("My comment"); //populate the comments field by id.

      //  AndroidDriver<WebElement>
    }

}