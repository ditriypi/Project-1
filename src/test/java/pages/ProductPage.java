package pages;

import org.openqa.selenium.WebElement;

public class ProductPage  extends HomePage{

    @Override
    protected void initElements() {
        product = searchLocator.findByXpath("//div[@class='product-card product-card--mini'] //div[@class='title-itm']");
    }

    protected void initHideElements(){
        productTitle = searchLocator.findByXpath("//h1[contains(@class,'title')]");

    }

    //Locator
    WebElement product;
    WebElement productTitle;
  //  WebElement

    //Page Object

    private WebElement getProductTitle() {
        initHideElements();
        return productTitle;
    }

    private WebElement getProduct() {
        return product;
    }
    public String getTitleProduct(){
     return getProductTitle().getText();
    }


    public ProductPage clickOnProduct(){
        initElements();
        getProduct().click();
        return  new ProductPage();

    };
}
