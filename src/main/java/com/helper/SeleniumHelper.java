package com.helper;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SeleniumHelper {


    public static String getDateAndTime() {
        SimpleDateFormat date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return date.format(currentDate);
    }

    public static void takeScreenShot(WebDriver driver) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SrcFile, new File("ScreenShots/pic_" + getDateAndTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void wait_and_click(WebDriver driver, WebElement element, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.click();
    }

    public void click_by_index(List<WebElement> element, int i) {
        element.get(i).click();
    }

    public static void click_on_webelements(List<WebElement> elements, WebDriver driver) {
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            driver.navigate().back();
        }
    }

    public static void click_by_text(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }


    public static ArrayList<Object> get_all_text(List<WebElement> elements) {
        ArrayList<Object> data = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            data.add(elements.get(i).getText());
        }
        return data;

    }

    public static void compare_data(ArrayList<Object> actualData, ArrayList<Object> expectedData) {
        SoftAssert softAssert = new SoftAssert();
        Iterator<Object> actual = actualData.iterator();
        Iterator<Object> expected = expectedData.iterator();

        while (actual.hasNext() && expected.hasNext()) {
            String actualText = actual.next().toString();
            String expectedText = expected.next().toString();

            softAssert.assertEquals(actualText, expectedText);
            System.out.println(actualText+" "+"AND"+" "+expectedText+"  <VERIFIED");

        }


    }

    public static void type_on_element(WebElement element, String givenText) {
        element.sendKeys(givenText);
    }


    public static void insert_login_data(HashMap<String, String> data, WebElement userName, WebElement password) {
        Set<Map.Entry<String, String>> a = data.entrySet();
        Iterator<Map.Entry<String, String>> iterator = a.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> map = iterator.next();

            userName.sendKeys(map.getKey());
            password.sendKeys(map.getValue());

        }

    }

    public static void verify_title(WebDriver driver, String title) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), title);
    }


    public static void scroll_down_js(WebDriver driver, int pixel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixel+")");
    }

    public static void hover_over_on_elements(WebDriver driver, List<WebElement> elements, int pixel) throws InterruptedException {
        Actions actions = new Actions(driver);
        for (int i = 0; i < elements.size(); i++) {
            Thread.sleep(2000);
            actions.moveToElement(elements.get(i)).build().perform();
            scroll_down_js(driver, pixel);
        }

    }

    public static void hover_over_and_click(WebDriver driver, List<WebElement> elements, String text) {
        Actions actions = new Actions(driver);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(text)) {
                actions.moveToElement(element).build().perform();
                element.click();
                break;
            }
        }
    }

    public static void hover_over_on_element(WebDriver driver, List<WebElement> elements, String text) {
        Actions actions = new Actions(driver);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(text)) {
                actions.moveToElement(element).build().perform();
                break;
            }
        }
    }


    public static String get_text_from_webElement(WebElement element) {
        return element.getText();
    }

    public static void verify_text(String actual, String expected) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);
    }

}
