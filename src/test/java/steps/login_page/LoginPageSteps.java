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
        LOGGER.log(Level.INFO, "Nazwa strony została zaciągnięta: {0} ", DriverManager.driverSetup().getTitle());
        return DriverManager.driverSetup().getTitle();
    }

    public String getUserNameField() {
        LOGGER.log(Level.INFO, "Atrybut \"user\" został zaciągnięty: {0}", usernameField.getAttribute("value"));
        return usernameField.getAttribute("value");
    }

    public void setUserNameField(String name) {
        LOGGER.log(Level.INFO, "Wprowadzam login użytkownika: {0}", name);
        usernameField.sendKeys(name);
    }

    public String getPasswordField() {
        LOGGER.log(Level.INFO, "Atrybut \"password\" został zaciągnięty: {0}", passwordField.getAttribute("value"));
        return passwordField.getAttribute("value");
    }

    public void setPasswordField(String password) {
        LOGGER.log(Level.INFO, "Wprowadzam hasło użytkownika: {0}", password);
        passwordField.sendKeys(password);
    }

    public boolean isHrmBannerDisplayed() {
        LOGGER.log(Level.INFO, "Banner: strony OrangeHRM został wyświetlony");
        return hrmBanner.isDisplayed();
    }

    public boolean isHrmLogoDisplayed() {
        LOGGER.log(Level.INFO, "Logo: strony OrangeHRM zostało wyświetlone");
        return hrmLogo.isDisplayed();
    }

    public String getHyperlinkForgotYourPassword() {
        LOGGER.log(Level.INFO, "Hyperlink: \"forgot your password\" został wyświetlony");
        return forgotYourPasswordHyperlink.getText();
    }

    public void clickForgotYourPasswordHyperlink() {
        forgotYourPasswordHyperlink.click();
        LOGGER.log(Level.INFO, "Hyperlink: \"forgot your password\" został wciśnięty");
    }

    public String getCurrentPageUrl() {
        LOGGER.log(Level.INFO, "Strona o nazwie: {0} została załadowana", DriverManager.driverSetup().getCurrentUrl());
        return DriverManager.driverSetup().getCurrentUrl();
    }

    public void clickProducerPageHyperlink() {
        producerPageHyperlink.click();
        LOGGER.log(Level.INFO, "Hyperlink: \"producer page\" został wciśnięty");
    }

    public String getInvalidCredentialsAlertText() {
        LOGGER.log(Level.INFO, "Tekst został wyświetlony: {0}", invalidCredentialsAlert.getText());
        return invalidCredentialsAlert.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
        LOGGER.log(Level.INFO, "Przycisk: \"login button\" został wciśnięty");
    }

    public void switchHandledTab(int tab) {
        List<String> browserTabs = new ArrayList<>(DriverManager.driverSetup().getWindowHandles());
        DriverManager.driverSetup().switchTo().window(browserTabs.get(tab));
        LOGGER.log(Level.INFO, "Karta przeglądarki została zmieniona");
    }
}
