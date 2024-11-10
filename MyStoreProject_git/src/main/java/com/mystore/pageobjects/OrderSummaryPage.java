package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage  extends BaseClass{
	Action action = new Action();
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver.get(), this);
	}
	

	@FindBy(xpath ="//span[normalize-space()='I confirm my order']" )
	private WebElement bankWireMethod;
	
	public OrderConfirmationPage clickPaymentType() {
		action.click(driver.get(), bankWireMethod);
		return new OrderConfirmationPage();
		
	}

}
