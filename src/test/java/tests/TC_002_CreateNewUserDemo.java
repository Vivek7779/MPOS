package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_002_CreateNewUserDemo {

    @Test
    public static void cUser() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://192.168.1.39:3000/signin");
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Utility method to add a 2-second wait after each element interaction
        Runnable waitAfterInteraction = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Login with old account
        String oldUsername = "Support";
        String oldPassword = "go2meeting";

        // Wait for username field to be visible and perform action
        WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[2]/div/input")));
        Username.click();
        waitAfterInteraction.run();
        Username.sendKeys(oldUsername);
        waitAfterInteraction.run();

        // Wait for password field to be visible and perform action
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.click();
        waitAfterInteraction.run();
        password.sendKeys(oldPassword);
        waitAfterInteraction.run();

        // Wait for remember me checkbox and click
        WebElement rememberme = wait.until(ExpectedConditions.elementToBeClickable(By.name("rememberClient")));
        rememberme.click();
        waitAfterInteraction.run();

        WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[5]/button"));
        login.click();

        // Print old account login details
        System.out.println("Logged in with old account:");
        System.out.println("Username: " + oldUsername);
        System.out.println("Password: " + oldPassword);

        // Wait for User Management and click
        WebElement UserManagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar-menu\"]/ul/li[5]/a/span")));
        UserManagement.click();
        waitAfterInteraction.run();

        // Wait for User Account section and click
        WebElement UseraAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sidebar-menu\"]/ul/li[5]/ul/li[1]/a/span")));
        UseraAccount.click();
        waitAfterInteraction.run();

        // Wait for Create User button and click
        WebElement CreateUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div[1]/button")));
        CreateUser.click();
        waitAfterInteraction.run();

        // Create new user details
        String newUsername = "Test_07-03";
        String newPassword = "Test@12345";

        // Wait for User Name field and fill it
        WebElement cUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("strUserName")));
        cUserName.click();
        waitAfterInteraction.run();
        cUserName.sendKeys(newUsername);
        waitAfterInteraction.run();
        cUserName.sendKeys(Keys.PAGE_DOWN);
        waitAfterInteraction.run();

        // Wait for Role selection and select "Admin"
        WebElement Role = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rc_select_0\"]")));
        Role.click();
        waitAfterInteraction.run();
        Role.sendKeys("Admin" + Keys.ENTER);
        waitAfterInteraction.run();

        // Use JavaScript to click outside
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.elementFromPoint(0, 0).click();");

        WebElement BackOffice = driver.findElement(By.id("backOffice"));
        BackOffice.click();
        waitAfterInteraction.run();

        // Wait for Password field and enter password
        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("strEncryptedPassword")));
        Password.click();
        waitAfterInteraction.run();
        Password.sendKeys(newPassword);
        waitAfterInteraction.run();

        // Wait for Confirm Password field and confirm password
        WebElement ConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("confirmPassword")));
        ConfirmPassword.click();
        waitAfterInteraction.run();
        ConfirmPassword.sendKeys(newPassword);
        waitAfterInteraction.run();
        ConfirmPassword.sendKeys(Keys.PAGE_DOWN);
        waitAfterInteraction.run();

        // Wait for Save button and click
        WebElement Save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/form/div[3]/button[2]")));
        Save.click();
        waitAfterInteraction.run();
        Thread.sleep(2000);
        
        // Log out from old account
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/ul/li[3]/a")));
        profile.click();
        waitAfterInteraction.run();

        WebElement Logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[1]/ul/li[3]/div/div/button")));
        Logout.click();
        waitAfterInteraction.run();

        // Log in with new account
        WebElement Username1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userNameOrEmailAddress")));
        Username1.sendKeys(newUsername);
        waitAfterInteraction.run();

        WebElement password1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password1.sendKeys(newPassword);
        waitAfterInteraction.run();

        WebElement login2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[5]/button"));
        login2.click();
        waitAfterInteraction.run();

        // Print new account login details
        System.out.println("Logged in with new account:");
        System.out.println("Username: " + newUsername);
        System.out.println("Password: " + newPassword);

        // Wait for 3 seconds before quitting
        Thread.sleep(3000);

        driver.quit();
    }
}
