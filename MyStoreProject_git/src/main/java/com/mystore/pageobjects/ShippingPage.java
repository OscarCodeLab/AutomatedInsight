package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	Action action = new Action();
	public ShippingPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(id ="cgv")
	private WebElement terms;
	
	@FindBy(xpath ="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;
	
	public void clickOnTermAndCondition() {
		//action.fluentWait(driver.get(), checkbox, 10);
		action.click(driver.get(), terms);
	}
	

	public PaymentPage clickproceedToCheckOut() {
		//action.fluentWait(driver.get(), proceedToCheckOut, 5);
		action.click(driver.get(), proceedToCheckOut);
		return new PaymentPage();
	}
	

}
