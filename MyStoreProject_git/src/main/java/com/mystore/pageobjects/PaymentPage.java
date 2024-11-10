package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	Action action = new Action();
	public PaymentPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(xpath ="//a[@title='Pay by bank wire']")
	private WebElement bankWireMethod;
	
	@FindBy(xpath ="//a[@title='Pay by check.']" )
	private WebElement payByCheckMethod;
	
	public OrderSummaryPage clickOnPaymentMethod() {
		action.explicitWait(driver.get(), bankWireMethod, 5);
		action.click(driver.get(), bankWireMethod);
		return new OrderSummaryPage();
	}

}
