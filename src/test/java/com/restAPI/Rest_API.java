package com.restAPI;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseClass;
import com.helper.SeleniumHelper;
import com.logger.LoggerConfig;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class Rest_API {



    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReports;
    public ExtentTest test;
    public static Logger logger = LoggerConfig.setup_logger(BaseClass.class);

    @BeforeSuite
    public void report_setup() {
        String report_folder = "API_Test_Report/report_" + SeleniumHelper.getDateAndTime() + ".html";
        htmlReporter = new ExtentHtmlReporter(report_folder);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.setAppendExisting(true);
    }

    @AfterMethod
    public void tear_down(ITestResult result) {
        logger.trace("Getting the test result");
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getTestName() + " << is FAILED");

        } else {
            test.pass(result.getMethod().getMethodName()+" << is PASSED");
        }



    }

    @AfterSuite
    public void generate_report() {
        extentReports.flush();
    }

    public RequestSpecification api_config() {
        RestAssured.baseURI = "http://localhost:3000/";
        RequestSpecification http = RestAssured.given();
        return http;
    }


    @Test(priority = 1)
    public void post_something() {
        test = extentReports.createTest("Posting with API");
        RequestSpecification http = api_config().given();
        JSONObject object = new JSONObject();
        object.put("title", "Hello World");
        object.put("author", "Dummy");
        object.put("email", "dummy@email.com");
        http.body(object);
        http.header("Content-Type", "application/json");
        Response response = http.request(Method.POST, "posts");

        int reponseCode = response.statusCode();
        Assert.assertEquals(reponseCode, 201);
    }


    @Test(priority = 2)
    public void get_post_details_and_verify() {
        test = extentReports.createTest("Getting post details with API");
        RequestSpecification http = api_config().given();
        Response response = http.request(Method.GET, "posts");
        String body = response.getBody().asPrettyString();
        Assert.assertTrue(body.contains("Dummy"));
    }


    @Test(priority = 3)
    public void get_all_header() {
        test = extentReports.createTest("Getting all the header with API");
        RequestSpecification http = api_config().given();
        Response response = http.request(Method.GET, "posts");
        Headers headers = response.headers();

        for (Header header : headers) {
            System.out.println(headers.toString());
        }
    }


    @Test(priority = 4)
    public void delete_post() {
        test = extentReports.createTest("Deleting post with API");
        RequestSpecification http = api_config().given();
        Response response = http.request(Method.DELETE, "posts/1");
        int responeCode = response.statusCode();
        Assert.assertEquals(responeCode, 404);
    }


    @Test(priority = 5)
    public void verify_delete() {
        test = extentReports.createTest("Verifying the delete post with API");
        RequestSpecification http = api_config().given();
        Response response = http.request(Method.GET, "posts/1");
        int resonseCode = response.statusCode();
        Assert.assertEquals(resonseCode, 404);
    }





}
