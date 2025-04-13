package Com.SwagLabs.Pages;

import Com.SwagLabs.Utils.ElementActions;
import Com.SwagLabs.Utils.ValidationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewPage {
    private final WebDriver driver ;

    public ReviewPage(WebDriver driver){
        this.driver = driver ;
    }

    // Locators
    private final By locateFinishButton = By.cssSelector("[href=\"./checkout-complete.html\"]");
    private final By locateCancelButton = By.cssSelector("a[class=\"cart_cancel_link btn_secondary\"]") ;
    private final By productName= By.cssSelector("[class=\"inventory_item_name\"]");
     private final By productPrice = By.cssSelector("[class=\"inventory_item_price\"]");
    // Method
   public CompletePage clickOnFinishButton(){
       ElementActions.ClickOnElement(driver , this.locateFinishButton);
       return  new CompletePage(driver) ;
   }
   public HomePage clickOnCancelButton(){
       ElementActions.ClickOnElement(driver, this.locateCancelButton);
       return  new HomePage(driver) ;
   }
    // Assertion
    public ReviewPage validateAllDataAreCorrectly(String productName , String productPrice){
        ValidationUtils.validateEquals(ElementActions.GetElementText( this.productName , driver) ,productName );
         ValidationUtils.validateEquals(ElementActions.GetElementText(this.productPrice , driver) , productPrice);
        return this ;
   }




}
