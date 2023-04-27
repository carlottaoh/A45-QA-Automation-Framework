import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public static void playSong() throws InterruptedException{

        String email = "demo@class.com";
        String password = "te$t$tudent";

        openBaseURL();
        enterCredentials(email, password);
        clickLogin();
        WebElement avatar = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatar.isDisplayed());

        //play third song on Home
        WebElement thirdSong = driver.findElement(By.cssSelector("ol.top-song-list :nth-child(3) > article > span.cover"));
        thirdSong.click();
        //verify soundbar while song is playing
        WebElement soundBar = driver.findElement(By.cssSelector("div.bars"));
        Assert.assertTrue(soundBar.isDisplayed());
        //click play next song
        WebElement nextSongPlay = driver.findElement(By.cssSelector("div.side.player-controls > i.next.fa.fa-step-forward.control"));
        nextSongPlay.click();
        //verify next song title is playing
        WebElement secondSong = driver.findElement(By.xpath(".//h3[text()='Mid-Air Machine - If It_s All I Do']"));
        Assert.assertTrue(secondSong.isDisplayed());
        Assert.assertTrue(soundBar.isDisplayed());
        //click pause
        WebElement pauseSong = driver.findElement(By.cssSelector("div.side.player-controls > span :nth-child(2) > i.fa.fa-pause"));
        pauseSong.click();
        Assert.assertFalse(soundBar.isDisplayed());

    }
}