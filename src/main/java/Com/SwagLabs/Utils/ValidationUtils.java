package Com.SwagLabs.Utils;

import Com.SwagLabs.Driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValidationUtils {
    private ValidationUtils() {};
    @Step("asserting the login successfully By comparing the page URL")
    public static void AssertLoginSuccessfully() {
        Assert.assertEquals(BrowserAction.GetPageURL(DriverManager.getDriver()), propertiesUtils.getProperty("homeURL"));
    }
  @Step("asserting the userName required field")
    public static void AssertUserNameRequired(WebDriver driver, By locators) {
        Assert.assertTrue(ElementActions.GetElementText(locators, driver).contains(propertiesUtils.getProperty("userNameRequiredFields")));
    }
    @Step("asserting the password required field")

    public static void AssertPasswordValueRequired(WebDriver driver , By locator){
        Assert.assertTrue(ElementActions.GetElementText(locator ,driver).contains(propertiesUtils.getProperty("passwordRequiredFields")));
    }
    @Step("asserting the error message for invalid credentials")
    public static void AssertLoginWithInvalidCredentials(WebDriver driver , By locator){
          Assert.assertTrue(ElementActions.GetElementText(locator,driver).contains(propertiesUtils.getProperty("userNameInvalidOrPassword")));
    }


    @Step("Assert cart has ")
    public static void assertItemAddedToCartCorrectly(WebDriver driver , By locator   , String numOfProduct ){
        Assert.assertEquals(ElementActions.GetElementText(locator ,driver) , numOfProduct);

    }

    public static void validateEquals(String actual , String Expected) {
         Assert.assertEquals(actual , Expected);
    }
    public static void notValidateEquals(String actual , String Expected) {
        Assert.assertNotEquals(actual , Expected);
    }

}
