package properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {
    private final static String PROPERTY_FILE = "src/main/resources/configuration.properties";
    private static Properties properties;

    public static void setProperties(Properties properties) {
        ConfigurationProperties.properties = properties;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String orangeHrmUrl() {
        return getProperties().getProperty("app.url");
    }

    public Properties configurationFileReader() {
        BufferedReader reader;
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