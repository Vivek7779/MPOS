package utils;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LocatorReader {
   /* public static String getLocator(String fileName, String key) {
        try {
            String filePath = "src/test/resources/locators/" + fileName + ".json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            return jsonObject.getString(key);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read locator: " + key, e);
        }
        
    }*/
}
