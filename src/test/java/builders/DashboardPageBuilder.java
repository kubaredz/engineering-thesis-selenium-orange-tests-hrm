package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.dashboard.DashboardSteps;
import java.util.logging.Logger;

public class DashboardPageBuilder {

    public static final Logger LOGGER = Logger.getLogger(DashboardSteps.class.getName());

    @FindBy(css = "img[src*='orangehrm-logo.png']")
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
