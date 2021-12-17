package com.qmetry.qaf.example.test;

import java.util.List;

import org.openqa.selenium.ElementNotSelectableException;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.StringUtil;

/**
 * @author chirag
 *
 */
public class SelectBox extends QAFWebComponent {
	
	@FindBy(locator = "css=option")
	List<QAFWebElement> options;
	
	@FindBy(locator = "css=option[selected]")
	QAFWebElement selectedOption;

	public SelectBox(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
	}
	
	public SelectBox(String locator) {
		super(locator);
	}
	
	@Override
	public String getText() {
		return selectedOption.getText();
	}
	
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		QAFWebElement op = getOption(keysToSend[0].toString());
		op.click();
	}

	private QAFWebElement getOption(String text) {
		QAFWebElement op = new QAFExtendedWebElement(this,String.format("xpath=.//option[contains(.,'%s')]",text));
		if(op.isPresent()) {
			if(!op.isDisplayed())
				this.click();
			return op;
		}
		if(StringUtil.isNumeric(text)) {
			QAFWebElement op1 = options.get(0);
			if(!op1.isDisplayed()) {
				this.click();
			}
				
			String op1Text = op1.getText();
			if(Integer.parseInt(text)<Integer.parseInt(op1Text)){
				if(getText().equalsIgnoreCase(op1Text)) {
					//no more options available
					throw new ElementNotSelectableException("options not found with text " + text);
				}
				op1.click();
			}else {
				QAFWebElement lastOP = options.get(options.size() - 1);
				if(getText().equalsIgnoreCase(lastOP.getText())) {
					//no more options available
					throw new ElementNotSelectableException("options not found with text " + text);				}
				lastOP.click();
			}
			//FIX to work with 4.0.0
			setId("-1");
			return getOption(text);
		}
		throw new ElementNotSelectableException("options not found with text " + text);				
	}
}
