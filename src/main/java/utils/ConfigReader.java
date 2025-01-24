package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	static {
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"D:\\MPOSE Automation\\MPOS\\src\\main\\resources\\config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load configuration file.");
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
