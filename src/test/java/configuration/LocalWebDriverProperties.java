package configuration;


import browsers.BrowserType;

public class LocalWebDriverProperties {

    // Metody zwracają właściwości dla poszczególnych kluczy, analogicznie jak w przypadku AppProperties

    public static BrowserType getLocalBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }

    public static String getChromeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    public static String getFirefoxWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }
}