package com.whatsapp.tests;

import com.whatsapp.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void getGomePage() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(20000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[2]/div/div/[1]"));
        element.click();
        Thread.sleep(2000);
        WebElement lastMessage= driver.findElement(By.xpath("(//div[@class='copyable-text'])[2]"));
        lastMessage.click();
        Actions builder = new Actions(driver);
        builder.doubleClick(lastMessage).perform();
}}
