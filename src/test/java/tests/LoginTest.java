package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {
        // Initialize LoginPage and perform the login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("support", "go2meeting");  // Passing credentials directly here
        
     // Wait for 5 seconds 
        Thread.sleep(5000);
    }
}