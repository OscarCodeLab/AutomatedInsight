package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	public AddToCartPage () {
		
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(id = "group_1")
	WebElement selectSize;
	
	@FindBy(xpath = "//input[@id='quantity_wanted']") 
	WebElement quantity;
	
	@FindBy(id = "color_8")
	WebElement shirtColorBtn;
	
	@FindBy(css = "button[name='Submit'] span")
	WebElement addToCartBtn;
	
	@FindBy(css = "div[class='layer_cart_product col-xs-12 col-md-6'] h2")
    WebElement addToCartMessage;
	
	@FindBy(css = "a[title='Proceed to checkout'] span")
    WebElement proceedToCheckOutBtn;
	
	@FindBy(css = "#layer_cart_product_attributes")
    WebElement shirtattributes;
	
	public void colourwhite() {
		//Action.explicitWait(driver.get(), shirtColorBtn, 5);
		Action.JSClick(driver.get(), shirtColorBtn);
	}
	
	public void enterQuantity(String total) {
		Action.fluentWait(driver.get(), quantity, 10);
		Action.type(quantity, total);
	}

	public void clickonAddToCart() {
		Action.click(driver.get(), addToCartBtn);
	}
	
	public void selectSize(String large) {
		Action.fluentWait(driver.get(), selectSize, 5);
		Action.selectByVisibleText(large, selectSize);
	}
	
	public boolean validateAddtoCart() {
		Action.explicitWait(driver.get(), addToCartMessage, 5);
		return Action.isDisplayed(driver.get(), addToCartMessage);
	}
	
	public boolean validateshirtcolor() {
		Action.explicitWait(driver.get(), shirtattributes, 5);
		return Action.isDisplayed(driver.get(), shirtattributes);
	}
	public OrderPage clickonCheckOut() {
		Action.fluentWait(driver.get(), proceedToCheckOutBtn, 5);
		Action.JSClick(driver.get(), proceedToCheckOutBtn);
		return new OrderPage();
	}
		
		}


