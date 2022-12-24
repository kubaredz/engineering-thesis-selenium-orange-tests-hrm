package steps.dashboard;

import builders.HeaderBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.logging.Level;

public class HeaderSteps extends HeaderBuilder {

    public HeaderSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }


    @Step("'Dropdown' zostal wcisniety")
    public void clickDropdownButton() {
        dropDownButton.click();
        logger.log(Level.INFO, "Dropdown: \"Header\" został wciśnięty");
    }

    @Step("Pobranie zawartosci dropdown 'menu'")
    public WebElement getDropdownMenu() {
        logger.log(Level.INFO, "Dropdown: \"Menu\" został wyświetlony");
        return dropdownMenu;
    }

    @Step("Pobranie aktualnego uzytkownika")
    public WebElement getUserDropdown() {
        logger.log(Level.INFO, "Dropdown: \"User\" został wyświetlony");
        return userDropdown;
    }

    @Step("Pobranie sekcji 'About'")
    public WebElement getAboutSection() {
        logger.log(Level.INFO, "Sekcja: \"About\" została wyświetlona");
        return aboutSection;
    }

    @Step("Pobranie adresu url strony")
    public String getPageUrl() {
        String pageUrl = DriverManager.driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Adres otworzonej strony to: {0}", pageUrl);
        return pageUrl;
    }

    @Step("Pobranie aktualnego uzytkownika")
    public String getLoggedUser() {
        String user = loggedUser.getText();
        logger.log(Level.INFO, "Zalogowany użytkownik to: {0}", user);
        return user;
    }
}
