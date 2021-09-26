package pages;


import User.User;
import User.UserBuilder;
import org.openqa.selenium.WebElement;

public class LoginPage extends HomePage {





    @Override
    protected void initElements() {
        loginPhoneNumber = searchLocator.findByXpath("//input[@name='phone']");
        //Continue  = searchLocator.findByXpath(" //button[@type='submit'] //@class");
        loginByEmail = searchLocator.findByXpath("//button[@type='button'][contains(@class ,'df jcc bd0 cup on aic uppercase medium mb')]");
        register  =  searchLocator.findByCssSelector("p.tc a.link");

    }
    //Locator
    private WebElement loginPhoneNumber;
    private WebElement Continue;
    private WebElement loginByEmail;
    private WebElement register;


//Page Object

    public WebElement getLoginPhoneNumber() {return loginPhoneNumber;}

    public WebElement getContinue() {return Continue;}

    public WebElement getLoginByEmail(){return loginByEmail;}

    public WebElement getRegister() {return register;}

   private   void sendTextInLoginFormPhoneNumber(User user){
        getLoginPhoneNumber().sendKeys(user.getPhone());
    }
    public void clickOnContinueButton(){
        Continue  = searchLocator.findByXpath(" //button[@type='submit'] //@class");
        Continue.click();
    }
//Business logic

    public LoggedUser getLoginByPhone(User user){
       sendTextInLoginFormPhoneNumber(user);
       clickOnContinueButton();
        return new LoggedUser();
    }
    public LoginPage sayHi(){
        return new LoginPage();
    }

}
