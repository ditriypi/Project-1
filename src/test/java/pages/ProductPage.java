package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import tools.Scroller;
import tools.browser.BrowserChoice;

public class ProductPage  extends HomePage{

    @Override
    protected void initElements() {

    }
    protected void initCatalogProduct(){
        productFromCatalog = searchLocator.findByXpath("//a[contains(@class,'link line-clamp-2 break-word link')]");
    }

    protected void initProduct() {
         product = searchLocator.findByXpath("//div[@class='product-card product-card--mini'] //div[@class='title-itm']");

    }
    protected void initByButtons(){
        buy = searchLocator.findByXpath("//button[contains(@class,'df jcc bd0 cup on aic uppercase medium df buyButton')]");
    }

    protected void initHideElements(){
        productTitle = searchLocator.findByXpath("//h1[contains(@class,'title')]");
        homeLogo = searchLocator.findByXpath("//img[@alt='Citrus Logo Image']");

    }
    protected void initExit(){
        close = searchLocator.findByXpath("//*[name()='path' and contains(@d,'M10.5858 1')]");
    }

    //Locator
    WebElement product;
    WebElement productTitle;
    WebElement productFromCatalog;
    WebElement buy;
    WebElement homeLogo;
    WebElement close;

    //Page Object

    private WebElement getProductFromCatalog() {
        return productFromCatalog;
    }

   private WebElement getClose(){
        initExit();
        return close; }

    private WebElement getProductTitle() {
        initHideElements();
        return productTitle;
    }
    private WebElement getProductTitleFormCatalog(){
        return searchLocator.findByXpath("//h1[contains(@class,'title')]");
    }
    private WebElement getHomeLogo(){
        initElements();
        return homeLogo;
    }
    private void clickOnCatalogProduct(){
        initCatalogProduct();
        getProductFromCatalog().click();
    }

    private WebElement getProduct() {
        return product;
    }

    private WebElement getBuy() {
        initByButtons();
        return buy;
    }

    private void clickOnHomeLogo(){
        getHomeLogo().click();
    }

    private void clickOnBuy(){
        getBuy().click();
    }

    private  void clickOnExit(){ getClose().click();}


    public String getTitleProduct(){
     return getProductTitle().getText();
    }


    public String getTitleProductFromCatalog(){
        return getProductTitleFormCatalog().getText();
    }

    //Business logic

    public HomePage addProductToBucket(){

        Dimension d = new Dimension(800,480);
        BrowserChoice.getDriver().manage().window().setSize(d);
        clickOnBuy();
        BrowserChoice.getDriver().manage().window().maximize();
       try {

            Thread.sleep(2434);
            clickOnExit();
        }catch (Exception r){}


        return new HomePage();
    }
    public ProductPage clickOnProductFromCatalog(){
        clickOnCatalogProduct();
        return new ProductPage();
    }

    public ProductPage clickOnProduct(){
        initProduct();
        getProduct().click();
        return  new ProductPage();

    };
}
