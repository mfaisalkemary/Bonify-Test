package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserDashBoardScreen {
    SelenideElement loginButton=$(By.xpath("//*[@id=\"content-frame\"]/div/div[2]/nav/ul[2]/li[1]/a"));
    SelenideElement bonifyImage=$(By.xpath("/html/body/div[2]/div/div/header/div[1]/img"));
    SelenideElement userNameField=$(By.xpath("//*[@id=\"loginId\"]"));
    SelenideElement passwordField=$(By.xpath("//*[@id='password']"));
    SelenideElement submitButton=$(By.xpath("//*[@id='login-button']"));
    SelenideElement welcomeBankStatus=$(By.xpath("//*[@class='welcome-bank-status']"));
    private SelenideElement cookiesPopUp=$(By.xpath("//*[@id=\"accept-button\"]"));


    public String loginUser(String username,String password){
        open("https://my.bonify.de/");
       // cookiesPopUp.shouldBe(Condition.visible).click();
        //loginButton.click();
        cookiesPopUp.shouldBe(Condition.visible).click();
     //   bonifyImage.shouldBe(Condition.visible);
        userNameField.setValue(username);
        passwordField.setValue(password);
        submitButton.click();
        return welcomeBankStatus.shouldBe(Condition.visible).getText();

    }




}
