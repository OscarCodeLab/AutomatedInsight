package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage index;
	SearchResultPage search;
	
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
    public void isProductAvailableTest() {
    	index = new IndexPage();
    	search = index.searchProduct(prop.getProperty("productName"));
    	boolean result = search.isProductAvailable();
    	Assert.assertTrue(result);
    }
    
}
