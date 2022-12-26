package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/recruitment/viewRecruitmentModule']")
    public WebElement recruitmentPanelSection;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addButton;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 orangehrm-main-title']")
    public WebElement addCandidateSectionText;

    @FindBy(css = "input[class='oxd-input oxd-input--active orangehrm-firstname']")
    public WebElement firstNameLabel;

    @FindBy(css = "input[class='oxd-input oxd-input--active orangehrm-middlename']")
    public WebElement secondNameLabel;

    @FindBy(css = "input[class='oxd-input oxd-input--active orangehrm-lastname']")
    public WebElement lastNameLabel;

    @FindBy(xpath = "//span[normalize-space()='Associate IT Manager']")
    public WebElement vacancyAssociateItManager;

    @FindBy(css = "div[class='oxd-select-text-input']")
    public WebElement vacancySelect;

    @FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//div[2]//input[1]")
    public WebElement emailLabel;

    @FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
    public WebElement contactNumberLabel;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(css = "div[class='oxd-toast-icon-container']")
    public WebElement positiveAlert;
}
