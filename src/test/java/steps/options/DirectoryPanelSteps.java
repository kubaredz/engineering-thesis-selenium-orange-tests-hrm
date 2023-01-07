package steps.options;

import builders.options.DirectoryPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;

import java.util.logging.Level;

public class DirectoryPanelSteps extends DirectoryPanelBuilder implements DefaultSteps, CommonSteps {

    public DirectoryPanelSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Override
    @Step("Sekcja 'Directory' zostala wyswietlona")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Sekcja: \"Directory\" zostala wyswietlona");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Directory' zostala otwarta")
    public DirectoryPanelSteps clickPanelSection() {
        directorySection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Directory\" zostal wcisniety");
        return new DirectoryPanelSteps();
    }

    @Override
    public CommonSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CommonSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }
}