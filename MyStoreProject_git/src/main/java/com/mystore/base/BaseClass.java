package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExcelReader;
import com.mystore.utility.ExtentManager;

public class BaseClass {

	public static Properties prop;
	public static Logger log = LogManager.getLogger(BaseClass.class);
	public static Action Action;
	public static ExcelReader excel = new ExcelReader(
			"C:\\Users\\hp\\git\\AutomatedInsight\\MyStoreProject_git\\src\\test\\resources\\TestData\\AccountCreationTestData.xlsx");
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			log.info("Configuration file loaded successfully.");
			Action = new Action();
		} catch (FileNotFoundException e) {
			log.error("File not found: " + e.getMessage());
		} catch (IOException e) {
			log.error("IO Exception: " + e.getMessage());
		}
	}

	public static void launchWeb(String browserName) {
		// String browserName = prop.getProperty("browser");
		// parameterized the browser name and reading parameters from test xml file
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			log.info("chrome browser lauching");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}

		log.info("Maximizing browser window");
		Action.maximizePageWindow(driver.get());
		log.info("Setting implicit wait");
		Action.implicitWait(driver.get(), 10);
		log.info("Setting page load timeout");
		Action.pageLoadTimeOut(driver.get(), 40);

		driver.get().get(prop.getProperty("url"));

	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
