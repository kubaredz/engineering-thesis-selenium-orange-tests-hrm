package tests;

import helpers.DateGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.MyInfoSteps;

import static org.testng.Assert.assertTrue;

public class MyInfoTests extends TestNgSteps {
    private CommonTests commonTests;
    private MyInfoSteps myInfoSteps;

    @BeforeMethod
    public void myInfoTestsSetup() {
        commonTests = new CommonTests();
        myInfoSteps = new MyInfoSteps();
    }

    @Test
    @Story("PI-39")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-39")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'My info' przekierowuje do strony 'PIM'")
    @Parameters({"login", "password"})
    public void asAdminMyInfoScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        myInfoSteps.clickPanelSection();
        assertTrue(myInfoSteps.isHeaderTextDisplayed());
    }

    @Test
    @Story("PI-39")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-39")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy modyfikacja swoich danych osobowych jest mozliwa")
    @Parameters({"login", "password"})
    public void asAdminModifyPersonalDataOfLoggedUserTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        String firstName = UserDataGenerator.generateFirstName();
        String secondName = UserDataGenerator.generateMiddleName();
        String lastName = UserDataGenerator.generateLastName();
        String username = UserDataGenerator.generateUsername();
        String id = UserDataGenerator.generateId();
        String otherId = UserDataGenerator.generateId();
        String driversLicenseNumber = UserDataGenerator.generateDriversLicenseNumber();
        String licenseExpiryDate = DateGenerator.setFutureDate(30);
        String ssn = UserDataGenerator.generateId();
        String sin = UserDataGenerator.generateId();

        myInfoSteps
                .clickPanelSection()
                .clickPersonalDetailsSection()
                .setFirstName(firstName)
                .setMiddleName(secondName)
                .setLastName(lastName)
                .setNicknameLabel(username)
                .setEmployeeIdLabel(id)
                .setEmployeeOtherIdLabel(otherId)
                .setDriversLicenseNumberLabel(driversLicenseNumber)
                .setLicenseExpiryDateLabel(licenseExpiryDate)
                .setSsnNumberLabel(ssn)
                .setSinNumberLabel(sin)
                .setDateOfBirthLabel("1997-10-21")
                .clickFemaleGenderRadioButton()
                .setMilitaryServiceLabel("yes")
                .clickSmokerCheckBox()
                .clickNationalitySelect()
                .clickNationality()
                .setMaritalStatusList()
                .setMaritalStatusMarriedLabel()
                .clickSaveButton();

        assertTrue(myInfoSteps.isPositiveAlertDisplayed());
    }

    @Test
    @Story("PI-39")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://pracainzynierskapjatk.atlassian.net/browse/PI-39")
    @Description("Jako zalogowany uzytkownik, weryfikacja czy modyfikacja pola w sekcji 'Custom Fields' jest mozliwa")
    @Parameters({"login", "password"})
    public void asLoggedUserIWantToChangeCustomFields(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        myInfoSteps
                .clickPanelSection()
                .clickPersonalDetailsSection()
                .clickBloodTypeSection()
                .clickBloodTypeBPlusLabel()
                .clickSecondSaveButton();

        assertTrue(myInfoSteps.isPositiveAlertDisplayed());
    }
}