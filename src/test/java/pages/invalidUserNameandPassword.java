package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.loginPageLocators;

public class invalidUserNameandPassword extends loginPageLocators{
	private WebDriver driver;
	private WebDriverWait wait;

	public void testUser(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}
	public void LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
	}

	public void testUser() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(UserManagement)).click();

	}
}
