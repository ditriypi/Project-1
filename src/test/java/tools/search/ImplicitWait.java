package tools.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import tools.browser.BrowserChoice;


import java.util.List;
import java.util.concurrent.TimeUnit;
public class ImplicitWait extends Search {


   private Long TIME_PAUSE =  7L;

    public ImplicitWait() {
        BrowserChoice.getDriver().manage().timeouts().implicitlyWait(TIME_PAUSE, TimeUnit.SECONDS);
    }

    public WebElement findByXpath(String elem){
       return BrowserChoice.getDriver().findElement(By.xpath(elem));
    }

    @Override
    public WebElement findByCssSelector(String path) {
        return BrowserChoice.getDriver().findElement(By.cssSelector(path));
    }

    @Override
    public List<WebElement> findElementsByXpath(String path) {
      return   BrowserChoice.getDriver().findElements(By.xpath(path));
    }

    @Override
    public List<WebElement> findElementsByCss(String path) {
        return BrowserChoice.getDriver().findElements(By.cssSelector(path));
    }

    @Override
    public WebElement findElementById(String path) {
        return BrowserChoice.getDriver().findElement(By.id(path));
    }


    @Override
    public WebElement findElementByURL(String path) {
        return BrowserChoice.getDriver().findElement(By.partialLinkText(path));
    }

    @Override
    public void setTypeWaiting(ExpectedCondition ex) {
        System.out.println("Not support for this waiting type");

    }


}




