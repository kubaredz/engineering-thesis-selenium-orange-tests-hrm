package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuzzPanelBuilder extends LoggerManager{

    @FindBy(css = "a[href='/web/index.php/buzz/viewBuzz']")
    public WebElement buzzPanelSection;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    public WebElement buzzText;

    @FindBy(css = "h4[class='oxd-text oxd-text--h4 orangehrm-module-under-development-heading']")
    public WebElement launchingSoonText;


}
