package parent.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import parent.factory.DriverFactory;

public class Hooks {

    private WebDriver driver;

    @Before
    public void before() throws IllegalAccessException {
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
