package com.qmetry.qaf.example.test;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import com.qmetry.qaf.example.steps.LoginFormBean;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.*;
import java.util.Map;

public class TestSuite1 extends WebDriverTestCase{

	@Test
	@QAFDataProvider(dataFile = "resources/data/logindata.csv")
	public void login(Map<String, Object> testdata) {
		get("https://qmetry.github.io/qaf/playground/login.html");
		LoginFormBean loginFormBean = new LoginFormBean();
		loginFormBean.fillData(testdata);
		//loginFormBean.fillUiElements();
		
//		loginFormBean.fillUiRequiredElements();
//		$("username.loc").verifyValue(loginFormBean.getUsername());
		$("submit.login").click();
		//Validator.verifyThat("Password error", testdata.get("pwd-error"), Matchers.equalTo("id=password-error"));
//		if((boolean)testdata.get("pwd-error")) {
//			$("password-error").verifyVisible();
//		}
		System.out.println(testdata);
	}
	
//	public void calcTest() {
//		get("https://qmetry.github.io/qaf/playground/calculator.html");
//		$(CalculatorScreen.getDigitLoc("9")).click();
//		$("plus.btn.loc").click();
//		$(CalculatorScreen.getDigitLoc("3")).click();
//		$("eq.btn.loc").click();
//		
//	}
	
}
