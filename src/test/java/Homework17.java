import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        String email = "demo@class.com";
        String password = "te$t$tudent";
        String searchForSong = "Waiting on a train";
        String playlistName = "Carlotta's Playlist";

        enterCredentials(email, password);
        clickLogin();
        searchSong(searchForSong);
        viewAllSongs();

        WebElement selectFirstSong = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//table[@class='items']/tr[1]"));
        WebElement selectElement = wait.until(ExpectedConditions.elementToBeClickable(selectFirstSong));
        selectElement.click();
        addSongNewList(playlistName);

        WebElement successMessage = driver.findElement(By.cssSelector(".success.show"));
        WebElement successElement = wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successElement.isDisplayed());

    }
}