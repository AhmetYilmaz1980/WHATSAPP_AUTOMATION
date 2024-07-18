package com.whatsapp.tests;

import com.whatsapp.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Login extends TestBase {

    @Test
    public void getGomePage() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(100000);
        WebElement element = driver.findElement(By.xpath("//*[@title='Yazılım']"));
        element.click();
        Thread.sleep(2000);
        WebElement lastMessage= driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div[2]/div[3]/div[22]/div/div/div[1]/div[1]/div[1]/div"));
        Thread.sleep(2000);
        lastMessage.click();
        Actions builder = new Actions(driver);
        builder.doubleClick(lastMessage).perform();
}}
