package parent.StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import parent.constants.EndPoint;
import parent.factory.DriverFactory;
import parent.pages.StorePage;

public class BrowseByCategorySteps {
    private WebDriver driver;
    protected CategoryPage categoryPage;
    protected StorePage storePage;

    @Given("I am on the Store page")
    public void customerIsOnStorePage() throws IllegalAccessException {
        driver = DriverFactory.getDriver();
        storePage = new StorePage(driver);
        storePage.load(EndPoint.STORE.url);
    }

    @When("I click on Men category")
    public void userClicksMenCategory() {
       storePage.clickMenCategory();
    }

    @Then("product list should show only Men products")
    public void productsFilteredToMen() {
        Assert.assertTrue(storePage.areProductsFromCategory("Men"),
                "Products should contain Men items");
    }

    @When("I click on Women category")
    public void userClicksWomenCategory() {
        storePage.clickWomenCategory();
    }

    @Then("product list should show only Women products")
    public void productsFilteredToWomen() {
        Assert.assertTrue(storePage.areProductsFromCategory("Women"),
                "Products should contain Women items");
    }

    @When("I click on Accessories category")
    public void userClicksAccessoriesCategory() {
        storePage.clickAccessoriesCategory();
    }

    @Then("product list should show only Accessories products")
    public void productsFilteredToAccessories() {
        Assert.assertTrue(storePage.areProductsFromCategory("Accessories"),
                "Products should contain Accessories items");
    }
}
