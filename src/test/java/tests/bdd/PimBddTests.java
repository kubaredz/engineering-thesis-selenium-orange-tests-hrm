package tests.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/Pim.feature",
        glue= {"steps/gherkin_steps"}
)
public class PimBddTests extends AbstractTestNGCucumberTests {
}
