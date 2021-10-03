package tools.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

interface Driver{
    WebDriver getDriver();
}
public class BrowserChoice  {
    private static WebDriver driver ;
    public static void SetDriver(DriverList Driver){

       driver  = Driver.getDriver();

    }

    public static WebDriver getDriver() {
        if(driver == null)  {  return DriverList.DEFAULTDRIVER.getDriver();}

        else
            return driver;
    }

    public static void quit(){
     if(driver != null) {
         driver.quit();
     }
        System.out.println("Driver quit");
    }
}




 class DriverInstanceChrome implements Driver {

    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
 class DriverInstanceFierfox implements Driver{

     public  WebDriver getDriver(){
         WebDriverManager.firefoxdriver().setup();
         return  new org.openqa.selenium.firefox.FirefoxDriver();
     }


 }
class DriverInstanceChromeWithoutUI implements Driver{

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--ignore-certificate-errors");
        return  new ChromeDriver(chromeOptions);

    }

 }
