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

    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    public WebElement addButton;

    @FindBy(css = "h6[class='oxd-text oxd-text--h6 orangehrm-main-title']")
    public WebElement addText;

    @FindBy(css = "div[class='oxd-toast-icon-container']")
    public WebElement infoAlert;

    @FindBy(css = "div[class='oxd-toast-icon-container']")
    public WebElement positiveAlert;

    @FindBy(css = "p[class*='oxd-text oxd-text--p oxd-alert-content-text']")
    public WebElement invalidCredentialsAlert;
}