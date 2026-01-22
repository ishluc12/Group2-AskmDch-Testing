package parent.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import parent.constants.EndPoint;

import java.time.Duration;

public class AccountPage extends BasePage {

//    fields for login form

    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = "button[value='Log in']")
    private WebElement loginButton;
    @FindBy(css = "div.woocommerce-MyAccount-content p strong")
    private WebElement welcomeUsername;
    @FindBy(css = "ul.woocommerce-error li")
    private WebElement errorMessage;

// fields for registration form

    @FindBy(id = "reg_username")
    private WebElement username_regField;
    @FindBy(id = "reg_email")
    private WebElement email_regField;
    @FindBy(id = "reg_password")
    private WebElement password_regField;
    @FindBy(css = "button[name='register']")
    private WebElement registerButton;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openAccountPage() throws IllegalAccessException {
        load(EndPoint.ACCOUNT.url);
    }

    //registration method
    public void registerUsername(String username) {
        username_regField.sendKeys(username);
    }

    public void registerEmail(String email) {
        email_regField.sendKeys(email);
    }

    public void registerPassword(String password) {
        password_regField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void settingAllRegFields(String username, String email, String password) {
        registerUsername(username);
        registerEmail(email);
        registerPassword(password);
    }

//   Login methods

    public void fillUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void settingAllLoginFields(String username, String password) {
        fillPassword(password);
        fillUsername(username);
        clickLoginButton();
    }

    public String isWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(welcomeUsername));
        return msg.getText().trim();
    }

    public String isErrorMessage() {
        try {
            return driver.findElement(By.cssSelector("ul.woocommerce-error li")).getText().trim();
        } catch (NoSuchElementException e) {
            return driver.findElement(By.cssSelector(".woocommerce-error")).getText().trim();
        }
    }


}
