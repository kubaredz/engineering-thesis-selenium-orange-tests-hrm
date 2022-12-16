package steps.dashboard;

import builders.HeaderBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

public class HeaderSteps extends HeaderBuilder {

    public HeaderSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public WebElement getDropDownButton() {
        return dropDownButton;
    }

    public void setDropDownButton(WebElement dropDownButton) {
        this.dropDownButton = dropDownButton;
    }

    public WebElement getDropdownMenu() {
        return dropdownMenu;
    }

    public void setDropdownMenu(WebElement dropdownMenu) {
        this.dropdownMenu = dropdownMenu;
    }

    public WebElement getUserDropdown() {
        return userDropdown;
    }

    public void setUserDropdown(WebElement userDropdown) {
        this.userDropdown = userDropdown;
    }

    public WebElement getAboutSection() {
        return aboutSection;
    }

    public void setAboutSection(WebElement aboutSection) {
        this.aboutSection = aboutSection;
    }

    public String getPageUrl() {
        String pageTitle = DriverManager.driverSetup().getCurrentUrl();
        return pageTitle;
    }
}
