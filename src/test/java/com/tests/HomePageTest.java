package com.tests;

import com.base.BaseClass;
import com.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @Test
    public void sign_in_test() {
        logger = extentReports.createTest("login test");
        HomePage homePage = new HomePage(driver);
        homePage.click_on_sign_in();
    }





}
