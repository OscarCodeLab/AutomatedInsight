package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {

	public IndexPage index;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browserName) {
		launchWeb(browserName);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.get().quit();
	}

	@Test(groups = "Smoke")
	public void verifyLogo() {
		index = new IndexPage();
		index.validatemyStoreLogo();
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {
		index = new IndexPage();
		String actualTitle = index.getMyStoreTitle();
		String expectedTitle = "My Shop";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test(groups = "Smoke")
	public void testSearchProduct() {
		index = new IndexPage();
		index.searchProduct(prop.getProperty("productName"));
	}
}
