package com.qmetry.qaf.example.steps;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qmetry.qaf.automation.core.QAFListenerAdapter;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

public class QAFListenerImpl extends QAFListenerAdapter {
//	@Override
//	public void beforeInitialize(Capabilities desiredCapabilities) {
//		System.out.println(desiredCapabilities);
//		ChromeOptions op = new ChromeOptions();
//		op.addArguments("start-maximized");
//		desiredCapabilities.merge(op);
//		System.out.println(desiredCapabilities);
//	}
	
	@Override
	public void onInitialize(QAFExtendedWebDriver driver) {
		driver.get("https://qmetry.github.io/qaf/playground/calculator.html");
	}
	
//	public static void main(String[] args) {
//		ChromeOptions op = new ChromeOptions();
//		WebDriver driver = new ChromeDriver(op);
//		
//	}
}
