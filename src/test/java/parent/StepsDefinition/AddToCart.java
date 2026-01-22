package parent.StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import parent.constants.EndPoint;
import parent.domainObject.Product;
import parent.factory.DriverFactory;
import parent.pages.StorePage;
import parent.utils.Configloader;

public class AddToCart {
    private WebDriver driver;

    @Given("I am on the store page")
    public void iAmOnTheStorePage() throws IllegalAccessException {
    driver = DriverFactory.getDriver();
        StorePage storePage = new StorePage(driver);
        storePage.load(EndPoint.STORE.url);

    }
    @When("I add a {product} to the cart")
    public void iAddABlueShoesToTheCart(Product product) {


    }
    @Then("I should see {int} \"\"Blue Shoes\"\" in the cart")
    public void iShouldSeeBlueShoesInTheCart(Integer int1) {

    }
}
