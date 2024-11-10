package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	Action action = new Action();
	public LoginPage() {
		PageFactory.initElements(driver.get(), this);
    }
	
	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "passwd")
	private WebElement passwordField;
	
	@FindBy(id = "SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(css = "a[title='Recover your forgotten password']")
	private WebElement forgotPasswordLinkText;
	
	@FindBy(id = "email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name = "SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public HomePage login(String email, String password) {	
		action.type(emailField, email);
		action.type(passwordField, password);
		action.click(driver.get(), signInBtn);
		
		return new HomePage();
	}
	
	public AddressPage login1(String email, String password) {	
		action.type(emailField, email);
		action.type(passwordField, password);
		action.click(driver.get(), signInBtn);
		
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		action.type(emailForNewAccount, newEmail);
		action.click(driver.get(), createNewAccountBtn);
		
		return new AccountCreationPage();
	}

}
