package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/admin/viewAdminModule']")
    public WebElement adminPanelSection;

    @FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]")
    public WebElement userRoleDropdown;

    @FindBy(css = "div[role='listbox'] div:nth-child(2) span:nth-child(1)")
    public WebElement adminUserRole;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']//input[1]")
    public WebElement employeeNameLabel;

    @FindBy(css = "div[role='option'] span")
    public WebElement employeeNameFromList;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement passwordLabel;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement confirmPasswordLabel;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement statusList;

    @FindBy(xpath = "//span[contains(text(),'Enabled')]")
    public WebElement statusEnabled;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]")
    public WebElement usernameLabel;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;

    @FindBy(css = "h5[class='oxd-text oxd-text--h5 oxd-table-filter-title']")
    public WebElement systemUsersText;
}
