package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TimePanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/time/viewTimeModule']")
    public WebElement timePanelSection;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameLabel;

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement viewButton;

    @FindBy(css = "div[role='option'] span")
    public WebElement promptedEmployeeName;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/h6[1]")
    public WebElement timesheetForLoggedUserText;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement projectNameLabel;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[1]")
    public WebElement pickedProject;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement activitySelect;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    public WebElement deleteReportButton;

    @FindBy(how = How.XPATH)
    public WebElement buttonFromList;

    @FindBy(how = How.XPATH)
    public WebElement pickedOption;

    @FindBy(how = How.XPATH)
    public WebElement dayLabel;
}