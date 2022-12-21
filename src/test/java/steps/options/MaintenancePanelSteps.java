package steps.options;

import builders.MaintenancePanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class MaintenancePanelSteps extends MaintenancePanelBuilder {

    public MaintenancePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public MaintenancePanelSteps clickMaintenanceSection() {
        maintenanceSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Maintenance\" został wciśnięty");
        return new MaintenancePanelSteps();
    }

    public String getMaintenancePageUrl() {
        logger.log(Level.INFO, "Adres otworzonej strony to: {0}", DriverManager.driverSetup().getCurrentUrl());
        return DriverManager.driverSetup().getCurrentUrl();
    }

    public MaintenancePanelSteps setPasswordLabel(String password) {
        passwordLabel.sendKeys(password);
        logger.log(Level.INFO, "Hasło: {0} zostało ustawione", password);
        return new MaintenancePanelSteps();
    }

    public MaintenancePanelSteps clickConfirmButton() {
        confirmButton.click();
        logger.log(Level.INFO, "Przycisk: confirm został wciśnięty");
        return new MaintenancePanelSteps();
    }

    public boolean isMaintenanceTextDisplayed() {
        logger.log(Level.INFO, "Text: Maintenance jest widoczny");
        return maintenanceSectionText.isDisplayed();
    }

    public boolean isPurgeRecordsTextDisplayed() {
        logger.log(Level.INFO, "Text: Purge Records jest widoczny");
        return purgeRecordsSectionText.isDisplayed();
    }

    public String getMaintenanceText() {
        logger.log(Level.INFO, "Text: {0} jest widoczny", maintenanceSectionText.getText());
        return maintenanceSectionText.getText();
    }

    public String getPurgeRecordsText() {
        logger.log(Level.INFO, "Text: {0} jest widoczny", purgeRecordsSectionText.getText());
        return purgeRecordsSectionText.getText();
    }
}
