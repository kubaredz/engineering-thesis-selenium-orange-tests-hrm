package tests;

import configuration.AppProperties;
import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import setup.DriverManager;
import setup.PageSetup;

import java.util.Properties;

public class TestBase {

    @BeforeClass
    @Step("Metoda odpowiedzialna za zalodowanie konfiguracji z pliku configuration.properties")
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @BeforeMethod
    @Step("Metoda odpowiedzialna za utworzenie drivera, ustawienie opoznienia oraz uruchomienia strony Orange HRM")
    public void beforeTest() {
        DriverManager.driverSetup();
        PageSetup.setMaximizeOfWindow();
        PageSetup.setImplicitWait();
        PageSetup.setPageUrl(AppProperties.getAllUrl());
    }

    @AfterMethod
    @Step("Metoda odpowiedzialna za zamkniecie przegladarki oraz wylaczenie drivera")
    public void afterTest() {
        DriverManager.extinctionDriver();
    }
}
