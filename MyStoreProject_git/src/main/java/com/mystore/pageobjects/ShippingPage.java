package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	public ShippingPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(id ="cgv")
	public WebElement terms;
	
	@FindBy(xpath ="//button/span[contains(text(),'Proceed to checkout')]")
	public WebElement proceedToCheckOut;
	
	public void clickOnTermAndCondition() {
		//Action.fluentWait(driver.get(), checkbox, 10);
		Action.click(driver.get(), terms);
	}
	

	public PaymentPage clickproceedToCheckOut() {
		//Action.fluentWait(driver.get(), proceedToCheckOut, 5);
		Action.click(driver.get(), proceedToCheckOut);
		return new PaymentPage();
	}
	

}
