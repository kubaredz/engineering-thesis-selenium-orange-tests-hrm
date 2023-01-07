package steps.dashboard;

import builders.dashboard.HeaderBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static setup.DriverPicker.driverSetup;

public class HeaderSteps extends HeaderBuilder {

    public HeaderSteps() {
        PageFactory.initElements(driverSetup(), this);
    }

    @Step("'Dropdown' zostal wcisniety")
    public HeaderSteps clickDropdownButton() {
        dropDownButton.click();
        logger.log(Level.INFO, "Dropdown: \"Header\" zostal wcisniety");
        return new HeaderSteps();
    }

    @Step("Pobranie zawartosci dropdown 'menu'")
    public WebElement getDropdownMenu() {
        logger.log(Level.INFO, "Dropdown: \"Menu\" zostal wyswietlony");
        return dropdownMenu;
    }

    @Step("Pobranie aktualnego uzytkownika")
    public WebElement getUserDropdown() {
        logger.log(Level.INFO, "Dropdown: \"User\" zostal wyswietlony");
        return userDropdown;
    }

    @Step("Pobranie sekcji 'About'")
    public WebElement getAboutSection() {
        logger.log(Level.INFO, "Sekcja: \"About\" zostala wyswietlona");
        return aboutSection;
    }

    @Step("Pobranie adresu url strony")
    public String getPageUrl() {
        String pageUrl = driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Adres otworzonej strony to: {0}", pageUrl);
        return pageUrl;
    }

    @Step("Pobranie aktualnego uzytkownika")
    public String getLoggedUser() {
        String user = loggedUser.getText();
        logger.log(Level.INFO, "Zalogowany uzytkownik to: {0}", user);
        return user;
    }

    @Step("Przycisk 'Logout' zostal wcisniety")
    public HeaderSteps clickLogoutButton() {
        logoutButton.click();
        logger.log(Level.INFO, "Przycisk: \"Logout\" zostal wcisniety");
        return new HeaderSteps();
    }

    @Step("Pobranie nazwy sekcji")
    public String getSectionHeaderText() {
        String visibleSectionText = headerSectionText.getText();
        logger.log(Level.INFO, "Pobranie nazwy sekcji: {0}", visibleSectionText);
        return visibleSectionText;
    }
}