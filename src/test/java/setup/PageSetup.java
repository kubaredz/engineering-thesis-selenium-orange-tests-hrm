package setup;

import java.time.Duration;

public class PageSetup {

    public static void setPageUrl(String pageUrl) {
        DriverManager.driverSetup().navigate().to(pageUrl);
    }

    public static void setMaximizeOfWindow() {
        DriverManager.driverSetup().manage().window().maximize();
    }

    public static void setImplicitWait() {
        DriverManager.driverSetup().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
