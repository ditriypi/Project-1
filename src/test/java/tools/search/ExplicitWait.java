package tools.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.browser.BrowserChoice;

import java.util.List;

public class ExplicitWait extends Search {
  private final WebDriverWait wait = new WebDriverWait(BrowserChoice.getDriver(),7);

  private ExpectedCondition condition;

    @Override
    public WebElement findByXpath(String path) {
        System.out.println("Privet");
       return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));

    }


    @Override
    public WebElement findByCssSelector(String path) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(path)));

    }

    @Override
    public List<WebElement> findElementsByXpath(String path) {
         return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
    }

    @Override
    public List<WebElement> findElementsByCss(String path) {
        return  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(path)));
    }

    @Override
    public WebElement findElementById(String path) {
        return  wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));

    }

    @Override
    public WebElement findElementByURL(String path) {

        return wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(path)));
    }

    public void setTypeWaiting(ExpectedCondition ex){condition = ex;}

    public  WebElement returnOwnSearchWait (){
        return (WebElement) wait.until(condition);
    }



}
