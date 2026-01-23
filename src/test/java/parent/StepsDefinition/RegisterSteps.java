package parent.StepsDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import parent.factory.DriverFactory;
import parent.hooks.Hooks;
import parent.pages.AccountPage;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class RegisterSteps {
    private WebDriver driver;
    protected AccountPage accountPage;


    @When("I register with valid data")
    public void iRegisterWithValidData(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        LoginSteps.accountPage.settingAllRegFields(
                data.get("username"),
                data.get("email address"),
                data.get("password")
        );
    }

    @Then("the account is registered and I get welcome message with name {string}")
    public void theAccountIsRegisteredAndIGetWelcomeMessageWithName(String expectedUsername) {
        String actualMessage = LoginSteps.accountPage.isWelcomeMessage();
        Assert.assertEquals(actualMessage,expectedUsername);
    }

    @When("I register with invalid {string},{string} and {string}")
    public void iRegisterWithInvalidAnd(String username, String email, String password) {
        LoginSteps.accountPage.settingAllRegFields(username, email, password);
    }

    @When("clicks the register button")
    public void clicksTheRegisterButton() {
        LoginSteps.accountPage.clickRegisterButton();
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String expectedMessage) {
        String actualMessage = LoginSteps.accountPage.isErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}