package steps.options;

import builders.options.DirectoryPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class DirectoryPanelSteps extends DirectoryPanelBuilder implements CommonSteps, CommonGenericSteps<DirectoryPanelSteps> {

    public DirectoryPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'Directory' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Directory\" została wyświetlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Directory' zostala otwarta")
    public <T> DirectoryPanelSteps clickPanelSection() {
        directorySection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Directory\" został wciśnięty");
        return new DirectoryPanelSteps();
    }

    @Override
    public <T> CommonGenericSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> CommonGenericSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }
}
