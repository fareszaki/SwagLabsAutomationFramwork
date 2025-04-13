package Com.SwagLabs.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {
    private Scroll(){} ;

    public static void scrollToElement(WebDriver driver , By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].scrollIntoView(true);" , ElementActions.ReturnWebElement(driver ,locator));

    }
}
