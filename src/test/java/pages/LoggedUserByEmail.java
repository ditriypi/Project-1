package pages;


import org.openqa.selenium.WebElement;



public class LoggedUserByEmail extends LoginPage {

  public void   initElements(){


      userName = searchLocator.findByXpath("//div[contains(@class,'tl text-ellipsis autorizeText-0-2-')]");


  }
  public void   initProfileParameter() throws Exception {
      if (getUserNameText() != null) {
          initElements();
          clickOnUser();
          myOrder = searchLocator.findByXpath("//a[contains(text(),'Мои заказы')]");
          wishList = searchLocator.findByXpath("//a[contains(text(),'Мои желания')]");
          logout = searchLocator.findByXpath("//a[contains(text(),'Выйти')]");
          searchLocator.findByXpath("//a[contains(text(),'Профиль')]");
      }
      else  throw new Exception("Exception: name == 0!");;
  }




    private  WebElement  myOrder ;//a[contains(text(),'Мои заказы')]
    private  WebElement  userName;
    private  WebElement wishList;//a[contains(text(),'Мои желания')]
    private  WebElement logout;//a[contains(text(),'Выйти')]

  //Page object
    private WebElement getUserName() {
        initElements();
        return userName;
    }
    private WebElement getMyOrder() {
        initElements();
        return myOrder;
    }

    private WebElement getWishList() {
        initElements();
        return wishList;
    }

    private WebElement getLogout() {
        initElements();
        return logout;
    }

    private void clickOnWishList(){
        getWishList().click();
    }
    private void clickOnLogout(){
        getLogout().click();
    }
    private void clickOnMyOrder(){
        getMyOrder().click();
    }



    public  void clickOnUser(){
        getUserName().click();
    }
    public String getUserNameText(){
      return   getUserName().getText();
    }
}
