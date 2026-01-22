package parent.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks","customType", "context"},
        plugin = {"pretty", "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"},
        monochrome = true
)
public class TestNgRunnerTest extends AbstractTestNGCucumberTests {

}

