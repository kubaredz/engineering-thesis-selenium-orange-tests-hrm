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

    public static void setProperties(Properties properties) {
        PropertiesReader.properties = properties;
    }

    public static String getPageUrl() {
        return properties.getProperty("url");
    }

    public static String getBrowserType() {
        return properties.getProperty("browserType");
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

    public static WebDriver chooseBrowser(String browserType) {
        if (System.getProperty("browser").equals("CHROME")){
//        if (browserType.equalsIgnoreCase("CHROME")) {
            System.out.println("praca inzzzzzz: " + System.getProperty("browser"));
            setPropertyOfSystem(getChromeDriver(), properties.getProperty("chromeDriver"));
            return new ChromeDriver();
        }
        if (System.getProperty("browser").equals("FIREFOX")){

        //        if (browserType.equalsIgnoreCase("FIREFOX")) {
            setPropertyOfSystem(getFirefoxDriver(), properties.getProperty("firefoxDriver"));
            return new FirefoxDriver();
        } else
        throw new IllegalStateException("Przegladarka ktora zostala wybrana, nie jest obslugiwana" + System.getProperty("browser"));
    }

    private static void setPropertyOfSystem(String driverType, String driverPath) {
        System.setProperty(driverType, driverPath);
    }

    public static void setPropertiesFromFileInSystem() {
        PropertiesReader propertiesReader = new PropertiesReader();
        Properties propertiesFromFile = propertiesReader.configurationFileReader();
        setProperties(propertiesFromFile);
    }
}