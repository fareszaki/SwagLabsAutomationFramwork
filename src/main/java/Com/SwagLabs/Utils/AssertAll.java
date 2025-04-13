package Com.SwagLabs.Utils;

import org.testng.asserts.SoftAssert;

public class AssertAll {
    private AssertAll(){};
    private static final SoftAssert softAssert =new SoftAssert();
    public static void AssertAll(){
        try{
            softAssert.assertAll("All assertions Executed Successfully");
        }catch (Exception e){
            LogsUtils.error("All Assertions Failed" , e.getMessage());

        }
    }
}
