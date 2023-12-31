package properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private final static String PROPERTY_FILE = "src/test/resources/configuration.properties";
    private static Properties properties;
    private static BufferedReader bufferedReader;

    public Properties configurationFileReader() {
        try {
            bufferedReader = new BufferedReader(new FileReader(PROPERTY_FILE));
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Plik configuration.properties nie zostal znaleziony pod lokalizacja: " + PROPERTY_FILE);
        }
        return properties;
    }

    public static WebDriver selectTypeOfStartup(String browser) {
        if (System.getProperty("browser") != null) {
            if (System.getProperty("browser").equals("CHROME")) {
                setPropertyOfSystem(getChromeDriver(), properties.getProperty("chromeDriver"));
                return new ChromeDriver();
            }
            if (System.getProperty("browser").equals("FIREFOX")) {
                setPropertyOfSystem(getFirefoxDriver(), properties.getProperty("firefoxDriver"));
                return new FirefoxDriver();
            } else {
                throw new IllegalStateException("Przegladarka ktora zostala wybrana za pomoca get property (Jenkins), nie jest obslugiwana: " + System.getProperty("browser"));
            }
        } else {
            if (browser.equalsIgnoreCase("CHROME")) {
                setPropertyOfSystem(getChromeDriver(), properties.getProperty("chromeDriver"));
                return new ChromeDriver();
            }
            if (browser.equalsIgnoreCase("FIREFOX")) {
                setPropertyOfSystem(getFirefoxDriver(), properties.getProperty("firefoxDriver"));
                return new FirefoxDriver();
            } else
                throw new IllegalStateException("Przegladarka ktora zostala wybrana, nie jest obslugiwana" + System.getProperty("typeOfBrowser"));
        }
    }

    public static void setSystemFileProperties() {
        PropertiesReader propertiesReader = new PropertiesReader();
        Properties enrolledProperties = propertiesReader.configurationFileReader();
        setProperties(enrolledProperties);
    }

    private static void setPropertyOfSystem(String driverType, String driverPath) {
        System.setProperty(driverType, driverPath);
    }

    public static String getPageUrl() {
        return properties.getProperty("url");
    }

    private static void setProperties(Properties properties) {
        PropertiesReader.properties = properties;
    }

    public static String getTypeOfBrowser() {
        return properties.getProperty("typeOfBrowser");
    }

    public static long getImplicitlyWait() {
        return Long.parseLong(properties.getProperty("implicitlyWaitTime"));
    }

    public static String getLogin() {
        return properties.getProperty("login");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    private static String getChromeDriver() {
        return properties.getProperty("chromePath");
    }

    private static String getFirefoxDriver() {
        return properties.getProperty("firefoxPath");
    }
}