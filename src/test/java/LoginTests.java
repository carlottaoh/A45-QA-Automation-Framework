
import org.testng.Assert;
import org.testng.annotations.Test;
import pageRefactory.HomePage;
import pageRefactory.LoginPage;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "getDataLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login w/ invalid password")
    public void invalidLogins(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterCredentials(username, password);
        loginPage.clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), baseURL);
    }

    @Test (enabled = true, priority = 1, description = "Login with valid credentials")
    public void validLoginCredentials() {
        String username = "demo@class.com";
        String password = "te$t$tudent";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.enterCredentials(username, password);
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.avatarDisplayed());
    }
}
