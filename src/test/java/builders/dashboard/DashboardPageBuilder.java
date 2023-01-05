package builders.dashboard;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageBuilder extends CommonBuilder {

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[1]/a[1]/div[2]/img[1]")
    public WebElement hrmLogoAfterLogin;

    @FindBy(xpath = "//p[normalize-space()='Time at Work']")
    public WebElement timeAtWorkSection;

    @FindBy(xpath = "//p[normalize-space()='My Actions']")
    public WebElement myActionsSection;

    @FindBy(xpath = "//p[normalize-space()='Quick Launch']")
    public WebElement quickLaunchSection;

    @FindBy(xpath = "//p[normalize-space()='Employees on Leave Today']")
    public WebElement employeesOnLeaveSection;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Sub Unit']")
    public WebElement employeeDistributionBySubUnitLeaveSection;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Location']")
    public WebElement employeeDistributionByLocationSection;
}