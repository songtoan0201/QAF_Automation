package com.qmetry.qaf.example.test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import static com.qmetry.qaf.automation.step.CommonStep.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.NewUserBean;

import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.*;


public class TestSuite extends WebDriverTestCase{
	@Test
	public void tc() {
		get("https://qmetry.github.io/qaf/playground/useraccount-form.html");
		
		NewUserBean userBean = new NewUserBean();
		
		$("firstName.loc").sendKeys("Toan");
		$("middleName.loc").sendKeys("Song");
		$("lastName.loc").sendKeys("Tran");
		
//		WebCalanderImpl cal = new WebCalanderImpl("calander.container.loc");
//		cal.verifyVisible();
//		cal.sendKeys("12/05/1955");
	
		$("martialstatus.loc").verifyDisabled();
		$("birthday.loc").click();
		$("birthday.loc").sendKeys("12/05/1955");
		$("birthday.loc").verifyAttribute("value", "12/05/1955");
		$("martialstatus.loc").verifyEnabled();
		$("birthday.loc").sendKeys("15-May-2016", "dd--MMM-yyyy");
		$("birthday.loc").verifyAttribute("value", "05/15/2016");
		$("martialstatus.loc").verifyDisabled();
		
		$("birthday.loc").sendKeys("05/25/1990");
		
		$("martialstatus.loc").assertEnabled();
		$("martialstatus.loc").click();	
		$("spousebirthdate.loc").sendKeys("06/11/1991");
		$("marriagedate.loc").sendKeys("06/11/2020");
		
	}
	
	
	
}
