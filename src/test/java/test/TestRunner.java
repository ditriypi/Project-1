package test;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import tools.browser.BrowserChoice;
import tools.browser.DriverList;


public abstract class TestRunner {
   final private   String URL =  "https://www.citrus.ua/";
private  static WebDriver driver;
   public HomePage loadApplication(){
       BrowserChoice.SetDriver(DriverList.CHROMEDRIVER);
       driver = BrowserChoice.getDriver();
       driver.get(URL);
      // BrowserChoice.getDriver().get(URL);
       return new  HomePage();
   }




}
