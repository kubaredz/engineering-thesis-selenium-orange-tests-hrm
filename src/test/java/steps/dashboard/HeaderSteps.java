package steps.dashboard;

import builders.HeaderBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class HeaderSteps extends HeaderBuilder {

    public HeaderSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
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
        return DriverManager.driverSetup().getCurrentUrl();
    }
}
