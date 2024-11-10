package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {
    Action action = new Action(); // Renamed to follow Java naming conventions

    // Constructor to initialize elements
    public AccountCreationPage() {
        PageFactory.initElements(driver.get(), this);
    }

    // Page elements
    @FindBy(css = ".page-heading")
    private WebElement formTitle;

    @FindBy(id = "id_gender1")
    private WebElement mr;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement customerEmail; // Corrected field name

    @FindBy(id = "passwd")
    private WebElement createPassword;

    @FindBy(id = "days")
    private WebElement days;

    @FindBy(id = "months")
    private WebElement months;

    @FindBy(id = "years")
    private WebElement years;

    @FindBy(id = "newsletter")
    private WebElement newsletter;

    @FindBy(xpath = "//span[normalize-space()='Register']")
    private WebElement register;

    // Method to fill in the account creation form and submit
    public MyAccountPage createAccount(String firstName, String lastName, String newPassword, String day, String month, String year) {
        action.click(driver.get(), mr);
        action.type(customerFirstName, firstName);
        action.type(customerLastName, lastName);
        action.type(customerEmail, firstName + "." + lastName + "@example.com"); // Example email, you can modify as needed
        action.type(createPassword, newPassword);

        action.selectByValue(days, day);
        action.selectByValue(months, month);
        action.selectByValue(years, year);
        action.click(driver.get(), newsletter);
        action.click(driver.get(), register);

        return new MyAccountPage();
    }

    // Method to validate if the form title is displayed
    public boolean validateFormTitle() {
        return action.isDisplayed(driver.get(), formTitle);
    }
}
