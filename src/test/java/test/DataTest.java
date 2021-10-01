package test;


import User.User;
import User.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class DataTest extends TestRunner {

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][]{{UserBuilder.existUser()}
        };
    }

    String PHONE_NUMBER_EXIST = "380664648120";
    @Test(dataProvider = "dataSuccessful")
    public void loginByPhoneTest(User user){

        HomePage homePage = loadApplication();
         LoginPage loginPage = homePage.goToLoginField();
         LoggedUserByPhone loggedUser = loginPage.getLoginByPhone(user);

         String number = loggedUser.getTextPhoneNumber();
        Assert.assertTrue(number.contains(PHONE_NUMBER_EXIST));

    }
    @Test(dataProvider = "dataSuccessful")
    public void loginByEmailTest(User user){
        HomePage homePage = loadApplication();
        LoginPage loginPage = homePage.goToLoginField();

        LoggedUserByEmail loggedUserByEmail = loginPage.getLoginByEmail(user);

        loggedUserByEmail.clickOnUser();
        String name =  loggedUserByEmail.getUserNameText();

        Assert.assertTrue(name.contains(user.getUser()));


    };
    @DataProvider
    public Object[][] dataRegister() {
        return new Object[][]{{UserBuilder.createUser()}
        };
    }

    @Test(dataProvider = "dataRegister")
    public void LoginTest(User user){

       HomePage homePage = loadApplication();

       LoginPage loginPage = homePage.goToLoginField();

        RegistrationPage registrationPage = loginPage.goToRegisterPage()
                .registerNewUser(user);
        String name = registrationPage.getUserName();
        Assert.assertTrue(name.contains(user.getUser()));

    }
}
