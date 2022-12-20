package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePanelBuilder extends LoggerManager {

    @FindBy(css = "a[href='/web/index.php/time/viewTimeModule']")
    public WebElement timePanelSection;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
    public WebElement timesheetSection;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameLabel;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement viewButton;

    @FindBy(css = "div[role='option'] span")
    public WebElement promptedEmployeeName;

    @FindBy(css = "div[class='oxd-toast-icon-container']")
    public WebElement infoAlert;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    public WebElement timeSection;
}
