package tests;

import base.BaseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {
        // Initialize LoginPage and perform the login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("support", "go2meeting");  // Passing credentials directly here
        Thread.sleep(5000);
       
    }
}