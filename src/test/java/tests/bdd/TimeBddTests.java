package tests.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Time.feature",
        glue= {"steps/gherkin_steps"}
)
public class TimeBddTests extends AbstractTestNGCucumberTests {

}