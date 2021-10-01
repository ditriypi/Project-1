package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import tools.browser.BrowserChoice;

public class OrderTest extends TestRunner {

    @DataProvider
    public Object[][] productName() {
        return new Object[][]{{"Apple iMac 21,5"}, {"Xiaomi 11T "}};
    }

    @Test(dataProvider = "productName")
    public void findProductFromSearchField(String product) {

        HomePage homePage = loadApplication();

        ProductPage productPage = homePage
               .searchProductFromSearchField(product).clickOnProduct();

        String productName = productPage.getTitleProduct();
        System.out.println(productName);
        Assert.assertTrue(productName.contains(product));

    }

    /* @DataProvider
     public Object[][] productCatalog(){
         return new Object[][]{{"Apple iMac 21,5"}};}*/
    @Test
    public void findProductByCatalog() {
        HomePage homePage = loadApplication().searchProductFromCatalogField("").clickOnCatalogPhone();


    }
    @Test
    public void product(){
        WebDriver driver =  BrowserChoice.getDriver();
        driver.get("https://www.citrus.ua/");
        driver.findElement
                (By.xpath("//form[contains(@class,'full-width full-height" +
                        " ovh df jcsb aic container')] //input")).click();
    }
}

