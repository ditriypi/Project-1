package tools;

import org.openqa.selenium.JavascriptExecutor;
import tools.browser.BrowserChoice;

public class Scroller {
    public static void ScrollPageDown(){
        JavascriptExecutor js = (JavascriptExecutor) BrowserChoice.getDriver();
        js.executeScript("window.scrollBy(0,500)");
    }
}
