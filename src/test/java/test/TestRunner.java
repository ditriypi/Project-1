package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import tools.browser.BrowserChoice;
import tools.browser.DriverList;
import tools.search.SearchStrategy;


public abstract class TestRunner {
   final private   String URL =  "https://www.citrus.ua/";
   WebDriver driver;
   public HomePage loadApplication(){
       BrowserChoice.SetDriver(DriverList.CHROMEDRIVER);

       BrowserChoice.getDriver().manage().window().maximize();

       BrowserChoice.getDriver().get(URL);
       return new  HomePage();
   }
   @AfterClass(alwaysRun = true)
    private void  tearDown(){
       BrowserChoice.quit();

   }

   @BeforeMethod(alwaysRun = true)
    public void setStrategy(){
       SearchStrategy.setExplicitStrategy();
   }




}
