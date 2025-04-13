package Com.SwagLabs.Pages;

import Com.SwagLabs.Utils.AssertAll;
import Com.SwagLabs.Utils.ElementActions;
import Com.SwagLabs.Utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    @Step("delete item from cart : {name}")
    public CartPage deleteItemFromList(String name) {
        By locateItem = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + name + "']"));
        ElementActions.ClickOnElement(driver, locateItem);
        return this;
    }
    @Step("Click on CheckOut Button")
    public checkoutInformationPage clickOnCheckOutButton() {
        ElementActions.ClickOnElement(driver, this.locateCheckOutButton);
        return  new checkoutInformationPage(driver);
    }
    @Step("Click on Continue Shopping Button")
    public HomePage clickOnContinueShopping() {
        ElementActions.ClickOnElement(driver, this.locateContinueShoppingButton);
        return new HomePage(driver);
    }
    @Step("get product name")
    private String getProductName() {
        return  ElementActions.GetElementText(this.locateProductName , driver) ;
    }
    @Step("get product price")
    private String getPrice(){
        return  ElementActions.GetElementText(this.locateProductPrice , driver) ;
    }

    // Assertion
    @Step("assert product's details displayed correctly in cart page ")
    public CartPage assertItemDetails(String expectedName , String expectedPrice){
        LogsUtils.info("get Product's Name");
        String ActualName = getProductName();
        LogsUtils.info("get Product's Price");
        String ActualPrice = getPrice() ;
        LogsUtils.info("assert Actual Name :" + ActualName + "match Expected Name " + expectedName );
        AssertAll.softAssert.assertEquals(ActualName , expectedName);
        LogsUtils.info("assert Actual Price :" + ActualPrice + "match Expected Price " + expectedPrice );
        AssertAll.softAssert.assertEquals(ActualPrice , expectedPrice);
        return  this  ;
    }





}
