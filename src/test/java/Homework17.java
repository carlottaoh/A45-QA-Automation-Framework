import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public static void addSongToPlaylist() throws InterruptedException{
        String email = "demo@class.com";
        String password = "te$t$tudent";
        String searchForSong = "Waiting on a train";
        String playlistName = "Carlotta's Playlist";

        openBaseURL();
        enterCredentials(email, password);
        clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/#!/home");
        searchSong(searchForSong);
        viewAllSongs();

        WebElement selectFirstSong = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//table[@class='items']/tr[1]"));
        selectFirstSong.click();
        addSongNewList(playlistName);

        WebElement successMessage = driver.findElement(By.cssSelector(".success.show"));
        Assert.assertTrue(successMessage.isDisplayed());
        Thread.sleep(2000);

    }
}