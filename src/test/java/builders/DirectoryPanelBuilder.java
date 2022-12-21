package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPanelBuilder extends LoggerManager{
    @FindBy(css = "a[href='/web/index.php/directory/viewDirectory']")
    public WebElement directorySection;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    public WebElement directorySectionLabel;
}
