package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.MyAccountPage;

public class AccountCreationsTest extends BaseClass {

    public IndexPage indexPage;
    public LoginPage loginPage;
    public AccountCreationPage accountCreationPage;
    public MyAccountPage myAccountPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setUp(String browserName) {
        launchWeb(browserName);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        driver.get().quit();
    }

    @Test(groups = "Regression", dataProvider = "newAcountDetailsData", dataProviderClass = DataProviders.class)
    public void accountCreationTest(HashMap<String, String> hashMapValue) throws Throwable {
        indexPage = new IndexPage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();

        loginPage = indexPage.clickSignInBtn();
        accountCreationPage = loginPage.createNewAccount(hashMapValue.get("Email"));
        myAccountPage = accountCreationPage.createAccount(
                hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("SetPassword"),
                hashMapValue.get("Day"),
                hashMapValue.get("Month"),
                hashMapValue.get("Year"));
        
        myAccountPage.verifyaccount();
        String actualText = myAccountPage.verifyText();
        String expectedText = "Your account has been created.";
        Assert.assertEquals(actualText, expectedText);
    } 
}
