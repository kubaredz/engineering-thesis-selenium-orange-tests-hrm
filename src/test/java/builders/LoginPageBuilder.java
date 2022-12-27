package builders;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageBuilder extends CommonBuilder {

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
}
