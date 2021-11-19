package com.helper;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
        for (int i = 0; i < elements.size(); i++) {
            if (!elements.get(i).getText().equalsIgnoreCase(text)) {
                continue;
            } else {
                elements.get(i).click();
                break;
            }
        }
    }


    public static ArrayList<String> get_all_text(List<WebElement> elements) {
        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            data.add(elements.get(i).getText());
        }
        return data;

    }

    public void compare_data(ArrayList<String> actualData, ArrayList<String> expectedData) {
        Iterator<String> actual = actualData.iterator();
        Iterator<String> expected = expectedData.iterator();

        while (actual.hasNext() && expected.hasNext()) {
            if (actual.next().equalsIgnoreCase(expected.next())) {
                System.out.println("Data verified");
            } else {
                System.out.println("Can not verify the data");
            }
        }



    }




}
