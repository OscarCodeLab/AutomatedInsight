package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    /**
     * Initializes the ExtentReports instance and sets up the HTML reporter.
     * @throws IOException if there's an issue with file I/O
     */
    public static void setExtent() throws IOException {
        // Set up the HTML reporter
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/MyReport.html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        // Initialize the ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Set system information
        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "MyStoreProject");
        extent.setSystemInfo("Tester", "Opeyemi");
        extent.setSystemInfo("OS", "Win11");
        extent.setSystemInfo("Browser", "Chrome");
    }

    /**
     * Flushes the ExtentReports instance to generate the report.
     */
    public static void endReport() {
        extent.flush();
    }
}