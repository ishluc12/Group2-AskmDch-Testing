package parent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class StorePage extends BasePage{
    public StorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[title='View cart']")
    private WebElement ViewCartLink;
    @FindBy(css = "#product_cat option[value='men']")
    private WebElement menCategory;
    @FindBy(css = "#product_cat option[value='women']")
    private WebElement womenCategory;
    @FindBy(css = "#product_cat option[value='accessories']")
    private WebElement accessoriesCategory;
    @FindBy(css = "ul.products li.product")
    private List<WebElement> productCards;

    public void addToCart(String productName){
        By addToCartButton = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartLink)).click();

    }
    public void clickMenCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(menCategory));
        menCategory.click();
        waitForPageLoad();
    }
    public void clickWomenCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(womenCategory));
        womenCategory.click();
        waitForPageLoad();
    }
    public void clickAccessoriesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(accessoriesCategory));
        accessoriesCategory.click();
        waitForPageLoad();
    }
    public List<String> getProductNames() {
        List<String> names = new java.util.ArrayList<>();
        productCards.forEach(card -> {
            String name = card.getText();
            if (!name.isEmpty()) {
                names.add(name);
            }
        });
        return names;
    }
    public boolean areProductsFromCategory(String category) {
        List<String> names = getProductNames();
        if (names.isEmpty()) {
            return false;
        }
        return names.stream().anyMatch(name -> name.toLowerCase().contains(category.toLowerCase()));
    }
    private void waitForPageLoad() {
        wait.until(driver -> Objects.equals(((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return document.readyState"), "complete"));
    }
}
