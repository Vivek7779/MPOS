package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.loginPage;

public class LoginPage extends loginPage{

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(REMEMBERME_CHECKBOX)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }
}
