package tests;

import helpers.UserDataGenerator;
import helpers.PasswordGenerator;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.PageSetup;
import steps.login_page.LoginPageSteps;
import steps.options.PimPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PimPanelTests extends TestNgSteps {
    private LoginPageSteps loginPageSteps;
    private PimPanelSteps pimPanelSteps;
    private LoginPageTests loginPageTests;
    private PageSetup pageSetup;

    @BeforeMethod
    public void pimPanelTestsSetup() {
        loginPageSteps = new LoginPageSteps();
        pimPanelSteps = new PimPanelSteps();
        loginPageTests = new LoginPageTests();
    }

    @Test
    @Story("PI-41")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-41")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'PIM' przekierowuje do strony z lista pracownikow")
    public void pimPanelRedirectsToEmployeeListTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        pimPanelSteps.clickPanelSection();

        assertTrue(pimPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Story("PI-41")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-41")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy sekcja 'Dodawania nowego uzykownika' jest widoczna")
    public void asUserICanGoToAddNewUserSectionAndItIsPresentTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        pimPanelSteps
                .clickPanelSection()
                .clickAddButton();

        assertTrue(pimPanelSteps.isAddEmployeeTextDisplayed());
        assertEquals(pimPanelSteps.getAddEmployeeText(), "Add Employee");
    }

    @Test
    @Story("PI-41")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-41")
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego pracownika do systemu 'PIM'")
    public void addNewUserInOrangeHrmApplicationTest() {
        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();
        String password = PasswordGenerator.generatePassword(15);

        pimPanelSteps
                .clickPanelSection()
                .clickAddButton()
                .setUploadImageButton(pageSetup.getAvatarPath())
                .setFirstNameLabel(UserDataGenerator.generateFirstName())
                .setMiddleNameLabel(UserDataGenerator.generateMiddleName())
                .setLastNameLabel(UserDataGenerator.generateLastName())
                .clickLoginDetailsCheckBox()
                .setUsernameLabel(UserDataGenerator.generateUsername())
                .clickStatusEnabledRadioButton()
                .setPasswordLabel(password)
                .setConfirmPasswordLabel(password)
                .clickSaveButton();

        assertTrue(pimPanelSteps.isSuccessPopupDisplayed());
    }
}