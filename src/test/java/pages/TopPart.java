package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        search = searchLocator.findByXpath("//form[@class='full-width full-height ovh df jcsb aic container-0-2-60']");

        compareItems = searchLocator.findByXpath("//button[@class='pr cup bd0 on aic jcc action-0-2-74']");

       basket = searchLocator.findByXpath("//button[@class='pr cup bd0 on aic jcc action-0-2-74 disable-0-2-76']");
       wishList = searchLocator.findByXpath("//a[@class='dn aic jcc wishlist-0-2-15']");
       language = searchLocator.findByXpath("//div[@class='languages-0-2-40'] //a");
       catalog = searchLocator.findByXpath("//button[@class='dn aic jcfs cup on bd0 catalog-0-2-46']");

    };
    //Locators

    private WebElement singIn;
    private WebElement search;
    private WebElement compareItems;
    private WebElement basket;
    private WebElement wishList;
    private WebElement language;
    private WebElement catalog;
    // Page Object

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



    //Business logic


   public LoginPage goToLoginField(){
       clickOnSingIn();
       return new LoginPage();
      //return new HomePage();
   }

}
