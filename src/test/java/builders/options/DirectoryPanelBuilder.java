package builders.options;

import builders.CommonBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPanelBuilder extends CommonBuilder {

    @FindBy(css = "a[href='/web/index.php/directory/viewDirectory']")
    public WebElement directorySection;
}