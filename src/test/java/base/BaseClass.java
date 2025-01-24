package base;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.ConfigReader;

public class BaseClass {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        // Set up WebDriver using BrowserFactory and ConfigReader
        String browser = ConfigReader.get("browser");
        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));

        // Call the login method as part of the setup
        login();
    }

    public void login() throws IOException {
        // Retrieve username and password from the ConfigReader
        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        // Check if username or password is missing
        if (username == null || username.isEmpty()) {
            throw new RuntimeException("Username is not defined in config.properties");
        }
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("Password is not defined in config.properties");
        }

        // Initialize WebDriverWait for dynamic waits
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));

        // Locate elements with WebDriverWait
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userNameOrEmailAddress")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        WebElement rememberCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.name("rememberClient")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[5]/button")));

        // Enter username
        usernameField.sendKeys(username);
        System.out.println("Username entered: " + usernameField.getAttribute("value"));

        // Enter password
        passwordField.sendKeys(password);
        System.out.println("Password entered: " + passwordField.getAttribute("value"));

        // Click the "Remember Me" checkbox
        rememberCheckbox.click();
        System.out.println("Remember Me checkbox clicked.");

        // Click the login button
        loginButton.click();
        System.out.println("Login button clicked. Login process initiated.");
    }
    
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }
}
