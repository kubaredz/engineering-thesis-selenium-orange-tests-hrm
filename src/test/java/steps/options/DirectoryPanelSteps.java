package steps.options;

import builders.DirectoryPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class DirectoryPanelSteps extends DirectoryPanelBuilder {

    public DirectoryPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Step("Sekcja: 'Directory' zostala otwarta")
    public PerformancePanelSteps clickDirectorySection() {
        directorySection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Directory\" został wciśnięty");
        return new PerformancePanelSteps();
    }

    @Step("Sekcja 'Directory' zostala wyswietlona")
    public boolean isDirectoryDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Directory\" została wyświetlona");
        return directorySectionLabel.isDisplayed();
    }
}
