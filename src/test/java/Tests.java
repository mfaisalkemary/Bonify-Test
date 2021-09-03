import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.images.Eyes;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashBoardScreen;
import utils.TestData;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.updateHash;

public class Tests {

    Eyes eyes=new Eyes();

HomePage homePage=new HomePage();
UserDashBoardScreen userDashBoardScreen=new UserDashBoardScreen();
    TestData data=new TestData();
    JSONObject testDataJsonObject;


    @BeforeClass
    public void setup() throws Exception {
         testDataJsonObject=data.getTestDataFromJsonFile();
        Configuration.timeout=20000;
        Configuration.pageLoadTimeout=20000;
        Configuration.reportsFolder="test-results/reports/screenshots";
        //ScreenShooter.captureSuccessfulTests = true;
        Configuration.browser="Chrome";
        Configuration.baseUrl="https://www.bonify.de";
        Configuration.startMaximized=true;
    }


    @Test
    public void searchValidation() throws IOException {
        String searchKeyWord=(String) testDataJsonObject.get("searchQuery");
        String searchResultValidation=(String) testDataJsonObject.get("firstSearchResultText");
        Assert.assertTrue(homePage.search(searchKeyWord).contains(searchResultValidation));
    }

   @Test
    public void loginValidation(){
        String userName= (String) testDataJsonObject.get("userName");
        String password=(String) testDataJsonObject.get("password");
        String expxectedWelcomeMessage=(String) testDataJsonObject.get("expectedWelcomeMessageAfterLogin") ;
       Assert.assertTrue(userDashBoardScreen.loginUser(userName, password).contains(expxectedWelcomeMessage));
   }



    @AfterTest
    public void quiet(){
        Selenide.closeWindow();
    }
}
