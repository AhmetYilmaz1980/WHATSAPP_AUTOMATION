package com.whatsapp.pages;

import com.whatsapp.utilities.ConfigurationReader;
import com.whatsapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    // Locater for the first contact element
    private By firstContact = By.xpath("//*[@id=\"pane-side\"]/div[2]/div/div/div[1]");

    public void navigateToHomePage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    public void clickFirstContact() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstContact));
        element.click();


    }
}


