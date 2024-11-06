package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage index;
	SearchResultPage search;
	AddToCartPage cart;
	OrderPage order;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browserName) {
		launchWeb(browserName);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.get().quit();
	}

	 @Test(groups = "Regression", dataProviderClass = DataProviders.class,  dataProvider = "dp")
	public void verifyTotalPriceTest(String productName, String size, String qty) {
		index = new IndexPage();
		search = new SearchResultPage();
		cart = new AddToCartPage();
		order = new OrderPage();
		
		search = index.searchProduct(productName);
		cart = search.clickOnTheProduct();
		cart.colourwhite();
		cart.selectSize(size);
		cart.enterQuantity(qty);
		cart.clickonAddToCart();
		order = cart.clickonCheckOut();
		double unitPrice = order.getUnitPrice();
		double totalPrice = order.getTotalPrice();
		int quantity = (int) Double.parseDouble(qty);
		double totalExpectedPrice = (unitPrice * quantity) + 7;
		Assert.assertEquals(totalPrice, totalExpectedPrice);

		System.out.println("Unit Price: " + unitPrice);
		System.out.println("Total Price: " + totalPrice);
		Assert.assertTrue(totalPrice > unitPrice);

	}

}
