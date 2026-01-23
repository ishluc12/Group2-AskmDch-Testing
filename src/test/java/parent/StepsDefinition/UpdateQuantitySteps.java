package parent.StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import parent.constants.EndPoint;
import parent.factory.DriverFactory;
import parent.pages.StorePage;

import static org.testng.Assert.assertEquals;

public class UpdateQuantitySteps {
    private WebDriver driver;
    private StorePage storePage;

    @Given("I have at least one product in the cart")
    public void iHaveAtLeastOneProductInTheCart() throws IllegalAccessException {
        driver = DriverFactory.getDriver();
        storePage = new StorePage(driver);
        storePage.load(EndPoint.STORE.url);
        storePage.addToCart("Blue Shoes");
    }
    @When("I update the quantity of the product")
    public void iUpdateTheQuantityOfTheProduct() {
        storePage.updateProductQuantity(3);
    }
    @When("I click Update Cart button")
    public void iClickUpdateCartButton() {
        storePage.clickUpdateCartButton();

    }
    @Then("the cart should reflect the updated quantity of product")
    public void theCartShouldReflectTheUpdatedQuantityOfProduct() {
        String actualMessage = storePage.getUpdateCartMessage();
        assertEquals(actualMessage, "Cart updated.", "Update cart message did not match!");
    }
}
