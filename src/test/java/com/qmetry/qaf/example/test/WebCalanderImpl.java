package com.qmetry.qaf.example.test;

import java.text.ParseException;
import java.util.Date;

import com.qmetry.qaf.automation.core.AutomationError;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.DateUtil;

/**
 * @author chirag
 *
 */
public class WebCalanderImpl extends QAFWebComponent {
	
	@FindBy(locator = "prev.btn.loc")
	private QAFWebElement prevBtn;
	
	@FindBy(locator = "next.btn.loc")
	private QAFWebElement nextBtn;

	@FindBy(locator = "month.selectbox.loc")
	private SelectBox monthSelection;
	
	@FindBy(locator = "year.selectbox.loc")
	private SelectBox yearSelection;
		
	public WebCalanderImpl(QAFExtendedWebElement parent, String locator) {
		super(parent, locator);
	}
	
	public WebCalanderImpl(String locator) {
		super(locator);
	}
	
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		String date = keysToSend[0].toString();
		String format = keysToSend.length>1?keysToSend[1].toString():DateUtil.DEFAULT_DATE_FORMAT;
		try {
			Date d = DateUtil.parseDate(date,format);
			setDate(d);
		} catch (ParseException e) {
			throw new AutomationError(e);
		}
	}
	
	public void setDate(Date date) {
		String month = DateUtil.getFormatedDate(date, "MMM");
		String year = DateUtil.getFormatedDate(date, "yyyy");
		String day = DateUtil.getFormatedDate(date, "d");
		
		yearSelection.sendKeys(year);
		monthSelection.sendKeys(month);
		
		getDate(Integer.parseInt(day)).click();
		
	}

	public QAFWebElement getPrevBtn() {
		return prevBtn;
	}

	public QAFWebElement getNextBtn() {
		return nextBtn;
	}

	public QAFWebElement getMonthSelection() {
		return monthSelection;
	}

	public QAFWebElement getYearSelection() {
		return yearSelection;
	}
	
	public QAFWebElement getDate(int day) {
		return new QAFExtendedWebElement("link=" +day);
	}
}
