package builders.dashboard;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderBuilder extends CommonBuilder {

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul")
    public WebElement dropDownButton;

    @FindBy(css = "ul[class='oxd-dropdown-menu']")
    public WebElement dropdownMenu;

    @FindBy(css = "i[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    public WebElement userDropdown;

    @FindBy(css = "//a[contains(text(),'About')]")
    public WebElement aboutSection;

    @FindBy(css = "p[class='oxd-userdropdown-name']")
    public WebElement loggedUser;

    @FindBy(css = "a[href='/web/index.php/auth/logout']")
    public WebElement logoutButton;
}
