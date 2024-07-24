package com.whatsapp.tests;

import com.whatsapp.utilities.ConfigurationReader;
import com.whatsapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class LoginTest extends TestBase {

    @Test
    public void testGetHomePage() throws InterruptedException {
        By lastMessage = By.xpath("(//div[@class='copyable-text'])[3]");
        By agreeButton = By.id("component-23");
        By textArea = By.xpath("//*[@id=\"component-5\"]/label/textarea");
        By firstContact = By.xpath("//*[@id=\"pane-side\"]/div[2]/div/div/div[1]");
        By firstMessage = By.xpath("//*[@id=\"chatbot\"]/div[2]/div/div[2]");
        Driver.get().get(ConfigurationReader.get("url"));
        Thread.sleep(20000);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstContact));
        element.click();
        Thread.sleep(2000);

        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(lastMessage));
        message.click();
        Actions builder = new Actions(Driver.get());
        builder.click(message).click(message).click(message).perform();
        Thread.sleep(1000);
        builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        Thread.sleep(1000);

        ((JavascriptExecutor) Driver.get()).executeScript("window.open('about:blank','_blank');");
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Driver.get().getWindowHandles());
        Driver.get().switchTo().window(tabs.get(1));
        Driver.get().get("https://huggingface.co/spaces/yuntian-deng/ChatGPT");
        Thread.sleep(3000);

        Thread.sleep(2000);
        Driver.get().switchTo().frame("iFrameResizer0");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(agreeButton));
        button.click();
        Thread.sleep(2000);
        Driver.get().switchTo().alert().accept();
        WebElement area = wait.until(ExpectedConditions.elementToBeClickable(textArea));
        area.click();
        Thread.sleep(1000);
        builder = new Actions(Driver.get());
        builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        builder.keyDown(Keys.ENTER).perform();

        Thread.sleep(2000);
        element = wait.until(ExpectedConditions.elementToBeClickable(firstMessage));
        element.click();
        builder = new Actions(Driver.get());
        builder.click(element).click(element).click(element).perform();
        Thread.sleep(2000);
        builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        System.out.println(element);
        System.out.println(firstMessage);

        ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(0));
        By lastMessage1 = By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p");
        message = wait.until(ExpectedConditions.elementToBeClickable(lastMessage1));
        message.click();
        builder = new Actions(Driver.get());
        Thread.sleep(1000);
        builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        builder.keyDown(Keys.ENTER).perform();


        // yapilacaklar:
        // tek kisi üzerinden mesaj trafigi ilerletilecek / son gelen mesajin locati belirlenecek
        // son gelen mesaji üzerinden for döngüsü olusturulacak
        // chatgbt sayfasindaki soru cevap ksiimlarinin locate mantigina bakilacak
        // her iki sayfa icinde for döngüsü olusturulacak

    }
}

