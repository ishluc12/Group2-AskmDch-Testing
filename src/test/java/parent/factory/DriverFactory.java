package parent.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver initializeDriver(String browser) throws IllegalAccessException {

        switch(browser){
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
                driver=new FirefoxDriver();
            }
            default -> throw new IllegalAccessException("Invalid bowser:" + browser);
        }
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
