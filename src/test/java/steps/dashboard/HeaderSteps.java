package steps.dashboard;

import builders.HeaderBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class HeaderSteps extends HeaderBuilder {

    public HeaderSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public WebElement getDropdownButton() {
        return dropDownButton;
    }

    public void clickDropdownButton() {
        dropDownButton.click();
    }

    public WebElement getDropdownMenu() {
        return dropdownMenu;
    }


    public WebElement getUserDropdown() {
        return userDropdown;
    }


    public WebElement getAboutSection() {
        return aboutSection;
    }

    public String getPageUrl() {
        String pageTitle = DriverManager.driverSetup().getCurrentUrl();
        return pageTitle;
    }
}
