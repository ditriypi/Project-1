package tools.browser;

import org.openqa.selenium.WebDriver;

public enum DriverList{
    DEFAULTDRIVER(new DriverInstanceChrome()),
    FIERFOXDRIVER(new DriverInstanceFierfox()),
    CHROMEDRIVER(new DriverInstanceChrome()),
    CHROME_WITHOUT_UI(new DriverInstanceChromeWithoutUI());
    private Driver driver;


    DriverList(Driver type){this.driver = type; }

    public WebDriver getDriver() {   return driver.getDriver();  }
}