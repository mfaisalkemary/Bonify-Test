package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
private SelenideElement searchField= $(By.xpath("//*[@id=\"content-frame\"]/div/div[2]/nav/ul[1]/li[6]/a"));
private SelenideElement searchBar=$(By.xpath("/html/body/div[1]/div/div/div[3]/div/section/form/div/input"));
private SelenideElement searchResults=$(By.xpath(".//*[@class='search__StyledResultsList-sc-1bms9wx-1 dacJbQ marked-content']"));
private SelenideElement cookiesPopUp=$(By.xpath(".//*[@class='Button__ButtonBase-sc-1660rwk-0 Button-sc-1660rwk-1 UserConsent__StyledButton-tctmop-10 fYNGYG required statistic personalized']"));
private SelenideElement searchButton=$(By.xpath(".//*[@type='submit']"));
private SelenideElement firstSearchResultElement=$(By.xpath(".//*[@class='search__StyledResultsList-sc-1bms9wx-1 dacJbQ marked-content']//child::li[1]//a//h2"));
    public String search(String searchQuery) throws IOException {
        open(Configuration.baseUrl);
        //wait for the cookies pop up to show then close it
        cookiesPopUp.shouldBe(Condition.visible).click();
        searchField.click();
        searchBar.shouldBe(Condition.visible).sendKeys(searchQuery);
        searchButton.click();
        searchResults.shouldBe(Condition.visible);

        //returns the first search result text to be validated at the Tests.class with the validation text coming from  utils/testData.json
        return firstSearchResultElement.getText();

    }
}
