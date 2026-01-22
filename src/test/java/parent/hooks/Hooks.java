package parent.hooks;

import io.cucumber.java.After;
import parent.factory.DriverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    @Before
    public void before() throws IllegalAccessException {
        driver=new DriverFactory().initializeDriver(System.getProperty("browser", "chrome"));
    }

//    @After
//    public void after(){
//        driver.quit();
//    }
}
