package builders.login_page;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageBuilder extends CommonBuilder {

    @FindBy(name = "username")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]")
    public WebElement hrmBanner;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/img[1]")
    public WebElement hrmLogo;

    @FindBy(css = "p[class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
    public WebElement forgotYourPasswordHyperlink;

    @FindBy(css = "a[href='http://www.orangehrm.com']")
    public WebElement producerPageHyperlink;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;
}