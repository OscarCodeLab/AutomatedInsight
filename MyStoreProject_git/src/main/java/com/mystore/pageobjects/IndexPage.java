package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	Action action = new Action();
	public IndexPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(css = "a[title='Log in to your customer account']")
	private WebElement signInBtn;
	
	@FindBy(css = "img[alt='My Shop']")
	private WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	private WebElement searchField;
	
	@FindBy(name = "submit_search")
	private WebElement searcBtn;
	
	public LoginPage clickSignInBtn() {
        action.click(driver.get(), signInBtn);
        
        return new LoginPage();
    }
	
	public boolean validatemyStoreLogo() {
		return action.isDisplayed(driver.get(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle1 = driver.get().getTitle();
		
		return myStoreTitle1;
	}
	
	public SearchResultPage searchProduct(String productName) {	
		action.type(searchField, productName);
        action.click(driver.get(), searcBtn);
        
        return new SearchResultPage();
    }
	}

