import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public static void deletePlaylist() throws InterruptedException{

        String email = "demo@class.com";
        String password = "te$t$tudent";

        enterCredentials(email, password);
        clickLogin();

        WebElement eighthSong = driver.findElement(By.xpath(".//nav[@class='side side-nav showing']//li[@class='playlist playlist'][8]"));
        eighthSong.click();
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylist.click();

        WebElement confirmationPopup = driver.findElement(By.xpath(".//div[@class='alertify'][1]//p[text()='Delete the playlist \"Test Pro Edited Playlist\"?']"));
        Assert.assertTrue(confirmationPopup.isDisplayed());
        WebElement clickOK = driver.findElement(By.xpath(".//div[@class='alertify'][1]//button[@class='ok']"));
        clickOK.click();

        /* I manually tested and this is as far as I can go. I'm unable to check the confirmation notification
            because there are two confirmation popups and when I click OK or cancel, it's not possible to select the
            confirmation notification element to find a selector
         */

    }
}