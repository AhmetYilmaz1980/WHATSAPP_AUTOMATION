package com.whatsapp.tests;

import com.whatsapp.pages.ChatPage;
import com.whatsapp.pages.LoginPage;
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
        LoginPage loginPage = new LoginPage();
        ChatPage chatPage = new ChatPage();
        //GbtPage gbtPage=new GbtPage();
        loginPage.navigateToHomePage();
        Thread.sleep(20000);
        loginPage.clickFirstContact();
        Thread.sleep(2000);
        chatPage.copyLastMessage();
        Thread.sleep(1000);
        chatPage.openNewTabAndNavigate();
        Thread.sleep(2000);
        chatPage.acceptCookiesAndPasteMessage();
        Thread.sleep(2000);
        loginPage.clickFirstMessage();


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));


        By lastMessage = By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[2]");
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(lastMessage));
        message.click();
        Actions builder = new Actions(Driver.get());
        Thread.sleep(1000);
        builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        builder.keyDown(Keys.ENTER).perform();









    }
}

