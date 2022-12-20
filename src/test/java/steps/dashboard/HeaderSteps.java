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
        logger.log(Level.INFO, "Dropdown: \"Header\" został wciśnięty");
    }

    public WebElement getDropdownMenu() {
        logger.log(Level.INFO, "Dropdown: \"Menu\" został wyświetlony");
        return dropdownMenu;
    }

    public WebElement getUserDropdown() {
        logger.log(Level.INFO, "Dropdown: \"User\" został wyświetlony");
        return userDropdown;
    }


    public WebElement getAboutSection() {
        logger.log(Level.INFO, "Sekcja: \"About\" została wyświetlona");
        return aboutSection;
    }

    public String getPageUrl() {
        logger.log(Level.INFO, "Adres otworzonej strony to: {0}", DriverManager.driverSetup().getCurrentUrl());
        return DriverManager.driverSetup().getCurrentUrl();
    }

    public String getLoggedUser() {
        logger.log(Level.INFO, "Zalogowany użytkownik to: {0}", loggedUser.getText());
        return loggedUser.getText();
    }
}
