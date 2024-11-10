package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	Action action = new Action();
	public SearchResultPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy (css ="img[title='Blouse']")
	private WebElement productResult;
	
	public boolean isProductAvailable() {
       return action.isDisplayed(driver.get(), productResult);
    }
	
	public AddToCartPage clickOnTheProduct() {
		
		action.click(driver.get(), productResult);
		
		return new AddToCartPage();
	}
}

