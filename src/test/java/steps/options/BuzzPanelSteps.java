package steps.options;

import builders.options.BuzzPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class BuzzPanelSteps extends BuzzPanelBuilder implements CommonSteps, CommonGenericSteps<BuzzPanelSteps> {

    public BuzzPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Override
    @Step("Text: 'Buzz' zostal wyswietlony")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"Buzz\" został wyświetlony");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Buzz' zostala otwarta")
    public <T> BuzzPanelSteps clickPanelSection() {
        buzzPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Buzz\" został wciśnięty");
        return new BuzzPanelSteps();
    }

    @Override
    public <T> CommonGenericSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Text: 'Launching Soon' zostal wyswietlony")
    public boolean isLaunchingSoonTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"Launching Soon\" został wyświetlony");
        return headerTextPrefix.isDisplayed();
    }

    @Step("Text: 'Launching Soon' zostal wyswietlony")
    public String getLaunchingSoonText() {
        String launchingSoon = launchingSoonText.getText();
        logger.log(Level.INFO, "Tekst: {0} został wyświetlony", launchingSoon);
        return launchingSoon;
    }
}
