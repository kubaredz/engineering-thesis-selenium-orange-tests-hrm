package tests;

import helpers.DateGenerator;
import helpers.UserDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.options.MyInfoSteps;

import static org.testng.Assert.assertTrue;

public class MyInfoTests extends TestBase {
    private CommonTests commonTests;
    private MyInfoSteps myInfoSteps;

    @BeforeMethod
    public void myInfoTestsSetup() {
        commonTests = new CommonTests();
        myInfoSteps = new MyInfoSteps();
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy panel 'My info' przekierowuje do strony 'PIM'")
    @Severity(SeverityLevel.NORMAL)
    @Story("PI-39")
    @Parameters({"login", "password"})
    public void asAdminMyInfoScreenIsPresentTest(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        myInfoSteps.clickPimPanelSection();

        assertTrue(myInfoSteps.isHeaderTextDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy moge zmodyfikowac swoje dane osobowe")
    @Severity(SeverityLevel.NORMAL)
    @Story("PI-39")
    @Parameters({"login", "password"})
    public void asAdminModifyDataOfLoggedUserTest(@Optional("Admin") String login, @Optional("admin123") String password) {
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
                .clickPimPanelSection()
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
                .isSmokerCheckBox()
                .clickNationalitySelect()
                .clickNationality()
                .setMaritalStatusList()
                .setMaritalStatusMarriedLabel()
                .clickSaveButton();

        assertTrue(myInfoSteps.isPositiveAlertDisplayed());
    }

    @Test
    @Description("Jako zalogowany uzytkownik, weryfikacja czy moge zmodyfikowac pola w sekcji 'Custom Fields'")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("PI-39")
    @Parameters({"login", "password"})
    public void asLoggedUserIWantToChangeCustomFields(@Optional("Admin") String login, @Optional("admin123") String password) {
        commonTests.loginAsAdministratorToOrangeHrmAppTest(login, password);

        myInfoSteps
                .clickPimPanelSection()
                .clickPersonalDetailsSection()
                .clickBloodTypeSection()
                .clickBloodTypeBPlusLabel()
                .clickSecondSaveButton();

        assertTrue(myInfoSteps.isPositiveAlertDisplayed());
    }
}
