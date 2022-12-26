package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class CommonBuilder {
    public final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    public WebElement headerTextPrefix;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")
    public WebElement headerTextAddition;
}
