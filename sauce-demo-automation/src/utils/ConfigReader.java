package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream("resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Config file not found");
        }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getURL() {
        return prop.getProperty("url");
    }
}