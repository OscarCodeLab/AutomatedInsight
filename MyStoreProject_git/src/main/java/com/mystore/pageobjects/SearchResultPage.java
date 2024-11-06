package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	public SearchResultPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy (css ="img[title='Blouse']")
	WebElement productResult;
	
	public boolean isProductAvailable() {
       return Action.isDisplayed(driver.get(), productResult);
    }
	
	public AddToCartPage clickOnTheProduct() {
		
		Action.click(driver.get(), productResult);
		
		return new AddToCartPage();
	}
}

