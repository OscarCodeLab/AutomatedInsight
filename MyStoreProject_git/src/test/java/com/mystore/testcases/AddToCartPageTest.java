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
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {

	IndexPage index;
	SearchResultPage search;
	AddToCartPage cart;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browserName) {
		launchWeb(browserName);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.get().quit();
	}
	
	@Test(groups = {"Regression", "Sanity"}, dataProviderClass = DataProviders.class, dataProvider = "dp" )
	public void addToCartPageTest(String product, String size, String qty) {
		index = new IndexPage();
		search = new SearchResultPage();
		cart = new AddToCartPage();

		search = index.searchProduct(product);
		cart = search.clickOnTheProduct();
		cart.colourwhite();
		cart.selectSize(size);
		cart.enterQuantity(qty);
		cart.clickonAddToCart();
		boolean result = cart.validateAddtoCart();
		Assert.assertTrue(result);
		/*
		 * boolean correct = cart.validateshirtcolor(); 
		 * Assert.assertTrue(correct);
		 */
	}

}
