package setup;

import properties.PropertiesReader;

import java.time.Duration;

public class PageSetup {
    private static String avatarPath = "resources/img/avatar.jpg";
    private static PropertiesReader propertiesReader;

    public static void setPageUrl() {
        DriverPicker.driverSetup().navigate().to(propertiesReader.getPageUrl());
    }

    public static void setMaximizeOfWindow() {
        DriverPicker.driverSetup().manage().window().maximize();
    }

    public static void setImplicitWait() {
        DriverPicker.driverSetup().manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesReader.getImplicitlyWait()));
    }

    public static String setLogin() {
        return propertiesReader.getLogin();
    }

    public static String setPassword() {
        return propertiesReader.getPassword();
    }

    public static String getAvatarPath() {
        return avatarPath;
    }
}