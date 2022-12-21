package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformancePanelBuilder extends LoggerManager {

    @FindBy(css = "a[href='/web/index.php/performance/viewPerformanceModule']")
    public WebElement performanceSection;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
    public WebElement performanceSectionLabel;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
    public WebElement manageReviewsLabel;
}
