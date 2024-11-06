package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver.get(), this);
    }
	
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(id = "passwd")
	WebElement passwordField;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(css = "a[title='Recover your forgotten password']")
	WebElement forgotPasswordLinkText;
	
	@FindBy(id = "email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name = "SubmitCreate")
	WebElement createNewAccountBtn;
	
	public HomePage login(String email, String password) {	
		Action.type(emailField, email);
		Action.type(passwordField, password);
		Action.click(driver.get(), signInBtn);
		
		return new HomePage();
	}
	
	public AddressPage login1(String email, String password) {	
		Action.type(emailField, email);
		Action.type(passwordField, password);
		Action.click(driver.get(), signInBtn);
		
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		Action.type(emailForNewAccount, newEmail);
		Action.click(driver.get(), createNewAccountBtn);
		
		return new AccountCreationPage();
	}

}
