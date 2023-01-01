package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/leave/viewLeaveModule']")
    public WebElement leavePanelSection;

    @FindBy(xpath = "//a[normalize-space()='Assign Leave']")
    public WebElement assignLeaveButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameLabel;

    @FindBy(css = "div[role='option'] span")
    public WebElement promptedEmployeeData;

    @FindBy(css = "div[class='oxd-select-text-input']")
    public WebElement leaveTypeSection;

    @FindBy(xpath = "//span[contains(text(),'CAN - Vacation')]")
    public WebElement vacationOption;

    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")
    public WebElement fromDateLabel;

    @FindBy(xpath = "//div[@class='oxd-layout-context']//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]")
    public WebElement toDateLabel;

    @FindBy(css = "textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    public WebElement commentsTextArea;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement assignButton;

    @FindBy(css = "p[class='oxd-text oxd-text--p oxd-text--card-title']")
    public WebElement confirmLeaveAssignmentPopup;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-button-margin']")
    public WebElement confirmLeaveAssignmentButton;
}