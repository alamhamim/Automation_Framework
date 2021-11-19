package com.pages;

import com.base.BaseClass;
import com.helper.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage{

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    @FindBy(tagName = "a")
    List<WebElement> element;


    public void click_on_sign_in() {
        SeleniumHelper.click_by_text(element, "sign in");

    }

}
