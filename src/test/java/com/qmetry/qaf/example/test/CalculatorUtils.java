package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.$;

import com.qmetry.qaf.automation.step.QAFTestStep;

public class CalculatorUtils {
	public static String getDigitLoc(Object lbl) {
		try {
			String format = getBundle().getString("btn.loc.format");
			//System.out.println(format);
			return (String.format(format, lbl, lbl));
		} catch (Exception e) {
			return "";
		}
	}
	
	
	@QAFTestStep(description = "click on button {lbl}")
	public static void clickBtn(String lbl) {
		//$(getDigitLoc(lbl).click());
	}
}
