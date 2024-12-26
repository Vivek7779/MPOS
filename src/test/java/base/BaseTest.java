package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.ConfigReader;

public class BaseTest {
    
	protected WebDriver driver;
    
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        String browser = ConfigReader.get("browser");
        driver = BrowserFactory.getDriver(browser);
        driver.get(ConfigReader.get("baseUrl"));
    }      
        @AfterMethod 
        public void tearDown() { 
        	if (driver != null) { 
        		driver.quit(); }
        } 
}
