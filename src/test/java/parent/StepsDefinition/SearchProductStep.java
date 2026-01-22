package parent.StepsDefinition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import parent.factory.DriverFactory;
import parent.pages.StorePage;

public class SearchProductStep {
    protected WebDriver driver;
    private StorePage storePage;

    @When("I enter product name into the search bar")
    public void iEnterIntoTheSearchBar() {
        driver = DriverFactory.getDriver();
        storePage = new StorePage(driver);
        storePage.enterProductName();
        storePage.searchButton();

    }
    @Then("I should see results showing product with its names")
    public void iShouldSeeResultsShowing() {
        String actualProductName = storePage.getProductTitle();
        Assert.assertEquals(actualProductName,"Red Shoes",
                "Product name doesn't exist");


    }
}
