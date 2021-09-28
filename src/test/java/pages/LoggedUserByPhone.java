package pages;

import org.openqa.selenium.WebElement;

public class LoggedUserByPhone  extends  LoginPage{

    public    void initElements(){
        phoneNumberLogin = searchLocator.findByXpath("//p[@class='pb24 tc body2 color-gray'] ");
        sendCodAgain = searchLocator.findByXpath("//p[@class=\"tc body2\"] //a");
        choiceOtherNumber = searchLocator.findByXpath("//p[@class='tc pt24 body2']");

    }

    public WebElement getPhoneNumberLogin() {
        return phoneNumberLogin;
    }

    public WebElement getSendCodAgain() {
        return sendCodAgain;
    }

    public WebElement getChoiceOtherNumber() {
        return choiceOtherNumber;
    }

    //Locator
    WebElement phoneNumberLogin;
    WebElement sendCodAgain;
    WebElement choiceOtherNumber;

    //Page Object

    public  String getTextPhoneNumber(){
      return   getPhoneNumberLogin().getText();
    }
    public void clickOnChoiceOtherNumber(){
        getChoiceOtherNumber().click();
    }
    public void  clickOnSendCodAgain(){
        getSendCodAgain().click();
    }



}
