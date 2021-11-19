package com.pages;

import com.helper.SeleniumHelper;
import com.page_data_provider.HomePageDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage{

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    @FindBy(tagName = "a")
    List<WebElement> all_home_page_elements;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement sing_in;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li/div/div[2]/h5/a")
    List<WebElement> all_homepage_products;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul/li/a")
    List<WebElement> homepage_header;

    public LoginPage click_on_sign_in() throws InterruptedException {
        sing_in.click();
        Thread.sleep(10000);
        return new LoginPage(driver);
    }

    public void verify_home_page_title() {
        SeleniumHelper.verify_title(driver, HomePageDataProvider.get_home_page_title());
    }

    public void homepage_header_verify() throws IOException {
        ArrayList<Object> actualData = HomePageDataProvider.get_home_page_header_data();
        ArrayList<Object> expectedData = SeleniumHelper.get_all_text(homepage_header);
        SeleniumHelper.compare_data(actualData, expectedData);

    }

    public void check_all_homepage_product() throws IOException {
        ArrayList<Object> actualData = SeleniumHelper.get_all_text(all_homepage_products);
        ArrayList<Object> expectedData = HomePageDataProvider.get_home_page_product();
        SeleniumHelper.compare_data(actualData, expectedData);
    }

    public void home_page_header_click_verify() {
        SeleniumHelper.click_on_webelements(homepage_header, driver);
    }

    public WomenPage click_on_women() {
        SeleniumHelper.click_by_text(homepage_header, "women");
        return new WomenPage(driver);
    }

    public void mouse_hover_on_header() throws InterruptedException {
        SeleniumHelper.hover_over_on_elements(driver, homepage_header, 0);
    }




}
