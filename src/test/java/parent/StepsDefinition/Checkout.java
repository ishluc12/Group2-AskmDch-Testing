package parent.StepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import parent.domainObject.BillingDetails;
import parent.factory.DriverFactory;
import parent.pages.CartPage;
import parent.pages.CheckoutPage;
import parent.pages.StorePage;

import java.util.Map;

public class Checkout {
    private WebDriver driver;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @And("I add {string} to my cart")
    public void iAddProductToCart(String productName) {
        driver = DriverFactory.getDriver();
        StorePage storePage = new StorePage(driver);
        storePage.addToCart(productName);

        // Initialize CartPage after adding a product
        cartPage = new CartPage(driver);
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {

        cartPage.clickCheckoutButton();
        checkoutPage = new CheckoutPage(driver);
    }

    @And("I provide my billing information:")
    public void iProvideBillingInformation(io.cucumber.datatable.DataTable table) {
        driver = DriverFactory.getDriver();
        checkoutPage = new CheckoutPage(driver);

        Map<String, String> data = table.asMap(String.class, String.class);

        BillingDetails billing = new BillingDetails(
                data.get("First name"),
                data.get("Last name"),
                data.get("Company name"),
                data.get("Country/Region"),
                data.get("Street address"),
                data.get("City"),
                data.get("State"),
                data.get("ZIP code"),
                data.get("Email address"),
                data.get("Phone"),
                "Automation order"
        );

        checkoutPage.setBillingDetails(billing);
    }

    @And("I select the payment method")
    public void iSelectThePaymentMethod() {
        checkoutPage.selectPaymentMethod("Cash on delivery");
    }

    @And("I place the order")
    public void iPlaceTheOrder() {
        checkoutPage.placeOrder();
    }

    @Then("I should see a confirmation message")
    public void confirmationMessageIsDisplayed() {
        Assert.assertTrue(
                checkoutPage.getConfirmationMessage().contains("Thank you"),
                "Order confirmation message not displayed"
        );
    }

    @And("an order number should be generated")
    public void orderNumberShouldBeGenerated() {
        Assert.assertFalse(
                checkoutPage.getOrderNumber().isEmpty(),
                "Order number was not generated"
        );
    }
}
