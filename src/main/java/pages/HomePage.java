package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
private SelenideElement searchField= $(By.xpath("//*[@id=\"content-frame\"]/div/div[2]/nav/ul[1]/li[6]/a"));
private SelenideElement searchBar=$(By.xpath(".//*[@class='react-autosuggest__input']"));
private SelenideElement searchResults=$(By.xpath(".//*[@class='search__StyledResultsList-sc-1bms9wx-1 dacJbQ marked-content']"));
private SelenideElement cookiesPopUp=$(By.xpath(".//*[@class='Button__ButtonBase-sc-1660rwk-0 Button-sc-1660rwk-1 UserConsent__StyledButton-tctmop-10 fYNGYG required statistic personalized']"));
private SelenideElement searchButton=$(By.xpath(".//*[@type='submit']"));
    public void search(String searchQuery){
        open(Configuration.baseUrl);
        cookiesPopUp.shouldBe(Condition.visible).click();
        searchField.click();
        searchBar.shouldBe(Condition.visible).sendKeys(searchQuery);
        searchButton.click();
        searchResults.shouldBe(Condition.visible);
    }
}
