package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
	private static WebDriver driver;

	public static WebDriver getDriver(String browser) throws IOException {
		// Load the config.properties file
		Properties properties = new Properties();
		FileInputStream configFile = new FileInputStream(
				"D:\\MPOSE Automation\\MPOS\\src\\main\\resources\\config.properties");
		properties.load(configFile);

		// Get the browser property from the config file
		String browserName = properties.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("You dont have an appropriate browser");
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}

	}
}