package com.whatsapp.tests;

import com.whatsapp.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Login extends TestBase {

    @Test
    public void getGomePage() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        Thread.sleep(20000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[2]/div/div/div[1]"));
        element.click();
        Thread.sleep(2000);
        WebElement lastMessage= driver.findElement(By.xpath("(//div[@class='copyable-text'])[3]"));
        lastMessage.click();
        Actions builder = new Actions(driver);
        builder.click(lastMessage).click(lastMessage).click(lastMessage).perform();
        Thread.sleep(1000);
        builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        Thread.sleep(2000);
        //builder.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://huggingface.co/spaces/yuntian-deng/ChatGPT");
        Thread.sleep(3000);
        driver.switchTo().frame("iFrameResizer0");

        WebElement agreeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("component-23")));
        agreeButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        WebElement textArea = wait.until(ExpectedConditions.elementToBeClickable(By.id("//*[@id=\"component-5\"]/label/textarea")));
        agreeButton.click();
        Thread.sleep(1000);
        builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();




    }}
