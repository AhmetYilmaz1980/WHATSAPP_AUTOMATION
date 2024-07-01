package com.whatsapp.tests;

import com.whatsapp.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void getGomePage(){

        extentLogger = report.createTest("TCoo1 Whatsapp Homepage");

        extentLogger.info("Navigate to HomePage");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.pass( "Pass...!");
    }
}
