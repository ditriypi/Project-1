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

     @DataProvider
     public Object[][] productCatalog(){
         return new Object[][]{{"Samsung Galaxy S20"}};}
    @Test(dataProvider = "productCatalog")
    public void findProductByCatalog(String product) {
        HomePage homePage = loadApplication().searchProductFromCatalogField();

         ProductPage productPage  = homePage.clickOnCatalogPhone()
                 .clickOnProductFromCatalog();
         String productTitle = productPage.getTitleProductFromCatalog();
         Assert.assertTrue(productTitle.contains(product));

    }

    @Test(dataProvider = "productCatalog")
    public void addProductToBucket(String product){
        HomePage homePage = loadApplication().searchProductFromCatalogField();

        ProductPage productPage  = homePage.clickOnCatalogPhone()
                .clickOnProductFromCatalog();

        String productTitle = productPage.getTitleProductFromCatalog();
        System.out.println(productTitle);

        Assert.assertTrue(productTitle.contains(product));

         homePage = productPage.addProductToBucket();
         homePage.clickOnBucket();
        String productName = homePage.getBucketProductName();


        Assert.assertTrue(productName.contains(product));




    }
}

