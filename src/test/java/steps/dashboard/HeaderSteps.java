package steps.dashboard;

import builders.HeaderBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class HeaderSteps extends HeaderBuilder {

    public HeaderSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }


    public void clickDropdownButton() {
        dropDownButton.click();
        LOGGER.log(Level.INFO, "Dropdown: \"Header\" został wciśnięty");
    }

    public WebElement getDropdownMenu() {
        LOGGER.log(Level.INFO, "Dropdown: \"Menu\" został wyświetlony");
        return dropdownMenu;
    }

    public WebElement getUserDropdown() {
        LOGGER.log(Level.INFO, "Dropdown: \"User\" został wyświetlony");
        return userDropdown;
    }


    public WebElement getAboutSection() {
        LOGGER.log(Level.INFO, "Sekcja: \"About\" została wyświetlona");
        return aboutSection;
    }

    public String getPageUrl() {
        LOGGER.log(Level.INFO, "Adres otworzonej strony to: {0}", DriverManager.driverSetup().getCurrentUrl());
        return DriverManager.driverSetup().getCurrentUrl();
    }
}
