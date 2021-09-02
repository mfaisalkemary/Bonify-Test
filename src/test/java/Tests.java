import com.codeborne.selenide.Configuration;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.updateHash;

public class Tests {


HomePage homePage=new HomePage();
    TestData data=new TestData();
    JSONObject testDataJsonObject;

    @BeforeClass
    public void setup() throws Exception {
         testDataJsonObject=data.getTestDataFromJsonFile();
        Configuration.timeout=10000;
        Configuration.pageLoadTimeout=10000;
        Configuration.reportsFolder="test-results/reports";
        //ScreenShooter.captureSuccessfulTests = true;
        Configuration.browser="Chrome";

        Configuration.baseUrl="https://www.bonify.de";
        Configuration.startMaximized=true;
    }


    @Test
    public void testSearch(){
        homePage.search("bonify");

    }


   @Test
    public void viewTestData(){
       System.out.println(testDataJsonObject.get("searchQuery"));
   }
}
