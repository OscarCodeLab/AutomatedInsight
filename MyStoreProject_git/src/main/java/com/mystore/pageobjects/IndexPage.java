package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	public IndexPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(css = "a[title='Log in to your customer account']")
	WebElement signInBtn;
	
	@FindBy(css = "img[alt='My Shop']")
	WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchField;
	
	@FindBy(name = "submit_search")
	WebElement searcBtn;
	
	public LoginPage clickSignInBtn() {
        Action.click(driver.get(), signInBtn);
        
        return new LoginPage();
    }
	
	public boolean validatemyStoreLogo() {
		return Action.isDisplayed(driver.get(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle1 = driver.get().getTitle();
		
		return myStoreTitle1;
	}
	
	public SearchResultPage searchProduct(String productName) {	
		Action.type(searchField, productName);
        Action.click(driver.get(), searcBtn);
        
        return new SearchResultPage();
    }
	}

