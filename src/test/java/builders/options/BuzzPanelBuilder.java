package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuzzPanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/buzz/viewBuzz']")
    public WebElement buzzPanelSection;

    @FindBy(css = "h4[class='oxd-text oxd-text--h4 orangehrm-module-under-development-heading']")
    public WebElement launchingSoonText;


}
