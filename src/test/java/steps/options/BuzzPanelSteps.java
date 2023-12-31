package steps.options;

import builders.options.BuzzPanelBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static setup.DriverPicker.driverSetup;

public class BuzzPanelSteps extends BuzzPanelBuilder implements DefaultSteps, CommonSteps {

    public BuzzPanelSteps() {
        PageFactory.initElements(driverSetup(), this);
    }

    @Override
    @Step("Text: 'Buzz' zostal wyswietlony")
    public boolean isHeaderTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"Buzz\" zostal wyswietlony");
        return headerTextPrefix.isDisplayed();
    }

    @Override
    @Step("Sekcja: 'Buzz' zostala otwarta")
    public BuzzPanelSteps clickPanelSection() {
        buzzPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Buzz\" zostal wcisniety");
        return new BuzzPanelSteps();
    }

    @Override
    public CommonSteps clickAddButton() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CommonSteps clickSaveButton() {
        throw new UnsupportedOperationException();
    }

    @Step("Text: 'Launching Soon' zostal wyswietlony")
    public boolean isLaunchingSoonTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"Launching Soon\" zostal wyswietlony");
        return headerTextPrefix.isDisplayed();
    }

    @Step("Text: 'Launching Soon' zostal wyswietlony")
    public String getLaunchingSoonText() {
        String launchingSoon = launchingSoonText.getText();
        logger.log(Level.INFO, "Tekst: {0} zostal wyswietlony", launchingSoon);
        return launchingSoon;
    }
}