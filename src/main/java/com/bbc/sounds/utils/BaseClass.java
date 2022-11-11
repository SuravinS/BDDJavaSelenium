package com.bbc.sounds.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bbc.sounds.utils.BaseClass;

public abstract class BaseClass {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    public BaseClass(WebDriver driver, WebDriverWait wait) {

        BaseClass.driver = driver;
        BaseClass.wait = wait;
    }

    protected void WaitUntilElementVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
