package tools.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public abstract class Search  {


    public abstract WebElement findByXpath(String path);

    public abstract WebElement findByCssSelector(String path);

    public abstract List<WebElement> findElementsByXpath(String path);

    public abstract List<WebElement> findElementsByCss(String path);

    public abstract WebElement findElementById(String path);

    public abstract WebElement findElementByURL(String path);

    public void setTypeWaiting(ExpectedCondition ex){};

    public WebElement returnOwnSearchWait(){return null;}









}
