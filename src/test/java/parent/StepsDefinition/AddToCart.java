package parent.StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import parent.constants.EndPoint;
import parent.domainObject.Product;
import parent.factory.DriverFactory;
import parent.pages.CartPage;
import parent.pages.StorePage;


public class AddToCart {
    protected WebDriver driver;
    protected StorePage storePage;
    protected CartPage cartPage;

    @Given("I am on the store page")
    public void iAmOnTheStorePage() throws IllegalAccessException {
    driver = DriverFactory.getDriver();
    storePage = new StorePage(driver);
    storePage.load(EndPoint.STORE.url);

    }
    @When("I add a {product} to the cart")
    public void iAddABlueShoesToTheCart(Product product) {
        storePage.addToCart(product.getProductName());
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeBlueShoesInTheCart(int quantity,Product product) {
        cartPage = new CartPage(driver);
        String names = cartPage.getProductNames();
        Assert.assertEquals(product.getProductName(),names);
        Assert.assertEquals(quantity,cartPage.getProductQuantity());

    }
}
