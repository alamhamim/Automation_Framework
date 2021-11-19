package com.tests;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.WomenPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WomenPageTest extends BaseClass {

    HomePage homePage;
    WomenPage womenPage;

    @Test(priority = 1)
    public void verify_women_page_title() {
        test = extentReports.createTest("Verifying the Womenpage title");
        homePage = new HomePage(driver);
        womenPage = homePage.click_on_women();
        womenPage.verify_women_page_title();
        Assert.fail();
    }

    @Test(priority = 2)
    public void verify_all_women_product() throws IOException {
        test = extentReports.createTest("Verifying the Womenpage Products");
        homePage = new HomePage(driver);
        womenPage = homePage.click_on_women();
        womenPage.verify_all_women_page_products();
    }

    @Test
    public void mouse_hover_on_all_women_products() throws InterruptedException {
        test = extentReports.createTest("Hovering the mouse on all women products");
        homePage = new HomePage(driver);
        womenPage = homePage.click_on_women();
        womenPage.mouse_hover_on_all_women_product();
    }

    @Test
    public void hover_over_and_click_test() throws InterruptedException {
        test = extentReports.createTest("Hover over and click test");
        homePage = new HomePage(driver);
        womenPage = homePage.click_on_women();
        womenPage.hover_over_on_element_women_page_and_click();

    }



}
