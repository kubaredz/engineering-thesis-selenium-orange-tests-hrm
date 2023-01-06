package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecruitmentPanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/recruitment/viewRecruitmentModule']")
    public WebElement recruitmentPanelSection;

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

    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[@class='oxd-grid-item oxd-grid-item--gutters']/div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[1]")
    public WebElement vacancyNameLabel;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    public WebElement jobTitleSelect;

    @FindBy(xpath = "//textarea[@placeholder='Type description here']")
    public WebElement jobDescriptionLabel;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement hiringManagerLabel;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]")
    public WebElement promptedHiringManager;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
    public WebElement numberOfPositionLabel;

    @FindBy(xpath = "//h6[normalize-space()='Edit Vacancy']")
    public WebElement editVacancyText;

    @FindBy(how = How.XPATH)
    public WebElement pickedJob;
}