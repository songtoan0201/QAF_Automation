package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;

import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.*;

public class SampleTest extends WebDriverTestCase {

	@BeforeTest
	public void lunchBrower() {
		get("https://qmetry.github.io/qaf/playground/useraccount-form.html");
	}
	
	@Test(groups="name")
	public void sendFirstNameTest(){
		//QAFWebElement firstName = getDriver().findElement(By.id("firstname"));
		QAFWebElement firstname = $("firstname.loc");
		firstname.sendKeys("Toan");
		firstname.assertValue("Toan");
	}
	
	@Test(groups="name")
	public void sendMiddleNameTest(){
		QAFWebElement middlename = $("middlename.loc");
		middlename.sendKeys("Song");
		middlename.assertValue("Song");
	}
	
	@Test(groups="name")
	public void sendLastNameTest(){
		QAFWebElement lastname = $("lastname.loc");
		lastname.sendKeys("Tran");
		lastname.assertValue("Tran");
	}
	
	@Test(dependsOnGroups="name", groups="account")
	public void sendUserNameTest(){
		QAFWebElement userName = getDriver().findElement(By.id("username"));
		userName.click();
		userName.assertValue("Toan.Tran");
	}
	
	@Test(dependsOnMethods="sendUserNameTest", groups="account" )
	public void sendPasswordTest(){
		QAFWebElement password = getDriver().findElement(By.id("password"));
		password.sendKeys("123456");
		password.assertValue("123456");
	}
	
	@Test(dependsOnMethods="sendPasswordTest", groups="account")
	public void sendConfirmPasswordTest(){
		QAFWebElement comfirmPassword = getDriver().findElement(By.id("confirm_password"));
		comfirmPassword.sendKeys("123456");
		comfirmPassword.assertValue("123456");
	}
	
	@Test(dependsOnMethods="sendConfirmPasswordTest", groups="account")
	public void sendEmailTest(){
		QAFWebElement email = getDriver().findElement(By.id("email"));
		email.sendKeys("toan@gmail.com");
		email.assertValue("toan@gmail.com");
	}
	
	@Test(dependsOnMethods="sendEmailTest", groups="account")
	public void sendBirthDateTest(){
		QAFWebElement birthDate = getDriver().findElement(By.id("birthdate"));
		birthDate.click();
		QAFWebElement datePicker = getDriver().findElement("id=ui-datepicker-div");
		datePicker.assertPresent();
		QAFWebElement date = getDriver().findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]/a"));
		date.click();
		birthDate.assertValue("12/02/2016");
	}
	
	@Test(dependsOnMethods="sendBirthDateTest", groups="account")
	public void agreePolicyTest(){
		QAFWebElement policyBox = getDriver().findElement(By.id("agree"));
		policyBox.click();
		policyBox.assertSelected();
	}
	
	@Test(dependsOnMethods="agreePolicyTest", groups="account")
	public void receiveNewsletterTest(){
		QAFWebElement newsBox = getDriver().findElement(By.id("newsletter"));
		newsBox.click();
		newsBox.assertSelected();
	}
	
	@Test(dependsOnMethods="receiveNewsletterTest", groups="account")
	public void selectNewslettersTest(){
		QAFWebElement newsletter1 = getDriver().findElement(By.id("topic_marketflash"));
		QAFWebElement newsletter2 = getDriver().findElement(By.id("topic_fuzz"));
		QAFWebElement newsletter3 = getDriver().findElement(By.id("topic_digester"));
		newsletter1.click();
		newsletter2.click();
		newsletter3.click();
		newsletter1.assertSelected();
		newsletter2.assertSelected();
		newsletter3.assertSelected();
	}
	
	@Test(dependsOnGroups="account")
	public void submitTest() throws InterruptedException{
		QAFWebElement sumbitForm = getDriver().findElement(By.className("submit"));
		sumbitForm.submit();
		
		QAFWebElement title = getDriver().findElement(By.tagName("title"));
		title.assertText(title.getText(), "User Details");
		Thread.sleep(5000);
	}
	
}
