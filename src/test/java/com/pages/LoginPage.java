package com.pages;

import com.helper.*;
import com.page_data_provider.LoginDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLException;
import java.util.List;

public class LoginPage {

    /*Please refer to the LoginPageDataProvider class in testdataprovider (pkg)*/

    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(tagName = "a")
    List<WebElement> all_elements;

    @FindBy(xpath = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
    WebElement user_name;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/span[1]/input[1]")
    WebElement pass_word;

    public void verify_login_page_title() {
        SeleniumHelper.verify_title(driver, LoginDataProvider.get_login_page_title());
    }

    /*Getting the data from database*/
    public void enter_user_name() throws SQLException {
        SeleniumHelper.insert_login_data(LoginDataProvider.get_user_name(), user_name, pass_word);
    }

    /*Getting the data from the database*/
    public void click_on_sign_in() {
        SeleniumHelper.click_by_text(all_elements, "sign in");
    }


}
