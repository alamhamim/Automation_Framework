package com.tests;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class LoginPageTest extends BaseClass {

    HomePage homePage;
    LoginPage loginPage;

    @Test(priority = 1)
    public void verify_login_page_title() throws InterruptedException {
        test = extentReports.createTest("Verifying the login page title");
        homePage = new HomePage(driver);
        loginPage = homePage.click_on_sign_in();
        loginPage.verify_login_page_title();
    }


    @Test(priority = 2, dependsOnMethods = "verify_login_page_title")
    public void enter_user_name_and_pass() throws SQLException, InterruptedException {
        test = extentReports.createTest("Login test");
        homePage = new HomePage(driver);
        loginPage = homePage.click_on_sign_in();
        loginPage.enter_user_name();
        loginPage.click_on_sign_in();
    }



}
