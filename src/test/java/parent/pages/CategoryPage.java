package parent.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText= "Store")
    private  WebElement storeTab;
    @FindBy(css = ".sidebar-categories, aside.categories, .product-filters")
    private WebElement sidebar;

    @FindBy(css = "a[href*='category'], li.category-item, .category-link")
    private List<WebElement> categoryItems;

    @FindBy(css = ".product-container, .products-grid, .products-list")
    private WebElement productContainer;

    @FindBy(css = "div.product-item, .product-card, article.product")
    private List<WebElement> productCards;

    @FindBy(xpath = "//a[contains(text(), 'Men')] | //li[contains(text(), 'Men')]")
    private WebElement menCategory;

    @FindBy(xpath = "//a[contains(text(), 'Women')] | //li[contains(text(), 'Women')]")
    private WebElement womenCategory;

    @FindBy(xpath = "//a[contains(text(), 'Accessories')] | //li[contains(text(), 'Accessories')]")
    private WebElement accessoriesCategory;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        PageFactory.initElements(driver, this);
    }
    /*public void clickStorePage(){
        driver.findElement(By.linkText( "Store")).click();

    }
     */
    public boolean isSidebarDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(sidebar));
            return sidebar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
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
    public int getProductCount() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productContainer));
            return productCards.size();
        } catch (Exception e) {
            return 0;
        }
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

