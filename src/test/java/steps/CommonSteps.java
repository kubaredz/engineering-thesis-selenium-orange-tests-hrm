package steps;

import builders.CommonBuilder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.DriverPicker;

import java.util.logging.Level;

public class CommonSteps extends CommonBuilder {

    public CommonSteps() {
        PageFactory.initElements(DriverPicker.driverSetup(), this);
    }

    @Step("Utworzenie selektora dla sekcji {header}")
    public CommonSteps generateAndClickSelectorForAllSections(String header) {
        String cssSelector = "a[href='/web/index.php/" + header.toLowerCase() + "/view" + header + "Module']";
        WebElement generatedSection = DriverPicker.driverSetup().findElement(By.cssSelector(cssSelector));
        generatedSection.click();
        logger.log(Level.INFO, "Utworzenie selektora dla sekcji: {0}", header);
        return new CommonSteps();
    }

    @Step("Strona z adresem: {url} zostala zaladowana")
    public String getSectionUrlAddress() {
        String sectionUrlAddress = DriverPicker.driverSetup().getCurrentUrl();
        logger.log(Level.INFO, "Strona z adresem: {0} zostala zaladowana");
        return sectionUrlAddress;
    }
}
