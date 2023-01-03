package tests;

import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import setup.DriverPicker;
import setup.PageSetup;

import static properties.PropertiesReader.setPropertiesFromFileInSystem;

public class TestBase {

    @BeforeClass
    @Step("Metoda odpowiedzialna za zalodowanie konfiguracji z pliku configuration.properties")
    public void beforeClass() {
        setPropertiesFromFileInSystem();
    }

    @BeforeMethod
    @Step("Metoda odpowiedzialna za utworzenie drivera, ustawienie opoznienia oraz uruchomienia strony Orange HRM")
    public void beforeMethod() {
        DriverPicker.driverSetup();
        PageSetup.setMaximizeOfWindow();
        PageSetup.setImplicitWait();
        PageSetup.setPageUrl();
    }

    @AfterMethod
    @Step("Metoda odpowiedzialna za zamkniecie przegladarki oraz wylaczenie drivera")
    public void afterMethod() {
        DriverPicker.getDriver().close();
        DriverPicker.setDriver(null);
    }
}
