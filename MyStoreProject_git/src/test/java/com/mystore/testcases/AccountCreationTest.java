package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationTest extends BaseClass {
	IndexPage index;
	LoginPage login;
	AccountCreationPage account;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setUp(String browserName) {
        launchWeb(browserName);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
    	driver.get().quit();	
    }
    
    @Test(groups = "Sanity")
    public void validateFormTitleTest() {
    	index = new IndexPage();
        login = new LoginPage();
        account = new AccountCreationPage();
        
       login = index.clickSignInBtn();
       account = login.createNewAccount(prop.getProperty("newemailaccount"));
       boolean result = account.validateFormTitle();
       Assert.assertTrue(result);
       
    	
    }
    
}
