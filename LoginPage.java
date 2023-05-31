package pages;

import java.time.Year;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    String baseURL = "https://www.saucedemo.com/";
    By usermaneBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorContainer = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public LoginPage login (String username, String password){
        writeText(usermaneBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;

    }

    public LoginPage verifyUnsucessfullLogin(String expectedText){
        String axtualText = readText(errorContainer);
        assertTextEquals(expectedText, axtualText);
        return this;

    }
    
}
