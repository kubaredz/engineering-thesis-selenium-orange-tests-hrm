package steps.options;

import builders.options.MaintenancePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;
import utils.RepeatedActions;

import java.util.logging.Level;

public class MaintenancePanelSteps extends MaintenancePanelBuilder implements DefaultSteps, CommonSteps {

    public MaintenancePanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Text: 'Maintenance' zostal wyswietlony")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Text: Maintenance jest widoczny");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Maintenance' zostala otwarta")
    public MaintenancePanelSteps clickPanelSection() {
        maintenanceSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Maintenance\" zostal wciśnięty");
        return new MaintenancePanelSteps();
    }

    @Override
    public CommonSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CommonSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Strona: Maintenance zostala otwarta")
    public String getMaintenancePageUrl() {
        String pageUrl = DriverPicker.driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Adres otworzonej strony to: {0}", pageUrl);
        return pageUrl;
    }

    @Step("Haslo: {password} zostalo wpisane")
    public MaintenancePanelSteps setPasswordLabel(String password) {
        RepeatedActions.deletingAndAddingContentToLabel(passwordLabel, password);
        logger.log(Level.INFO, "Haslo: {0} zostalo ustawione", password);
        return new MaintenancePanelSteps();
    }

    @Step("Przycisk: 'Confirm' zostal wcisniety")
    public MaintenancePanelSteps clickConfirmButton() {
        confirmButton.click();
        logger.log(Level.INFO, "Przycisk: confirm zostal wciśnięty");
        return new MaintenancePanelSteps();
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
