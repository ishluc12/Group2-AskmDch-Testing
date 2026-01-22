package parent.StepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import parent.factory.DriverFactory;
import parent.pages.CategoryPage;
import parent.utils.Configloader;

public class BrowseByCategorySteps {
    private WebDriver driver;
    private CategoryPage categoryPage;
    private int actualProductCount;

    @Given("I am on the Store page")
    public void customerIsOnStorePage() throws IllegalAccessException {
        driver = DriverFactory.getDriver();
        categoryPage = new CategoryPage(driver);
    }

    @When("I view the category sidebar")
    public void userViewsCategorySidebar() {
        Assert.assertTrue(categoryPage.isSidebarDisplayed(),
                "Category sidebar should be displayed");
    }

    @Then("category sidebar should be displayed")
    public void sidebarShouldBeDisplayed() {
        Assert.assertTrue(categoryPage.isSidebarDisplayed(),
                "Sidebar is not displayed on the page");
    }

    @When("I click on Men category")
    public void userClicksMenCategory() {
        categoryPage.clickMenCategory();
    }
    @Then("product list should show only Men products")
    public void productsFilteredToMen() {
        Assert.assertTrue(categoryPage.areProductsFromCategory("Men"),
                "Products should contain Men items");
    }

    @When("I click on Women category")
    public void userClicksWomenCategory() {
        categoryPage.clickWomenCategory();
    }
    @Then("product list should show only Women products")
    public void productsFilteredToWomen() {
        Assert.assertTrue(categoryPage.areProductsFromCategory("Women"),
                "Products should contain Women items");
    }

    @When("I click on Accessories category")
    public void userClicksAccessoriesCategory() {
        categoryPage.clickAccessoriesCategory();
    }

    @Then("product list should show only Accessories products")
    public void productsFilteredToAccessories() {
        Assert.assertTrue(categoryPage.areProductsFromCategory("Accessories"),
                "Products should contain Accessories items");
    }

    @Then("product count should be {int}")
    public void productCountShouldMatch(int expectedCount) {
        actualProductCount = categoryPage.getProductCount();
        Assert.assertEquals(actualProductCount, expectedCount,
                "Product count mismatch. Expected: " + expectedCount + ", Actual: " + actualProductCount);
    }
}
