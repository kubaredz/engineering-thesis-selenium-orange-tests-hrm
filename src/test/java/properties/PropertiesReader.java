package properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private final static String PROPERTY_FILE = "src/main/resources/configuration.properties";
    private static Properties properties;
    private static BufferedReader reader;

    public static void setProperties(Properties properties) {
        PropertiesReader.properties = properties;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getPageUrl() {
        String pageUrl = properties.getProperty("url");
        return pageUrl;
    }

    public static String getBrowserType() {
        String browserType = properties.getProperty("browserType");
        return browserType;
    }

    public static long getImplicitlyWait() {
        String path = properties.getProperty("implicitlyWaitTime");
        return Long.parseLong(path);
    }

    public Properties configurationFileReader() {
        try {
            reader = new BufferedReader(new FileReader(PROPERTY_FILE));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Plik configuration.properties nie zostal znaleziony pod lokalizacja: " + PROPERTY_FILE);
        }
        return properties;
    }
}