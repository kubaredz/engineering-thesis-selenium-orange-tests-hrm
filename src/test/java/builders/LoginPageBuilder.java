package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.login_page.LoginPageSteps;

import java.util.logging.Logger;

public class LoginPageBuilder {

    public static final Logger LOGGER = Logger.getLogger(LoginPageSteps.class.getName());

    @FindBy(name = "username")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(css = "img[src*='ohrm_branding']")
    public WebElement hrmBanner;

    @FindBy(xpath = "//div[@class='orangehrm-login-logo']/img[1]")
    public WebElement hrmLogo;

    @FindBy(css = "p[class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    public WebElement forgotYourPasswordHyperlink;

    @FindBy(css = "a[href='http://www.orangehrm.com']")
    public WebElement producerPageHyperlink;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(css = "p[class*='oxd-text oxd-text--p oxd-alert-content-text']")
    public WebElement invalidCredentialsAlert;
}
