import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void removeThreadSleep() {

        String email = "demo@class.com";
        String password = "te$t$tudent";
        String searchSong = "test song not found";

        enterCredentials(email, password);
        clickLogin();
        searchSong(searchSong);
        WebElement searchResultText = driver.findElement(By.xpath(".//span[text()='Search Results for ']"));
        Assert.assertTrue(searchResultText.isDisplayed());

    }
}