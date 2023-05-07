package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver passedDriver) {
        super(passedDriver);
    }

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public void enterCredentials (String email, String password){
        findElement(emailField).sendKeys(email);
        findElement(passwordField).sendKeys(password);
    }
    public void clickLogin () {
        findElement(submitButton).click();
    }
    public void login () {
        String email = "demo@class.com";
        String password = "te$t$tudent";

        enterCredentials(email, password);
        clickLogin();
    }

}
