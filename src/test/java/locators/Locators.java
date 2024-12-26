package locators;

import org.openqa.selenium.By;

public class Locators {

    //Login Page Locators
    public static final By USERNAME_FIELD = By.name("userNameOrEmailAddress");
    public static final By PASSWORD_FIELD = By.name("password");
    public static final By REMEMBERME_CHECKBOX = By.name("rememberClient"); 
    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div[5]/button");
}
