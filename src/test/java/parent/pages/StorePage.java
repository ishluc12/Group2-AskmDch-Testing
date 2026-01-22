package parent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{
    public StorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[title='View cart']") private WebElement ViewCartLink;
    @FindBy(id = "woocommerce-product-search-field-0") private WebElement searchElement;
    @FindBy(css = "button[value='Search']") private WebElement searchButton;
    @FindBy(className = "woocommerce-loop-product__title") private WebElement productTitle;

    public void addToCart(String productName){
        By addToCartButton = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(ViewCartLink)).click();

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