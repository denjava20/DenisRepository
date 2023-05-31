package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver){
        super(driver);
    }


    By homePageTitleBy = By.className("title");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By shoopingCartBadgeBy = By.className("shopping_cart_badge");
    By numberOfItems = By.className("inventory_item");
    By menuButtonBy = By.id("react-burger-menu-btn");
    By aboutButtonBy = By.id("about_sidebar_link");

    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifyProductAddedToCart(){
        click(addToCartButton1By);
        waitVisability(shoopingCartBadgeBy);
        return this;
    }
    
    public HomePage numberOfProducts( int expectedNumberOfProducts){
        int actualNumbersOfProducts = countItems(numberOfItems);
        assertIntegerEquals(expectedNumberOfProducts, actualNumbersOfProducts);
        return this;
    }

    public HomePage clickOnMenuButton(){
        click(menuButtonBy);
        return this;
    }
    public HomePage verifyAboutLink(String expectedLink){
        String actualLink = readLink(aboutButtonBy);
        assertTextEquals(expectedLink, actualLink);
        return this;
    }
    
}
