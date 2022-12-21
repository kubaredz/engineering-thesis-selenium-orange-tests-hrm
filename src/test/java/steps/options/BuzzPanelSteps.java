package steps.options;

import builders.BuzzPanelBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class BuzzPanelSteps extends BuzzPanelBuilder {

    public BuzzPanelSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public BuzzPanelSteps clickBuzzPanelSection() {
        buzzPanelSection.click();
        logger.log(Level.INFO, "Przycisk dla sekcji: \"Buzz\" został wciśnięty");
        return new BuzzPanelSteps();
    }

    public boolean isBuzzTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"Buzz\" został wyświetlony");
        return buzzText.isDisplayed();
    }

    public boolean isLaunchingSoonTextDisplayed() {
        logger.log(Level.INFO, "Tekst: \"Launching Soon\" został wyświetlony");
        return buzzText.isDisplayed();
    }

    public String getLaunchingSoonText() {
        logger.log(Level.INFO, "Tekst: {0} został wyświetlony", launchingSoonText.getText());
        return launchingSoonText.getText();
    }
}
