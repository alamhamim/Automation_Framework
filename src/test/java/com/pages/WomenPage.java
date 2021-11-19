package com.pages;

import com.dataProvider.DataProvider;
import com.helper.SeleniumHelper;
import com.page_data_provider.WomenPageDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WomenPage {

    private WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "span")
    List<WebElement> all_add_to_cart;

    @FindBy(tagName = "a")
    private List<WebElement> all_women_page_element;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li/div[1]/div[2]/h5[1]/a")
    private List<WebElement> all_women_products;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/h2[1]")
    private WebElement add_to_cart_msg;

    public void verify_women_page_title() {
        SeleniumHelper.verify_title(driver, WomenPageDataProvider.get_women_page_title());
    }

    public void verify_all_women_page_products() throws IOException {
        ArrayList<Object> actualData = SeleniumHelper.get_all_text(all_women_products);
        ArrayList<Object> expectedData = WomenPageDataProvider.get_women_page_product();
        SeleniumHelper.compare_data(actualData, expectedData);
    }


    public void mouse_hover_on_all_women_product() throws InterruptedException {
        SeleniumHelper.hover_over_on_elements(driver, all_women_products, 130);
    }



    public void hover_over_on_element_women_page_and_click() throws InterruptedException {
        SeleniumHelper.scroll_down_js(driver, 700);
        SeleniumHelper.hover_over_on_element(driver, all_women_products, "Blouse");
        Thread.sleep(5000);
        SeleniumHelper.click_by_text(all_add_to_cart, WomenPageDataProvider.get_add_to_cart_data());
        Thread.sleep(5000);
        String actualText = SeleniumHelper.get_text_from_webElement(add_to_cart_msg);
        Thread.sleep(5000);
        SeleniumHelper.verify_text(actualText, WomenPageDataProvider.get_add_to_cart_msg());
    }



}
