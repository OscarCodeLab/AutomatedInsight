package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
	Action action = new Action();
		
		@FindBy(xpath ="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]" )
		private WebElement proceedToCheckOut;
		
		
		public AddressPage() {
			PageFactory.initElements(driver.get(), this);
		}
		
		public ShippingPage clickOnCheckOut() {
		//	action.fluentWait(driver.get(), proceedToCheckOut, 10);
			action.JSClick(driver.get(), proceedToCheckOut);
			return new ShippingPage();
		}
}
