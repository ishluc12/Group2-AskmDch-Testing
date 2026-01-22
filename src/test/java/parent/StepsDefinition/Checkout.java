package parent.StepsDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import parent.constants.EndPoint;
import parent.domainObject.BillingDetails;
import parent.factory.DriverFactory;
import parent.pages.CheckoutPage;

import java.util.Map;

public class Checkout {

    private WebDriver driver = DriverFactory.getDriver();
    private CheckoutPage checkoutPage;

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }

    @When("I enter valid billing details:")
    public void i_enter_valid_billing_details(DataTable dataTable) {
        Map<String, String> entry = dataTable.asMap(String.class, String.class);

        BillingDetails billingDetails = new BillingDetails(
                entry.get("First name"),
                entry.get("Last name"),
                entry.get("Company name"),
                entry.get("Country/Region"),
                entry.get("Street address"),
                entry.get("City"),
                entry.get("State"),
                entry.get("ZIP code"),
                entry.get("Email address"),
                entry.get("Phone"),
                entry.getOrDefault("Apartment/unit", "") // optional
        );

        checkoutPage.setBillingDetails(billingDetails)
                .setAppartment(entry.getOrDefault("Apartment/unit", ""));
    }

    @When("I select {string} as the payment method")
    public void i_select_as_the_payment_method(String paymentMethod) {
        checkoutPage.selectPaymentMethod(paymentMethod);
    }

    @When("I click the Place Order button")
    public void i_click_the_place_order_button() {
        checkoutPage.clickToPlaceOrder();
    }

    @Then("a confirmation message {string} is displayed")
    public void a_confirmation_message_is_displayed(String expectedMessage) {
        String actualMessage = checkoutPage.getText();
        if (!actualMessage.contains(expectedMessage)) {
            throw new AssertionError(
                    "Expected message: " + expectedMessage + " but got: " + actualMessage
            );
        }
    }

    @Then("I can see the order number")
    public void i_can_see_the_order_number() {
        String orderNumber = checkoutPage.getOrder();
        System.out.println("Order number: " + orderNumber);
    }
}
