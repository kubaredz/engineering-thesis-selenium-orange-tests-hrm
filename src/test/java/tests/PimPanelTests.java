package tests;

import helpers.UserDataGenerator;
import helpers.PasswordGenerator;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.login_page.LoginPageSteps;
import steps.options.PimPanelSteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PimPanelTests extends TestBase {
    private LoginPageSteps loginPageSteps;
    private PimPanelSteps pimPanelSteps;
    private LoginPageTests loginPageTests;

    @BeforeMethod
    public void pimPanelTestsSetup() {
        loginPageSteps = new LoginPageSteps();
        pimPanelSteps = new PimPanelSteps();
        loginPageTests = new LoginPageTests();
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'PIM' przekierowuje do strony 'PIM' z lista pracownikow")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-41")
    @Story("PI-41")
    public void asUserICanGoToPimSectionTest() {
        loginPageSteps
                .setUserNameField("Admin")
                .setPasswordField("admin123")
                .clickLoginButton();

        pimPanelSteps.clickPanelSection();

        assertTrue(pimPanelSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy sekcja 'Dodawania nowego uzykownika' jest widoczna")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-41")
    @Story("PI-41")
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
    @Description("Jako zalogowany uzytkownik, weryfikacja dodania nowego pracownika do systemu 'PIM'")
    @Severity(SeverityLevel.CRITICAL)
    @Story("PI-41")
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-41")
    public void addNewUserInOrangeHrmApplicationTest() {
        loginPageTests.asAdministratorTryToLoginWithCorrectLoginAndPasswordTest();
        String password = PasswordGenerator.generatePassword(15);

        pimPanelSteps
                .clickPanelSection()
                .clickAddButton()
                .setUploadImageButton("C:\\Users\\kubar\\avatar.jpg")
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
