package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.browsers.BrowserConfig;
import com.helper.SeleniumHelper;
import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseClass {


    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReports;
    public ExtentTest logger;

    @BeforeSuite
    public void report_setup() {
        String report_folder = "HTML_Report/report_" + SeleniumHelper.getDateAndTime() + ".html";
        htmlReporter = new ExtentHtmlReporter(report_folder);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.setAppendExisting(true);
    }


    @BeforeMethod
    public void environment_setup(@Optional("false") boolean cloud_test, @Optional("false") boolean headless,
                                  @Optional("mac") String os, @Optional("chrome") String browser_name,
                                  @Optional("http://automationpractice.com/index.php") String url) {
        if (cloud_test == true) {
            driver = BrowserConfig.get_cloud_driver(driver, os, browser_name, url);
        } else if (headless == true) {
            driver = BrowserConfig.get_headless_driver(driver, os, browser_name, url);
        } else {
            driver = BrowserConfig.get_local_driver(driver, browser_name, url, os);
        }
    }


    @AfterMethod
    public void tear_down(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.fail(result.getTestName() + " << is FAILED");
            SeleniumHelper.takeScreenShot(driver);
        } else {
            logger.pass(result.getMethod().getDescription()+" <<is PASSED");
        }

        driver.quit();
    }

    @AfterSuite
    public void generate_report() {
        extentReports.flush();
    }

}
