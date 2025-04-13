package Com.SwagLabs.Pages;

import Com.SwagLabs.Utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutInformationPage {
    private final WebDriver driver;

    public checkoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By locateFirstName = By.cssSelector("input[id=\"first-name\"]");
    private final By locateLastName = By.cssSelector("input[id=\"last-name\"]");
    private final By locateZipCode = By.cssSelector("input[id=\"postal-code\"]");
    private final By locateCancelButton = By.cssSelector("a[href=\"./cart.html\"][class=\"cart_cancel_link btn_secondary\"]");
    private final By locateContinueCheckoutButton = By.cssSelector("input[type=\"submit\"][value=\"CONTINUE\"]");
    private final By locateErrorMessage = By.cssSelector("h3[data-test=\"error\"]");
    //Actions
    @Step("enter first name : {fName}")
    public checkoutInformationPage enterFirstName(String fName) {
        ElementActions.EnterDataOnField(driver, this.locateFirstName, fName);
        return this;
    }

    @Step("enter last name : {lName}")
    public checkoutInformationPage enterLastName(String lName) {
        ElementActions.EnterDataOnField(driver, this.locateLastName, lName);
        return this;
    }

    @Step("enter zip code : {zipCode}")
    public checkoutInformationPage enterZipCode(String zipCode) {
        ElementActions.EnterDataOnField(driver, this.locateZipCode, zipCode);
        return this;
    }
    @Step("Click on Continue Checkout Button")
    public ReviewPage clickOnContinueButton() {
        ElementActions.ClickOnElement(driver, this.locateContinueCheckoutButton);
         return new ReviewPage(driver);
    }
    @Step("Click on Cancel Button")
    public CartPage clickOnCancelButton() {
        ElementActions.ClickOnElement(driver, this.locateCancelButton);
        return new CartPage(driver);
    }
    // Validations
    public checkoutInformationPage assertErrorMessageForEmptyData() {
        ValidationUtils.validateEquals(ElementActions.GetElementText(this.locateErrorMessage, driver), "Error: First Name is required");
        return this;
    }
    public void assertSuccessfullyCheckout() {
        ValidationUtils.validateEquals(BrowserAction.GetPageURL(driver), propertiesUtils.getProperty("reviewOrderURL"));
    }

    public checkoutInformationPage assertInformationEntered(String fName , String lName , String zipCode){
        AssertAll.softAssert.assertEquals(ElementActions.getValueFromInput(driver , this.locateFirstName) , fName);
        AssertAll.softAssert.assertEquals(ElementActions.getValueFromInput(driver, this.locateLastName) , lName);
        AssertAll.softAssert.assertEquals(ElementActions.getValueFromInput(driver , this.locateZipCode) , zipCode);
        return  this;
    }



}
