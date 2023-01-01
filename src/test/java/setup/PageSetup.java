package setup;

import properties.PropertiesReader;

import java.time.Duration;

public class PageSetup {

    public static void setPageUrl() {
        DriverPicker.driverSetup().navigate().to(PropertiesReader.getPageUrl());
    }

    public static void setMaximizeOfWindow() {
        DriverPicker.driverSetup().manage().window().maximize();
    }

    public static void setImplicitWait() {
        DriverPicker.driverSetup().manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertiesReader.getImplicitlyWait()));
    }
}