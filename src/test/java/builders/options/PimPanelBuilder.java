package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PimPanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
    public WebElement pimPanelSection;

    @FindBy(css = "button[class='oxd-icon-button employee-image-action']")
    public WebElement uploadImageButton;

    @FindBy(name = "firstName")
    public WebElement firstNameLabel;

    @FindBy(name = "middleName")
    public WebElement middleNameLabel;

    @FindBy(name = "lastName")
    public WebElement lastNameLabel;

    @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    public WebElement loginDetailsCheckBox;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElement usernameLabel;

    @FindBy(xpath = "//label[normalize-space()='Enabled']")
    public WebElement statusEnabledRadioButton;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement passwordLabel;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement confirmPasswordLabel;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement saveButton;

    @FindBy(css = "div[class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    public WebElement successPopup;

    @FindBy(xpath = "(//a[normalize-space()='Reports'])[1]")
    public WebElement reportsButton;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addButton;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    public WebElement reportNameLabel;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement selectionCriteriaSelect;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[1]")
    public WebElement criteriaButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[2]/div[2]/button[1]")
    public WebElement displayFieldsButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement educationTypeSelect;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement displayedFieldGroupSelect;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement displayFieldSelect;

    //TODO with regex "%s"
    String tmp;
    @FindBy(xpath = "//span[normalize-space()='criteria']")
    public String criteriaSelect;
}