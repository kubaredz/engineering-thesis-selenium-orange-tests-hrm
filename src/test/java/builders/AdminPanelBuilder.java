package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanelBuilder extends LoggerManager {

    @FindBy(css = "a[href='/web/index.php/admin/viewAdminModule']")
    public WebElement adminPanelSection;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
    public WebElement userManagementSection;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addButton;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 orangehrm-main-title']")
    public WebElement addUserText;

    @FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]")
    public WebElement userRoleDropdown;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']//input[1]")
    public WebElement employeeNameLabel;

    @FindBy(xpath = "(//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]")
    public WebElement statusDropdown;
}
