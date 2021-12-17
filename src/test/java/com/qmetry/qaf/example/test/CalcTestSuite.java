package com.qmetry.qaf.example.test;
import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.$;
import static com.qmetry.qaf.example.test.CalculatorUtils.*;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.StringMatcher;

public class CalcTestSuite extends WebDriverTestCase {
//	public static void main(String[] args) {
//		System.out.println(getElementWithLabel("9"));
//	}
	@Test
	@QAFDataProvider(dataFile = "resources/data/calcdata.txt")
	public void testCalc(Map<String, Object> testdata) {
		//get("https://qmetry.github.io/qaf/playground/calculator.html");
//		scenario().given("click on clear btn", ()-> {
//			click("")
//		})
//		
		$(CalculatorUtils.getDigitLoc(testdata.get("val1"))).click();
		$(testdata.get("operation") + ".btn.loc").click();
		$(CalculatorUtils.getDigitLoc(testdata.get("val2"))).click();
		$("eq.btn.loc").click();
		//only works on 1 platform
		//$("res.box.loc").verifyText(StringMatcher.eq(String.valueOf(testdata.get("expectedResult"))));
		verifyValue("res.box.loc", String.valueOf(testdata.get("expectedResult")));
		$("clear.btn.loc").click();
	}
	
}
