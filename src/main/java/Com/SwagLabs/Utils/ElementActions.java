package Com.SwagLabs.Utils;

import Com.SwagLabs.Driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {
    private ElementActions() {
    }

    ;

    public static WebElement ReturnWebElement(WebDriver driver, By Locator) {
        return driver.findElement(Locator);
    }

    public static String GetElementText(By Locator, WebDriver driver) {
        Waits.waitElementToBeClickable(driver , Locator) ;
        Scroll.scrollToElement(driver, Locator);
        LogsUtils.info("Getting the text of the element");
        return ElementActions.ReturnWebElement(driver, Locator).getText();
    }

    public static void EnterDataOnField(WebDriver driver, By Locator, String Data) {
        LogsUtils.info("Wait Element To Be Clickable" + " " + Locator.toString());
        Waits.waitElementToBeClickable(driver, Locator);
        LogsUtils.info("Scroll to the element" + " " + Locator.toString());
        Scroll.scrollToElement(driver, Locator);
        LogsUtils.info("Enter Data :"+" "+ Data + "  " + Locator.toString());
        ElementActions.ReturnWebElement(driver, Locator).sendKeys(Data);
    }

    public static void ClickOnElement(WebDriver driver, By Locator) {
        LogsUtils.info("Wait Element To Be Clickable" + " " + Locator.toString());
        Waits.waitElementToBeClickable(driver, Locator);
        LogsUtils.info("Scroll to the element" + " " + Locator.toString());
        Scroll.scrollToElement(driver, Locator);
        LogsUtils.info("Click on the element" + " " + Locator.toString());
        ElementActions.ReturnWebElement(driver, Locator).click();

    }

    public static void selectElementFromList(WebDriver driver, By Locator, String Name) {
        Waits.waitElementToBeClickable(driver, Locator);
        Scroll.scrollToElement(driver , Locator);
        ElementActions.ClickOnElement(driver , Locator);
        WebElement e = ReturnWebElement(driver, Locator) ;
        Select select = new Select(e);
        select.selectByVisibleText(Name);
    }
    public static String getValueFromInput(WebDriver driver , By locator){
        LogsUtils.info("wait Element to be clickable :"+ locator.toString());
        Waits.waitElementToBeClickable(driver , locator);
        LogsUtils.info("scroll to element : " + locator.toString());
        Scroll.scrollToElement(driver , locator);
        LogsUtils.info("Return value from : " +locator.toString() );
       return ReturnWebElement(driver, locator).getDomAttribute("value") ;
    }


}
