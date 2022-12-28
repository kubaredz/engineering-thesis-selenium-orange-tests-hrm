package steps.login_page;

import builders.login_page.LoginPageBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import setup.DriverManager;
import utils.RepeatedActions;

import java.util.*;
import java.util.logging.Level;

public class LoginPageSteps extends LoginPageBuilder {

    public LoginPageSteps() {
        PageFactory.initElements(DriverManager.driverSetup(), this);
    }

    @Step("Adres strony zostaje zaciagniety")
    public String getPageTitle() {
        String pageTitle = DriverManager.driverSetup().getTitle();
        logger.log(Level.INFO, "Nazwa strony została zaciągnięta: {0} ", pageTitle);
        return pageTitle;
    }

    @Step("Pobranie zawartosci pola username")
    public String getUserNameField() {
        String userNameField = usernameField.getAttribute("value");
        logger.log(Level.INFO, "Atrybut \"user\" został zaciągnięty: {0}", userNameField);
        return userNameField;
    }

    @Step("Wprowadzony login uzytkownika to: {name}")
    public LoginPageSteps setUserNameField(String name) {
        RepeatedActions.deletingAndAddingContentToLabel(usernameField, name);
        logger.log(Level.INFO, "Wprowadzam login użytkownika: {0}", name);
        return new LoginPageSteps();
    }

    @Step("Pobranie zawartosci pola password")
    public String getPasswordField() {
        String password = passwordField.getAttribute("value");
        logger.log(Level.INFO, "Atrybut \"password\" został zaciągnięty: {0}", password);
        return password;
    }

    @Step("Wprowadzony login uzytkownika to: {password}")
    public LoginPageSteps setPasswordField(String password) {
        RepeatedActions.deletingAndAddingContentToLabel(passwordField, password);
        logger.log(Level.INFO, "Wprowadzam hasło użytkownika: {0}", password);
        return new LoginPageSteps();
    }

    @Step("Baner strony Orange HRM zostal wyswietlony")
    public boolean isHrmBannerDisplayed() {
        logger.log(Level.INFO, "Baner: strony OrangeHRM został wyświetlony");
        return hrmBanner.isDisplayed();
    }

    @Step("Logo strony Orange HRM zostalo wyswietlone")
    public boolean isHrmLogoDisplayed() {
        logger.log(Level.INFO, "Logo: strony OrangeHRM zostało wyświetlone");
        return hrmLogo.isDisplayed();
    }

    @Step("Hyperlink: 'Forgot your password'")
    public String getHyperlinkForgotYourPassword() {
        String hyperlinkText = forgotYourPasswordHyperlink.getText();
        logger.log(Level.INFO, "Hyperlink: \"{0}\" został wyświetlony", hyperlinkText);
        return hyperlinkText;
    }

    @Step("Przycisk: 'Forgot your password' zostal wcisniety")
    public void clickForgotYourPasswordHyperlink() {
        forgotYourPasswordHyperlink.click();
        logger.log(Level.INFO, "Hyperlink: \"forgot your password\" został wciśnięty");
    }

    @Step("Zaciagniecie aktualnego adresu strony")
    public String getCurrentPageUrl() {
        String currentPageUrl = DriverManager.driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Strona o nazwie: {0} została załadowana", currentPageUrl);
        return currentPageUrl;
    }

    @Step("Hyperlink: 'Producer page' zostal wcisniety")
    public LoginPageSteps clickProducerPageHyperlink() {
        producerPageHyperlink.click();
        logger.log(Level.INFO, "Hyperlink: \"producer page\" został wciśnięty");
        return new LoginPageSteps();
    }

    @Step("Alert: 'Invalid Credentials' zostal wyswietlony")
    public String getInvalidCredentialsAlertText() {
        String invalidCredentials = invalidCredentialsAlert.getText();
        logger.log(Level.INFO, "Tekst został wyświetlony: {0}", invalidCredentials);
        return invalidCredentials;
    }

    @Step("Przycisk: 'Login' zostal wcisniety")
    public LoginPageSteps clickLoginButton() {
        loginButton.click();
        logger.log(Level.INFO, "Przycisk: \"login button\" został wciśnięty");
        return new LoginPageSteps();
    }

    @Step("Nowa karta przegladarki o numerze: {tab} zostala otwarta")
    public LoginPageSteps switchHandledTab(int tab) {
        List<String> browserTabs = new ArrayList<>(DriverManager.driverSetup().getWindowHandles());
        DriverManager.driverSetup().switchTo().window(browserTabs.get(tab));
        logger.log(Level.INFO, "Karta przeglądarki została zmieniona");
        return new LoginPageSteps();
    }
}
