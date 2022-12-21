package steps.options;

import builders.DirectoryPanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class DirectoryPanelSteps extends DirectoryPanelBuilder {

    public DirectoryPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public PerformancePanelSteps clickDirectorySection() {
        directorySection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Directory\" został wciśnięty");
        return new PerformancePanelSteps();
    }

    public boolean isDirectoryDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Directory\" została wyświetlona");
        return directorySectionLabel.isDisplayed();
    }
}
