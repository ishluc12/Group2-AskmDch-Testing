package parent.StepsDefinition;

import parent.constants.EndPoint;
import parent.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import parent.pages.LoginPage;


import static org.testng.Assert.assertTrue;

public class Login {

    private WebDriver driver;


    @Given("I am in the login form of the Askmdch Application")
    public void i_am_in_the_login_form_of_the_askmdch_application()  throws IllegalAccessException {
        driver=DriverFactory.getDriver();
        new LoginPage(driver).load(EndPoint.ACCOUNT.url);
    }


    @When("I enter valid {string}")
    public void i_enter_valid(String string) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.username("chris");
    }

    @When("I enter valid password {string}")
    public void i_enter_valid_password(String string) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.password("chris123");
    }

    @When("I click login button")
    public void i_click_login_button() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login();
    }

    @Then("I should be taken to the dashboard")
    public void i_should_be_taken_to_the_dashboard() {
        String text = new LoginPage(driver).getText();
        System.out.println(text);
        assertTrue(text.contains("Hello"));
        assertTrue(text.contains("Log out"));

    }

}
