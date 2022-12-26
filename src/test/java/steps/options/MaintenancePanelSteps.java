package steps.options;

import builders.MaintenancePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class MaintenancePanelSteps extends MaintenancePanelBuilder {

    public MaintenancePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Step("Sekcja: 'Maintenance' zostala otwarta")
    public MaintenancePanelSteps clickMaintenanceSection() {
        maintenanceSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Maintenance\" został wciśnięty");
        return new MaintenancePanelSteps();
    }

    @Step("Strona: Maintenance zostala otwarta")
    public String getMaintenancePageUrl() {
        String pageUrl = DriverManager.driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Adres otworzonej strony to: {0}", pageUrl);
        return pageUrl;
    }

    @Step("Haslo: {password} zostalo wpisane")
    public MaintenancePanelSteps setPasswordLabel(String password) {
        passwordLabel.sendKeys(password);
        logger.log(Level.INFO, "Hasło: {0} zostało ustawione", password);
        return new MaintenancePanelSteps();
    }

    @Step("Przycisk: 'Confirm' zostal wcisniety")
    public MaintenancePanelSteps clickConfirmButton() {
        confirmButton.click();
        logger.log(Level.INFO, "Przycisk: confirm został wciśnięty");
        return new MaintenancePanelSteps();
    }

    @Step("Text: 'Maintenance' zostal wyswietlony")
    public boolean isMaintenanceTextDisplayed() {
        logger.log(Level.INFO, "Text: Maintenance jest widoczny");
        return headerTextPrefix.isDisplayed();
    }

    @Step("Text: 'Purge Records' zostal wyswietlony")
    public boolean isPurgeRecordsTextDisplayed() {
        logger.log(Level.INFO, "Text: Purge Records jest widoczny");
        return headerTextAddition.isDisplayed();
    }

    @Step("Text: 'Maintenance' jest widoczny")
    public String getMaintenanceText() {
        String maintenanceText = headerTextPrefix.getText();
        logger.log(Level.INFO, "Text: {0} jest widoczny", maintenanceText);
        return maintenanceText;
    }

    @Step("Text: 'Purge Records' jest widoczny")
    public String getPurgeRecordsText() {
        String purgeRecordsSection = headerTextAddition.getText();
        logger.log(Level.INFO, "Text: {0} jest widoczny", purgeRecordsSection);
        return purgeRecordsSection;
    }
}
