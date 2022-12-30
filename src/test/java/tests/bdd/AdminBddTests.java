package tests.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Admin.feature",
        glue= {"steps/gherkin_steps"}
)
public class AdminBddTests extends AbstractTestNGCucumberTests {

}