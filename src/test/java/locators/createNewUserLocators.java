package locators;

import org.openqa.selenium.By;

public class createNewUserLocators {
	//Navigate to create User Name Button.
	public static final By UserManagement = By.xpath("//*[@id=\"sidebar-menu\"]/ul/li[4]/a");
	public static final By UserAccount = By.xpath("//*[@id=\"sidebar-menu\"]/ul/li[4]/ul/li[1]/a/span");
	public static final By CreateUser=By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div[1]/button");
	
	//Create New User Form.
	public static final By cUserName=By.name("strUserName");
	public static final By Role=By.xpath("//*[@id=\"rc_select_0\"]");	
	public static final By AllowZDisplay=By.id("isAllowZdisplay");
	public static final By Active=By.id("isDeleted");
	public static final By Till=By.xpath("//*[@id=\"till\"]");
	public static final By HHT=By.xpath("//*[@id=\"hht\"]");
	
	//Locating New fields new fields.
	public static final By Password=By.name("strEncryptedPassword");
	public static final By ConfirmPassword=By.name("confirmPassword"); 	
	public static final By StaffCode=By.name("strPinnumber");	
	
	//Locating save Button.
	public static final By UserLogin=By.name("//*[@id=\"root\"]/div/div/div[3]/div/form/div[3]/button[2]");


	


	
}
