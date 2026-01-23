package parent.StepsDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import parent.constants.EndPoint;
import parent.factory.DriverFactory;
import parent.pages.StorePage;

import static parent.factory.DriverFactory.driver;

public class SortProductsSteps {
    private WebDriver driver;
    protected StorePage storePage;
    @Given("I am on Store page")
    public void iAmOnStorePage() throws IllegalAccessException {
        driver = DriverFactory.getDriver();
        storePage = new StorePage(driver);
        storePage.load(EndPoint.STORE.url);
    }

    @When("user records initial product order")
    public void userRecordsInitialProductOrder() {

    }

    @Then("products should maintain default order")
    public void productsShouldMaintainDefaultOrder() {

    }

    @When("I click sort dropdown")
    public void iClickSortDropdown() {

    }

    @And("I select <SortOption> option")
    public void iSelectSortOptionOption() {

    }

    @Then("products should be sorted according to <SortOption>")
    public void productsShouldBeSortedAccordingToSortOption() {

    }

    @And("<ValidationMessage> should be verified")
    public void validationmessageShouldBeVerified() {

    }
}
