package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaintenancePanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/maintenance/viewMaintenanceModule']")
    public WebElement maintenanceSection;

    @FindBy(name = "password")
    public WebElement passwordLabel;

    @FindBy(css = "button[class='oxd-button oxd-button--large oxd-button--secondary orangehrm-admin-access-button']")
    public WebElement confirmButton;
}
