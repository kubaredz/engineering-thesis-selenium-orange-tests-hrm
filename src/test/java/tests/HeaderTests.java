package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import steps.dashboard.HeaderSteps;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class HeaderTests extends TestBase {

    @Test
    public void verifyThatUserDropDownListHasAllNecessaryFields() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.getDropDownButton().click();

        List<WebElement> listOfLinksElements = headerSteps.getDropdownMenu().findElements(By.tagName("li"));
        List<String> listOfElementsInUserDropDownList = new ArrayList<>();
        for (int i = 0; i < listOfLinksElements.size(); i++) {
            listOfElementsInUserDropDownList.add(listOfLinksElements.get(i).getText());
        }
        List<String> listOfExpectedOptions = new ArrayList<>();
        listOfExpectedOptions.add("About");
        listOfExpectedOptions.add("Support");
        listOfExpectedOptions.add("Change Password");
        listOfExpectedOptions.add("Logout");

        assertEquals(listOfExpectedOptions, listOfElementsInUserDropDownList);
    }

    @Test
    public void verifyThatAboutOptionHasAllNecessaryInformation() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.getDropDownButton().click();

        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("About")) {
                option.click();
                assertEquals(headerSteps.getAboutSection().getText(), "About");
            }
        }
    }

    @Test
    public void verifyThatSupportOptionTransferToSupportPage() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.getDropDownButton().click();
        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Support")) {
                //TODO
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/help/support");
            }
        }
    }

    @Test
    public void verifyThatChangePasswordOptionRedirectToChangePasswordPage() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.getDropDownButton().click();
        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Change Password")) {
                //TODO
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/updatePassword");
            }
        }
    }

    @Test
    public void verifyThatLogoutOptionLogsOutUser() {
        LoginPageTests loginPageTests = new LoginPageTests();
        loginPageTests.asUserTryToLoginWithCorrectLoginAndPassword();

        HeaderSteps headerSteps = new HeaderSteps();
        headerSteps.getDropDownButton().click();
        List<WebElement> options = headerSteps.getUserDropdown().findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.getText().equals("Change Password")) {
                //TODO
                option.click();
                assertEquals(headerSteps.getPageUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            }
        }
    }
}