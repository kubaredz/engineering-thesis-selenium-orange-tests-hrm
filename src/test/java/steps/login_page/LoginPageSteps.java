package steps.login_page;

import builders.LoginPageBuilder;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;

import java.util.*;
import java.util.logging.Level;

public class LoginPageSteps extends LoginPageBuilder {

    public LoginPageSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    public String getPageTitle() {
        logger.log(Level.INFO, "Nazwa strony została zaciągnięta: {0} ", DriverManager.driverSetup().getTitle());
        return DriverManager.driverSetup().getTitle();
    }

    public String getUserNameField() {
        logger.log(Level.INFO, "Atrybut \"user\" został zaciągnięty: {0}", usernameField.getAttribute("value"));
        return usernameField.getAttribute("value");
    }

    public LoginPageSteps setUserNameField(String name) {
        logger.log(Level.INFO, "Wprowadzam login użytkownika: {0}", name);
        usernameField.sendKeys(name);
        return new LoginPageSteps();
    }

    public String getPasswordField() {
        logger.log(Level.INFO, "Atrybut \"password\" został zaciągnięty: {0}", passwordField.getAttribute("value"));
        return passwordField.getAttribute("value");
    }

    public LoginPageSteps setPasswordField(String password) {
        logger.log(Level.INFO, "Wprowadzam hasło użytkownika: {0}", password);
        passwordField.sendKeys(password);
        return new LoginPageSteps();
    }

    public boolean isHrmBannerDisplayed() {
        logger.log(Level.INFO, "Banner: strony OrangeHRM został wyświetlony");
        return hrmBanner.isDisplayed();
    }

    public boolean isHrmLogoDisplayed() {
        logger.log(Level.INFO, "Logo: strony OrangeHRM zostało wyświetlone");
        return hrmLogo.isDisplayed();
    }

    public String getHyperlinkForgotYourPassword() {
        logger.log(Level.INFO, "Hyperlink: \"forgot your password\" został wyświetlony");
        return forgotYourPasswordHyperlink.getText();
    }

    public void clickForgotYourPasswordHyperlink() {
        forgotYourPasswordHyperlink.click();
        logger.log(Level.INFO, "Hyperlink: \"forgot your password\" został wciśnięty");
    }

    public String getCurrentPageUrl() {
        logger.log(Level.INFO, "Strona o nazwie: {0} została załadowana", DriverManager.driverSetup().getCurrentUrl());
        return DriverManager.driverSetup().getCurrentUrl();
    }

    public LoginPageSteps clickProducerPageHyperlink() {
        producerPageHyperlink.click();
        logger.log(Level.INFO, "Hyperlink: \"producer page\" został wciśnięty");
        return new LoginPageSteps();
    }

    public String getInvalidCredentialsAlertText() {
        logger.log(Level.INFO, "Tekst został wyświetlony: {0}", invalidCredentialsAlert.getText());
        return invalidCredentialsAlert.getText();
    }

    public LoginPageSteps clickLoginButton() {
        loginButton.click();
        logger.log(Level.INFO, "Przycisk: \"login button\" został wciśnięty");
        return new LoginPageSteps();
    }

    public LoginPageSteps switchHandledTab(int tab) {
        List<String> browserTabs = new ArrayList<>(DriverManager.driverSetup().getWindowHandles());
        DriverManager.driverSetup().switchTo().window(browserTabs.get(tab));
        logger.log(Level.INFO, "Karta przeglądarki została zmieniona");
        return new LoginPageSteps();
    }
}
