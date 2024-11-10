package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class MyAccountPage extends BaseClass {
	Action action = new Action();
	public MyAccountPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Add my first address']")
	private WebElement address;
	
	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	private WebElement orderHistory;
	
	@FindBy(xpath = "//span[normalize-space()='My credit slips']")
	private WebElement myCreditSlip;
	
	@FindBy(xpath = "//span[normalize-space()='My addresses']")
	private WebElement myAddress;
	
	@FindBy(xpath = "//span[normalize-space()='My personal information']")
	private WebElement personalInformation;
	
	@FindBy(xpath = "//p[contains(text(),'Your account has been created.')]")
	private WebElement accountCreated;

	
	public boolean verifyaccount() {
		return accountCreated.isDisplayed();
		
	}
	
	public String verifyText() {
		String creationtext = action.getText(getDriver(), accountCreated);
		return creationtext;
		
	}
}