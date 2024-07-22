package com.whatsapp.pages;

import com.whatsapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ChatPage extends BasePage {
    private WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    // Locater for the last message element
    private By lastMessage = By.xpath("(//div[@class='copyable-text'])[3]");

    // Locater for the agree button element
    private By agreeButton = By.id("component-23");

    // Locater for the text area element
    private By textArea = By.xpath("//*[@id=\"component-5\"]/label/textarea");

    public void copyLastMessage() throws InterruptedException {
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(lastMessage));
        message.click();
        Actions builder = new Actions(Driver.get());
        builder.click(message).click(message).click(message).perform();
        Thread.sleep(1000);
        builder.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
    }

    public void openNewTabAndNavigate() throws InterruptedException {
        ((JavascriptExecutor) Driver.get()).executeScript("window.open('about:blank','_blank');");
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Driver.get().getWindowHandles());
        Driver.get().switchTo().window(tabs.get(1));
        Driver.get().get("https://huggingface.co/spaces/yuntian-deng/ChatGPT");
        Thread.sleep(3000);
    }

    public void acceptCookiesAndPasteMessage() throws InterruptedException {
        Driver.get().switchTo().frame("iFrameResizer0");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(agreeButton));
        button.click();
        Thread.sleep(2000);
        Driver.get().switchTo().alert().accept();

        WebElement area = wait.until(ExpectedConditions.elementToBeClickable(textArea));
        area.click();
        Thread.sleep(1000);
        Actions builder = new Actions(Driver.get());
        builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }
}

