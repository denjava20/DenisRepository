package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class ShoppingTest extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    int numberOfAllItems = 6;
    String expectedAboutLink = "https://saucelabs.com/";

    @Test
    public void verifySuccessfulAddToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifyProductAddedToCart();
        homePage.verifySuccesfulLogin(homePageTitle);
       
    }

    @Test
    public void numberOfItemsHomePage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.numberOfProducts(numberOfAllItems);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
}

    @Test
    public void verifyAboutLink(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.clickOnMenuButton();
        homePage.verifyAboutLink(expectedAboutLink);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
   
