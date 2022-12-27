package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformancePanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/performance/viewPerformanceModule']")
    public WebElement performanceSection;
}
