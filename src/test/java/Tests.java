import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class Tests {


HomePage homePage=new HomePage();


    @BeforeClass
    public void setup() throws Exception {
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
}
