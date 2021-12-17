package com.qmetry.qaf.example.test;

import java.util.Date;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;

/**
 * @author chirag
 *
 */
public class CalanderInput extends QAFWebComponent {
	
	public CalanderInput(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
	}
	
	public CalanderInput(String locator) {
		super(locator);
	}
	
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		WebCalanderImpl cal = getCalander();
		cal.sendKeys(keysToSend);
		cal.waitForNotVisible();
	}
	public void setDate(Date date) {
		getCalander().setDate(date);
	}
	
	private WebCalanderImpl getCalander(){
		WebCalanderImpl cal = new WebCalanderImpl("calander.container.loc");
		if(!cal.isDisplayed()) {
			click();
		}
		return cal;
	}
}
