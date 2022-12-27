package setup;

import properties_loader.ConfigurationProperties;

import java.time.Duration;

public class PageSetup {

    public static void setPageUrl() {
        DriverManager.driverSetup().navigate().to(ConfigurationProperties.orangeHrmUrl());
    }

    public static void setMaximizeOfWindow() {
        DriverManager.driverSetup().manage().window().maximize();
    }

    public static void setImplicitWait() {
        DriverManager.driverSetup().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
