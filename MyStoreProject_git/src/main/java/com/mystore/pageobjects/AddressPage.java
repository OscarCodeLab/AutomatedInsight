package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
		
		
		@FindBy(xpath ="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]" )
		public WebElement proceedToCheckOut;
		
		
		public AddressPage() {
			PageFactory.initElements(driver.get(), this);
		}
		
		public ShippingPage clickOnCheckOut() {
		//	Action.fluentWait(driver.get(), proceedToCheckOut, 10);
			Action.JSClick(driver.get(), proceedToCheckOut);
			return new ShippingPage();
		}
}
