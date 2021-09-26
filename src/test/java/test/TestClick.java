package test;


import User.User;
import User.UserBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoggedUser;
import pages.LoginPage;
import test.TestRunner;

public class TestClick extends TestRunner {

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][]{{UserBuilder.createUser()}
        };
    }
    @Test(dataProvider = "dataSuccessful")
    public void loginTest(User user){

        HomePage homePage = loadApplication().goToLoginField();

        // LoginPage loginPage = loadApplication()

       // loginPage.getLoginByPhone(user);


    }
}
