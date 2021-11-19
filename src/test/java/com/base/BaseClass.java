package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.browsers.BrowserConfig;
import com.helper.SeleniumHelper;
import com.logger.LoggerConfig;
import org.apache.commons.exec.OS;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseClass {


    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReports;
    public ExtentTest test;
    public static Logger logger = LoggerConfig.setup_logger(BaseClass.class);

    @BeforeSuite
    public void report_setup() {
        String report_folder = "UI_Test_Report/report_" + SeleniumHelper.getDateAndTime() + ".html";
        htmlReporter = new ExtentHtmlReporter(report_folder);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.setAppendExisting(true);
    }


    @Parameters({"cloud_test", "headless", "os", "browser_name", "url"})

    @BeforeMethod
    public void environment_setup(@Optional("false") boolean cloud_test, @Optional("false") boolean headless,
                                  @Optional("linux") String os, @Optional("chrome") String browser_name,
                                  @Optional("http://automationpractice.com/index.php") String url) {
        logger.trace("opening the browser");
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
        logger.trace("Getting the test result");
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getTestName() + " << is FAILED");
            SeleniumHelper.takeScreenShot(driver);
        } else {
            test.pass(result.getMethod().getMethodName()+" << is PASSED");
        }

        driver.quit();
    }

    @AfterSuite
    public void generate_report() {
        logger.trace("Creating the report");
        extentReports.flush();

    }

}
