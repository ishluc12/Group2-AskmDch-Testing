package parent.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
//    private static StorePage storagePage;
    private static LoginPage loginPage;
//    private  static CartPage cartPage;


//    public static StorePage getStoragePage(WebDriver driver){
//        return storagePage==null? new StorePage(driver): storagePage;
//    }
    public static LoginPage getLoginPage(WebDriver driver){
        return loginPage==null? new LoginPage(driver): loginPage;
    }
//    public static CartPage getCartPage(WebDriver driver){
//        return cartPage==null? new CartPage(driver): cartPage;
//    }
}

