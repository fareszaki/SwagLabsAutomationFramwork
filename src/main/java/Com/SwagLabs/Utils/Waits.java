package Com.SwagLabs.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private Waits(){} ;


    public static WebElement waitElementToBePresent(WebDriver driver  , By locator){
        return new WebDriverWait(driver , Duration.ofSeconds(5)).until(
                driver1->
                        ElementActions.ReturnWebElement(driver ,locator)
);

    }

    public static WebElement waitElementToBevisible(WebDriver driver , By locator){
        WebDriverWait driverWait = new WebDriverWait(driver , Duration.ofSeconds(5));
       return driverWait.until(driver1 -> {
               WebElement e  = waitElementToBePresent(driver , locator);
               return e.isDisplayed() ? e : null ;
        });
    }


    public static WebElement waitElementToBeClickable(WebDriver driver , By  locator) {
        WebDriverWait driverWait = new WebDriverWait(driver , Duration.ofSeconds(5));
        return driverWait.until(driver1 -> {
              WebElement element=waitElementToBevisible(driver ,locator);
              return element.isEnabled() ? element : null ;

        });

    }


}
