package steps.options;

import builders.options.PerformancePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;

import java.util.logging.Level;

public class PerformancePanelSteps extends PerformancePanelBuilder implements CommonSteps {

    public PerformancePanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja: 'Performance' zostala otwarta")
    public PerformancePanelSteps clickPanelSection() {
        performanceSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Performance\" zostal wcisniety");
        return new PerformancePanelSteps();
    }

    @Override
    public CommonSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CommonSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Sekcja 'Performance' zostala wyswietlona")
    public boolean isPerformanceSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Manage Reviews\" zostala wyswietlona");
        return performanceSection.isDisplayed();
    }

    @Step("Sekcja: 'Manage Reviews' zostala wyswietlona")
    public boolean isManageReviewsSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Manage Reviews\" zostala wyswietlona");
        return headerTextAddition.isDisplayed();
    }
}