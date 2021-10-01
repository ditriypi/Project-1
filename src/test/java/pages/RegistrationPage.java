package pages;

import User.User;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends LoginPage {

    @Override
    protected void initElements() {
      name = searchLocator.findByXpath("//input[@name='name']");
      phone = searchLocator.findByXpath("//input[@placeholder='+380']");
      email = searchLocator.findByXpath("//input[@name='email']");
      password = searchLocator.findByXpath("//input[@name='password']");


    }
    private LoggedUserByEmail loggedUserByEmail;


    //Locator
  private   WebElement name;
  private   WebElement phone;
  private   WebElement email;
  private   WebElement password;
  private   WebElement register;




//Page object
@Override
public WebElement getRegister() {
    return searchLocator.findByXpath("//span[contains(text(),'Зарегистрироваться')]");
}
   public void clickRegister(){
    getRegister().click();
   }

    public WebElement getPhone() {return phone;}

    public WebElement getEmail() {return email;}

    public WebElement getPassword() {return password;}

    public WebElement getName() {return name;}

    public String getUserName(){
    loggedUserByEmail = new LoggedUserByEmail();
   return loggedUserByEmail.getUserNameText();
    }

    private void sendInPhone(User user){
        getPhone().sendKeys(user.getPhone());
    }
    private void sendInEmail(User user){
        getEmail().sendKeys(user.getEmail());
    }
    private void sendInName(User user){
        getName().sendKeys(user.getUser());
    }
    private void sendInPassword(User user){
        getPassword().sendKeys(user.getPassword());
    }
    //Business logic
    public RegistrationPage registerNewUser(User user){
        sendInName(user);
        sendInEmail(user);
        sendInPhone(user);
        sendInPassword(user);
        clickRegister();
        return new RegistrationPage();
    }

}
