package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	IndexPage index;
	SearchResultPage search;
	AddToCartPage cart;
	OrderPage order;
	LoginPage login;
	AddressPage address;
	ShippingPage shipping;
	PaymentPage payment;
	OrderSummaryPage summary;
	OrderConfirmationPage confirm;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browserName) {
		launchWeb(browserName);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.get().quit();
	}
	
	@Test(groups="Regression", dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void endToEndTest(String productName, String size, String quantity, String username, String password) {
		index = new IndexPage();
		search = new SearchResultPage();
		cart = new AddToCartPage();
		order = new OrderPage();
		login = new LoginPage();
		address = new AddressPage();
		shipping = new ShippingPage();
		payment = new PaymentPage();
		summary = new OrderSummaryPage();
		confirm = new OrderConfirmationPage();
		
		search = index.searchProduct(productName);
		cart = search.clickOnTheProduct();
		cart.colourwhite();
		cart.selectSize(size);
		cart.enterQuantity(quantity);
		cart.clickonAddToCart();
		order = cart.clickonCheckOut();
		login = order.clickOnCheckOut();
		address = login.login1(username, password);
		shipping = address.clickOnCheckOut();
		shipping.clickOnTermAndCondition();
		payment = shipping.clickproceedToCheckOut();
		summary = payment.clickOnPaymentMethod();
		confirm = summary.clickPaymentType();
		String actualMessage = confirm.validateConfirmMessage();
		String expectedMessage = "Your order on My Shop is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
		
		
}
}
