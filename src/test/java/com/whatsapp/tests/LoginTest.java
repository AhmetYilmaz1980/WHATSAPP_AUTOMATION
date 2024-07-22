package com.whatsapp.tests;

import com.whatsapp.pages.ChatPage;
import com.whatsapp.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testGetHomePage() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        ChatPage chatPage = new ChatPage();

        loginPage.navigateToHomePage();
        Thread.sleep(20000);
        loginPage.clickFirstContact();
        Thread.sleep(2000);

        chatPage.copyLastMessage();
        Thread.sleep(1000);
        chatPage.openNewTabAndNavigate();
        Thread.sleep(2000);
        chatPage.acceptCookiesAndPasteMessage();
    }
}

