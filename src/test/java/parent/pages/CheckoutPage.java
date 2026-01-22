package parent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import parent.domainObject.BillingDetails;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage{
    @FindBy(id="billing_first_name") private WebElement firstnameFiled;
    @FindBy(id="billing_last_name") private WebElement lastnameFiled;
    @FindBy(id="billing_company") private WebElement companyNameFiled;
    @FindBy(id="billing_country") private WebElement countryNameFiled;
    @FindBy(id="billing_address_1") private WebElement streetField;
    @FindBy(id="billing_address_2") private WebElement appartmentField;
    @FindBy(id="billing_city") private WebElement cityField;
    @FindBy(id="billing_state") private WebElement stateField;
    @FindBy(id="billing_postcode") private WebElement zipField;
    @FindBy(id="billing_postcode") private WebElement phoneField;
    @FindBy(id="billing_email") private WebElement emailField;
    @FindBy(id="order_comments") private WebElement textField;
    @FindBy(css = "ul.wc_payment_methods") private WebElement paymentCheck;
    @FindBy(id="place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement confirmationMessage;
    @FindBy(css = ".woocommerce-order-overview__order.order") private WebElement orderNumber;

    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    public CheckoutPage enterBillingFname(String fname){
        WebElement element=firstnameFiled;
        element.sendKeys(fname);
        return this;
    }
    public CheckoutPage enterBillingLname(String lname){
        WebElement element=lastnameFiled;
        element.sendKeys(lname);
        return this;
    }
    public CheckoutPage enterBillingCompany(String company){
        WebElement element=lastnameFiled;
        element.sendKeys(company);
        return this;
    }
    public CheckoutPage selectCountry(String country){
        WebElement element=lastnameFiled;
        element.sendKeys(country);
        return this;
    }
    public CheckoutPage enterBillingStreet(String street){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = streetField;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(street);
        return this;
    }
    public CheckoutPage setAppartment(String appartment){
        WebElement element=appartmentField;
        element.sendKeys(appartment);
        return this;
    }
    public CheckoutPage enterBillingTown(String town){
        WebElement element=cityField;
        element.sendKeys(town);
        return this;
    }
    public CheckoutPage selectState(String state){
        WebElement element=stateField;
        element.sendKeys(state);
        return this;
    }
    public CheckoutPage enterBillingZip(String code){
        WebElement element=zipField;
        element.sendKeys(code);
        return this;
    }
    public CheckoutPage enterBillingPhone(String phone){
        WebElement element=phoneField;
        element.sendKeys(phone);
        return this;
    }
    public CheckoutPage enterBillingEmail(String email){
        WebElement element=emailField;
        element.sendKeys(email);
        return this;
    }
    public CheckoutPage enterBillingText(String text){
        WebElement element=textField;
        element.sendKeys(text);
        return this;
    }
    public CheckoutPage selectPaymentMethod(String paymentMethodText) {

        List<WebElement> methods = paymentCheck.findElements(By.cssSelector("li.wc_payment_method"));

        for (WebElement method : methods) {
            WebElement label = method.findElement(By.tagName("label"));
            if (label.getText().trim().equalsIgnoreCase(paymentMethodText)) {
                label.click();
                break;
            }
        }
        return this;
    }



    public CheckoutPage clickToPlaceOrder(){
        WebElement element=wait.until(ExpectedConditions.visibilityOf((WebElement) placeOrderBtn));
        element.click();
        return this;
    }


    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFname(billingDetails.getFirstname())
                .enterBillingLname(billingDetails.getLastname())
                .enterBillingCompany(billingDetails.getCompany())
                .selectCountry(billingDetails.getCountry())
                .enterBillingStreet(billingDetails.getLastAddressOne())
                .enterBillingTown(billingDetails.getCity())
                .enterBillingZip(billingDetails.getZipCode())
                .enterBillingEmail(billingDetails.getEmail())
                .enterBillingPhone(billingDetails.getPhone())
                .enterBillingText(billingDetails.getAdditionText());
    }

    public String getText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = wait.until(ExpectedConditions.visibilityOf((WebElement)confirmationMessage));
        return message.getText();
    }
    public String getOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = wait.until(ExpectedConditions.visibilityOf((WebElement)orderNumber));
        return message.getText();
    }
}
