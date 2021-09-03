package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
private SelenideElement searchField= $(By.xpath("//*[@id=\"content-frame\"]/div/div[2]/nav/ul[1]/li[6]/a"));
private SelenideElement searchBar=$(By.xpath(".//*[@class='react-autosuggest__input']"));
private SelenideElement searchResults=$(By.xpath(".//*[@class='search__StyledResultsList-sc-1bms9wx-1 dacJbQ marked-content']"));
private SelenideElement cookiesPopUp=$(By.xpath(".//*[@class='Button__ButtonBase-sc-1660rwk-0 Button-sc-1660rwk-1 UserConsent__StyledButton-tctmop-10 fYNGYG required statistic personalized']"));
private SelenideElement searchButton=$(By.xpath(".//*[@type='submit']"));
private SelenideElement firstSearchResultElement=$(By.xpath(".//*[@class='search__StyledResultsList-sc-1bms9wx-1 dacJbQ marked-content']//child::li[1]//a//h2"));
    public String search(String searchQuery) throws IOException {


        //Eyes eyes=new Eyes();
        //eyes.setApiKey("CVrvhify65wPA110sOk5zUbN79QAxK3hfs8VjBgUGDhEw110");
        //eyes.open(Configuration.browser,"bonify",new RectangleSize(800, 600));
        //eyes.setHostOS("Windows10");
        //BufferedImage img= ImageIO.read(new File("test-results/reports/baseScreenshots/searchResults.jpg"));
        open(Configuration.baseUrl);
        if(cookiesPopUp.is(Condition.visible)){
            cookiesPopUp.click();
        }
        //cookiesPopUp.shouldBe(Condition.visible).click();
        searchField.click();
        searchBar.shouldBe(Condition.visible).sendKeys(searchQuery);
        searchButton.click();
        searchResults.shouldBe(Condition.visible);

        //eyes.check("visual validation for bonify", Target.image(img));
        //eyes.checkImage(img);
       // screenshot("searchResults");

       // return searchResults.is(Condition.visible);
        return firstSearchResultElement.getText();

    }
}
