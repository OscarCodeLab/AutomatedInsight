package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	Action action = new Action();
	public HomePage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(css ="a[title='Information'] span")
	private WebElement personalInformation;
	
	@FindBy(css ="a[title='Addresses'] span")
	private WebElement myAddresses;

public boolean validateMyPersonalInformation() {
	
	return action.isDisplayed(driver.get(), personalInformation);
}

public boolean validateMyAddresses() {

    return action.isDisplayed(driver.get(), myAddresses);
}

public String getCurrentURL() {
	
	String actualURL = driver.get().getCurrentUrl();
	
	return actualURL;
}

}