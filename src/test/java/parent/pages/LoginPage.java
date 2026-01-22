package parent.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    @FindBy(id= "username") private WebElement usernameField;
    @FindBy(id= "password") private WebElement passwordField;
    @FindBy(css="button.woocommerce-form-login__submit") private WebElement loginBtn;
    @FindBy(xpath = "//p[contains(text(), 'Hello')]") private WebElement text;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage username(String username){
        WebElement element= wait.until(ExpectedConditions.visibilityOf((WebElement) usernameField));
        element.clear();
        element.sendKeys(username);
        return this;
    }
    public LoginPage password(String password){
        WebElement element= wait.until(ExpectedConditions.visibilityOf((WebElement) passwordField));
        element.clear();
        element.sendKeys(password);
        return this;
    }
    public LoginPage login(){
        WebElement element=wait.until(ExpectedConditions.visibilityOf((WebElement) loginBtn));
        element.click();
        return this;
    }
    public String getText(){
        return wait.until(ExpectedConditions.visibilityOf((WebElement) text)).getText();
    }
}
