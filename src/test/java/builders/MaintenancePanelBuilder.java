package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaintenancePanelBuilder extends LoggerManager{

    @FindBy(css = "a[href='/web/index.php/maintenance/viewMaintenanceModule']")
    public WebElement maintenanceSection;

    @FindBy(name = "password")
    public WebElement passwordLabel;

    @FindBy(css = "button[class='oxd-button oxd-button--large oxd-button--secondary orangehrm-admin-access-button']")
    public WebElement confirmButton;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    public WebElement maintenanceSectionText;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
    public WebElement purgeRecordsSectionText;
}
