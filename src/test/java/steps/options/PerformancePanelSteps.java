package steps.options;

import builders.options.PerformancePanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class PerformancePanelSteps extends PerformancePanelBuilder implements CommonGenericSteps<PerformancePanelSteps>{

    public PerformancePanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Override
    @Step("Sekcja: 'Performance' zostala otwarta")
    public <T> PerformancePanelSteps clickPanelSection() {
        performanceSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Performance\" został wciśnięty");
        return new PerformancePanelSteps();
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
