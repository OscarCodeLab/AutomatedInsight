package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{
	
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
	
    @Test(dataProvider = "dp", dataProviderClass = DataProviders.class, groups = {"Sanity, Smoke"})
	public void loginTest(String username, String password) {
	index = new IndexPage();
	login = new LoginPage();
	home = new HomePage();	
	
	index.clickSignInBtn();
	home = login.login(username, password);
	String actualURL = home.getCurrentURL();
	String expectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
	Assert.assertEquals(actualURL, expectedURL);
	
	}
	

}
