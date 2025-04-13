package Com.SwagLabs.Pages;

import Com.SwagLabs.Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class CartPage {
    // variables
    private final WebDriver driver;
    //Constructor

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By locateCheckOutButton = By.cssSelector("[href=\"./checkout-step-one.html\"]");
    private final By locateContinueShoppingButton = By.cssSelector("a[href=\"./inventory.html\"][class=\"btn_secondary\"]");
    private final  By locateProductName= By.cssSelector("[class=\"inventory_item_name\"]") ;

    private final By locateProductPrice =By.cssSelector("div[class=\"item_pricebar\"] [class=\"inventory_item_price\"]");
    // Method
    public CartPage deleteItemFromList(String name) {
        By locateItem = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + name + "']"));
        ElementActions.ClickOnElement(driver, locateItem);
        return this;
    }

    public CartPage clickOnCheckOutButton() {
        ElementActions.ClickOnElement(driver, this.locateCheckOutButton);
        return this;
    }

    public CartPage clickOnContinueShopping() {
        ElementActions.ClickOnElement(driver, this.locateContinueShoppingButton);
        return this;
    }

    public String getProductName() {
        return  ElementActions.GetElementText(this.locateProductName , driver) ;
    }

    public String getPrice(){
        return  ElementActions.GetElementText(this.locateProductPrice , driver) ;
    }

    public void deleteItemFromCart(String productName){
        By locateItem = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='"+  productName + "']")) ;
        ElementActions.ClickOnElement(driver , locateItem);
    }



}
