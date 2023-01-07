package tests.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/Recruitment.feature",
        glue= {"steps/gherkin_steps"}
)
public class RecruitmentBddTests extends AbstractTestNGCucumberTests {
}