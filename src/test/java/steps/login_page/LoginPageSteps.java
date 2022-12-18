package steps.login_page;

import builders.LoginPageBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.*;

public class LoginPageSteps extends LoginPageBuilder {

    public LoginPageSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public String getPageTitle() {
        return DriverManager.driverSetup().getTitle();
    }

    public String getUserNameField() {
        return usernameField.getAttribute("value");
    }

    public void setUserNameField(String name) {
        usernameField.sendKeys(name);
    }

    public String getPasswordField() {
        return passwordField.getAttribute("value");
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public boolean isHrmBannerDisplayed() {
        return hrmBanner.isDisplayed();
    }

    public boolean isHrmLogoDisplayed() {
        return hrmLogo.isDisplayed();
    }

    public String getHyperlinkForgotYourPassword() {
        return forgotYourPasswordHyperlink.getText();
    }

    public void clickForgotYourPasswordHyperlink() {
        forgotYourPasswordHyperlink.click();
    }

    public String getCurrentPageUrl() {
        return DriverManager.driverSetup().getCurrentUrl();
    }

    public void clickProducerPageHyperlink() {
        producerPageHyperlink.click();
    }

    public String getInvalidCredentialsAlertText() {
        return invalidCredentialsAlert.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void switchHandledTab(int tab) {
        List<String> browserTabs = new ArrayList<>(DriverManager.driverSetup().getWindowHandles());
        DriverManager.driverSetup().switchTo().window(browserTabs.get(tab));
    }
}
