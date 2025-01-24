package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC_003_Test_invalidUserNameandPassword {
	@Test
	public void checklogin() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.1.39:3000/signin");
		driver.manage().window().maximize();

		// Initialize WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Utility method to add a 1-second wait after each element interaction
		Runnable waitAfterInteraction = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		// Scenario 1: Existing username with a wrong password
		String IncorrectUsername = "Support";
		String IncorrectPassword = "Admin123";

		System.out.println("Scenario 1: Testing existing username with wrong password");

		// Locate and interact with elements for Scenario 1
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[2]/div/input")));
		Username.click();
		waitAfterInteraction.run();
		Username.sendKeys(IncorrectUsername);
		waitAfterInteraction.run();

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.click();
		waitAfterInteraction.run();
		password.sendKeys(IncorrectPassword);
		waitAfterInteraction.run();

		WebElement rememberme = wait.until(ExpectedConditions.elementToBeClickable(By.name("rememberClient")));
		rememberme.click();
		waitAfterInteraction.run();

		WebElement login = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[5]/button"));
		login.click();
		Thread.sleep(3000);

		System.out.println("Logged in with Correct User Name & Wrong Password:");
		System.out.println("Username: " + IncorrectUsername);
		System.out.println("Password: " + IncorrectPassword);
		System.out.println("Scenario 1 executed successfully.");
		System.out.println("Login Failed");

		// Refresh the page for Scenario 2
		driver.navigate().refresh();
		waitAfterInteraction.run();

		// Scenario 2: Non-existing username with an existing password
		System.out.println("\nScenario 2: Testing non-existing username with an existing password");

		// Scenario 1: Existing username with a wrong password
		String IncorrectUserName1 = "Admin";
		String CorrectPassword = "go2meeting";

		// Re-locate elements after page refresh
		Username = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[2]/div/input")));
		Username.clear();
		Username.sendKeys(IncorrectUserName1);
		waitAfterInteraction.run();

		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.clear();
		password.sendKeys(CorrectPassword);
		waitAfterInteraction.run();

		login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[5]/button"));
		login.click();
		Thread.sleep(3000);

		System.out.println("Logged in with Correct User Name & Wrong Password:");
		System.out.println("Username: " + IncorrectUserName1);
		System.out.println("Password: " + CorrectPassword);
		System.out.println("Scenario 2 executed successfully.");
		System.out.println("Login Failed");


		// Refresh the page for Scenario 3
		driver.navigate().refresh();
		waitAfterInteraction.run();

		// Scenario 3: Existing username with an existing password
		System.out.println("\nScenario 3: Testing existing username with an existing password");

		String CorrectUserName = "Support";
		String CorrectPassword1 = "go2meeting";

		// Re-locate elements after page refresh
		Username = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[2]/div/input")));
		Username.clear();
		Username.sendKeys(CorrectUserName);
		waitAfterInteraction.run();

		password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.clear();
		password.sendKeys(CorrectPassword1);
		waitAfterInteraction.run();

		login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[5]/button"));
		login.click();
		Thread.sleep(3000);

		System.out.println("Logged in with Correct User Name & Correct Password:");
		System.out.println("Username: " + CorrectUserName);
		System.out.println("Password: " + CorrectPassword1);
		System.out.println("Scenario 3 executed successfully.");
		System.out.println("Login Succeeded");
    
        Thread.sleep(1000);
		// Close the browser
		driver.quit();
	}
}