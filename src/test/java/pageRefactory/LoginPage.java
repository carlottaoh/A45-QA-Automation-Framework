package pageRefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public LoginPage(WebDriver passedDriver) {super(passedDriver);}
    public LoginPage enterCredentials(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        click(submitButton);
        return this;
    }

}
