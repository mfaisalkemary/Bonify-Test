
import apis.Search;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDashBoardPage;
import utils.TestData;

import java.io.IOException;


public class Tests {
HomePage homePage=new HomePage();
UserDashBoardPage userDashBoardScreen=new UserDashBoardPage();
    TestData data=new TestData();
    JSONObject testDataJsonObject;
    Search searchViaApi=new Search();


    @BeforeClass
    public void setup() throws Exception {
         testDataJsonObject=data.getTestDataFromJsonFile();
        Configuration.timeout=20000;
        Configuration.pageLoadTimeout=20000;
        Configuration.reportsFolder="test-results/reports/screenshots";
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.browser="Firefox";
        Configuration.headless=true;
        Configuration.baseUrl="https://www.bonify.de";
        Configuration.startMaximized=true;

    }

    @Test
    public void searchValidationViaAPI(){
        String searchKeyWord=(String) testDataJsonObject.get("searchQuery");
        org.testng.Assert.assertTrue(searchViaApi.searchViaApi(searchKeyWord).getStatusCode()==200);
    }

    @Test(priority = 1)
    public void searchValidationViaPage() throws IOException {
        String searchKeyWord=(String) testDataJsonObject.get("searchQuery");
        String searchResultValidation=(String) testDataJsonObject.get("firstSearchResultText");
        Assert.assertTrue(homePage.search(searchKeyWord).contains(searchResultValidation));
    }

   @Test(priority = 2)
    public void loginValidation(){
        String userName= (String) testDataJsonObject.get("userName");
        String password=(String) testDataJsonObject.get("password");
        String expxectedWelcomeMessage=(String) testDataJsonObject.get("expectedWelcomeMessageAfterLogin") ;
       Assert.assertTrue(userDashBoardScreen.loginUser(userName, password).contains(expxectedWelcomeMessage));
   }




    @AfterClass
    public void quiet(){
        Selenide.closeWindow();

    }
}
