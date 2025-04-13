package Com.SwagLabs.Pages;

import Com.SwagLabs.Utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.NoSuchElementException;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By locateDropList = By.cssSelector("select[class=\"product_sort_container\"]");
    private final By locateCartButton = By.cssSelector("a[href=\"./cart.html\"]");
    private final By locateNumOfItem = By.xpath("//a[@href=\"./cart.html\"]//../span");


    //Navigate
    @Step("Navigate To Home Page")
    public HomePage navigateToHomePage() {
        BrowserAction.NavigateToPage(driver, propertiesUtils.getProperty("homeURL"));
        return this;
    }


    // Actions On Method
    @Step("Added product To Cart : {productName}")
    public HomePage addProductToCart(String productName) {
        LogsUtils.info("Adding" +" "+ productName + "to cart ");
        By locateProduct = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + productName + "']"));
        ElementActions.ClickOnElement(driver, locateProduct);
        LogsUtils.info("Product name :" + productName + " " + "Added Correctly To Cart");
        return this;
    }

    @Step("Sorted Products : {Name}")
    public HomePage sortListUsingName(String Name) {
        ElementActions.selectElementFromList(driver, this.locateDropList, Name);
        return this;
    }

    @Step("Click on Cart Button ")
    public CartPage clickOnCartButton() {
        ElementActions.ClickOnElement(driver, this.locateCartButton);
        return new CartPage(driver);
    }
    @Step("Click on Drop List")
    public HomePage presenceOfElement() {
        Waits.waitElementToBePresent(driver, this.locateDropList);
        return this;
    }


    // Validations
    @Step("Assert total num of products Added to cart True ")
    public void assertProductsAddedCorrectlyToCart(String num) {
        FluentWait wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).withMessage("Fail To Find Element ");
        wait.until(driver1 ->
        {
            WebElement e = ElementActions.ReturnWebElement(driver, this.locateNumOfItem);
            ValidationUtils.assertItemAddedToCartCorrectly(driver, this.locateNumOfItem, num);
            return driver1;
        });
    }
   @Step("Assert total num of products Added to cart Correctly")
    public void assertAddedProductCorrectly(String ProductName , String ExpectedResult) {
        By locateProduct = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='" + ProductName + "']"));
        String Actual = ElementActions.GetElementText(locateProduct, driver);
        ValidationUtils.validateEquals(Actual, ExpectedResult);
         LogsUtils.info("product :" + ProductName + " " + "Added Correctly To Cart ");

    }
    @Step("assert User Navigate to cart page")
    public void assertNavigateToCartPage(String CartURL){
        ValidationUtils.validateEquals(BrowserAction.GetPageURL(driver) ,CartURL );

    }


}
