package com.whatsapp.tests;

import com.whatsapp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    @AfterMethod
//    public void tearDown() {
//        Driver.closeDriver();
//    }
}

