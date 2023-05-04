import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {

        String email = "demo@class.com";
        String password = "te$t$tudent";

        enterCredentials(email, password);
        clickLogin();

        editPlaylistName();
        editPlaylistBack();

    }
}