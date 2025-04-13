package Com.SwagLabs.Pages;

import Com.SwagLabs.Utils.ElementActions;
import Com.SwagLabs.Utils.LogsUtils;
import Com.SwagLabs.Utils.ValidationUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage {
    private final WebDriver driver ;

    public CompletePage(WebDriver driver){
        this.driver = driver ;
    }


    private final By locateMessage = By.cssSelector("div[class=\"subheader\"]");
     @Step("get Confirmation Message")
    private String getConfirmationMessage(){

         String text =ElementActions.GetElementText(this.locateMessage ,driver) ;
         LogsUtils.info("Element is : " +" "+ text);
         return  text ;

     }

    // Validate Confirm Message
    @Step("assert Confirmation Message correctly ")
    public void assertOrderCompleteCorrectly(String message){
         ValidationUtils.validateEquals(getConfirmationMessage(), message);
     }


}
