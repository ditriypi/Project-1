package test;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import tools.browser.BrowserChoice;
import tools.browser.DriverList;


public abstract class TestRunner {
   final private   String URL =  "https://www.citrus.ua/";
   public HomePage loadApplication(){
       BrowserChoice.SetDriver(DriverList.CHROMEDRIVER);

       BrowserChoice.getDriver().manage().window().maximize();

       BrowserChoice.getDriver().get(URL);
       return new  HomePage();
   }




}
