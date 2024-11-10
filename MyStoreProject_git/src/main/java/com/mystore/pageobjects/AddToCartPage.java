package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	Action action = new Action();
	public AddToCartPage () {
		
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(id = "group_1")
	private WebElement selectSize;
	
	@FindBy(css = "#quantity_wanted") 
	private WebElement quantity;
	
	@FindBy(id = "color_8")
	private WebElement shirtColorBtn;
	
	@FindBy(css = "button[name='Submit'] span")
	private WebElement addToCartBtn;
	
	@FindBy(css = "div[class='layer_cart_product col-xs-12 col-md-6'] h2")
	private WebElement addToCartMessage;
	
	@FindBy(css = "a[title='Proceed to checkout'] span")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(css = "#layer_cart_product_attributes")
	private WebElement shirtattributes;
	
	public void colourwhite() {
		action.explicitWait(driver.get(), shirtColorBtn, 5);
		action.JSClick(driver.get(), shirtColorBtn);
	}
	
	public void enterQuantity(String total) {
		action.explicitWait(driver.get(), quantity, 10);
		action.type(quantity, total);
	}

	public void clickonAddToCart() {
		action.click(driver.get(), addToCartBtn);
	}
	
	public void selectSize(String large) {
		action.selectByVisibleText(large, selectSize);
	}
	
	public boolean validateAddtoCart() {
		action.explicitWait(driver.get(), addToCartMessage, 5);
		return action.isDisplayed(driver.get(), addToCartMessage);
	}
	
	public boolean validateshirtcolor() {
		action.explicitWait(driver.get(), shirtattributes, 5);
		return action.isDisplayed(driver.get(), shirtattributes);
	}
	public OrderPage clickonCheckOut() {
		action.fluentWait(driver.get(), proceedToCheckOutBtn, 5);
		action.JSClick(driver.get(), proceedToCheckOutBtn);
		return new OrderPage();
	}
		
		}


