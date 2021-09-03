package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserDashBoardPage {
    SelenideElement userNameField=$(By.xpath("//*[@id=\"loginId\"]"));
    SelenideElement passwordField=$(By.xpath("//*[@id='password']"));
    SelenideElement submitButton=$(By.xpath("//*[@id='login-button']"));
    SelenideElement welcomeBankStatus=$(By.xpath("//*[@class='welcome-bank-status']"));
    private SelenideElement cookiesPopUp=$(By.xpath("//*[@id=\"accept-button\"]"));


    public String loginUser(String username,String password){
        open("https://my.bonify.de/");
        if (cookiesPopUp.is(Condition.visible)) {
            cookiesPopUp.click();
        }
        userNameField.setValue(username);
        passwordField.setValue(password);
        submitButton.click();

        //returninig the welcome message to be validated at Tests.class against a text coming from testData.json
        return welcomeBankStatus.shouldBe(Condition.visible).getText();
    }




}
