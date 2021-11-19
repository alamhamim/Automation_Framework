package com.tests;

import com.base.BaseClass;
import com.pages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseClass {

    HomePage homePage;

    @Test
    public void verify_home_page_title() {
        test = extentReports.createTest("Verifying the Homepage title");
        homePage = new HomePage(driver);
        homePage.verify_home_page_title();
    }

    @Test(priority = 3)
    public void check_all_product_homepage() throws IOException {
        test = extentReports.createTest("checking all the product from the homepage");
        homePage = new HomePage(driver);
        homePage.check_all_homepage_product();
    }

    @Test(priority = 1)
    public void home_page_header_test() throws IOException {
        test = extentReports.createTest("Checking the homepage header");
        homePage = new HomePage(driver);
        homePage.homepage_header_verify();
    }

    @Test(priority = 2)
    public void home_page_header_click_test() {
        test = extentReports.createTest("Clicking on the Homepage Header");
        homePage = new HomePage(driver);
        homePage.home_page_header_click_verify();
    }

    @Test
    public void verify_mouse_hover_on_header() throws InterruptedException {
        test = extentReports.createTest("Verifying the mouse hover on the header");
        homePage = new HomePage(driver);
        homePage.mouse_hover_on_header();
    }




}
