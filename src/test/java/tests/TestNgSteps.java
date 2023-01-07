package tests;

import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static properties.PropertiesReader.setSystemFileProperties;
import static setup.DriverPicker.*;
import static setup.PageSetup.*;

public class TestNgSteps {

    @BeforeClass
    @Step("Metoda odpowiedzialna za zalodowanie konfiguracji z pliku configuration.properties")
    public void beforeClass() {
        setSystemFileProperties();
    }

    @BeforeMethod
    @Step("Metoda odpowiedzialna za utworzenie drivera, ustawienie opoznienia oraz uruchomienia strony Orange HRM")
    public void beforeMethod() {
        driverSetup();
        setMaximizeOfWindow();
        setImplicitWait();
        setPageUrl();
    }

    @AfterMethod
    @Step("Metoda odpowiedzialna za zamkniecie przegladarki oraz wylaczenie drivera")
    public void afterMethod() {
        getDriver().close();
        setDriver(null);
    }
}