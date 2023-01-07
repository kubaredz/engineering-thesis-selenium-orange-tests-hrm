package steps.login_page;

import builders.login_page.LoginPageBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.logging.Level;

import static setup.DriverPicker.driverSetup;
import static utils.RepeatedActions.deletingAndAddingContentToLabel;

public class LoginPageSteps extends LoginPageBuilder {

    public LoginPageSteps() {
        PageFactory.initElements(driverSetup(), this);
    }

    @Step("Adres strony zostaje zaciagniety")
    public String getPageTitle() {
        String pageTitle = driverSetup().getTitle();
        logger.log(Level.INFO, "Nazwa strony zostala zaciagnieta: {0} ", pageTitle);
        return pageTitle;
    }

    @Step("Pobranie zawartosci pola username")
    public String getUserNameField() {
        String userNameField = usernameField.getAttribute("value");
        logger.log(Level.INFO, "Atrybut \"user\" zostal zaciagniety: {0}", userNameField);
        return userNameField;
    }

    @Step("Wprowadzony login uzytkownika to: {username}")
    public LoginPageSteps setUserNameField(String username) {
        deletingAndAddingContentToLabel(usernameField, username);
        logger.log(Level.INFO, "Wprowadzam login uzytkownika: {0}", username);
        return new LoginPageSteps();
    }

    @Step("Wprowadzony login uzytkownika to: {password}")
    public LoginPageSteps setPasswordField(String password) {
        deletingAndAddingContentToLabel(passwordField, password);
        logger.log(Level.INFO, "Wprowadzam haslo uzytkownika: {0}", password);
        return new LoginPageSteps();
    }

    @Step("Pobranie zawartosci pola password")
    public String getPasswordField() {
        String password = passwordField.getAttribute("value");
        logger.log(Level.INFO, "Atrybut \"password\" zostal zaciagniety: {0}", password);
        return password;
    }

    @Step("Baner strony Orange HRM zostal wyswietlony")
    public boolean isHrmBannerDisplayed() {
        logger.log(Level.INFO, "Baner: strony OrangeHRM zostal wyswietlony");
        return hrmBanner.isDisplayed();
    }

    @Step("Logo strony Orange HRM zostalo wyswietlone")
    public boolean isHrmLogoDisplayed() {
        logger.log(Level.INFO, "Logo: strony OrangeHRM zostalo wyswietlone");
        return hrmLogo.isDisplayed();
    }

    @Step("Hyperlink: 'Forgot your password'")
    public String getHyperlinkForgotYourPassword() {
        String hyperlinkText = forgotYourPasswordHyperlink.getText();
        logger.log(Level.INFO, "Hyperlink: \"{0}\" zostal wyswietlony", hyperlinkText);
        return hyperlinkText;
    }

    @Step("Przycisk: 'Forgot your password' zostal wcisniety")
    public LoginPageSteps clickForgotYourPasswordHyperlink() {
        forgotYourPasswordHyperlink.click();
        logger.log(Level.INFO, "Hyperlink: \"forgot your password\" zostal wcisniety");
        return new LoginPageSteps();
    }

    @Step("Zaciagniecie aktualnego adresu strony")
    public String getCurrentPageUrl() {
        String currentPageUrl = driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Strona o nazwie: {0} zostala zaladowana", currentPageUrl);
        return currentPageUrl;
    }

    @Step("Hyperlink: 'Producer page' zostal wcisniety")
    public LoginPageSteps clickProducerPageHyperlink() {
        producerPageHyperlink.click();
        logger.log(Level.INFO, "Hyperlink: \"producer page\" zostal wcisniety");
        return new LoginPageSteps();
    }

    @Step("Alert: 'Invalid Credentials' zostal wyswietlony")
    public String getInvalidCredentialsAlertText() {
        String invalidCredentials = invalidCredentialsAlert.getText();
        logger.log(Level.INFO, "Tekst zostal wyswietlony: {0}", invalidCredentials);
        return invalidCredentials;
    }

    @Step("Przycisk: 'Login' zostal wcisniety")
    public LoginPageSteps clickLoginButton() {
        loginButton.click();
        logger.log(Level.INFO, "Przycisk: \"login button\" zostal wcisniety");
        return new LoginPageSteps();
    }

    @Step("Nowa karta przegladarki o numerze: {tab} zostala otwarta")
    public LoginPageSteps switchHandledTab(int tab) {
        List<String> browserTabs = new ArrayList<>(driverSetup().getWindowHandles());
        driverSetup().switchTo().window(browserTabs.get(tab));
        logger.log(Level.INFO, "Karta przegladarki zostala zmieniona");
        return new LoginPageSteps();
    }
}