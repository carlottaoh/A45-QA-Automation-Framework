package pageRefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitButton;

    public LoginPage(WebDriver passedDriver) {super(passedDriver);}
    public LoginPage enterCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        click(submitButton);
        return this;
    }

}
