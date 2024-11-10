package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	Action action = new Action();
	public OrderPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(css = "li[class='price']")
	private WebElement unitPrice;

	@FindBy(id = "total_price")
	private WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckout;

	public double getUnitPrice() {
		//action.explicitWait(driver.get(), unitPrice, 6);
		//action.moveToElement(driver.get(), unitPrice);
		String unitPriceText = unitPrice.getText().replaceAll("[^0-9.]", "");
		double finalUnitPrice = Double.parseDouble(unitPriceText);
		return finalUnitPrice;
	}

	public double getTotalPrice() {
		//action.moveToElement(driver.get(), totalPrice);
		String totalPriceText = totalPrice.getText().replaceAll("[^0-9.]", "");
		double finalTotalPrice = Double.parseDouble(totalPriceText);
		return finalTotalPrice;
	}

	public LoginPage clickOnCheckOut() {
//Assert.assertTrue(false);// delibrate failin the test
		
		action.click(driver.get(), proceedToCheckout);

		return new LoginPage();

	}
}
