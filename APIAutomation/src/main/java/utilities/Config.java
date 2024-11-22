package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	 private static Properties properties = new Properties();

	    public static void loadProperties(String filePath) {
	        try (FileInputStream fis = new FileInputStream(filePath)) {
	            properties.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load properties file: " + filePath);
	        }
	    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
    
    static {
        loadProperties("src/test/resources/Config.properties");
    }
}
