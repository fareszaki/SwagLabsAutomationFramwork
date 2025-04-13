package Com.SwagLabs.Utils;

import org.testng.asserts.SoftAssert;

public class AssertAll {
    private AssertAll(){};
    public static final SoftAssert softAssert =new SoftAssert();
    public static void assertAll(){
        try{
            softAssert.assertAll("All assertions Executed Successfully");
        }catch (Exception e){
            LogsUtils.error("All Assertions Failed" , e.getMessage());

        }
    }
}
