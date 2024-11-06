package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {

	IndexPage index;
	LoginPage login;
	HomePage home;
	
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
    public void validateMyPersonalInformationTest() {
    	index = new IndexPage();
    	login = new LoginPage();
    	home = new HomePage();
        login = index.clickSignInBtn();
        home = login.login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result =home.validateMyPersonalInformation();
        Assert.assertTrue(result);
    }
    
    @Test(groups = "Smoke")
    public void validateMyAddressesTest() {
    	index = new IndexPage();
    	login = new LoginPage();
    	home = new HomePage();
        login = index.clickSignInBtn();
        home = login.login(prop.getProperty("username"), prop.getProperty("password"));
        boolean result =home.validateMyAddresses();
        Assert.assertTrue(result);
    }
    
    
}
