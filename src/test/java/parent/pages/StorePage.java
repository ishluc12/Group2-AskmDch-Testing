package parent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.List;
import java.util.Objects;

public class StorePage extends BasePage{
    public StorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#product_cat option[value='men']")
    private WebElement menCategory;
    @FindBy(css = "#product_cat option[value='women']")
    private WebElement womenCategory;
    @FindBy(css = "#product_cat option[value='accessories']")
    private WebElement accessoriesCategory;
    @FindBy(css = "ul.products li.product")
    private List<WebElement> productCards;

    private int initialCartCount;

    @FindBy(css = "a[title='View cart']") private WebElement ViewCartLink;
    @FindBy(css = ".woocommerce-message") private WebElement successMessage;
    @FindBy(css = ".ast-cart-menu-wrap") private WebElement cartIconQuantity;
    @FindBy( css= "input[type='number']") private WebElement quantityInput;
    @FindBy( css = "button[name ='update_cart']") private WebElement updateCartButton;
    @FindBy( className = "woocommerce-message") private WebElement updateCartMessage;
    @FindBy(id = "woocommerce-product-search-field-0") private WebElement searchElement;
    @FindBy(css = "button[value='Search']") private WebElement searchButton;
    @FindBy(className = "woocommerce-loop-product__title") private WebElement productTitle;


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

    public void removeFromCart(){
        By removeButton = By.cssSelector(".remove");
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }

    public void storeInitialCartCount() {
        WebElement cartCount = wait.until(ExpectedConditions.visibilityOf(cartIconQuantity));
        initialCartCount = Integer.parseInt(cartCount.getText());
    }

    public boolean isCartIconQuantityDecreased() {
        WebElement cartCount = wait.until(ExpectedConditions.visibilityOf(cartIconQuantity));
        int currentCount = Integer.parseInt(cartCount.getText());
        return currentCount < initialCartCount;
    }

    public void updateProductQuantityAndSubmit(int quantity) {
        updateProductQuantity(quantity);
        clickUpdateCartButton();
    }

    public void updateProductQuantity(int quantity) {
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOf(quantityInput));
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
    }

    public void clickUpdateCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateCartButton)).click();
    }
    public String getUpdateCartMessage() {
        wait.until(ExpectedConditions.visibilityOf(updateCartMessage));
        return updateCartMessage.getText();
    }

    public void enterProductName(){
        searchElement.sendKeys("Blue Shoes");
    }
    public void searchButton(){
        searchButton.click();
    }

    public String getProductTitle(){
        return productTitle.getText();
    }

}