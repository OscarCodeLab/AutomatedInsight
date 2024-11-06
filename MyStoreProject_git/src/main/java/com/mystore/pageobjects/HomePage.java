package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(css ="a[title='Information'] span")
	WebElement personalInformation;
	
	@FindBy(css ="a[title='Addresses'] span")
	WebElement myAddresses;

public boolean validateMyPersonalInformation() {
	
	return Action.isDisplayed(driver.get(), personalInformation);
}

public boolean validateMyAddresses() {

    return Action.isDisplayed(driver.get(), myAddresses);
}

public String getCurrentURL() {
	
	String actualURL = driver.get().getCurrentUrl();
	
	return actualURL;
}

}