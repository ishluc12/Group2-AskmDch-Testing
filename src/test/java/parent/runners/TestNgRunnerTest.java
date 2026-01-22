package parent.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;


@CucumberOptions(
        features = "src/test/resources/Features/BrowseByCategory.feature",
        glue = {"parent"},
        plugin = {"pretty", "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"},
        monochrome = true,
        snippets=CAMELCASE
)
public class TestNgRunnerTest extends AbstractTestNGCucumberTests {

}

