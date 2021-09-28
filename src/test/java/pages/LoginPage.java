package pages;


import User.User;
import User.UserBuilder;
import org.openqa.selenium.WebElement;


public class LoginPage extends HomePage {


    public LoginPage() {
    }

    @Override
    protected void initElements() {

        register  =  searchLocator.findByCssSelector("p.tc a.link");
        Continue  = searchLocator.findByXpath("//button[@type='submit']");
      //

    }
    //Locator
    private WebElement loginPhoneNumber;
    private WebElement Continue;
    private WebElement loginByEmail;
    private WebElement register;



//Page Object
    private WebElement getEmail(){
        return searchLocator.findByXpath("//input[@name='email']");
    }
    private WebElement getPassword(){
        return searchLocator.findByXpath("//input[@name=\"password\"]");
    }


    public WebElement getLoginPhoneNumber() {return searchLocator.findByXpath("//input[@name='phone']");}

    public WebElement getContinue() {
        initElements();
    return Continue;}


 public WebElement getLoginByEmail(){return
         searchLocator.findByXpath(
                 "//button[@type='button'][contains(@class ,'df jcc bd0 cup on aic uppercase medium mb')]");}


    public WebElement getRegister() {return register;}

   private void clickOnLoginByEmail(){
        getLoginByEmail().click();
   }
   private   void sendTextInLoginFormPhoneNumber(User user){
        getLoginPhoneNumber().sendKeys(user.getPhone());
    }
    private void sendTextInLoginFormByEmail(User user){
      getEmail().sendKeys(user.getEmail());

    }
    private  void sendPasswordInPasswordForm(User user){
        getPassword().sendKeys(user.getPassword());
    }
    public void clickOnContinueButton(){
        getContinue().click();

    }
//Business logic

    public LoggedUserByPhone getLoginByPhone(User user){
       sendTextInLoginFormPhoneNumber(user);
       clickOnContinueButton();
        return new LoggedUserByPhone();
    }

    public LoggedUserByEmail getLoginByEmail(User user){
         clickOnLoginByEmail();
        sendTextInLoginFormByEmail(user);
        clickOnContinueButton();
        sendPasswordInPasswordForm(user);
        clickOnContinueButton();
        return  new LoggedUserByEmail();
    }

}
