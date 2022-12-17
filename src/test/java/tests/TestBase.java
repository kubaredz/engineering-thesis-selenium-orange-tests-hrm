package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.DriverManager;
import setup.PageSetup;

public class TestBase {
    private final static String PAGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeMethod
    public void beforeTest() {
        DriverManager.driverSetup();
        PageSetup.setMaximizeOfWindow();
        PageSetup.setImplicitWait();
        PageSetup.setPageUrl(PAGE_URL);
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.extinctionDriver();
    }
}
