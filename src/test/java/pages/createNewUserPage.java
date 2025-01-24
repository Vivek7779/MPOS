package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.createNewUserLocators;

public class createNewUserPage extends createNewUserLocators {

	private WebDriver driver;
	private WebDriverWait wait;

	public createNewUserPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds wait
	}

	public void Createnewuser(String username, String password) {
	
		//Navigate to create User Name Button.
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserManagement)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserAccount)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CreateUser)).click();
		
		//Create New User Form.
		wait.until(ExpectedConditions.elementToBeClickable(cUserName)).sendKeys("Test_07_01");
		wait.until(ExpectedConditions.elementToBeClickable(Role)).sendKeys("Admin"+ Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(AllowZDisplay)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Active)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Till)).click();
		wait.until(ExpectedConditions.elementToBeClickable(HHT)).click();
		
		//Locating New fields new fields.
		wait.until(ExpectedConditions.elementToBeClickable(Password)).sendKeys("Test@12345");
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmPassword)).sendKeys("Test@12345");
		wait.until(ExpectedConditions.elementToBeClickable(StaffCode)).sendKeys("369");
		
		//Locating save Button.
		wait.until(ExpectedConditions.elementToBeClickable(UserLogin)).click();	
}
}