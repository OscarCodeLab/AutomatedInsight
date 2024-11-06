package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

	public OrderPage() {
		PageFactory.initElements(driver.get(), this);
	}

	@FindBy(css = "li[class='price']")
	WebElement unitPrice;

	@FindBy(id = "total_price")
	WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckout;

	public double getUnitPrice() {
		//Action.explicitWait(driver.get(), unitPrice, 6);
		//Action.moveToElement(driver.get(), unitPrice);
		String unitPriceText = unitPrice.getText().replaceAll("[^0-9.]", "");
		double finalUnitPrice = Double.parseDouble(unitPriceText);
		return finalUnitPrice;
	}

	public double getTotalPrice() {
		//Action.moveToElement(driver.get(), totalPrice);
		String totalPriceText = totalPrice.getText().replaceAll("[^0-9.]", "");
		double finalTotalPrice = Double.parseDouble(totalPriceText);
		return finalTotalPrice;
	}

	public LoginPage clickOnCheckOut() {
//Assert.assertTrue(false);// delibrate failin the test
		
		Action.click(driver.get(), proceedToCheckout);

		return new LoginPage();

	}
}
