package parent.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"parent"},
        snippets = CAMELCASE,
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"},
        tags= "@browseByCategory"
)

public class TestNgRunnerTest extends AbstractTestNGCucumberTests {

}

