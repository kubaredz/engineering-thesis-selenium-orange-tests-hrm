package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/time/viewTimeModule']")
    public WebElement timePanelSection;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameLabel;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement viewButton;

    @FindBy(css = "div[role='option'] span")
    public WebElement promptedEmployeeName;
}
