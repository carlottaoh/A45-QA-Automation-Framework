
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test (dataProvider = "getDataLoginData", dataProviderClass = BaseTest.class, enabled = true, priority = 0, description = "Login w/ invalid password")
    public void invalidLoginsTest(String username, String password) {
        enterCredentials(username, password);
        clickLogin();
    }

    @Test
    public static void LoginEmptyEmailPasswordTest() {

        String url = "https://bbbtestpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
