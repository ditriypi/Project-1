package pages;



import org.openqa.selenium.Keys;
import tools.search.Search;
import tools.search.SearchStrategy;
import org.openqa.selenium.WebElement;

public abstract class TopPart {
     Search searchLocator =   SearchStrategy.setExplicitStrategy();
   // Search search  =  SearchStrategy.getSearch();

    TopPart(){
        initElements();
    }


    protected  void initElements(){

        singIn = searchLocator.findByXpath("//button[contains(@class,'dn account-0-2-13')]");

        search = searchLocator.findByXpath("//form[contains(@class,'full-width full-height ovh df jcsb aic container')] //input");

        compareItems = searchLocator.findByXpath("//a[@class='dn aic jcc compare-0-2-14']//div[@class='pr']//*[name()='svg']");

       basket = searchLocator.findByXpath("//div[@class='dib df basket-0-2-11'] //button");
       wishList = searchLocator.findByXpath("//a[@class='dn aic jcc wishlist-0-2-15']");
       language = searchLocator.findByXpath("//div[contains(@class,'languages')]");
       catalog = searchLocator.findByXpath("//button[contains(@class, 'dn aic jcfs cup on bd0 catalog')]");

    };

    private WebElement initHideElements(){
     return    searchLocator.findByXpath
                ("//input[contains(@class,'full-height on bd0 pr16 pl16 input')]");
    }
    private void initCatalogElements(){
        catalogPhone = searchLocator.findByXpath("//a[@href='/smartfony/']//div[@class='df aic'][normalize-space()='']");
    }
    private void initBucketTotal(){
        bucketTotal = searchLocator.findByXpath("//a[@class='link line-clamp-1']");
    }
    //Locators

    private WebElement singIn;
    private WebElement search;
    private WebElement compareItems;
    private WebElement basket;
    private WebElement wishList;
    private WebElement language;
    private WebElement catalog;
    private WebElement searchInput;
    private WebElement catalogPhone;
    private WebElement smartWatch;
    private WebElement bucketTotal;
    // Page Object
    private WebElement getBucketTotal(){
        initBucketTotal();
        return bucketTotal;
    }
    private WebElement getCatalogPhone(){return catalogPhone;}

    private WebElement getSingIn() {return singIn;}

    private WebElement getSearch() {return search;}

    private WebElement getCompareItems() {return compareItems;}

    private WebElement getBasket() {return basket;}

    private WebElement getWishList() {return wishList;}

    private WebElement getLanguage() {return language;}

    private WebElement getCatalog() {return catalog;}

    private void clickOnSingIn(){
        getSingIn().click();
    }

    private void sendTextInSearchField(String text){
        initElements();
        getSearch().click();
        initHideElements().sendKeys(text);
    }
    public void clickOnBucket(){
        initElements();
        getBasket().click();
    }
    public void clickOnCompare(){
        initElements();
        getCompareItems().click();
    }
    public String getBucketContain(){
        initElements();

        return null;
    }

    private void searchProduct(){
        initElements();
        initHideElements().sendKeys(Keys.ENTER);
        //getSearch().sendKeys(Keys.ENTER);
    }
    public void clickOnCatalog(){
        initElements();
        getCatalog().click();
    }

    public String getBucketProductName(){
      return   getBucketTotal().getText();
    }


    //Business logic

   public LoginPage goToLoginField(){
       clickOnSingIn();

       return new LoginPage();
   }

   public  ProductPage searchProductFromSearchField(String text){
       sendTextInSearchField(text);
         searchProduct();

        return new ProductPage();
   }
   public ProductPage searchProductFromCatalogField(){
       clickOnCatalog();

        return new ProductPage();
   }
    public ProductPage clickOnCatalogPhone(){
        initCatalogElements();
        getCatalogPhone().click();
        return  new ProductPage();
    }

}
