package steps.options;

import builders.options.PerformancePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;

import java.util.logging.Level;

public class PerformancePanelSteps extends PerformancePanelBuilder implements CommonGenericSteps<PerformancePanelSteps>{

    public PerformancePanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja: 'Performance' zostala otwarta")
    public <T> PerformancePanelSteps clickPimPanelSection() {
        performanceSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Performance\" został wciśnięty");
        return new PerformancePanelSteps();
    }

    @Override
    public <T> CommonGenericSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> CommonGenericSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Sekcja 'Performance' zostala wyswietlona")
    public boolean isPerformanceSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Manage Reviews\" została wyświetlona");
        return performanceSection.isDisplayed();
    }

    @Step("Sekcja: 'Manage Reviews' zostala wyswietlona")
    public boolean isManageReviewsSectionDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Manage Reviews\" została wyświetlona");
        return headerTextAddition.isDisplayed();
    }
}
