package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass{
    
	public AccountCreationPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(css = ".page-heading")
	WebElement formTitle;
	
	@FindBy(id = "id_gender1")
	WebElement mr;
	@FindBy(id = "customer_firstname")
	public WebElement customerFirstName;
	
	@FindBy(id = "customer_lastname")
	public WebElement customerLastName;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement customereemail;
	
	@FindBy(id = "passwd")
	public WebElement createPassword;
	
	@FindBy(id = "days")
	public WebElement days;
	
	@FindBy(id = "months")
	public WebElement months;
	
	@FindBy(id = "years")
	public WebElement years;
	
	
	@FindBy(id = "newsletter")
	public WebElement newsletter;
	
	@FindBy(xpath = "//span[normalize-space()='Register']")
	public WebElement register;
	
	
	
	public void accountCreationPages(String firstName, String lastName, String newPassword, String day, String month, String year) {
		Action.click(driver.get(), mr);
		Action.type(customerFirstName, firstName);
		Action.type(customerLastName, lastName);
		//Action.explicitWait(getWebDriver(), createPassword, 5);
		Action.type(createPassword, newPassword);
	
		Action.selectByValue(days, day);
		Action.selectByValue(months, month);
		Action.selectByValue(years, year);
		Action.click(driver.get(), newsletter);
		Action.click(driver.get(), register);
	}
	
	public boolean validateformtitle() {
		return Action.isDisplayed(driver.get(), formTitle);
	}
}
