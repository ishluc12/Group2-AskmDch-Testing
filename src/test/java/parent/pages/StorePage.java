package parent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage extends BasePage{
    public StorePage(WebDriver driver) {
        super(driver);
    }
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